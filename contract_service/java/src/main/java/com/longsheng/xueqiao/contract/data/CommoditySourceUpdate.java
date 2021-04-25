package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySource;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySourcePage;
import com.longsheng.xueqiao.contract.thriftapi.ContractManageErrorCode;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceOption;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.util.ArrayList;
import java.util.List;

public class CommoditySourceUpdate {

    public void update(CommoditySource commoditySource) throws TException {

        if (commoditySource == null || !commoditySource.isSetSourceId()) {
            throw new IllegalArgumentException("commoditySource id must set");
        }
        if (!commoditySource.isSetExchangeMic()) {
            throw new IllegalArgumentException("commoditySource ExchangeMic must set.");
        }

        ContractDaoServiceStub stub = new ContractDaoServiceStub();
        ReqCommoditySourceOption option = new ReqCommoditySourceOption();
        option.addToSourceIds(commoditySource.getSourceId());
        CommoditySourcePage page = stub.reqCommoditySource(option);
        if (page.getPageSize() == 0) {
            throw new IllegalArgumentException("commoditySource not found.");
        }

        CommoditySource oldSource = page.getPage().get(0);

        if (commoditySource.isSetTechPlatformEnv()) {
            if (!oldSource.getTechPlatformEnv().equals(commoditySource.getTechPlatformEnv())) {
                throw new IllegalArgumentException("commoditySource TechPlatformEnv no change.");
            }
            commoditySource.unsetTechPlatformEnv();
        }
        if (commoditySource.isSetTechPlatformSource()) {
            if (!oldSource.getTechPlatformSource().equals(commoditySource.getTechPlatformSource())) {
                throw new IllegalArgumentException("commoditySource TechPlatformSource no change.");
            }
            commoditySource.unsetTechPlatformSource();
        }

        List<String> mics = new ArrayList<>();
        CommoditySourcePage allPage = stub.reqCommoditySource(new ReqCommoditySourceOption());
        for (CommoditySource source : allPage.getPage()) {
            if (source.getSourceId() != commoditySource.getSourceId()
                    && source.getTechPlatformEnv() == oldSource.getTechPlatformEnv()) {
                mics.addAll(source.getExchangeMic());
            }
        }

        for (String mic : mics) {
            if (commoditySource.getExchangeMic().contains(mic)) {
                throw new ErrorInfo(ContractManageErrorCode.SLED_EXCHANGE_SOURCE_EXISTS.getValue(),
                        ContractManageErrorCode.SLED_EXCHANGE_SOURCE_EXISTS.name());
            }
        }

        stub.updateCommoditySource(commoditySource);
    }
}
