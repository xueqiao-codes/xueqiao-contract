/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.contract.thriftapi;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum ImportMapErrorCode implements org.apache.thrift.TEnum {
  MAP_FILE_READ_FAIL(2001),
  MAP_FILE_MD5_ERROR(2002),
  DATA_FORMAT_ERROR(2003);

  private final int value;

  private ImportMapErrorCode(int value) {
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
  public static ImportMapErrorCode findByValue(int value) { 
    switch (value) {
      case 2001:
        return MAP_FILE_READ_FAIL;
      case 2002:
        return MAP_FILE_MD5_ERROR;
      case 2003:
        return DATA_FORMAT_ERROR;
      default:
        return null;
    }
  }
}
