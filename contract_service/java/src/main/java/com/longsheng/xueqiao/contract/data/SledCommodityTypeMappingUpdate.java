package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.ContractManageErrorCode;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledCommodityTypeMappingOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMappingPage;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class SledCommodityTypeMappingUpdate {

    public void add(SledCommodityTypeMapping mapping) throws TException {

        if (mapping.isSetSledCommodityType() && mapping.isSetTechPlatformCommodityType() && mapping.isSetTechPlatform()) {
            SledCommodityTypeMappingAccess access = new SledCommodityTypeMappingAccess();
            ReqSledCommodityTypeMappingOption option = new ReqSledCommodityTypeMappingOption();
            option.setTechPlatform(mapping.getTechPlatform());
            option.setSledCommodityType(mapping.getSledCommodityType());
            SledCommodityTypeMappingPage page = access.getPage(option);
            if (page.getPageSize() > 0) {
                throw new ErrorInfo(ContractManageErrorCode.SLED_COMMODITY_TYPE_MAPPING_EXISTS.getValue(), "Commodity type mapping exists.");
            }

            new ContractDaoServiceStub().addSledCommodityTypeMapping(mapping);
        } else {
            throw new IllegalArgumentException("SledCommodityTypeMapping fields must set.");
        }
    }

    public void update(SledCommodityTypeMapping mapping) throws TException {
        if (mapping.isSetMappingId()){
            new ContractDaoServiceStub().updateSledCommodityTypeMapping(mapping);
        }
        else {
            throw new IllegalArgumentException("SledCommodityTypeMapping MappingId must set.");
        }

    }
}
