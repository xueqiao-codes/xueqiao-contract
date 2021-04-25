package com.longsheng.daemon;


import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContract;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contractconvertor.LibraryLoader;
import com.longsheng.xueqiao.contractconvertor.swig.CommonContract;
import com.longsheng.xueqiao.contractconvertor.swig.ContractConvertor;
import com.longsheng.xueqiao.contractconvertor.swig.TechPlatformContractToSledArgs;
import com.longsheng.xueqiao.contractconvertor.swig.TechPlatformContractToSledResult;
import com.longsheng.xueqiao.ctp_service.CtpAccount;
import com.longsheng.xueqiao.ctp_service.CtpInter;
import com.longsheng.xueqiao.ctp_service.core.trade.CtpTradeApi;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInstrument;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpProduct;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {


//        String sledContractCode = "";
//        String patternStr = "(IPS|SPD|SPC|SP)\\s(.+?)([0-9]+)&(.+?)([0-9]+)";
//
////        String ctpContractCode = "RM803";
////        String ctpContractCode = "m1809-P-3050";
////        String ctpContractCode = "SR807C5400";
//        String ctpContractCode = "IPS SF809&SM809";
////        String ctpContractCode = "SPD RM805&RM809";
////        String ctpContractCode = "SPC j1805&jm1709";
////        String ctpContractCode = "SP y1805&y1809";
//
//
//        Pattern pattern = Pattern.compile(patternStr);
//        Matcher m = pattern.matcher(ctpContractCode);
//        if (m.matches()) {
//            String exchange = m.group(1);
//            String product = m.group(2);
//            String code = m.group(3);
//            String product2 = m.group(4);
//            String code2 =m.group(5);
//            System.out.println("exchange:" + exchange);
//            System.out.println("product:" + product);
//            System.out.println("code:" + code);
//            System.out.println("product2:" + product2);
//            System.out.println("code2:" + code2);
//
//            if (code.length() < 4){
//
//                String yearPreStr = code.substring(0,1);
//                String codeSub = code.substring(1);
//                int yearPre= Integer.parseInt(yearPreStr);
//                Date date = new Date();
//                int todayYear= date.getYear() + 1900;
//                int TwoKYear = 2000;
//                boolean needRun =false;
//                do {
//
//
//                    if (TwoKYear + yearPre < todayYear){
//                        yearPre +=10;
//                        needRun= true;
//                    }
//                    else {
//                        needRun =false;
//                    }
//
//                }while (needRun);
//                System.out.println(todayYear);
//                System.out.println(yearPre);
//
//                code =yearPre+ codeSub;
//                System.out.println("code :" +code);
//            }
//
//        } else {
//            System.out.println(ctpContractCode);
//        }
//        transform();


//        Ctp.account.host=tcp://101.231.3.126:41205
//        Ctp.account.simhost=tcp://101.231.3.125:41205
//        Ctp.account.brokerId=8888
//        Ctp.account.userId=180861
//        Ctp.account.password=longsheng1919

        testCtp();


//        AppLog.d("MAIN START");
//        try {
//            LibraryLoader.init();
//            com.longsheng.xueqiao.util.esunny9.LibraryLoader.init();
//            TCommodityMapCache commodityMapCache = TCommodityMapCache.getInstance();
//            AppLog.d("init commodity map");
//            try {
//                commodityMapCache.init(0);
//            } catch (TException e) {
//                e.printStackTrace();
//            }
//
//
//            try {
//                new EsunnyV9().run();
//            } catch (TException e) {
//                e.printStackTrace();
//            }
//
//            AppLog.d("done");
//
//            do {
//                try {
//                    AppLog.d("waiting...");
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            } while (true);
//        } catch (Exception e) {
//            AppLog.e(e.getMessage(), e);
//        }
    }

    public static void testCtp() {
        CtpAccount account = new CtpAccount();
        account.setBrokerId("8888");
        account.setPassword("longsheng1919");
        account.setUserId("180861");
//        List<String> hosts = new ArrayList<>();
//        hosts.add("tcp://101.231.3.125:41205");
//        hosts.add();
        account.setHost("tcp://101.231.3.126:41205");
        CtpTradeApi ctpTradeApi = new CtpTradeApi(account);

        do {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!ctpTradeApi.isRefresh);


        List<CtpInstrument> list = ctpTradeApi.reqInstrumentList(null);
        System.out.println(list);
        List<CtpProduct> pros = ctpTradeApi.reqProducts(null);
        System.out.println(pros);
    }

    public static void transform() {
        String platformContractCode = "2106/2411";
        PlatformCommodity platformCommodity = new PlatformCommodity();
        platformCommodity.setCommodityCode("SP_BRENT");
        platformCommodity.setCommodityType("S");
        platformCommodity.setExchange("ICEU");

        TechPlatform techPlatform = TechPlatform.ESUNNY_3;
        TSledContract tSledContract = new TSledContract();
        TechPlatformContractToSledArgs toSledArgs = new TechPlatformContractToSledArgs();
        if (techPlatform == TechPlatform.CTP)
            toSledArgs.setTechPlatform_(com.longsheng.xueqiao.contractconvertor.swig.TechPlatform.TechPlatform_CTP);
        if (techPlatform == TechPlatform.ESUNNY_3)
            toSledArgs.setTechPlatform_(com.longsheng.xueqiao.contractconvertor.swig.TechPlatform.TechPlatform_ESUNNY_3);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_(platformCommodity.getExchange());
        commonContract.setTechPlatform_CommodityType_(platformCommodity.getCommodityType());
        commonContract.setTechPlatform_CommodityCode_(platformCommodity.getCommodityCode());
        commonContract.setTechPlatform_ContractCode_(platformContractCode);
        toSledArgs.setCommonContract_(commonContract);
        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(toSledArgs);
        AppLog.d("TechPlatformContractToSledResult : " + result);
        if (result == null) {
            System.out.println("rusult: " + result);
        }
        AppLog.d("result.getMixContract().getSledContractCode(): " + result.getMixContract_().getSledContractCode_());
        tSledContract.setSledContractCode(result.getMixContract_().getSledContractCode_());

        AppLog.d("getRelateMixContractCount: " + result.getRelateMixContractCount_());
//        List<TSledContract> relateContracts = getRelateContractIds(result, techPlatformEnv, techPlatform);

        System.out.println(tSledContract);
        System.out.println("getRelateMixContractCount: " + result.getRelateMixContractCount_());
    }

}
