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

public enum PositionDateType implements org.apache.thrift.TEnum {
  EMPTY(0),
  TODAY(1),
  HISTORY(2);

  private final int value;

  private PositionDateType(int value) {
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
  public static PositionDateType findByValue(int value) { 
    switch (value) {
      case 0:
        return EMPTY;
      case 1:
        return TODAY;
      case 2:
        return HISTORY;
      default:
        return null;
    }
  }
}
