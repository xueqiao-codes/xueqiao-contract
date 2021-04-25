package com.longsheng.xueqiao.contract.online.dao.data;

import com.longsheng.xueqiao.contract.dao.handlers.CommodityMapHandler;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTCommodityMapOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMap;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMapPage;
import com.longsheng.xueqiao.contract.online.dao.config.WorkingStatus;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMappingPage;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqCommodityMappingOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class CommodityMappingAccess {

    private final IConnectionProvider connProvider;

    public CommodityMappingAccess(IConnectionProvider iConnectionProvider) {
        connProvider = iConnectionProvider;
    }

    public CommodityMappingPage reqCommodityMap(ReqCommodityMappingOption option, int pageIndex, int pageSize) throws TException {

        ReqTCommodityMapOption reqTCommodityMapOption = new ReqTCommodityMapOption();
        if (option.isSetBrokerEntryId()) {
            reqTCommodityMapOption.setBrokerEntryId(option.getBrokerEntryId());
        }
        if (option.isSetTechPlatform()) {
            reqTCommodityMapOption.setPlatform(option.getTechPlatform().getValue());
        }

        if (option.isSetSledCommodityIdList() && option.getSledCommodityIdListSize() > 0) {
            reqTCommodityMapOption.setSledCommodityIds(option.getSledCommodityIdList());
        }

        if (option.isSetExchange()) {
            reqTCommodityMapOption.setExchange(option.getExchange());
        }
        if (option.isSetCommodityType()) {
            reqTCommodityMapOption.setCommodityType(option.getCommodityType());
        }
        if (option.isSetCommodityCode()) {
            reqTCommodityMapOption.setCommodityCode(option.getCommodityCode());
        }
        if (option.isSetMapIds() && option.getMapIdsSize() > 0) {
            reqTCommodityMapOption.setMapIds(option.getMapIds());
        }

//        reqTCommodityMapOption.setWorkingStatus(WorkingStatus.WORKING.getValue());


        TCommodityMapPage tCommodityMapPage =new CommodityMapHandler(connProvider).query( reqTCommodityMapOption, pageIndex, pageSize);
        CommodityMappingPage page = new CommodityMappingPage();
        page.setTotal(tCommodityMapPage.getTotal());
        page.setPage(map2CommodityMap(tCommodityMapPage.getPage()));
        return page;
    }

    public static List<CommodityMapping> map2CommodityMap(List<TCommodityMap> tCommodityMaps) {
        List<CommodityMapping> maps = new ArrayList<>();
        for (TCommodityMap tCommodityMap : tCommodityMaps) {
            CommodityMapping map = getCommodityMap(tCommodityMap);
            maps.add(map);
        }
        return maps;
    }

    public static CommodityMapping getCommodityMap(TCommodityMap tCommodityMap) {

        CommodityMapping map = new CommodityMapping();
        map.setExchange(tCommodityMap.getExchange());
        map.setCommodityType(tCommodityMap.getCommodityType());
        map.setCommodityCode(tCommodityMap.getCommodityCode());
        map.setMappingId(tCommodityMap.getMapId());
        map.setTechPlatform(TechPlatform.findByValue(tCommodityMap.getTechPlatform()));
        map.setMoneyRatio(tCommodityMap.getMoneyRatio());
        map.setSledCommodityId(tCommodityMap.getSledCommodityId());
        map.setBrokerEntryId(tCommodityMap.getBrokerEntryId());
        map.setCreateTimestamp(tCommodityMap.getCreateTimestamp());
        map.setLastModityTimestamp(tCommodityMap.getLastModityTimestamp());
        map.setActiveStartTimestamp(tCommodityMap.getActiveStartTimestamp());
        map.setActiveEndTimestamp(tCommodityMap.getActiveEndTimestamp());

        return map;
    }
}
