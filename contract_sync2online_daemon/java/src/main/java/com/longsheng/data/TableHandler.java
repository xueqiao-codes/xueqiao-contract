package com.longsheng.data;

import com.antiy.error_code.ErrorCodeInner;
import org.apache.commons.dbutils.QueryRunner;
import org.soldier.base.sql.PreparedFields;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;

public abstract class TableHandler {

    protected Connection conn;
    protected QueryRunner runner;

    public TableHandler(Connection connection, QueryRunner queryRunner) throws ErrorInfo {
        this.conn = connection;
        this.runner = queryRunner;
    }

    public Connection getConnection() throws ErrorInfo {
        if (this.conn == null) {
            throw new ErrorInfo(ErrorCodeInner.DB_CONNECT_FAILED.getErrorCode(),
                    ErrorCodeInner.DB_CONNECT_FAILED.getErrorMsg());
        }
        return this.conn;
    }

    protected StringBuffer getInsertTableSqlBuffer(String tableName, PreparedFields fields) {
        StringBuffer giftTableSqlBuffer = new StringBuffer(128);
        giftTableSqlBuffer.append("INSERT INTO ");
        giftTableSqlBuffer.append(tableName);
        giftTableSqlBuffer.append(" SET ");
        giftTableSqlBuffer.append(fields.getPreparedSql());
        return giftTableSqlBuffer;
    }
}
