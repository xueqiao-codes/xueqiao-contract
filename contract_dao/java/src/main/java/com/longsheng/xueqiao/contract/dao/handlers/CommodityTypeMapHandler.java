package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableCommodityTypeMap;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledCommodityTypeMappingOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMappingPage;
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

public class CommodityTypeMapHandler extends TableHandler {

    public CommodityTypeMapHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(SledCommodityTypeMapping sledExchangeMapping) throws ErrorInfo {
        PreparedFields fields = getPreparedFields(sledExchangeMapping);
        int createTime = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableCommodityTypeMap.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableCommodityTypeMap.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableCommodityTypeMap.TABLE_NAME, fields);
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

    private PreparedFields getPreparedFields(SledCommodityTypeMapping sledExchangeMapping) {
        PreparedFields fields = new PreparedFields();

        if (sledExchangeMapping.isSetTechPlatform()) {
            fields.addInt(TableCommodityTypeMap.COLUMN_FTECH_PLATFORM, sledExchangeMapping.getTechPlatform().getValue());
        }
        if (sledExchangeMapping.isSetSledCommodityType()) {
            fields.addInt(TableCommodityTypeMap.COLUMN_FSLED_COMMODITY_TYPE, sledExchangeMapping.getSledCommodityType().getValue());
        }
        if (sledExchangeMapping.isSetTechPlatformCommodityType()) {
            fields.addString(TableCommodityTypeMap.COLUMN_FPLATFORM_COMMODITY_TYPE, sledExchangeMapping.getTechPlatformCommodityType());
        }

        return fields;
    }


    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableCommodityTypeMap.COLUMN_FMAPPING_ID,
                TableCommodityTypeMap.COLUMN_FSLED_COMMODITY_TYPE,
                TableCommodityTypeMap.COLUMN_FTECH_PLATFORM,
                TableCommodityTypeMap.COLUMN_FPLATFORM_COMMODITY_TYPE,
                TableCommodityTypeMap.COLUMN_FCREATE_TIMESTAMP,
                TableCommodityTypeMap.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableCommodityTypeMap.TABLE_NAME);
        return sqlBuilder;
    }

    public SledCommodityTypeMappingPage query(ReqSledCommodityTypeMappingOption option) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.isSetMappingIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityTypeMap.COLUMN_FMAPPING_ID, option.getMappingIds());
        }
        if (option.isSetSledCommodityType()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityTypeMap.COLUMN_FSLED_COMMODITY_TYPE + "=?", option.getSledCommodityType().getValue());
        }
        if (option.isSetTechPlatform()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityTypeMap.COLUMN_FTECH_PLATFORM + "=?", option.getTechPlatform().getValue());
        }
        if (option.isSetTechPlatformCommodityType()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityTypeMap.COLUMN_FPLATFORM_COMMODITY_TYPE + "=?", option.getTechPlatformCommodityType());
        }

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();

        try {
            SledCommodityTypeMappingPage page = new SledCommodityTypeMappingPage();

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

    public void update(SledCommodityTypeMapping sledExchangeMapping) throws ErrorInfo {

        if (!sledExchangeMapping.isSetMappingId()) {
            throw new IllegalArgumentException("SledExchangeMapping mappingId must set.");
        }

        PreparedFields fields = getPreparedFields(sledExchangeMapping);

        int createTime = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableCommodityTypeMap.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer updateSqlBuffer = getTableUpdateSqlBuffer(TableCommodityTypeMap.TABLE_NAME, fields);
        String condition = TableCommodityTypeMap.COLUMN_FMAPPING_ID + "=" + sledExchangeMapping.getMappingId();
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

    private class TExchangeMappingHandler extends AbstractListHandler<SledCommodityTypeMapping> {

        @Override
        protected SledCommodityTypeMapping handleRow(ResultSet rs) throws SQLException {
            SledCommodityTypeMapping info = new SledCommodityTypeMapping();
            info.setMappingId(rs.getInt(TableCommodityTypeMap.COLUMN_FMAPPING_ID));
            info.setSledCommodityType(SledCommodityType.findByValue(rs.getInt(TableCommodityTypeMap.COLUMN_FSLED_COMMODITY_TYPE)) );
            info.setTechPlatform(TechPlatform.findByValue(rs.getInt(TableCommodityTypeMap.COLUMN_FTECH_PLATFORM)));
            info.setTechPlatformCommodityType(rs.getString(TableCommodityTypeMap.COLUMN_FPLATFORM_COMMODITY_TYPE));
            info.setCreateTimestamp(rs.getLong(TableCommodityTypeMap.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModifyTimestamp(rs.getLong(TableCommodityTypeMap.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }
}
