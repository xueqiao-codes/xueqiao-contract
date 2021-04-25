/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.currency.thriftapi;

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

public class Currency implements org.apache.thrift.TBase<Currency, Currency._Fields>, java.io.Serializable, Cloneable, Comparable<Currency> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Currency");

  private static final org.apache.thrift.protocol.TField CURRENCY_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("currencyCode", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField EN_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("enName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField CN_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("cnName", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField SYMBOL_FIELD_DESC = new org.apache.thrift.protocol.TField("symbol", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField IS_BASE_CURRENCY_FIELD_DESC = new org.apache.thrift.protocol.TField("isBaseCurrency", org.apache.thrift.protocol.TType.BOOL, (short)6);
  private static final org.apache.thrift.protocol.TField CREATE_TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("createTimestamp", org.apache.thrift.protocol.TType.I64, (short)40);
  private static final org.apache.thrift.protocol.TField LAST_MODITY_TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("lastModityTimestamp", org.apache.thrift.protocol.TType.I64, (short)41);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CurrencyStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CurrencyTupleSchemeFactory());
  }

  public String currencyCode; // optional
  public String enName; // optional
  public String cnName; // optional
  public String symbol; // optional
  public boolean isBaseCurrency; // optional
  public long createTimestamp; // optional
  public long lastModityTimestamp; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CURRENCY_CODE((short)2, "currencyCode"),
    EN_NAME((short)3, "enName"),
    CN_NAME((short)4, "cnName"),
    SYMBOL((short)5, "symbol"),
    IS_BASE_CURRENCY((short)6, "isBaseCurrency"),
    CREATE_TIMESTAMP((short)40, "createTimestamp"),
    LAST_MODITY_TIMESTAMP((short)41, "lastModityTimestamp");

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
        case 2: // CURRENCY_CODE
          return CURRENCY_CODE;
        case 3: // EN_NAME
          return EN_NAME;
        case 4: // CN_NAME
          return CN_NAME;
        case 5: // SYMBOL
          return SYMBOL;
        case 6: // IS_BASE_CURRENCY
          return IS_BASE_CURRENCY;
        case 40: // CREATE_TIMESTAMP
          return CREATE_TIMESTAMP;
        case 41: // LAST_MODITY_TIMESTAMP
          return LAST_MODITY_TIMESTAMP;
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
  private static final int __ISBASECURRENCY_ISSET_ID = 0;
  private static final int __CREATETIMESTAMP_ISSET_ID = 1;
  private static final int __LASTMODITYTIMESTAMP_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.CURRENCY_CODE,_Fields.EN_NAME,_Fields.CN_NAME,_Fields.SYMBOL,_Fields.IS_BASE_CURRENCY,_Fields.CREATE_TIMESTAMP,_Fields.LAST_MODITY_TIMESTAMP};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CURRENCY_CODE, new org.apache.thrift.meta_data.FieldMetaData("currencyCode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EN_NAME, new org.apache.thrift.meta_data.FieldMetaData("enName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CN_NAME, new org.apache.thrift.meta_data.FieldMetaData("cnName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SYMBOL, new org.apache.thrift.meta_data.FieldMetaData("symbol", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.IS_BASE_CURRENCY, new org.apache.thrift.meta_data.FieldMetaData("isBaseCurrency", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.CREATE_TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("createTimestamp", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.LAST_MODITY_TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("lastModityTimestamp", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Currency.class, metaDataMap);
  }

  public Currency() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Currency(Currency other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetCurrencyCode()) {
      this.currencyCode = other.currencyCode;
    }
    if (other.isSetEnName()) {
      this.enName = other.enName;
    }
    if (other.isSetCnName()) {
      this.cnName = other.cnName;
    }
    if (other.isSetSymbol()) {
      this.symbol = other.symbol;
    }
    this.isBaseCurrency = other.isBaseCurrency;
    this.createTimestamp = other.createTimestamp;
    this.lastModityTimestamp = other.lastModityTimestamp;
  }

  public Currency deepCopy() {
    return new Currency(this);
  }

  @Override
  public void clear() {
    this.currencyCode = null;
    this.enName = null;
    this.cnName = null;
    this.symbol = null;
    setIsBaseCurrencyIsSet(false);
    this.isBaseCurrency = false;
    setCreateTimestampIsSet(false);
    this.createTimestamp = 0;
    setLastModityTimestampIsSet(false);
    this.lastModityTimestamp = 0;
  }

  public String getCurrencyCode() {
    return this.currencyCode;
  }

  public Currency setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  public void unsetCurrencyCode() {
    this.currencyCode = null;
  }

  /** Returns true if field currencyCode is set (has been assigned a value) and false otherwise */
  public boolean isSetCurrencyCode() {
    return this.currencyCode != null;
  }

  public void setCurrencyCodeIsSet(boolean value) {
    if (!value) {
      this.currencyCode = null;
    }
  }

  public String getEnName() {
    return this.enName;
  }

  public Currency setEnName(String enName) {
    this.enName = enName;
    return this;
  }

  public void unsetEnName() {
    this.enName = null;
  }

  /** Returns true if field enName is set (has been assigned a value) and false otherwise */
  public boolean isSetEnName() {
    return this.enName != null;
  }

  public void setEnNameIsSet(boolean value) {
    if (!value) {
      this.enName = null;
    }
  }

  public String getCnName() {
    return this.cnName;
  }

  public Currency setCnName(String cnName) {
    this.cnName = cnName;
    return this;
  }

  public void unsetCnName() {
    this.cnName = null;
  }

  /** Returns true if field cnName is set (has been assigned a value) and false otherwise */
  public boolean isSetCnName() {
    return this.cnName != null;
  }

  public void setCnNameIsSet(boolean value) {
    if (!value) {
      this.cnName = null;
    }
  }

  public String getSymbol() {
    return this.symbol;
  }

  public Currency setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public void unsetSymbol() {
    this.symbol = null;
  }

  /** Returns true if field symbol is set (has been assigned a value) and false otherwise */
  public boolean isSetSymbol() {
    return this.symbol != null;
  }

  public void setSymbolIsSet(boolean value) {
    if (!value) {
      this.symbol = null;
    }
  }

  public boolean isIsBaseCurrency() {
    return this.isBaseCurrency;
  }

  public Currency setIsBaseCurrency(boolean isBaseCurrency) {
    this.isBaseCurrency = isBaseCurrency;
    setIsBaseCurrencyIsSet(true);
    return this;
  }

  public void unsetIsBaseCurrency() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISBASECURRENCY_ISSET_ID);
  }

  /** Returns true if field isBaseCurrency is set (has been assigned a value) and false otherwise */
  public boolean isSetIsBaseCurrency() {
    return EncodingUtils.testBit(__isset_bitfield, __ISBASECURRENCY_ISSET_ID);
  }

  public void setIsBaseCurrencyIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISBASECURRENCY_ISSET_ID, value);
  }

  public long getCreateTimestamp() {
    return this.createTimestamp;
  }

  public Currency setCreateTimestamp(long createTimestamp) {
    this.createTimestamp = createTimestamp;
    setCreateTimestampIsSet(true);
    return this;
  }

  public void unsetCreateTimestamp() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CREATETIMESTAMP_ISSET_ID);
  }

  /** Returns true if field createTimestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetCreateTimestamp() {
    return EncodingUtils.testBit(__isset_bitfield, __CREATETIMESTAMP_ISSET_ID);
  }

  public void setCreateTimestampIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CREATETIMESTAMP_ISSET_ID, value);
  }

  public long getLastModityTimestamp() {
    return this.lastModityTimestamp;
  }

  public Currency setLastModityTimestamp(long lastModityTimestamp) {
    this.lastModityTimestamp = lastModityTimestamp;
    setLastModityTimestampIsSet(true);
    return this;
  }

  public void unsetLastModityTimestamp() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LASTMODITYTIMESTAMP_ISSET_ID);
  }

  /** Returns true if field lastModityTimestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetLastModityTimestamp() {
    return EncodingUtils.testBit(__isset_bitfield, __LASTMODITYTIMESTAMP_ISSET_ID);
  }

  public void setLastModityTimestampIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LASTMODITYTIMESTAMP_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CURRENCY_CODE:
      if (value == null) {
        unsetCurrencyCode();
      } else {
        setCurrencyCode((String)value);
      }
      break;

    case EN_NAME:
      if (value == null) {
        unsetEnName();
      } else {
        setEnName((String)value);
      }
      break;

    case CN_NAME:
      if (value == null) {
        unsetCnName();
      } else {
        setCnName((String)value);
      }
      break;

    case SYMBOL:
      if (value == null) {
        unsetSymbol();
      } else {
        setSymbol((String)value);
      }
      break;

    case IS_BASE_CURRENCY:
      if (value == null) {
        unsetIsBaseCurrency();
      } else {
        setIsBaseCurrency((Boolean)value);
      }
      break;

    case CREATE_TIMESTAMP:
      if (value == null) {
        unsetCreateTimestamp();
      } else {
        setCreateTimestamp((Long)value);
      }
      break;

    case LAST_MODITY_TIMESTAMP:
      if (value == null) {
        unsetLastModityTimestamp();
      } else {
        setLastModityTimestamp((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CURRENCY_CODE:
      return getCurrencyCode();

    case EN_NAME:
      return getEnName();

    case CN_NAME:
      return getCnName();

    case SYMBOL:
      return getSymbol();

    case IS_BASE_CURRENCY:
      return Boolean.valueOf(isIsBaseCurrency());

    case CREATE_TIMESTAMP:
      return Long.valueOf(getCreateTimestamp());

    case LAST_MODITY_TIMESTAMP:
      return Long.valueOf(getLastModityTimestamp());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CURRENCY_CODE:
      return isSetCurrencyCode();
    case EN_NAME:
      return isSetEnName();
    case CN_NAME:
      return isSetCnName();
    case SYMBOL:
      return isSetSymbol();
    case IS_BASE_CURRENCY:
      return isSetIsBaseCurrency();
    case CREATE_TIMESTAMP:
      return isSetCreateTimestamp();
    case LAST_MODITY_TIMESTAMP:
      return isSetLastModityTimestamp();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Currency)
      return this.equals((Currency)that);
    return false;
  }

  public boolean equals(Currency that) {
    if (that == null)
      return false;

    boolean this_present_currencyCode = true && this.isSetCurrencyCode();
    boolean that_present_currencyCode = true && that.isSetCurrencyCode();
    if (this_present_currencyCode || that_present_currencyCode) {
      if (!(this_present_currencyCode && that_present_currencyCode))
        return false;
      if (!this.currencyCode.equals(that.currencyCode))
        return false;
    }

    boolean this_present_enName = true && this.isSetEnName();
    boolean that_present_enName = true && that.isSetEnName();
    if (this_present_enName || that_present_enName) {
      if (!(this_present_enName && that_present_enName))
        return false;
      if (!this.enName.equals(that.enName))
        return false;
    }

    boolean this_present_cnName = true && this.isSetCnName();
    boolean that_present_cnName = true && that.isSetCnName();
    if (this_present_cnName || that_present_cnName) {
      if (!(this_present_cnName && that_present_cnName))
        return false;
      if (!this.cnName.equals(that.cnName))
        return false;
    }

    boolean this_present_symbol = true && this.isSetSymbol();
    boolean that_present_symbol = true && that.isSetSymbol();
    if (this_present_symbol || that_present_symbol) {
      if (!(this_present_symbol && that_present_symbol))
        return false;
      if (!this.symbol.equals(that.symbol))
        return false;
    }

    boolean this_present_isBaseCurrency = true && this.isSetIsBaseCurrency();
    boolean that_present_isBaseCurrency = true && that.isSetIsBaseCurrency();
    if (this_present_isBaseCurrency || that_present_isBaseCurrency) {
      if (!(this_present_isBaseCurrency && that_present_isBaseCurrency))
        return false;
      if (this.isBaseCurrency != that.isBaseCurrency)
        return false;
    }

    boolean this_present_createTimestamp = true && this.isSetCreateTimestamp();
    boolean that_present_createTimestamp = true && that.isSetCreateTimestamp();
    if (this_present_createTimestamp || that_present_createTimestamp) {
      if (!(this_present_createTimestamp && that_present_createTimestamp))
        return false;
      if (this.createTimestamp != that.createTimestamp)
        return false;
    }

    boolean this_present_lastModityTimestamp = true && this.isSetLastModityTimestamp();
    boolean that_present_lastModityTimestamp = true && that.isSetLastModityTimestamp();
    if (this_present_lastModityTimestamp || that_present_lastModityTimestamp) {
      if (!(this_present_lastModityTimestamp && that_present_lastModityTimestamp))
        return false;
      if (this.lastModityTimestamp != that.lastModityTimestamp)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Currency other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCurrencyCode()).compareTo(other.isSetCurrencyCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCurrencyCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.currencyCode, other.currencyCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEnName()).compareTo(other.isSetEnName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.enName, other.enName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCnName()).compareTo(other.isSetCnName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCnName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cnName, other.cnName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSymbol()).compareTo(other.isSetSymbol());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSymbol()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.symbol, other.symbol);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIsBaseCurrency()).compareTo(other.isSetIsBaseCurrency());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsBaseCurrency()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isBaseCurrency, other.isBaseCurrency);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCreateTimestamp()).compareTo(other.isSetCreateTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCreateTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createTimestamp, other.createTimestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastModityTimestamp()).compareTo(other.isSetLastModityTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastModityTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastModityTimestamp, other.lastModityTimestamp);
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
    StringBuilder sb = new StringBuilder("Currency(");
    boolean first = true;

    if (isSetCurrencyCode()) {
      sb.append("currencyCode:");
      if (this.currencyCode == null) {
        sb.append("null");
      } else {
        sb.append(this.currencyCode);
      }
      first = false;
    }
    if (isSetEnName()) {
      if (!first) sb.append(", ");
      sb.append("enName:");
      if (this.enName == null) {
        sb.append("null");
      } else {
        sb.append(this.enName);
      }
      first = false;
    }
    if (isSetCnName()) {
      if (!first) sb.append(", ");
      sb.append("cnName:");
      if (this.cnName == null) {
        sb.append("null");
      } else {
        sb.append(this.cnName);
      }
      first = false;
    }
    if (isSetSymbol()) {
      if (!first) sb.append(", ");
      sb.append("symbol:");
      if (this.symbol == null) {
        sb.append("null");
      } else {
        sb.append(this.symbol);
      }
      first = false;
    }
    if (isSetIsBaseCurrency()) {
      if (!first) sb.append(", ");
      sb.append("isBaseCurrency:");
      sb.append(this.isBaseCurrency);
      first = false;
    }
    if (isSetCreateTimestamp()) {
      if (!first) sb.append(", ");
      sb.append("createTimestamp:");
      sb.append(this.createTimestamp);
      first = false;
    }
    if (isSetLastModityTimestamp()) {
      if (!first) sb.append(", ");
      sb.append("lastModityTimestamp:");
      sb.append(this.lastModityTimestamp);
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

  private static class CurrencyStandardSchemeFactory implements SchemeFactory {
    public CurrencyStandardScheme getScheme() {
      return new CurrencyStandardScheme();
    }
  }

  private static class CurrencyStandardScheme extends StandardScheme<Currency> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Currency struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 2: // CURRENCY_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.currencyCode = iprot.readString();
              struct.setCurrencyCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EN_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.enName = iprot.readString();
              struct.setEnNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CN_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.cnName = iprot.readString();
              struct.setCnNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // SYMBOL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.symbol = iprot.readString();
              struct.setSymbolIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // IS_BASE_CURRENCY
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isBaseCurrency = iprot.readBool();
              struct.setIsBaseCurrencyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 40: // CREATE_TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.createTimestamp = iprot.readI64();
              struct.setCreateTimestampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 41: // LAST_MODITY_TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.lastModityTimestamp = iprot.readI64();
              struct.setLastModityTimestampIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Currency struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.currencyCode != null) {
        if (struct.isSetCurrencyCode()) {
          oprot.writeFieldBegin(CURRENCY_CODE_FIELD_DESC);
          oprot.writeString(struct.currencyCode);
          oprot.writeFieldEnd();
        }
      }
      if (struct.enName != null) {
        if (struct.isSetEnName()) {
          oprot.writeFieldBegin(EN_NAME_FIELD_DESC);
          oprot.writeString(struct.enName);
          oprot.writeFieldEnd();
        }
      }
      if (struct.cnName != null) {
        if (struct.isSetCnName()) {
          oprot.writeFieldBegin(CN_NAME_FIELD_DESC);
          oprot.writeString(struct.cnName);
          oprot.writeFieldEnd();
        }
      }
      if (struct.symbol != null) {
        if (struct.isSetSymbol()) {
          oprot.writeFieldBegin(SYMBOL_FIELD_DESC);
          oprot.writeString(struct.symbol);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetIsBaseCurrency()) {
        oprot.writeFieldBegin(IS_BASE_CURRENCY_FIELD_DESC);
        oprot.writeBool(struct.isBaseCurrency);
        oprot.writeFieldEnd();
      }
      if (struct.isSetCreateTimestamp()) {
        oprot.writeFieldBegin(CREATE_TIMESTAMP_FIELD_DESC);
        oprot.writeI64(struct.createTimestamp);
        oprot.writeFieldEnd();
      }
      if (struct.isSetLastModityTimestamp()) {
        oprot.writeFieldBegin(LAST_MODITY_TIMESTAMP_FIELD_DESC);
        oprot.writeI64(struct.lastModityTimestamp);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CurrencyTupleSchemeFactory implements SchemeFactory {
    public CurrencyTupleScheme getScheme() {
      return new CurrencyTupleScheme();
    }
  }

  private static class CurrencyTupleScheme extends TupleScheme<Currency> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Currency struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCurrencyCode()) {
        optionals.set(0);
      }
      if (struct.isSetEnName()) {
        optionals.set(1);
      }
      if (struct.isSetCnName()) {
        optionals.set(2);
      }
      if (struct.isSetSymbol()) {
        optionals.set(3);
      }
      if (struct.isSetIsBaseCurrency()) {
        optionals.set(4);
      }
      if (struct.isSetCreateTimestamp()) {
        optionals.set(5);
      }
      if (struct.isSetLastModityTimestamp()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetCurrencyCode()) {
        oprot.writeString(struct.currencyCode);
      }
      if (struct.isSetEnName()) {
        oprot.writeString(struct.enName);
      }
      if (struct.isSetCnName()) {
        oprot.writeString(struct.cnName);
      }
      if (struct.isSetSymbol()) {
        oprot.writeString(struct.symbol);
      }
      if (struct.isSetIsBaseCurrency()) {
        oprot.writeBool(struct.isBaseCurrency);
      }
      if (struct.isSetCreateTimestamp()) {
        oprot.writeI64(struct.createTimestamp);
      }
      if (struct.isSetLastModityTimestamp()) {
        oprot.writeI64(struct.lastModityTimestamp);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Currency struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.currencyCode = iprot.readString();
        struct.setCurrencyCodeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.enName = iprot.readString();
        struct.setEnNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.cnName = iprot.readString();
        struct.setCnNameIsSet(true);
      }
      if (incoming.get(3)) {
        struct.symbol = iprot.readString();
        struct.setSymbolIsSet(true);
      }
      if (incoming.get(4)) {
        struct.isBaseCurrency = iprot.readBool();
        struct.setIsBaseCurrencyIsSet(true);
      }
      if (incoming.get(5)) {
        struct.createTimestamp = iprot.readI64();
        struct.setCreateTimestampIsSet(true);
      }
      if (incoming.get(6)) {
        struct.lastModityTimestamp = iprot.readI64();
        struct.setLastModityTimestampIsSet(true);
      }
    }
  }

}

