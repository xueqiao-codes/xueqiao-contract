package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo;
import org.apache.thrift.TException;

public class DbLockingAccess {

    public DbLockingInfo reqDbLocking() throws TException {
        ContractDaoServiceStub stub = new ContractDaoServiceStub();
        return stub.reqDbLockingInfo();
    }
}
