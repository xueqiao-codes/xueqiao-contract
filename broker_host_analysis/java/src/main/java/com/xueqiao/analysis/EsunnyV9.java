//package com.xueqiao.analysis;
//
//import com.antiy.error_code.ErrorCodeOuter;
//import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
//import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
//import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
//import com.longsheng.xueqiao.broker.thriftapi.AccessAddress;
//import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry;
//import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContract;
//import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
//import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption;
//import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
//import com.longsheng.xueqiao.contract.standard.thriftapi.SledContract;
//import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
//import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv;
//import com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount;
//import com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccountPage;
//import com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceAccountOption;
//import com.longsheng.xueqiao.contract.thriftapi.SledContractEditPage;
//import com.longsheng.xueqiao.contract.thriftapi.WorkingStatus;
//import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
//import com.longsheng.xueqiao.util.esunny9.swig.*;
//import org.apache.commons.lang.StringUtils;
//import org.apache.thrift.TException;
//import org.soldier.base.logger.AppLog;
//import org.soldier.platform.svr_platform.comm.ErrorInfo;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//public class EsunnyV9 {
//
//    private static final String taskCount = "esunyV9.add.contract";
//    private static final String taskTotal = "esunyV9.add.contract.total";
//    private static final String REFRESH_ESUNNY_SUCCESS = "refresh.contract.analysis.esunny.success";
//
//    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    private ContractDaoServiceStub contractDaoServiceStub = new ContractDaoServiceStub();
//    private CommoditySourceAccount workingAccount;
//    private ContractServiceStub contractServiceStub = new ContractServiceStub();
//    private int count = 0;
//
//    public void run() throws TException {
//        setSourceAccount();
//        if (StringUtils.isBlank(workingAccount.getIpAddress())) {
//            setBrokerAccessInfo();
//        }
//        System.out.println("working account: " + workingAccount);
//        EsLoginInfo esLoginInfo = new EsLoginInfo();
//        esLoginInfo.setUserNo(workingAccount.getAccountName());
//        esLoginInfo.setPassword(workingAccount.getAccountpwd());
//        esLoginInfo.setIp(workingAccount.getIpAddress());
//        esLoginInfo.setPort(workingAccount.getPort());
//        esLoginInfo.setAuthCode(workingAccount.getAccountProperties().get("CER"));
//
//        EsunnyTradeSwig esunnyTradeSwig = new EsunnyTradeSwig();
//        Es9TradeCallback callback = new Es9TradeCallback(esunnyTradeSwig, this);
//
//
//        QryCommodityType qryCommodityType = new QryCommodityType();
//        qryCommodityType.setEnable_Futures(true);
//        qryCommodityType.setEnable_Spread_Month(true);
//        qryCommodityType.setEnable_Spread_Commodity(true);
//        System.out.println("init es api ...");
//        esunnyTradeSwig.Init(esLoginInfo, callback, qryCommodityType);
//    }
//
//    public void runUpdate(Map<String, EsCommodityInfo> esCommodityInfos, List<EsContractInfo> esContractInfos) throws TException {
//
//        System.out.println("esCommodityInfos: " + esCommodityInfos.size());
//        System.out.println("esContractInfos: " + esContractInfos.size());
//        AppLog.d("esCommodityInfos: " + esCommodityInfos.size());
//        AppLog.d("esContractInfos: " + esContractInfos.size());
//
//        TechPlatformCommodityUpdate.refreshEsunnyTechPlatformCommodity(esCommodityInfos.values());
//
//        List<String> xlmeContracts = new ArrayList();
//        xlmeContracts.add("3M");
//        xlmeContracts.add("CASH");
//        xlmeContracts.add("TOM");
//
//        for (EsContractInfo esContractInfo : esContractInfos) {
//            AppLog.d("esContractInfo: " + esContractInfo.getContractNo1());
//            AppLog.d("esContractInfo.getContractExpDate: " + esContractInfo.getContractExpDate());
//
//            EsCommodityInfo esCommodityInfo = esCommodityInfos.get(Es9TradeCallback.genCommodityKey(esContractInfo.getExchangeNo(), esContractInfo.getCommodityType(), esContractInfo.getCommodityNo()));
//            if (esCommodityInfo == null) {
//                continue;
//            }
//            PlatformCommodity platformCommodity = TechPlatformCommodityUpdate.getEsPlatformCommodity(esCommodityInfo);
//            if (platformCommodity == null) {
//                continue;
//            }
//
//            TechPlatform techPlatform = TechPlatform.ESUNNY;
//            SledCommodity sledCommodity = CtpContractUpdateDaemon.getCommodity(platformCommodity, techPlatform);
//            if (sledCommodity == null) {
//                AppLog.d("sledCommodity null ");
//                continue;
//            }
//
//            // 对LME 交易所合约进行过滤，不导入每日合约
//            if ("XLME".equals(sledCommodity.getExchangeMic())) {
//                if (!xlmeContracts.contains(esContractInfo.getContractNo1())) {
//                    continue;
//                }
//                AppLog.e("refresh XLME esContractInfo.getContractNo1: " + esContractInfo.getContractNo1());
//                AppLog.e("refresh XLME sledCommodity.isIsAlsoSupportSim: " + sledCommodity.isIsAlsoSupportSim());
//            }
//
//            List<TechPlatformEnv> envList = new ArrayList<>();
//            envList.add(TechPlatformEnv.REAL);
//            if (sledCommodity.isIsAlsoSupportSim()) {
//                envList.add(TechPlatformEnv.SIM);
//            }
//
//            for (TechPlatformEnv env : envList) {
//
//                TSledContract tSledContract = CtpContractUpdateDaemon.getSledContract(platformCommodity,
//                        esContractInfo.getContractNo1(), env, techPlatform, sledCommodity, esContractInfo.getContractNo2());
//                if (tSledContract == null) {
//
//                    printCommodity(esCommodityInfo);
//                    printContract(esContractInfo);
//
//                    continue;
//                }
//
//                AppLog.d("=== tSledContract === : " + tSledContract);
//                tSledContract.setSledCommodityId(sledCommodity.getSledCommodityId());
//                setDateTimes(esContractInfo, tSledContract);
//                tSledContract.setEngName(esContractInfo.getContractName());
//                tSledContract.setTechPlatformEnv(env.getValue());
//                tSledContract.setWorkingStatus(WorkingStatus.WORKING.getValue());
//
//                if (doUpdate(esContractInfo, tSledContract, env)) continue;
//                addSledContract(esContractInfo, tSledContract, env);
//                count++;
//
//            }
//        }
//
//        System.out.println("Esunny 9 update contract: " + count);
//        AppLog.e("Esunny 9 update contract: " + count);
//        PlatformMonitor.getInstance().logPlatformStatis(REFRESH_ESUNNY_SUCCESS);
//    }
//
//    public void printContract(EsContractInfo esContractInfo) {
//        StringBuilder builder = new StringBuilder(128);
//        builder.append("EsContractInfo: ").append("getExchangeNo: ").append(esContractInfo.getExchangeNo())
//                .append(" ").append("getCommodityType: ").append(esContractInfo.getCommodityType())
//                .append(" ").append("getCommodityNo: ").append(esContractInfo.getCommodityNo())
//                .append(" ").append("getContractType: ").append(esContractInfo.getContractType())
//                .append(" ").append("getContractName: ").append(esContractInfo.getContractName())
//                .append(" ").append("getContractExpDate: ").append(esContractInfo.getContractExpDate())
//                .append(" ").append("getFirstNoticeDate: ").append(esContractInfo.getFirstNoticeDate())
//                .append(" ").append("getFirstNoticeDate: ").append(esContractInfo.getLastTradeDate())
//                .append(" ").append("getContractNo1: ").append(esContractInfo.getContractNo1())
//                .append(" ").append("getContractNo2: ").append(esContractInfo.getContractNo2())
//                .append(" ").append("getStrikePrice1: ").append(esContractInfo.getStrikePrice1())
//                .append(" ").append("getStrikePrice2: ").append(esContractInfo.getStrikePrice2())
//                .append(" ").append("getCallOrPutFlag1: ").append(esContractInfo.getCallOrPutFlag1())
//                .append(" ").append("getCallOrPutFlag2: ").append(esContractInfo.getCallOrPutFlag2())
//                .append(" ").append("getQuoteUnderlyingContract: ").append(esContractInfo.getQuoteUnderlyingContract());
//
////        System.out.println(builder.toString());
//        AppLog.i(builder.toString());
//
//    }
//
//    public void printCommodity(EsCommodityInfo esCommodityInfo) {
//        StringBuilder builder = new StringBuilder(128);
//        builder.append("EsCommodityInfo: ").append("getExchangeNo: ").append(esCommodityInfo.getExchangeNo())
//                .append(" ").append("getCommodityType: ").append(esCommodityInfo.getCommodityType())
//                .append(" ").append("getCommodityNo: ").append(esCommodityInfo.getCommodityNo())
//                .append(" ").append("getCommodityName: ").append(esCommodityInfo.getCommodityName())
//                .append(" ").append("getAddOneTime: ").append(esCommodityInfo.getAddOneTime())
//                .append(" ").append("getCmbDirect: ").append(esCommodityInfo.getCmbDirect())
//                .append(" ").append("getContractSize: ").append(esCommodityInfo.getContractSize())
//                .append(" ").append("getDeliveryDays: ").append(esCommodityInfo.getDeliveryDays())
//                .append(" ").append("getDeliveryMode: ").append(esCommodityInfo.getDeliveryMode())
//                .append(" ").append("getOpenCloseMode: ").append(esCommodityInfo.getOpenCloseMode())
//                .append(" ").append("getRelateCommodityNo: ").append(esCommodityInfo.getRelateCommodityNo())
//                .append(" ").append("getStrikePriceTimes: ").append(esCommodityInfo.getStrikePriceTimes())
//                .append(" ").append("getTradeCurrency: ").append(esCommodityInfo.getTradeCurrency())
//                .append(" ").append("getCommodityTimeZone: ").append(esCommodityInfo.getCommodityTimeZone())
//                .append(" ").append("getIsAddOne: ").append(esCommodityInfo.getIsAddOne())
//                .append(" ").append("getCommodityDenominator: ").append(esCommodityInfo.getCommodityDenominator())
//                .append(" ").append("getCommodityTickSize: ").append(esCommodityInfo.getCommodityTickSize())
//                .append(" ").append("getCommodityEngName: ").append(esCommodityInfo.getCommodityEngName())
//                .append(" ").append("getRelateExchangeNo2: ").append(esCommodityInfo.getRelateExchangeNo2())
//                .append(" ").append("getRelateCommodityType2: ").append(esCommodityInfo.getRelateCommodityType2())
//                .append(" ").append("getRelateCommodityNo2: ").append(esCommodityInfo.getRelateCommodityNo2());
//
////        System.out.println(builder.toString());
//        AppLog.i(builder.toString());
//
//    }
//
//    private void setBrokerAccessInfo() throws TException {
//        BrokerDaoServiceStub stub = new BrokerDaoServiceStub();
//        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
//        option.addToBrokerIds(workingAccount.getBrokerEntryId());
//        option.addToEntryIds(workingAccount.getBrokerAccessId());
//        BrokerAccessEntryPage page = stub.reqBrokerAccessEntry(option, 0, 1);
//        if (page.getPageSize() > 0) {
//            BrokerAccessEntry entry = page.getPage().get(0);
//            AppLog.i("BrokerAccessEntry: " + entry);
//            for (AccessAddress accessAddress : entry.getTradeAddresses()) {
//                workingAccount.setIpAddress(accessAddress.getAddress());
//                workingAccount.setPort(accessAddress.getPort());
//            }
//        }
//    }
//
//    private void setSourceAccount() throws TException {
//        CommoditySourceAccountPage accountPage = contractServiceStub.reqCommoditySourceAccount(new ReqCommoditySourceAccountOption());
//        if (accountPage.getPageSize() > 0) {
//            for (CommoditySourceAccount account : accountPage.getPage()) {
//                if (TechPlatform.ESUNNY.equals(account.getTechPlatform())) {
//                    // 所有数据来源设定为实盘
//                    if (TechPlatformEnv.REAL.equals(account.getTechPlatformEnv())) {
//                        if (StringUtils.isNotBlank(account.getIpAddress())) {
//                            workingAccount = account;
//                            AppLog.d("workingAccount: " + workingAccount);
//                        } else {
//                            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "source account not found");
//                        }
//                    }
//                }
//            }
//        } else {
//            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "source account not found");
//        }
//    }
//
//    private void addSledContract(EsContractInfo instrument, TSledContract tSledContract, TechPlatformEnv env) throws TException {
//        long start = System.currentTimeMillis() / 1000;
//        long timespan = 100 * 365 * 24 * 60 * 60;
//        long end = start + timespan;
//        tSledContract.setActiveStartTimestamp(start);
//        tSledContract.setActiveEndTimestamp(end);
//        tSledContract.setTechPlatformEnv(env.getValue());
//        tSledContract.setCnName(instrument.getContractName());
//        contractDaoServiceStub.addTSledContract(tSledContract);
//    }
//
//    private boolean doUpdate(EsContractInfo instrument, TSledContract tSledContract, TechPlatformEnv env) {
//        ReqSledContractOption option = new ReqSledContractOption();
//        option.setPlatformEnv(env);
//        option.setSledCommodityId(tSledContract.getSledCommodityId());
//        option.setSledContractCode(tSledContract.getSledContractCode());
//        AppLog.d("tSledContract: " + tSledContract);
//        SledContractEditPage page = null;
//        try {
//            page = new ContractServiceStub().reqSledContractDetail(option, 0, 1);
//        } catch (TException e) {
//            AppLog.e(e.getMessage(), e);
//            return true;
//        }
//
//        if (page.getTotal() > 0) {
//            try {
//                checkUpdate(instrument, page);
//            } catch (TException e) {
//                AppLog.e(e.getMessage(), e);
//            }
//            return true;
//        }
//        return false;
//    }
//
//    private void checkUpdate(EsContractInfo instrument, SledContractEditPage page) throws TException {
//        SledContract oldContract = page.getPage().get(0).getSledContract();
//        TSledContract updateContract = new TSledContract();
//        updateContract.setSledContractId(oldContract.getSledContractId());
//        setDateTimes(instrument, updateContract);
//        updateContract.setWorkingStatus(WorkingStatus.WORKING.getValue());
//
////        if (oldContract.getContractExpDate() != updateContract.getContractExpDate()) {
//        AppLog.d("update tSledContract: " + updateContract);
//        contractDaoServiceStub.updateTSledContract(updateContract);
////        }
//    }
//
//    private void setDateTimes(EsContractInfo esContractInfo, TSledContract tSledContract) {
//        tSledContract.setContractExpDate(pasreDate(esContractInfo.getContractExpDate()));
//        tSledContract.setLastTradeDate(pasreDate(esContractInfo.getLastTradeDate()));
//        tSledContract.setFirstNoticeDate(pasreDate(esContractInfo.getFirstNoticeDate()));
//    }
//
//    private static long pasreDate(String source) {
//
//        try {
//            Date date = dateFormat.parse(source);
//            return date.getTime() / 1000;
//        } catch (ParseException e) {
////            e.printStackTrace();
//        }
//        return 0;
//    }
//
//
//}
