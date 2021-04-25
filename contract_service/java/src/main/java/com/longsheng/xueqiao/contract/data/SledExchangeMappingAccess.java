package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledExchangeMappingOption;
import com.longsheng.xueqiao.contract.thriftapi.SledExchangeMappingPage;
import org.apache.thrift.TException;

public class SledExchangeMappingAccess {

    public SledExchangeMappingPage getPage(ReqSledExchangeMappingOption option) throws TException {
        return new ContractDaoServiceStub().reqSledExchangeMapping(option);
    }
}
