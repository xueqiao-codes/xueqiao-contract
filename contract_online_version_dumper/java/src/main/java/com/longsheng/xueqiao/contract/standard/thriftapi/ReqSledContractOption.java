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

public class ReqSledContractOption implements org.apache.thrift.TBase<ReqSledContractOption, ReqSledContractOption._Fields>, java.io.Serializable, Cloneable, Comparable<ReqSledContractOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReqSledContractOption");

  private static final org.apache.thrift.protocol.TField SLED_CONTRACT_ID_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("sledContractIdList", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField PLATFORM_ENV_FIELD_DESC = new org.apache.thrift.protocol.TField("platformEnv", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField SLED_CONTRACT_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("sledContractCode", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField CONTRACT_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("contractStatus", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReqSledContractOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReqSledContractOptionTupleSchemeFactory());
  }

  public List<Integer> sledContractIdList; // optional
  public int sledCommodityId; // optional
  /**
   * 
   * @see TechPlatformEnv
   */
  public TechPlatformEnv platformEnv; // optional
  public String sledContractCode; // optional
  /**
   * 
   * @see ContractStatus
   */
  public ContractStatus contractStatus; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLED_CONTRACT_ID_LIST((short)1, "sledContractIdList"),
    SLED_COMMODITY_ID((short)2, "sledCommodityId"),
    /**
     * 
     * @see TechPlatformEnv
     */
    PLATFORM_ENV((short)3, "platformEnv"),
    SLED_CONTRACT_CODE((short)4, "sledContractCode"),
    /**
     * 
     * @see ContractStatus
     */
    CONTRACT_STATUS((short)5, "contractStatus");

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
        case 1: // SLED_CONTRACT_ID_LIST
          return SLED_CONTRACT_ID_LIST;
        case 2: // SLED_COMMODITY_ID
          return SLED_COMMODITY_ID;
        case 3: // PLATFORM_ENV
          return PLATFORM_ENV;
        case 4: // SLED_CONTRACT_CODE
          return SLED_CONTRACT_CODE;
        case 5: // CONTRACT_STATUS
          return CONTRACT_STATUS;
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
  private _Fields optionals[] = {_Fields.SLED_CONTRACT_ID_LIST,_Fields.SLED_COMMODITY_ID,_Fields.PLATFORM_ENV,_Fields.SLED_CONTRACT_CODE,_Fields.CONTRACT_STATUS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLED_CONTRACT_ID_LIST, new org.apache.thrift.meta_data.FieldMetaData("sledContractIdList", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.SLED_COMMODITY_ID, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PLATFORM_ENV, new org.apache.thrift.meta_data.FieldMetaData("platformEnv", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TechPlatformEnv.class)));
    tmpMap.put(_Fields.SLED_CONTRACT_CODE, new org.apache.thrift.meta_data.FieldMetaData("sledContractCode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CONTRACT_STATUS, new org.apache.thrift.meta_data.FieldMetaData("contractStatus", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ContractStatus.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReqSledContractOption.class, metaDataMap);
  }

  public ReqSledContractOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReqSledContractOption(ReqSledContractOption other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetSledContractIdList()) {
      List<Integer> __this__sledContractIdList = new ArrayList<Integer>(other.sledContractIdList);
      this.sledContractIdList = __this__sledContractIdList;
    }
    this.sledCommodityId = other.sledCommodityId;
    if (other.isSetPlatformEnv()) {
      this.platformEnv = other.platformEnv;
    }
    if (other.isSetSledContractCode()) {
      this.sledContractCode = other.sledContractCode;
    }
    if (other.isSetContractStatus()) {
      this.contractStatus = other.contractStatus;
    }
  }

  public ReqSledContractOption deepCopy() {
    return new ReqSledContractOption(this);
  }

  @Override
  public void clear() {
    this.sledContractIdList = null;
    setSledCommodityIdIsSet(false);
    this.sledCommodityId = 0;
    this.platformEnv = null;
    this.sledContractCode = null;
    this.contractStatus = null;
  }

  public int getSledContractIdListSize() {
    return (this.sledContractIdList == null) ? 0 : this.sledContractIdList.size();
  }

  public java.util.Iterator<Integer> getSledContractIdListIterator() {
    return (this.sledContractIdList == null) ? null : this.sledContractIdList.iterator();
  }

  public void addToSledContractIdList(int elem) {
    if (this.sledContractIdList == null) {
      this.sledContractIdList = new ArrayList<Integer>();
    }
    this.sledContractIdList.add(elem);
  }

  public List<Integer> getSledContractIdList() {
    return this.sledContractIdList;
  }

  public ReqSledContractOption setSledContractIdList(List<Integer> sledContractIdList) {
    this.sledContractIdList = sledContractIdList;
    return this;
  }

  public void unsetSledContractIdList() {
    this.sledContractIdList = null;
  }

  /** Returns true if field sledContractIdList is set (has been assigned a value) and false otherwise */
  public boolean isSetSledContractIdList() {
    return this.sledContractIdList != null;
  }

  public void setSledContractIdListIsSet(boolean value) {
    if (!value) {
      this.sledContractIdList = null;
    }
  }

  public int getSledCommodityId() {
    return this.sledCommodityId;
  }

  public ReqSledContractOption setSledCommodityId(int sledCommodityId) {
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

  /**
   * 
   * @see TechPlatformEnv
   */
  public TechPlatformEnv getPlatformEnv() {
    return this.platformEnv;
  }

  /**
   * 
   * @see TechPlatformEnv
   */
  public ReqSledContractOption setPlatformEnv(TechPlatformEnv platformEnv) {
    this.platformEnv = platformEnv;
    return this;
  }

  public void unsetPlatformEnv() {
    this.platformEnv = null;
  }

  /** Returns true if field platformEnv is set (has been assigned a value) and false otherwise */
  public boolean isSetPlatformEnv() {
    return this.platformEnv != null;
  }

  public void setPlatformEnvIsSet(boolean value) {
    if (!value) {
      this.platformEnv = null;
    }
  }

  public String getSledContractCode() {
    return this.sledContractCode;
  }

  public ReqSledContractOption setSledContractCode(String sledContractCode) {
    this.sledContractCode = sledContractCode;
    return this;
  }

  public void unsetSledContractCode() {
    this.sledContractCode = null;
  }

  /** Returns true if field sledContractCode is set (has been assigned a value) and false otherwise */
  public boolean isSetSledContractCode() {
    return this.sledContractCode != null;
  }

  public void setSledContractCodeIsSet(boolean value) {
    if (!value) {
      this.sledContractCode = null;
    }
  }

  /**
   * 
   * @see ContractStatus
   */
  public ContractStatus getContractStatus() {
    return this.contractStatus;
  }

  /**
   * 
   * @see ContractStatus
   */
  public ReqSledContractOption setContractStatus(ContractStatus contractStatus) {
    this.contractStatus = contractStatus;
    return this;
  }

  public void unsetContractStatus() {
    this.contractStatus = null;
  }

  /** Returns true if field contractStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetContractStatus() {
    return this.contractStatus != null;
  }

  public void setContractStatusIsSet(boolean value) {
    if (!value) {
      this.contractStatus = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SLED_CONTRACT_ID_LIST:
      if (value == null) {
        unsetSledContractIdList();
      } else {
        setSledContractIdList((List<Integer>)value);
      }
      break;

    case SLED_COMMODITY_ID:
      if (value == null) {
        unsetSledCommodityId();
      } else {
        setSledCommodityId((Integer)value);
      }
      break;

    case PLATFORM_ENV:
      if (value == null) {
        unsetPlatformEnv();
      } else {
        setPlatformEnv((TechPlatformEnv)value);
      }
      break;

    case SLED_CONTRACT_CODE:
      if (value == null) {
        unsetSledContractCode();
      } else {
        setSledContractCode((String)value);
      }
      break;

    case CONTRACT_STATUS:
      if (value == null) {
        unsetContractStatus();
      } else {
        setContractStatus((ContractStatus)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SLED_CONTRACT_ID_LIST:
      return getSledContractIdList();

    case SLED_COMMODITY_ID:
      return Integer.valueOf(getSledCommodityId());

    case PLATFORM_ENV:
      return getPlatformEnv();

    case SLED_CONTRACT_CODE:
      return getSledContractCode();

    case CONTRACT_STATUS:
      return getContractStatus();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SLED_CONTRACT_ID_LIST:
      return isSetSledContractIdList();
    case SLED_COMMODITY_ID:
      return isSetSledCommodityId();
    case PLATFORM_ENV:
      return isSetPlatformEnv();
    case SLED_CONTRACT_CODE:
      return isSetSledContractCode();
    case CONTRACT_STATUS:
      return isSetContractStatus();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReqSledContractOption)
      return this.equals((ReqSledContractOption)that);
    return false;
  }

  public boolean equals(ReqSledContractOption that) {
    if (that == null)
      return false;

    boolean this_present_sledContractIdList = true && this.isSetSledContractIdList();
    boolean that_present_sledContractIdList = true && that.isSetSledContractIdList();
    if (this_present_sledContractIdList || that_present_sledContractIdList) {
      if (!(this_present_sledContractIdList && that_present_sledContractIdList))
        return false;
      if (!this.sledContractIdList.equals(that.sledContractIdList))
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

    boolean this_present_platformEnv = true && this.isSetPlatformEnv();
    boolean that_present_platformEnv = true && that.isSetPlatformEnv();
    if (this_present_platformEnv || that_present_platformEnv) {
      if (!(this_present_platformEnv && that_present_platformEnv))
        return false;
      if (!this.platformEnv.equals(that.platformEnv))
        return false;
    }

    boolean this_present_sledContractCode = true && this.isSetSledContractCode();
    boolean that_present_sledContractCode = true && that.isSetSledContractCode();
    if (this_present_sledContractCode || that_present_sledContractCode) {
      if (!(this_present_sledContractCode && that_present_sledContractCode))
        return false;
      if (!this.sledContractCode.equals(that.sledContractCode))
        return false;
    }

    boolean this_present_contractStatus = true && this.isSetContractStatus();
    boolean that_present_contractStatus = true && that.isSetContractStatus();
    if (this_present_contractStatus || that_present_contractStatus) {
      if (!(this_present_contractStatus && that_present_contractStatus))
        return false;
      if (!this.contractStatus.equals(that.contractStatus))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ReqSledContractOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSledContractIdList()).compareTo(other.isSetSledContractIdList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledContractIdList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledContractIdList, other.sledContractIdList);
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
    lastComparison = Boolean.valueOf(isSetPlatformEnv()).compareTo(other.isSetPlatformEnv());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlatformEnv()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.platformEnv, other.platformEnv);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSledContractCode()).compareTo(other.isSetSledContractCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledContractCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledContractCode, other.sledContractCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetContractStatus()).compareTo(other.isSetContractStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContractStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.contractStatus, other.contractStatus);
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
    StringBuilder sb = new StringBuilder("ReqSledContractOption(");
    boolean first = true;

    if (isSetSledContractIdList()) {
      sb.append("sledContractIdList:");
      if (this.sledContractIdList == null) {
        sb.append("null");
      } else {
        sb.append(this.sledContractIdList);
      }
      first = false;
    }
    if (isSetSledCommodityId()) {
      if (!first) sb.append(", ");
      sb.append("sledCommodityId:");
      sb.append(this.sledCommodityId);
      first = false;
    }
    if (isSetPlatformEnv()) {
      if (!first) sb.append(", ");
      sb.append("platformEnv:");
      if (this.platformEnv == null) {
        sb.append("null");
      } else {
        sb.append(this.platformEnv);
      }
      first = false;
    }
    if (isSetSledContractCode()) {
      if (!first) sb.append(", ");
      sb.append("sledContractCode:");
      if (this.sledContractCode == null) {
        sb.append("null");
      } else {
        sb.append(this.sledContractCode);
      }
      first = false;
    }
    if (isSetContractStatus()) {
      if (!first) sb.append(", ");
      sb.append("contractStatus:");
      if (this.contractStatus == null) {
        sb.append("null");
      } else {
        sb.append(this.contractStatus);
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

  private static class ReqSledContractOptionStandardSchemeFactory implements SchemeFactory {
    public ReqSledContractOptionStandardScheme getScheme() {
      return new ReqSledContractOptionStandardScheme();
    }
  }

  private static class ReqSledContractOptionStandardScheme extends StandardScheme<ReqSledContractOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReqSledContractOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SLED_CONTRACT_ID_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list56 = iprot.readListBegin();
                struct.sledContractIdList = new ArrayList<Integer>(_list56.size);
                for (int _i57 = 0; _i57 < _list56.size; ++_i57)
                {
                  int _elem58;
                  _elem58 = iprot.readI32();
                  struct.sledContractIdList.add(_elem58);
                }
                iprot.readListEnd();
              }
              struct.setSledContractIdListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SLED_COMMODITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledCommodityId = iprot.readI32();
              struct.setSledCommodityIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PLATFORM_ENV
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.platformEnv = TechPlatformEnv.findByValue(iprot.readI32());
              struct.setPlatformEnvIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SLED_CONTRACT_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sledContractCode = iprot.readString();
              struct.setSledContractCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // CONTRACT_STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.contractStatus = ContractStatus.findByValue(iprot.readI32());
              struct.setContractStatusIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReqSledContractOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sledContractIdList != null) {
        if (struct.isSetSledContractIdList()) {
          oprot.writeFieldBegin(SLED_CONTRACT_ID_LIST_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.sledContractIdList.size()));
            for (int _iter59 : struct.sledContractIdList)
            {
              oprot.writeI32(_iter59);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetSledCommodityId()) {
        oprot.writeFieldBegin(SLED_COMMODITY_ID_FIELD_DESC);
        oprot.writeI32(struct.sledCommodityId);
        oprot.writeFieldEnd();
      }
      if (struct.platformEnv != null) {
        if (struct.isSetPlatformEnv()) {
          oprot.writeFieldBegin(PLATFORM_ENV_FIELD_DESC);
          oprot.writeI32(struct.platformEnv.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.sledContractCode != null) {
        if (struct.isSetSledContractCode()) {
          oprot.writeFieldBegin(SLED_CONTRACT_CODE_FIELD_DESC);
          oprot.writeString(struct.sledContractCode);
          oprot.writeFieldEnd();
        }
      }
      if (struct.contractStatus != null) {
        if (struct.isSetContractStatus()) {
          oprot.writeFieldBegin(CONTRACT_STATUS_FIELD_DESC);
          oprot.writeI32(struct.contractStatus.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ReqSledContractOptionTupleSchemeFactory implements SchemeFactory {
    public ReqSledContractOptionTupleScheme getScheme() {
      return new ReqSledContractOptionTupleScheme();
    }
  }

  private static class ReqSledContractOptionTupleScheme extends TupleScheme<ReqSledContractOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReqSledContractOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSledContractIdList()) {
        optionals.set(0);
      }
      if (struct.isSetSledCommodityId()) {
        optionals.set(1);
      }
      if (struct.isSetPlatformEnv()) {
        optionals.set(2);
      }
      if (struct.isSetSledContractCode()) {
        optionals.set(3);
      }
      if (struct.isSetContractStatus()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetSledContractIdList()) {
        {
          oprot.writeI32(struct.sledContractIdList.size());
          for (int _iter60 : struct.sledContractIdList)
          {
            oprot.writeI32(_iter60);
          }
        }
      }
      if (struct.isSetSledCommodityId()) {
        oprot.writeI32(struct.sledCommodityId);
      }
      if (struct.isSetPlatformEnv()) {
        oprot.writeI32(struct.platformEnv.getValue());
      }
      if (struct.isSetSledContractCode()) {
        oprot.writeString(struct.sledContractCode);
      }
      if (struct.isSetContractStatus()) {
        oprot.writeI32(struct.contractStatus.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReqSledContractOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list61 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.sledContractIdList = new ArrayList<Integer>(_list61.size);
          for (int _i62 = 0; _i62 < _list61.size; ++_i62)
          {
            int _elem63;
            _elem63 = iprot.readI32();
            struct.sledContractIdList.add(_elem63);
          }
        }
        struct.setSledContractIdListIsSet(true);
      }
      if (incoming.get(1)) {
        struct.sledCommodityId = iprot.readI32();
        struct.setSledCommodityIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.platformEnv = TechPlatformEnv.findByValue(iprot.readI32());
        struct.setPlatformEnvIsSet(true);
      }
      if (incoming.get(3)) {
        struct.sledContractCode = iprot.readString();
        struct.setSledContractCodeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.contractStatus = ContractStatus.findByValue(iprot.readI32());
        struct.setContractStatusIsSet(true);
      }
    }
  }

}

