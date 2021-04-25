package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableSledCommodityChange;
import com.longsheng.xueqiao.contract.dao.thriftapi.*;
import com.longsheng.xueqiao.contract.dao.utils.DaoUtil;
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
import java.util.List;

public class SledCommodityChangeHandler extends TableHandler {


    public SledCommodityChangeHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public int insert(TSledCommodityChange tSledCommodityChange) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = new PreparedFields();
        if (tSledCommodityChange.isSetSledCommodityId()) {
            fields.addInt(TableSledCommodityChange.COLUMN_FSLED_COMMODITY_ID, tSledCommodityChange.getSledCommodityId());
        }
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledCommodityChange fields must set.");
        }

        fields.addInt(TableSledCommodityChange.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableSledCommodityChange.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSledCommodityChange.TABLE_NAME, fields);

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
        return tSledCommodityChange.getSledCommodityId();
    }

    public boolean remove(int tSledCommodityId) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            String deleteStr = "delete from " + TableSledCommodityChange.TABLE_NAME + " where " + TableSledCommodityChange.COLUMN_FSLED_COMMODITY_ID + " = " + tSledCommodityId;
            runner.update(conn, deleteStr);
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
        return true;
    }

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(TableSledCommodityChange.COLUMN_FSLED_COMMODITY_ID,
                TableSledCommodityChange.COLUMN_FCREATE_TIMESTAMP,
                TableSledCommodityChange.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableSledCommodityChange.TABLE_NAME);
        return sqlBuilder;
    }

    public TSledCommodityChangePage query(ReqTSledCommodityChangeOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();

        if (option.isSetSledCommodityIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledCommodityChange.COLUMN_FSLED_COMMODITY_ID, DaoUtil.map2Set(option.getSledCommodityIds()));
        }

        QueryRunner runner = new QueryRunner();
        sqlBuilder.setPage(pageIndex, pageSize);
        Connection conn = getConnection();
        try {
            AppLog.d("query sql: " + sqlBuilder.getItemsSql());
            TSledCommodityChangePage page = new TSledCommodityChangePage();
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(),
                    sqlBuilder.getParameterList()).intValue();

            List<TSledCommodityChange> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSledCommodityChangeHandler(),
                    sqlBuilder.getParameterList());
            page.setTotal(total);
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

    private class TSledCommodityChangeHandler extends AbstractListHandler<TSledCommodityChange> {

        @Override
        protected TSledCommodityChange handleRow(ResultSet rs) throws SQLException {
            TSledCommodityChange info = new TSledCommodityChange();
            info.setSledCommodityId(rs.getInt(TableSledCommodityChange.COLUMN_FSLED_COMMODITY_ID));
            info.setCreateTimestamp(rs.getLong(TableSledCommodityChange.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getLong(TableSledCommodityChange.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }

}
