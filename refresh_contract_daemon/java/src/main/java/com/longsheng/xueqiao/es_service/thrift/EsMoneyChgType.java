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

public enum EsMoneyChgType implements org.apache.thrift.TEnum {
  UNKNOWN(-1),
  MONEY_CHG_ADJUST(0),
  MONEY_CHG_CASHIN(1),
  MONEY_CHG_CASHOUT(2),
  MONEY_CHG_FEE(3),
  MONEY_CHG_FROZEN(4),
  MONEY_CHG_COVERPROFIT(5),
  MONEY_CHG_DAYCVERPROFIT(6),
  MONEY_CHG_FLOATPROFIT(7),
  MONEY_CHG_DAYFLOATPROFIT(8),
  MONEY_CHG_UNEXPIREDPROFIT(9),
  MONEY_CHG_PREMIUM(10),
  MONEY_CHG_DEPOSIT(11),
  MONEY_CHG_KEEPDEPOSIT(12),
  MONEY_CHG_PLEDGE(13),
  MONEY_CHG_TAVAILABLE(14),
  MONEY_CHG_Discount(15),
  MONEY_CHG_TradeFee(16),
  MONEY_CHG_DeliveryFee(17),
  MONEY_CHG_ExchangeFee(18),
  MONEY_CHG_FrozenDeposit(19),
  MONEY_CHG_FrozenFee(20),
  MONEY_CHG_NewFloatProfit(21),
  MONEY_CHG_LmeFloatProfit(22),
  MONEY_CHG_OptionMarketValue(23),
  MONEY_CHG_OriCash(24),
  MONEY_CHG_TMoney(25),
  MONEY_CHG_TBalance(26),
  MONEY_CHG_TCanCashOut(27),
  MONEY_CHG_RiskRate(28),
  MONEY_CHG_AccountMarketValue(29);

  private final int value;

  private EsMoneyChgType(int value) {
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
  public static EsMoneyChgType findByValue(int value) { 
    switch (value) {
      case -1:
        return UNKNOWN;
      case 0:
        return MONEY_CHG_ADJUST;
      case 1:
        return MONEY_CHG_CASHIN;
      case 2:
        return MONEY_CHG_CASHOUT;
      case 3:
        return MONEY_CHG_FEE;
      case 4:
        return MONEY_CHG_FROZEN;
      case 5:
        return MONEY_CHG_COVERPROFIT;
      case 6:
        return MONEY_CHG_DAYCVERPROFIT;
      case 7:
        return MONEY_CHG_FLOATPROFIT;
      case 8:
        return MONEY_CHG_DAYFLOATPROFIT;
      case 9:
        return MONEY_CHG_UNEXPIREDPROFIT;
      case 10:
        return MONEY_CHG_PREMIUM;
      case 11:
        return MONEY_CHG_DEPOSIT;
      case 12:
        return MONEY_CHG_KEEPDEPOSIT;
      case 13:
        return MONEY_CHG_PLEDGE;
      case 14:
        return MONEY_CHG_TAVAILABLE;
      case 15:
        return MONEY_CHG_Discount;
      case 16:
        return MONEY_CHG_TradeFee;
      case 17:
        return MONEY_CHG_DeliveryFee;
      case 18:
        return MONEY_CHG_ExchangeFee;
      case 19:
        return MONEY_CHG_FrozenDeposit;
      case 20:
        return MONEY_CHG_FrozenFee;
      case 21:
        return MONEY_CHG_NewFloatProfit;
      case 22:
        return MONEY_CHG_LmeFloatProfit;
      case 23:
        return MONEY_CHG_OptionMarketValue;
      case 24:
        return MONEY_CHG_OriCash;
      case 25:
        return MONEY_CHG_TMoney;
      case 26:
        return MONEY_CHG_TBalance;
      case 27:
        return MONEY_CHG_TCanCashOut;
      case 28:
        return MONEY_CHG_RiskRate;
      case 29:
        return MONEY_CHG_AccountMarketValue;
      default:
        return null;
    }
  }
}
