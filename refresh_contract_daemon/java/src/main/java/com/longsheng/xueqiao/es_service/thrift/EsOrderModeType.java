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

public enum EsOrderModeType implements org.apache.thrift.TEnum {
  UNKNOWN(-1),
  ORDER_MODE_FOK(0),
  ORDER_MODE_FAK(1),
  ORDER_MODE_GFD(2),
  ORDER_MODE_GTC(3),
  ORDER_MODE_GTD(4);

  private final int value;

  private EsOrderModeType(int value) {
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
  public static EsOrderModeType findByValue(int value) { 
    switch (value) {
      case -1:
        return UNKNOWN;
      case 0:
        return ORDER_MODE_FOK;
      case 1:
        return ORDER_MODE_FAK;
      case 2:
        return ORDER_MODE_GFD;
      case 3:
        return ORDER_MODE_GTC;
      case 4:
        return ORDER_MODE_GTD;
      default:
        return null;
    }
  }
}