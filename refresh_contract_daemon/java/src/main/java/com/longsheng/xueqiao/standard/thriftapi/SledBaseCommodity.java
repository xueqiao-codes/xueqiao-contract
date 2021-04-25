/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.standard.thriftapi;

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

public class SledBaseCommodity implements org.apache.thrift.TBase<SledBaseCommodity, SledBaseCommodity._Fields>, java.io.Serializable, Cloneable, Comparable<SledBaseCommodity> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SledBaseCommodity");

  private static final org.apache.thrift.protocol.TField EXCHANGE_MIC_FIELD_DESC = new org.apache.thrift.protocol.TField("exchangeMic", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityType", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityCode", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityId", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SledBaseCommodityStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SledBaseCommodityTupleSchemeFactory());
  }

  public String exchangeMic; // optional
  /**
   * 
   * @see SledCommodityType
   */
  public SledCommodityType sledCommodityType; // optional
  public String sledCommodityCode; // optional
  public int sledCommodityId; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EXCHANGE_MIC((short)1, "exchangeMic"),
    /**
     * 
     * @see SledCommodityType
     */
    SLED_COMMODITY_TYPE((short)2, "sledCommodityType"),
    SLED_COMMODITY_CODE((short)3, "sledCommodityCode"),
    SLED_COMMODITY_ID((short)4, "sledCommodityId");

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
        case 1: // EXCHANGE_MIC
          return EXCHANGE_MIC;
        case 2: // SLED_COMMODITY_TYPE
          return SLED_COMMODITY_TYPE;
        case 3: // SLED_COMMODITY_CODE
          return SLED_COMMODITY_CODE;
        case 4: // SLED_COMMODITY_ID
          return SLED_COMMODITY_ID;
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
  private _Fields optionals[] = {_Fields.EXCHANGE_MIC,_Fields.SLED_COMMODITY_TYPE,_Fields.SLED_COMMODITY_CODE,_Fields.SLED_COMMODITY_ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EXCHANGE_MIC, new org.apache.thrift.meta_data.FieldMetaData("exchangeMic", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SLED_COMMODITY_TYPE, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, SledCommodityType.class)));
    tmpMap.put(_Fields.SLED_COMMODITY_CODE, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityCode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SLED_COMMODITY_ID, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SledBaseCommodity.class, metaDataMap);
  }

  public SledBaseCommodity() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SledBaseCommodity(SledBaseCommodity other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetExchangeMic()) {
      this.exchangeMic = other.exchangeMic;
    }
    if (other.isSetSledCommodityType()) {
      this.sledCommodityType = other.sledCommodityType;
    }
    if (other.isSetSledCommodityCode()) {
      this.sledCommodityCode = other.sledCommodityCode;
    }
    this.sledCommodityId = other.sledCommodityId;
  }

  public SledBaseCommodity deepCopy() {
    return new SledBaseCommodity(this);
  }

  @Override
  public void clear() {
    this.exchangeMic = null;
    this.sledCommodityType = null;
    this.sledCommodityCode = null;
    setSledCommodityIdIsSet(false);
    this.sledCommodityId = 0;
  }

  public String getExchangeMic() {
    return this.exchangeMic;
  }

  public SledBaseCommodity setExchangeMic(String exchangeMic) {
    this.exchangeMic = exchangeMic;
    return this;
  }

  public void unsetExchangeMic() {
    this.exchangeMic = null;
  }

  /** Returns true if field exchangeMic is set (has been assigned a value) and false otherwise */
  public boolean isSetExchangeMic() {
    return this.exchangeMic != null;
  }

  public void setExchangeMicIsSet(boolean value) {
    if (!value) {
      this.exchangeMic = null;
    }
  }

  /**
   * 
   * @see SledCommodityType
   */
  public SledCommodityType getSledCommodityType() {
    return this.sledCommodityType;
  }

  /**
   * 
   * @see SledCommodityType
   */
  public SledBaseCommodity setSledCommodityType(SledCommodityType sledCommodityType) {
    this.sledCommodityType = sledCommodityType;
    return this;
  }

  public void unsetSledCommodityType() {
    this.sledCommodityType = null;
  }

  /** Returns true if field sledCommodityType is set (has been assigned a value) and false otherwise */
  public boolean isSetSledCommodityType() {
    return this.sledCommodityType != null;
  }

  public void setSledCommodityTypeIsSet(boolean value) {
    if (!value) {
      this.sledCommodityType = null;
    }
  }

  public String getSledCommodityCode() {
    return this.sledCommodityCode;
  }

  public SledBaseCommodity setSledCommodityCode(String sledCommodityCode) {
    this.sledCommodityCode = sledCommodityCode;
    return this;
  }

  public void unsetSledCommodityCode() {
    this.sledCommodityCode = null;
  }

  /** Returns true if field sledCommodityCode is set (has been assigned a value) and false otherwise */
  public boolean isSetSledCommodityCode() {
    return this.sledCommodityCode != null;
  }

  public void setSledCommodityCodeIsSet(boolean value) {
    if (!value) {
      this.sledCommodityCode = null;
    }
  }

  public int getSledCommodityId() {
    return this.sledCommodityId;
  }

  public SledBaseCommodity setSledCommodityId(int sledCommodityId) {
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

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case EXCHANGE_MIC:
      if (value == null) {
        unsetExchangeMic();
      } else {
        setExchangeMic((String)value);
      }
      break;

    case SLED_COMMODITY_TYPE:
      if (value == null) {
        unsetSledCommodityType();
      } else {
        setSledCommodityType((SledCommodityType)value);
      }
      break;

    case SLED_COMMODITY_CODE:
      if (value == null) {
        unsetSledCommodityCode();
      } else {
        setSledCommodityCode((String)value);
      }
      break;

    case SLED_COMMODITY_ID:
      if (value == null) {
        unsetSledCommodityId();
      } else {
        setSledCommodityId((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EXCHANGE_MIC:
      return getExchangeMic();

    case SLED_COMMODITY_TYPE:
      return getSledCommodityType();

    case SLED_COMMODITY_CODE:
      return getSledCommodityCode();

    case SLED_COMMODITY_ID:
      return Integer.valueOf(getSledCommodityId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case EXCHANGE_MIC:
      return isSetExchangeMic();
    case SLED_COMMODITY_TYPE:
      return isSetSledCommodityType();
    case SLED_COMMODITY_CODE:
      return isSetSledCommodityCode();
    case SLED_COMMODITY_ID:
      return isSetSledCommodityId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SledBaseCommodity)
      return this.equals((SledBaseCommodity)that);
    return false;
  }

  public boolean equals(SledBaseCommodity that) {
    if (that == null)
      return false;

    boolean this_present_exchangeMic = true && this.isSetExchangeMic();
    boolean that_present_exchangeMic = true && that.isSetExchangeMic();
    if (this_present_exchangeMic || that_present_exchangeMic) {
      if (!(this_present_exchangeMic && that_present_exchangeMic))
        return false;
      if (!this.exchangeMic.equals(that.exchangeMic))
        return false;
    }

    boolean this_present_sledCommodityType = true && this.isSetSledCommodityType();
    boolean that_present_sledCommodityType = true && that.isSetSledCommodityType();
    if (this_present_sledCommodityType || that_present_sledCommodityType) {
      if (!(this_present_sledCommodityType && that_present_sledCommodityType))
        return false;
      if (!this.sledCommodityType.equals(that.sledCommodityType))
        return false;
    }

    boolean this_present_sledCommodityCode = true && this.isSetSledCommodityCode();
    boolean that_present_sledCommodityCode = true && that.isSetSledCommodityCode();
    if (this_present_sledCommodityCode || that_present_sledCommodityCode) {
      if (!(this_present_sledCommodityCode && that_present_sledCommodityCode))
        return false;
      if (!this.sledCommodityCode.equals(that.sledCommodityCode))
        return false;
    }

    boolean this_present_sledCommodityId = true && this.isSetSledCommodityId();
    boolean that_present_sledCommodityId = true && that.isSetSledCommodityId();
    if (this_present_sledCommodityId || that_present_sledCommodityId) {
      if (!(this_present_sledCommodityId && that_present_sledCommodityId))
        return false;
      if (this.sledCommodityId != that.sledCommodityId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(SledBaseCommodity other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetExchangeMic()).compareTo(other.isSetExchangeMic());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExchangeMic()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.exchangeMic, other.exchangeMic);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSledCommodityType()).compareTo(other.isSetSledCommodityType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledCommodityType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledCommodityType, other.sledCommodityType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSledCommodityCode()).compareTo(other.isSetSledCommodityCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledCommodityCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledCommodityCode, other.sledCommodityCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    StringBuilder sb = new StringBuilder("SledBaseCommodity(");
    boolean first = true;

    if (isSetExchangeMic()) {
      sb.append("exchangeMic:");
      if (this.exchangeMic == null) {
        sb.append("null");
      } else {
        sb.append(this.exchangeMic);
      }
      first = false;
    }
    if (isSetSledCommodityType()) {
      if (!first) sb.append(", ");
      sb.append("sledCommodityType:");
      if (this.sledCommodityType == null) {
        sb.append("null");
      } else {
        sb.append(this.sledCommodityType);
      }
      first = false;
    }
    if (isSetSledCommodityCode()) {
      if (!first) sb.append(", ");
      sb.append("sledCommodityCode:");
      if (this.sledCommodityCode == null) {
        sb.append("null");
      } else {
        sb.append(this.sledCommodityCode);
      }
      first = false;
    }
    if (isSetSledCommodityId()) {
      if (!first) sb.append(", ");
      sb.append("sledCommodityId:");
      sb.append(this.sledCommodityId);
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

  private static class SledBaseCommodityStandardSchemeFactory implements SchemeFactory {
    public SledBaseCommodityStandardScheme getScheme() {
      return new SledBaseCommodityStandardScheme();
    }
  }

  private static class SledBaseCommodityStandardScheme extends StandardScheme<SledBaseCommodity> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SledBaseCommodity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EXCHANGE_MIC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.exchangeMic = iprot.readString();
              struct.setExchangeMicIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SLED_COMMODITY_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledCommodityType = SledCommodityType.findByValue(iprot.readI32());
              struct.setSledCommodityTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SLED_COMMODITY_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sledCommodityCode = iprot.readString();
              struct.setSledCommodityCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SLED_COMMODITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledCommodityId = iprot.readI32();
              struct.setSledCommodityIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SledBaseCommodity struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.exchangeMic != null) {
        if (struct.isSetExchangeMic()) {
          oprot.writeFieldBegin(EXCHANGE_MIC_FIELD_DESC);
          oprot.writeString(struct.exchangeMic);
          oprot.writeFieldEnd();
        }
      }
      if (struct.sledCommodityType != null) {
        if (struct.isSetSledCommodityType()) {
          oprot.writeFieldBegin(SLED_COMMODITY_TYPE_FIELD_DESC);
          oprot.writeI32(struct.sledCommodityType.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.sledCommodityCode != null) {
        if (struct.isSetSledCommodityCode()) {
          oprot.writeFieldBegin(SLED_COMMODITY_CODE_FIELD_DESC);
          oprot.writeString(struct.sledCommodityCode);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetSledCommodityId()) {
        oprot.writeFieldBegin(SLED_COMMODITY_ID_FIELD_DESC);
        oprot.writeI32(struct.sledCommodityId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SledBaseCommodityTupleSchemeFactory implements SchemeFactory {
    public SledBaseCommodityTupleScheme getScheme() {
      return new SledBaseCommodityTupleScheme();
    }
  }

  private static class SledBaseCommodityTupleScheme extends TupleScheme<SledBaseCommodity> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SledBaseCommodity struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetExchangeMic()) {
        optionals.set(0);
      }
      if (struct.isSetSledCommodityType()) {
        optionals.set(1);
      }
      if (struct.isSetSledCommodityCode()) {
        optionals.set(2);
      }
      if (struct.isSetSledCommodityId()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetExchangeMic()) {
        oprot.writeString(struct.exchangeMic);
      }
      if (struct.isSetSledCommodityType()) {
        oprot.writeI32(struct.sledCommodityType.getValue());
      }
      if (struct.isSetSledCommodityCode()) {
        oprot.writeString(struct.sledCommodityCode);
      }
      if (struct.isSetSledCommodityId()) {
        oprot.writeI32(struct.sledCommodityId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SledBaseCommodity struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.exchangeMic = iprot.readString();
        struct.setExchangeMicIsSet(true);
      }
      if (incoming.get(1)) {
        struct.sledCommodityType = SledCommodityType.findByValue(iprot.readI32());
        struct.setSledCommodityTypeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.sledCommodityCode = iprot.readString();
        struct.setSledCommodityCodeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.sledCommodityId = iprot.readI32();
        struct.setSledCommodityIdIsSet(true);
      }
    }
  }

}
