package com.longsheng.xueqiao.broker.dao.thriftapi.server.impl;


import java.util.*;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.broker.config.ConfigurationProperty;
import com.longsheng.xueqiao.broker.dao.thriftapi.*;
import com.longsheng.xueqiao.broker.handlers.BrokerAccessHandler;
import com.longsheng.xueqiao.broker.handlers.BrokerHandler;
import com.longsheng.xueqiao.broker.handlers.SyncHandler;
import com.longsheng.xueqiao.broker.handlers.ZookeeperHandler;
import com.longsheng.xueqiao.broker.page.Page;
import com.longsheng.xueqiao.broker.thriftapi.*;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEditPage;
import com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMappingEditOption;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.dal_set.DalSetProxy;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import com.longsheng.xueqiao.broker.dao.thriftapi.server.BrokerDaoServiceAdaptor;

public class BrokerDaoServiceHandler extends BrokerDaoServiceAdaptor {
    @Override
    public int InitApp(Properties props) {
        try {
            DalSetProxy.getInstance().loadFromXml();
        } catch (Exception e) {
            AppLog.e("DAL init fail.", e);
            e.printStackTrace();
            return -1;
        }
        try {
            ConfigurationProperty.instance().init(props);
        } catch (Exception e) {
            e.printStackTrace();
            AppLog.e("Config init fail.", e);
            return -1;
        }
        AppLog.e("======= SERVICE START =======");
        return 0;
    }

    @Override
    protected int addBrokerEntry(TServiceCntl oCntl, BrokerEntry brokerEntry) throws ErrorInfo, TException {
        BrokerHandler handler = new BrokerHandler(oCntl);
        if (brokerEntry.isSetBrokerId()) {
            brokerEntry.setBrokerId(0);
        }
        checkInput(brokerEntry, handler);
        int brokerId = handler.insert(brokerEntry);
        reSetBrokerFlags(oCntl, brokerId);
        return brokerId;
    }

    private void checkInput(BrokerEntry brokerEntry, BrokerHandler handler) throws ErrorInfo {
        ReqBrokerEntryOption option = new ReqBrokerEntryOption();
        if (brokerEntry.isSetCnName()) {
            option.setCnNameWhole(brokerEntry.getCnName());
        }
        Page<BrokerEntry> page = handler.query(option, 0, 1);
        if (page.getTotal() > 0) {
            BrokerEntry entry = page.getPage().get(0);
            if (entry.getBrokerId() != brokerEntry.getBrokerId()) {
                throw new ErrorInfo(BrokerErrorCode.BROKER_CN_NAME_EXIST.getValue(), "cn name exist.");
            }
        }

        if (brokerEntry.isSetEngName()) {
            option.clear();
            option.setEngNameWhole(brokerEntry.getEngName());
        }
        Page<BrokerEntry> engPage = handler.query(option, 0, 1);
        if (engPage.getTotal() > 0) {
            BrokerEntry entry = engPage.getPage().get(0);
            if (entry.getBrokerId() != brokerEntry.getBrokerId()) {
                throw new ErrorInfo(BrokerErrorCode.BROKER_ENG_NAME_EXIST.getValue(), "eng name exist.");
            }
        }
    }

