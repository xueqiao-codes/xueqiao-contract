package com.longsheng.xueqiao.es_service.thrift;


import java.util.HashMap;
import java.util.Map; 

public class EsServiceFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("reqOrderInsert",1);
    putEntry("reqOrderAction",2);
    putEntry("reqOrders",3);
    putEntry("reqTrades",4);
    putEntry("reqInstruments",51);
    putEntry("reqProducts",52);
    putEntry("reqClientCountRents",53);
    putEntry("reqEsAccount",101);
    putEntry("updateEsAccount",102);
    putEntry("reqLogin",103);
    putEntry("reqLogout",104);
    putEntry("reqRelogin",105);
    putEntry("reqLoginStatus",106);
    putEntry("reqEsHolds",151);
    putEntry("reqEsMoney",152);
    putEntry("test1",251);
    putEntry("test2",252);
    putEntry("test3",253);
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
