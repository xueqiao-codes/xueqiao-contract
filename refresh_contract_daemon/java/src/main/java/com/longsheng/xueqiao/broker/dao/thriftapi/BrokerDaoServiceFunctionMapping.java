package com.longsheng.xueqiao.broker.dao.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class BrokerDaoServiceFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("addBrokerEntry",1);
    putEntry("updateBrokerEntry",2);
    putEntry("reqBrokerEntry",3);
    putEntry("addBrokerAccessEntry",4);
    putEntry("updateBrokerAccessEntry",5);
    putEntry("reqBrokerAccessEntry",6);
    putEntry("reqWorkingBrokerAccessEntry",7);
    putEntry("syncBrokerAccessEntry",8);
    putEntry("removeBrokerAccessEntry",9);
    putEntry("removeBrokerEntry",10);
    putEntry("syncBroker",11);
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
