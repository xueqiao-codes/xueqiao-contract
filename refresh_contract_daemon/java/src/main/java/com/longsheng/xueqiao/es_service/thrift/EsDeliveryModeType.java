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

public enum EsDeliveryModeType implements org.apache.thrift.TEnum {
  UNKNOWN(-1),
  DELIVERY_MODE_GOODS(0),
  DELIVERY_MODE_CASH(1),
  DELIVERY_MODE_EXECUTE(2);

  private final int value;

  private EsDeliveryModeType(int value) {
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
  public static EsDeliveryModeType findByValue(int value) { 
    switch (value) {
      case -1:
        return UNKNOWN;
      case 0:
        return DELIVERY_MODE_GOODS;
      case 1:
        return DELIVERY_MODE_CASH;
      case 2:
        return DELIVERY_MODE_EXECUTE;
      default:
        return null;
    }
  }
}
