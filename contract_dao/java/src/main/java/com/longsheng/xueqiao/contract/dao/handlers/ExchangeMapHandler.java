package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableExchangeMap;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledExchangeMappingOption;
import com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping;
import com.longsheng.xueqiao.contract.thriftapi.SledExchangeMappingPage;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.dal_set.DbUtil;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExchangeMapHandler extends TableHandler {

    public ExchangeMapHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(SledExchangeMapping sledExchangeMapping) throws ErrorInfo {
        PreparedFields fields = getPreparedFields(sledExchangeMapping);
        int createTime = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableExchangeMap.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableExchangeMap.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableExchangeMap.TABLE_NAME, fields);

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

    private PreparedFields getPreparedFields(SledExchangeMapping sledExchangeMapping) {
        PreparedFields fields = new PreparedFields();

        if (sledExchangeMapping.isSetTechPlatform()) {
            fields.addInt(TableExchangeMap.COLUMN_FTECH_PLATFORM, sledExchangeMapping.getTechPlatform().getValue());
        }
        if (sledExchangeMapping.isSetSledExchangeMic()) {
            fields.addString(TableExchangeMap.COLUMN_FSLED_EXCHANGE_MIC, sledExchangeMapping.getSledExchangeMic());
        }
        if (sledExchangeMapping.isSetTechPlatformExchangeCode()) {
            fields.addString(TableExchangeMap.COLUMN_FPLATFORM_EXCHANGE, sledExchangeMapping.getTechPlatformExchangeCode());
        }

        return fields;
    }


    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableExchangeMap.COLUMN_FMAPPING_ID,
                TableExchangeMap.COLUMN_FSLED_EXCHANGE_MIC,
                TableExchangeMap.COLUMN_FTECH_PLATFORM,
                TableExchangeMap.COLUMN_FPLATFORM_EXCHANGE,
                TableExchangeMap.COLUMN_FCREATE_TIMESTAMP,
                TableExchangeMap.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableExchangeMap.TABLE_NAME);
        return sqlBuilder;
    }

    public SledExchangeMappingPage query(ReqSledExchangeMappingOption option) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.isSetMappingIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableExchangeMap.COLUMN_FMAPPING_ID, option.getMappingIds());
        }
        if (option.isSetSledExchangeMic()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableExchangeMap.COLUMN_FSLED_EXCHANGE_MIC + "=?", option.getSledExchangeMic());
        }
        if (option.isSetTechPlatform()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableExchangeMap.COLUMN_FTECH_PLATFORM + "=?", option.getTechPlatform().getValue());
        }
        if (option.isSetTechPlatformExchangeCode()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableExchangeMap.COLUMN_FPLATFORM_EXCHANGE + "=?", option.getTechPlatformExchangeCode());
        }

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();

        try {
            SledExchangeMappingPage page = new SledExchangeMappingPage();

            if (option.isSetPageOption()) {
                if (option.getPageOption().isNeedTotalCount()) {
                    page.setTotal(runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue());
                }
                if (option.getPageOption().getPageSize() > 0) {
                    sqlBuilder.setPage(option.getPageOption().getPageIndex(), option.getPageOption().getPageSize());
                }
            }

            page.setPage(runner.query(conn, sqlBuilder.getItemsSql(), new TExchangeMappingHandler(),
                    sqlBuilder.getParameterList()));

            return page;
        } catch (SQLException e) {
            AppLog.e("Error occurs at query.", e);
            throw new ErrorInfo(ErrorCodeInner.DB_SELECT_FAILED.getErrorCode(),
                    ErrorCodeInner.DB_SELECT_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public void update(SledExchangeMapping sledExchangeMapping) throws ErrorInfo {

        if (!sledExchangeMapping.isSetMappingId()) {
            throw new IllegalArgumentException("SledExchangeMapping mappingId must set.");
        }

        PreparedFields fields = getPreparedFields(sledExchangeMapping);

        int createTime = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableExchangeMap.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer updateSqlBuffer = getTableUpdateSqlBuffer(TableExchangeMap.TABLE_NAME, fields);
        String condition = TableExchangeMap.COLUMN_FMAPPING_ID + "=" + sledExchangeMapping.getMappingId();
        updateSqlBuffer.append(condition);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            runner.update(conn, updateSqlBuffer.toString(), fields.getParameters());
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public void deleteExchangeMapping(QueryRunner runner,
                                      Connection conn, String exchangeMic) throws SQLException {
        String deleteSql = "delete from " + TableExchangeMap.TABLE_NAME + " where " + TableExchangeMap.COLUMN_FSLED_EXCHANGE_MIC + " =?";
        runner.update(conn, deleteSql, exchangeMic);
    }

    private class TExchangeMappingHandler extends AbstractListHandler<SledExchangeMapping> {

        @Override
        protected SledExchangeMapping handleRow(ResultSet rs) throws SQLException {
            SledExchangeMapping info = new SledExchangeMapping();
            info.setMappingId(rs.getInt(TableExchangeMap.COLUMN_FMAPPING_ID));
            info.setSledExchangeMic(rs.getString(TableExchangeMap.COLUMN_FSLED_EXCHANGE_MIC));
            info.setTechPlatform(TechPlatform.findByValue(rs.getInt(TableExchangeMap.COLUMN_FTECH_PLATFORM)));
            info.setTechPlatformExchangeCode(rs.getString(TableExchangeMap.COLUMN_FPLATFORM_EXCHANGE));
            info.setCreateTimestamp(rs.getLong(TableExchangeMap.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModifyTimestamp(rs.getLong(TableExchangeMap.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }
}
