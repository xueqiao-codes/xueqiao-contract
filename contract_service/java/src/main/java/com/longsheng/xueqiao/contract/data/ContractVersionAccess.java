package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.ContractVersionPage;
import com.longsheng.xueqiao.contract.thriftapi.ReqContractVersionOption;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;

public class ContractVersionAccess {
    protected ContractDaoServiceStub stub = new ContractDaoServiceStub();
    protected int routeKey = RandomUtils.nextInt();
    protected int timeout = 3000;

    public ContractVersionPage getPage(ReqContractVersionOption option, int pageIndex, int pageSize) throws TException {

        return stub.reqContractVersion(routeKey, timeout, option, pageIndex, pageSize);
    }
}
