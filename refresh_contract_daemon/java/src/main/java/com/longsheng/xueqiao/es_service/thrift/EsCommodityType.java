/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.es_service.thrift;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum EsCommodityType implements org.apache.thrift.TEnum {
  UNKNOWN(-1),
  COMMODITY_TYPE_GOODS(0),
  COMMODITY_TYPE_FUTURE(1),
  COMMODITY_TYPE_OPTION(2),
  COMMODITY_TYPE_SPREAD_MONTH(3),
  COMMODITY_TYPE_SPREAD_COMMODITY(4);

  private final int value;

  private EsCommodityType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static EsCommodityType findByValue(int value) { 
    switch (value) {
      case -1:
        return UNKNOWN;
      case 0:
        return COMMODITY_TYPE_GOODS;
      case 1:
        return COMMODITY_TYPE_FUTURE;
      case 2:
        return COMMODITY_TYPE_OPTION;
      case 3:
        return COMMODITY_TYPE_SPREAD_MONTH;
      case 4:
        return COMMODITY_TYPE_SPREAD_COMMODITY;
      default:
        return null;
    }
  }
}
