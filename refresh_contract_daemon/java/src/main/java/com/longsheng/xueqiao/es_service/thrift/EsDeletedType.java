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

public enum EsDeletedType implements org.apache.thrift.TEnum {
  UNKNOWN(-1),
  DEL_YES(0),
  DEL_NO(1),
  DEL_DISAPPEAR(2);

  private final int value;

  private EsDeletedType(int value) {
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
  public static EsDeletedType findByValue(int value) { 
    switch (value) {
      case -1:
        return UNKNOWN;
      case 0:
        return DEL_YES;
      case 1:
        return DEL_NO;
      case 2:
        return DEL_DISAPPEAR;
      default:
        return null;
    }
  }
}