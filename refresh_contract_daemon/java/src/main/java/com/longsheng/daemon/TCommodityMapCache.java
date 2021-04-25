package com.longsheng.daemon;

import com.longsheng.xueqiao.contract.dao.thriftapi.*;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.WorkingStatus;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TCommodityMapCache {
    private static TCommodityMapCache ourInstance = new TCommodityMapCache();

    public static TCommodityMapCache getInstance() {
        return ourInstance;
    }

    ContractDaoServiceStub stub = new ContractDaoServiceStub();
    int router = 0;
    int timeout = 2000;


    private Map<String, Integer> sledCommodityIdMap = new HashMap<>();

    private Map<Integer, TCommodityMap> tCommodityMapping = new HashMap<>();

    public TCommodityMap getTCommodityMap(int sledCommodityId) {
        return tCommodityMapping.get(sledCommodityId);
    }

    private class CommodityKey {
        public int platform;
        public String exchange;
        public String commodityType;
        public String commodityCode;

        public String getKey() {
            return platform + "|" + exchange + "|" + commodityType + "|" + commodityCode;
        }
    }

    private TCommodityMapCache() {
    }

    public void init(int brokerEntryId) throws TException {
        sledCommodityIdMap.clear();
        tCommodityMapping.clear();

        List<PlatformBrokerMap> list = new ArrayList<>();
        list.add(new PlatformBrokerMap(TechPlatform.CTP, 0));
        list.add(new PlatformBrokerMap(TechPlatform.ESUNNY, 0));
        if (brokerEntryId > 0) {
            list.add(new PlatformBrokerMap(TechPlatform.ESUNNY_3, brokerEntryId));
        }

        for (PlatformBrokerMap map : list) {
            int pageIndex = 0;
            int pageSize = 20;
            int total = 0;
            do {
                ReqTCommodityMapOption option = new ReqTCommodityMapOption();
                option.setBrokerEntryId(map.getBrokerEntryId());
                option.setPlatform(map.getTechPlatform().getValue());
                TCommodityMapPage page = stub.reqTCommodityMap(router, timeout, option, pageIndex, pageSize);
                total = page.getTotal();
                AppLog.d("page index: " + pageIndex);
                AppLog.d("commodity map total: " + total);
                for (TCommodityMap t : page.getPage()) {
//                    AppLog.i("TCommodityMap: " + t);
                    CommodityKey key = new CommodityKey();
                    key.platform = t.getTechPlatform();
                    key.exchange = t.getExchange();
                    key.commodityType = t.getCommodityType();
                    key.commodityCode = t.getCommodityCode();
//                    AppLog.d("CommodityKey " + key.getKey());
                    sledCommodityIdMap.put(key.getKey(), t.getSledCommodityId());
                    tCommodityMapping.put(t.getSledCommodityId(), t);
                }
                pageIndex++;
            } while (total > pageIndex * pageSize);
        }
    }

    public TSledCommodity getTSledCommodityId(TechPlatform platform, String exchange, String commodityType, String commodityCode) {

        CommodityKey key = new CommodityKey();
        key.platform = platform.getValue();
        key.exchange = exchange;
        key.commodityType = commodityType;
        key.commodityCode = commodityCode;
        AppLog.d("CommodityKey " + key.getKey());
        Integer id = sledCommodityIdMap.get(key.getKey());
        AppLog.d("sled commodity id: " + id);
        if (id == null) {
            return null;
        }

        ReqTSledCommodityOption option = new ReqTSledCommodityOption();
        option.addToSledCommodityIds(id);
        TCommodityPage page;
        try {
            page = stub.reqTSledCommodity(router, timeout, option, 0, 1);
        } catch (TException e) {
            AppLog.e(e.getMessage(), e);
            return null;
        }
        AppLog.d("sled commodity page: " + page);
        if (page.getPageSize() > 0) {
            TSledCommodity tSledCommodity = page.getPage().get(0);
            return tSledCommodity;
        }
        return null;
    }
}
