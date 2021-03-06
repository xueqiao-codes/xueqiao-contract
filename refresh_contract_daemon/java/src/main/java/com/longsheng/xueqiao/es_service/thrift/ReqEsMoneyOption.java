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

public class ReqEsMoneyOption implements org.apache.thrift.TBase<ReqEsMoneyOption, ReqEsMoneyOption._Fields>, java.io.Serializable, Cloneable, Comparable<ReqEsMoneyOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReqEsMoneyOption");

  private static final org.apache.thrift.protocol.TField CURRENCY_NOS_FIELD_DESC = new org.apache.thrift.protocol.TField("currencyNos", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField PAGE_OPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("pageOption", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReqEsMoneyOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReqEsMoneyOptionTupleSchemeFactory());
  }

  public List<String> currencyNos; // optional
  public com.longsheng.xueqiao.standard.thriftapi.PageOption pageOption; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CURRENCY_NOS((short)1, "currencyNos"),
    PAGE_OPTION((short)2, "pageOption");

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
        case 1: // CURRENCY_NOS
          return CURRENCY_NOS;
        case 2: // PAGE_OPTION
          return PAGE_OPTION;
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
  private _Fields optionals[] = {_Fields.CURRENCY_NOS,_Fields.PAGE_OPTION};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CURRENCY_NOS, new org.apache.thrift.meta_data.FieldMetaData("currencyNos", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.PAGE_OPTION, new org.apache.thrift.meta_data.FieldMetaData("pageOption", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.longsheng.xueqiao.standard.thriftapi.PageOption.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReqEsMoneyOption.class, metaDataMap);
  }

  public ReqEsMoneyOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReqEsMoneyOption(ReqEsMoneyOption other) {
    if (other.isSetCurrencyNos()) {
      List<String> __this__currencyNos = new ArrayList<String>(other.currencyNos);
      this.currencyNos = __this__currencyNos;
    }
    if (other.isSetPageOption()) {
      this.pageOption = new com.longsheng.xueqiao.standard.thriftapi.PageOption(other.pageOption);
    }
  }

  public ReqEsMoneyOption deepCopy() {
    return new ReqEsMoneyOption(this);
  }

  @Override
  public void clear() {
    this.currencyNos = null;
    this.pageOption = null;
  }

  public int getCurrencyNosSize() {
    return (this.currencyNos == null) ? 0 : this.currencyNos.size();
  }

  public java.util.Iterator<String> getCurrencyNosIterator() {
    return (this.currencyNos == null) ? null : this.currencyNos.iterator();
  }

  public void addToCurrencyNos(String elem) {
    if (this.currencyNos == null) {
      this.currencyNos = new ArrayList<String>();
    }
    this.currencyNos.add(elem);
  }

  public List<String> getCurrencyNos() {
    return this.currencyNos;
  }

  public ReqEsMoneyOption setCurrencyNos(List<String> currencyNos) {
    this.currencyNos = currencyNos;
    return this;
  }

  public void unsetCurrencyNos() {
    this.currencyNos = null;
  }

  /** Returns true if field currencyNos is set (has been assigned a value) and false otherwise */
  public boolean isSetCurrencyNos() {
    return this.currencyNos != null;
  }

  public void setCurrencyNosIsSet(boolean value) {
    if (!value) {
      this.currencyNos = null;
    }
  }

  public com.longsheng.xueqiao.standard.thriftapi.PageOption getPageOption() {
    return this.pageOption;
  }

  public ReqEsMoneyOption setPageOption(com.longsheng.xueqiao.standard.thriftapi.PageOption pageOption) {
    this.pageOption = pageOption;
    return this;
  }

  public void unsetPageOption() {
    this.pageOption = null;
  }

  /** Returns true if field pageOption is set (has been assigned a value) and false otherwise */
  public boolean isSetPageOption() {
    return this.pageOption != null;
  }

  public void setPageOptionIsSet(boolean value) {
    if (!value) {
      this.pageOption = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CURRENCY_NOS:
      if (value == null) {
        unsetCurrencyNos();
      } else {
        setCurrencyNos((List<String>)value);
      }
      break;

    case PAGE_OPTION:
      if (value == null) {
        unsetPageOption();
      } else {
        setPageOption((com.longsheng.xueqiao.standard.thriftapi.PageOption)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CURRENCY_NOS:
      return getCurrencyNos();

    case PAGE_OPTION:
      return getPageOption();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CURRENCY_NOS:
      return isSetCurrencyNos();
    case PAGE_OPTION:
      return isSetPageOption();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReqEsMoneyOption)
      return this.equals((ReqEsMoneyOption)that);
    return false;
  }

  public boolean equals(ReqEsMoneyOption that) {
    if (that == null)
      return false;

    boolean this_present_currencyNos = true && this.isSetCurrencyNos();
    boolean that_present_currencyNos = true && that.isSetCurrencyNos();
    if (this_present_currencyNos || that_present_currencyNos) {
      if (!(this_present_currencyNos && that_present_currencyNos))
        return false;
      if (!this.currencyNos.equals(that.currencyNos))
        return false;
    }

    boolean this_present_pageOption = true && this.isSetPageOption();
    boolean that_present_pageOption = true && that.isSetPageOption();
    if (this_present_pageOption || that_present_pageOption) {
      if (!(this_present_pageOption && that_present_pageOption))
        return false;
      if (!this.pageOption.equals(that.pageOption))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ReqEsMoneyOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCurrencyNos()).compareTo(other.isSetCurrencyNos());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCurrencyNos()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.currencyNos, other.currencyNos);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageOption()).compareTo(other.isSetPageOption());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageOption()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageOption, other.pageOption);
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
    StringBuilder sb = new StringBuilder("ReqEsMoneyOption(");
    boolean first = true;

    if (isSetCurrencyNos()) {
      sb.append("currencyNos:");
      if (this.currencyNos == null) {
        sb.append("null");
      } else {
        sb.append(this.currencyNos);
      }
      first = false;
    }
    if (isSetPageOption()) {
      if (!first) sb.append(", ");
      sb.append("pageOption:");
      if (this.pageOption == null) {
        sb.append("null");
      } else {
        sb.append(this.pageOption);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (pageOption != null) {
      pageOption.validate();
    }
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

  private static class ReqEsMoneyOptionStandardSchemeFactory implements SchemeFactory {
    public ReqEsMoneyOptionStandardScheme getScheme() {
      return new ReqEsMoneyOptionStandardScheme();
    }
  }

  private static class ReqEsMoneyOptionStandardScheme extends StandardScheme<ReqEsMoneyOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReqEsMoneyOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CURRENCY_NOS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list120 = iprot.readListBegin();
                struct.currencyNos = new ArrayList<String>(_list120.size);
                for (int _i121 = 0; _i121 < _list120.size; ++_i121)
                {
                  String _elem122;
                  _elem122 = iprot.readString();
                  struct.currencyNos.add(_elem122);
                }
                iprot.readListEnd();
              }
              struct.setCurrencyNosIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PAGE_OPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.pageOption = new com.longsheng.xueqiao.standard.thriftapi.PageOption();
              struct.pageOption.read(iprot);
              struct.setPageOptionIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReqEsMoneyOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.currencyNos != null) {
        if (struct.isSetCurrencyNos()) {
          oprot.writeFieldBegin(CURRENCY_NOS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.currencyNos.size()));
            for (String _iter123 : struct.currencyNos)
            {
              oprot.writeString(_iter123);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.pageOption != null) {
        if (struct.isSetPageOption()) {
          oprot.writeFieldBegin(PAGE_OPTION_FIELD_DESC);
          struct.pageOption.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ReqEsMoneyOptionTupleSchemeFactory implements SchemeFactory {
    public ReqEsMoneyOptionTupleScheme getScheme() {
      return new ReqEsMoneyOptionTupleScheme();
    }
  }

  private static class ReqEsMoneyOptionTupleScheme extends TupleScheme<ReqEsMoneyOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReqEsMoneyOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCurrencyNos()) {
        optionals.set(0);
      }
      if (struct.isSetPageOption()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetCurrencyNos()) {
        {
          oprot.writeI32(struct.currencyNos.size());
          for (String _iter124 : struct.currencyNos)
          {
            oprot.writeString(_iter124);
          }
        }
      }
      if (struct.isSetPageOption()) {
        struct.pageOption.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReqEsMoneyOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list125 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.currencyNos = new ArrayList<String>(_list125.size);
          for (int _i126 = 0; _i126 < _list125.size; ++_i126)
          {
            String _elem127;
            _elem127 = iprot.readString();
            struct.currencyNos.add(_elem127);
          }
        }
        struct.setCurrencyNosIsSet(true);
      }
      if (incoming.get(1)) {
        struct.pageOption = new com.longsheng.xueqiao.standard.thriftapi.PageOption();
        struct.pageOption.read(iprot);
        struct.setPageOptionIsSet(true);
      }
    }
  }

}

