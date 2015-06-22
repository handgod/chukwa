/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.chukwa.dataloader;

import junit.framework.TestCase;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.chukwa.ChunkImpl;
import org.apache.hadoop.chukwa.Chunk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;

import org.apache.hadoop.chukwa.datacollection.collector.CaptureWriter;
import org.apache.hadoop.chukwa.datacollection.writer.PipelineStageWriter;
import org.apache.hadoop.chukwa.datacollection.writer.SocketTeeWriter;
import org.apache.hadoop.chukwa.rest.bean.ClientTraceBean;

import java.net.*;
import java.io.*;

public class TestSocketDataLoader  extends TestCase{
  public void testSocketTee() throws Exception {
    
    Configuration conf = new Configuration();  
    
    conf.set("chukwa.pipeline",
        SocketTeeWriter.class.getCanonicalName());
    
    conf.set("chukwa.writerClass", 
        PipelineStageWriter.class.getCanonicalName());
    
    PipelineStageWriter psw = new PipelineStageWriter(conf);

    SocketDataLoader sdl = new SocketDataLoader("all");
    
    System.out.println("pipeline established; now pushing a chunk");
    ArrayList<Chunk> l = new ArrayList<Chunk>();
    l.add(new ChunkImpl("dt", "name", 1, new byte[] {'a'}, null));
    psw.add(l);
    //push a chunk through. SocketDataLoader should receive this chunk.
    
    try {
      Collection<Chunk> clist = sdl.read();
      for(Chunk c : clist) {
        if(c!=null && c.getData()!=null) {
          assertTrue("a".equals(new String(c.getData())));
        }
      }
    } catch(NoSuchElementException e) {
    }
  }
  
}
