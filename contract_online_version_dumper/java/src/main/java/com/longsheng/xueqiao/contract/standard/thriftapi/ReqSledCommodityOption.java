/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.contract.standard.thriftapi;

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

public class ReqSledCommodityOption implements org.apache.thrift.TBase<ReqSledCommodityOption, ReqSledCommodityOption._Fields>, java.io.Serializable, Cloneable, Comparable<ReqSledCommodityOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReqSledCommodityOption");

  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_ID_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityIdList", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField EXCHANGE_MIC_FIELD_DESC = new org.apache.thrift.protocol.TField("exchangeMic", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityType", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityCode", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReqSledCommodityOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReqSledCommodityOptionTupleSchemeFactory());
  }

  public List<Integer> sledCommodityIdList; // optional
  public String exchangeMic; // optional
  /**
   * 
   * @see SledCommodityType
   */
  public SledCommodityType sledCommodityType; // optional
  public String sledCommodityCode; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLED_COMMODITY_ID_LIST((short)1, "sledCommodityIdList"),
    EXCHANGE_MIC((short)2, "exchangeMic"),
    /**
     * 
     * @see SledCommodityType
     */
    SLED_COMMODITY_TYPE((short)3, "sledCommodityType"),
    SLED_COMMODITY_CODE((short)4, "sledCommodityCode");

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
        case 1: // SLED_COMMODITY_ID_LIST
          return SLED_COMMODITY_ID_LIST;
        case 2: // EXCHANGE_MIC
          return EXCHANGE_MIC;
        case 3: // SLED_COMMODITY_TYPE
          return SLED_COMMODITY_TYPE;
        case 4: // SLED_COMMODITY_CODE
          return SLED_COMMODITY_CODE;
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
  private _Fields optionals[] = {_Fields.SLED_COMMODITY_ID_LIST,_Fields.EXCHANGE_MIC,_Fields.SLED_COMMODITY_TYPE,_Fields.SLED_COMMODITY_CODE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLED_COMMODITY_ID_LIST, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityIdList", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.EXCHANGE_MIC, new org.apache.thrift.meta_data.FieldMetaData("exchangeMic", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SLED_COMMODITY_TYPE, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, SledCommodityType.class)));
    tmpMap.put(_Fields.SLED_COMMODITY_CODE, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityCode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReqSledCommodityOption.class, metaDataMap);
  }

  public ReqSledCommodityOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReqSledCommodityOption(ReqSledCommodityOption other) {
    if (other.isSetSledCommodityIdList()) {
      List<Integer> __this__sledCommodityIdList = new ArrayList<Integer>(other.sledCommodityIdList);
      this.sledCommodityIdList = __this__sledCommodityIdList;
    }
    if (other.isSetExchangeMic()) {
      this.exchangeMic = other.exchangeMic;
    }
    if (other.isSetSledCommodityType()) {
      this.sledCommodityType = other.sledCommodityType;
    }
    if (other.isSetSledCommodityCode()) {
      this.sledCommodityCode = other.sledCommodityCode;
    }
  }

  public ReqSledCommodityOption deepCopy() {
    return new ReqSledCommodityOption(this);
  }

  @Override
  public void clear() {
    this.sledCommodityIdList = null;
    this.exchangeMic = null;
    this.sledCommodityType = null;
    this.sledCommodityCode = null;
  }

  public int getSledCommodityIdListSize() {
    return (this.sledCommodityIdList == null) ? 0 : this.sledCommodityIdList.size();
  }

  public java.util.Iterator<Integer> getSledCommodityIdListIterator() {
    return (this.sledCommodityIdList == null) ? null : this.sledCommodityIdList.iterator();
  }

  public void addToSledCommodityIdList(int elem) {
    if (this.sledCommodityIdList == null) {
      this.sledCommodityIdList = new ArrayList<Integer>();
    }
    this.sledCommodityIdList.add(elem);
  }

  public List<Integer> getSledCommodityIdList() {
    return this.sledCommodityIdList;
  }

  public ReqSledCommodityOption setSledCommodityIdList(List<Integer> sledCommodityIdList) {
    this.sledCommodityIdList = sledCommodityIdList;
    return this;
  }

  public void unsetSledCommodityIdList() {
    this.sledCommodityIdList = null;
  }

  /** Returns true if field sledCommodityIdList is set (has been assigned a value) and false otherwise */
  public boolean isSetSledCommodityIdList() {
    return this.sledCommodityIdList != null;
  }

  public void setSledCommodityIdListIsSet(boolean value) {
    if (!value) {
      this.sledCommodityIdList = null;
    }
  }

  public String getExchangeMic() {
    return this.exchangeMic;
  }

  public ReqSledCommodityOption setExchangeMic(String exchangeMic) {
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
  public ReqSledCommodityOption setSledCommodityType(SledCommodityType sledCommodityType) {
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

  public ReqSledCommodityOption setSledCommodityCode(String sledCommodityCode) {
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

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SLED_COMMODITY_ID_LIST:
      if (value == null) {
        unsetSledCommodityIdList();
      } else {
        setSledCommodityIdList((List<Integer>)value);
      }
      break;

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

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SLED_COMMODITY_ID_LIST:
      return getSledCommodityIdList();

    case EXCHANGE_MIC:
      return getExchangeMic();

    case SLED_COMMODITY_TYPE:
      return getSledCommodityType();

    case SLED_COMMODITY_CODE:
      return getSledCommodityCode();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SLED_COMMODITY_ID_LIST:
      return isSetSledCommodityIdList();
    case EXCHANGE_MIC:
      return isSetExchangeMic();
    case SLED_COMMODITY_TYPE:
      return isSetSledCommodityType();
    case SLED_COMMODITY_CODE:
      return isSetSledCommodityCode();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReqSledCommodityOption)
      return this.equals((ReqSledCommodityOption)that);
    return false;
  }

  public boolean equals(ReqSledCommodityOption that) {
    if (that == null)
      return false;

    boolean this_present_sledCommodityIdList = true && this.isSetSledCommodityIdList();
    boolean that_present_sledCommodityIdList = true && that.isSetSledCommodityIdList();
    if (this_present_sledCommodityIdList || that_present_sledCommodityIdList) {
      if (!(this_present_sledCommodityIdList && that_present_sledCommodityIdList))
        return false;
      if (!this.sledCommodityIdList.equals(that.sledCommodityIdList))
        return false;
    }

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

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ReqSledCommodityOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSledCommodityIdList()).compareTo(other.isSetSledCommodityIdList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledCommodityIdList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledCommodityIdList, other.sledCommodityIdList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    StringBuilder sb = new StringBuilder("ReqSledCommodityOption(");
    boolean first = true;

    if (isSetSledCommodityIdList()) {
      sb.append("sledCommodityIdList:");
      if (this.sledCommodityIdList == null) {
        sb.append("null");
      } else {
        sb.append(this.sledCommodityIdList);
      }
      first = false;
    }
    if (isSetExchangeMic()) {
      if (!first) sb.append(", ");
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ReqSledCommodityOptionStandardSchemeFactory implements SchemeFactory {
    public ReqSledCommodityOptionStandardScheme getScheme() {
      return new ReqSledCommodityOptionStandardScheme();
    }
  }

  private static class ReqSledCommodityOptionStandardScheme extends StandardScheme<ReqSledCommodityOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReqSledCommodityOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SLED_COMMODITY_ID_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list72 = iprot.readListBegin();
                struct.sledCommodityIdList = new ArrayList<Integer>(_list72.size);
                for (int _i73 = 0; _i73 < _list72.size; ++_i73)
                {
                  int _elem74;
                  _elem74 = iprot.readI32();
                  struct.sledCommodityIdList.add(_elem74);
                }
                iprot.readListEnd();
              }
              struct.setSledCommodityIdListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // EXCHANGE_MIC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.exchangeMic = iprot.readString();
              struct.setExchangeMicIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SLED_COMMODITY_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledCommodityType = SledCommodityType.findByValue(iprot.readI32());
              struct.setSledCommodityTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SLED_COMMODITY_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sledCommodityCode = iprot.readString();
              struct.setSledCommodityCodeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReqSledCommodityOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sledCommodityIdList != null) {
        if (struct.isSetSledCommodityIdList()) {
          oprot.writeFieldBegin(SLED_COMMODITY_ID_LIST_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.sledCommodityIdList.size()));
            for (int _iter75 : struct.sledCommodityIdList)
            {
              oprot.writeI32(_iter75);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
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
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ReqSledCommodityOptionTupleSchemeFactory implements SchemeFactory {
    public ReqSledCommodityOptionTupleScheme getScheme() {
      return new ReqSledCommodityOptionTupleScheme();
    }
  }

  private static class ReqSledCommodityOptionTupleScheme extends TupleScheme<ReqSledCommodityOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReqSledCommodityOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSledCommodityIdList()) {
        optionals.set(0);
      }
      if (struct.isSetExchangeMic()) {
        optionals.set(1);
      }
      if (struct.isSetSledCommodityType()) {
        optionals.set(2);
      }
      if (struct.isSetSledCommodityCode()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetSledCommodityIdList()) {
        {
          oprot.writeI32(struct.sledCommodityIdList.size());
          for (int _iter76 : struct.sledCommodityIdList)
          {
            oprot.writeI32(_iter76);
          }
        }
      }
      if (struct.isSetExchangeMic()) {
        oprot.writeString(struct.exchangeMic);
      }
      if (struct.isSetSledCommodityType()) {
        oprot.writeI32(struct.sledCommodityType.getValue());
      }
      if (struct.isSetSledCommodityCode()) {
        oprot.writeString(struct.sledCommodityCode);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReqSledCommodityOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list77 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.sledCommodityIdList = new ArrayList<Integer>(_list77.size);
          for (int _i78 = 0; _i78 < _list77.size; ++_i78)
          {
            int _elem79;
            _elem79 = iprot.readI32();
            struct.sledCommodityIdList.add(_elem79);
          }
        }
        struct.setSledCommodityIdListIsSet(true);
      }
      if (incoming.get(1)) {
        struct.exchangeMic = iprot.readString();
        struct.setExchangeMicIsSet(true);
      }
      if (incoming.get(2)) {
        struct.sledCommodityType = SledCommodityType.findByValue(iprot.readI32());
        struct.setSledCommodityTypeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.sledCommodityCode = iprot.readString();
        struct.setSledCommodityCodeIsSet(true);
      }
    }
  }

}

