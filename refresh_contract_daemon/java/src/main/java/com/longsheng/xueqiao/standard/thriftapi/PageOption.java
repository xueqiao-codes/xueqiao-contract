/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.standard.thriftapi;

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

/**
 * 分页查询选项
 * 
 */
public class PageOption implements org.apache.thrift.TBase<PageOption, PageOption._Fields>, java.io.Serializable, Cloneable, Comparable<PageOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PageOption");

  private static final org.apache.thrift.protocol.TField GET_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("getCount", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField PAGE_INDEX_FIELD_DESC = new org.apache.thrift.protocol.TField("pageIndex", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField PAGE_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("pageSize", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PageOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PageOptionTupleSchemeFactory());
  }

  public boolean getCount; // optional
  public int pageIndex; // optional
  public int pageSize; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    GET_COUNT((short)1, "getCount"),
    PAGE_INDEX((short)2, "pageIndex"),
    PAGE_SIZE((short)3, "pageSize");

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
        case 1: // GET_COUNT
          return GET_COUNT;
        case 2: // PAGE_INDEX
          return PAGE_INDEX;
        case 3: // PAGE_SIZE
          return PAGE_SIZE;
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
  private static final int __GETCOUNT_ISSET_ID = 0;
  private static final int __PAGEINDEX_ISSET_ID = 1;
  private static final int __PAGESIZE_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.GET_COUNT,_Fields.PAGE_INDEX,_Fields.PAGE_SIZE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.GET_COUNT, new org.apache.thrift.meta_data.FieldMetaData("getCount", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.PAGE_INDEX, new org.apache.thrift.meta_data.FieldMetaData("pageIndex", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PAGE_SIZE, new org.apache.thrift.meta_data.FieldMetaData("pageSize", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PageOption.class, metaDataMap);
  }

  public PageOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PageOption(PageOption other) {
    __isset_bitfield = other.__isset_bitfield;
    this.getCount = other.getCount;
    this.pageIndex = other.pageIndex;
    this.pageSize = other.pageSize;
  }

  public PageOption deepCopy() {
    return new PageOption(this);
  }

  @Override
  public void clear() {
    setGetCountIsSet(false);
    this.getCount = false;
    setPageIndexIsSet(false);
    this.pageIndex = 0;
    setPageSizeIsSet(false);
    this.pageSize = 0;
  }

  public boolean isGetCount() {
    return this.getCount;
  }

  public PageOption setGetCount(boolean getCount) {
    this.getCount = getCount;
    setGetCountIsSet(true);
    return this;
  }

  public void unsetGetCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __GETCOUNT_ISSET_ID);
  }

  /** Returns true if field getCount is set (has been assigned a value) and false otherwise */
  public boolean isSetGetCount() {
    return EncodingUtils.testBit(__isset_bitfield, __GETCOUNT_ISSET_ID);
  }

  public void setGetCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __GETCOUNT_ISSET_ID, value);
  }

  public int getPageIndex() {
    return this.pageIndex;
  }

  public PageOption setPageIndex(int pageIndex) {
    this.pageIndex = pageIndex;
    setPageIndexIsSet(true);
    return this;
  }

  public void unsetPageIndex() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGEINDEX_ISSET_ID);
  }

  /** Returns true if field pageIndex is set (has been assigned a value) and false otherwise */
  public boolean isSetPageIndex() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGEINDEX_ISSET_ID);
  }

  public void setPageIndexIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGEINDEX_ISSET_ID, value);
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public PageOption setPageSize(int pageSize) {
    this.pageSize = pageSize;
    setPageSizeIsSet(true);
    return this;
  }

  public void unsetPageSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGESIZE_ISSET_ID);
  }

  /** Returns true if field pageSize is set (has been assigned a value) and false otherwise */
  public boolean isSetPageSize() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGESIZE_ISSET_ID);
  }

  public void setPageSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGESIZE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case GET_COUNT:
      if (value == null) {
        unsetGetCount();
      } else {
        setGetCount((Boolean)value);
      }
      break;

    case PAGE_INDEX:
      if (value == null) {
        unsetPageIndex();
      } else {
        setPageIndex((Integer)value);
      }
      break;

    case PAGE_SIZE:
      if (value == null) {
        unsetPageSize();
      } else {
        setPageSize((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case GET_COUNT:
      return Boolean.valueOf(isGetCount());

    case PAGE_INDEX:
      return Integer.valueOf(getPageIndex());

    case PAGE_SIZE:
      return Integer.valueOf(getPageSize());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case GET_COUNT:
      return isSetGetCount();
    case PAGE_INDEX:
      return isSetPageIndex();
    case PAGE_SIZE:
      return isSetPageSize();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PageOption)
      return this.equals((PageOption)that);
    return false;
  }

  public boolean equals(PageOption that) {
    if (that == null)
      return false;

    boolean this_present_getCount = true && this.isSetGetCount();
    boolean that_present_getCount = true && that.isSetGetCount();
    if (this_present_getCount || that_present_getCount) {
      if (!(this_present_getCount && that_present_getCount))
        return false;
      if (this.getCount != that.getCount)
        return false;
    }

    boolean this_present_pageIndex = true && this.isSetPageIndex();
    boolean that_present_pageIndex = true && that.isSetPageIndex();
    if (this_present_pageIndex || that_present_pageIndex) {
      if (!(this_present_pageIndex && that_present_pageIndex))
        return false;
      if (this.pageIndex != that.pageIndex)
        return false;
    }

    boolean this_present_pageSize = true && this.isSetPageSize();
    boolean that_present_pageSize = true && that.isSetPageSize();
    if (this_present_pageSize || that_present_pageSize) {
      if (!(this_present_pageSize && that_present_pageSize))
        return false;
      if (this.pageSize != that.pageSize)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(PageOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetGetCount()).compareTo(other.isSetGetCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGetCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.getCount, other.getCount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageIndex()).compareTo(other.isSetPageIndex());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageIndex()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageIndex, other.pageIndex);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageSize()).compareTo(other.isSetPageSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageSize, other.pageSize);
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
    StringBuilder sb = new StringBuilder("PageOption(");
    boolean first = true;

    if (isSetGetCount()) {
      sb.append("getCount:");
      sb.append(this.getCount);
      first = false;
    }
    if (isSetPageIndex()) {
      if (!first) sb.append(", ");
      sb.append("pageIndex:");
      sb.append(this.pageIndex);
      first = false;
    }
    if (isSetPageSize()) {
      if (!first) sb.append(", ");
      sb.append("pageSize:");
      sb.append(this.pageSize);
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

  private static class PageOptionStandardSchemeFactory implements SchemeFactory {
    public PageOptionStandardScheme getScheme() {
      return new PageOptionStandardScheme();
    }
  }

  private static class PageOptionStandardScheme extends StandardScheme<PageOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PageOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // GET_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.getCount = iprot.readBool();
              struct.setGetCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PAGE_INDEX
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageIndex = iprot.readI32();
              struct.setPageIndexIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PAGE_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageSize = iprot.readI32();
              struct.setPageSizeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, PageOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetGetCount()) {
        oprot.writeFieldBegin(GET_COUNT_FIELD_DESC);
        oprot.writeBool(struct.getCount);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPageIndex()) {
        oprot.writeFieldBegin(PAGE_INDEX_FIELD_DESC);
        oprot.writeI32(struct.pageIndex);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPageSize()) {
        oprot.writeFieldBegin(PAGE_SIZE_FIELD_DESC);
        oprot.writeI32(struct.pageSize);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PageOptionTupleSchemeFactory implements SchemeFactory {
    public PageOptionTupleScheme getScheme() {
      return new PageOptionTupleScheme();
    }
  }

  private static class PageOptionTupleScheme extends TupleScheme<PageOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PageOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetGetCount()) {
        optionals.set(0);
      }
      if (struct.isSetPageIndex()) {
        optionals.set(1);
      }
      if (struct.isSetPageSize()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetGetCount()) {
        oprot.writeBool(struct.getCount);
      }
      if (struct.isSetPageIndex()) {
        oprot.writeI32(struct.pageIndex);
      }
      if (struct.isSetPageSize()) {
        oprot.writeI32(struct.pageSize);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PageOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.getCount = iprot.readBool();
        struct.setGetCountIsSet(true);
      }
      if (incoming.get(1)) {
        struct.pageIndex = iprot.readI32();
        struct.setPageIndexIsSet(true);
      }
      if (incoming.get(2)) {
        struct.pageSize = iprot.readI32();
        struct.setPageSizeIsSet(true);
      }
    }
  }

}

