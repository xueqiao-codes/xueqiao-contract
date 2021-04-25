package com.longsheng.xueqiao.contract.utils;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;

public class ContractDao {
    private static ContractDao ourInstance = new ContractDao();

    public static ContractDao getInstance() {
        return ourInstance;
    }

    private ContractDaoServiceStub serviceStub;

    private ContractDao() {
        serviceStub = new ContractDaoServiceStub();
    }


    public ContractDaoServiceStub getServiceStub() {
        return serviceStub;
    }
}
