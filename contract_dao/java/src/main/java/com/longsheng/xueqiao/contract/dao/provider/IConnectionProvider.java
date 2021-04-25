package com.longsheng.xueqiao.contract.dao.provider;

import java.sql.Connection;

import org.soldier.platform.svr_platform.comm.ErrorInfo;

public interface IConnectionProvider {
    Connection getConnection() throws ErrorInfo;
}
