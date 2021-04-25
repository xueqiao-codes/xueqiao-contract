/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.ctp_service.thriftapi;

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

public class CtpInputOrderActionRspField implements org.apache.thrift.TBase<CtpInputOrderActionRspField, CtpInputOrderActionRspField._Fields>, java.io.Serializable, Cloneable, Comparable<CtpInputOrderActionRspField> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CtpInputOrderActionRspField");

  private static final org.apache.thrift.protocol.TField SLED_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField SLED_ACCOUNT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledAccountId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField ERROR_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("errorId", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField ERROR_MSG_FIELD_DESC = new org.apache.thrift.protocol.TField("errorMsg", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField ACTION_FLAG_FIELD_DESC = new org.apache.thrift.protocol.TField("actionFlag", org.apache.thrift.protocol.TType.BYTE, (short)6);
  private static final org.apache.thrift.protocol.TField LIMIT_PRICE_FIELD_DESC = new org.apache.thrift.protocol.TField("limitPrice", org.apache.thrift.protocol.TType.DOUBLE, (short)7);
  private static final org.apache.thrift.protocol.TField VOLUME_CHANGE_FIELD_DESC = new org.apache.thrift.protocol.TField("volumeChange", org.apache.thrift.protocol.TType.I32, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CtpInputOrderActionRspFieldStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CtpInputOrderActionRspFieldTupleSchemeFactory());
  }

  public String sledId; // optional
  public int sledAccountId; // optional
  public int userId; // optional
  public int errorId; // optional
  public String errorMsg; // optional
  public byte actionFlag; // optional
  public double limitPrice; // optional
  public int volumeChange; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLED_ID((short)1, "sledId"),
    SLED_ACCOUNT_ID((short)2, "sledAccountId"),
    USER_ID((short)3, "userId"),
    ERROR_ID((short)4, "errorId"),
    ERROR_MSG((short)5, "errorMsg"),
    ACTION_FLAG((short)6, "actionFlag"),
    LIMIT_PRICE((short)7, "limitPrice"),
    VOLUME_CHANGE((short)8, "volumeChange");

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
        case 2: // SLED_ACCOUNT_ID
          return SLED_ACCOUNT_ID;
        case 3: // USER_ID
          return USER_ID;
        case 4: // ERROR_ID
          return ERROR_ID;
        case 5: // ERROR_MSG
          return ERROR_MSG;
        case 6: // ACTION_FLAG
          return ACTION_FLAG;
        case 7: // LIMIT_PRICE
          return LIMIT_PRICE;
        case 8: // VOLUME_CHANGE
          return VOLUME_CHANGE;
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
  private static final int __SLEDACCOUNTID_ISSET_ID = 0;
  private static final int __USERID_ISSET_ID = 1;
  private static final int __ERRORID_ISSET_ID = 2;
  private static final int __ACTIONFLAG_ISSET_ID = 3;
  private static final int __LIMITPRICE_ISSET_ID = 4;
  private static final int __VOLUMECHANGE_ISSET_ID = 5;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.SLED_ID,_Fields.SLED_ACCOUNT_ID,_Fields.USER_ID,_Fields.ERROR_ID,_Fields.ERROR_MSG,_Fields.ACTION_FLAG,_Fields.LIMIT_PRICE,_Fields.VOLUME_CHANGE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLED_ID, new org.apache.thrift.meta_data.FieldMetaData("sledId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SLED_ACCOUNT_ID, new org.apache.thrift.meta_data.FieldMetaData("sledAccountId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ERROR_ID, new org.apache.thrift.meta_data.FieldMetaData("errorId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ERROR_MSG, new org.apache.thrift.meta_data.FieldMetaData("errorMsg", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ACTION_FLAG, new org.apache.thrift.meta_data.FieldMetaData("actionFlag", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.LIMIT_PRICE, new org.apache.thrift.meta_data.FieldMetaData("limitPrice", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.VOLUME_CHANGE, new org.apache.thrift.meta_data.FieldMetaData("volumeChange", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CtpInputOrderActionRspField.class, metaDataMap);
  }

  public CtpInputOrderActionRspField() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CtpInputOrderActionRspField(CtpInputOrderActionRspField other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetSledId()) {
      this.sledId = other.sledId;
    }
    this.sledAccountId = other.sledAccountId;
    this.userId = other.userId;
    this.errorId = other.errorId;
    if (other.isSetErrorMsg()) {
      this.errorMsg = other.errorMsg;
    }
    this.actionFlag = other.actionFlag;
    this.limitPrice = other.limitPrice;
    this.volumeChange = other.volumeChange;
  }

  public CtpInputOrderActionRspField deepCopy() {
    return new CtpInputOrderActionRspField(this);
  }

  @Override
  public void clear() {
    this.sledId = null;
    setSledAccountIdIsSet(false);
    this.sledAccountId = 0;
    setUserIdIsSet(false);
    this.userId = 0;
    setErrorIdIsSet(false);
    this.errorId = 0;
    this.errorMsg = null;
    setActionFlagIsSet(false);
    this.actionFlag = 0;
    setLimitPriceIsSet(false);
    this.limitPrice = 0.0;
    setVolumeChangeIsSet(false);
    this.volumeChange = 0;
  }

  public String getSledId() {
    return this.sledId;
  }

  public CtpInputOrderActionRspField setSledId(String sledId) {
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

  public int getSledAccountId() {
    return this.sledAccountId;
  }

  public CtpInputOrderActionRspField setSledAccountId(int sledAccountId) {
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

  public CtpInputOrderActionRspField setUserId(int userId) {
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

  public int getErrorId() {
    return this.errorId;
  }

  public CtpInputOrderActionRspField setErrorId(int errorId) {
    this.errorId = errorId;
    setErrorIdIsSet(true);
    return this;
  }

  public void unsetErrorId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ERRORID_ISSET_ID);
  }

  /** Returns true if field errorId is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorId() {
    return EncodingUtils.testBit(__isset_bitfield, __ERRORID_ISSET_ID);
  }

  public void setErrorIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ERRORID_ISSET_ID, value);
  }

  public String getErrorMsg() {
    return this.errorMsg;
  }

  public CtpInputOrderActionRspField setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
    return this;
  }

  public void unsetErrorMsg() {
    this.errorMsg = null;
  }

  /** Returns true if field errorMsg is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorMsg() {
    return this.errorMsg != null;
  }

  public void setErrorMsgIsSet(boolean value) {
    if (!value) {
      this.errorMsg = null;
    }
  }

  public byte getActionFlag() {
    return this.actionFlag;
  }

  public CtpInputOrderActionRspField setActionFlag(byte actionFlag) {
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

  public double getLimitPrice() {
    return this.limitPrice;
  }

  public CtpInputOrderActionRspField setLimitPrice(double limitPrice) {
    this.limitPrice = limitPrice;
    setLimitPriceIsSet(true);
    return this;
  }

  public void unsetLimitPrice() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LIMITPRICE_ISSET_ID);
  }

  /** Returns true if field limitPrice is set (has been assigned a value) and false otherwise */
  public boolean isSetLimitPrice() {
    return EncodingUtils.testBit(__isset_bitfield, __LIMITPRICE_ISSET_ID);
  }

  public void setLimitPriceIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LIMITPRICE_ISSET_ID, value);
  }

  public int getVolumeChange() {
    return this.volumeChange;
  }

  public CtpInputOrderActionRspField setVolumeChange(int volumeChange) {
    this.volumeChange = volumeChange;
    setVolumeChangeIsSet(true);
    return this;
  }

  public void unsetVolumeChange() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __VOLUMECHANGE_ISSET_ID);
  }

  /** Returns true if field volumeChange is set (has been assigned a value) and false otherwise */
  public boolean isSetVolumeChange() {
    return EncodingUtils.testBit(__isset_bitfield, __VOLUMECHANGE_ISSET_ID);
  }

  public void setVolumeChangeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __VOLUMECHANGE_ISSET_ID, value);
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

    case ERROR_ID:
      if (value == null) {
        unsetErrorId();
      } else {
        setErrorId((Integer)value);
      }
      break;

    case ERROR_MSG:
      if (value == null) {
        unsetErrorMsg();
      } else {
        setErrorMsg((String)value);
      }
      break;

    case ACTION_FLAG:
      if (value == null) {
        unsetActionFlag();
      } else {
        setActionFlag((Byte)value);
      }
      break;

    case LIMIT_PRICE:
      if (value == null) {
        unsetLimitPrice();
      } else {
        setLimitPrice((Double)value);
      }
      break;

    case VOLUME_CHANGE:
      if (value == null) {
        unsetVolumeChange();
      } else {
        setVolumeChange((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SLED_ID:
      return getSledId();

    case SLED_ACCOUNT_ID:
      return Integer.valueOf(getSledAccountId());

    case USER_ID:
      return Integer.valueOf(getUserId());

    case ERROR_ID:
      return Integer.valueOf(getErrorId());

    case ERROR_MSG:
      return getErrorMsg();

    case ACTION_FLAG:
      return Byte.valueOf(getActionFlag());

    case LIMIT_PRICE:
      return Double.valueOf(getLimitPrice());

    case VOLUME_CHANGE:
      return Integer.valueOf(getVolumeChange());

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
    case SLED_ACCOUNT_ID:
      return isSetSledAccountId();
    case USER_ID:
      return isSetUserId();
    case ERROR_ID:
      return isSetErrorId();
    case ERROR_MSG:
      return isSetErrorMsg();
    case ACTION_FLAG:
      return isSetActionFlag();
    case LIMIT_PRICE:
      return isSetLimitPrice();
    case VOLUME_CHANGE:
      return isSetVolumeChange();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CtpInputOrderActionRspField)
      return this.equals((CtpInputOrderActionRspField)that);
    return false;
  }

  public boolean equals(CtpInputOrderActionRspField that) {
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

    boolean this_present_errorId = true && this.isSetErrorId();
    boolean that_present_errorId = true && that.isSetErrorId();
    if (this_present_errorId || that_present_errorId) {
      if (!(this_present_errorId && that_present_errorId))
        return false;
      if (this.errorId != that.errorId)
        return false;
    }

    boolean this_present_errorMsg = true && this.isSetErrorMsg();
    boolean that_present_errorMsg = true && that.isSetErrorMsg();
    if (this_present_errorMsg || that_present_errorMsg) {
      if (!(this_present_errorMsg && that_present_errorMsg))
        return false;
      if (!this.errorMsg.equals(that.errorMsg))
        return false;
    }

    boolean this_present_actionFlag = true && this.isSetActionFlag();
    boolean that_present_actionFlag = true && that.isSetActionFlag();
    if (this_present_actionFlag || that_present_actionFlag) {
      if (!(this_present_actionFlag && that_present_actionFlag))
        return false;
      if (this.actionFlag != that.actionFlag)
        return false;
    }

    boolean this_present_limitPrice = true && this.isSetLimitPrice();
    boolean that_present_limitPrice = true && that.isSetLimitPrice();
    if (this_present_limitPrice || that_present_limitPrice) {
      if (!(this_present_limitPrice && that_present_limitPrice))
        return false;
      if (this.limitPrice != that.limitPrice)
        return false;
    }

    boolean this_present_volumeChange = true && this.isSetVolumeChange();
    boolean that_present_volumeChange = true && that.isSetVolumeChange();
    if (this_present_volumeChange || that_present_volumeChange) {
      if (!(this_present_volumeChange && that_present_volumeChange))
        return false;
      if (this.volumeChange != that.volumeChange)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(CtpInputOrderActionRspField other) {
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
    lastComparison = Boolean.valueOf(isSetErrorId()).compareTo(other.isSetErrorId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorId, other.errorId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetErrorMsg()).compareTo(other.isSetErrorMsg());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorMsg()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorMsg, other.errorMsg);
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
    lastComparison = Boolean.valueOf(isSetLimitPrice()).compareTo(other.isSetLimitPrice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLimitPrice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.limitPrice, other.limitPrice);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVolumeChange()).compareTo(other.isSetVolumeChange());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVolumeChange()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.volumeChange, other.volumeChange);
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
    StringBuilder sb = new StringBuilder("CtpInputOrderActionRspField(");
    boolean first = true;

    if (isSetSledId()) {
      sb.append("sledId:");
      if (this.sledId == null) {
        sb.append("null");
      } else {
        sb.append(this.sledId);
      }
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
    if (isSetErrorId()) {
      if (!first) sb.append(", ");
      sb.append("errorId:");
      sb.append(this.errorId);
      first = false;
    }
    if (isSetErrorMsg()) {
      if (!first) sb.append(", ");
      sb.append("errorMsg:");
      if (this.errorMsg == null) {
        sb.append("null");
      } else {
        sb.append(this.errorMsg);
      }
      first = false;
    }
    if (isSetActionFlag()) {
      if (!first) sb.append(", ");
      sb.append("actionFlag:");
      sb.append(this.actionFlag);
      first = false;
    }
    if (isSetLimitPrice()) {
      if (!first) sb.append(", ");
      sb.append("limitPrice:");
      sb.append(this.limitPrice);
      first = false;
    }
    if (isSetVolumeChange()) {
      if (!first) sb.append(", ");
      sb.append("volumeChange:");
      sb.append(this.volumeChange);
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

  private static class CtpInputOrderActionRspFieldStandardSchemeFactory implements SchemeFactory {
    public CtpInputOrderActionRspFieldStandardScheme getScheme() {
      return new CtpInputOrderActionRspFieldStandardScheme();
    }
  }

  private static class CtpInputOrderActionRspFieldStandardScheme extends StandardScheme<CtpInputOrderActionRspField> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CtpInputOrderActionRspField struct) throws org.apache.thrift.TException {
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
          case 2: // SLED_ACCOUNT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledAccountId = iprot.readI32();
              struct.setSledAccountIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userId = iprot.readI32();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ERROR_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.errorId = iprot.readI32();
              struct.setErrorIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ERROR_MSG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.errorMsg = iprot.readString();
              struct.setErrorMsgIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ACTION_FLAG
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.actionFlag = iprot.readByte();
              struct.setActionFlagIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // LIMIT_PRICE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.limitPrice = iprot.readDouble();
              struct.setLimitPriceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // VOLUME_CHANGE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.volumeChange = iprot.readI32();
              struct.setVolumeChangeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CtpInputOrderActionRspField struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sledId != null) {
        if (struct.isSetSledId()) {
          oprot.writeFieldBegin(SLED_ID_FIELD_DESC);
          oprot.writeString(struct.sledId);
          oprot.writeFieldEnd();
        }
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
      if (struct.isSetErrorId()) {
        oprot.writeFieldBegin(ERROR_ID_FIELD_DESC);
        oprot.writeI32(struct.errorId);
        oprot.writeFieldEnd();
      }
      if (struct.errorMsg != null) {
        if (struct.isSetErrorMsg()) {
          oprot.writeFieldBegin(ERROR_MSG_FIELD_DESC);
          oprot.writeString(struct.errorMsg);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetActionFlag()) {
        oprot.writeFieldBegin(ACTION_FLAG_FIELD_DESC);
        oprot.writeByte(struct.actionFlag);
        oprot.writeFieldEnd();
      }
      if (struct.isSetLimitPrice()) {
        oprot.writeFieldBegin(LIMIT_PRICE_FIELD_DESC);
        oprot.writeDouble(struct.limitPrice);
        oprot.writeFieldEnd();
      }
      if (struct.isSetVolumeChange()) {
        oprot.writeFieldBegin(VOLUME_CHANGE_FIELD_DESC);
        oprot.writeI32(struct.volumeChange);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CtpInputOrderActionRspFieldTupleSchemeFactory implements SchemeFactory {
    public CtpInputOrderActionRspFieldTupleScheme getScheme() {
      return new CtpInputOrderActionRspFieldTupleScheme();
    }
  }

  private static class CtpInputOrderActionRspFieldTupleScheme extends TupleScheme<CtpInputOrderActionRspField> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CtpInputOrderActionRspField struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSledId()) {
        optionals.set(0);
      }
      if (struct.isSetSledAccountId()) {
        optionals.set(1);
      }
      if (struct.isSetUserId()) {
        optionals.set(2);
      }
      if (struct.isSetErrorId()) {
        optionals.set(3);
      }
      if (struct.isSetErrorMsg()) {
        optionals.set(4);
      }
      if (struct.isSetActionFlag()) {
        optionals.set(5);
      }
      if (struct.isSetLimitPrice()) {
        optionals.set(6);
      }
      if (struct.isSetVolumeChange()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetSledId()) {
        oprot.writeString(struct.sledId);
      }
      if (struct.isSetSledAccountId()) {
        oprot.writeI32(struct.sledAccountId);
      }
      if (struct.isSetUserId()) {
        oprot.writeI32(struct.userId);
      }
      if (struct.isSetErrorId()) {
        oprot.writeI32(struct.errorId);
      }
      if (struct.isSetErrorMsg()) {
        oprot.writeString(struct.errorMsg);
      }
      if (struct.isSetActionFlag()) {
        oprot.writeByte(struct.actionFlag);
      }
      if (struct.isSetLimitPrice()) {
        oprot.writeDouble(struct.limitPrice);
      }
      if (struct.isSetVolumeChange()) {
        oprot.writeI32(struct.volumeChange);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CtpInputOrderActionRspField struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.sledId = iprot.readString();
        struct.setSledIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.sledAccountId = iprot.readI32();
        struct.setSledAccountIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.userId = iprot.readI32();
        struct.setUserIdIsSet(true);
      }
      if (incoming.get(3)) {
        struct.errorId = iprot.readI32();
        struct.setErrorIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.errorMsg = iprot.readString();
        struct.setErrorMsgIsSet(true);
      }
      if (incoming.get(5)) {
        struct.actionFlag = iprot.readByte();
        struct.setActionFlagIsSet(true);
      }
      if (incoming.get(6)) {
        struct.limitPrice = iprot.readDouble();
        struct.setLimitPriceIsSet(true);
      }
      if (incoming.get(7)) {
        struct.volumeChange = iprot.readI32();
        struct.setVolumeChangeIsSet(true);
      }
    }
  }

}
