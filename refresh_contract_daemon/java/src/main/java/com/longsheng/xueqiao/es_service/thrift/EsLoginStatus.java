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

public enum EsLoginStatus implements org.apache.thrift.TEnum {
  LOGGING(0),
  LOGIN(1),
  LOGOUT(2),
  LOGIN_FAIL(3),
  DISCONNECTED(4);

  private final int value;

  private EsLoginStatus(int value) {
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
  public static EsLoginStatus findByValue(int value) { 
    switch (value) {
      case 0:
        return LOGGING;
      case 1:
        return LOGIN;
      case 2:
        return LOGOUT;
      case 3:
        return LOGIN_FAIL;
      case 4:
        return DISCONNECTED;
      default:
        return null;
    }
  }
}
