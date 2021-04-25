package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.thrift.TException;

public class TradeTimeAccess {
    public SledCommoditySpecTradeTimePage getSpecTradeTime(ReqCommoditySpecTradeTimeOption option, int pageIndex, int pageSize) throws TException {
        ContractDaoServiceStub stub = new ContractDaoServiceStub();
        return stub.reqSledCommoditySpecTradeTime(option, pageIndex, pageSize);
    }
}
