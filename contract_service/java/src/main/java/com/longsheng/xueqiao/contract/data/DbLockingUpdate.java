package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.ContractManageErrorCode;
import com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class DbLockingUpdate {

    private ContractDaoServiceStub stub = new ContractDaoServiceStub();

    public void addLocking(DbLockingInfo dbLockingInfo) throws TException {
        DbLockingAccess access = new DbLockingAccess();
        DbLockingInfo info = access.reqDbLocking();
        if (info.isIsLocked()) {
            throw new ErrorInfo(ContractManageErrorCode.DATABASE_LOCKED.getValue(), "db is locked.");
        }
        stub.addDbLocking(dbLockingInfo);
    }

    public void removeLocking(String lockingBy) throws TException {

        DbLockingAccess access = new DbLockingAccess();
        DbLockingInfo info = access.reqDbLocking();
        if (StringUtils.isNotEmpty(info.getLockedBy())) {
            if (lockingBy.equals(info.getLockedBy())) {
                stub.removeDbLocking(lockingBy);
            } else {
                throw new ErrorInfo(ContractManageErrorCode.DATABASE_LOCKED_BY_OTHER.getValue(), "db is locked by other.");
            }
        }
    }
}
