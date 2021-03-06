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

public class StdCompUnitField implements org.apache.thrift.TBase<StdCompUnitField, StdCompUnitField._Fields>, java.io.Serializable, Cloneable, Comparable<StdCompUnitField> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StdCompUnitField");

  private static final org.apache.thrift.protocol.TField VARIABLE_FIELD_DESC = new org.apache.thrift.protocol.TField("variable", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CONTRACT_FIELD_DESC = new org.apache.thrift.protocol.TField("contract", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField QUANTITY_FIELD_DESC = new org.apache.thrift.protocol.TField("quantity", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField DIRECTION_FIELD_DESC = new org.apache.thrift.protocol.TField("direction", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField ORDER_FIELD_DESC = new org.apache.thrift.protocol.TField("order", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField PRICE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("priceType", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField PLUS_TICK_FIELD_DESC = new org.apache.thrift.protocol.TField("plusTick", org.apache.thrift.protocol.TType.I32, (short)7);
  private static final org.apache.thrift.protocol.TField COMPOSE_UKEY_FIELD_DESC = new org.apache.thrift.protocol.TField("composeUkey", org.apache.thrift.protocol.TType.STRING, (short)8);
  private static final org.apache.thrift.protocol.TField SLED_CONTRACT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledContractId", org.apache.thrift.protocol.TType.I32, (short)9);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new StdCompUnitFieldStandardSchemeFactory());
    schemes.put(TupleScheme.class, new StdCompUnitFieldTupleSchemeFactory());
  }

  public String variable; // required
  public Contract contract; // optional
  public int quantity; // required
  public int direction; // required
  public int order; // required
  public int priceType; // optional
  public int plusTick; // optional
  public String composeUkey; // optional
  public int sledContractId; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    VARIABLE((short)1, "variable"),
    CONTRACT((short)2, "contract"),
    QUANTITY((short)3, "quantity"),
    DIRECTION((short)4, "direction"),
    ORDER((short)5, "order"),
    PRICE_TYPE((short)6, "priceType"),
    PLUS_TICK((short)7, "plusTick"),
    COMPOSE_UKEY((short)8, "composeUkey"),
    SLED_CONTRACT_ID((short)9, "sledContractId");

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
        case 1: // VARIABLE
          return VARIABLE;
        case 2: // CONTRACT
          return CONTRACT;
        case 3: // QUANTITY
          return QUANTITY;
        case 4: // DIRECTION
          return DIRECTION;
        case 5: // ORDER
          return ORDER;
        case 6: // PRICE_TYPE
          return PRICE_TYPE;
        case 7: // PLUS_TICK
          return PLUS_TICK;
        case 8: // COMPOSE_UKEY
          return COMPOSE_UKEY;
        case 9: // SLED_CONTRACT_ID
          return SLED_CONTRACT_ID;
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
  private static final int __QUANTITY_ISSET_ID = 0;
  private static final int __DIRECTION_ISSET_ID = 1;
  private static final int __ORDER_ISSET_ID = 2;
  private static final int __PRICETYPE_ISSET_ID = 3;
  private static final int __PLUSTICK_ISSET_ID = 4;
  private static final int __SLEDCONTRACTID_ISSET_ID = 5;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.CONTRACT,_Fields.PRICE_TYPE,_Fields.PLUS_TICK,_Fields.COMPOSE_UKEY,_Fields.SLED_CONTRACT_ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.VARIABLE, new org.apache.thrift.meta_data.FieldMetaData("variable", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CONTRACT, new org.apache.thrift.meta_data.FieldMetaData("contract", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Contract.class)));
    tmpMap.put(_Fields.QUANTITY, new org.apache.thrift.meta_data.FieldMetaData("quantity", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DIRECTION, new org.apache.thrift.meta_data.FieldMetaData("direction", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ORDER, new org.apache.thrift.meta_data.FieldMetaData("order", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PRICE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("priceType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PLUS_TICK, new org.apache.thrift.meta_data.FieldMetaData("plusTick", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COMPOSE_UKEY, new org.apache.thrift.meta_data.FieldMetaData("composeUkey", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SLED_CONTRACT_ID, new org.apache.thrift.meta_data.FieldMetaData("sledContractId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StdCompUnitField.class, metaDataMap);
  }

  public StdCompUnitField() {
  }

  public StdCompUnitField(
    String variable,
    int quantity,
    int direction,
    int order)
  {
    this();
    this.variable = variable;
    this.quantity = quantity;
    setQuantityIsSet(true);
    this.direction = direction;
    setDirectionIsSet(true);
    this.order = order;
    setOrderIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public StdCompUnitField(StdCompUnitField other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetVariable()) {
      this.variable = other.variable;
    }
    if (other.isSetContract()) {
      this.contract = new Contract(other.contract);
    }
    this.quantity = other.quantity;
    this.direction = other.direction;
    this.order = other.order;
    this.priceType = other.priceType;
    this.plusTick = other.plusTick;
    if (other.isSetComposeUkey()) {
      this.composeUkey = other.composeUkey;
    }
    this.sledContractId = other.sledContractId;
  }

  public StdCompUnitField deepCopy() {
    return new StdCompUnitField(this);
  }

  @Override
  public void clear() {
    this.variable = null;
    this.contract = null;
    setQuantityIsSet(false);
    this.quantity = 0;
    setDirectionIsSet(false);
    this.direction = 0;
    setOrderIsSet(false);
    this.order = 0;
    setPriceTypeIsSet(false);
    this.priceType = 0;
    setPlusTickIsSet(false);
    this.plusTick = 0;
    this.composeUkey = null;
    setSledContractIdIsSet(false);
    this.sledContractId = 0;
  }

  public String getVariable() {
    return this.variable;
  }

  public StdCompUnitField setVariable(String variable) {
    this.variable = variable;
    return this;
  }

  public void unsetVariable() {
    this.variable = null;
  }

  /** Returns true if field variable is set (has been assigned a value) and false otherwise */
  public boolean isSetVariable() {
    return this.variable != null;
  }

  public void setVariableIsSet(boolean value) {
    if (!value) {
      this.variable = null;
    }
  }

  public Contract getContract() {
    return this.contract;
  }

  public StdCompUnitField setContract(Contract contract) {
    this.contract = contract;
    return this;
  }

  public void unsetContract() {
    this.contract = null;
  }

  /** Returns true if field contract is set (has been assigned a value) and false otherwise */
  public boolean isSetContract() {
    return this.contract != null;
  }

  public void setContractIsSet(boolean value) {
    if (!value) {
      this.contract = null;
    }
  }

  public int getQuantity() {
    return this.quantity;
  }

  public StdCompUnitField setQuantity(int quantity) {
    this.quantity = quantity;
    setQuantityIsSet(true);
    return this;
  }

  public void unsetQuantity() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __QUANTITY_ISSET_ID);
  }

  /** Returns true if field quantity is set (has been assigned a value) and false otherwise */
  public boolean isSetQuantity() {
    return EncodingUtils.testBit(__isset_bitfield, __QUANTITY_ISSET_ID);
  }

  public void setQuantityIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __QUANTITY_ISSET_ID, value);
  }

  public int getDirection() {
    return this.direction;
  }

  public StdCompUnitField setDirection(int direction) {
    this.direction = direction;
    setDirectionIsSet(true);
    return this;
  }

  public void unsetDirection() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DIRECTION_ISSET_ID);
  }

  /** Returns true if field direction is set (has been assigned a value) and false otherwise */
  public boolean isSetDirection() {
    return EncodingUtils.testBit(__isset_bitfield, __DIRECTION_ISSET_ID);
  }

  public void setDirectionIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DIRECTION_ISSET_ID, value);
  }

  public int getOrder() {
    return this.order;
  }

  public StdCompUnitField setOrder(int order) {
    this.order = order;
    setOrderIsSet(true);
    return this;
  }

  public void unsetOrder() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ORDER_ISSET_ID);
  }

  /** Returns true if field order is set (has been assigned a value) and false otherwise */
  public boolean isSetOrder() {
    return EncodingUtils.testBit(__isset_bitfield, __ORDER_ISSET_ID);
  }

  public void setOrderIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ORDER_ISSET_ID, value);
  }

  public int getPriceType() {
    return this.priceType;
  }

  public StdCompUnitField setPriceType(int priceType) {
    this.priceType = priceType;
    setPriceTypeIsSet(true);
    return this;
  }

  public void unsetPriceType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PRICETYPE_ISSET_ID);
  }

  /** Returns true if field priceType is set (has been assigned a value) and false otherwise */
  public boolean isSetPriceType() {
    return EncodingUtils.testBit(__isset_bitfield, __PRICETYPE_ISSET_ID);
  }

  public void setPriceTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PRICETYPE_ISSET_ID, value);
  }

  public int getPlusTick() {
    return this.plusTick;
  }

  public StdCompUnitField setPlusTick(int plusTick) {
    this.plusTick = plusTick;
    setPlusTickIsSet(true);
    return this;
  }

  public void unsetPlusTick() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PLUSTICK_ISSET_ID);
  }

  /** Returns true if field plusTick is set (has been assigned a value) and false otherwise */
  public boolean isSetPlusTick() {
    return EncodingUtils.testBit(__isset_bitfield, __PLUSTICK_ISSET_ID);
  }

  public void setPlusTickIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PLUSTICK_ISSET_ID, value);
  }

  public String getComposeUkey() {
    return this.composeUkey;
  }

  public StdCompUnitField setComposeUkey(String composeUkey) {
    this.composeUkey = composeUkey;
    return this;
  }

  public void unsetComposeUkey() {
    this.composeUkey = null;
  }

  /** Returns true if field composeUkey is set (has been assigned a value) and false otherwise */
  public boolean isSetComposeUkey() {
    return this.composeUkey != null;
  }

  public void setComposeUkeyIsSet(boolean value) {
    if (!value) {
      this.composeUkey = null;
    }
  }

  public int getSledContractId() {
    return this.sledContractId;
  }

  public StdCompUnitField setSledContractId(int sledContractId) {
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

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case VARIABLE:
      if (value == null) {
        unsetVariable();
      } else {
        setVariable((String)value);
      }
      break;

    case CONTRACT:
      if (value == null) {
        unsetContract();
      } else {
        setContract((Contract)value);
      }
      break;

    case QUANTITY:
      if (value == null) {
        unsetQuantity();
      } else {
        setQuantity((Integer)value);
      }
      break;

    case DIRECTION:
      if (value == null) {
        unsetDirection();
      } else {
        setDirection((Integer)value);
      }
      break;

    case ORDER:
      if (value == null) {
        unsetOrder();
      } else {
        setOrder((Integer)value);
      }
      break;

    case PRICE_TYPE:
      if (value == null) {
        unsetPriceType();
      } else {
        setPriceType((Integer)value);
      }
      break;

    case PLUS_TICK:
      if (value == null) {
        unsetPlusTick();
      } else {
        setPlusTick((Integer)value);
      }
      break;

    case COMPOSE_UKEY:
      if (value == null) {
        unsetComposeUkey();
      } else {
        setComposeUkey((String)value);
      }
      break;

    case SLED_CONTRACT_ID:
      if (value == null) {
        unsetSledContractId();
      } else {
        setSledContractId((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case VARIABLE:
      return getVariable();

    case CONTRACT:
      return getContract();

    case QUANTITY:
      return Integer.valueOf(getQuantity());

    case DIRECTION:
      return Integer.valueOf(getDirection());

    case ORDER:
      return Integer.valueOf(getOrder());

    case PRICE_TYPE:
      return Integer.valueOf(getPriceType());

    case PLUS_TICK:
      return Integer.valueOf(getPlusTick());

    case COMPOSE_UKEY:
      return getComposeUkey();

    case SLED_CONTRACT_ID:
      return Integer.valueOf(getSledContractId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case VARIABLE:
      return isSetVariable();
    case CONTRACT:
      return isSetContract();
    case QUANTITY:
      return isSetQuantity();
    case DIRECTION:
      return isSetDirection();
    case ORDER:
      return isSetOrder();
    case PRICE_TYPE:
      return isSetPriceType();
    case PLUS_TICK:
      return isSetPlusTick();
    case COMPOSE_UKEY:
      return isSetComposeUkey();
    case SLED_CONTRACT_ID:
      return isSetSledContractId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof StdCompUnitField)
      return this.equals((StdCompUnitField)that);
    return false;
  }

  public boolean equals(StdCompUnitField that) {
    if (that == null)
      return false;

    boolean this_present_variable = true && this.isSetVariable();
    boolean that_present_variable = true && that.isSetVariable();
    if (this_present_variable || that_present_variable) {
      if (!(this_present_variable && that_present_variable))
        return false;
      if (!this.variable.equals(that.variable))
        return false;
    }

    boolean this_present_contract = true && this.isSetContract();
    boolean that_present_contract = true && that.isSetContract();
    if (this_present_contract || that_present_contract) {
      if (!(this_present_contract && that_present_contract))
        return false;
      if (!this.contract.equals(that.contract))
        return false;
    }

    boolean this_present_quantity = true;
    boolean that_present_quantity = true;
    if (this_present_quantity || that_present_quantity) {
      if (!(this_present_quantity && that_present_quantity))
        return false;
      if (this.quantity != that.quantity)
        return false;
    }

    boolean this_present_direction = true;
    boolean that_present_direction = true;
    if (this_present_direction || that_present_direction) {
      if (!(this_present_direction && that_present_direction))
        return false;
      if (this.direction != that.direction)
        return false;
    }

    boolean this_present_order = true;
    boolean that_present_order = true;
    if (this_present_order || that_present_order) {
      if (!(this_present_order && that_present_order))
        return false;
      if (this.order != that.order)
        return false;
    }

    boolean this_present_priceType = true && this.isSetPriceType();
    boolean that_present_priceType = true && that.isSetPriceType();
    if (this_present_priceType || that_present_priceType) {
      if (!(this_present_priceType && that_present_priceType))
        return false;
      if (this.priceType != that.priceType)
        return false;
    }

    boolean this_present_plusTick = true && this.isSetPlusTick();
    boolean that_present_plusTick = true && that.isSetPlusTick();
    if (this_present_plusTick || that_present_plusTick) {
      if (!(this_present_plusTick && that_present_plusTick))
        return false;
      if (this.plusTick != that.plusTick)
        return false;
    }

    boolean this_present_composeUkey = true && this.isSetComposeUkey();
    boolean that_present_composeUkey = true && that.isSetComposeUkey();
    if (this_present_composeUkey || that_present_composeUkey) {
      if (!(this_present_composeUkey && that_present_composeUkey))
        return false;
      if (!this.composeUkey.equals(that.composeUkey))
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

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(StdCompUnitField other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetVariable()).compareTo(other.isSetVariable());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVariable()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.variable, other.variable);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetContract()).compareTo(other.isSetContract());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContract()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.contract, other.contract);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQuantity()).compareTo(other.isSetQuantity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuantity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.quantity, other.quantity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDirection()).compareTo(other.isSetDirection());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDirection()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.direction, other.direction);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOrder()).compareTo(other.isSetOrder());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOrder()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.order, other.order);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPriceType()).compareTo(other.isSetPriceType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPriceType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.priceType, other.priceType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPlusTick()).compareTo(other.isSetPlusTick());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlusTick()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.plusTick, other.plusTick);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetComposeUkey()).compareTo(other.isSetComposeUkey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetComposeUkey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.composeUkey, other.composeUkey);
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
    StringBuilder sb = new StringBuilder("StdCompUnitField(");
    boolean first = true;

    sb.append("variable:");
    if (this.variable == null) {
      sb.append("null");
    } else {
      sb.append(this.variable);
    }
    first = false;
    if (isSetContract()) {
      if (!first) sb.append(", ");
      sb.append("contract:");
      if (this.contract == null) {
        sb.append("null");
      } else {
        sb.append(this.contract);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("quantity:");
    sb.append(this.quantity);
    first = false;
    if (!first) sb.append(", ");
    sb.append("direction:");
    sb.append(this.direction);
    first = false;
    if (!first) sb.append(", ");
    sb.append("order:");
    sb.append(this.order);
    first = false;
    if (isSetPriceType()) {
      if (!first) sb.append(", ");
      sb.append("priceType:");
      sb.append(this.priceType);
      first = false;
    }
    if (isSetPlusTick()) {
      if (!first) sb.append(", ");
      sb.append("plusTick:");
      sb.append(this.plusTick);
      first = false;
    }
    if (isSetComposeUkey()) {
      if (!first) sb.append(", ");
      sb.append("composeUkey:");
      if (this.composeUkey == null) {
        sb.append("null");
      } else {
        sb.append(this.composeUkey);
      }
      first = false;
    }
    if (isSetSledContractId()) {
      if (!first) sb.append(", ");
      sb.append("sledContractId:");
      sb.append(this.sledContractId);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (variable == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'variable' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'quantity' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'direction' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'order' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
    if (contract != null) {
      contract.validate();
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class StdCompUnitFieldStandardSchemeFactory implements SchemeFactory {
    public StdCompUnitFieldStandardScheme getScheme() {
      return new StdCompUnitFieldStandardScheme();
    }
  }

  private static class StdCompUnitFieldStandardScheme extends StandardScheme<StdCompUnitField> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, StdCompUnitField struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // VARIABLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.variable = iprot.readString();
              struct.setVariableIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CONTRACT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.contract = new Contract();
              struct.contract.read(iprot);
              struct.setContractIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // QUANTITY
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.quantity = iprot.readI32();
              struct.setQuantityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DIRECTION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.direction = iprot.readI32();
              struct.setDirectionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ORDER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.order = iprot.readI32();
              struct.setOrderIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // PRICE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.priceType = iprot.readI32();
              struct.setPriceTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // PLUS_TICK
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.plusTick = iprot.readI32();
              struct.setPlusTickIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // COMPOSE_UKEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.composeUkey = iprot.readString();
              struct.setComposeUkeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 9: // SLED_CONTRACT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledContractId = iprot.readI32();
              struct.setSledContractIdIsSet(true);
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
      if (!struct.isSetQuantity()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'quantity' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetDirection()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'direction' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetOrder()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'order' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, StdCompUnitField struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.variable != null) {
        oprot.writeFieldBegin(VARIABLE_FIELD_DESC);
        oprot.writeString(struct.variable);
        oprot.writeFieldEnd();
      }
      if (struct.contract != null) {
        if (struct.isSetContract()) {
          oprot.writeFieldBegin(CONTRACT_FIELD_DESC);
          struct.contract.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldBegin(QUANTITY_FIELD_DESC);
      oprot.writeI32(struct.quantity);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(DIRECTION_FIELD_DESC);
      oprot.writeI32(struct.direction);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ORDER_FIELD_DESC);
      oprot.writeI32(struct.order);
      oprot.writeFieldEnd();
      if (struct.isSetPriceType()) {
        oprot.writeFieldBegin(PRICE_TYPE_FIELD_DESC);
        oprot.writeI32(struct.priceType);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPlusTick()) {
        oprot.writeFieldBegin(PLUS_TICK_FIELD_DESC);
        oprot.writeI32(struct.plusTick);
        oprot.writeFieldEnd();
      }
      if (struct.composeUkey != null) {
        if (struct.isSetComposeUkey()) {
          oprot.writeFieldBegin(COMPOSE_UKEY_FIELD_DESC);
          oprot.writeString(struct.composeUkey);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetSledContractId()) {
        oprot.writeFieldBegin(SLED_CONTRACT_ID_FIELD_DESC);
        oprot.writeI32(struct.sledContractId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class StdCompUnitFieldTupleSchemeFactory implements SchemeFactory {
    public StdCompUnitFieldTupleScheme getScheme() {
      return new StdCompUnitFieldTupleScheme();
    }
  }

  private static class StdCompUnitFieldTupleScheme extends TupleScheme<StdCompUnitField> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, StdCompUnitField struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.variable);
      oprot.writeI32(struct.quantity);
      oprot.writeI32(struct.direction);
      oprot.writeI32(struct.order);
      BitSet optionals = new BitSet();
      if (struct.isSetContract()) {
        optionals.set(0);
      }
      if (struct.isSetPriceType()) {
        optionals.set(1);
      }
      if (struct.isSetPlusTick()) {
        optionals.set(2);
      }
      if (struct.isSetComposeUkey()) {
        optionals.set(3);
      }
      if (struct.isSetSledContractId()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetContract()) {
        struct.contract.write(oprot);
      }
      if (struct.isSetPriceType()) {
        oprot.writeI32(struct.priceType);
      }
      if (struct.isSetPlusTick()) {
        oprot.writeI32(struct.plusTick);
      }
      if (struct.isSetComposeUkey()) {
        oprot.writeString(struct.composeUkey);
      }
      if (struct.isSetSledContractId()) {
        oprot.writeI32(struct.sledContractId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, StdCompUnitField struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.variable = iprot.readString();
      struct.setVariableIsSet(true);
      struct.quantity = iprot.readI32();
      struct.setQuantityIsSet(true);
      struct.direction = iprot.readI32();
      struct.setDirectionIsSet(true);
      struct.order = iprot.readI32();
      struct.setOrderIsSet(true);
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.contract = new Contract();
        struct.contract.read(iprot);
        struct.setContractIsSet(true);
      }
      if (incoming.get(1)) {
        struct.priceType = iprot.readI32();
        struct.setPriceTypeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.plusTick = iprot.readI32();
        struct.setPlusTickIsSet(true);
      }
      if (incoming.get(3)) {
        struct.composeUkey = iprot.readString();
        struct.setComposeUkeyIsSet(true);
      }
      if (incoming.get(4)) {
        struct.sledContractId = iprot.readI32();
        struct.setSledContractIdIsSet(true);
      }
    }
  }

}

