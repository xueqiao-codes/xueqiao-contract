/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.common.thriftapi;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum BasePriceType implements org.apache.thrift.TEnum {
  PRICE_IN_LINE(0),
  PRICE_OPPONENT(1);

  private final int value;

  private BasePriceType(int value) {
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
  public static BasePriceType findByValue(int value) { 
    switch (value) {
      case 0:
        return PRICE_IN_LINE;
      case 1:
        return PRICE_OPPONENT;
      default:
        return null;
    }
  }
}