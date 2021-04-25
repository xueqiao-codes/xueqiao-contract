package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableTechPlatformCommodity;
import com.longsheng.xueqiao.contract.dao.utils.DaoUtil;
import com.longsheng.xueqiao.contract.dao.utils.JsonFactory;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.soldier.base.file.IFileListener;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.dal_set.DbUtil;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import org.soldier.platform.svr_platform.util.ProtocolUtil;

import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlatformCommodityHandler extends TableHandler {


    public PlatformCommodityHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(TechPlatformCommodity techPlatformCommodity) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(techPlatformCommodity);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SyncMappingTask fields must set.");
        }
        ByteBuffer data = ProtocolUtil.serialize(JsonFactory.getInstance().getFactory(), techPlatformCommodity);
        fields.addString(TableTechPlatformCommodity.COLUMN_FCONTENT, new String(data.array()));
        fields.addInt(TableTechPlatformCommodity.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableTechPlatformCommodity.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableTechPlatformCommodity.TABLE_NAME, fields);
        StringBuffer updateSqlBuffer = getTableUpdateSqlBuffer(TableTechPlatformCommodity.TABLE_NAME, fields);
        String condition = TableTechPlatformCommodity.COLUMN_FSLED_COMMODITY_ID + "=" + techPlatformCommodity.getSledCommodityId();
        updateSqlBuffer.append(condition);

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

    private PreparedFields prepareFields(TechPlatformCommodity techPlatformCommodity) {
        PreparedFields fields = new PreparedFields();
        if (techPlatformCommodity.isSetSledCommodityId()) {
            fields.addInt(TableTechPlatformCommodity.COLUMN_FSLED_COMMODITY_ID, techPlatformCommodity.getSledCommodityId());
        }
        if (techPlatformCommodity.isSetTechPlatform()) {
            fields.addInt(TableTechPlatformCommodity.COLUMN_FTECH_PLATFORM, techPlatformCommodity.getTechPlatform().getValue());
        }
        if (techPlatformCommodity.isSetExchange()) {
            fields.addString(TableTechPlatformCommodity.COLUMN_FPLATFORM_EXCHANGE, techPlatformCommodity.getExchange());
        }
        if (techPlatformCommodity.isSetCommodityType()) {
            fields.addString(TableTechPlatformCommodity.COLUMN_FPLATFORM_COMMODITY_TYPE, techPlatformCommodity.getCommodityType());
        }
        if (techPlatformCommodity.isSetCommodityCode()) {
            fields.addString(TableTechPlatformCommodity.COLUMN_FPLATFORM_COMMODITY_CODE, techPlatformCommodity.getCommodityCode());
        }
        return fields;
    }

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableTechPlatformCommodity.COLUMN_FCONTENT,
                TableTechPlatformCommodity.COLUMN_FPLATFORM_COMMODITY_CODE,
                TableTechPlatformCommodity.COLUMN_FPLATFORM_COMMODITY_TYPE,
                TableTechPlatformCommodity.COLUMN_FPLATFORM_EXCHANGE,
                TableTechPlatformCommodity.COLUMN_FTECH_PLATFORM,
                TableTechPlatformCommodity.COLUMN_FSLED_COMMODITY_ID,
                TableTechPlatformCommodity.COLUMN_FTECH_PLATFORM_COMMODITY_ID,
                TableTechPlatformCommodity.COLUMN_FLAST_MODIFY_TIMESTAMP,
                TableTechPlatformCommodity.COLUMN_FCREATE_TIMESTAMP);
        sqlBuilder.addTables(TableTechPlatformCommodity.TABLE_NAME);
        return sqlBuilder;
    }

    public TechPlatformCommodityPage query(ReqTechPlatformCommodityOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();

        if (option.isSetTechPlatformCommodityIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableTechPlatformCommodity.COLUMN_FTECH_PLATFORM_COMMODITY_ID, DaoUtil.map2Set(option.getTechPlatformCommodityIds()));
        }
        if (option.isSetSledCommodityIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableTechPlatformCommodity.COLUMN_FSLED_COMMODITY_ID, DaoUtil.map2Set(option.getSledCommodityIds()));
        }
        if (option.isSetTechPlatform()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableTechPlatformCommodity.COLUMN_FTECH_PLATFORM + "=?", option.getTechPlatform().getValue());
        }
        if (option.isSetTechPlatformExchange()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableTechPlatformCommodity.COLUMN_FPLATFORM_EXCHANGE + "=?", option.getTechPlatformExchange());
        }
        if (option.isSetTechPlatformCommodityType()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableTechPlatformCommodity.COLUMN_FPLATFORM_COMMODITY_TYPE + "=?", option.getTechPlatformCommodityType());
        }
        if (option.isSetTechPlatformCommodityCode()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableTechPlatformCommodity.COLUMN_FPLATFORM_COMMODITY_CODE + "=?", option.getTechPlatformCommodityCode());
        }

        sqlBuilder.setPage(pageIndex, pageSize);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            TechPlatformCommodityPage page = new TechPlatformCommodityPage();
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
            page.setTotal(total);
            List<TechPlatformCommodity> list = runner.query(conn, sqlBuilder.getItemsSql(), new TTechPlatformCommodityHandler(),
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

    private class TTechPlatformCommodityHandler extends AbstractListHandler<TechPlatformCommodity> {

        @Override
        protected TechPlatformCommodity handleRow(ResultSet rs) throws SQLException {
            TechPlatformCommodity info = null;
            String json = rs.getString(TableTechPlatformCommodity.COLUMN_FCONTENT);
            byte[] data = null;
            try {
                if (json != null && !"".equals(json.trim())) {
                    data = json.getBytes("utf-8");
                }
            } catch (Throwable e) {
                AppLog.e(e.getMessage(), e);
            }
            if (data != null) {
                info = ProtocolUtil.unSerialize(JsonFactory.getInstance().getFactory(), data, TechPlatformCommodity.class);
            } else {
                info = new TechPlatformCommodity();
            }
            info.setSledCommodityId(rs.getInt(TableTechPlatformCommodity.COLUMN_FTECH_PLATFORM_COMMODITY_ID));
            info.setCreateTimestamp(rs.getLong(TableTechPlatformCommodity.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getLong(TableTechPlatformCommodity.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }

    public void clear(TechPlatform techPlatform) throws ErrorInfo {
        if (techPlatform == null) {
            return;
        }
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {

            String deleteSql = "delete from " + TableTechPlatformCommodity.TABLE_NAME + " where " + TableTechPlatformCommodity.COLUMN_FTECH_PLATFORM + " =?";
            runner.update(conn, deleteSql, techPlatform.getValue());
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }
}