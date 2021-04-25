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

public enum MatchSource implements org.apache.thrift.TEnum {
  ALL(0),
  SELF_ETRADER(1),
  PROXY_ETRADER(2),
  JTRADER(3),
  MANUAL(4),
  CARRY(5),
  PROGRAM(6),
  DELIVERY(7),
  ABANDON(8),
  CHANNEL(9),
  ESUNNY_API(10);

  private final int value;

  private MatchSource(int value) {
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
  public static MatchSource findByValue(int value) { 
    switch (value) {
      case 0:
        return ALL;
      case 1:
        return SELF_ETRADER;
      case 2:
        return PROXY_ETRADER;
      case 3:
        return JTRADER;
      case 4:
        return MANUAL;
      case 5:
        return CARRY;
      case 6:
        return PROGRAM;
      case 7:
        return DELIVERY;
      case 8:
        return ABANDON;
      case 9:
        return CHANNEL;
      case 10:
        return ESUNNY_API;
      default:
        return null;
    }
  }
}