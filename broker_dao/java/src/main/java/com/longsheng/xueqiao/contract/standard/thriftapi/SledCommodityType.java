/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.contract.standard.thriftapi;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum SledCommodityType implements org.apache.thrift.TEnum {
  NONE(0),
  FUTURES(1),
  OPTION(2),
  SPOT(3),
  SPREAD_MONTH(4),
  SPREAD_COMMODITY(5),
  BUL(6),
  BER(7),
  STD(8),
  STG(9),
  PRT(10),
  DIRECTFOREX(11),
  INDIRECTFOREX(12),
  CROSSFOREX(13),
  INDEX(14),
  STOCK(15);

  private final int value;

  private SledCommodityType(int value) {
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
  public static SledCommodityType findByValue(int value) { 
    switch (value) {
      case 0:
        return NONE;
      case 1:
        return FUTURES;
      case 2:
        return OPTION;
      case 3:
        return SPOT;
      case 4:
        return SPREAD_MONTH;
      case 5:
        return SPREAD_COMMODITY;
      case 6:
        return BUL;
      case 7:
        return BER;
      case 8:
        return STD;
      case 9:
        return STG;
      case 10:
        return PRT;
      case 11:
        return DIRECTFOREX;
      case 12:
        return INDIRECTFOREX;
      case 13:
        return CROSSFOREX;
      case 14:
        return INDEX;
      case 15:
        return STOCK;
      default:
        return null;
    }
  }
}
