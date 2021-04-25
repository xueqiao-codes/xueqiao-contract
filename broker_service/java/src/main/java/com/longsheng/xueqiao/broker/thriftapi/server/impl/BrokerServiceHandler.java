package com.longsheng.xueqiao.broker.thriftapi.server.impl;


import java.util.*;

import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.broker.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import com.longsheng.xueqiao.broker.thriftapi.server.BrokerServiceAdaptor;

public class BrokerServiceHandler extends BrokerServiceAdaptor {
    @Override
    public int InitApp(Properties props) {
        return 0;
    }

    @Override
    protected BrokerPage reqBroker(TServiceCntl oCntl, ReqBrokerOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        checkPageSize(pageSize);
        BrokerDaoServiceStub stub = new BrokerDaoServiceStub();

        ReqBrokerEntryOption reqEntryOption = new ReqBrokerEntryOption();
        if (option.isSetEnv()) {
            reqEntryOption.setEnv(option.getEnv());
        }
        if (option.isSetBrokerId()) {
            reqEntryOption.addToBrokerIds(option.getBrokerId());
        }
        if (option.isSetCnNamePartical()) {
            reqEntryOption.setCnNamePartical(option.getCnNamePartical());
        }
        if (option.isSetCnNameWhole()) {
            reqEntryOption.setCnNameWhole(option.getCnNameWhole());
        }
        if (option.isSetEngNamePartical()) {
            reqEntryOption.setEngNamePartical(option.getEngNamePartical());
        }
        if (option.isSetEngNameWhole()) {
            reqEntryOption.setEngNameWhole(option.getEngNameWhole());
        }
        reqEntryOption.setOrderAsc(true);
        reqEntryOption.setOrderByBrokerName(true);
        BrokerEntryPage page = stub.reqBrokerEntry(reqEntryOption, pageIndex, pageSize);

        BrokerPage brokerPage = new BrokerPage();
        brokerPage.setTotal(page.getTotal());
        brokerPage.setPage(page.getPage());
        return brokerPage;
    }

    @Override
    protected BrokerAccessPage reqBrokerAccess(TServiceCntl oCntl, ReqBrokerAccessOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        checkPageSize(pageSize);

        BrokerDaoServiceStub stub = new BrokerDaoServiceStub();
        ReqBrokerAccessEntryOption reqAccessOption = new ReqBrokerAccessEntryOption();
        if (option.isSetBrokerId()) {
            reqAccessOption.setBrokerIds(option.getBrokerId());
        }
        if (option.isSetPlatform()) {
            reqAccessOption.setPlatform(option.getPlatform());
        }
        if (option.isSetPlatforms()){
            reqAccessOption.setPlatforms(option.getPlatforms());
        }

        BrokerAccessEntryPage page = stub.reqBrokerAccessEntry(reqAccessOption, pageIndex, pageSize);
        BrokerAccessPage resultPage = new BrokerAccessPage();
        resultPage.setTotal(page.getTotal());
        resultPage.setPage(page.getPage());
        return resultPage;
    }

    @Override
    protected BrokerAccessInfoPage reqBrokerAccessInfo(TServiceCntl oCntl, ReqBrokerAccessInfoOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        checkPageSize(pageSize);
        if (option.getBrokerAccessIdsSize() == 0) {
            throw new IllegalArgumentException("option must set.");
        }

        BrokerDaoServiceStub stub = new BrokerDaoServiceStub();
        ReqBrokerAccessEntryOption reqAccessOption = new ReqBrokerAccessEntryOption();
        if (option.isSetBrokerAccessIds() && option.getBrokerAccessIdsSize() > 0) {
            reqAccessOption.setEntryIds(option.getBrokerAccessIds());
        }
        if (option.isSetPlatforms() && option.getPlatformsSize() > 0) {
            reqAccessOption.setPlatforms(option.getPlatforms());
        }
        BrokerAccessEntryPage accessEntryPage = stub.reqBrokerAccessEntry(reqAccessOption, pageIndex, pageSize);

        if (accessEntryPage.getTotal() == 0) {
            return new BrokerAccessInfoPage().setTotal(0).setPage(new ArrayList<>());
        }

        Set<Integer> brokerIds = new HashSet<>();

        for (BrokerAccessEntry accessEntry : accessEntryPage.getPage()) {
            brokerIds.add(accessEntry.getBrokerId());
        }

        ReqBrokerEntryOption reqBrokerOption = new ReqBrokerEntryOption();
        List<Integer> list = new ArrayList<>();
        list.addAll(brokerIds);
        reqBrokerOption.setBrokerIds(list);
        BrokerEntryPage brokerEntryPage = stub.reqBrokerEntry(reqBrokerOption, pageIndex, pageSize);
        Map<Integer, BrokerEntry> map = new HashMap<>();
        for (BrokerEntry t : brokerEntryPage.getPage()) {
            map.put(t.getBrokerId(), t);
        }

        BrokerAccessInfoPage page = new BrokerAccessInfoPage();
        page.setTotal(accessEntryPage.getTotal());
        List<BrokerAccessInfo> infos = new ArrayList<>();
        for (BrokerAccessEntry accessEntry : accessEntryPage.getPage()) {
            BrokerAccessInfo info = new BrokerAccessInfo();

            info.setBrokerId(accessEntry.getBrokerId());
            info.setEntryId(accessEntry.getEntryId());
            info.setPlatform(accessEntry.getPlatform());
            BrokerEntry entry = map.get(accessEntry.getBrokerId());
            if (entry != null) {
                info.setEngName(entry.getEngName());
                info.setCnName(entry.getCnName());
                info.setNote(entry.getNote());
            }
            info.setTechPlatformEnv(accessEntry.getTechPlatformEnv());
            info.setAccessName(accessEntry.getAccessName());
            infos.add(info);
        }
        page.setPage(infos);
        return page;
    }

    private void checkPageSize(int pageSize) {
        if (pageSize > 50) {
            throw new IllegalArgumentException(pageSize + " must 1 - 50.");
        }
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
