package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableSyncMappingTask;
import com.longsheng.xueqiao.contract.dao.utils.DaoUtil;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv;
import com.longsheng.xueqiao.contract.thriftapi.ReqSyncMappingTaskOption;
import com.longsheng.xueqiao.contract.thriftapi.SyncMappingTask;
import com.longsheng.xueqiao.contract.thriftapi.SyncMappingTaskPage;
import com.longsheng.xueqiao.contract.thriftapi.SyncTaskType;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.dal_set.DbUtil;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class SyncMappingHandler extends TableHandler {

    public SyncMappingHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(SyncMappingTask syncMappingTask) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(syncMappingTask);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SyncMappingTask fields must set.");
        }
        fields.addInt(TableSyncMappingTask.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableSyncMappingTask.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSyncMappingTask.TABLE_NAME, fields);

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public void insert(Connection conn, QueryRunner runner, SyncMappingTask syncMappingTask) throws ErrorInfo, SQLException {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(syncMappingTask);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SyncMappingTask fields must set.");
        }
        fields.addInt(TableSyncMappingTask.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableSyncMappingTask.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSyncMappingTask.TABLE_NAME, fields);
        runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
    }

    private PreparedFields prepareFields(SyncMappingTask syncMappingTask) {
        PreparedFields fields = new PreparedFields();
        if (syncMappingTask.isSetTechPlatformEnv()) {
            fields.addInt(TableSyncMappingTask.COLUMN_FPLATFORM_ENV, syncMappingTask.getTechPlatformEnv().getValue());
        }
        if (syncMappingTask.isSetSyncTargetId()) {
            fields.addInt(TableSyncMappingTask.COLUMN_FSYNC_TARGET_ID, syncMappingTask.getSyncTargetId());
        }
        if (syncMappingTask.isSetTaskType()) {
            fields.addInt(TableSyncMappingTask.COLUMN_FTASK_TYPE, syncMappingTask.getTaskType().getValue());
        }
        return fields;
    }

    public void update(SyncMappingTask syncMappingTask) throws ErrorInfo {

        if (!syncMappingTask.isSetTaskId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SyncMappingTask field TaskId must set.");
        }
        PreparedFields fields = prepareFields(syncMappingTask);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SyncMappingTask fields must set.");
        }
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableSyncMappingTask.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableSyncMappingTask.TABLE_NAME, fields);
        String condition = TableSyncMappingTask.COLUMN_FTASK_ID + "=" + syncMappingTask.getTaskId();
        sqlBuffer.append(condition);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            runner.update(conn, sqlBuffer.toString(), fields.getParameters());
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public void setInActive(ReqSyncMappingTaskOption option) throws ErrorInfo {
        PreparedFields fields = new PreparedFields();
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableSyncMappingTask.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        fields.addInt(TableSyncMappingTask.COLUMN_FSTATUS, 1);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableSyncMappingTask.TABLE_NAME, fields);

        boolean isFirst = true;
        if (option.isSetTechPlatformEnv()) {

            String condition = TableSyncMappingTask.COLUMN_FPLATFORM_ENV + " = " + option.getTechPlatformEnv().getValue();
            sqlBuffer.append(isFirst ? " " : " AND ");
            sqlBuffer.append("(");
            sqlBuffer.append(condition);
            sqlBuffer.append(")");
            isFirst = false;
        }
        if (option.isSetTargetIds()) {
            String condition = getCondition(TableSyncMappingTask.COLUMN_FSYNC_TARGET_ID, option.getTargetIds());
            sqlBuffer.append(isFirst ? " " : " AND ");
            sqlBuffer.append("(");
            sqlBuffer.append(condition);
            sqlBuffer.append(")");
            isFirst = false;
        }
        if (option.isSetTaskIds()) {
            String condition = getCondition(TableSyncMappingTask.COLUMN_FTASK_ID, option.getTaskIds());
            sqlBuffer.append(isFirst ? " " : " AND ");
            sqlBuffer.append("(");
            sqlBuffer.append(condition);
            sqlBuffer.append(")");
            isFirst = false;
        }
        if (option.isSetTaskType()) {
            String condition = TableSyncMappingTask.COLUMN_FTASK_TYPE + " = " + option.getTaskType().getValue();
            sqlBuffer.append(isFirst ? " " : " AND ");
            sqlBuffer.append("(");
            sqlBuffer.append(condition);
            sqlBuffer.append(")");
            isFirst = false;
        }

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            runner.update(conn, sqlBuffer.toString(), fields.getParameters());
            String deleteStr = "delete from " + TableSyncMappingTask.TABLE_NAME + " where " + TableSyncMappingTask.COLUMN_FSTATUS + " =1";
            runner.update(conn, deleteStr);
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    private String getCondition(String field, List<Integer> ids) {
        StringBuffer condition = new StringBuffer(128);
        condition.append(field + " IN (");
        Iterator iterator = ids.iterator();

        while (iterator.hasNext()) {
            condition.append(iterator.next());
            if (iterator.hasNext()) {
                condition.append(",");
            }
        }
        condition.append(")");
        return condition.toString();
    }

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableSyncMappingTask.COLUMN_FTASK_ID,
                TableSyncMappingTask.COLUMN_FSYNC_TARGET_ID,
                TableSyncMappingTask.COLUMN_FPLATFORM_ENV,
                TableSyncMappingTask.COLUMN_FTASK_TYPE,
                TableSyncMappingTask.COLUMN_FCREATE_TIMESTAMP,
                TableSyncMappingTask.COLUMN_FSTATUS,
                TableSyncMappingTask.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableSyncMappingTask.TABLE_NAME);
        return sqlBuilder;
    }

    public SyncMappingTaskPage query(ReqSyncMappingTaskOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();

        if (option.isSetTaskIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSyncMappingTask.COLUMN_FTASK_ID, DaoUtil.map2Set(option.getTaskIds()));
        }
        if (option.isSetTargetIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSyncMappingTask.COLUMN_FSYNC_TARGET_ID, DaoUtil.map2Set(option.getTargetIds()));
        }
        if (option.isSetTechPlatformEnv()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSyncMappingTask.COLUMN_FPLATFORM_ENV + "=?", option.getTechPlatformEnv().getValue());
        }

        sqlBuilder.setPage(pageIndex, pageSize);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            SyncMappingTaskPage page = new SyncMappingTaskPage();
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
            page.setTotal(total);
            List<SyncMappingTask> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSyncMappingTaskHandler(),
                    sqlBuilder.getParameterList());
            page.setPage(list);
            return page;
        } catch (SQLException e) {
            AppLog.e("Error occurs at query.", e);
            throw new ErrorInfo(ErrorCodeInner.DB_SELECT_FAILED.getErrorCode(),
                    ErrorCodeInner.DB_SELECT_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    private class TSyncMappingTaskHandler extends AbstractListHandler<SyncMappingTask> {

        @Override
        protected SyncMappingTask handleRow(ResultSet rs) throws SQLException {
            SyncMappingTask info = new SyncMappingTask();
            info.setTaskId(rs.getInt(TableSyncMappingTask.COLUMN_FTASK_ID));
            info.setSyncTargetId(rs.getInt(TableSyncMappingTask.COLUMN_FSYNC_TARGET_ID));
            info.setTechPlatformEnv(TechPlatformEnv.findByValue(rs.getInt(TableSyncMappingTask.COLUMN_FPLATFORM_ENV)));
            info.setTaskType(SyncTaskType.findByValue(rs.getInt(TableSyncMappingTask.COLUMN_FTASK_TYPE)));
            info.setCreateTimestamp(rs.getLong(TableSyncMappingTask.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getLong(TableSyncMappingTask.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }
}