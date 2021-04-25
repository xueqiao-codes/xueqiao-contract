/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.common.thriftapi;

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

public class StdOrderActionField implements org.apache.thrift.TBase<StdOrderActionField, StdOrderActionField._Fields>, java.io.Serializable, Cloneable, Comparable<StdOrderActionField> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StdOrderActionField");

  private static final org.apache.thrift.protocol.TField SLED_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ACTION_FLAG_FIELD_DESC = new org.apache.thrift.protocol.TField("actionFlag", org.apache.thrift.protocol.TType.BYTE, (short)2);
  private static final org.apache.thrift.protocol.TField PRICE_FIELD_DESC = new org.apache.thrift.protocol.TField("price", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField QUANTITY_CHANGE_FIELD_DESC = new org.apache.thrift.protocol.TField("quantityChange", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField SLED_ACCOUNT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledAccountId", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField SLED_CONTRACT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledContractId", org.apache.thrift.protocol.TType.I32, (short)12);
  private static final org.apache.thrift.protocol.TField SERIAL_VERSION_UID_FIELD_DESC = new org.apache.thrift.protocol.TField("serialVersionUID", org.apache.thrift.protocol.TType.I64, (short)101);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new StdOrderActionFieldStandardSchemeFactory());
    schemes.put(TupleScheme.class, new StdOrderActionFieldTupleSchemeFactory());
  }

  public String sledId; // required
  public byte actionFlag; // required
  public double price; // optional
  public int quantityChange; // optional
  public int sledAccountId; // optional
  public int userId; // optional
  public int sledContractId; // optional
  public long serialVersionUID; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLED_ID((short)1, "sledId"),
    ACTION_FLAG((short)2, "actionFlag"),
    PRICE((short)3, "price"),
    QUANTITY_CHANGE((short)4, "quantityChange"),
    SLED_ACCOUNT_ID((short)5, "sledAccountId"),
    USER_ID((short)6, "userId"),
    SLED_CONTRACT_ID((short)12, "sledContractId"),
    SERIAL_VERSION_UID((short)101, "serialVersionUID");

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
        case 1: // SLED_ID
          return SLED_ID;
        case 2: // ACTION_FLAG
          return ACTION_FLAG;
        case 3: // PRICE
          return PRICE;
        case 4: // QUANTITY_CHANGE
          return QUANTITY_CHANGE;
        case 5: // SLED_ACCOUNT_ID
          return SLED_ACCOUNT_ID;
        case 6: // USER_ID
          return USER_ID;
        case 12: // SLED_CONTRACT_ID
          return SLED_CONTRACT_ID;
        case 101: // SERIAL_VERSION_UID
          return SERIAL_VERSION_UID;
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
  private static final int __ACTIONFLAG_ISSET_ID = 0;
  private static final int __PRICE_ISSET_ID = 1;
  private static final int __QUANTITYCHANGE_ISSET_ID = 2;
  private static final int __SLEDACCOUNTID_ISSET_ID = 3;
  private static final int __USERID_ISSET_ID = 4;
  private static final int __SLEDCONTRACTID_ISSET_ID = 5;
  private static final int __SERIALVERSIONUID_ISSET_ID = 6;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.PRICE,_Fields.QUANTITY_CHANGE,_Fields.SLED_ACCOUNT_ID,_Fields.USER_ID,_Fields.SLED_CONTRACT_ID,_Fields.SERIAL_VERSION_UID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLED_ID, new org.apache.thrift.meta_data.FieldMetaData("sledId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ACTION_FLAG, new org.apache.thrift.meta_data.FieldMetaData("actionFlag", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.PRICE, new org.apache.thrift.meta_data.FieldMetaData("price", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.QUANTITY_CHANGE, new org.apache.thrift.meta_data.FieldMetaData("quantityChange", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SLED_ACCOUNT_ID, new org.apache.thrift.meta_data.FieldMetaData("sledAccountId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SLED_CONTRACT_ID, new org.apache.thrift.meta_data.FieldMetaData("sledContractId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SERIAL_VERSION_UID, new org.apache.thrift.meta_data.FieldMetaData("serialVersionUID", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StdOrderActionField.class, metaDataMap);
  }

  public StdOrderActionField() {
  }

  public StdOrderActionField(
    String sledId,
    byte actionFlag)
  {
    this();
    this.sledId = sledId;
    this.actionFlag = actionFlag;
    setActionFlagIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public StdOrderActionField(StdOrderActionField other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetSledId()) {
      this.sledId = other.sledId;
    }
    this.actionFlag = other.actionFlag;
    this.price = other.price;
    this.quantityChange = other.quantityChange;
    this.sledAccountId = other.sledAccountId;
    this.userId = other.userId;
    this.sledContractId = other.sledContractId;
    this.serialVersionUID = other.serialVersionUID;
  }

  public StdOrderActionField deepCopy() {
    return new StdOrderActionField(this);
  }

  @Override
  public void clear() {
    this.sledId = null;
    setActionFlagIsSet(false);
    this.actionFlag = 0;
    setPriceIsSet(false);
    this.price = 0.0;
    setQuantityChangeIsSet(false);
    this.quantityChange = 0;
    setSledAccountIdIsSet(false);
    this.sledAccountId = 0;
    setUserIdIsSet(false);
    this.userId = 0;
    setSledContractIdIsSet(false);
    this.sledContractId = 0;
    setSerialVersionUIDIsSet(false);
    this.serialVersionUID = 0;
  }

  public String getSledId() {
    return this.sledId;
  }

  public StdOrderActionField setSledId(String sledId) {
    this.sledId = sledId;
    return this;
  }

  public void unsetSledId() {
    this.sledId = null;
  }

  /** Returns true if field sledId is set (has been assigned a value) and false otherwise */
  public boolean isSetSledId() {
    return this.sledId != null;
  }

  public void setSledIdIsSet(boolean value) {
    if (!value) {
      this.sledId = null;
    }
  }

  public byte getActionFlag() {
    return this.actionFlag;
  }

  public StdOrderActionField setActionFlag(byte actionFlag) {
    this.actionFlag = actionFlag;
    setActionFlagIsSet(true);
    return this;
  }

  public void unsetActionFlag() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ACTIONFLAG_ISSET_ID);
  }

  /** Returns true if field actionFlag is set (has been assigned a value) and false otherwise */
  public boolean isSetActionFlag() {
    return EncodingUtils.testBit(__isset_bitfield, __ACTIONFLAG_ISSET_ID);
  }

  public void setActionFlagIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ACTIONFLAG_ISSET_ID, value);
  }

  public double getPrice() {
    return this.price;
  }

  public StdOrderActionField setPrice(double price) {
    this.price = price;
    setPriceIsSet(true);
    return this;
  }

  public void unsetPrice() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PRICE_ISSET_ID);
  }

  /** Returns true if field price is set (has been assigned a value) and false otherwise */
  public boolean isSetPrice() {
    return EncodingUtils.testBit(__isset_bitfield, __PRICE_ISSET_ID);
  }

  public void setPriceIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PRICE_ISSET_ID, value);
  }

  public int getQuantityChange() {
    return this.quantityChange;
  }

  public StdOrderActionField setQuantityChange(int quantityChange) {
    this.quantityChange = quantityChange;
    setQuantityChangeIsSet(true);
    return this;
  }

  public void unsetQuantityChange() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __QUANTITYCHANGE_ISSET_ID);
  }

  /** Returns true if field quantityChange is set (has been assigned a value) and false otherwise */
  public boolean isSetQuantityChange() {
    return EncodingUtils.testBit(__isset_bitfield, __QUANTITYCHANGE_ISSET_ID);
  }

  public void setQuantityChangeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __QUANTITYCHANGE_ISSET_ID, value);
  }

  public int getSledAccountId() {
    return this.sledAccountId;
  }

  public StdOrderActionField setSledAccountId(int sledAccountId) {
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

  public int getUserId() {
    return this.userId;
  }

  public StdOrderActionField setUserId(int userId) {
    this.userId = userId;
    setUserIdIsSet(true);
    return this;
  }

  public void unsetUserId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return EncodingUtils.testBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  public void setUserIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERID_ISSET_ID, value);
  }

  public int getSledContractId() {
    return this.sledContractId;
  }

  public StdOrderActionField setSledContractId(int sledContractId) {
    this.sledContractId = sledContractId;
    setSledContractIdIsSet(true);
    return this;
  }

  public void unsetSledContractId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SLEDCONTRACTID_ISSET_ID);
  }

  /** Returns true if field sledContractId is set (has been assigned a value) and false otherwise */
  public boolean isSetSledContractId() {
    return EncodingUtils.testBit(__isset_bitfield, __SLEDCONTRACTID_ISSET_ID);
  }

  public void setSledContractIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SLEDCONTRACTID_ISSET_ID, value);
  }

  public long getSerialVersionUID() {
    return this.serialVersionUID;
  }

  public StdOrderActionField setSerialVersionUID(long serialVersionUID) {
    this.serialVersionUID = serialVersionUID;
    setSerialVersionUIDIsSet(true);
    return this;
  }

  public void unsetSerialVersionUID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SERIALVERSIONUID_ISSET_ID);
  }

  /** Returns true if field serialVersionUID is set (has been assigned a value) and false otherwise */
  public boolean isSetSerialVersionUID() {
    return EncodingUtils.testBit(__isset_bitfield, __SERIALVERSIONUID_ISSET_ID);
  }

  public void setSerialVersionUIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SERIALVERSIONUID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SLED_ID:
      if (value == null) {
        unsetSledId();
      } else {
        setSledId((String)value);
      }
      break;

    case ACTION_FLAG:
      if (value == null) {
        unsetActionFlag();
      } else {
        setActionFlag((Byte)value);
      }
      break;

    case PRICE:
      if (value == null) {
        unsetPrice();
      } else {
        setPrice((Double)value);
      }
      break;

    case QUANTITY_CHANGE:
      if (value == null) {
        unsetQuantityChange();
      } else {
        setQuantityChange((Integer)value);
      }
      break;

    case SLED_ACCOUNT_ID:
      if (value == null) {
        unsetSledAccountId();
      } else {
        setSledAccountId((Integer)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Integer)value);
      }
      break;

    case SLED_CONTRACT_ID:
      if (value == null) {
        unsetSledContractId();
      } else {
        setSledContractId((Integer)value);
      }
      break;

    case SERIAL_VERSION_UID:
      if (value == null) {
        unsetSerialVersionUID();
      } else {
        setSerialVersionUID((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SLED_ID:
      return getSledId();

    case ACTION_FLAG:
      return Byte.valueOf(getActionFlag());

    case PRICE:
      return Double.valueOf(getPrice());

    case QUANTITY_CHANGE:
      return Integer.valueOf(getQuantityChange());

    case SLED_ACCOUNT_ID:
      return Integer.valueOf(getSledAccountId());

    case USER_ID:
      return Integer.valueOf(getUserId());

    case SLED_CONTRACT_ID:
      return Integer.valueOf(getSledContractId());

    case SERIAL_VERSION_UID:
      return Long.valueOf(getSerialVersionUID());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SLED_ID:
      return isSetSledId();
    case ACTION_FLAG:
      return isSetActionFlag();
    case PRICE:
      return isSetPrice();
    case QUANTITY_CHANGE:
      return isSetQuantityChange();
    case SLED_ACCOUNT_ID:
      return isSetSledAccountId();
    case USER_ID:
      return isSetUserId();
    case SLED_CONTRACT_ID:
      return isSetSledContractId();
    case SERIAL_VERSION_UID:
      return isSetSerialVersionUID();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof StdOrderActionField)
      return this.equals((StdOrderActionField)that);
    return false;
  }

  public boolean equals(StdOrderActionField that) {
    if (that == null)
      return false;

    boolean this_present_sledId = true && this.isSetSledId();
    boolean that_present_sledId = true && that.isSetSledId();
    if (this_present_sledId || that_present_sledId) {
      if (!(this_present_sledId && that_present_sledId))
        return false;
      if (!this.sledId.equals(that.sledId))
        return false;
    }

    boolean this_present_actionFlag = true;
    boolean that_present_actionFlag = true;
    if (this_present_actionFlag || that_present_actionFlag) {
      if (!(this_present_actionFlag && that_present_actionFlag))
        return false;
      if (this.actionFlag != that.actionFlag)
        return false;
    }

    boolean this_present_price = true && this.isSetPrice();
    boolean that_present_price = true && that.isSetPrice();
    if (this_present_price || that_present_price) {
      if (!(this_present_price && that_present_price))
        return false;
      if (this.price != that.price)
        return false;
    }

    boolean this_present_quantityChange = true && this.isSetQuantityChange();
    boolean that_present_quantityChange = true && that.isSetQuantityChange();
    if (this_present_quantityChange || that_present_quantityChange) {
      if (!(this_present_quantityChange && that_present_quantityChange))
        return false;
      if (this.quantityChange != that.quantityChange)
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

    boolean this_present_userId = true && this.isSetUserId();
    boolean that_present_userId = true && that.isSetUserId();
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (this.userId != that.userId)
        return false;
    }

    boolean this_present_sledContractId = true && this.isSetSledContractId();
    boolean that_present_sledContractId = true && that.isSetSledContractId();
    if (this_present_sledContractId || that_present_sledContractId) {
      if (!(this_present_sledContractId && that_present_sledContractId))
        return false;
      if (this.sledContractId != that.sledContractId)
        return false;
    }

    boolean this_present_serialVersionUID = true && this.isSetSerialVersionUID();
    boolean that_present_serialVersionUID = true && that.isSetSerialVersionUID();
    if (this_present_serialVersionUID || that_present_serialVersionUID) {
      if (!(this_present_serialVersionUID && that_present_serialVersionUID))
        return false;
      if (this.serialVersionUID != that.serialVersionUID)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(StdOrderActionField other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSledId()).compareTo(other.isSetSledId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledId, other.sledId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetActionFlag()).compareTo(other.isSetActionFlag());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetActionFlag()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.actionFlag, other.actionFlag);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPrice()).compareTo(other.isSetPrice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.price, other.price);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQuantityChange()).compareTo(other.isSetQuantityChange());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuantityChange()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.quantityChange, other.quantityChange);
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
    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(other.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userId, other.userId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSledContractId()).compareTo(other.isSetSledContractId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledContractId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledContractId, other.sledContractId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSerialVersionUID()).compareTo(other.isSetSerialVersionUID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSerialVersionUID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serialVersionUID, other.serialVersionUID);
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
    StringBuilder sb = new StringBuilder("StdOrderActionField(");
    boolean first = true;

    sb.append("sledId:");
    if (this.sledId == null) {
      sb.append("null");
    } else {
      sb.append(this.sledId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("actionFlag:");
    sb.append(this.actionFlag);
    first = false;
    if (isSetPrice()) {
      if (!first) sb.append(", ");
      sb.append("price:");
      sb.append(this.price);
      first = false;
    }
    if (isSetQuantityChange()) {
      if (!first) sb.append(", ");
      sb.append("quantityChange:");
      sb.append(this.quantityChange);
      first = false;
    }
    if (isSetSledAccountId()) {
      if (!first) sb.append(", ");
      sb.append("sledAccountId:");
      sb.append(this.sledAccountId);
      first = false;
    }
    if (isSetUserId()) {
      if (!first) sb.append(", ");
      sb.append("userId:");
      sb.append(this.userId);
      first = false;
    }
    if (isSetSledContractId()) {
      if (!first) sb.append(", ");
      sb.append("sledContractId:");
      sb.append(this.sledContractId);
      first = false;
    }
    if (isSetSerialVersionUID()) {
      if (!first) sb.append(", ");
      sb.append("serialVersionUID:");
      sb.append(this.serialVersionUID);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (sledId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sledId' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'actionFlag' because it's a primitive and you chose the non-beans generator.
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

  private static class StdOrderActionFieldStandardSchemeFactory implements SchemeFactory {
    public StdOrderActionFieldStandardScheme getScheme() {
      return new StdOrderActionFieldStandardScheme();
    }
  }

  private static class StdOrderActionFieldStandardScheme extends StandardScheme<StdOrderActionField> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, StdOrderActionField struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SLED_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sledId = iprot.readString();
              struct.setSledIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ACTION_FLAG
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.actionFlag = iprot.readByte();
              struct.setActionFlagIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PRICE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.price = iprot.readDouble();
              struct.setPriceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // QUANTITY_CHANGE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.quantityChange = iprot.readI32();
              struct.setQuantityChangeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // SLED_ACCOUNT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledAccountId = iprot.readI32();
              struct.setSledAccountIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userId = iprot.readI32();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 12: // SLED_CONTRACT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledContractId = iprot.readI32();
              struct.setSledContractIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 101: // SERIAL_VERSION_UID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.serialVersionUID = iprot.readI64();
              struct.setSerialVersionUIDIsSet(true);
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
      if (!struct.isSetActionFlag()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'actionFlag' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, StdOrderActionField struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sledId != null) {
        oprot.writeFieldBegin(SLED_ID_FIELD_DESC);
        oprot.writeString(struct.sledId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ACTION_FLAG_FIELD_DESC);
      oprot.writeByte(struct.actionFlag);
      oprot.writeFieldEnd();
      if (struct.isSetPrice()) {
        oprot.writeFieldBegin(PRICE_FIELD_DESC);
        oprot.writeDouble(struct.price);
        oprot.writeFieldEnd();
      }
      if (struct.isSetQuantityChange()) {
        oprot.writeFieldBegin(QUANTITY_CHANGE_FIELD_DESC);
        oprot.writeI32(struct.quantityChange);
        oprot.writeFieldEnd();
      }
      if (struct.isSetSledAccountId()) {
        oprot.writeFieldBegin(SLED_ACCOUNT_ID_FIELD_DESC);
        oprot.writeI32(struct.sledAccountId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetUserId()) {
        oprot.writeFieldBegin(USER_ID_FIELD_DESC);
        oprot.writeI32(struct.userId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetSledContractId()) {
        oprot.writeFieldBegin(SLED_CONTRACT_ID_FIELD_DESC);
        oprot.writeI32(struct.sledContractId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetSerialVersionUID()) {
        oprot.writeFieldBegin(SERIAL_VERSION_UID_FIELD_DESC);
        oprot.writeI64(struct.serialVersionUID);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class StdOrderActionFieldTupleSchemeFactory implements SchemeFactory {
    public StdOrderActionFieldTupleScheme getScheme() {
      return new StdOrderActionFieldTupleScheme();
    }
  }

  private static class StdOrderActionFieldTupleScheme extends TupleScheme<StdOrderActionField> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, StdOrderActionField struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.sledId);
      oprot.writeByte(struct.actionFlag);
      BitSet optionals = new BitSet();
      if (struct.isSetPrice()) {
        optionals.set(0);
      }
      if (struct.isSetQuantityChange()) {
        optionals.set(1);
      }
      if (struct.isSetSledAccountId()) {
        optionals.set(2);
      }
      if (struct.isSetUserId()) {
        optionals.set(3);
      }
      if (struct.isSetSledContractId()) {
        optionals.set(4);
      }
      if (struct.isSetSerialVersionUID()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetPrice()) {
        oprot.writeDouble(struct.price);
      }
      if (struct.isSetQuantityChange()) {
        oprot.writeI32(struct.quantityChange);
      }
      if (struct.isSetSledAccountId()) {
        oprot.writeI32(struct.sledAccountId);
      }
      if (struct.isSetUserId()) {
        oprot.writeI32(struct.userId);
      }
      if (struct.isSetSledContractId()) {
        oprot.writeI32(struct.sledContractId);
      }
      if (struct.isSetSerialVersionUID()) {
        oprot.writeI64(struct.serialVersionUID);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, StdOrderActionField struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.sledId = iprot.readString();
      struct.setSledIdIsSet(true);
      struct.actionFlag = iprot.readByte();
      struct.setActionFlagIsSet(true);
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.price = iprot.readDouble();
        struct.setPriceIsSet(true);
      }
      if (incoming.get(1)) {
        struct.quantityChange = iprot.readI32();
        struct.setQuantityChangeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.sledAccountId = iprot.readI32();
        struct.setSledAccountIdIsSet(true);
      }
      if (incoming.get(3)) {
        struct.userId = iprot.readI32();
        struct.setUserIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.sledContractId = iprot.readI32();
        struct.setSledContractIdIsSet(true);
      }
      if (incoming.get(5)) {
        struct.serialVersionUID = iprot.readI64();
        struct.setSerialVersionUIDIsSet(true);
      }
    }
  }

}

