//package com.xueqiao.analysis;
//
//import com.longsheng.xueqiao.util.esunny9.swig.EsCommodityInfo;
//import com.longsheng.xueqiao.util.esunny9.swig.EsContractInfo;
//import com.longsheng.xueqiao.util.esunny9.swig.EsunnyTradeSwig;
//import com.longsheng.xueqiao.util.esunny9.swig.IEsunnyTradeSwigCallback;
//import org.apache.thrift.TException;
//import org.soldier.base.logger.AppLog;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Es9TradeCallback extends IEsunnyTradeSwigCallback {
//
//    private EsunnyTradeSwig esunnyTradeSwig;
//
//    private volatile boolean isInitFinish = true;
//    //
//    private volatile boolean isCommodityFinish;
//    //
//    private volatile boolean isContractFinish;
//
//    private EsunnyV9 esunnyV9;
//
//    private Map<String, EsCommodityInfo> esCommodityInfoHashMap = new HashMap<>();
//    private List<EsContractInfo> esContractInfos = new ArrayList<>();
//
//    private boolean isSend = true;
//
//    public Es9TradeCallback(EsunnyTradeSwig esunnyTradeSwig, EsunnyV9 esunnyV9) {
//        if (esunnyTradeSwig == null) {
//            throw new IllegalArgumentException();
//        }
//        this.esunnyTradeSwig = esunnyTradeSwig;
//        this.esunnyV9 = esunnyV9;
//    }
//
//    @Override
//    public void onInitFinish(boolean isFinish) {
//        System.out.println("init :" + isFinish);
//        this.isInitFinish = isFinish;
//        if (isFinish) {
//            AppLog.e("Init");
//            this.esunnyTradeSwig.GetCommodityList();
//            // 只存期货和跨期
//            this.esunnyTradeSwig.GetContractList('F');
//            this.esunnyTradeSwig.GetContractList('S');
//            try {
//                System.out.println("runUpdate start");
//                this.esunnyV9.runUpdate(this.esCommodityInfoHashMap, this.esContractInfos);
//                isSend = false;
//                System.out.println("runUpdate end");
//            } catch (TException e) {
//                System.out.println(e.getMessage());
//                AppLog.e(e.getMessage(), e);
//            }
//        } else {
//            AppLog.e("Uninit");
//        }
//        if (isSend){
//            String errMsg = "Refresh esunny fail. Init es api fail.";
//            new SmsSender().send2Maintance(errMsg);
//        }
//        this.esunnyTradeSwig.Uninit();
//    }
//
//    @Override
//    public void onCommodity(EsCommodityInfo esCommodityInfo, boolean isFinish) {
////        AppLog.d("isFinish: " + isFinish);
//
//        isCommodityFinish = isFinish;
//
//        EsCommodityInfo newEsCommodityInfo = new EsCommodityInfo();
//        newEsCommodityInfo.setExchangeNo(esCommodityInfo.getExchangeNo());
//        newEsCommodityInfo.setCommodityType(esCommodityInfo.getCommodityType());
//        newEsCommodityInfo.setCommodityNo(esCommodityInfo.getCommodityNo());
//        newEsCommodityInfo.setCommodityName(esCommodityInfo.getCommodityName());
//        newEsCommodityInfo.setCommodityEngName(esCommodityInfo.getCommodityEngName());
//        newEsCommodityInfo.setRelateExchangeNo(esCommodityInfo.getRelateExchangeNo());
//        newEsCommodityInfo.setRelateCommodityType(esCommodityInfo.getRelateCommodityType());
//        newEsCommodityInfo.setRelateCommodityNo(esCommodityInfo.getRelateCommodityNo());
//        newEsCommodityInfo.setRelateExchangeNo2(esCommodityInfo.getRelateExchangeNo2());
//        newEsCommodityInfo.setRelateCommodityType2(esCommodityInfo.getRelateCommodityType2());
//        newEsCommodityInfo.setRelateCommodityNo2(esCommodityInfo.getRelateCommodityNo2());
//        newEsCommodityInfo.setCurrencyGroupNo(esCommodityInfo.getCurrencyGroupNo());
//        newEsCommodityInfo.setTradeCurrency(esCommodityInfo.getTradeCurrency());
//        newEsCommodityInfo.setContractSize(esCommodityInfo.getContractSize());
//        newEsCommodityInfo.setOpenCloseMode(esCommodityInfo.getOpenCloseMode());
//        newEsCommodityInfo.setStrikePriceTimes(esCommodityInfo.getStrikePriceTimes());
//        newEsCommodityInfo.setCommodityTickSize(esCommodityInfo.getCommodityTickSize());
//        newEsCommodityInfo.setCommodityDenominator(esCommodityInfo.getCommodityDenominator());
//        newEsCommodityInfo.setCmbDirect(esCommodityInfo.getCmbDirect());
//        newEsCommodityInfo.setDeliveryMode(esCommodityInfo.getDeliveryMode());
//        newEsCommodityInfo.setDeliveryDays(esCommodityInfo.getDeliveryDays());
//        newEsCommodityInfo.setAddOneTime(esCommodityInfo.getAddOneTime());
//        newEsCommodityInfo.setCommodityTimeZone(esCommodityInfo.getCommodityTimeZone());
//        newEsCommodityInfo.setIsAddOne(esCommodityInfo.getIsAddOne());
//
//        esCommodityInfoHashMap.put(genCommodityKey(newEsCommodityInfo.getExchangeNo(), newEsCommodityInfo.getCommodityType(), newEsCommodityInfo.getCommodityNo()), newEsCommodityInfo);
////        uninit();
//    }
//
//    public static String genCommodityKey(String exchangeNo, char commodityType, String commodityNo) {
//        StringBuilder builder = new StringBuilder(128);
//        builder.append(exchangeNo);
//        builder.append("|");
//        builder.append(commodityType);
//        builder.append("|");
//        builder.append(commodityNo);
//        return builder.toString();
//    }
//
//    @Override
//    public void onContract(EsContractInfo esContractInfo, boolean isFinish) {
////        AppLog.d("isFinish: " + isFinish);
////        printContract(esContractInfo);
//        isContractFinish = isFinish;
//
//        EsContractInfo newEsContractInfo = new EsContractInfo();
//        newEsContractInfo.setExchangeNo(esContractInfo.getExchangeNo());
//        newEsContractInfo.setCommodityType(esContractInfo.getCommodityType());
//        newEsContractInfo.setCommodityNo(esContractInfo.getCommodityNo());
//        newEsContractInfo.setContractName(esContractInfo.getContractName());
//        newEsContractInfo.setContractType(esContractInfo.getContractType());
//        newEsContractInfo.setContractNo1(esContractInfo.getContractNo1());
//        newEsContractInfo.setContractNo2(esContractInfo.getContractNo2());
//        newEsContractInfo.setStrikePrice1(esContractInfo.getStrikePrice1());
//        newEsContractInfo.setStrikePrice2(esContractInfo.getStrikePrice2());
//        newEsContractInfo.setCallOrPutFlag1(esContractInfo.getCallOrPutFlag1());
//        newEsContractInfo.setCallOrPutFlag2(esContractInfo.getCallOrPutFlag2());
//        newEsContractInfo.setQuoteUnderlyingContract(esContractInfo.getQuoteUnderlyingContract());
//        newEsContractInfo.setContractExpDate(esContractInfo.getContractExpDate());
//        newEsContractInfo.setLastTradeDate(esContractInfo.getLastTradeDate());
//        newEsContractInfo.setFirstNoticeDate(esContractInfo.getFirstNoticeDate());
//        esContractInfos.add(newEsContractInfo);
//
//    }
//
//    public Map<String, EsCommodityInfo> getEsCommodityInfoHashMap() {
//        return this.esCommodityInfoHashMap;
//    }
//
//    public List<EsContractInfo> getEsContractInfos() {
//        return this.esContractInfos;
//    }
//
//}
