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

public class StdOrderInsertErrField implements org.apache.thrift.TBase<StdOrderInsertErrField, StdOrderInsertErrField._Fields>, java.io.Serializable, Cloneable, Comparable<StdOrderInsertErrField> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StdOrderInsertErrField");

  private static final org.apache.thrift.protocol.TField SLED_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ERROR_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("errorID", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField ERROR_MSG_FIELD_DESC = new org.apache.thrift.protocol.TField("errorMsg", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField SLED_ACCOUNT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledAccountId", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField SAVE_STRING_FIELD_DESC = new org.apache.thrift.protocol.TField("saveString", org.apache.thrift.protocol.TType.STRING, (short)30);
  private static final org.apache.thrift.protocol.TField SERIAL_VERSION_UID_FIELD_DESC = new org.apache.thrift.protocol.TField("serialVersionUID", org.apache.thrift.protocol.TType.I64, (short)101);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new StdOrderInsertErrFieldStandardSchemeFactory());
    schemes.put(TupleScheme.class, new StdOrderInsertErrFieldTupleSchemeFactory());
  }

  public String sledId; // required
  public int errorID; // required
  public String errorMsg; // required
  public int sledAccountId; // optional
  public int userId; // optional
  public String saveString; // optional
  public long serialVersionUID; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLED_ID((short)1, "sledId"),
    ERROR_ID((short)2, "errorID"),
    ERROR_MSG((short)3, "errorMsg"),
    SLED_ACCOUNT_ID((short)4, "sledAccountId"),
    USER_ID((short)5, "userId"),
    SAVE_STRING((short)30, "saveString"),
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
        case 2: // ERROR_ID
          return ERROR_ID;
        case 3: // ERROR_MSG
          return ERROR_MSG;
        case 4: // SLED_ACCOUNT_ID
          return SLED_ACCOUNT_ID;
        case 5: // USER_ID
          return USER_ID;
        case 30: // SAVE_STRING
          return SAVE_STRING;
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
  private static final int __ERRORID_ISSET_ID = 0;
  private static final int __SLEDACCOUNTID_ISSET_ID = 1;
  private static final int __USERID_ISSET_ID = 2;
  private static final int __SERIALVERSIONUID_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.SLED_ACCOUNT_ID,_Fields.USER_ID,_Fields.SAVE_STRING,_Fields.SERIAL_VERSION_UID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLED_ID, new org.apache.thrift.meta_data.FieldMetaData("sledId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ERROR_ID, new org.apache.thrift.meta_data.FieldMetaData("errorID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ERROR_MSG, new org.apache.thrift.meta_data.FieldMetaData("errorMsg", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SLED_ACCOUNT_ID, new org.apache.thrift.meta_data.FieldMetaData("sledAccountId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SAVE_STRING, new org.apache.thrift.meta_data.FieldMetaData("saveString", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SERIAL_VERSION_UID, new org.apache.thrift.meta_data.FieldMetaData("serialVersionUID", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StdOrderInsertErrField.class, metaDataMap);
  }

  public StdOrderInsertErrField() {
  }

  public StdOrderInsertErrField(
    String sledId,
    int errorID,
    String errorMsg)
  {
    this();
    this.sledId = sledId;
    this.errorID = errorID;
    setErrorIDIsSet(true);
    this.errorMsg = errorMsg;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public StdOrderInsertErrField(StdOrderInsertErrField other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetSledId()) {
      this.sledId = other.sledId;
    }
    this.errorID = other.errorID;
    if (other.isSetErrorMsg()) {
      this.errorMsg = other.errorMsg;
    }
    this.sledAccountId = other.sledAccountId;
    this.userId = other.userId;
    if (other.isSetSaveString()) {
      this.saveString = other.saveString;
    }
    this.serialVersionUID = other.serialVersionUID;
  }

  public StdOrderInsertErrField deepCopy() {
    return new StdOrderInsertErrField(this);
  }

  @Override
  public void clear() {
    this.sledId = null;
    setErrorIDIsSet(false);
    this.errorID = 0;
    this.errorMsg = null;
    setSledAccountIdIsSet(false);
    this.sledAccountId = 0;
    setUserIdIsSet(false);
    this.userId = 0;
    this.saveString = null;
    setSerialVersionUIDIsSet(false);
    this.serialVersionUID = 0;
  }

  public String getSledId() {
    return this.sledId;
  }

  public StdOrderInsertErrField setSledId(String sledId) {
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

  public int getErrorID() {
    return this.errorID;
  }

  public StdOrderInsertErrField setErrorID(int errorID) {
    this.errorID = errorID;
    setErrorIDIsSet(true);
    return this;
  }

  public void unsetErrorID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ERRORID_ISSET_ID);
  }

  /** Returns true if field errorID is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorID() {
    return EncodingUtils.testBit(__isset_bitfield, __ERRORID_ISSET_ID);
  }

  public void setErrorIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ERRORID_ISSET_ID, value);
  }

  public String getErrorMsg() {
    return this.errorMsg;
  }

  public StdOrderInsertErrField setErrorMsg(String errorMsg) {
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

  public int getSledAccountId() {
    return this.sledAccountId;
  }

  public StdOrderInsertErrField setSledAccountId(int sledAccountId) {
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

  public StdOrderInsertErrField setUserId(int userId) {
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

  public String getSaveString() {
    return this.saveString;
  }

  public StdOrderInsertErrField setSaveString(String saveString) {
    this.saveString = saveString;
    return this;
  }

  public void unsetSaveString() {
    this.saveString = null;
  }

  /** Returns true if field saveString is set (has been assigned a value) and false otherwise */
  public boolean isSetSaveString() {
    return this.saveString != null;
  }

  public void setSaveStringIsSet(boolean value) {
    if (!value) {
      this.saveString = null;
    }
  }

  public long getSerialVersionUID() {
    return this.serialVersionUID;
  }

  public StdOrderInsertErrField setSerialVersionUID(long serialVersionUID) {
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

    case ERROR_ID:
      if (value == null) {
        unsetErrorID();
      } else {
        setErrorID((Integer)value);
      }
      break;

    case ERROR_MSG:
      if (value == null) {
        unsetErrorMsg();
      } else {
        setErrorMsg((String)value);
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

    case SAVE_STRING:
      if (value == null) {
        unsetSaveString();
      } else {
        setSaveString((String)value);
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

    case ERROR_ID:
      return Integer.valueOf(getErrorID());

    case ERROR_MSG:
      return getErrorMsg();

    case SLED_ACCOUNT_ID:
      return Integer.valueOf(getSledAccountId());

    case USER_ID:
      return Integer.valueOf(getUserId());

    case SAVE_STRING:
      return getSaveString();

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
    case ERROR_ID:
      return isSetErrorID();
    case ERROR_MSG:
      return isSetErrorMsg();
    case SLED_ACCOUNT_ID:
      return isSetSledAccountId();
    case USER_ID:
      return isSetUserId();
    case SAVE_STRING:
      return isSetSaveString();
    case SERIAL_VERSION_UID:
      return isSetSerialVersionUID();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof StdOrderInsertErrField)
      return this.equals((StdOrderInsertErrField)that);
    return false;
  }

  public boolean equals(StdOrderInsertErrField that) {
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

    boolean this_present_errorID = true;
    boolean that_present_errorID = true;
    if (this_present_errorID || that_present_errorID) {
      if (!(this_present_errorID && that_present_errorID))
        return false;
      if (this.errorID != that.errorID)
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

    boolean this_present_saveString = true && this.isSetSaveString();
    boolean that_present_saveString = true && that.isSetSaveString();
    if (this_present_saveString || that_present_saveString) {
      if (!(this_present_saveString && that_present_saveString))
        return false;
      if (!this.saveString.equals(that.saveString))
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
  public int compareTo(StdOrderInsertErrField other) {
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
    lastComparison = Boolean.valueOf(isSetErrorID()).compareTo(other.isSetErrorID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorID, other.errorID);
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
    lastComparison = Boolean.valueOf(isSetSaveString()).compareTo(other.isSetSaveString());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSaveString()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.saveString, other.saveString);
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
    StringBuilder sb = new StringBuilder("StdOrderInsertErrField(");
    boolean first = true;

    sb.append("sledId:");
    if (this.sledId == null) {
      sb.append("null");
    } else {
      sb.append(this.sledId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("errorID:");
    sb.append(this.errorID);
    first = false;
    if (!first) sb.append(", ");
    sb.append("errorMsg:");
    if (this.errorMsg == null) {
      sb.append("null");
    } else {
      sb.append(this.errorMsg);
    }
    first = false;
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
    if (isSetSaveString()) {
      if (!first) sb.append(", ");
      sb.append("saveString:");
      if (this.saveString == null) {
        sb.append("null");
      } else {
        sb.append(this.saveString);
      }
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
    // alas, we cannot check 'errorID' because it's a primitive and you chose the non-beans generator.
    if (errorMsg == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'errorMsg' was not present! Struct: " + toString());
    }
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

  private static class StdOrderInsertErrFieldStandardSchemeFactory implements SchemeFactory {
    public StdOrderInsertErrFieldStandardScheme getScheme() {
      return new StdOrderInsertErrFieldStandardScheme();
    }
  }

  private static class StdOrderInsertErrFieldStandardScheme extends StandardScheme<StdOrderInsertErrField> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, StdOrderInsertErrField struct) throws org.apache.thrift.TException {
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
          case 2: // ERROR_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.errorID = iprot.readI32();
              struct.setErrorIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ERROR_MSG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.errorMsg = iprot.readString();
              struct.setErrorMsgIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SLED_ACCOUNT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledAccountId = iprot.readI32();
              struct.setSledAccountIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userId = iprot.readI32();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 30: // SAVE_STRING
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.saveString = iprot.readString();
              struct.setSaveStringIsSet(true);
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
      if (!struct.isSetErrorID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'errorID' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, StdOrderInsertErrField struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sledId != null) {
        oprot.writeFieldBegin(SLED_ID_FIELD_DESC);
        oprot.writeString(struct.sledId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ERROR_ID_FIELD_DESC);
      oprot.writeI32(struct.errorID);
      oprot.writeFieldEnd();
      if (struct.errorMsg != null) {
        oprot.writeFieldBegin(ERROR_MSG_FIELD_DESC);
        oprot.writeString(struct.errorMsg);
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
      if (struct.saveString != null) {
        if (struct.isSetSaveString()) {
          oprot.writeFieldBegin(SAVE_STRING_FIELD_DESC);
          oprot.writeString(struct.saveString);
          oprot.writeFieldEnd();
        }
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

  private static class StdOrderInsertErrFieldTupleSchemeFactory implements SchemeFactory {
    public StdOrderInsertErrFieldTupleScheme getScheme() {
      return new StdOrderInsertErrFieldTupleScheme();
    }
  }

  private static class StdOrderInsertErrFieldTupleScheme extends TupleScheme<StdOrderInsertErrField> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, StdOrderInsertErrField struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.sledId);
      oprot.writeI32(struct.errorID);
      oprot.writeString(struct.errorMsg);
      BitSet optionals = new BitSet();
      if (struct.isSetSledAccountId()) {
        optionals.set(0);
      }
      if (struct.isSetUserId()) {
        optionals.set(1);
      }
      if (struct.isSetSaveString()) {
        optionals.set(2);
      }
      if (struct.isSetSerialVersionUID()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetSledAccountId()) {
        oprot.writeI32(struct.sledAccountId);
      }
      if (struct.isSetUserId()) {
        oprot.writeI32(struct.userId);
      }
      if (struct.isSetSaveString()) {
        oprot.writeString(struct.saveString);
      }
      if (struct.isSetSerialVersionUID()) {
        oprot.writeI64(struct.serialVersionUID);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, StdOrderInsertErrField struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.sledId = iprot.readString();
      struct.setSledIdIsSet(true);
      struct.errorID = iprot.readI32();
      struct.setErrorIDIsSet(true);
      struct.errorMsg = iprot.readString();
      struct.setErrorMsgIsSet(true);
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.sledAccountId = iprot.readI32();
        struct.setSledAccountIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.userId = iprot.readI32();
        struct.setUserIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.saveString = iprot.readString();
        struct.setSaveStringIsSet(true);
      }
      if (incoming.get(3)) {
        struct.serialVersionUID = iprot.readI64();
        struct.setSerialVersionUIDIsSet(true);
      }
    }
  }

}
