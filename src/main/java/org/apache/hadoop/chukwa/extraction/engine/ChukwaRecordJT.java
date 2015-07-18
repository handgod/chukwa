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

// File generated by hadoop record compiler. Do not edit.
package org.apache.hadoop.chukwa.extraction.engine;

import java.io.Serializable;


public class ChukwaRecordJT extends org.apache.hadoop.record.Record implements Serializable {
  private static final long serialVersionUID = 15015L;
  private static final org.apache.hadoop.record.meta.RecordTypeInfo _rio_recTypeInfo;
  private static org.apache.hadoop.record.meta.RecordTypeInfo _rio_rtiFilter;
  private static int[] _rio_rtiFilterFields;
  static {
    _rio_recTypeInfo = new org.apache.hadoop.record.meta.RecordTypeInfo(
        "ChukwaRecordJT");
    _rio_recTypeInfo.addField("time",
        org.apache.hadoop.record.meta.TypeID.LongTypeID);
    _rio_recTypeInfo.addField("mapFields",
        new org.apache.hadoop.record.meta.MapTypeID(
            org.apache.hadoop.record.meta.TypeID.StringTypeID,
            org.apache.hadoop.record.meta.TypeID.BufferTypeID));
  }

  protected long time;
  protected java.util.TreeMap<String, org.apache.hadoop.record.Buffer> mapFields;

  public ChukwaRecordJT() {
  }

  public ChukwaRecordJT(
                        final long time,
                        final java.util.TreeMap<String, org.apache.hadoop.record.Buffer> mapFields) {
    this.time = time;
    this.mapFields = mapFields;
  }

  public static org.apache.hadoop.record.meta.RecordTypeInfo getTypeInfo() {
    return _rio_recTypeInfo;
  }

  public static void setTypeFilter(
      org.apache.hadoop.record.meta.RecordTypeInfo rti) {
    if (null == rti)
      return;
    _rio_rtiFilter = rti;
    _rio_rtiFilterFields = null;
  }

  private static void setupRtiFields() {
    if (null == _rio_rtiFilter)
      return;
    // we may already have done this
    if (null != _rio_rtiFilterFields)
      return;
    int _rio_i, _rio_j;
    _rio_rtiFilterFields = new int[_rio_rtiFilter.getFieldTypeInfos().size()];
    for (_rio_i = 0; _rio_i < _rio_rtiFilterFields.length; _rio_i++) {
      _rio_rtiFilterFields[_rio_i] = 0;
    }
    java.util.Iterator<org.apache.hadoop.record.meta.FieldTypeInfo> _rio_itFilter = _rio_rtiFilter
        .getFieldTypeInfos().iterator();
    _rio_i = 0;
    while (_rio_itFilter.hasNext()) {
      org.apache.hadoop.record.meta.FieldTypeInfo _rio_tInfoFilter = _rio_itFilter
          .next();
      java.util.Iterator<org.apache.hadoop.record.meta.FieldTypeInfo> _rio_it = _rio_recTypeInfo
          .getFieldTypeInfos().iterator();
      _rio_j = 1;
      while (_rio_it.hasNext()) {
        org.apache.hadoop.record.meta.FieldTypeInfo _rio_tInfo = _rio_it.next();
        if (_rio_tInfo.equals(_rio_tInfoFilter)) {
          _rio_rtiFilterFields[_rio_i] = _rio_j;
          break;
        }
        _rio_j++;
      }
      _rio_i++;
    }
  }

  public long getTime() {
    return time;
  }

  public void setTime(final long time) {
    this.time = time;
  }

  public java.util.TreeMap<String, org.apache.hadoop.record.Buffer> getMapFields() {
    return mapFields;
  }

  public void setMapFields(
      final java.util.TreeMap<String, org.apache.hadoop.record.Buffer> mapFields) {
    this.mapFields = mapFields;
  }

  public void serialize(final org.apache.hadoop.record.RecordOutput _rio_a,
      final String _rio_tag) throws java.io.IOException {
    _rio_a.startRecord(this, _rio_tag);
    _rio_a.writeLong(time, "time");
    {
      _rio_a.startMap(mapFields, "mapFields");
      java.util.Set<java.util.Map.Entry<String, org.apache.hadoop.record.Buffer>> _rio_es1 = mapFields
          .entrySet();
      for (java.util.Iterator<java.util.Map.Entry<String, org.apache.hadoop.record.Buffer>> _rio_midx1 = _rio_es1
          .iterator(); _rio_midx1.hasNext();) {
        java.util.Map.Entry<String, org.apache.hadoop.record.Buffer> _rio_me1 = _rio_midx1
            .next();
        String _rio_k1 = _rio_me1.getKey();
        org.apache.hadoop.record.Buffer _rio_v1 = _rio_me1.getValue();
        _rio_a.writeString(_rio_k1, "_rio_k1");
        _rio_a.writeBuffer(_rio_v1, "_rio_v1");
      }
      _rio_a.endMap(mapFields, "mapFields");
    }
    _rio_a.endRecord(this, _rio_tag);
  }

