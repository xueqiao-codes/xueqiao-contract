/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.standard.thriftapi;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum PlatformEnv implements org.apache.thrift.TEnum {
  NONE(0),
  REAL(1),
  SIM(2);

  private final int value;

  private PlatformEnv(int value) {
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
  public static PlatformEnv findByValue(int value) { 
    switch (value) {
      case 0:
        return NONE;
      case 1:
        return REAL;
      case 2:
        return SIM;
      default:
        return null;
    }
  }
}