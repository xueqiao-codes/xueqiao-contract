/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.es_service.thrift;

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

public class EsMoneyChgNoticeField implements org.apache.thrift.TBase<EsMoneyChgNoticeField, EsMoneyChgNoticeField._Fields>, java.io.Serializable, Cloneable, Comparable<EsMoneyChgNoticeField> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EsMoneyChgNoticeField");

  private static final org.apache.thrift.protocol.TField CLIENT_NO_FIELD_DESC = new org.apache.thrift.protocol.TField("clientNo", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CURRENCY_NO_FIELD_DESC = new org.apache.thrift.protocol.TField("currencyNo", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField MONEY_CHG_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("moneyChgNum", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField MONEY_CHG_FIELD_DESC = new org.apache.thrift.protocol.TField("moneyChg", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField MONEY_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("moneyValue", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField SLED_ACCOUNT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledAccountId", org.apache.thrift.protocol.TType.I32, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new EsMoneyChgNoticeFieldStandardSchemeFactory());
    schemes.put(TupleScheme.class, new EsMoneyChgNoticeFieldTupleSchemeFactory());
  }

  public String clientNo; // optional
  public String currencyNo; // optional
  public int moneyChgNum; // optional
  /**
   * 
   * @see EsMoneyChgType
   */
  public EsMoneyChgType moneyChg; // optional
  public double moneyValue; // optional
  public int sledAccountId; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CLIENT_NO((short)1, "clientNo"),
    CURRENCY_NO((short)2, "currencyNo"),
    MONEY_CHG_NUM((short)3, "moneyChgNum"),
    /**
     * 
     * @see EsMoneyChgType
     */
    MONEY_CHG((short)4, "moneyChg"),
    MONEY_VALUE((short)5, "moneyValue"),
    SLED_ACCOUNT_ID((short)6, "sledAccountId");

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
        case 1: // CLIENT_NO
          return CLIENT_NO;
        case 2: // CURRENCY_NO
          return CURRENCY_NO;
        case 3: // MONEY_CHG_NUM
          return MONEY_CHG_NUM;
        case 4: // MONEY_CHG
          return MONEY_CHG;
        case 5: // MONEY_VALUE
          return MONEY_VALUE;
        case 6: // SLED_ACCOUNT_ID
          return SLED_ACCOUNT_ID;
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
  private static final int __MONEYCHGNUM_ISSET_ID = 0;
  private static final int __MONEYVALUE_ISSET_ID = 1;
  private static final int __SLEDACCOUNTID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.CLIENT_NO,_Fields.CURRENCY_NO,_Fields.MONEY_CHG_NUM,_Fields.MONEY_CHG,_Fields.MONEY_VALUE,_Fields.SLED_ACCOUNT_ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CLIENT_NO, new org.apache.thrift.meta_data.FieldMetaData("clientNo", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CURRENCY_NO, new org.apache.thrift.meta_data.FieldMetaData("currencyNo", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MONEY_CHG_NUM, new org.apache.thrift.meta_data.FieldMetaData("moneyChgNum", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MONEY_CHG, new org.apache.thrift.meta_data.FieldMetaData("moneyChg", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, EsMoneyChgType.class)));
    tmpMap.put(_Fields.MONEY_VALUE, new org.apache.thrift.meta_data.FieldMetaData("moneyValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.SLED_ACCOUNT_ID, new org.apache.thrift.meta_data.FieldMetaData("sledAccountId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EsMoneyChgNoticeField.class, metaDataMap);
  }

  public EsMoneyChgNoticeField() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EsMoneyChgNoticeField(EsMoneyChgNoticeField other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetClientNo()) {
      this.clientNo = other.clientNo;
    }
    if (other.isSetCurrencyNo()) {
      this.currencyNo = other.currencyNo;
    }
    this.moneyChgNum = other.moneyChgNum;
    if (other.isSetMoneyChg()) {
      this.moneyChg = other.moneyChg;
    }
    this.moneyValue = other.moneyValue;
    this.sledAccountId = other.sledAccountId;
  }

  public EsMoneyChgNoticeField deepCopy() {
    return new EsMoneyChgNoticeField(this);
  }

  @Override
  public void clear() {
    this.clientNo = null;
    this.currencyNo = null;
    setMoneyChgNumIsSet(false);
    this.moneyChgNum = 0;
    this.moneyChg = null;
    setMoneyValueIsSet(false);
    this.moneyValue = 0.0;
    setSledAccountIdIsSet(false);
    this.sledAccountId = 0;
  }

  public String getClientNo() {
    return this.clientNo;
  }

  public EsMoneyChgNoticeField setClientNo(String clientNo) {
    this.clientNo = clientNo;
    return this;
  }

  public void unsetClientNo() {
    this.clientNo = null;
  }

  /** Returns true if field clientNo is set (has been assigned a value) and false otherwise */
  public boolean isSetClientNo() {
    return this.clientNo != null;
  }

  public void setClientNoIsSet(boolean value) {
    if (!value) {
      this.clientNo = null;
    }
  }

  public String getCurrencyNo() {
    return this.currencyNo;
  }

  public EsMoneyChgNoticeField setCurrencyNo(String currencyNo) {
    this.currencyNo = currencyNo;
    return this;
  }

  public void unsetCurrencyNo() {
    this.currencyNo = null;
  }

  /** Returns true if field currencyNo is set (has been assigned a value) and false otherwise */
  public boolean isSetCurrencyNo() {
    return this.currencyNo != null;
  }

  public void setCurrencyNoIsSet(boolean value) {
    if (!value) {
      this.currencyNo = null;
    }
  }

  public int getMoneyChgNum() {
    return this.moneyChgNum;
  }

  public EsMoneyChgNoticeField setMoneyChgNum(int moneyChgNum) {
    this.moneyChgNum = moneyChgNum;
    setMoneyChgNumIsSet(true);
    return this;
  }

  public void unsetMoneyChgNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MONEYCHGNUM_ISSET_ID);
  }

  /** Returns true if field moneyChgNum is set (has been assigned a value) and false otherwise */
  public boolean isSetMoneyChgNum() {
    return EncodingUtils.testBit(__isset_bitfield, __MONEYCHGNUM_ISSET_ID);
  }

  public void setMoneyChgNumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MONEYCHGNUM_ISSET_ID, value);
  }

  /**
   * 
   * @see EsMoneyChgType
   */
  public EsMoneyChgType getMoneyChg() {
    return this.moneyChg;
  }

  /**
   * 
   * @see EsMoneyChgType
   */
  public EsMoneyChgNoticeField setMoneyChg(EsMoneyChgType moneyChg) {
    this.moneyChg = moneyChg;
    return this;
  }

  public void unsetMoneyChg() {
    this.moneyChg = null;
  }

  /** Returns true if field moneyChg is set (has been assigned a value) and false otherwise */
  public boolean isSetMoneyChg() {
    return this.moneyChg != null;
  }

  public void setMoneyChgIsSet(boolean value) {
    if (!value) {
      this.moneyChg = null;
    }
  }

  public double getMoneyValue() {
    return this.moneyValue;
  }

  public EsMoneyChgNoticeField setMoneyValue(double moneyValue) {
    this.moneyValue = moneyValue;
    setMoneyValueIsSet(true);
    return this;
  }

  public void unsetMoneyValue() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MONEYVALUE_ISSET_ID);
  }

  /** Returns true if field moneyValue is set (has been assigned a value) and false otherwise */
  public boolean isSetMoneyValue() {
    return EncodingUtils.testBit(__isset_bitfield, __MONEYVALUE_ISSET_ID);
  }

  public void setMoneyValueIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MONEYVALUE_ISSET_ID, value);
  }

  public int getSledAccountId() {
    return this.sledAccountId;
  }

  public EsMoneyChgNoticeField setSledAccountId(int sledAccountId) {
    this.sledAccountId = sledAccountId;
    setSledAccountIdIsSet(true);
    return this;
  }

  public void unsetSledAccountId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SLEDACCOUNTID_ISSET_ID);
  }

  /** Returns true if field sledAccountId is set (has been assigned a value) and false otherwise */
  public boolean isSetSledAccountId() {
    return EncodingUtils.testBit(__isset_bitfield, __SLEDACCOUNTID_ISSET_ID);
  }

  public void setSledAccountIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SLEDACCOUNTID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CLIENT_NO:
      if (value == null) {
        unsetClientNo();
      } else {
        setClientNo((String)value);
      }
      break;

    case CURRENCY_NO:
      if (value == null) {
        unsetCurrencyNo();
      } else {
        setCurrencyNo((String)value);
      }
      break;

    case MONEY_CHG_NUM:
      if (value == null) {
        unsetMoneyChgNum();
      } else {
        setMoneyChgNum((Integer)value);
      }
      break;

    case MONEY_CHG:
      if (value == null) {
        unsetMoneyChg();
      } else {
        setMoneyChg((EsMoneyChgType)value);
      }
      break;

    case MONEY_VALUE:
      if (value == null) {
        unsetMoneyValue();
      } else {
        setMoneyValue((Double)value);
      }
      break;

    case SLED_ACCOUNT_ID:
      if (value == null) {
        unsetSledAccountId();
      } else {
        setSledAccountId((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CLIENT_NO:
      return getClientNo();

    case CURRENCY_NO:
      return getCurrencyNo();

    case MONEY_CHG_NUM:
      return Integer.valueOf(getMoneyChgNum());

    case MONEY_CHG:
      return getMoneyChg();

    case MONEY_VALUE:
      return Double.valueOf(getMoneyValue());

    case SLED_ACCOUNT_ID:
      return Integer.valueOf(getSledAccountId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CLIENT_NO:
      return isSetClientNo();
    case CURRENCY_NO:
      return isSetCurrencyNo();
    case MONEY_CHG_NUM:
      return isSetMoneyChgNum();
    case MONEY_CHG:
      return isSetMoneyChg();
    case MONEY_VALUE:
      return isSetMoneyValue();
    case SLED_ACCOUNT_ID:
      return isSetSledAccountId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EsMoneyChgNoticeField)
      return this.equals((EsMoneyChgNoticeField)that);
    return false;
  }

  public boolean equals(EsMoneyChgNoticeField that) {
    if (that == null)
      return false;

    boolean this_present_clientNo = true && this.isSetClientNo();
    boolean that_present_clientNo = true && that.isSetClientNo();
    if (this_present_clientNo || that_present_clientNo) {
      if (!(this_present_clientNo && that_present_clientNo))
        return false;
      if (!this.clientNo.equals(that.clientNo))
        return false;
    }

    boolean this_present_currencyNo = true && this.isSetCurrencyNo();
    boolean that_present_currencyNo = true && that.isSetCurrencyNo();
    if (this_present_currencyNo || that_present_currencyNo) {
      if (!(this_present_currencyNo && that_present_currencyNo))
        return false;
      if (!this.currencyNo.equals(that.currencyNo))
        return false;
    }

    boolean this_present_moneyChgNum = true && this.isSetMoneyChgNum();
    boolean that_present_moneyChgNum = true && that.isSetMoneyChgNum();
    if (this_present_moneyChgNum || that_present_moneyChgNum) {
      if (!(this_present_moneyChgNum && that_present_moneyChgNum))
        return false;
      if (this.moneyChgNum != that.moneyChgNum)
        return false;
    }

    boolean this_present_moneyChg = true && this.isSetMoneyChg();
    boolean that_present_moneyChg = true && that.isSetMoneyChg();
    if (this_present_moneyChg || that_present_moneyChg) {
      if (!(this_present_moneyChg && that_present_moneyChg))
        return false;
      if (!this.moneyChg.equals(that.moneyChg))
        return false;
    }

    boolean this_present_moneyValue = true && this.isSetMoneyValue();
    boolean that_present_moneyValue = true && that.isSetMoneyValue();
    if (this_present_moneyValue || that_present_moneyValue) {
      if (!(this_present_moneyValue && that_present_moneyValue))
        return false;
      if (this.moneyValue != that.moneyValue)
        return false;
    }

    boolean this_present_sledAccountId = true && this.isSetSledAccountId();
    boolean that_present_sledAccountId = true && that.isSetSledAccountId();
    if (this_present_sledAccountId || that_present_sledAccountId) {
      if (!(this_present_sledAccountId && that_present_sledAccountId))
        return false;
      if (this.sledAccountId != that.sledAccountId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(EsMoneyChgNoticeField other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetClientNo()).compareTo(other.isSetClientNo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClientNo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.clientNo, other.clientNo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCurrencyNo()).compareTo(other.isSetCurrencyNo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCurrencyNo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.currencyNo, other.currencyNo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMoneyChgNum()).compareTo(other.isSetMoneyChgNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMoneyChgNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.moneyChgNum, other.moneyChgNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMoneyChg()).compareTo(other.isSetMoneyChg());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMoneyChg()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.moneyChg, other.moneyChg);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMoneyValue()).compareTo(other.isSetMoneyValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMoneyValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.moneyValue, other.moneyValue);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSledAccountId()).compareTo(other.isSetSledAccountId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledAccountId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledAccountId, other.sledAccountId);
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
    StringBuilder sb = new StringBuilder("EsMoneyChgNoticeField(");
    boolean first = true;

    if (isSetClientNo()) {
      sb.append("clientNo:");
      if (this.clientNo == null) {
        sb.append("null");
      } else {
        sb.append(this.clientNo);
      }
      first = false;
    }
    if (isSetCurrencyNo()) {
      if (!first) sb.append(", ");
      sb.append("currencyNo:");
      if (this.currencyNo == null) {
        sb.append("null");
      } else {
        sb.append(this.currencyNo);
      }
      first = false;
    }
    if (isSetMoneyChgNum()) {
      if (!first) sb.append(", ");
      sb.append("moneyChgNum:");
      sb.append(this.moneyChgNum);
      first = false;
    }
    if (isSetMoneyChg()) {
      if (!first) sb.append(", ");
      sb.append("moneyChg:");
      if (this.moneyChg == null) {
        sb.append("null");
      } else {
        sb.append(this.moneyChg);
      }
      first = false;
    }
    if (isSetMoneyValue()) {
      if (!first) sb.append(", ");
      sb.append("moneyValue:");
      sb.append(this.moneyValue);
      first = false;
    }
    if (isSetSledAccountId()) {
      if (!first) sb.append(", ");
      sb.append("sledAccountId:");
      sb.append(this.sledAccountId);
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

  private static class EsMoneyChgNoticeFieldStandardSchemeFactory implements SchemeFactory {
    public EsMoneyChgNoticeFieldStandardScheme getScheme() {
      return new EsMoneyChgNoticeFieldStandardScheme();
    }
  }

  private static class EsMoneyChgNoticeFieldStandardScheme extends StandardScheme<EsMoneyChgNoticeField> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, EsMoneyChgNoticeField struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CLIENT_NO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.clientNo = iprot.readString();
              struct.setClientNoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CURRENCY_NO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.currencyNo = iprot.readString();
              struct.setCurrencyNoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MONEY_CHG_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.moneyChgNum = iprot.readI32();
              struct.setMoneyChgNumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // MONEY_CHG
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.moneyChg = EsMoneyChgType.findByValue(iprot.readI32());
              struct.setMoneyChgIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MONEY_VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.moneyValue = iprot.readDouble();
              struct.setMoneyValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // SLED_ACCOUNT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledAccountId = iprot.readI32();
              struct.setSledAccountIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, EsMoneyChgNoticeField struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.clientNo != null) {
        if (struct.isSetClientNo()) {
          oprot.writeFieldBegin(CLIENT_NO_FIELD_DESC);
          oprot.writeString(struct.clientNo);
          oprot.writeFieldEnd();
        }
      }
      if (struct.currencyNo != null) {
        if (struct.isSetCurrencyNo()) {
          oprot.writeFieldBegin(CURRENCY_NO_FIELD_DESC);
          oprot.writeString(struct.currencyNo);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetMoneyChgNum()) {
        oprot.writeFieldBegin(MONEY_CHG_NUM_FIELD_DESC);
        oprot.writeI32(struct.moneyChgNum);
        oprot.writeFieldEnd();
      }
      if (struct.moneyChg != null) {
        if (struct.isSetMoneyChg()) {
          oprot.writeFieldBegin(MONEY_CHG_FIELD_DESC);
          oprot.writeI32(struct.moneyChg.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetMoneyValue()) {
        oprot.writeFieldBegin(MONEY_VALUE_FIELD_DESC);
        oprot.writeDouble(struct.moneyValue);
        oprot.writeFieldEnd();
      }
      if (struct.isSetSledAccountId()) {
        oprot.writeFieldBegin(SLED_ACCOUNT_ID_FIELD_DESC);
        oprot.writeI32(struct.sledAccountId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class EsMoneyChgNoticeFieldTupleSchemeFactory implements SchemeFactory {
    public EsMoneyChgNoticeFieldTupleScheme getScheme() {
      return new EsMoneyChgNoticeFieldTupleScheme();
    }
  }

  private static class EsMoneyChgNoticeFieldTupleScheme extends TupleScheme<EsMoneyChgNoticeField> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, EsMoneyChgNoticeField struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetClientNo()) {
        optionals.set(0);
      }
      if (struct.isSetCurrencyNo()) {
        optionals.set(1);
      }
      if (struct.isSetMoneyChgNum()) {
        optionals.set(2);
      }
      if (struct.isSetMoneyChg()) {
        optionals.set(3);
      }
      if (struct.isSetMoneyValue()) {
        optionals.set(4);
      }
      if (struct.isSetSledAccountId()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetClientNo()) {
        oprot.writeString(struct.clientNo);
      }
      if (struct.isSetCurrencyNo()) {
        oprot.writeString(struct.currencyNo);
      }
      if (struct.isSetMoneyChgNum()) {
        oprot.writeI32(struct.moneyChgNum);
      }
      if (struct.isSetMoneyChg()) {
        oprot.writeI32(struct.moneyChg.getValue());
      }
      if (struct.isSetMoneyValue()) {
        oprot.writeDouble(struct.moneyValue);
      }
      if (struct.isSetSledAccountId()) {
        oprot.writeI32(struct.sledAccountId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, EsMoneyChgNoticeField struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.clientNo = iprot.readString();
        struct.setClientNoIsSet(true);
      }
      if (incoming.get(1)) {
        struct.currencyNo = iprot.readString();
        struct.setCurrencyNoIsSet(true);
      }
      if (incoming.get(2)) {
        struct.moneyChgNum = iprot.readI32();
        struct.setMoneyChgNumIsSet(true);
      }
      if (incoming.get(3)) {
        struct.moneyChg = EsMoneyChgType.findByValue(iprot.readI32());
        struct.setMoneyChgIsSet(true);
      }
      if (incoming.get(4)) {
        struct.moneyValue = iprot.readDouble();
        struct.setMoneyValueIsSet(true);
      }
      if (incoming.get(5)) {
        struct.sledAccountId = iprot.readI32();
        struct.setSledAccountIdIsSet(true);
      }
    }
  }

}

