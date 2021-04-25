package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTCommodityMapOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMap;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMapPage;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledContractErrorCode;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEdit;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEditPage;
import com.longsheng.xueqiao.contract.thriftapi.EditStatus;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMappingEditOption;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class CommodityMappingUpdate {

    private static ContractDaoServiceStub stub = new ContractDaoServiceStub();
    private static int timeout = 3000;
    private static int routerKey = 0;

    public CommodityMappingEdit addCommodityMap(CommodityMapping commodityMap) throws TException {
       doAddCommodityMap(commodityMap);

        ReqCommodityMappingEditOption option = new ReqCommodityMappingEditOption();
        option.setTechPlatform(commodityMap.getTechPlatform());
        option.setBrokerEntryId(commodityMap.getBrokerEntryId());
        option.addToSledCommodityIdList(commodityMap.getSledCommodityId());
        CommodityMappingAccess access =new CommodityMappingAccess();
        return access.reqCommodityMap(option, 0, 1).getPage().get(0);
    }

    public  void doAddCommodityMap(CommodityMapping commodityMap) throws TException {
        checkMappingInput(commodityMap);
        TCommodityMap tCommodityMap = map2TCommodityMap(commodityMap);
        tCommodityMap.setEditstatus(EditStatus.NEW.getValue());
        stub.addTCommodityMap(routerKey, timeout, tCommodityMap);
    }

    private void checkMappingInput(CommodityMapping commodityMap) throws TException {
        ReqCommodityMappingEditOption option = new ReqCommodityMappingEditOption();
        option.setExchange(commodityMap.getExchange());
        option.setCommodityType(commodityMap.getCommodityType());
        option.setCommodityCode(commodityMap.getCommodityCode());
        option.setTechPlatform(commodityMap.getTechPlatform());
        option.setBrokerEntryId(commodityMap.getBrokerEntryId());
        CommodityMappingAccess access = new CommodityMappingAccess();
        CommodityMappingEditPage page = access.reqCommodityMap(option, 0, 1);
        if (page.getTotal() > 0) {
            if (page.getPage().get(0).getCommodityMapping().getSledCommodityId() == commodityMap.getSledCommodityId()) {
                throw new ErrorInfo(SledContractErrorCode.COMMODITY_MAP_EXISTS.getValue(), "commodity map exists.");
            }
            throw new ErrorInfo(SledContractErrorCode.COMMODITY_MAP_UPDATE_FORBID.getValue(), "commodity map update forbid.");
        }

        option.unsetCommodityCode();
        option.unsetCommodityType();
        option.unsetExchange();
        option.addToSledCommodityIdList(commodityMap.getSledCommodityId());

        CommodityMappingEditPage page2 = access.reqCommodityMap(option, 0, 1);
        if (page2.getTotal() > 0) {
            CommodityMapping mapping = page2.getPage().get(0).getCommodityMapping();
            if (mapping.getExchange().equals(commodityMap.getExchange())
                    && mapping.getCommodityType().equals(commodityMap.getCommodityType())
                    && mapping.getCommodityCode().equals(commodityMap.getCommodityCode())) {
                throw new ErrorInfo(SledContractErrorCode.COMMODITY_MAP_EXISTS.getValue(), "commodity map exists.");
            }

            throw new ErrorInfo(SledContractErrorCode.COMMODITY_MAP_UPDATE_FORBID.getValue(), "commodity map update forbid.");
        }
    }

    private TCommodityMap map2TCommodityMap(CommodityMapping commodityMap) {
        if (!commodityMap.isSetSledCommodityId() || !commodityMap.isSetCommodityCode()
                || !commodityMap.isSetCommodityType() || !commodityMap.isSetExchange()
                || !commodityMap.isSetMoneyRatio() || !commodityMap.isSetTechPlatform()
                || !commodityMap.isSetBrokerEntryId()) {
            throw new IllegalArgumentException("CommodityMap properties must set.");
        }
        TCommodityMap tCommodityMap = new TCommodityMap();
        if (commodityMap.isSetCommodityCode()) {
            tCommodityMap.setCommodityCode(commodityMap.getCommodityCode());
        }
        if (commodityMap.isSetCommodityType()) {
            tCommodityMap.setCommodityType(commodityMap.getCommodityType());
        }
        if (commodityMap.isSetExchange()) {
            tCommodityMap.setExchange(commodityMap.getExchange());
        }
        if (commodityMap.isSetMoneyRatio()) {
            tCommodityMap.setMoneyRatio(commodityMap.getMoneyRatio());
        }
        if (commodityMap.isSetTechPlatform()) {
            tCommodityMap.setTechPlatform(commodityMap.getTechPlatform().getValue());
        }
        if (commodityMap.isSetSledCommodityId()) {
            tCommodityMap.setSledCommodityId(commodityMap.getSledCommodityId());
        }
        if (commodityMap.isSetBrokerEntryId()) {
            tCommodityMap.setBrokerEntryId(commodityMap.getBrokerEntryId());
        }
        if (commodityMap.isSetActiveStartTimestamp()) {
            tCommodityMap.setActiveStartTimestamp(commodityMap.getActiveStartTimestamp());
        }
        if (commodityMap.isSetActiveEndTimestamp()) {
            tCommodityMap.setActiveEndTimestamp(commodityMap.getActiveEndTimestamp());
        }
        return tCommodityMap;
    }

    private TCommodityMap queryMap(ReqTCommodityMapOption option) throws TException {
        TCommodityMapPage tPage = stub.reqTCommodityMap(routerKey, timeout, option, 0, 10);
        if (tPage.getPageSize() == 0) {
            throw new ErrorInfo(SledContractErrorCode.COMMODITY_MAP_NOT_FOUND.getValue(), "update commodity map fail.");
        }
        return tPage.getPage().get(0);
    }

    public CommodityMappingEdit updateCommodityMap(CommodityMapping commodityMap) throws TException {

        if (!commodityMap.isSetBrokerEntryId() || !commodityMap.isSetTechPlatform()) {
            throw new IllegalArgumentException("CommodityMap BrokerAccessId TechPlatform must set.");
        }
        TCommodityMap tCommodityMap = map2TCommodityMap(commodityMap);
        if (commodityMap.isSetMappingId()) {
            tCommodityMap.setMapId(commodityMap.getMappingId());
        } else {
            throw new IllegalArgumentException("CommodityMap mapId must set.");
        }

        ReqTCommodityMapOption option = new ReqTCommodityMapOption();
        option.addToMapIds(commodityMap.getMappingId());
        CommodityMappingEdit map = CommodityMappingAccess.getCommodityMap(queryMap(option));

        if (map.getEditStatus() == EditStatus.SYNCHRONIZED) {
            throw new ErrorInfo(SledContractErrorCode.COMMODITY_MAP_UPDATE_FORBID.getValue(), "Mapping no change after syncAll.");
        }

        stub.updateTCommodityMap(routerKey, timeout, tCommodityMap);
        return CommodityMappingAccess.getCommodityMap(queryMap(option));
    }
}
