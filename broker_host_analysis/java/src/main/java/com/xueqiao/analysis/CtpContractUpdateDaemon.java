package com.xueqiao.analysis;

import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.broker.thriftapi.AccessAddress;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform;
import com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv;
import com.xueqiao.ctp_service.core.trade.CtpAccount;
import com.xueqiao.ctp_service.core.trade.CtpTradeApi;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CtpContractUpdateDaemon {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    private CtpTradeApi ctpTradeApi;

    public CtpContractUpdateDaemon() {

    }

    public void run() throws TException {
        reqCtp();
    }

    public void reqCtp() throws TException {

        BrokerDaoServiceStub stub = new BrokerDaoServiceStub();
        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.setEnv(TechPlatformEnv.REAL);
        option.setPlatform(BrokerPlatform.CTP);
        BrokerAccessEntryPage page = stub.reqBrokerAccessEntry(option, 0, Integer.MAX_VALUE);
        String prefix = "tcp://";
        if (page.getPageSize() > 0) {
            for (BrokerAccessEntry accessEntry : page.getPage()) {
                AppLog.i("accessEntry: " + accessEntry);
                for (AccessAddress address : accessEntry.getTradeAddresses()) {
                    CtpAccount account = new CtpAccount();
                    account.setBrokerId(accessEntry.getCustomInfoMap().get("BROKER_ID_INFO"));
                    String host = address.getAddress() + ":" + address.getPort();
                    if (!host.startsWith(prefix)) {
                        host = prefix + host;
                    }

                    account.setHost(host);
                    account.setBrokerAccessName(accessEntry.getAccessName());
                    account.setBrokerEntryId(accessEntry.getBrokerId());
                    ctpTradeApi = new CtpTradeApi(account);
                    ctpTradeApi.start();
                }
            }
        }
    }
}
