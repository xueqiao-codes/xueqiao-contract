package com.longsheng.daemon;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.broker.thriftapi.AccessAddress;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry;
import com.longsheng.xueqiao.contract.dao.thriftapi.*;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledContract;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
import com.longsheng.xueqiao.contractconvertor.swig.*;
import com.longsheng.xueqiao.ctp_service.CtpAccount;
import com.longsheng.xueqiao.ctp_service.core.trade.CtpTradeApi;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInstrument;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInstrumentCommissionRate;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInstrumentMarginRate;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpProduct;
import com.longsheng.xueqiao.ctp_service.thriftapi.client.CtpServiceStub;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.applet.Applet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CtpContractUpdateDaemon {

    private static final String inactiveFailCount = "daemon.server.inactive.fail.count";
    private static final String inactiveFailTotal = "daemon.server.inactive.fail.total";

    private static final String taskCount = "ctp.add.contract";
    private static final String taskTotal = "ctp.add.contract.total";

    private ContractDaoServiceStub stub = new ContractDaoServiceStub();
    private int routerKey = 0;
    private int timeout = 2000;
    private static DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    private CommoditySourceAccount workingAccount;
    private CtpTradeApi ctpTradeApi;

    ContractServiceStub contractServiceStub = new ContractServiceStub();

    private Map<Integer, Boolean> ctpCommodityRefresh = new HashMap<>();

    private List<CtpInstrument> ctpInstruments = new ArrayList<>();
    private List<CtpProduct> products = new ArrayList<>();

    public CtpContractUpdateDaemon() {

    }

    public void run() throws TException {
        setSourceAccount();
        reqCtp();
        AppLog.d("refresh contract");
        System.out.println("refresh contract");
        ctpCommodityRefresh.clear();
        refreshActiveContract();
        System.out.println("inactive expired contract");
        AppLog.d("inactive expired contract");
        inactiveExpiredContract();
    }

    private void setSourceAccount() throws TException {
        CommoditySourceAccountPage accountPage = contractServiceStub.reqCommoditySourceAccount(new ReqCommoditySourceAccountOption());
        if (accountPage.getPageSize() > 0) {
            for (CommoditySourceAccount account : accountPage.getPage()) {
                if (TechPlatform.CTP.equals(account.getTechPlatform())) {
                    // 所有数据来源设定为实盘
                    if (TechPlatformEnv.REAL.equals(account.getTechPlatformEnv())) {
                        if (StringUtils.isNotBlank(account.getIpAddress())) {
                            workingAccount = account;
                            System.out.println("workingAccount: " + workingAccount);
                        } else {
                            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "source account not found");
                        }
                    }
                }
            }
        } else {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "source account not found");
        }
    }

    private void inactiveExpiredContract() throws TException {

        long now = System.currentTimeMillis() / 1000 - 24 * 60 * 60;
        boolean success = stub.inactiveExpiredSledContract(routerKey, timeout, now);
        if (!success) {

        }
    }

    private void refreshActiveContract() throws TException {
        long start = System.currentTimeMillis() / 1000;
        long timespan = 50 * 365 * 24 * 60 * 60;
        long end = start + timespan;
        int count = 0;
        TechPlatform techPlatform = TechPlatform.CTP;

        List<CtpInstrument> notFuture = new ArrayList<>();
        List<CtpInstrument> futures = new ArrayList<>();

        for (CtpInstrument ctpInstrument : ctpInstruments) {
            PlatformCommodity platformCommodity = map2PlatformCommodity(ctpInstrument.getExchangeID().toUpperCase(),
                    String.valueOf((char) ctpInstrument.getProductClass()), ctpInstrument.getProductID());

            SledCommodity sledCommodity = getCommodity(platformCommodity, techPlatform);
            if (sledCommodity == null) {
                continue;
            }
            if (!SledCommodityType.FUTURES.equals(sledCommodity.getSledCommodityType())) {
                notFuture.add(ctpInstrument);
            } else {
                futures.add(ctpInstrument);
            }
        }

        count = getCount(start, end, count, techPlatform, futures);
        AppLog.e("add new future contract: " + count);
        count = getCount(start, end, count, techPlatform, notFuture);
        AppLog.e("add new notFuture contract: " + count);
    }

    private int getCount(long start, long end, int count, TechPlatform techPlatform, List<CtpInstrument> ctpInstruments) throws TException {
        for (CtpInstrument ctpInstrument : ctpInstruments) {
//            AppLog.d("ctpInstrument : " + ctpInstrument.getInstrumentID());
            PlatformCommodity platformCommodity = map2PlatformCommodity(ctpInstrument.getExchangeID().toUpperCase(),
                    String.valueOf((char) ctpInstrument.getProductClass()), ctpInstrument.getProductID());

            WorkingStatus workingStatus = ctpInstrument.isIsTrading() ? WorkingStatus.WORKING : WorkingStatus.NOT_WORKING;

            SledCommodity sledCommodity = getCommodity(platformCommodity, techPlatform);

//            AppLog.d("sledCommodity : " + sledCommodity);
            if (sledCommodity == null) {
                continue;
            }

            String platformContractCode = ctpInstrument.getInstrumentID();

            List<TechPlatformEnv> envList = new ArrayList<>();
            envList.add(TechPlatformEnv.REAL);
            if (sledCommodity.isIsAlsoSupportSim()) {
                envList.add(TechPlatformEnv.SIM);
            }
            for (TechPlatformEnv env : envList) {
                TSledContract tSledContract = getSledContract(platformCommodity, platformContractCode, env, techPlatform, sledCommodity, null);
//                AppLog.d("tSledContract : " + tSledContract);
                if (tSledContract == null) {
                    continue;
                }
                tSledContract.setSledCommodityId(sledCommodity.getSledCommodityId());
                tSledContract.setWorkingStatus(workingStatus.getValue());
                tSledContract.setSubscribeXQQuote(1);

                ReqTSledContractOption option = new ReqTSledContractOption();
                option.setTechPlatformEnv(env.getValue());
                option.setSledCommodityId(tSledContract.getSledCommodityId());
                option.setSledContractCode(tSledContract.getSledContractCode());
                TSledContractPage page = stub.reqTSledContract(option, 0, 1);

                setDateTimes(ctpInstrument, tSledContract);

                if (page.getTotal() > 0) {

                    TSledContract oldContract = page.getPage().get(0);
                    TSledContract updateContract = new TSledContract();
                    updateContract.setSledContractId(oldContract.getSledContractId());
                    updateContract.setContractExpDate(tSledContract.getContractExpDate());
                    updateContract.setFirstNoticeDate(tSledContract.getFirstNoticeDate());
                    updateContract.setLastTradeDate(tSledContract.getLastTradeDate());
                    updateContract.setWorkingStatus(tSledContract.getWorkingStatus());
                    updateContract.setSubscribeXQQuote(1);
                    updateContract.setContractStatus(ContractStatus.NORMAL.getValue());

                    if (oldContract.getContractExpDate() != updateContract.getContractExpDate()
                            || oldContract.getFirstNoticeDate() != updateContract.getFirstNoticeDate()
                            || oldContract.getLastTradeDate() != updateContract.getLastTradeDate()
                            || oldContract.getWorkingStatus() != updateContract.getWorkingStatus()
                            || oldContract.getSubscribeXQQuote() == 0) {
                        stub.updateTSledContract(updateContract);
                        AppLog.i("updateContract: " + updateContract);
                    }
                    continue;
                }

                tSledContract.setActiveStartTimestamp(start);
                tSledContract.setActiveEndTimestamp(end);
                tSledContract.setTechPlatformEnv(env.getValue());

                ReqTSledCommodityOption reqSledCommodityOption = new ReqTSledCommodityOption();
                reqSledCommodityOption.addToSledCommodityIds(sledCommodity.getSledCommodityId());
                TCommodityPage tSledCommodity = stub.reqTSledCommodity(reqSledCommodityOption, 0, 1);
                String sledContractCnName = tSledCommodity.getPage().get(0).getCnName() + "-" + tSledContract.getSledContractCode();
                tSledContract.setCnName(sledContractCnName);

                int sledContractId = stub.addTSledContract(tSledContract);
                AppLog.w("updateContract: " + tSledContract);
                if (sledContractId > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public void reqCtp() throws TException {

        BrokerDaoServiceStub stub = new BrokerDaoServiceStub();
        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.addToBrokerIds(workingAccount.getBrokerEntryId());
        option.addToEntryIds(workingAccount.getBrokerAccessId());
        BrokerAccessEntryPage page = stub.reqBrokerAccessEntry(option, 0, 1);
        if (page.getPageSize() > 0) {
            BrokerAccessEntry entry = page.getPage().get(0);

            //workingAccount.setAccountProperties(entry.getCustomInfoMap());
            for (Map.Entry<String, String> keyValue : entry.getCustomInfoMap().entrySet())
                workingAccount.putToAccountProperties(keyValue.getKey(), keyValue.getValue());

            AppLog.i("workingAccount: " + workingAccount);
            CtpAccount account = new CtpAccount();
            account.setAppId(workingAccount.getAccountProperties().get("APPID"));
            account.setAuthCode(workingAccount.getAccountProperties().get("CER"));
            account.setBrokerId(workingAccount.getAccountProperties().get("BROKER_ID_INFO"));
            account.setPassword(workingAccount.getAccountpwd());
            account.setUserId(workingAccount.getAccountName());
            account.setHost(workingAccount.getIpAddress() + ":" + workingAccount.getPort());
            account.print();
            ctpTradeApi = new CtpTradeApi(account);
            int waiting = 0;
            do {
                AppLog.d("refresh ctpInstruments");
                System.out.println("refresh ctpInstruments");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waiting++;
            } while (!ctpTradeApi.isRefresh && waiting < 60);

            ctpInstruments = ctpTradeApi.reqInstrumentList(null);
            AppLog.d("ctpInstruments: " + ctpInstruments.size());
            System.out.println("ctpInstruments: " + ctpInstruments.size());
            products = ctpTradeApi.reqProducts(null);
            System.out.println("products: " + products.size());
            AppLog.d("products: " + products);
            TechPlatformCommodityUpdate.refreshCtpTechPlatformCommodity(products);
        }
    }

    private void setDateTimes(CtpInstrument ctpInstrument, TSledContract tSledContract) {
//        AppLog.i("set dates: " + tSledContract);
//        AppLog.i("set dates: " + ctpInstrument);

        long lastDay = pasreDate(ctpInstrument.getExpireDate());
        if (tSledContract.getContractExpDate() == 0) {
            tSledContract.setContractExpDate(lastDay + 24 * 60 * 60);
        }
        if (tSledContract.getLastTradeDate() == 0)
            tSledContract.setLastTradeDate(pasreDate(ctpInstrument.getExpireDate()));
        if (tSledContract.getFirstNoticeDate() == 0)
            tSledContract.setFirstNoticeDate(pasreDate(ctpInstrument.getCreateDate()));
//        AppLog.i("set dates: " + tSledContract);
    }

    private static PlatformCommodity map2PlatformCommodity(String exchange, String commodityType, String commodityCode) {
        PlatformCommodity platformCommodity = new PlatformCommodity();
        platformCommodity.setExchange(exchange);
        platformCommodity.setCommodityType(commodityType);
        platformCommodity.setCommodityCode(commodityCode);
        return platformCommodity;
    }

    private static long pasreDate(String source) {

        try {
            Date date = dateFormat.parse(source);
            return date.getTime() / 1000;
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        return 0;
    }

    public static TSledContract getSledContract(PlatformCommodity platformCommodity,
                                                String platformContractCode,
                                                TechPlatformEnv techPlatformEnv,
                                                TechPlatform techPlatform,
                                                SledCommodity sledCommodity, String otherPlatformContractCode) throws TException {

        TSledContract tSledContract = new TSledContract();
        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        if (TechPlatform.CTP.equals(techPlatform))
            args.setTechPlatform_(com.longsheng.xueqiao.contractconvertor.swig.TechPlatform.TechPlatform_CTP);
        if (TechPlatform.ESUNNY_3.equals(techPlatform))
            args.setTechPlatform_(com.longsheng.xueqiao.contractconvertor.swig.TechPlatform.TechPlatform_ESUNNY_3);
        if (TechPlatform.ESUNNY.equals(techPlatform)) {
            args.setTechPlatform_(com.longsheng.xueqiao.contractconvertor.swig.TechPlatform.TechPlatform_ESUNNY);
        }
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_(platformCommodity.getExchange());
        commonContract.setTechPlatform_CommodityType_(platformCommodity.getCommodityType());
        commonContract.setTechPlatform_CommodityCode_(platformCommodity.getCommodityCode());
        commonContract.setTechPlatform_ContractCode_(platformContractCode);

        AppLog.d(platformCommodity.getExchange());
        AppLog.d(platformCommodity.getCommodityType());
        AppLog.d(platformCommodity.getCommodityCode());
        AppLog.d(platformContractCode);

        args.setCommonContract_(commonContract);


        if (otherPlatformContractCode != null) {
            CommonContract otherContract = new CommonContract();
            otherContract.setTechPlatform_Exchange_(platformCommodity.getExchange());
            otherContract.setTechPlatform_CommodityType_(platformCommodity.getCommodityType());
            otherContract.setTechPlatform_CommodityCode_(platformCommodity.getCommodityCode());
            otherContract.setTechPlatform_ContractCode_(otherPlatformContractCode);

            AppLog.d(otherPlatformContractCode);
            args.setOtherCommonContract_(otherContract);
        }

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);
        if (result == null) {
            AppLog.d("result null");
            return null;
        }
        AppLog.d("result.getMixContract().getSledContractCode(): " + result.getMixContract_().getSledContractCode_());
        tSledContract.setSledContractCode(result.getMixContract_().getSledContractCode_());

        AppLog.d("getRelateMixContractCount: " + result.getRelateMixContractCount_());
        if (result.getRelateMixContractCount_() == 0) {
            return tSledContract;
        }
        List<TSledContract> relateContracts = getRelateContractIds(result, techPlatformEnv, sledCommodity);
        if (relateContracts == null) return null;
        if (relateContracts.size() > 0) {
            long expiredDate = 0;
            long lastTradeDate = 0;
            long firstNoticeDate = 0;

            for (TSledContract t : relateContracts) {
                tSledContract.addToRelateContractIds(t.getSledContractId());
                expiredDate = expiredDate == 0 ? t.getContractExpDate() : Math.min(expiredDate, t.getContractExpDate());
                lastTradeDate = lastTradeDate == 0 ? t.getLastTradeDate() : Math.min(lastTradeDate, t.getLastTradeDate());
                firstNoticeDate = firstNoticeDate == 0 ? t.getFirstNoticeDate() : Math.max(firstNoticeDate, t.getFirstNoticeDate());
            }
            tSledContract.setContractExpDate(expiredDate);
            tSledContract.setLastTradeDate(lastTradeDate);
            tSledContract.setFirstNoticeDate(firstNoticeDate);
        }
        return tSledContract;
    }

    private static List<TSledContract> getRelateContractIds(TechPlatformContractToSledResult result, TechPlatformEnv env, SledCommodity sledCommodity) throws TException {
        List<TSledContract> relateContracts = new ArrayList<>();

        ContractServiceStub stub = new ContractServiceStub();

        ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();
        reqSledCommodityOption.addToSledCommodityIdList(sledCommodity.getSledCommodityId());
        SledCommodityEditPage commodityEditPage = stub.reqSledCommodity(reqSledCommodityOption, 0, 1);
        if (commodityEditPage.getPageSize() == 0) {
            return null;
        }
        List<Integer> relateSledCommodityIds = commodityEditPage.getPage().get(0).getSledCommodity().getRelateCommodityIds();
        if (relateSledCommodityIds.size() < 2) {
            return null;
        }

        for (int i = 0; i < result.getRelateMixContractCount_(); i++) {
            AppLog.d("result.getRelateMixContract_(i).getTechPlatform_CommodityCode_(): " + result.getRelateMixContract_(i).getTechPlatform_CommodityCode_());
            AppLog.d("result.getRelateMixContract_(i).getSledContractCode_(): " + result.getRelateMixContract_(i).getSledContractCode_());

            ReqTSledContractOption option = new ReqTSledContractOption();
            option.setTechPlatformEnv(env.getValue());
            option.setSledCommodityId(relateSledCommodityIds.get(i));
            option.setSledContractCode(result.getRelateMixContract_(i).getSledContractCode_());
            TSledContractPage page = new ContractDaoServiceStub().reqTSledContract(option, 0, 1);
            if (page.getTotal() == 0) {
                return null;
            }
            relateContracts.add(page.getPage().get(0));
        }
        return relateContracts;
    }

    public static SledCommodity getCommodity(PlatformCommodity platformCommodity, TechPlatform techPlatform) throws TException {

        TSledCommodity tCommodity = TCommodityMapCache.getInstance().getTSledCommodityId(techPlatform, platformCommodity.getExchange(), platformCommodity.getCommodityType(), platformCommodity.getCommodityCode());
        if (tCommodity == null) {
            return null;
        }

        SledCommodity sledCommodity = new SledCommodity();
        sledCommodity.setSledCommodityId(tCommodity.getSledCommodityId());
        sledCommodity.setExchangeMic(tCommodity.getExchangeMic());
        sledCommodity.setSledCommodityType(SledCommodityType.findByValue(tCommodity.getSledCommodityType()));
        sledCommodity.setSledCommodityCode(tCommodity.getSledCommodityCode());
        sledCommodity.setIsAlsoSupportSim(tCommodity.isIsAlsoSupportSim());
        return sledCommodity;
    }
}
