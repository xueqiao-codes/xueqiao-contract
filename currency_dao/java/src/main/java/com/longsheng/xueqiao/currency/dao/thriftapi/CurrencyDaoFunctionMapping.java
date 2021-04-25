package com.longsheng.xueqiao.currency.dao.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class CurrencyDaoFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("addCurrency",1);
    putEntry("updateCurrency",2);
    putEntry("reqCurrency",3);
    putEntry("reqExchangeRate",10);
    putEntry("updateExchangeRateValue",11);
    putEntry("syncExchangeRateToOnline",12);
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