    @Override
    protected void updateBrokerEntry(TServiceCntl oCntl, BrokerEntry brokerEntry) throws ErrorInfo, TException {
        BrokerHandler handler = new BrokerHandler(oCntl);
        ReqBrokerEntryOption option = new ReqBrokerEntryOption();
        option.addToBrokerIds(brokerEntry.getBrokerId());
        Page<BrokerEntry> page = handler.query(option, 0, 1);
        if (page.getTotal() == 0) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_NOT_FOUND.getValue(), "Broker not found.");
        }

        checkInput(brokerEntry, handler);
        handler.update(brokerEntry);
        reSetBrokerFlags(oCntl, brokerEntry.getBrokerId());
    }

    @Override
    protected BrokerEntryPage reqBrokerEntry(TServiceCntl oCntl, ReqBrokerEntryOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        Page<BrokerEntry> page = new BrokerHandler(oCntl).query(option, pageIndex, pageSize);
        return new BrokerEntryPage().setTotal(page.getTotal()).setPage(page.getPage());

    }

    @Override
    protected int addBrokerAccessEntry(TServiceCntl oCntl, BrokerAccessEntry brokerAccessEntry) throws ErrorInfo, TException {

        if (!brokerAccessEntry.isSetBrokerId() || !brokerAccessEntry.isSetPlatform()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "BrokerAccessEntry BrokerId and Platform must set.");
        }
        BrokerAccessHandler handler = new BrokerAccessHandler(oCntl);

        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.addToBrokerIds(brokerAccessEntry.getBrokerId());
        option.setPlatform(brokerAccessEntry.getPlatform());
        option.setAccessName(brokerAccessEntry.isSetAccessName() ? brokerAccessEntry.getAccessName() : "");
        Page<BrokerAccessEntry> page = handler.query(option, 0, 1);
        if (page.getTotal() > 0) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_EXIST.getValue(), "Broker access exist.");
        }

        BrokerHandler brokerHandler = new BrokerHandler(oCntl);
        ReqBrokerEntryOption reqEntryOption = new ReqBrokerEntryOption();
        reqEntryOption.addToBrokerIds(brokerAccessEntry.getBrokerId());
        Page<BrokerEntry> brokerPage = brokerHandler.query(reqEntryOption, 0, 1);
        BrokerEntry entry = brokerPage.getPage().get(0);
        if (!entry.getTechPlatforms().contains(brokerAccessEntry.getPlatform())) {
            BrokerEntry brokerEntry = new BrokerEntry();
            brokerEntry.setBrokerId(entry.getBrokerId());
            brokerEntry.setTechPlatforms(entry.getTechPlatforms()).addToTechPlatforms(brokerAccessEntry.getPlatform());
            brokerHandler.update(brokerEntry);
        }
        int accessEntryId = handler.insert(brokerAccessEntry);
        reSetBrokerFlags(oCntl, brokerAccessEntry.getBrokerId());
        return accessEntryId;
    }

    @Override
    protected void updateBrokerAccessEntry(TServiceCntl oCntl, BrokerAccessEntry brokerAccessEntry) throws ErrorInfo, TException {
        BrokerAccessHandler handler = new BrokerAccessHandler(oCntl);
        checkUpdateEntry(brokerAccessEntry, handler);
        if (brokerAccessEntry.getStatus() != BrokerAccessStatus.VERIFIED_CORRECT) {
            brokerAccessEntry.setStatus(BrokerAccessStatus.EDIT);
        }
        handler.update(brokerAccessEntry);

        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.addToEntryIds(brokerAccessEntry.getEntryId());
        Page<BrokerAccessEntry> page = handler.query(option, 0, 1);
        if (page.getTotal() > 0) {
            brokerAccessEntry = page.getPage().get(0);
            if (brokerAccessEntry.getPlatform().equals(BrokerPlatform.ESUNNY_3)) {
                if (brokerAccessEntry.getStatus() != BrokerAccessStatus.VERIFIED_CORRECT) {
                    new ZookeeperHandler().removeSyncMappingTable(brokerAccessEntry);
                } else {
                    new ZookeeperHandler().addSyncMappingTable(brokerAccessEntry);
                }
            }
            reSetBrokerFlags(oCntl, brokerAccessEntry.getBrokerId());
        }
    }

    private void checkUpdateEntry(BrokerAccessEntry brokerAccessEntry, BrokerAccessHandler handler) throws ErrorInfo {
        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.addToEntryIds(brokerAccessEntry.getEntryId());
        Page<BrokerAccessEntry> page = handler.query(option, 0, 1);
        if (page.getTotal() == 0) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_NOT_FOUND.getValue(), "Broker access not found.");
        }

        BrokerAccessEntry oldEntry = page.getPage().get(0);

        if (brokerAccessEntry.isSetBrokerId() && brokerAccessEntry.getBrokerId() != oldEntry.getBrokerId()) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_BROKERID_NO_CHANGE.getValue(), BrokerErrorCode.BROKER_ACCESS_BROKERID_NO_CHANGE.name());
        }

        if (brokerAccessEntry.isSetPlatform() && brokerAccessEntry.getPlatform() != oldEntry.getPlatform()) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_PLATFORM_NO_CHANGE.getValue(), BrokerErrorCode.BROKER_ACCESS_PLATFORM_NO_CHANGE.name());
        }
        if (brokerAccessEntry.getWorkingStatus() == BrokerAccessWorkingStatus.WORKING) {
            if (brokerAccessEntry.getTechPlatformEnv() != oldEntry.getTechPlatformEnv()) {
                throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_PLATFORM_ENV_NO_CHANGE.getValue(), BrokerErrorCode.BROKER_ACCESS_PLATFORM_ENV_NO_CHANGE.name());
            }
            if (brokerAccessEntry.getCustomInfoMapSize() > 0) {
                Map<String, String> map = brokerAccessEntry.getCustomInfoMap();
                Map<String, String> oldMap = oldEntry.getCustomInfoMap();
//                compareMap(map, oldMap);
//                compareMap(oldMap, map);
            }
        }
    }

    private void compareMap(Map<String, String> map, Map<String, String> oldMap) throws ErrorInfo {

        for (String s : map.keySet()) {
            if (!oldMap.containsKey(s) || !map.get(s).equals(oldMap.get(s))) {
                throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_CUSTOM_INFO_NO_CHANGE.getValue(), BrokerErrorCode.BROKER_ACCESS_CUSTOM_INFO_NO_CHANGE.name());
            }
        }
    }

    @Override
    protected BrokerAccessEntryPage reqBrokerAccessEntry(TServiceCntl oCntl, ReqBrokerAccessEntryOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        Page<BrokerAccessEntry> page = new BrokerAccessHandler(oCntl).query(option, pageIndex, pageSize);
        return new BrokerAccessEntryPage().setTotal(page.getTotal()).setPage(page.getPage());
    }

    @Override
    protected WorkingBrokerAccessEntryResp reqWorkingBrokerAccessEntry(TServiceCntl oCntl, int brokerAccessEntryId) throws ErrorInfo, TException {

        BrokerAccessHandler handler = new BrokerAccessHandler(oCntl);
        return new ZookeeperHandler().reqWorkingBrokerAccessEntry(brokerAccessEntryId, handler);
    }

    @Override
    protected WorkingBrokerAccessEntryResp syncBrokerAccessEntry(TServiceCntl oCntl, int brokerAccessEntryId) throws ErrorInfo, TException {

        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.addToEntryIds(brokerAccessEntryId);
        BrokerAccessHandler handler = new BrokerAccessHandler(oCntl);
        Page<BrokerAccessEntry> page = handler.query(option, 0, 1);
        WorkingBrokerAccessEntryResp resp = new WorkingBrokerAccessEntryResp();
        if (page.getTotal() > 0) {
            BrokerAccessEntry brokerAccessEntry = page.getPage().get(0);
            checkEsunny3(brokerAccessEntry);
            BrokerAccessEntry entry = new ZookeeperHandler().updateToZookeeper(brokerAccessEntry, handler);
            resp.setEntry(entry);
            resp.setWorking(true);
            return resp;
        } else {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_NOT_FOUND.getValue(), BrokerErrorCode.BROKER_ACCESS_NOT_FOUND.name());
        }
    }

    private void checkEsunny3(BrokerAccessEntry brokerAccessEntry) throws TException {
        if (BrokerPlatform.ESUNNY_3.equals(brokerAccessEntry.getPlatform())) {
            int brokerEntryId = brokerAccessEntry.getBrokerId();
            ContractServiceStub stub = new ContractServiceStub();
            checkCommodityMappingExist(brokerEntryId, stub);
            checkContractSync(stub);
        }
    }

    private void checkContractSync(ContractServiceStub stub) throws TException {
        DbLockingInfo dbLockingInfo = stub.reqDbLockingInfo();
        if (dbLockingInfo.isIsLocked()) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_MAPPING_FILE_MUST_SET.getValue(), "Sync contract first.");
        }
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

    @Override
    protected RemoveBrokerAccessEntryResp removeBrokerAccessEntry(TServiceCntl oCntl, int entryId) throws ErrorInfo, TException {
        BrokerAccessHandler handler = new BrokerAccessHandler(oCntl);
        RemoveBrokerAccessEntryResp resp = new RemoveBrokerAccessEntryResp();
        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.addToEntryIds(entryId);
        Page<BrokerAccessEntry> page = handler.query(option, 0, 1);
        if (page.getTotal() == 0) {
            resp.setSuccess(false);
            return resp;
        }

        BrokerAccessEntry brokerAccessEntry = page.getPage().get(0);
        if (brokerAccessEntry.getWorkingStatus() == BrokerAccessWorkingStatus.WORKING) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_WORKING.getValue(), BrokerErrorCode.BROKER_ACCESS_WORKING.name());
        }

        brokerAccessEntry.getBrokerId();

        handler.removeBrokerAccessEntry(entryId);
        reSetBrokerFlags(oCntl, brokerAccessEntry.getBrokerId());

        resp.setSuccess(true);
        return resp;
    }

    private void reSetBrokerFlags(TServiceCntl oCntl, int brokerId) throws ErrorInfo {
        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.addToBrokerIds(brokerId);
        Page<BrokerAccessEntry> newPage = new BrokerAccessHandler(oCntl).query(option, 0, Integer.MAX_VALUE);
        Set<BrokerPlatform> platforms = new HashSet<>();
        Set<TechPlatformEnv> envs = new HashSet<>();
        for (BrokerAccessEntry entry : newPage.getPage()) {
            if (entry.getPlatform() != BrokerPlatform.NONE) {
                platforms.add(entry.getPlatform());
            }
            if (entry.getTechPlatformEnv() != TechPlatformEnv.NONE) {
                envs.add(entry.getTechPlatformEnv());
            }
        }
        BrokerEntry brokerEntry = new BrokerEntry();
        brokerEntry.setBrokerId(brokerId);
        List<BrokerPlatform> brokerPlatforms = new ArrayList<>();
        brokerPlatforms.addAll(platforms);
        brokerEntry.setTechPlatforms(brokerPlatforms);
        List<TechPlatformEnv> techPlatformEnvs = new ArrayList<>();
        techPlatformEnvs.addAll(envs);
        brokerEntry.setTechPlatformEnvs(techPlatformEnvs);
        new BrokerHandler(oCntl).update(brokerEntry);
    }

    @Override
    protected RemoveBrokerEntryResp removeBrokerEntry(TServiceCntl oCntl, int brokerEntryId) throws ErrorInfo, TException {
        BrokerHandler handler = new BrokerHandler(oCntl);
        RemoveBrokerEntryResp resp = new RemoveBrokerEntryResp();
        ReqBrokerEntryOption option = new ReqBrokerEntryOption();
        option.addToBrokerIds(brokerEntryId);
        Page<BrokerEntry> page = handler.query(option, 0, 1);
        if (page.getTotal() == 0) {
            resp.setSuccess(false);
            return resp;
        }

        BrokerAccessHandler accessHandler = new BrokerAccessHandler(oCntl);
        ReqBrokerAccessEntryOption accessOption = new ReqBrokerAccessEntryOption();
        accessOption.addToBrokerIds(brokerEntryId);
        Page<BrokerAccessEntry> accessPage = accessHandler.query(accessOption, 0, 1);
        if (accessPage.getTotal() > 0) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_EXIST.getValue(), "Can not remove the broker, broker access exists.");
        }

        handler.removeBrokerEntry(brokerEntryId);
        resp.setSuccess(true);
        return resp;
    }

    @Override
    protected SyncBrokerResp syncBroker(TServiceCntl oCntl, SyncBrokerOption option) throws ErrorInfo, TException {
        new SyncHandler(oCntl).sync(option);
        return new SyncBrokerResp().setSuccess(true);
    }

    @Override
    public void destroy() {
    }
}
