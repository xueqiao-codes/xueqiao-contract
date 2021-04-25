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

public class CtpAccount implements org.apache.thrift.TBase<CtpAccount, CtpAccount._Fields>, java.io.Serializable, Cloneable, Comparable<CtpAccount> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CtpAccount");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField HOSTS_FIELD_DESC = new org.apache.thrift.protocol.TField("hosts", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField BROKER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("brokerId", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField ACTIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("active", org.apache.thrift.protocol.TType.BOOL, (short)6);
  private static final org.apache.thrift.protocol.TField BROKER_SYS_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("brokerSysId", org.apache.thrift.protocol.TType.I32, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CtpAccountStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CtpAccountTupleSchemeFactory());
  }

  public int id; // optional
  public List<String> hosts; // optional
  public String brokerId; // optional
  public String userId; // optional
  public String password; // optional
  public boolean active; // optional
  public int brokerSysId; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    HOSTS((short)2, "hosts"),
    BROKER_ID((short)3, "brokerId"),
    USER_ID((short)4, "userId"),
    PASSWORD((short)5, "password"),
    ACTIVE((short)6, "active"),
    BROKER_SYS_ID((short)7, "brokerSysId");

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
        case 1: // ID
          return ID;
        case 2: // HOSTS
          return HOSTS;
        case 3: // BROKER_ID
          return BROKER_ID;
        case 4: // USER_ID
          return USER_ID;
        case 5: // PASSWORD
          return PASSWORD;
        case 6: // ACTIVE
          return ACTIVE;
        case 7: // BROKER_SYS_ID
          return BROKER_SYS_ID;
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
  private static final int __ID_ISSET_ID = 0;
  private static final int __ACTIVE_ISSET_ID = 1;
  private static final int __BROKERSYSID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.ID,_Fields.HOSTS,_Fields.BROKER_ID,_Fields.USER_ID,_Fields.PASSWORD,_Fields.ACTIVE,_Fields.BROKER_SYS_ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.HOSTS, new org.apache.thrift.meta_data.FieldMetaData("hosts", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.BROKER_ID, new org.apache.thrift.meta_data.FieldMetaData("brokerId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ACTIVE, new org.apache.thrift.meta_data.FieldMetaData("active", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.BROKER_SYS_ID, new org.apache.thrift.meta_data.FieldMetaData("brokerSysId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CtpAccount.class, metaDataMap);
  }

  public CtpAccount() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CtpAccount(CtpAccount other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetHosts()) {
      List<String> __this__hosts = new ArrayList<String>(other.hosts);
      this.hosts = __this__hosts;
    }
    if (other.isSetBrokerId()) {
      this.brokerId = other.brokerId;
    }
    if (other.isSetUserId()) {
      this.userId = other.userId;
    }
    if (other.isSetPassword()) {
      this.password = other.password;
    }
    this.active = other.active;
    this.brokerSysId = other.brokerSysId;
  }

  public CtpAccount deepCopy() {
    return new CtpAccount(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.hosts = null;
    this.brokerId = null;
    this.userId = null;
    this.password = null;
    setActiveIsSet(false);
    this.active = false;
    setBrokerSysIdIsSet(false);
    this.brokerSysId = 0;
  }

  public int getId() {
    return this.id;
  }

  public CtpAccount setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public int getHostsSize() {
    return (this.hosts == null) ? 0 : this.hosts.size();
  }

  public java.util.Iterator<String> getHostsIterator() {
    return (this.hosts == null) ? null : this.hosts.iterator();
  }

  public void addToHosts(String elem) {
    if (this.hosts == null) {
      this.hosts = new ArrayList<String>();
    }
    this.hosts.add(elem);
  }

  public List<String> getHosts() {
    return this.hosts;
  }

  public CtpAccount setHosts(List<String> hosts) {
    this.hosts = hosts;
    return this;
  }

  public void unsetHosts() {
    this.hosts = null;
  }

  /** Returns true if field hosts is set (has been assigned a value) and false otherwise */
  public boolean isSetHosts() {
    return this.hosts != null;
  }

  public void setHostsIsSet(boolean value) {
    if (!value) {
      this.hosts = null;
    }
  }

  public String getBrokerId() {
    return this.brokerId;
  }

  public CtpAccount setBrokerId(String brokerId) {
    this.brokerId = brokerId;
    return this;
  }

  public void unsetBrokerId() {
    this.brokerId = null;
  }

  /** Returns true if field brokerId is set (has been assigned a value) and false otherwise */
  public boolean isSetBrokerId() {
    return this.brokerId != null;
  }

  public void setBrokerIdIsSet(boolean value) {
    if (!value) {
      this.brokerId = null;
    }
  }

  public String getUserId() {
    return this.userId;
  }

  public CtpAccount setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public void unsetUserId() {
    this.userId = null;
  }

  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return this.userId != null;
  }

  public void setUserIdIsSet(boolean value) {
    if (!value) {
      this.userId = null;
    }
  }

  public String getPassword() {
    return this.password;
  }

  public CtpAccount setPassword(String password) {
    this.password = password;
    return this;
  }

  public void unsetPassword() {
    this.password = null;
  }

  /** Returns true if field password is set (has been assigned a value) and false otherwise */
  public boolean isSetPassword() {
    return this.password != null;
  }

  public void setPasswordIsSet(boolean value) {
    if (!value) {
      this.password = null;
    }
  }

  public boolean isActive() {
    return this.active;
  }

  public CtpAccount setActive(boolean active) {
    this.active = active;
    setActiveIsSet(true);
    return this;
  }

  public void unsetActive() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ACTIVE_ISSET_ID);
  }

  /** Returns true if field active is set (has been assigned a value) and false otherwise */
  public boolean isSetActive() {
    return EncodingUtils.testBit(__isset_bitfield, __ACTIVE_ISSET_ID);
  }

  public void setActiveIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ACTIVE_ISSET_ID, value);
  }

  public int getBrokerSysId() {
    return this.brokerSysId;
  }

  public CtpAccount setBrokerSysId(int brokerSysId) {
    this.brokerSysId = brokerSysId;
    setBrokerSysIdIsSet(true);
    return this;
  }

  public void unsetBrokerSysId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __BROKERSYSID_ISSET_ID);
  }

  /** Returns true if field brokerSysId is set (has been assigned a value) and false otherwise */
  public boolean isSetBrokerSysId() {
    return EncodingUtils.testBit(__isset_bitfield, __BROKERSYSID_ISSET_ID);
  }

  public void setBrokerSysIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __BROKERSYSID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case HOSTS:
      if (value == null) {
        unsetHosts();
      } else {
        setHosts((List<String>)value);
      }
      break;

    case BROKER_ID:
      if (value == null) {
        unsetBrokerId();
      } else {
        setBrokerId((String)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((String)value);
      }
      break;

    case PASSWORD:
      if (value == null) {
        unsetPassword();
      } else {
        setPassword((String)value);
      }
      break;

    case ACTIVE:
      if (value == null) {
        unsetActive();
      } else {
        setActive((Boolean)value);
      }
      break;

    case BROKER_SYS_ID:
      if (value == null) {
        unsetBrokerSysId();
      } else {
        setBrokerSysId((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return Integer.valueOf(getId());

    case HOSTS:
      return getHosts();

    case BROKER_ID:
      return getBrokerId();

    case USER_ID:
      return getUserId();

    case PASSWORD:
      return getPassword();

    case ACTIVE:
      return Boolean.valueOf(isActive());

    case BROKER_SYS_ID:
      return Integer.valueOf(getBrokerSysId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case HOSTS:
      return isSetHosts();
    case BROKER_ID:
      return isSetBrokerId();
    case USER_ID:
      return isSetUserId();
    case PASSWORD:
      return isSetPassword();
    case ACTIVE:
      return isSetActive();
    case BROKER_SYS_ID:
      return isSetBrokerSysId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CtpAccount)
      return this.equals((CtpAccount)that);
    return false;
  }

  public boolean equals(CtpAccount that) {
    if (that == null)
      return false;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_hosts = true && this.isSetHosts();
    boolean that_present_hosts = true && that.isSetHosts();
    if (this_present_hosts || that_present_hosts) {
      if (!(this_present_hosts && that_present_hosts))
        return false;
      if (!this.hosts.equals(that.hosts))
        return false;
    }

    boolean this_present_brokerId = true && this.isSetBrokerId();
    boolean that_present_brokerId = true && that.isSetBrokerId();
    if (this_present_brokerId || that_present_brokerId) {
      if (!(this_present_brokerId && that_present_brokerId))
        return false;
      if (!this.brokerId.equals(that.brokerId))
        return false;
    }

    boolean this_present_userId = true && this.isSetUserId();
    boolean that_present_userId = true && that.isSetUserId();
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (!this.userId.equals(that.userId))
        return false;
    }

    boolean this_present_password = true && this.isSetPassword();
    boolean that_present_password = true && that.isSetPassword();
    if (this_present_password || that_present_password) {
      if (!(this_present_password && that_present_password))
        return false;
      if (!this.password.equals(that.password))
        return false;
    }

    boolean this_present_active = true && this.isSetActive();
    boolean that_present_active = true && that.isSetActive();
    if (this_present_active || that_present_active) {
      if (!(this_present_active && that_present_active))
        return false;
      if (this.active != that.active)
        return false;
    }

    boolean this_present_brokerSysId = true && this.isSetBrokerSysId();
    boolean that_present_brokerSysId = true && that.isSetBrokerSysId();
    if (this_present_brokerSysId || that_present_brokerSysId) {
      if (!(this_present_brokerSysId && that_present_brokerSysId))
        return false;
      if (this.brokerSysId != that.brokerSysId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(CtpAccount other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHosts()).compareTo(other.isSetHosts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHosts()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hosts, other.hosts);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBrokerId()).compareTo(other.isSetBrokerId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBrokerId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.brokerId, other.brokerId);
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
    lastComparison = Boolean.valueOf(isSetPassword()).compareTo(other.isSetPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, other.password);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetActive()).compareTo(other.isSetActive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetActive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.active, other.active);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBrokerSysId()).compareTo(other.isSetBrokerSysId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBrokerSysId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.brokerSysId, other.brokerSysId);
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
    StringBuilder sb = new StringBuilder("CtpAccount(");
    boolean first = true;

    if (isSetId()) {
      sb.append("id:");
      sb.append(this.id);
      first = false;
    }
    if (isSetHosts()) {
      if (!first) sb.append(", ");
      sb.append("hosts:");
      if (this.hosts == null) {
        sb.append("null");
      } else {
        sb.append(this.hosts);
      }
      first = false;
    }
    if (isSetBrokerId()) {
      if (!first) sb.append(", ");
      sb.append("brokerId:");
      if (this.brokerId == null) {
        sb.append("null");
      } else {
        sb.append(this.brokerId);
      }
      first = false;
    }
    if (isSetUserId()) {
      if (!first) sb.append(", ");
      sb.append("userId:");
      if (this.userId == null) {
        sb.append("null");
      } else {
        sb.append(this.userId);
      }
      first = false;
    }
    if (isSetPassword()) {
      if (!first) sb.append(", ");
      sb.append("password:");
      if (this.password == null) {
        sb.append("null");
      } else {
        sb.append(this.password);
      }
      first = false;
    }
    if (isSetActive()) {
      if (!first) sb.append(", ");
      sb.append("active:");
      sb.append(this.active);
      first = false;
    }
    if (isSetBrokerSysId()) {
      if (!first) sb.append(", ");
      sb.append("brokerSysId:");
      sb.append(this.brokerSysId);
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

  private static class CtpAccountStandardSchemeFactory implements SchemeFactory {
    public CtpAccountStandardScheme getScheme() {
      return new CtpAccountStandardScheme();
    }
  }

  private static class CtpAccountStandardScheme extends StandardScheme<CtpAccount> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CtpAccount struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // HOSTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.hosts = new ArrayList<String>(_list8.size);
                for (int _i9 = 0; _i9 < _list8.size; ++_i9)
                {
                  String _elem10;
                  _elem10 = iprot.readString();
                  struct.hosts.add(_elem10);
                }
                iprot.readListEnd();
              }
              struct.setHostsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BROKER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.brokerId = iprot.readString();
              struct.setBrokerIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.userId = iprot.readString();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.password = iprot.readString();
              struct.setPasswordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ACTIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.active = iprot.readBool();
              struct.setActiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // BROKER_SYS_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.brokerSysId = iprot.readI32();
              struct.setBrokerSysIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CtpAccount struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetId()) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeI32(struct.id);
        oprot.writeFieldEnd();
      }
      if (struct.hosts != null) {
        if (struct.isSetHosts()) {
          oprot.writeFieldBegin(HOSTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.hosts.size()));
            for (String _iter11 : struct.hosts)
            {
              oprot.writeString(_iter11);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.brokerId != null) {
        if (struct.isSetBrokerId()) {
          oprot.writeFieldBegin(BROKER_ID_FIELD_DESC);
          oprot.writeString(struct.brokerId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.userId != null) {
        if (struct.isSetUserId()) {
          oprot.writeFieldBegin(USER_ID_FIELD_DESC);
          oprot.writeString(struct.userId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.password != null) {
        if (struct.isSetPassword()) {
          oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
          oprot.writeString(struct.password);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetActive()) {
        oprot.writeFieldBegin(ACTIVE_FIELD_DESC);
        oprot.writeBool(struct.active);
        oprot.writeFieldEnd();
      }
      if (struct.isSetBrokerSysId()) {
        oprot.writeFieldBegin(BROKER_SYS_ID_FIELD_DESC);
        oprot.writeI32(struct.brokerSysId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CtpAccountTupleSchemeFactory implements SchemeFactory {
    public CtpAccountTupleScheme getScheme() {
      return new CtpAccountTupleScheme();
    }
  }

  private static class CtpAccountTupleScheme extends TupleScheme<CtpAccount> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CtpAccount struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetHosts()) {
        optionals.set(1);
      }
      if (struct.isSetBrokerId()) {
        optionals.set(2);
      }
      if (struct.isSetUserId()) {
        optionals.set(3);
      }
      if (struct.isSetPassword()) {
        optionals.set(4);
      }
      if (struct.isSetActive()) {
        optionals.set(5);
      }
      if (struct.isSetBrokerSysId()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetHosts()) {
        {
          oprot.writeI32(struct.hosts.size());
          for (String _iter12 : struct.hosts)
          {
            oprot.writeString(_iter12);
          }
        }
      }
      if (struct.isSetBrokerId()) {
        oprot.writeString(struct.brokerId);
      }
      if (struct.isSetUserId()) {
        oprot.writeString(struct.userId);
      }
      if (struct.isSetPassword()) {
        oprot.writeString(struct.password);
      }
      if (struct.isSetActive()) {
        oprot.writeBool(struct.active);
      }
      if (struct.isSetBrokerSysId()) {
        oprot.writeI32(struct.brokerSysId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CtpAccount struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.hosts = new ArrayList<String>(_list13.size);
          for (int _i14 = 0; _i14 < _list13.size; ++_i14)
          {
            String _elem15;
            _elem15 = iprot.readString();
            struct.hosts.add(_elem15);
          }
        }
        struct.setHostsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.brokerId = iprot.readString();
        struct.setBrokerIdIsSet(true);
      }
      if (incoming.get(3)) {
        struct.userId = iprot.readString();
        struct.setUserIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.password = iprot.readString();
        struct.setPasswordIsSet(true);
      }
      if (incoming.get(5)) {
        struct.active = iprot.readBool();
        struct.setActiveIsSet(true);
      }
      if (incoming.get(6)) {
        struct.brokerSysId = iprot.readI32();
        struct.setBrokerSysIdIsSet(true);
      }
    }
  }

}
