package com.longsheng.xueqiao.contract.dao.handlers;

import java.sql.Connection;

import org.soldier.base.sql.PreparedFields;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;

public abstract class TableHandler {

    protected IConnectionProvider provider;

    public TableHandler(IConnectionProvider provider) throws ErrorInfo {
        this.provider = provider;
    }

    public Connection getConnection() throws ErrorInfo {
        return this.provider.getConnection();
    }

    protected static StringBuffer getInsertTableSqlBuffer(String tableName, PreparedFields fields) {
        StringBuffer giftTableSqlBuffer = new StringBuffer(128);
        giftTableSqlBuffer.append("INSERT INTO ");
        giftTableSqlBuffer.append(tableName);
        giftTableSqlBuffer.append(" SET ");
        giftTableSqlBuffer.append(fields.getPreparedSql());
        return giftTableSqlBuffer;
    }

    protected static StringBuffer getTableUpdateSqlBuffer(String tableName, PreparedFields fields) {
        StringBuffer sqlBuffer = new StringBuffer(128);
        sqlBuffer.append("UPDATE ");
        sqlBuffer.append(tableName);
        sqlBuffer.append(" SET ");
        sqlBuffer.append(fields.getPreparedSql());
        sqlBuffer.append(" WHERE ");
        return sqlBuffer;
    }
}
