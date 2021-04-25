package com.longsheng.xueqiao.broker.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class BrokerServiceFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("reqBroker",1);
    putEntry("reqBrokerAccess",2);
    putEntry("reqBrokerAccessInfo",3);
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