  private void deserializeWithoutFilter(
      final org.apache.hadoop.record.RecordInput _rio_a, final String _rio_tag)
      throws java.io.IOException {
    _rio_a.startRecord(_rio_tag);
    time = _rio_a.readLong("time");
    {
      org.apache.hadoop.record.Index _rio_midx1 = _rio_a.startMap("mapFields");
      mapFields = new java.util.TreeMap<String, org.apache.hadoop.record.Buffer>();
      for (; !_rio_midx1.done(); _rio_midx1.incr()) {
        String _rio_k1;
        _rio_k1 = _rio_a.readString("_rio_k1");
        org.apache.hadoop.record.Buffer _rio_v1;
        _rio_v1 = _rio_a.readBuffer("_rio_v1");
        mapFields.put(_rio_k1, _rio_v1);
      }
      _rio_a.endMap("mapFields");
    }
    _rio_a.endRecord(_rio_tag);
  }

  public void deserialize(final org.apache.hadoop.record.RecordInput _rio_a,
      final String _rio_tag) throws java.io.IOException {
    if (null == _rio_rtiFilter) {
      deserializeWithoutFilter(_rio_a, _rio_tag);
      return;
    }
    // if we're here, we need to read based on version info
    _rio_a.startRecord(_rio_tag);
    setupRtiFields();
    for (int _rio_i = 0; _rio_i < _rio_rtiFilter.getFieldTypeInfos().size(); _rio_i++) {
      if (1 == _rio_rtiFilterFields[_rio_i]) {
        time = _rio_a.readLong("time");
      } else if (2 == _rio_rtiFilterFields[_rio_i]) {
        {
          org.apache.hadoop.record.Index _rio_midx1 = _rio_a
              .startMap("mapFields");
          mapFields = new java.util.TreeMap<String, org.apache.hadoop.record.Buffer>();
          for (; !_rio_midx1.done(); _rio_midx1.incr()) {
            String _rio_k1;
            _rio_k1 = _rio_a.readString("_rio_k1");
            org.apache.hadoop.record.Buffer _rio_v1;
            _rio_v1 = _rio_a.readBuffer("_rio_v1");
            mapFields.put(_rio_k1, _rio_v1);
          }
          _rio_a.endMap("mapFields");
        }
      } else {
        java.util.ArrayList<org.apache.hadoop.record.meta.FieldTypeInfo> typeInfos = (java.util.ArrayList<org.apache.hadoop.record.meta.FieldTypeInfo>) (_rio_rtiFilter
            .getFieldTypeInfos());
        org.apache.hadoop.record.meta.Utils.skip(_rio_a, typeInfos.get(_rio_i)
            .getFieldID(), typeInfos.get(_rio_i).getTypeID());
      }
    }
    _rio_a.endRecord(_rio_tag);
  }

  public int compareTo(final Object _rio_peer_) throws ClassCastException {
    if (!(_rio_peer_ instanceof ChukwaRecordJT)) {
      throw new ClassCastException("Comparing different types of records.");
    }
    ChukwaRecordJT _rio_peer = (ChukwaRecordJT) _rio_peer_;
    int _rio_ret = 0;
    _rio_ret = (time == _rio_peer.time) ? 0
        : ((time < _rio_peer.time) ? -1 : 1);
    if (_rio_ret != 0)
      return _rio_ret;
    {
      java.util.Set<String> _rio_set10 = mapFields.keySet();
      java.util.Set<String> _rio_set20 = _rio_peer.mapFields.keySet();
      java.util.Iterator<String> _rio_miter10 = _rio_set10.iterator();
      java.util.Iterator<String> _rio_miter20 = _rio_set20.iterator();
      while(_rio_miter10.hasNext() && _rio_miter20.hasNext()) {
        String _rio_k10 = _rio_miter10.next();
        String _rio_k20 = _rio_miter20.next();
        _rio_ret = _rio_k10.compareTo(_rio_k20);
        if (_rio_ret != 0) {
          return _rio_ret;
        }
      }
      _rio_ret = (_rio_set10.size() - _rio_set20.size());
    }
    if (_rio_ret != 0)
      return _rio_ret;
    return _rio_ret;
  }

  public boolean equals(final Object _rio_peer_) {
    if (!(_rio_peer_ instanceof ChukwaRecordJT)) {
      return false;
    }
    if (_rio_peer_ == this) {
      return true;
    }
    ChukwaRecordJT _rio_peer = (ChukwaRecordJT) _rio_peer_;
    boolean _rio_ret = false;
    _rio_ret = (time == _rio_peer.time);
    if (!_rio_ret)
      return _rio_ret;
    _rio_ret = mapFields.equals(_rio_peer.mapFields);
    if (!_rio_ret)
      return _rio_ret;
    return _rio_ret;
  }

