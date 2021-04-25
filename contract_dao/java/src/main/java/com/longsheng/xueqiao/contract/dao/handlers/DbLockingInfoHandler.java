package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableDbLockingInfo;
import com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.soldier.base.logger.AppLog;

import org.soldier.base.sql.DbUtil;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DbLockingInfoHandler extends TableHandler {
    public DbLockingInfoHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(DbLockingInfo dbLockingInfo) throws ErrorInfo {
        if (!dbLockingInfo.isSetLockedBy() || "".equals(dbLockingInfo.getLockedBy())) {
            throw new IllegalArgumentException("lockedBy must set");
        }

        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(dbLockingInfo);

        fields.addInt(TableDbLockingInfo.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableDbLockingInfo.COLUMN_FSTART_LOCKED_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableDbLockingInfo.TABLE_NAME, fields);

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();

        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        try {
            conn.setAutoCommit(false);
            List<DbLockingInfo> list = runner.query(conn, sqlBuilder.getItemsSql() + " for update", new TDbLockingInfoHandler(),
                    sqlBuilder.getParameterList());
            if (list.size() > 0) {
                throw new ErrorInfo(ErrorCodeInner.ILLEGAL_OPERATION_ERROR.getErrorCode(),
                        "Db is already locked.");
            }

            runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                AppLog.e(e1.getMessage(), e1);
            }
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    private PreparedFields prepareFields(DbLockingInfo dbLockingInfo) {
        PreparedFields fields = new PreparedFields();
        if (dbLockingInfo.isSetLockedBy()) {
            fields.addString(TableDbLockingInfo.COLUMN_FLOCKED_BY, dbLockingInfo.getLockedBy());
        }
        if (dbLockingInfo.isSetLockArea()) {
            fields.addString(TableDbLockingInfo.COLUMN_FLOCK_AREA, dbLockingInfo.getLockArea());
        }

        return fields;
    }

    public void remove(String lockedBy) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            String deleteStr = "delete from " + TableDbLockingInfo.TABLE_NAME;
            String condition;
            if ("".equals(lockedBy) || lockedBy == null) {
                throw new IllegalArgumentException("lockedBy must set.");
            } else {
                condition = " where " + TableDbLockingInfo.COLUMN_FLOCKED_BY + " = ?";
            }
            deleteStr = deleteStr + condition;
            runner.update(conn, deleteStr, lockedBy);
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }


    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableDbLockingInfo.COLUMN_F_ID,
                TableDbLockingInfo.COLUMN_FLOCKED_BY,
                TableDbLockingInfo.COLUMN_FLOCK_AREA,
                TableDbLockingInfo.COLUMN_FCREATE_TIMESTAMP,
                TableDbLockingInfo.COLUMN_FSTART_LOCKED_TIMESTAMP);
        sqlBuilder.addTables(TableDbLockingInfo.TABLE_NAME);
        return sqlBuilder;
    }

    public DbLockingInfo query() throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {

            List<DbLockingInfo> list = runner.query(conn, sqlBuilder.getItemsSql(), new TDbLockingInfoHandler(),
                    sqlBuilder.getParameterList());

            if (list.size() > 1) {
                throw new ErrorInfo(ErrorCodeInner.ILLEGAL_OPERATION_ERROR.getErrorCode(),
                        "Db lock info error, more than 1 locking record.");
            }
            if (list.size() == 1) {
                return list.get(0);
            }
            return new DbLockingInfo();
        } catch (SQLException e) {
            AppLog.e("Error occurs at query.", e);
            throw new ErrorInfo(ErrorCodeInner.DB_SELECT_FAILED.getErrorCode(),
                    ErrorCodeInner.DB_SELECT_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    private class TDbLockingInfoHandler extends AbstractListHandler<DbLockingInfo> {

        @Override
        protected DbLockingInfo handleRow(ResultSet rs) throws SQLException {
            DbLockingInfo info = new DbLockingInfo();
            info.setIsLocked(true);
            info.setLockedBy(rs.getString(TableDbLockingInfo.COLUMN_FLOCKED_BY));
            info.setLockArea(rs.getString(TableDbLockingInfo.COLUMN_FLOCK_AREA));
            info.setCreateTimestamp(rs.getLong(TableDbLockingInfo.COLUMN_FCREATE_TIMESTAMP));
            info.setStartLockedTimestamp(rs.getLong(TableDbLockingInfo.COLUMN_FSTART_LOCKED_TIMESTAMP));
            return info;
        }
    }
}
