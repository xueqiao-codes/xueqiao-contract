package com.longsheng.xueqiao.ctp_service.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class CtpServiceFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("reqOrderInsert",1);
    putEntry("reqOrderAction",2);
    putEntry("reqInstrumentList",11);
    putEntry("reqInvestorInfo",12);
    putEntry("reqTradingParams",13);
    putEntry("reqOrders",14);
    putEntry("reqTrades",15);
    putEntry("reqInvestorPosition",16);
    putEntry("reqInstrumentMarginRate",18);
    putEntry("reqInstrumentCommissionRate",19);
    putEntry("reqTradingAccount",20);
    putEntry("reqProducts",21);
    putEntry("reqCtpAccount",41);
    putEntry("updateCtpAccount",42);
    putEntry("reqLogin",43);
    putEntry("reqLogout",44);
    putEntry("reqRelogin",45);
    putEntry("reqLoginStatus",46);
  }

  public static int getUniqueNumber(String functionName) {
    Integer number = sMapping.get(functionName);
    if (number == null) {
      return -1;    }
    return number.intValue();
  }

  private static void putEntry(String functionName, int uniqueNumber) {
    sMapping.put(functionName, uniqueNumber);
  }

}
