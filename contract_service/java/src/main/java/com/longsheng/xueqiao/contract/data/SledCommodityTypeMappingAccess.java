package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledCommodityTypeMappingOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMappingPage;
import org.apache.thrift.TException;

public class SledCommodityTypeMappingAccess {

    public SledCommodityTypeMappingPage getPage(ReqSledCommodityTypeMappingOption option) throws TException {

        return new ContractDaoServiceStub().reqSledCommodityTypeMapping(option);
    }
}
