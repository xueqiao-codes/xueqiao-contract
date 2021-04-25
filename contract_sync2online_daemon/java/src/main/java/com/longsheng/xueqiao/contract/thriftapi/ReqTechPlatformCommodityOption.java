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

public class ReqTechPlatformCommodityOption implements org.apache.thrift.TBase<ReqTechPlatformCommodityOption, ReqTechPlatformCommodityOption._Fields>, java.io.Serializable, Cloneable, Comparable<ReqTechPlatformCommodityOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReqTechPlatformCommodityOption");

  private static final org.apache.thrift.protocol.TField TECH_PLATFORM_COMMODITY_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("techPlatformCommodityIds", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityIds", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField TECH_PLATFORM_FIELD_DESC = new org.apache.thrift.protocol.TField("techPlatform", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField TECH_PLATFORM_EXCHANGE_FIELD_DESC = new org.apache.thrift.protocol.TField("techPlatformExchange", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField TECH_PLATFORM_COMMODITY_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("techPlatformCommodityType", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField TECH_PLATFORM_COMMODITY_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("techPlatformCommodityCode", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReqTechPlatformCommodityOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReqTechPlatformCommodityOptionTupleSchemeFactory());
  }

  public List<Integer> techPlatformCommodityIds; // optional
  public List<Integer> sledCommodityIds; // optional
  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform
   */
  public com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform techPlatform; // optional
  public String techPlatformExchange; // optional
  public String techPlatformCommodityType; // optional
  public String techPlatformCommodityCode; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TECH_PLATFORM_COMMODITY_IDS((short)1, "techPlatformCommodityIds"),
    SLED_COMMODITY_IDS((short)2, "sledCommodityIds"),
    /**
     * 
     * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform
     */
    TECH_PLATFORM((short)3, "techPlatform"),
    TECH_PLATFORM_EXCHANGE((short)4, "techPlatformExchange"),
    TECH_PLATFORM_COMMODITY_TYPE((short)5, "techPlatformCommodityType"),
    TECH_PLATFORM_COMMODITY_CODE((short)6, "techPlatformCommodityCode");

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
        case 1: // TECH_PLATFORM_COMMODITY_IDS
          return TECH_PLATFORM_COMMODITY_IDS;
        case 2: // SLED_COMMODITY_IDS
          return SLED_COMMODITY_IDS;
        case 3: // TECH_PLATFORM
          return TECH_PLATFORM;
        case 4: // TECH_PLATFORM_EXCHANGE
          return TECH_PLATFORM_EXCHANGE;
        case 5: // TECH_PLATFORM_COMMODITY_TYPE
          return TECH_PLATFORM_COMMODITY_TYPE;
        case 6: // TECH_PLATFORM_COMMODITY_CODE
          return TECH_PLATFORM_COMMODITY_CODE;
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
  private _Fields optionals[] = {_Fields.TECH_PLATFORM_COMMODITY_IDS,_Fields.SLED_COMMODITY_IDS,_Fields.TECH_PLATFORM,_Fields.TECH_PLATFORM_EXCHANGE,_Fields.TECH_PLATFORM_COMMODITY_TYPE,_Fields.TECH_PLATFORM_COMMODITY_CODE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TECH_PLATFORM_COMMODITY_IDS, new org.apache.thrift.meta_data.FieldMetaData("techPlatformCommodityIds", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.SLED_COMMODITY_IDS, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityIds", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.TECH_PLATFORM, new org.apache.thrift.meta_data.FieldMetaData("techPlatform", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform.class)));
    tmpMap.put(_Fields.TECH_PLATFORM_EXCHANGE, new org.apache.thrift.meta_data.FieldMetaData("techPlatformExchange", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TECH_PLATFORM_COMMODITY_TYPE, new org.apache.thrift.meta_data.FieldMetaData("techPlatformCommodityType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TECH_PLATFORM_COMMODITY_CODE, new org.apache.thrift.meta_data.FieldMetaData("techPlatformCommodityCode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReqTechPlatformCommodityOption.class, metaDataMap);
  }

  public ReqTechPlatformCommodityOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReqTechPlatformCommodityOption(ReqTechPlatformCommodityOption other) {
    if (other.isSetTechPlatformCommodityIds()) {
      List<Integer> __this__techPlatformCommodityIds = new ArrayList<Integer>(other.techPlatformCommodityIds);
      this.techPlatformCommodityIds = __this__techPlatformCommodityIds;
    }
    if (other.isSetSledCommodityIds()) {
      List<Integer> __this__sledCommodityIds = new ArrayList<Integer>(other.sledCommodityIds);
      this.sledCommodityIds = __this__sledCommodityIds;
    }
    if (other.isSetTechPlatform()) {
      this.techPlatform = other.techPlatform;
    }
    if (other.isSetTechPlatformExchange()) {
      this.techPlatformExchange = other.techPlatformExchange;
    }
    if (other.isSetTechPlatformCommodityType()) {
      this.techPlatformCommodityType = other.techPlatformCommodityType;
    }
    if (other.isSetTechPlatformCommodityCode()) {
      this.techPlatformCommodityCode = other.techPlatformCommodityCode;
    }
  }

  public ReqTechPlatformCommodityOption deepCopy() {
    return new ReqTechPlatformCommodityOption(this);
  }

  @Override
  public void clear() {
    this.techPlatformCommodityIds = null;
    this.sledCommodityIds = null;
    this.techPlatform = null;
    this.techPlatformExchange = null;
    this.techPlatformCommodityType = null;
    this.techPlatformCommodityCode = null;
  }

  public int getTechPlatformCommodityIdsSize() {
    return (this.techPlatformCommodityIds == null) ? 0 : this.techPlatformCommodityIds.size();
  }

  public java.util.Iterator<Integer> getTechPlatformCommodityIdsIterator() {
    return (this.techPlatformCommodityIds == null) ? null : this.techPlatformCommodityIds.iterator();
  }

  public void addToTechPlatformCommodityIds(int elem) {
    if (this.techPlatformCommodityIds == null) {
      this.techPlatformCommodityIds = new ArrayList<Integer>();
    }
    this.techPlatformCommodityIds.add(elem);
  }

  public List<Integer> getTechPlatformCommodityIds() {
    return this.techPlatformCommodityIds;
  }

  public ReqTechPlatformCommodityOption setTechPlatformCommodityIds(List<Integer> techPlatformCommodityIds) {
    this.techPlatformCommodityIds = techPlatformCommodityIds;
    return this;
  }

  public void unsetTechPlatformCommodityIds() {
    this.techPlatformCommodityIds = null;
  }

  /** Returns true if field techPlatformCommodityIds is set (has been assigned a value) and false otherwise */
  public boolean isSetTechPlatformCommodityIds() {
    return this.techPlatformCommodityIds != null;
  }

  public void setTechPlatformCommodityIdsIsSet(boolean value) {
    if (!value) {
      this.techPlatformCommodityIds = null;
    }
  }

  public int getSledCommodityIdsSize() {
    return (this.sledCommodityIds == null) ? 0 : this.sledCommodityIds.size();
  }

  public java.util.Iterator<Integer> getSledCommodityIdsIterator() {
    return (this.sledCommodityIds == null) ? null : this.sledCommodityIds.iterator();
  }

  public void addToSledCommodityIds(int elem) {
    if (this.sledCommodityIds == null) {
      this.sledCommodityIds = new ArrayList<Integer>();
    }
    this.sledCommodityIds.add(elem);
  }

  public List<Integer> getSledCommodityIds() {
    return this.sledCommodityIds;
  }

  public ReqTechPlatformCommodityOption setSledCommodityIds(List<Integer> sledCommodityIds) {
    this.sledCommodityIds = sledCommodityIds;
    return this;
  }

  public void unsetSledCommodityIds() {
    this.sledCommodityIds = null;
  }

  /** Returns true if field sledCommodityIds is set (has been assigned a value) and false otherwise */
  public boolean isSetSledCommodityIds() {
    return this.sledCommodityIds != null;
  }

  public void setSledCommodityIdsIsSet(boolean value) {
    if (!value) {
      this.sledCommodityIds = null;
    }
  }

  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform
   */
  public com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform getTechPlatform() {
    return this.techPlatform;
  }

  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform
   */
  public ReqTechPlatformCommodityOption setTechPlatform(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform techPlatform) {
    this.techPlatform = techPlatform;
    return this;
  }

  public void unsetTechPlatform() {
    this.techPlatform = null;
  }

  /** Returns true if field techPlatform is set (has been assigned a value) and false otherwise */
  public boolean isSetTechPlatform() {
    return this.techPlatform != null;
  }

  public void setTechPlatformIsSet(boolean value) {
    if (!value) {
      this.techPlatform = null;
    }
  }

  public String getTechPlatformExchange() {
    return this.techPlatformExchange;
  }

  public ReqTechPlatformCommodityOption setTechPlatformExchange(String techPlatformExchange) {
    this.techPlatformExchange = techPlatformExchange;
    return this;
  }

  public void unsetTechPlatformExchange() {
    this.techPlatformExchange = null;
  }

  /** Returns true if field techPlatformExchange is set (has been assigned a value) and false otherwise */
  public boolean isSetTechPlatformExchange() {
    return this.techPlatformExchange != null;
  }

  public void setTechPlatformExchangeIsSet(boolean value) {
    if (!value) {
      this.techPlatformExchange = null;
    }
  }

  public String getTechPlatformCommodityType() {
    return this.techPlatformCommodityType;
  }

  public ReqTechPlatformCommodityOption setTechPlatformCommodityType(String techPlatformCommodityType) {
    this.techPlatformCommodityType = techPlatformCommodityType;
    return this;
  }

  public void unsetTechPlatformCommodityType() {
    this.techPlatformCommodityType = null;
  }

  /** Returns true if field techPlatformCommodityType is set (has been assigned a value) and false otherwise */
  public boolean isSetTechPlatformCommodityType() {
    return this.techPlatformCommodityType != null;
  }

  public void setTechPlatformCommodityTypeIsSet(boolean value) {
    if (!value) {
      this.techPlatformCommodityType = null;
    }
  }

  public String getTechPlatformCommodityCode() {
    return this.techPlatformCommodityCode;
  }

  public ReqTechPlatformCommodityOption setTechPlatformCommodityCode(String techPlatformCommodityCode) {
    this.techPlatformCommodityCode = techPlatformCommodityCode;
    return this;
  }

  public void unsetTechPlatformCommodityCode() {
    this.techPlatformCommodityCode = null;
  }

  /** Returns true if field techPlatformCommodityCode is set (has been assigned a value) and false otherwise */
  public boolean isSetTechPlatformCommodityCode() {
    return this.techPlatformCommodityCode != null;
  }

  public void setTechPlatformCommodityCodeIsSet(boolean value) {
    if (!value) {
      this.techPlatformCommodityCode = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TECH_PLATFORM_COMMODITY_IDS:
      if (value == null) {
        unsetTechPlatformCommodityIds();
      } else {
        setTechPlatformCommodityIds((List<Integer>)value);
      }
      break;

    case SLED_COMMODITY_IDS:
      if (value == null) {
        unsetSledCommodityIds();
      } else {
        setSledCommodityIds((List<Integer>)value);
      }
      break;

    case TECH_PLATFORM:
      if (value == null) {
        unsetTechPlatform();
      } else {
        setTechPlatform((com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform)value);
      }
      break;

    case TECH_PLATFORM_EXCHANGE:
      if (value == null) {
        unsetTechPlatformExchange();
      } else {
        setTechPlatformExchange((String)value);
      }
      break;

    case TECH_PLATFORM_COMMODITY_TYPE:
      if (value == null) {
        unsetTechPlatformCommodityType();
      } else {
        setTechPlatformCommodityType((String)value);
      }
      break;

    case TECH_PLATFORM_COMMODITY_CODE:
      if (value == null) {
        unsetTechPlatformCommodityCode();
      } else {
        setTechPlatformCommodityCode((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TECH_PLATFORM_COMMODITY_IDS:
      return getTechPlatformCommodityIds();

    case SLED_COMMODITY_IDS:
      return getSledCommodityIds();

    case TECH_PLATFORM:
      return getTechPlatform();

    case TECH_PLATFORM_EXCHANGE:
      return getTechPlatformExchange();

    case TECH_PLATFORM_COMMODITY_TYPE:
      return getTechPlatformCommodityType();

    case TECH_PLATFORM_COMMODITY_CODE:
      return getTechPlatformCommodityCode();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TECH_PLATFORM_COMMODITY_IDS:
      return isSetTechPlatformCommodityIds();
    case SLED_COMMODITY_IDS:
      return isSetSledCommodityIds();
    case TECH_PLATFORM:
      return isSetTechPlatform();
    case TECH_PLATFORM_EXCHANGE:
      return isSetTechPlatformExchange();
    case TECH_PLATFORM_COMMODITY_TYPE:
      return isSetTechPlatformCommodityType();
    case TECH_PLATFORM_COMMODITY_CODE:
      return isSetTechPlatformCommodityCode();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReqTechPlatformCommodityOption)
      return this.equals((ReqTechPlatformCommodityOption)that);
    return false;
  }

  public boolean equals(ReqTechPlatformCommodityOption that) {
    if (that == null)
      return false;

    boolean this_present_techPlatformCommodityIds = true && this.isSetTechPlatformCommodityIds();
    boolean that_present_techPlatformCommodityIds = true && that.isSetTechPlatformCommodityIds();
    if (this_present_techPlatformCommodityIds || that_present_techPlatformCommodityIds) {
      if (!(this_present_techPlatformCommodityIds && that_present_techPlatformCommodityIds))
        return false;
      if (!this.techPlatformCommodityIds.equals(that.techPlatformCommodityIds))
        return false;
    }

    boolean this_present_sledCommodityIds = true && this.isSetSledCommodityIds();
    boolean that_present_sledCommodityIds = true && that.isSetSledCommodityIds();
    if (this_present_sledCommodityIds || that_present_sledCommodityIds) {
      if (!(this_present_sledCommodityIds && that_present_sledCommodityIds))
        return false;
      if (!this.sledCommodityIds.equals(that.sledCommodityIds))
        return false;
    }

    boolean this_present_techPlatform = true && this.isSetTechPlatform();
    boolean that_present_techPlatform = true && that.isSetTechPlatform();
    if (this_present_techPlatform || that_present_techPlatform) {
      if (!(this_present_techPlatform && that_present_techPlatform))
        return false;
      if (!this.techPlatform.equals(that.techPlatform))
        return false;
    }

    boolean this_present_techPlatformExchange = true && this.isSetTechPlatformExchange();
    boolean that_present_techPlatformExchange = true && that.isSetTechPlatformExchange();
    if (this_present_techPlatformExchange || that_present_techPlatformExchange) {
      if (!(this_present_techPlatformExchange && that_present_techPlatformExchange))
        return false;
      if (!this.techPlatformExchange.equals(that.techPlatformExchange))
        return false;
    }

    boolean this_present_techPlatformCommodityType = true && this.isSetTechPlatformCommodityType();
    boolean that_present_techPlatformCommodityType = true && that.isSetTechPlatformCommodityType();
    if (this_present_techPlatformCommodityType || that_present_techPlatformCommodityType) {
      if (!(this_present_techPlatformCommodityType && that_present_techPlatformCommodityType))
        return false;
      if (!this.techPlatformCommodityType.equals(that.techPlatformCommodityType))
        return false;
    }

    boolean this_present_techPlatformCommodityCode = true && this.isSetTechPlatformCommodityCode();
    boolean that_present_techPlatformCommodityCode = true && that.isSetTechPlatformCommodityCode();
    if (this_present_techPlatformCommodityCode || that_present_techPlatformCommodityCode) {
      if (!(this_present_techPlatformCommodityCode && that_present_techPlatformCommodityCode))
        return false;
      if (!this.techPlatformCommodityCode.equals(that.techPlatformCommodityCode))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ReqTechPlatformCommodityOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTechPlatformCommodityIds()).compareTo(other.isSetTechPlatformCommodityIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTechPlatformCommodityIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.techPlatformCommodityIds, other.techPlatformCommodityIds);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSledCommodityIds()).compareTo(other.isSetSledCommodityIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledCommodityIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledCommodityIds, other.sledCommodityIds);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTechPlatform()).compareTo(other.isSetTechPlatform());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTechPlatform()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.techPlatform, other.techPlatform);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTechPlatformExchange()).compareTo(other.isSetTechPlatformExchange());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTechPlatformExchange()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.techPlatformExchange, other.techPlatformExchange);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTechPlatformCommodityType()).compareTo(other.isSetTechPlatformCommodityType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTechPlatformCommodityType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.techPlatformCommodityType, other.techPlatformCommodityType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTechPlatformCommodityCode()).compareTo(other.isSetTechPlatformCommodityCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTechPlatformCommodityCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.techPlatformCommodityCode, other.techPlatformCommodityCode);
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
    StringBuilder sb = new StringBuilder("ReqTechPlatformCommodityOption(");
    boolean first = true;

    if (isSetTechPlatformCommodityIds()) {
      sb.append("techPlatformCommodityIds:");
      if (this.techPlatformCommodityIds == null) {
        sb.append("null");
      } else {
        sb.append(this.techPlatformCommodityIds);
      }
      first = false;
    }
    if (isSetSledCommodityIds()) {
      if (!first) sb.append(", ");
      sb.append("sledCommodityIds:");
      if (this.sledCommodityIds == null) {
        sb.append("null");
      } else {
        sb.append(this.sledCommodityIds);
      }
      first = false;
    }
    if (isSetTechPlatform()) {
      if (!first) sb.append(", ");
      sb.append("techPlatform:");
      if (this.techPlatform == null) {
        sb.append("null");
      } else {
        sb.append(this.techPlatform);
      }
      first = false;
    }
    if (isSetTechPlatformExchange()) {
      if (!first) sb.append(", ");
      sb.append("techPlatformExchange:");
      if (this.techPlatformExchange == null) {
        sb.append("null");
      } else {
        sb.append(this.techPlatformExchange);
      }
      first = false;
    }
    if (isSetTechPlatformCommodityType()) {
      if (!first) sb.append(", ");
      sb.append("techPlatformCommodityType:");
      if (this.techPlatformCommodityType == null) {
        sb.append("null");
      } else {
        sb.append(this.techPlatformCommodityType);
      }
      first = false;
    }
    if (isSetTechPlatformCommodityCode()) {
      if (!first) sb.append(", ");
      sb.append("techPlatformCommodityCode:");
      if (this.techPlatformCommodityCode == null) {
        sb.append("null");
      } else {
        sb.append(this.techPlatformCommodityCode);
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

  private static class ReqTechPlatformCommodityOptionStandardSchemeFactory implements SchemeFactory {
    public ReqTechPlatformCommodityOptionStandardScheme getScheme() {
      return new ReqTechPlatformCommodityOptionStandardScheme();
    }
  }

  private static class ReqTechPlatformCommodityOptionStandardScheme extends StandardScheme<ReqTechPlatformCommodityOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReqTechPlatformCommodityOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TECH_PLATFORM_COMMODITY_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list176 = iprot.readListBegin();
                struct.techPlatformCommodityIds = new ArrayList<Integer>(_list176.size);
                for (int _i177 = 0; _i177 < _list176.size; ++_i177)
                {
                  int _elem178;
                  _elem178 = iprot.readI32();
                  struct.techPlatformCommodityIds.add(_elem178);
                }
                iprot.readListEnd();
              }
              struct.setTechPlatformCommodityIdsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SLED_COMMODITY_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list179 = iprot.readListBegin();
                struct.sledCommodityIds = new ArrayList<Integer>(_list179.size);
                for (int _i180 = 0; _i180 < _list179.size; ++_i180)
                {
                  int _elem181;
                  _elem181 = iprot.readI32();
                  struct.sledCommodityIds.add(_elem181);
                }
                iprot.readListEnd();
              }
              struct.setSledCommodityIdsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TECH_PLATFORM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.techPlatform = com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform.findByValue(iprot.readI32());
              struct.setTechPlatformIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TECH_PLATFORM_EXCHANGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.techPlatformExchange = iprot.readString();
              struct.setTechPlatformExchangeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TECH_PLATFORM_COMMODITY_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.techPlatformCommodityType = iprot.readString();
              struct.setTechPlatformCommodityTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // TECH_PLATFORM_COMMODITY_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.techPlatformCommodityCode = iprot.readString();
              struct.setTechPlatformCommodityCodeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReqTechPlatformCommodityOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.techPlatformCommodityIds != null) {
        if (struct.isSetTechPlatformCommodityIds()) {
          oprot.writeFieldBegin(TECH_PLATFORM_COMMODITY_IDS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.techPlatformCommodityIds.size()));
            for (int _iter182 : struct.techPlatformCommodityIds)
            {
              oprot.writeI32(_iter182);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.sledCommodityIds != null) {
        if (struct.isSetSledCommodityIds()) {
          oprot.writeFieldBegin(SLED_COMMODITY_IDS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.sledCommodityIds.size()));
            for (int _iter183 : struct.sledCommodityIds)
            {
              oprot.writeI32(_iter183);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.techPlatform != null) {
        if (struct.isSetTechPlatform()) {
          oprot.writeFieldBegin(TECH_PLATFORM_FIELD_DESC);
          oprot.writeI32(struct.techPlatform.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.techPlatformExchange != null) {
        if (struct.isSetTechPlatformExchange()) {
          oprot.writeFieldBegin(TECH_PLATFORM_EXCHANGE_FIELD_DESC);
          oprot.writeString(struct.techPlatformExchange);
          oprot.writeFieldEnd();
        }
      }
      if (struct.techPlatformCommodityType != null) {
        if (struct.isSetTechPlatformCommodityType()) {
          oprot.writeFieldBegin(TECH_PLATFORM_COMMODITY_TYPE_FIELD_DESC);
          oprot.writeString(struct.techPlatformCommodityType);
          oprot.writeFieldEnd();
        }
      }
      if (struct.techPlatformCommodityCode != null) {
        if (struct.isSetTechPlatformCommodityCode()) {
          oprot.writeFieldBegin(TECH_PLATFORM_COMMODITY_CODE_FIELD_DESC);
          oprot.writeString(struct.techPlatformCommodityCode);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ReqTechPlatformCommodityOptionTupleSchemeFactory implements SchemeFactory {
    public ReqTechPlatformCommodityOptionTupleScheme getScheme() {
      return new ReqTechPlatformCommodityOptionTupleScheme();
    }
  }

  private static class ReqTechPlatformCommodityOptionTupleScheme extends TupleScheme<ReqTechPlatformCommodityOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReqTechPlatformCommodityOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTechPlatformCommodityIds()) {
        optionals.set(0);
      }
      if (struct.isSetSledCommodityIds()) {
        optionals.set(1);
      }
      if (struct.isSetTechPlatform()) {
        optionals.set(2);
      }
      if (struct.isSetTechPlatformExchange()) {
        optionals.set(3);
      }
      if (struct.isSetTechPlatformCommodityType()) {
        optionals.set(4);
      }
      if (struct.isSetTechPlatformCommodityCode()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetTechPlatformCommodityIds()) {
        {
          oprot.writeI32(struct.techPlatformCommodityIds.size());
          for (int _iter184 : struct.techPlatformCommodityIds)
          {
            oprot.writeI32(_iter184);
          }
        }
      }
      if (struct.isSetSledCommodityIds()) {
        {
          oprot.writeI32(struct.sledCommodityIds.size());
          for (int _iter185 : struct.sledCommodityIds)
          {
            oprot.writeI32(_iter185);
          }
        }
      }
      if (struct.isSetTechPlatform()) {
        oprot.writeI32(struct.techPlatform.getValue());
      }
      if (struct.isSetTechPlatformExchange()) {
        oprot.writeString(struct.techPlatformExchange);
      }
      if (struct.isSetTechPlatformCommodityType()) {
        oprot.writeString(struct.techPlatformCommodityType);
      }
      if (struct.isSetTechPlatformCommodityCode()) {
        oprot.writeString(struct.techPlatformCommodityCode);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReqTechPlatformCommodityOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list186 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.techPlatformCommodityIds = new ArrayList<Integer>(_list186.size);
          for (int _i187 = 0; _i187 < _list186.size; ++_i187)
          {
            int _elem188;
            _elem188 = iprot.readI32();
            struct.techPlatformCommodityIds.add(_elem188);
          }
        }
        struct.setTechPlatformCommodityIdsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list189 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.sledCommodityIds = new ArrayList<Integer>(_list189.size);
          for (int _i190 = 0; _i190 < _list189.size; ++_i190)
          {
            int _elem191;
            _elem191 = iprot.readI32();
            struct.sledCommodityIds.add(_elem191);
          }
        }
        struct.setSledCommodityIdsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.techPlatform = com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform.findByValue(iprot.readI32());
        struct.setTechPlatformIsSet(true);
      }
      if (incoming.get(3)) {
        struct.techPlatformExchange = iprot.readString();
        struct.setTechPlatformExchangeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.techPlatformCommodityType = iprot.readString();
        struct.setTechPlatformCommodityTypeIsSet(true);
      }
      if (incoming.get(5)) {
        struct.techPlatformCommodityCode = iprot.readString();
        struct.setTechPlatformCommodityCodeIsSet(true);
      }
    }
  }

}
