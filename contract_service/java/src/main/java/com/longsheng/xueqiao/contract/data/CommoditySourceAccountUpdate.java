package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccountPage;
import com.longsheng.xueqiao.contract.thriftapi.ContractManageErrorCode;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceAccountOption;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class CommoditySourceAccountUpdate {

    public void update(CommoditySourceAccount commoditySourceAccount) throws TException {
        if (commoditySourceAccount == null || !commoditySourceAccount.isSetAccountId()) {
            throw new IllegalArgumentException("AccountId must set");
        }
        ContractDaoServiceStub stub = new ContractDaoServiceStub();

        ReqCommoditySourceAccountOption option = new ReqCommoditySourceAccountOption();
        option.addToAccountIds(commoditySourceAccount.getAccountId());
        CommoditySourceAccountPage page = stub.reqCommoditySourceAccount(option);
        if (page.getPageSize() == 0) {
            throw new IllegalArgumentException("CommoditySourceAccount not found.");
        }

        CommoditySourceAccount oldAccount = page.getPage().get(0);

        if (commoditySourceAccount.isSetTechPlatformEnv() && !commoditySourceAccount.getTechPlatformEnv().equals(oldAccount.getTechPlatformEnv())) {
            throw new IllegalArgumentException("CommoditySourceAccount TechPlatformEnv no change.");
        }
        if (commoditySourceAccount.isSetTechPlatform() && !commoditySourceAccount.getTechPlatform().equals(oldAccount.getTechPlatform())) {
            throw new IllegalArgumentException("CommoditySourceAccount TechPlatform no change.");
        }
        commoditySourceAccount.unsetTechPlatform();
        commoditySourceAccount.unsetTechPlatformEnv();

        CommoditySourceAccountPage allPage = stub.reqCommoditySourceAccount(new ReqCommoditySourceAccountOption());
        for (CommoditySourceAccount account : allPage.getPage()) {
            if (account.getAccountId() != commoditySourceAccount.getAccountId()
                    && !"".equals(account.getIpAddress())
                    && account.getIpAddress().equals(commoditySourceAccount.getIpAddress())
                    && account.getPort() == commoditySourceAccount.getPort()
                    && account.getTechPlatform().equals(commoditySourceAccount.getTechPlatform())) {
                throw new ErrorInfo(ContractManageErrorCode.SOURCE_ACCOUNT_IP_PORT_EXISTS.getValue(),
                        ContractManageErrorCode.SOURCE_ACCOUNT_IP_PORT_EXISTS.name());
            }
        }
        stub.updateCommoditySourceAccount(commoditySourceAccount);
    }
}
