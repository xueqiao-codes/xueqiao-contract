package com.longsheng.xueqiao.contract.data;


import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledContractErrorCode;
import com.longsheng.xueqiao.contract.thriftapi.ContractVersion;
import com.longsheng.xueqiao.contract.thriftapi.ContractVersionPage;
import com.longsheng.xueqiao.contract.thriftapi.RemoveContractVersionOption;
import com.longsheng.xueqiao.contract.thriftapi.ReqContractVersionOption;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class ContractVersionUpdate {

    protected ContractDaoServiceStub stub = new ContractDaoServiceStub();
    protected int routeKey = RandomUtils.nextInt();
    protected int timeout = 3000;

    public void add(ContractVersion contractVersion) throws TException {
        stub.addContractVersion(routeKey, timeout, contractVersion);
    }

    public void update(ContractVersion contractVersion) throws TException {

        if (!contractVersion.isSetVersionId()) {
            throw new IllegalArgumentException("ContractVersionId must set");
        }

        stub.updateContractVersion(routeKey, timeout, contractVersion);
    }

    public boolean remove(int versionId) throws TException {
        ContractVersionAccess access = new ContractVersionAccess();
        ReqContractVersionOption option = new ReqContractVersionOption();
        option.setVersionId(versionId);
        ContractVersionPage page = access.getPage(option, 0, 1);
        if (page.getTotal() == 0) {
            throw new ErrorInfo(SledContractErrorCode.CONTRACT_VERSION_NOT_FOUND.getValue(), "contract version not found.");
        }
        try {
            RemoveContractVersionOption removeOption = new RemoveContractVersionOption();
            removeOption.setVersionId(versionId);
            stub.removeContractVersion(routeKey, timeout, removeOption);
            return true;
        } catch (TException e) {
            AppLog.e(e.getMessage(), e);
            return false;
        }
    }

    public void addSyncTask() throws TException {
        RemoveContractVersionOption removeOption = new RemoveContractVersionOption();
        removeOption.setAll(true);
        stub.removeContractVersion(removeOption);
        ContractVersion contractVersion =new ContractVersion();
        contractVersion.setFileMD5("");
        contractVersion.setFilePath("");
        stub.addContractVersion(contractVersion);
    }

}
