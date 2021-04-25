package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.ContractManageErrorCode;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledExchangeMappingOption;
import com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping;
import com.longsheng.xueqiao.contract.thriftapi.SledExchangeMappingPage;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class SledExchangeMappingUpdate {

    public void add(SledExchangeMapping mapping) throws TException {
        if (mapping.isSetSledExchangeMic() && mapping.isSetTechPlatform() && mapping.isSetTechPlatformExchangeCode()) {
            SledExchangeMappingAccess sledExchangeMappingAccess = new SledExchangeMappingAccess();
            ReqSledExchangeMappingOption option = new ReqSledExchangeMappingOption();
            option.setSledExchangeMic(mapping.getSledExchangeMic());
            option.setTechPlatform(mapping.getTechPlatform());
            SledExchangeMappingPage page = sledExchangeMappingAccess.getPage(option);
            if (page.getPageSize() > 0) {
                throw new ErrorInfo(ContractManageErrorCode.SLED_EXCHANGE_MAPPING_EXISTS.getValue(), " exchange mapping exists.");
            }
            new ContractDaoServiceStub().addSledExchangeMapping(mapping);

        } else {
            throw new IllegalArgumentException("SledExchangeMapping fields must set.");
        }

    }

    public void update(SledExchangeMapping mapping) throws TException {
        if (mapping.isSetMappingId()) {
            new ContractDaoServiceStub().updateSledExchangeMapping(mapping);

        } else {
            throw new IllegalArgumentException("SledExchangeMapping MappingId must set.");
        }

    }
}
