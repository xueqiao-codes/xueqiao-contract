package com.longsheng.xueqiao.contract.dao.thriftapi.server.impl;


import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.xueqiao.contract.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.contract.dao.handlers.*;
import com.longsheng.xueqiao.contract.dao.provider.DalSetConnectionProvider;
import com.longsheng.xueqiao.contract.dao.thriftapi.*;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.dal_set.DalSetProxy;
import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import com.longsheng.xueqiao.contract.dao.thriftapi.server.ContractDaoServiceAdaptor;

public class ContractDaoServiceHandler extends ContractDaoServiceAdaptor {
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
    protected int addTSledCommodity(TServiceCntl oCntl, TSledCommodity tSledCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(tSledCommodity, "tSledCommodity");
        return new SledCommodityHandler(
                getProvider(oCntl)).insert(tSledCommodity);
    }

    @Override
    protected int updateTSledCommodity(TServiceCntl oCntl, TSledCommodity tSledCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(tSledCommodity, "tSledCommodity");
        return new SledCommodityHandler(
                getProvider(oCntl)).update(tSledCommodity);
    }

    @Override
    protected TCommodityPage reqTSledCommodity(TServiceCntl oCntl, ReqTSledCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new SledCommodityHandler(
                getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected int addTSledContract(TServiceCntl oCntl, TSledContract tSledContract) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(tSledContract, "tSledContract");
        return new SledContractHandler(
                getProvider(oCntl)).insert(tSledContract);
    }

    @Override
    protected int updateTSledContract(TServiceCntl oCntl, TSledContract tSledContract) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(tSledContract, "tSledContract");
        return new SledContractHandler(
                getProvider(oCntl)).update(tSledContract);
    }

