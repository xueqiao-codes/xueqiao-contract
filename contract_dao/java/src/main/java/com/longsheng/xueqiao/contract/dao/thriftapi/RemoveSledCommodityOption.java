/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.contract.dao.thriftapi;

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

public class RemoveSledCommodityOption implements org.apache.thrift.TBase<RemoveSledCommodityOption, RemoveSledCommodityOption._Fields>, java.io.Serializable, Cloneable, Comparable<RemoveSledCommodityOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RemoveSledCommodityOption");

  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField BROKER_ENTRY_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("brokerEntryIds", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RemoveSledCommodityOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RemoveSledCommodityOptionTupleSchemeFactory());
  }

  public int sledCommodityId; // optional
  public List<Integer> brokerEntryIds; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLED_COMMODITY_ID((short)1, "sledCommodityId"),
    BROKER_ENTRY_IDS((short)2, "brokerEntryIds");

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
        case 1: // SLED_COMMODITY_ID
          return SLED_COMMODITY_ID;
        case 2: // BROKER_ENTRY_IDS
          return BROKER_ENTRY_IDS;
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
  private _Fields optionals[] = {_Fields.SLED_COMMODITY_ID,_Fields.BROKER_ENTRY_IDS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLED_COMMODITY_ID, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.BROKER_ENTRY_IDS, new org.apache.thrift.meta_data.FieldMetaData("brokerEntryIds", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RemoveSledCommodityOption.class, metaDataMap);
  }

  public RemoveSledCommodityOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RemoveSledCommodityOption(RemoveSledCommodityOption other) {
    __isset_bitfield = other.__isset_bitfield;
    this.sledCommodityId = other.sledCommodityId;
    if (other.isSetBrokerEntryIds()) {
      List<Integer> __this__brokerEntryIds = new ArrayList<Integer>(other.brokerEntryIds);
      this.brokerEntryIds = __this__brokerEntryIds;
    }
  }

  public RemoveSledCommodityOption deepCopy() {
    return new RemoveSledCommodityOption(this);
  }

  @Override
  public void clear() {
    setSledCommodityIdIsSet(false);
    this.sledCommodityId = 0;
    this.brokerEntryIds = null;
  }

  public int getSledCommodityId() {
    return this.sledCommodityId;
  }

  public RemoveSledCommodityOption setSledCommodityId(int sledCommodityId) {
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

  public int getBrokerEntryIdsSize() {
    return (this.brokerEntryIds == null) ? 0 : this.brokerEntryIds.size();
  }

  public java.util.Iterator<Integer> getBrokerEntryIdsIterator() {
    return (this.brokerEntryIds == null) ? null : this.brokerEntryIds.iterator();
  }

  public void addToBrokerEntryIds(int elem) {
    if (this.brokerEntryIds == null) {
      this.brokerEntryIds = new ArrayList<Integer>();
    }
    this.brokerEntryIds.add(elem);
  }

  public List<Integer> getBrokerEntryIds() {
    return this.brokerEntryIds;
  }

  public RemoveSledCommodityOption setBrokerEntryIds(List<Integer> brokerEntryIds) {
    this.brokerEntryIds = brokerEntryIds;
    return this;
  }

  public void unsetBrokerEntryIds() {
    this.brokerEntryIds = null;
  }

  /** Returns true if field brokerEntryIds is set (has been assigned a value) and false otherwise */
  public boolean isSetBrokerEntryIds() {
    return this.brokerEntryIds != null;
  }

  public void setBrokerEntryIdsIsSet(boolean value) {
    if (!value) {
      this.brokerEntryIds = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SLED_COMMODITY_ID:
      if (value == null) {
        unsetSledCommodityId();
      } else {
        setSledCommodityId((Integer)value);
      }
      break;

    case BROKER_ENTRY_IDS:
      if (value == null) {
        unsetBrokerEntryIds();
      } else {
        setBrokerEntryIds((List<Integer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SLED_COMMODITY_ID:
      return Integer.valueOf(getSledCommodityId());

    case BROKER_ENTRY_IDS:
      return getBrokerEntryIds();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SLED_COMMODITY_ID:
      return isSetSledCommodityId();
    case BROKER_ENTRY_IDS:
      return isSetBrokerEntryIds();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RemoveSledCommodityOption)
      return this.equals((RemoveSledCommodityOption)that);
    return false;
  }

  public boolean equals(RemoveSledCommodityOption that) {
    if (that == null)
      return false;

    boolean this_present_sledCommodityId = true && this.isSetSledCommodityId();
    boolean that_present_sledCommodityId = true && that.isSetSledCommodityId();
    if (this_present_sledCommodityId || that_present_sledCommodityId) {
      if (!(this_present_sledCommodityId && that_present_sledCommodityId))
        return false;
      if (this.sledCommodityId != that.sledCommodityId)
        return false;
    }

    boolean this_present_brokerEntryIds = true && this.isSetBrokerEntryIds();
    boolean that_present_brokerEntryIds = true && that.isSetBrokerEntryIds();
    if (this_present_brokerEntryIds || that_present_brokerEntryIds) {
      if (!(this_present_brokerEntryIds && that_present_brokerEntryIds))
        return false;
      if (!this.brokerEntryIds.equals(that.brokerEntryIds))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(RemoveSledCommodityOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetBrokerEntryIds()).compareTo(other.isSetBrokerEntryIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBrokerEntryIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.brokerEntryIds, other.brokerEntryIds);
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
    StringBuilder sb = new StringBuilder("RemoveSledCommodityOption(");
    boolean first = true;

    if (isSetSledCommodityId()) {
      sb.append("sledCommodityId:");
      sb.append(this.sledCommodityId);
      first = false;
    }
    if (isSetBrokerEntryIds()) {
      if (!first) sb.append(", ");
      sb.append("brokerEntryIds:");
      if (this.brokerEntryIds == null) {
        sb.append("null");
      } else {
        sb.append(this.brokerEntryIds);
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

  private static class RemoveSledCommodityOptionStandardSchemeFactory implements SchemeFactory {
    public RemoveSledCommodityOptionStandardScheme getScheme() {
      return new RemoveSledCommodityOptionStandardScheme();
    }
  }

  private static class RemoveSledCommodityOptionStandardScheme extends StandardScheme<RemoveSledCommodityOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RemoveSledCommodityOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SLED_COMMODITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledCommodityId = iprot.readI32();
              struct.setSledCommodityIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BROKER_ENTRY_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list224 = iprot.readListBegin();
                struct.brokerEntryIds = new ArrayList<Integer>(_list224.size);
                for (int _i225 = 0; _i225 < _list224.size; ++_i225)
                {
                  int _elem226;
                  _elem226 = iprot.readI32();
                  struct.brokerEntryIds.add(_elem226);
                }
                iprot.readListEnd();
              }
              struct.setBrokerEntryIdsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RemoveSledCommodityOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetSledCommodityId()) {
        oprot.writeFieldBegin(SLED_COMMODITY_ID_FIELD_DESC);
        oprot.writeI32(struct.sledCommodityId);
        oprot.writeFieldEnd();
      }
      if (struct.brokerEntryIds != null) {
        if (struct.isSetBrokerEntryIds()) {
          oprot.writeFieldBegin(BROKER_ENTRY_IDS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.brokerEntryIds.size()));
            for (int _iter227 : struct.brokerEntryIds)
            {
              oprot.writeI32(_iter227);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RemoveSledCommodityOptionTupleSchemeFactory implements SchemeFactory {
    public RemoveSledCommodityOptionTupleScheme getScheme() {
      return new RemoveSledCommodityOptionTupleScheme();
    }
  }

  private static class RemoveSledCommodityOptionTupleScheme extends TupleScheme<RemoveSledCommodityOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RemoveSledCommodityOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSledCommodityId()) {
        optionals.set(0);
      }
      if (struct.isSetBrokerEntryIds()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetSledCommodityId()) {
        oprot.writeI32(struct.sledCommodityId);
      }
      if (struct.isSetBrokerEntryIds()) {
        {
          oprot.writeI32(struct.brokerEntryIds.size());
          for (int _iter228 : struct.brokerEntryIds)
          {
            oprot.writeI32(_iter228);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RemoveSledCommodityOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.sledCommodityId = iprot.readI32();
        struct.setSledCommodityIdIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list229 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.brokerEntryIds = new ArrayList<Integer>(_list229.size);
          for (int _i230 = 0; _i230 < _list229.size; ++_i230)
          {
            int _elem231;
            _elem231 = iprot.readI32();
            struct.brokerEntryIds.add(_elem231);
          }
        }
        struct.setBrokerEntryIdsIsSet(true);
      }
    }
  }

}

