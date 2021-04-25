package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableCommoditySource;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySource;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySourcePage;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceOption;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.dal_set.DbUtil;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class CommoditySourceHandler extends TableHandler {

    public CommoditySourceHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(CommoditySource commoditySource) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(commoditySource);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommoditySource fields must set.");
        }

        fields.addInt(TableCommoditySource.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableCommoditySource.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableCommoditySource.TABLE_NAME, fields);

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

    private PreparedFields prepareFields(CommoditySource commoditySource) {
        PreparedFields fields = new PreparedFields();
        if (commoditySource.isSetExchangeMic()) {
            fields.addString(TableCommoditySource.COLUMN_FEXCHANGE_MIC, StringUtils.join(commoditySource.getExchangeMic(), ","));
        }
        if (commoditySource.isSetTechPlatformEnv()) {
            fields.addInt(TableCommoditySource.COLUMN_FTECH_PLATFORM_ENV, commoditySource.getTechPlatformEnv().getValue());
        }
        if (commoditySource.isSetTechPlatformSource()) {
            fields.addInt(TableCommoditySource.COLUMN_FTECH_PLATFORM, commoditySource.getTechPlatformSource().getValue());
        }
        return fields;
    }

    public void update(CommoditySource commoditySource) throws ErrorInfo {

        if (!commoditySource.isSetSourceId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommoditySource field SourceId must set.");
        }
        PreparedFields fields = prepareFields(commoditySource);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommoditySource fields must set.");
        }
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableCommoditySource.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableCommoditySource.TABLE_NAME, fields);
        String condition = TableCommoditySource.COLUMN_FSOURCE_ID + "=" + commoditySource.getSourceId();
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

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableCommoditySource.COLUMN_FSOURCE_ID,
                TableCommoditySource.COLUMN_FEXCHANGE_MIC,
                TableCommoditySource.COLUMN_FTECH_PLATFORM,
                TableCommoditySource.COLUMN_FTECH_PLATFORM_ENV,
                TableCommoditySource.COLUMN_FCREATE_TIMESTAMP,
                TableCommoditySource.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableCommoditySource.TABLE_NAME);
        return sqlBuilder;
    }

    public CommoditySourcePage query(ReqCommoditySourceOption option) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.getSourceIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableCommoditySource.COLUMN_FSOURCE_ID,
                    option.getSourceIds());
        }

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            CommoditySourcePage page = new CommoditySourcePage();
            if (option.isSetPageOption()) {
                if (option.getPageOption().isNeedTotalCount()) {
                    int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
                    page.setTotal(total);
                }
                if (option.getPageOption().getPageSize() > 0) {
                    sqlBuilder.setPage(option.getPageOption().getPageIndex(), option.getPageOption().getPageSize());
                }
            }
            List<CommoditySource> list = runner.query(conn, sqlBuilder.getItemsSql(), new TCommoditySourceHandler(),
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

    private class TCommoditySourceHandler extends AbstractListHandler<CommoditySource> {

        @Override
        protected CommoditySource handleRow(ResultSet rs) throws SQLException {
            CommoditySource info = new CommoditySource();
            info.setSourceId(rs.getInt(TableCommoditySource.COLUMN_FSOURCE_ID));
            String[] exchangeMics = StringUtils.split(rs.getString(TableCommoditySource.COLUMN_FEXCHANGE_MIC), ",");
            info.setExchangeMic(Arrays.asList(exchangeMics));
            info.setTechPlatformEnv(TechPlatformEnv.findByValue(rs.getInt(TableCommoditySource.COLUMN_FTECH_PLATFORM_ENV)));
            info.setTechPlatformSource(TechPlatform.findByValue(rs.getInt(TableCommoditySource.COLUMN_FTECH_PLATFORM)));
            info.setCreateTimestamp(rs.getLong(TableCommoditySource.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModifyTimestamp(rs.getLong(TableCommoditySource.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }
}
