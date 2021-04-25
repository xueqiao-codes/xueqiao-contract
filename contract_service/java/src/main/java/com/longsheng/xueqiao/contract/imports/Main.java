package com.longsheng.xueqiao.contract.imports;

import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityConfig;
import org.apache.commons.lang.math.RandomUtils;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


//        String filepath = "/Users/walter/Desktop/data/file_upload_test.txt";
//        File file = new File(filepath);
//        Importer importer = new Importer();
//        CommodityMapFileInfo fileInfo = new CommodityMapFileInfo();
//        fileInfo.setBrokerEntryId(0);
//        fileInfo.setFileMD5("D0291DC733989435B19163545E4F1B2A");
////        byte[] data = IOUtils.readFully(file);
////        fileInfo.setCommodityMapFile(data);
//        try {
//            importer.importMapFile(fileInfo);
//        } catch (TException e) {
//            System.out.println(e);
//        }

//        Map<String, String> exchangeMap = new HashMap<>();
//        exchangeMap.put("CCFX", "CFFEX");
//        exchangeMap.put("XDCE", "DCE");
//        exchangeMap.put("XSGE", "SHFE");
//        exchangeMap.put("XZCE", "CZCE");
//        exchangeMap.put("XINE", "INE");
//
//        Gson gson = new Gson();
//        String json = gson.toJson(exchangeMap);
//        System.out.println(json);
//
//        HashMap<String, String> ctpExchangeMap = new Gson().fromJson(json, new HashMap<String, String>().getClass());
////        new TypeToken<HashMap<String, String>>(){}.getType()
//        System.out.println(ctpExchangeMap.size());
//        for (String key : ctpExchangeMap.keySet()) {
//            System.out.println(key);
//            System.out.println(ctpExchangeMap.get(key));
//        }
//
//        Map<String, String> commodityTypeMap = new HashMap<>();
//        commodityTypeMap.put("FUTURES", "1");
//        commodityTypeMap.put("OPTION", "2");
//        commodityTypeMap.put("SPREAD_MONTH", "3");
//        commodityTypeMap.put("SPREAD_COMMODITY", "3");
//
//        json = gson.toJson(commodityTypeMap);
//        System.out.println(json);
//
//
//        exchangeMap.clear();
//        commodityTypeMap.clear();
//        exchangeMap.put("XASX", "ASX");
//        exchangeMap.put("XKLS", "BMD");
//        exchangeMap.put("XCBT", "CBOT");
//        exchangeMap.put("XCME", "CME");
//        exchangeMap.put("XCEC", "COMEX");
//        exchangeMap.put("XEUR", "EUREX");
//        exchangeMap.put("XHKG", "HKEX");
//        exchangeMap.put("IFCA", "ICCA");
//        exchangeMap.put("IFEU", "ICEU");
//        exchangeMap.put("IFSG", "ICE_SG");
////        exchangeMap.put("IFLL","ICEU");
//        exchangeMap.put("IFUS", "ICUS");
//        exchangeMap.put("XKRX", "KRX");
//        exchangeMap.put("IFLX", "LIFFE");
//        exchangeMap.put("XPAR", "EURONEXT");
//        exchangeMap.put("XLME", "LME");
//        exchangeMap.put("XNYM", "NYMEX");
//        exchangeMap.put("XOSE", "OSE");
//        exchangeMap.put("XSES", "SGX");
//        exchangeMap.put("XTKT", "TOCOM");
//        exchangeMap.put("XTKS", "TES");
//        exchangeMap.put("TFEX", "TFEX");
//        exchangeMap.put("XNYM", "NYMEX");
//        exchangeMap.put("IFLL", "ICEU");
//
//        json = gson.toJson(exchangeMap);
//        System.out.println(json);
//
//        commodityTypeMap.put("FUTURES", "F");
//        commodityTypeMap.put("OPTION", "O");
//        commodityTypeMap.put("SPREAD_MONTH", "S");
//        commodityTypeMap.put("SPREAD_COMMODITY", "M");
//
//        json = gson.toJson(commodityTypeMap);
//        System.out.println(json);

//        compare();



    }

    private static void compare() {
        List<SledCommodityConfig> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SledCommodityConfig commodityConfig = new SledCommodityConfig();

            long start = RandomUtils.nextInt() +i*100;
            long end = start + RandomUtils.nextInt();
            commodityConfig.setActiveStartTimestamp(start);
            commodityConfig.setActiveEndTimestamp(end);
            commodityConfig.setConfigId(i);
            list.add(commodityConfig);
        }

        Comparator comparator = Comparator.comparing(SledCommodityConfig::getActiveStartTimestamp);
        list.sort(comparator);

        for (int i = 0; i < 5; i++) {
            System.out.println("start:");
            System.out.println(list.get(i).getActiveStartTimestamp());
            if (i<4)
            System.out.println(list.get(i).setActiveEndTimestamp(list.get(i+1).getActiveStartTimestamp()));
        }
    }
}
