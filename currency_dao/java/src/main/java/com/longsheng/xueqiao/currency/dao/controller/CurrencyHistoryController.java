package com.longsheng.xueqiao.currency.dao.controller;

import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.xueqiao.currency.dao.handler.SledCurrencyHandler;
import com.longsheng.xueqiao.currency.dao.handler.SledExchangeRateHandler;
import com.longsheng.xueqiao.currency.dao.handler.SledExchangeRateHistoryHandler;
import com.longsheng.xueqiao.currency.thriftapi.Currency;
import com.longsheng.xueqiao.currency.thriftapi.CurrencyPage;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRate;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRateHistory;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRateHistoryPage;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage;
import com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption;
import com.longsheng.xueqiao.currency.thriftapi.ReqHistoryOption;
import org.apache.thrift.TBase;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.util.ProtocolUtil;
import org.soldier.platform.zookeeper.IConfProvider;
import org.soldier.platform.zookeeper.ZooKeeperManager;
import org.soldier.platform.zookeeper.ZooKeeperManagerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyHistoryController {

    // TODO 分配一个 manager key
    private final static String ZOO_KEEPER_MANAGER_KEY = "xueqiao_broker";
    private final static String CURRENCY_PATH = "/xueqiao/currency";
    private final static String SLED_EXCHANGE_RATE_NODE = "exchange_rate";
    private final static String SLED_CURRENCY_NODE = "sled_currency";

    public void syncHistory(String roleName, String serviceName) throws ErrorInfo {

        new DBTransactionHelper<Void>(new DalSetDataSource(roleName, serviceName, false, 0)) {


            List<ExchangeRateHistory> histories = new ArrayList<>();
            CurrencyPage currencyPage;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {

                SledCurrencyHandler sledCurrencyHandler = new SledCurrencyHandler(getConnection());
                SledExchangeRateHandler sledExchangeRateHandler = new SledExchangeRateHandler(getConnection());
                currencyPage = sledCurrencyHandler.query(null, null);

                for (Currency currency : currencyPage.getPage()) {
                    if (currency.isIsBaseCurrency()) {
                        ReqExchangeRateOption exchangeRateOption = new ReqExchangeRateOption();
                        ExchangeRatePage exchangeRatePage = sledExchangeRateHandler.query(exchangeRateOption, null);
                        if (exchangeRatePage.getPageSize() > 0) {
                            Map<String, Double> exchagneRateMap = new HashMap<>();
                            for (ExchangeRate rate : exchangeRatePage.getPage()) {
                                exchagneRateMap.put(rate.getTargetCurrency(), rate.getExchangeRate());
                            }
                            ExchangeRateHistory history = new ExchangeRateHistory();
                            history.setExchangeRate(exchagneRateMap);
                            history.setCurrencyCode(currency.getCurrencyCode());
                            histories.add(history);
                        }
                    }
                }
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                SledExchangeRateHistoryHandler sledExchangeRateHistoryHandler = new SledExchangeRateHistoryHandler(getConnection(), roleName);
                long historyId = sledExchangeRateHistoryHandler.batAdd(histories);

                for (Currency currency : currencyPage.getPage()) {
                    if (currency.isIsBaseCurrency()) {
                        ReqHistoryOption option = new ReqHistoryOption();
                        option.setHistoryId(historyId);
                        option.setCurrency(currency.getCurrencyCode());
                        IndexedPageOption pageOption = new IndexedPageOption();
                        pageOption.setNeedTotalCount(true);
                        ExchangeRateHistoryPage page = sledExchangeRateHistoryHandler.query(option, pageOption);
                        String path = CURRENCY_PATH + "/" + currency.getCurrencyCode();
                        save2ZooKeeper(page, path, SLED_EXCHANGE_RATE_NODE);
                    }
                }

                save2ZooKeeper(currencyPage, CURRENCY_PATH, SLED_CURRENCY_NODE);
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();
    }


    private ZooKeeperManager getZooKeeperManager() throws IConfProvider.ConfException, IOException {
        try {
            return ZooKeeperManagerFactory.Global().get(ZOO_KEEPER_MANAGER_KEY);
        } catch (Throwable e) {
            AppLog.d(e.getMessage(), e);
            throw e;
        }
    }

    private void save2ZooKeeper(TBase tObject, String path, String nodeName) throws ErrorInfo {
        byte[] data = ProtocolUtil.serialize2Bytes(JsonFactory.getInstance().getFactory(), tObject);
        try {
            createNodeIfNeed(path);
            String fullPath = path + "/" + nodeName;
            saveData(data, fullPath);
        } catch (Exception e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "ZooKeeper sync fail.");
        }
    }

    private void saveData(byte[] data, String path) throws IConfProvider.ConfException, IOException, KeeperException, InterruptedException {
        ZooKeeperManager manager = getZooKeeperManager();
        Stat stat = manager.getZooKeeper().exists(path, false);
        AppLog.i("path: " + path);
        if (stat == null) {
            AppLog.i("add: " + path);
            manager.getZooKeeper().create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } else {
            int version = -1;
            AppLog.i("update: " + path);
            manager.getZooKeeper().setData(path, data, version);
        }
    }

    private void createNodeIfNeed(String path) throws IConfProvider.ConfException, IOException, KeeperException, InterruptedException {
        ZooKeeperManager manager = getZooKeeperManager();
        Stat brokerStat = manager.getZooKeeper().exists(path, false);
        if (brokerStat == null) {
            manager.getZooKeeper().create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }
}
