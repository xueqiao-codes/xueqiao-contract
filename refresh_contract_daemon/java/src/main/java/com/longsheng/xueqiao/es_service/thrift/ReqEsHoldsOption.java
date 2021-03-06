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

public class ReqEsHoldsOption implements org.apache.thrift.TBase<ReqEsHoldsOption, ReqEsHoldsOption._Fields>, java.io.Serializable, Cloneable, Comparable<ReqEsHoldsOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReqEsHoldsOption");

  private static final org.apache.thrift.protocol.TField COMMODITY_NOS_FIELD_DESC = new org.apache.thrift.protocol.TField("commodityNos", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField CONTRACT_NOS_FIELD_DESC = new org.apache.thrift.protocol.TField("contractNos", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField DIRECTS_FIELD_DESC = new org.apache.thrift.protocol.TField("directs", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField PAGE_OPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("pageOption", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReqEsHoldsOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReqEsHoldsOptionTupleSchemeFactory());
  }

  public List<String> commodityNos; // optional
  public List<String> contractNos; // optional
  public List<EsDirectType> directs; // optional
  public com.longsheng.xueqiao.standard.thriftapi.PageOption pageOption; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COMMODITY_NOS((short)1, "commodityNos"),
    CONTRACT_NOS((short)2, "contractNos"),
    DIRECTS((short)3, "directs"),
    PAGE_OPTION((short)4, "pageOption");

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
        case 1: // COMMODITY_NOS
          return COMMODITY_NOS;
        case 2: // CONTRACT_NOS
          return CONTRACT_NOS;
        case 3: // DIRECTS
          return DIRECTS;
        case 4: // PAGE_OPTION
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
  private _Fields optionals[] = {_Fields.COMMODITY_NOS,_Fields.CONTRACT_NOS,_Fields.DIRECTS,_Fields.PAGE_OPTION};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COMMODITY_NOS, new org.apache.thrift.meta_data.FieldMetaData("commodityNos", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.CONTRACT_NOS, new org.apache.thrift.meta_data.FieldMetaData("contractNos", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.DIRECTS, new org.apache.thrift.meta_data.FieldMetaData("directs", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, EsDirectType.class))));
    tmpMap.put(_Fields.PAGE_OPTION, new org.apache.thrift.meta_data.FieldMetaData("pageOption", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.longsheng.xueqiao.standard.thriftapi.PageOption.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReqEsHoldsOption.class, metaDataMap);
  }

  public ReqEsHoldsOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReqEsHoldsOption(ReqEsHoldsOption other) {
    if (other.isSetCommodityNos()) {
      List<String> __this__commodityNos = new ArrayList<String>(other.commodityNos);
      this.commodityNos = __this__commodityNos;
    }
    if (other.isSetContractNos()) {
      List<String> __this__contractNos = new ArrayList<String>(other.contractNos);
      this.contractNos = __this__contractNos;
    }
    if (other.isSetDirects()) {
      List<EsDirectType> __this__directs = new ArrayList<EsDirectType>(other.directs.size());
      for (EsDirectType other_element : other.directs) {
        __this__directs.add(other_element);
      }
      this.directs = __this__directs;
    }
    if (other.isSetPageOption()) {
      this.pageOption = new com.longsheng.xueqiao.standard.thriftapi.PageOption(other.pageOption);
    }
  }

  public ReqEsHoldsOption deepCopy() {
    return new ReqEsHoldsOption(this);
  }

  @Override
  public void clear() {
    this.commodityNos = null;
    this.contractNos = null;
    this.directs = null;
    this.pageOption = null;
  }

  public int getCommodityNosSize() {
    return (this.commodityNos == null) ? 0 : this.commodityNos.size();
  }

  public java.util.Iterator<String> getCommodityNosIterator() {
    return (this.commodityNos == null) ? null : this.commodityNos.iterator();
  }

  public void addToCommodityNos(String elem) {
    if (this.commodityNos == null) {
      this.commodityNos = new ArrayList<String>();
    }
    this.commodityNos.add(elem);
  }

  public List<String> getCommodityNos() {
    return this.commodityNos;
  }

  public ReqEsHoldsOption setCommodityNos(List<String> commodityNos) {
    this.commodityNos = commodityNos;
    return this;
  }

  public void unsetCommodityNos() {
    this.commodityNos = null;
  }

  /** Returns true if field commodityNos is set (has been assigned a value) and false otherwise */
  public boolean isSetCommodityNos() {
    return this.commodityNos != null;
  }

  public void setCommodityNosIsSet(boolean value) {
    if (!value) {
      this.commodityNos = null;
    }
  }

  public int getContractNosSize() {
    return (this.contractNos == null) ? 0 : this.contractNos.size();
  }

  public java.util.Iterator<String> getContractNosIterator() {
    return (this.contractNos == null) ? null : this.contractNos.iterator();
  }

  public void addToContractNos(String elem) {
    if (this.contractNos == null) {
      this.contractNos = new ArrayList<String>();
    }
    this.contractNos.add(elem);
  }

  public List<String> getContractNos() {
    return this.contractNos;
  }

  public ReqEsHoldsOption setContractNos(List<String> contractNos) {
    this.contractNos = contractNos;
    return this;
  }

  public void unsetContractNos() {
    this.contractNos = null;
  }

  /** Returns true if field contractNos is set (has been assigned a value) and false otherwise */
  public boolean isSetContractNos() {
    return this.contractNos != null;
  }

  public void setContractNosIsSet(boolean value) {
    if (!value) {
      this.contractNos = null;
    }
  }

  public int getDirectsSize() {
    return (this.directs == null) ? 0 : this.directs.size();
  }

  public java.util.Iterator<EsDirectType> getDirectsIterator() {
    return (this.directs == null) ? null : this.directs.iterator();
  }

  public void addToDirects(EsDirectType elem) {
    if (this.directs == null) {
      this.directs = new ArrayList<EsDirectType>();
    }
    this.directs.add(elem);
  }

  public List<EsDirectType> getDirects() {
    return this.directs;
  }

  public ReqEsHoldsOption setDirects(List<EsDirectType> directs) {
    this.directs = directs;
    return this;
  }

  public void unsetDirects() {
    this.directs = null;
  }

  /** Returns true if field directs is set (has been assigned a value) and false otherwise */
  public boolean isSetDirects() {
    return this.directs != null;
  }

  public void setDirectsIsSet(boolean value) {
    if (!value) {
      this.directs = null;
    }
  }

  public com.longsheng.xueqiao.standard.thriftapi.PageOption getPageOption() {
    return this.pageOption;
  }

  public ReqEsHoldsOption setPageOption(com.longsheng.xueqiao.standard.thriftapi.PageOption pageOption) {
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
    case COMMODITY_NOS:
      if (value == null) {
        unsetCommodityNos();
      } else {
        setCommodityNos((List<String>)value);
      }
      break;

    case CONTRACT_NOS:
      if (value == null) {
        unsetContractNos();
      } else {
        setContractNos((List<String>)value);
      }
      break;

    case DIRECTS:
      if (value == null) {
        unsetDirects();
      } else {
        setDirects((List<EsDirectType>)value);
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
    case COMMODITY_NOS:
      return getCommodityNos();

    case CONTRACT_NOS:
      return getContractNos();

    case DIRECTS:
      return getDirects();

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
    case COMMODITY_NOS:
      return isSetCommodityNos();
    case CONTRACT_NOS:
      return isSetContractNos();
    case DIRECTS:
      return isSetDirects();
    case PAGE_OPTION:
      return isSetPageOption();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReqEsHoldsOption)
      return this.equals((ReqEsHoldsOption)that);
    return false;
  }

  public boolean equals(ReqEsHoldsOption that) {
    if (that == null)
      return false;

    boolean this_present_commodityNos = true && this.isSetCommodityNos();
    boolean that_present_commodityNos = true && that.isSetCommodityNos();
    if (this_present_commodityNos || that_present_commodityNos) {
      if (!(this_present_commodityNos && that_present_commodityNos))
        return false;
      if (!this.commodityNos.equals(that.commodityNos))
        return false;
    }

    boolean this_present_contractNos = true && this.isSetContractNos();
    boolean that_present_contractNos = true && that.isSetContractNos();
    if (this_present_contractNos || that_present_contractNos) {
      if (!(this_present_contractNos && that_present_contractNos))
        return false;
      if (!this.contractNos.equals(that.contractNos))
        return false;
    }

    boolean this_present_directs = true && this.isSetDirects();
    boolean that_present_directs = true && that.isSetDirects();
    if (this_present_directs || that_present_directs) {
      if (!(this_present_directs && that_present_directs))
        return false;
      if (!this.directs.equals(that.directs))
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
  public int compareTo(ReqEsHoldsOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCommodityNos()).compareTo(other.isSetCommodityNos());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommodityNos()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.commodityNos, other.commodityNos);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetContractNos()).compareTo(other.isSetContractNos());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContractNos()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.contractNos, other.contractNos);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDirects()).compareTo(other.isSetDirects());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDirects()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.directs, other.directs);
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
    StringBuilder sb = new StringBuilder("ReqEsHoldsOption(");
    boolean first = true;

    if (isSetCommodityNos()) {
      sb.append("commodityNos:");
      if (this.commodityNos == null) {
        sb.append("null");
      } else {
        sb.append(this.commodityNos);
      }
      first = false;
    }
    if (isSetContractNos()) {
      if (!first) sb.append(", ");
      sb.append("contractNos:");
      if (this.contractNos == null) {
        sb.append("null");
      } else {
        sb.append(this.contractNos);
      }
      first = false;
    }
    if (isSetDirects()) {
      if (!first) sb.append(", ");
      sb.append("directs:");
      if (this.directs == null) {
        sb.append("null");
      } else {
        sb.append(this.directs);
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

  private static class ReqEsHoldsOptionStandardSchemeFactory implements SchemeFactory {
    public ReqEsHoldsOptionStandardScheme getScheme() {
      return new ReqEsHoldsOptionStandardScheme();
    }
  }

  private static class ReqEsHoldsOptionStandardScheme extends StandardScheme<ReqEsHoldsOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReqEsHoldsOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COMMODITY_NOS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list168 = iprot.readListBegin();
                struct.commodityNos = new ArrayList<String>(_list168.size);
                for (int _i169 = 0; _i169 < _list168.size; ++_i169)
                {
                  String _elem170;
                  _elem170 = iprot.readString();
                  struct.commodityNos.add(_elem170);
                }
                iprot.readListEnd();
              }
              struct.setCommodityNosIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CONTRACT_NOS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list171 = iprot.readListBegin();
                struct.contractNos = new ArrayList<String>(_list171.size);
                for (int _i172 = 0; _i172 < _list171.size; ++_i172)
                {
                  String _elem173;
                  _elem173 = iprot.readString();
                  struct.contractNos.add(_elem173);
                }
                iprot.readListEnd();
              }
              struct.setContractNosIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DIRECTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list174 = iprot.readListBegin();
                struct.directs = new ArrayList<EsDirectType>(_list174.size);
                for (int _i175 = 0; _i175 < _list174.size; ++_i175)
                {
                  EsDirectType _elem176;
                  _elem176 = EsDirectType.findByValue(iprot.readI32());
                  struct.directs.add(_elem176);
                }
                iprot.readListEnd();
              }
              struct.setDirectsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PAGE_OPTION
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReqEsHoldsOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.commodityNos != null) {
        if (struct.isSetCommodityNos()) {
          oprot.writeFieldBegin(COMMODITY_NOS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.commodityNos.size()));
            for (String _iter177 : struct.commodityNos)
            {
              oprot.writeString(_iter177);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.contractNos != null) {
        if (struct.isSetContractNos()) {
          oprot.writeFieldBegin(CONTRACT_NOS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.contractNos.size()));
            for (String _iter178 : struct.contractNos)
            {
              oprot.writeString(_iter178);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.directs != null) {
        if (struct.isSetDirects()) {
          oprot.writeFieldBegin(DIRECTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.directs.size()));
            for (EsDirectType _iter179 : struct.directs)
            {
              oprot.writeI32(_iter179.getValue());
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

  private static class ReqEsHoldsOptionTupleSchemeFactory implements SchemeFactory {
    public ReqEsHoldsOptionTupleScheme getScheme() {
      return new ReqEsHoldsOptionTupleScheme();
    }
  }

  private static class ReqEsHoldsOptionTupleScheme extends TupleScheme<ReqEsHoldsOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReqEsHoldsOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCommodityNos()) {
        optionals.set(0);
      }
      if (struct.isSetContractNos()) {
        optionals.set(1);
      }
      if (struct.isSetDirects()) {
        optionals.set(2);
      }
      if (struct.isSetPageOption()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetCommodityNos()) {
        {
          oprot.writeI32(struct.commodityNos.size());
          for (String _iter180 : struct.commodityNos)
          {
            oprot.writeString(_iter180);
          }
        }
      }
      if (struct.isSetContractNos()) {
        {
          oprot.writeI32(struct.contractNos.size());
          for (String _iter181 : struct.contractNos)
          {
            oprot.writeString(_iter181);
          }
        }
      }
      if (struct.isSetDirects()) {
        {
          oprot.writeI32(struct.directs.size());
          for (EsDirectType _iter182 : struct.directs)
          {
            oprot.writeI32(_iter182.getValue());
          }
        }
      }
      if (struct.isSetPageOption()) {
        struct.pageOption.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReqEsHoldsOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list183 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.commodityNos = new ArrayList<String>(_list183.size);
          for (int _i184 = 0; _i184 < _list183.size; ++_i184)
          {
            String _elem185;
            _elem185 = iprot.readString();
            struct.commodityNos.add(_elem185);
          }
        }
        struct.setCommodityNosIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list186 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.contractNos = new ArrayList<String>(_list186.size);
          for (int _i187 = 0; _i187 < _list186.size; ++_i187)
          {
            String _elem188;
            _elem188 = iprot.readString();
            struct.contractNos.add(_elem188);
          }
        }
        struct.setContractNosIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list189 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.directs = new ArrayList<EsDirectType>(_list189.size);
          for (int _i190 = 0; _i190 < _list189.size; ++_i190)
          {
            EsDirectType _elem191;
            _elem191 = EsDirectType.findByValue(iprot.readI32());
            struct.directs.add(_elem191);
          }
        }
        struct.setDirectsIsSet(true);
      }
      if (incoming.get(3)) {
        struct.pageOption = new com.longsheng.xueqiao.standard.thriftapi.PageOption();
        struct.pageOption.read(iprot);
        struct.setPageOptionIsSet(true);
      }
    }
  }

}