  public Object clone() throws CloneNotSupportedException {
    super.clone();
    ChukwaRecordJT _rio_other = new ChukwaRecordJT();
    _rio_other.time = this.time;
    _rio_other.mapFields = (java.util.TreeMap<String, org.apache.hadoop.record.Buffer>) this.mapFields
        .clone();
    return _rio_other;
  }

  public int hashCode() {
    int _rio_result = 17;
    int _rio_ret;
    _rio_ret = (int) (time ^ (time >>> 32));
    _rio_result = 37 * _rio_result + _rio_ret;
    _rio_ret = mapFields.hashCode();
    _rio_result = 37 * _rio_result + _rio_ret;
    return _rio_result;
  }

  public static String signature() {
    return "LChukwaRecordJT(l{sB})";
  }

  public static class Comparator extends
      org.apache.hadoop.record.RecordComparator implements Serializable {
    public Comparator() {
      super(ChukwaRecordJT.class);
    }

    static public int slurpRaw(byte[] b, int s, int l) {
      try {
        int os = s;
        {
          long i = org.apache.hadoop.record.Utils.readVLong(b, s);
          int z = org.apache.hadoop.record.Utils.getVIntSize(i);
          s += z;
          l -= z;
        }
        {
          int mi1 = org.apache.hadoop.record.Utils.readVInt(b, s);
          int mz1 = org.apache.hadoop.record.Utils.getVIntSize(mi1);
          s += mz1;
          l -= mz1;
          for (int midx1 = 0; midx1 < mi1; midx1++) {
            {
              int i = org.apache.hadoop.record.Utils.readVInt(b, s);
              int z = org.apache.hadoop.record.Utils.getVIntSize(i);
              s += (z + i);
              l -= (z + i);
            }
            {
              int i = org.apache.hadoop.record.Utils.readVInt(b, s);
              int z = org.apache.hadoop.record.Utils.getVIntSize(i);
              s += z + i;
              l -= (z + i);
            }
          }
        }
        return (os - s);
      } catch (java.io.IOException e) {
        throw new RuntimeException(e);
      }
    }

    static public int compareRaw(byte[] b1, int s1, int l1, byte[] b2, int s2,
        int l2) {
      try {
        int os1 = s1;
        {
          long i1 = org.apache.hadoop.record.Utils.readVLong(b1, s1);
          long i2 = org.apache.hadoop.record.Utils.readVLong(b2, s2);
          if (i1 != i2) {
            return ((i1 - i2) < 0) ? -1 : 0;
          }
          int z1 = org.apache.hadoop.record.Utils.getVIntSize(i1);
          int z2 = org.apache.hadoop.record.Utils.getVIntSize(i2);
          s1 += z1;
          s2 += z2;
          l1 -= z1;
          l2 -= z2;
        }
        {
          int mi11 = org.apache.hadoop.record.Utils.readVInt(b1, s1);
          int mi21 = org.apache.hadoop.record.Utils.readVInt(b2, s2);
          int mz11 = org.apache.hadoop.record.Utils.getVIntSize(mi11);
          int mz21 = org.apache.hadoop.record.Utils.getVIntSize(mi21);
          s1 += mz11;
          s2 += mz21;
          l1 -= mz11;
          l2 -= mz21;
          for (int midx1 = 0; midx1 < mi11 && midx1 < mi21; midx1++) {
            {
              int i1 = org.apache.hadoop.record.Utils.readVInt(b1, s1);
              int i2 = org.apache.hadoop.record.Utils.readVInt(b2, s2);
              int z1 = org.apache.hadoop.record.Utils.getVIntSize(i1);
              int z2 = org.apache.hadoop.record.Utils.getVIntSize(i2);
              s1 += z1;
              s2 += z2;
              l1 -= z1;
              l2 -= z2;
              int r1 = org.apache.hadoop.record.Utils.compareBytes(b1, s1, i1,
                  b2, s2, i2);
              if (r1 != 0) {
                return (r1 < 0) ? -1 : 0;
              }
              s1 += i1;
              s2 += i2;
              l1 -= i1;
              l1 -= i2;
            }
            {
              int i = org.apache.hadoop.record.Utils.readVInt(b1, s1);
              int z = org.apache.hadoop.record.Utils.getVIntSize(i);
              s1 += z + i;
              l1 -= (z + i);
            }
            {
              int i = org.apache.hadoop.record.Utils.readVInt(b2, s2);
              int z = org.apache.hadoop.record.Utils.getVIntSize(i);
              s2 += z + i;
              l2 -= (z + i);
            }
          }
          if (mi11 != mi21) {
            return (mi11 < mi21) ? -1 : 0;
          }
        }
        return (os1 - s1);
      } catch (java.io.IOException e) {
        throw new RuntimeException(e);
      }
    }

    public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
      int ret = compareRaw(b1, s1, l1, b2, s2, l2);
      return (ret == -1) ? -1 : ((ret == 0) ? 1 : 0);
    }
  }

  static {
    org.apache.hadoop.record.RecordComparator.define(ChukwaRecordJT.class,
        new Comparator());
  }
}
