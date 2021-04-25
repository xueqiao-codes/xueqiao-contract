package com.longsheng.xueqiao.contract.online.dao.thriftapi.server.impl;


import java.util.Properties;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.handlers.DbLockingInfoHandler;
import com.longsheng.xueqiao.contract.dao.handlers.SledTradeTimeTmpHandler;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeOption;
import com.longsheng.xueqiao.contract.thriftapi.SledTradeTimePage;
import org.apache.thrift.TException;
import org.soldier.base.beanfactory.Globals;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;

import com.longsheng.xueqiao.contract.dao.handlers.ContractVersionHandler;
import com.longsheng.xueqiao.contract.online.dao.config.OnlineConfigurationProperty;
import com.longsheng.xueqiao.contract.online.dao.data.CommodityMappingAccess;
import com.longsheng.xueqiao.contract.online.dao.data.SledCommodityAccess;
import com.longsheng.xueqiao.contract.online.dao.data.SledContractAccess;
import com.longsheng.xueqiao.contract.online.dao.data.SledExchangeAccess;
import com.longsheng.xueqiao.contract.online.dao.provider.DalSetConnectionProviderFactory;
import com.longsheng.xueqiao.contract.online.dao.provider.IConnectionProviderFactory;
import com.longsheng.xueqiao.contract.online.dao.provider.IConnectionProviderFactory.ConnectionContext;
import com.longsheng.xueqiao.contract.online.dao.thriftapi.server.ContractOnlineDaoServiceAdaptor;
import com.longsheng.xueqiao.contract.thriftapi.RemoveContractVersionOption;

public class ContractOnlineDaoServiceHandler extends ContractOnlineDaoServiceAdaptor {
    private IConnectionProviderFactory connectionProviderFactory;

    @Override
    public int InitApp(Properties props) {
        try {
            OnlineConfigurationProperty.instance().init(props);

            connectionProviderFactory = Globals.getInstance().queryInterface(IConnectionProviderFactory.class);
            if (connectionProviderFactory == null) {
                connectionProviderFactory = new DalSetConnectionProviderFactory(
                        OnlineConfigurationProperty.instance().getRoleName());
            }
            AppLog.d("connectionProviderFactory impl class=" + connectionProviderFactory.getClass().getName());
        } catch (Throwable e) {
            AppLog.e("Config init fail.", e);
            return -1;
        }

        AppLog.e("======= SERVICE STARTED =======");
        return 0;
    }

    @Override
    protected com.longsheng.xueqiao.contract.standard.thriftapi.SledContractPage reqSledContract(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new SledContractAccess(
                connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, true)))
                .getSledContractPage(option, pageIndex, pageSize);
    }

    @Override
    protected SledContractDetailsPage reqSledContractDetail(TServiceCntl oCntl, ReqSledContractDetailsOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new SledContractAccess(
                connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, true))).getSledContractDetailPage(option, pageIndex, pageSize);
    }

    @Override
    protected com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMappingPage reqCommodityMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqCommodityMappingOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new CommodityMappingAccess(
                connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, true)))
                .reqCommodityMap(option, pageIndex, pageSize);
    }

    @Override
    protected com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage reqSledExchange(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new SledExchangeAccess(
                connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, true)))
                .getPage(option, pageIndex, pageSize);
    }

    @Override
    protected com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityPage reqSledCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new SledCommodityAccess(
                connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, true)))
                .getPage(option, pageIndex, pageSize);
    }

    @Override
    protected com.longsheng.xueqiao.contract.thriftapi.ContractVersionPage reqContractVersion(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqContractVersionOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new ContractVersionHandler(
                connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, true)))
                .query(option, pageIndex, pageSize);
    }

    @Override
    protected void updateContractVersion(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ContractVersion contractVersion) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(contractVersion, "contractVersion");
        new ContractVersionHandler(
                connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, false)))
                .update(contractVersion);
    }

    @Override
    protected void removeContractVersion(TServiceCntl oCntl, int versionId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        RemoveContractVersionOption option = new RemoveContractVersionOption();
        option.setVersionId(versionId);
        new ContractVersionHandler(
                connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, false)))
                .remove(option);
    }

    @Override
    protected void addDbLocking(TServiceCntl oCntl, DbLockingInfo dbLockingInfo) throws ErrorInfo, TException {
        checkNull(dbLockingInfo, "dbLockingInfo");
        DbLockingInfo info = new DbLockingInfoHandler(connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, false))).query();
        if (info.isIsLocked()) {
            throw new ErrorInfo(ErrorCodeOuter.ILLEGAL_OPEARTION_ERROR.getErrorCode(), "Db is locked.");
        } else {
            new DbLockingInfoHandler(connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, false))).insert(dbLockingInfo);
        }
    }

    @Override
    protected void removeDbLocking(TServiceCntl oCntl, String lockedBy) throws ErrorInfo, TException {
        checkNull(lockedBy, "lockedBy");
        DbLockingInfo info = new DbLockingInfoHandler(connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, false))).query();
        if (lockedBy.equals(info.getLockedBy())) {
            new DbLockingInfoHandler(connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, false))).remove(lockedBy);
        } else {
            throw new ErrorInfo(ErrorCodeOuter.ILLEGAL_OPEARTION_ERROR.getErrorCode(), "Db is locked by other.");
        }
    }

    @Override
    protected DbLockingInfo reqDbLockingInfo(TServiceCntl oCntl) throws ErrorInfo, TException {
        return new DbLockingInfoHandler(connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, false))).query();
    }

    @Override
    protected SledTradeTimePage reqSledTradeTime(TServiceCntl oCntl, ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new SledTradeTimeTmpHandler(connectionProviderFactory.getConnectionProvider(new ConnectionContext(oCntl, true))).query(option, pageIndex, pageSize);
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
