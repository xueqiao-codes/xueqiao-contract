package com.longsheng.xueqiao.contract.sync;

import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledCommodityOption;
import com.longsheng.xueqiao.contract.data.ContractVersionUpdate;
import com.longsheng.xueqiao.contract.data.DbLockingUpdate;
import com.longsheng.xueqiao.contract.data.SledCommodityAccess;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class ContractSyncer implements Runnable {

    private String mUserName;

    public ContractSyncer(String userName) {
        mUserName = userName;

    }

    private void checkContractWorking() throws TException {
        SledCommodityAccess access = new SledCommodityAccess();
        ReqTSledCommodityOption tOption = new ReqTSledCommodityOption();
        tOption.setWorkingStatus(WorkingStatus.NOT_WORKING.getValue());

        SledCommodityEditPage page = access.getSledCommodityEditPage(0, 1, tOption);
        if (page.getPageSize() > 0) {
            throw new ErrorInfo(ContractManageErrorCode.SLED_COMMODITY_NOT_WORKING.getValue(), page.getTotal() + " sled commodity not working.");
        }
    }

    public void checkContractEdit() throws TException {
        ReqTSledCommodityOption tOption = new ReqTSledCommodityOption();
        tOption.setWorkingStatus(WorkingStatus.WORKING.getValue());
        tOption.setEditstatus(EditStatus.EDIT.getValue());
        SledCommodityAccess access = new SledCommodityAccess();
        SledCommodityEditPage tPage = access.getSledCommodityEditPage(0, 1, tOption);
        if (tPage.getTotal() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (SledCommodityEdit edit : tPage.getPage()) {
                stringBuilder.append(edit.getSledCommodity().getExchangeMic());
                stringBuilder.append("-");
                stringBuilder.append(edit.getSledCommodity().getSledCommodityType().name());
                stringBuilder.append("-");
                stringBuilder.append(edit.getSledCommodity().getSledCommodityCode());
                stringBuilder.append(",");
            }
            throw new ErrorInfo(ContractManageErrorCode.SLED_COMMODITY_NOT_VERIFY.getValue(), " Working sled commodity not verify: " + stringBuilder.toString());
        }
    }

    public void unlockDb() throws TException {
        new DbLockingUpdate().removeLocking(mUserName);
    }

    private void lockDb() throws TException {
        DbLockingInfo lockInfo = new DbLockingInfo();
        lockInfo.setLockedBy(mUserName);
        lockInfo.setLockArea("ALL");
        new DbLockingUpdate().addLocking(lockInfo);
    }

    @Override
    public void run() {
        try {
            mUserName = "System";
            lockDb();
            new TradeTimeSyncer().runOnce();
            new ContractVersionUpdate().addSyncTask();
            unlockDb();
        } catch (Exception e) {
            AppLog.e(e.getMessage(), e);
        }

    }
}
