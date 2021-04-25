package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTCommodityMapOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMap;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMapPage;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class CommodityMappingAccess {

    private static ContractDaoServiceStub stub = new ContractDaoServiceStub();
    private static int timeout = 3000;
    private static int routerKey = 0;

    public CommodityMappingEditPage reqCommodityMap(ReqCommodityMappingEditOption option, int pageIndex, int pageSize) throws TException {

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

        if (option.isSetEditStatus()) {
            reqTCommodityMapOption.setEditstatus(option.getEditStatus().getValue());
        }
        if (option.isSetWorkingStatus()) {
            reqTCommodityMapOption.setWorkingStatus(option.getEditStatus().getValue());
        }

        TCommodityMapPage tCommodityMapPage = stub.reqTCommodityMap(routerKey, timeout, reqTCommodityMapOption, pageIndex, pageSize);
        CommodityMappingEditPage page = new CommodityMappingEditPage();
        page.setTotal(tCommodityMapPage.getTotal());
        page.setPage(map2CommodityMap(tCommodityMapPage.getPage()));
        return page;
    }

    public static List<CommodityMappingEdit> map2CommodityMap(List<TCommodityMap> tCommodityMaps) {
        List<CommodityMappingEdit> maps = new ArrayList<>();
        for (TCommodityMap tCommodityMap : tCommodityMaps) {
            CommodityMappingEdit map = getCommodityMap(tCommodityMap);
            maps.add(map);
        }
        return maps;
    }

    public static CommodityMappingEdit getCommodityMap(TCommodityMap tCommodityMap) {
        CommodityMappingEdit mappingEdit = new CommodityMappingEdit();

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

        mappingEdit.setCommodityMapping(map);
        mappingEdit.setEditStatus(EditStatus.findByValue(tCommodityMap.getEditstatus()));
        mappingEdit.setWorkingStatus(WorkingStatus.findByValue(tCommodityMap.getWorkingStatus()));

        return mappingEdit;
    }
}
