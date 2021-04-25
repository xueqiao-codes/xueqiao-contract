/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.contract.thriftapi;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SledTradeTime implements org.apache.thrift.TBase<SledTradeTime, SledTradeTime._Fields>, java.io.Serializable, Cloneable, Comparable<SledTradeTime> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SledTradeTime");

  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField DATE_TIME_SPANS_FIELD_DESC = new org.apache.thrift.protocol.TField("dateTimeSpans", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField ZONE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("zoneId", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SledTradeTimeStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SledTradeTimeTupleSchemeFactory());
  }

  public int sledCommodityId; // optional
  public List<DateTimeSpan> dateTimeSpans; // optional
  public String zoneId; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLED_COMMODITY_ID((short)1, "sledCommodityId"),
    DATE_TIME_SPANS((short)2, "dateTimeSpans"),
    ZONE_ID((short)6, "zoneId");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SLED_COMMODITY_ID
          return SLED_COMMODITY_ID;
        case 2: // DATE_TIME_SPANS
          return DATE_TIME_SPANS;
        case 6: // ZONE_ID
          return ZONE_ID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __SLEDCOMMODITYID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.SLED_COMMODITY_ID,_Fields.DATE_TIME_SPANS,_Fields.ZONE_ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLED_COMMODITY_ID, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DATE_TIME_SPANS, new org.apache.thrift.meta_data.FieldMetaData("dateTimeSpans", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, DateTimeSpan.class))));
    tmpMap.put(_Fields.ZONE_ID, new org.apache.thrift.meta_data.FieldMetaData("zoneId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SledTradeTime.class, metaDataMap);
  }

  public SledTradeTime() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SledTradeTime(SledTradeTime other) {
    __isset_bitfield = other.__isset_bitfield;
    this.sledCommodityId = other.sledCommodityId;
    if (other.isSetDateTimeSpans()) {
      List<DateTimeSpan> __this__dateTimeSpans = new ArrayList<DateTimeSpan>(other.dateTimeSpans.size());
      for (DateTimeSpan other_element : other.dateTimeSpans) {
        __this__dateTimeSpans.add(new DateTimeSpan(other_element));
      }
      this.dateTimeSpans = __this__dateTimeSpans;
    }
    if (other.isSetZoneId()) {
      this.zoneId = other.zoneId;
    }
  }

  public SledTradeTime deepCopy() {
    return new SledTradeTime(this);
  }

  @Override
  public void clear() {
    setSledCommodityIdIsSet(false);
    this.sledCommodityId = 0;
    this.dateTimeSpans = null;
    this.zoneId = null;
  }

  public int getSledCommodityId() {
    return this.sledCommodityId;
  }

  public SledTradeTime setSledCommodityId(int sledCommodityId) {
    this.sledCommodityId = sledCommodityId;
    setSledCommodityIdIsSet(true);
    return this;
  }

  public void unsetSledCommodityId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SLEDCOMMODITYID_ISSET_ID);
  }

  /** Returns true if field sledCommodityId is set (has been assigned a value) and false otherwise */
  public boolean isSetSledCommodityId() {
    return EncodingUtils.testBit(__isset_bitfield, __SLEDCOMMODITYID_ISSET_ID);
  }

  public void setSledCommodityIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SLEDCOMMODITYID_ISSET_ID, value);
  }

  public int getDateTimeSpansSize() {
    return (this.dateTimeSpans == null) ? 0 : this.dateTimeSpans.size();
  }

  public java.util.Iterator<DateTimeSpan> getDateTimeSpansIterator() {
    return (this.dateTimeSpans == null) ? null : this.dateTimeSpans.iterator();
  }

  public void addToDateTimeSpans(DateTimeSpan elem) {
    if (this.dateTimeSpans == null) {
      this.dateTimeSpans = new ArrayList<DateTimeSpan>();
    }
    this.dateTimeSpans.add(elem);
  }

  public List<DateTimeSpan> getDateTimeSpans() {
    return this.dateTimeSpans;
  }

  public SledTradeTime setDateTimeSpans(List<DateTimeSpan> dateTimeSpans) {
    this.dateTimeSpans = dateTimeSpans;
    return this;
  }

  public void unsetDateTimeSpans() {
    this.dateTimeSpans = null;
  }

  /** Returns true if field dateTimeSpans is set (has been assigned a value) and false otherwise */
  public boolean isSetDateTimeSpans() {
    return this.dateTimeSpans != null;
  }

  public void setDateTimeSpansIsSet(boolean value) {
    if (!value) {
      this.dateTimeSpans = null;
    }
  }

  public String getZoneId() {
    return this.zoneId;
  }

  public SledTradeTime setZoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

  public void unsetZoneId() {
    this.zoneId = null;
  }

  /** Returns true if field zoneId is set (has been assigned a value) and false otherwise */
  public boolean isSetZoneId() {
    return this.zoneId != null;
  }

  public void setZoneIdIsSet(boolean value) {
    if (!value) {
      this.zoneId = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SLED_COMMODITY_ID:
      if (value == null) {
        unsetSledCommodityId();
      } else {
        setSledCommodityId((Integer)value);
      }
      break;

    case DATE_TIME_SPANS:
      if (value == null) {
        unsetDateTimeSpans();
      } else {
        setDateTimeSpans((List<DateTimeSpan>)value);
      }
      break;

    case ZONE_ID:
      if (value == null) {
        unsetZoneId();
      } else {
        setZoneId((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SLED_COMMODITY_ID:
      return Integer.valueOf(getSledCommodityId());

    case DATE_TIME_SPANS:
      return getDateTimeSpans();

    case ZONE_ID:
      return getZoneId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SLED_COMMODITY_ID:
      return isSetSledCommodityId();
    case DATE_TIME_SPANS:
      return isSetDateTimeSpans();
    case ZONE_ID:
      return isSetZoneId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SledTradeTime)
      return this.equals((SledTradeTime)that);
    return false;
  }

  public boolean equals(SledTradeTime that) {
    if (that == null)
      return false;

    boolean this_present_sledCommodityId = true && this.isSetSledCommodityId();
    boolean that_present_sledCommodityId = true && that.isSetSledCommodityId();
    if (this_present_sledCommodityId || that_present_sledCommodityId) {
      if (!(this_present_sledCommodityId && that_present_sledCommodityId))
        return false;
      if (this.sledCommodityId != that.sledCommodityId)
        return false;
    }

    boolean this_present_dateTimeSpans = true && this.isSetDateTimeSpans();
    boolean that_present_dateTimeSpans = true && that.isSetDateTimeSpans();
    if (this_present_dateTimeSpans || that_present_dateTimeSpans) {
      if (!(this_present_dateTimeSpans && that_present_dateTimeSpans))
        return false;
      if (!this.dateTimeSpans.equals(that.dateTimeSpans))
        return false;
    }

    boolean this_present_zoneId = true && this.isSetZoneId();
    boolean that_present_zoneId = true && that.isSetZoneId();
    if (this_present_zoneId || that_present_zoneId) {
      if (!(this_present_zoneId && that_present_zoneId))
        return false;
      if (!this.zoneId.equals(that.zoneId))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(SledTradeTime other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSledCommodityId()).compareTo(other.isSetSledCommodityId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledCommodityId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledCommodityId, other.sledCommodityId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDateTimeSpans()).compareTo(other.isSetDateTimeSpans());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDateTimeSpans()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dateTimeSpans, other.dateTimeSpans);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetZoneId()).compareTo(other.isSetZoneId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetZoneId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.zoneId, other.zoneId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("SledTradeTime(");
    boolean first = true;

    if (isSetSledCommodityId()) {
      sb.append("sledCommodityId:");
      sb.append(this.sledCommodityId);
      first = false;
    }
    if (isSetDateTimeSpans()) {
      if (!first) sb.append(", ");
      sb.append("dateTimeSpans:");
      if (this.dateTimeSpans == null) {
        sb.append("null");
      } else {
        sb.append(this.dateTimeSpans);
      }
      first = false;
    }
    if (isSetZoneId()) {
      if (!first) sb.append(", ");
      sb.append("zoneId:");
      if (this.zoneId == null) {
        sb.append("null");
      } else {
        sb.append(this.zoneId);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SledTradeTimeStandardSchemeFactory implements SchemeFactory {
    public SledTradeTimeStandardScheme getScheme() {
      return new SledTradeTimeStandardScheme();
    }
  }

  private static class SledTradeTimeStandardScheme extends StandardScheme<SledTradeTime> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SledTradeTime struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SLED_COMMODITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledCommodityId = iprot.readI32();
              struct.setSledCommodityIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DATE_TIME_SPANS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list232 = iprot.readListBegin();
                struct.dateTimeSpans = new ArrayList<DateTimeSpan>(_list232.size);
                for (int _i233 = 0; _i233 < _list232.size; ++_i233)
                {
                  DateTimeSpan _elem234;
                  _elem234 = new DateTimeSpan();
                  _elem234.read(iprot);
                  struct.dateTimeSpans.add(_elem234);
                }
                iprot.readListEnd();
              }
              struct.setDateTimeSpansIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ZONE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.zoneId = iprot.readString();
              struct.setZoneIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SledTradeTime struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetSledCommodityId()) {
        oprot.writeFieldBegin(SLED_COMMODITY_ID_FIELD_DESC);
        oprot.writeI32(struct.sledCommodityId);
        oprot.writeFieldEnd();
      }
      if (struct.dateTimeSpans != null) {
        if (struct.isSetDateTimeSpans()) {
          oprot.writeFieldBegin(DATE_TIME_SPANS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.dateTimeSpans.size()));
            for (DateTimeSpan _iter235 : struct.dateTimeSpans)
            {
              _iter235.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.zoneId != null) {
        if (struct.isSetZoneId()) {
          oprot.writeFieldBegin(ZONE_ID_FIELD_DESC);
          oprot.writeString(struct.zoneId);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SledTradeTimeTupleSchemeFactory implements SchemeFactory {
    public SledTradeTimeTupleScheme getScheme() {
      return new SledTradeTimeTupleScheme();
    }
  }

  private static class SledTradeTimeTupleScheme extends TupleScheme<SledTradeTime> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SledTradeTime struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSledCommodityId()) {
        optionals.set(0);
      }
      if (struct.isSetDateTimeSpans()) {
        optionals.set(1);
      }
      if (struct.isSetZoneId()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetSledCommodityId()) {
        oprot.writeI32(struct.sledCommodityId);
      }
      if (struct.isSetDateTimeSpans()) {
        {
          oprot.writeI32(struct.dateTimeSpans.size());
          for (DateTimeSpan _iter236 : struct.dateTimeSpans)
          {
            _iter236.write(oprot);
          }
        }
      }
      if (struct.isSetZoneId()) {
        oprot.writeString(struct.zoneId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SledTradeTime struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.sledCommodityId = iprot.readI32();
        struct.setSledCommodityIdIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list237 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.dateTimeSpans = new ArrayList<DateTimeSpan>(_list237.size);
          for (int _i238 = 0; _i238 < _list237.size; ++_i238)
          {
            DateTimeSpan _elem239;
            _elem239 = new DateTimeSpan();
            _elem239.read(iprot);
            struct.dateTimeSpans.add(_elem239);
          }
        }
        struct.setDateTimeSpansIsSet(true);
      }
      if (incoming.get(2)) {
        struct.zoneId = iprot.readString();
        struct.setZoneIdIsSet(true);
      }
    }
  }

}
