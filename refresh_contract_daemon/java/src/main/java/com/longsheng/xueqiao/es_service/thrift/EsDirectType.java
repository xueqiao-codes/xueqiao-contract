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

public enum EsDirectType implements org.apache.thrift.TEnum {
  UNKNOWN(-1),
  DIRECT_BUY(0),
  DIRECT_SELL(1);

  private final int value;

  private EsDirectType(int value) {
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
  public static EsDirectType findByValue(int value) { 
    switch (value) {
      case -1:
        return UNKNOWN;
      case 0:
        return DIRECT_BUY;
      case 1:
        return DIRECT_SELL;
      default:
        return null;
    }
  }
}