    @Override
    protected TSledContractPage reqTSledContract(TServiceCntl oCntl, ReqTSledContractOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new SledContractHandler(
                getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected int addTSledExchange(TServiceCntl oCntl, TSledExchange tSledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(tSledExchange, "tSledExchange");
        return new SledExchangeHandler(
                getProvider(oCntl)).insert(tSledExchange);
    }

    @Override
    protected int updateTSledExchange(TServiceCntl oCntl, TSledExchange tSledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(tSledExchange, "tSledExchange");
        return new SledExchangeHandler(
                getProvider(oCntl)).update(tSledExchange);
    }

    @Override
    protected TSledExchangePage reqTSledExchange(TServiceCntl oCntl, ReqTSledExchangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new SledExchangeHandler(
                getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected TCommodityMapPage reqTCommodityMap(TServiceCntl oCntl, ReqTCommodityMapOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new CommodityMapHandler(
                getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected void addTCommodityMap(TServiceCntl oCntl, TCommodityMap tCommodityMap) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(tCommodityMap, "tCommodityMap");
        new CommodityMapHandler(
                getProvider(oCntl)).insert(tCommodityMap);
    }

    @Override
    protected void addSledExchangeMapping(TServiceCntl oCntl, SledExchangeMapping sledExchangeMapping) throws ErrorInfo, TException {
        new ExchangeMapHandler(getProvider(oCntl)).insert(sledExchangeMapping);
    }

    @Override
    protected void updateSledExchangeMapping(TServiceCntl oCntl, SledExchangeMapping sledExchangeMapping) throws ErrorInfo, TException {
        new ExchangeMapHandler(getProvider(oCntl)).update(sledExchangeMapping);
    }

    @Override
    protected SledExchangeMappingPage reqSledExchangeMapping(TServiceCntl oCntl, ReqSledExchangeMappingOption option) throws ErrorInfo, TException {
        return new ExchangeMapHandler(getProvider(oCntl)).query(option);
    }

    @Override
    protected void addSledCommodityTypeMapping(TServiceCntl oCntl, SledCommodityTypeMapping sledCommodityTypeMapping) throws ErrorInfo, TException {
        new CommodityTypeMapHandler(getProvider(oCntl)).insert(sledCommodityTypeMapping);
    }

    @Override
    protected void updateSledCommodityTypeMapping(TServiceCntl oCntl, SledCommodityTypeMapping sledCommodityTypeMapping) throws ErrorInfo, TException {
        new CommodityTypeMapHandler(getProvider(oCntl)).update(sledCommodityTypeMapping);
    }

    @Override
    protected SledCommodityTypeMappingPage reqSledCommodityTypeMapping(TServiceCntl oCntl, ReqSledCommodityTypeMappingOption option) throws ErrorInfo, TException {
        return new CommodityTypeMapHandler(getProvider(oCntl)).query(option);
    }

    @Override
    protected int updateTCommodityMap(TServiceCntl oCntl, TCommodityMap tCommodityMap) throws ErrorInfo, TException {
        checkNull(tCommodityMap, "tCommodityMap");
        return new CommodityMapHandler(
                getProvider(oCntl)).update(tCommodityMap);
    }

    @Override
    protected boolean inactiveExpiredSledContract(TServiceCntl oCntl, long expiredTimestamp) throws ErrorInfo, TException {
        return new SledContractHandler(
                getProvider(oCntl)).inactiveExpiredContract(expiredTimestamp);
    }

    @Override
    protected TSledCommodityChangePage reqTSledCommodityChange(TServiceCntl oCntl, ReqTSledCommodityChangeOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new SledCommodityChangeHandler(
                getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected int addTSledCommodityChange(TServiceCntl oCntl, TSledCommodityChange tCommodityChange) throws ErrorInfo, TException {
        checkNull(tCommodityChange, "tCommodityChange");
        return new SledCommodityChangeHandler(
                getProvider(oCntl)).insert(tCommodityChange);
    }

    @Override
    protected boolean removeTSledCommodityChange(TServiceCntl oCntl, TSledCommodityChange tCommodityChange) throws ErrorInfo, TException {
        checkNull(tCommodityChange, "tCommodityChange");
        return new SledCommodityChangeHandler(
                getProvider(oCntl)).remove(tCommodityChange.getSledCommodityId());
    }

    @Override
    protected void addCommodityMapFileInfo(TServiceCntl oCntl, CommodityMapFileInfo mapFileInfo) throws ErrorInfo, TException {
        checkNull(mapFileInfo, "mapFileInfo");
        new BrokerCommodityMappingFileHandler(
                getProvider(oCntl)).insert(mapFileInfo);
    }

    @Override
    protected void updateCommodityMapFileInfo(TServiceCntl oCntl, CommodityMapFileInfo mapFileInfo) throws ErrorInfo, TException {
        checkNull(mapFileInfo, "mapFileInfo");
        new BrokerCommodityMappingFileHandler(
                getProvider(oCntl)).update(mapFileInfo);
    }

    @Override
    protected CommodityMapFileInfoPage reqCommodityMapFileInfo(TServiceCntl oCntl, ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new BrokerCommodityMappingFileHandler(
                getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected SyncMappingTaskPage reqSyncMappingTask(TServiceCntl oCntl, ReqSyncMappingTaskOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new SyncMappingHandler(
                getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected void addSyncMappingTask(TServiceCntl oCntl, SyncMappingTask tTask) throws ErrorInfo, TException {
        checkNull(tTask, "tTask");
        new SyncMappingHandler(
                getProvider(oCntl)).insert(tTask);
    }

    @Override
    protected void removeSyncMappingTask(TServiceCntl oCntl, ReqSyncMappingTaskOption option) throws ErrorInfo, TException {
        checkNull(option, "option");
        new SyncMappingHandler(
                getProvider(oCntl)).setInActive(option);
    }

    @Override
    protected void addTechPlatformCommodity(TServiceCntl oCntl, TechPlatformCommodity techPlatformCommodity) throws ErrorInfo, TException {
        checkNull(techPlatformCommodity, "techPlatformCommodity");
        new PlatformCommodityHandler(
                getProvider(oCntl)).insert(techPlatformCommodity);
    }

    @Override
    protected TechPlatformCommodityPage reqTechPlatformCommodity(TServiceCntl oCntl, ReqTechPlatformCommodityOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new PlatformCommodityHandler(
                getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected void removeSledCommodity(TServiceCntl oCntl, RemoveSledCommodityOption removeOption) throws ErrorInfo, TException {
        checkNull(removeOption, "removeOption");
        new DeleteCommodityHandler(
                getProvider(oCntl)).deleteCommodityFullPackage(removeOption.getSledCommodityId(), removeOption.getBrokerEntryIds());
    }

    @Override
    protected void removeSledExchange(TServiceCntl oCntl, RemoveSledExchangeOption removeOption) throws ErrorInfo, TException {
        checkNull(removeOption, "removeOption");
        new SledExchangeHandler(
                getProvider(oCntl)).deleteExchange(removeOption.getSledExchangeId());
    }

    @Override
    protected void addContractVersion(TServiceCntl oCntl, ContractVersion contractVersion) throws ErrorInfo, TException {
        checkNull(contractVersion, "contractVersion");
        new ContractVersionHandler(
                getProvider(oCntl)).insert(contractVersion);
    }

    @Override
    protected void removeContractVersion(TServiceCntl oCntl, RemoveContractVersionOption removeOption) throws ErrorInfo, TException {
        checkNull(removeOption, "removeOption");
        new ContractVersionHandler(
                getProvider(oCntl)).remove(removeOption);
    }

    @Override
    protected ContractVersionPage reqContractVersion(TServiceCntl oCntl, ReqContractVersionOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new ContractVersionHandler(
                getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected void updateContractVersion(TServiceCntl oCntl, ContractVersion contractVersion) throws ErrorInfo, TException {
        checkNull(contractVersion, "contractVersion");
        new ContractVersionHandler(
                getProvider(oCntl)).update(contractVersion);
    }

    private DalSetConnectionProvider getProvider(TServiceCntl oCntl) {
        return new DalSetConnectionProvider(oCntl, ConfigurationProperty.instance().getRoleName());
    }

    @Override
    protected void addDbLocking(TServiceCntl oCntl, DbLockingInfo dbLockingInfo) throws ErrorInfo, TException {
        checkNull(dbLockingInfo, "dbLockingInfo");
        new DbLockingInfoHandler(
                getProvider(oCntl)).insert(dbLockingInfo);
    }

    @Override
    protected void removeDbLocking(TServiceCntl oCntl, String lockedBy) throws ErrorInfo, TException {
        checkNull(lockedBy, "lockedBy");
        new DbLockingInfoHandler(
                getProvider(oCntl)).remove(lockedBy);
    }

    @Override
    protected DbLockingInfo reqDbLockingInfo(TServiceCntl oCntl) throws ErrorInfo, TException {
        return new DbLockingInfoHandler(
                getProvider(oCntl)).query();
    }

    @Override
    protected void addSledTradeTimeConfig(TServiceCntl oCntl, SledTradeTimeConfig config) throws ErrorInfo, TException {
        checkNull(config, "config");
        new SledTradeTimeConfigHandler(getProvider(oCntl)).insert(config);
    }

    @Override
    protected void updateSledTradeTimeConfig(TServiceCntl oCntl, SledTradeTimeConfig config) throws ErrorInfo, TException {
        checkNull(config, "config");
        new SledTradeTimeConfigHandler(getProvider(oCntl)).update(config);
    }

    @Override
    protected SledTradeTimeConfigPage reqSledTradeTimeConfig(TServiceCntl oCntl, ReqSledTradeTimeConfigOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        for (int i = 0; i < 200; i++) {
            long timeSpanId = 0;
            try {
                timeSpanId = ConfigurationProperty.instance().getSledTradingSessionTimeSpanIdMaker().createId();
            } catch (IdException e) {
                AppLog.e(e.getMessage(), e);
                throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "TradingSessionTimeSpanIdMaker create id fail");
            }
            AppLog.i("time span id : " + i + " : " + timeSpanId);
        }
        return new SledTradeTimeConfigPage();
    }

    @Override
    protected void addSpecTradeTime(TServiceCntl oCntl, SpecTradeTime specTradeTime) throws ErrorInfo, TException {
        checkNull(specTradeTime, "specTradeTime");
        new SpecTradeTimeHandler(getProvider(oCntl)).insert(specTradeTime);
    }

    @Override
    protected void updateSpecTradeTime(TServiceCntl oCntl, SpecTradeTime specTradeTime) throws ErrorInfo, TException {
        checkNull(specTradeTime, "specTradeTime");
        new SpecTradeTimeHandler(getProvider(oCntl)).update(specTradeTime);
    }

    @Override
    protected SpecTradeTimePage reqSpecTradeTime(TServiceCntl oCntl, ReqSpecTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new SpecTradeTimeHandler(getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected SledCommoditySpecTradeTimePage reqSledCommoditySpecTradeTime(TServiceCntl oCntl, ReqCommoditySpecTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new SpecTradeTimeHandler(getProvider(oCntl)).querySledCommoditySpecTradeTime(option, pageIndex, pageSize);
    }

    @Override
    protected SledTradeTimePage reqSledTradeTime(TServiceCntl oCntl, ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new SledTradeTimeTmpHandler(getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected void batAddSledTradeTime(TServiceCntl oCntl, List<SledTradeTime> sledTradeTimes) throws ErrorInfo, TException {
        checkNull(sledTradeTimes, "sledTradeTimes");
        new SledTradeTimeTmpHandler(getProvider(oCntl)).batInsert(sledTradeTimes);
    }

    @Override
    protected void addDstTransferConfig(TServiceCntl oCntl, DstTransferConfig transferConfig) throws ErrorInfo, TException {
        checkNull(transferConfig, "transferConfig");
        new DstTransferConfigHandler(getProvider(oCntl)).insert(transferConfig);
    }

    @Override
    protected void updateDstTransferConfig(TServiceCntl oCntl, DstTransferConfig transferConfig) throws ErrorInfo, TException {
        checkNull(transferConfig, "transferConfig");
        new DstTransferConfigHandler(getProvider(oCntl)).update(transferConfig);
    }

    @Override
    protected DstTransferConfigPage reqDstTransferConfig(TServiceCntl oCntl, ReqDstTransferConfigOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new DstTransferConfigHandler(getProvider(oCntl)).query(option, pageIndex, pageSize);
    }

    @Override
    protected void removeSpecTradeTime(TServiceCntl oCntl, RemoveSpecTradeTimeOption removeOption) throws ErrorInfo, TException {
        checkNull(removeOption, "removeOption");
        for (int id : removeOption.getSpecTradeTimeIds()) {
            new SpecTradeTimeHandler(getProvider(oCntl)).remove(id);
        }
    }

    @Override
    protected void removeDstTransferConfig(TServiceCntl oCntl, RemoveDstTransferConfigOption removeOption) throws ErrorInfo, TException {
        checkNull(removeOption, "removeOption");
        for (int id : removeOption.getDstTransferConfigIds()) {
            new DstTransferConfigHandler(getProvider(oCntl)).remove(id);
        }
    }

    @Override
    protected void batUpdateSledTradeTimeConfigs(TServiceCntl oCntl, List<SledTradeTimeConfig> configs) throws ErrorInfo, TException {
        checkNull(configs, "configs");
        new SledTradeTimeConfigHandler(getProvider(oCntl)).batUpdate(configs);
    }

    @Override
    protected void addCommoditySource(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySource commoditySource) throws ErrorInfo, TException {
        new CommoditySourceHandler(getProvider(oCntl)).insert(commoditySource);
    }

    @Override
    protected void updateCommoditySource(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySource commoditySource) throws ErrorInfo, TException {
        new CommoditySourceHandler(getProvider(oCntl)).update(commoditySource);
    }

    @Override
    protected com.longsheng.xueqiao.contract.thriftapi.CommoditySourcePage reqCommoditySource(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceOption option) throws ErrorInfo, TException {
        return new CommoditySourceHandler(getProvider(oCntl)).query(option);
    }

    @Override
    protected void addCommoditySourceAccount(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount commoditySourceAccount) throws ErrorInfo, TException {
        new CommoditySourceAccountHandler(getProvider(oCntl)).insert(commoditySourceAccount);
    }

    @Override
    protected void updateCommoditySourceAccount(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount commoditySourceAccount) throws ErrorInfo, TException {
        new CommoditySourceAccountHandler(getProvider(oCntl)).update(commoditySourceAccount);
    }

    @Override
    protected com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccountPage reqCommoditySourceAccount(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceAccountOption option) throws ErrorInfo, TException {
        return new CommoditySourceAccountHandler(getProvider(oCntl)).query(option);
    }

    @Override
    protected void addSledTradingSession(TServiceCntl oCntl, SledTradingSession sledTradingSession) throws ErrorInfo, TException {
        DalSetConnectionProvider provider = getProvider(oCntl);
        new TradingSessionHandler(provider.getDalSetDataSource()).addSledTradingSession(sledTradingSession);
    }

    @Override
    protected void updateSledTradingSession(TServiceCntl oCntl, SledTradingSession sledTradingSession) throws ErrorInfo, TException {
        DalSetConnectionProvider provider = getProvider(oCntl);
        new TradingSessionHandler(provider.getDalSetDataSource()).updateSledTradingSession(sledTradingSession);
    }

    @Override
    protected SledTradingSessionPage reqSledTradingSession(TServiceCntl oCntl, ReqSledTradingSessionOption option, IndexedPageOption pageOption) throws ErrorInfo, TException {
        DalSetConnectionProvider provider = getProvider(oCntl);
        return new TradingSessionHandler(provider.getDalSetDataSource()).reqSledTradingSession(option, pageOption);
    }

    @Override
    protected void removeSledTradingSession(TServiceCntl oCntl, long tradeSessionId) throws ErrorInfo, TException {
        DalSetConnectionProvider provider = getProvider(oCntl);
        new TradingSessionHandler(provider.getDalSetDataSource()).deleteSledTradingSession(tradeSessionId);
    }

    @Override
    protected void clearAllTechPlatformCommodity(TServiceCntl oCntl, int techPlatformValue) throws ErrorInfo, TException {
        new PlatformCommodityHandler(getProvider(oCntl)).clear(TechPlatform.findByValue(techPlatformValue));
    }

    @Override
    public void destroy() {
    }

    private void checkNull(Object obj, String paramterName) {
        if (obj == null) {
            throw new IllegalArgumentException(paramterName + " must not null.");
        }
    }
}
