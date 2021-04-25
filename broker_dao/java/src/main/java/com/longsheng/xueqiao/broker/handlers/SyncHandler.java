package com.longsheng.xueqiao.broker.handlers;

import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.SyncBrokerOption;
import com.longsheng.xueqiao.broker.page.Page;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessStatus;
import com.longsheng.xueqiao.broker.thriftapi.BrokerErrorCode;
import com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEditPage;
import com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMappingEditOption;
import com.longsheng.xueqiao.contract.thriftapi.SyncContractOption;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;

public class SyncHandler {
    private TServiceCntl oCntl;

    public SyncHandler(TServiceCntl oCntl) {
        this.oCntl = oCntl;
    }

    public void sync(SyncBrokerOption syncBrokerOption) throws TException {
        if (!syncBrokerOption.isSetUserName() || "".equals(syncBrokerOption.getUserName())) {
            throw new IllegalArgumentException("SyncBrokerOption user name must set.");
        }

        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.setAccessStatus(BrokerAccessStatus.VERIFIED_CORRECT);
        BrokerAccessHandler handler = new BrokerAccessHandler(oCntl);
        Page<BrokerAccessEntry> page = handler.query(option, 0, Integer.MAX_VALUE);
        boolean syncContract = false;
        for (BrokerAccessEntry brokerAccessEntry : page.getPage()) {
            if (needSyncContract(brokerAccessEntry)) {
                syncContract = true;
            }
        }

        if (syncContract) {
            new ContractServiceStub().syncContract(0, 10000, new SyncContractOption().setUserName(syncBrokerOption.getUserName()));
        } else {
            new ContractServiceStub().removeDbLocking(syncBrokerOption.getUserName());
        }
        for (BrokerAccessEntry brokerAccessEntry : page.getPage()) {
            new ZookeeperHandler().sync2Zookeeper(brokerAccessEntry, handler);
        }
    }

    private boolean needSyncContract(BrokerAccessEntry brokerAccessEntry) throws TException {
        if (BrokerPlatform.ESUNNY_3.equals(brokerAccessEntry.getPlatform())) {
            int brokerEntryId = brokerAccessEntry.getBrokerId();
            ContractServiceStub stub = new ContractServiceStub();
//            checkCommodityMappingExist(brokerEntryId, stub);
//            return true;
        }
        return false;
    }

    private void checkCommodityMappingExist(int brokerEntryId, ContractServiceStub stub) throws TException {
        ReqCommodityMappingEditOption reqMappingOption = new ReqCommodityMappingEditOption();
        reqMappingOption.setBrokerEntryId(brokerEntryId);
        reqMappingOption.setTechPlatform(TechPlatform.ESUNNY_3);
        CommodityMappingEditPage mappingPage = stub.reqCommodityMapping(reqMappingOption, 0, 1);
        if (mappingPage.getTotal() == 0) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_MAPPING_FILE_MUST_SET.getValue(), "Esunny 3.0 Commodity mapping not found.");
        }
    }
}
