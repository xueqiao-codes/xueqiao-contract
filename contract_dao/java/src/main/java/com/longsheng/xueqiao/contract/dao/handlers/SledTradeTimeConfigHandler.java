package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.google.gson.reflect.TypeToken;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableSledCommodityTradeTimeConfig;
import com.longsheng.xueqiao.contract.dao.utils.GsonFactory;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.DbUtil;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SledTradeTimeConfigHandler extends TableHandler {


    public SledTradeTimeConfigHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(SledTradeTimeConfig sledTradeTimeConfig) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            insert(sledTradeTimeConfig, runner, conn);
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public static void insert(SledTradeTimeConfig sledTradeTimeConfig, QueryRunner runner, Connection conn) throws SQLException, ErrorInfo {
        if (sledTradeTimeConfig.getSledCommodityId() <= 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SledCommodityId must set.");
        }

        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(sledTradeTimeConfig);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SledTradeTimeConfig fields must set.");
        }

        fields.addInt(TableSledCommodityTradeTimeConfig.COLUMN_FSLED_COMMODITY_ID, sledTradeTimeConfig.getSledCommodityId());
        fields.addInt(TableSledCommodityTradeTimeConfig.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableSledCommodityTradeTimeConfig.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSledCommodityTradeTimeConfig.TABLE_NAME, fields);
        runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
    }

    private static PreparedFields prepareFields(SledTradeTimeConfig sledTradeTimeConfig) {
        PreparedFields fields = new PreparedFields();
        if (sledTradeTimeConfig.isSetZoneId()) {
            fields.addString(TableSledCommodityTradeTimeConfig.COLUMN_FZONE_ID, sledTradeTimeConfig.getZoneId());
        }
        if (sledTradeTimeConfig.isSetStandardWeekTradeTimes()) {
            Map<Days, DayTradeTime> map = sledTradeTimeConfig.getStandardWeekTradeTimes();
            clearEmptyValue(map);

            String data = GsonFactory.getInstance().getGson().toJson(sledTradeTimeConfig.getStandardWeekTradeTimes());
            fields.addString(TableSledCommodityTradeTimeConfig.COLUMN_FSTANDARD_WEEK_TRADE_TIMES, data);
        }
        if (sledTradeTimeConfig.isSetDstWeekTradeTimes()) {
            Map<Days, DayTradeTime> map = sledTradeTimeConfig.getDstWeekTradeTimes();
            clearEmptyValue(map);
            String data = GsonFactory.getInstance().getGson().toJson(sledTradeTimeConfig.getDstWeekTradeTimes());
            fields.addString(TableSledCommodityTradeTimeConfig.COLUMN_FDST_WEEK_TRADE_TIMES, data);
        }
        if (sledTradeTimeConfig.isSetDstExists()) {
            fields.addInt(TableSledCommodityTradeTimeConfig.COLUMN_FDST_EXISTS, sledTradeTimeConfig.isDstExists() ? 1 : 0);
        }

        return fields;
    }

    private static void clearEmptyValue(Map<Days, DayTradeTime> map) {
        for (int i =0;i<7;i++) {
            Days days = Days.findByValue(i);
            DayTradeTime dayTradeTime = map.get(days);
            if (dayTradeTime != null) {
                if (dayTradeTime.getTTradeTimesSize() == 0 && dayTradeTime.getTPlusOneTradeTimesSize() == 0) {
                    map.remove(days);
                }
            }
        }
    }

    public void update(SledTradeTimeConfig sledTradeTimeConfig) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            update(sledTradeTimeConfig, runner, conn);
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public void batUpdate(List<SledTradeTimeConfig> configs) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            for (SledTradeTimeConfig config : configs) {
                update(config, runner, conn);
            }
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public static void update(SledTradeTimeConfig sledTradeTimeConfig, QueryRunner runner, Connection conn) throws SQLException, ErrorInfo {
        if (sledTradeTimeConfig.getSledCommodityId() <= 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SledCommodityId must set.");
        }
        PreparedFields fields = prepareFields(sledTradeTimeConfig);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SledTradeTimeConfig fields must set.");
        }
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableSledCommodityTradeTimeConfig.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableSledCommodityTradeTimeConfig.TABLE_NAME, fields);
        String condition = TableSledCommodityTradeTimeConfig.COLUMN_FSLED_COMMODITY_ID + "=" + sledTradeTimeConfig.getSledCommodityId();
        sqlBuffer.append(condition);
        runner.update(conn, sqlBuffer.toString(), fields.getParameters());
    }


    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableSledCommodityTradeTimeConfig.COLUMN_FSLED_COMMODITY_ID,
                TableSledCommodityTradeTimeConfig.COLUMN_FZONE_ID,
                TableSledCommodityTradeTimeConfig.COLUMN_FSTANDARD_WEEK_TRADE_TIMES,
                TableSledCommodityTradeTimeConfig.COLUMN_FDST_WEEK_TRADE_TIMES,
                TableSledCommodityTradeTimeConfig.COLUMN_FDST_EXISTS,
                TableSledCommodityTradeTimeConfig.COLUMN_FCREATE_TIMESTAMP,
                TableSledCommodityTradeTimeConfig.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableSledCommodityTradeTimeConfig.TABLE_NAME);
        return sqlBuilder;
    }

    public SledTradeTimeConfigPage query(ReqSledTradeTimeConfigOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.isSetSledCommodityIds() && option.getSledCommodityIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledCommodityTradeTimeConfig.COLUMN_FSLED_COMMODITY_ID,
                    option.getSledCommodityIds());
        }

        sqlBuilder.setPage(pageIndex, pageSize);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
            List<SledTradeTimeConfig> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSledTradeTimeConfigHandler(),
                    sqlBuilder.getParameterList());
            SledTradeTimeConfigPage page = new SledTradeTimeConfigPage();
            page.setPage(list);
            page.setTotal(total);
            return page;
        } catch (SQLException e) {
            AppLog.e("Error occurs at query.", e);
            throw new ErrorInfo(ErrorCodeInner.DB_SELECT_FAILED.getErrorCode(),
                    ErrorCodeInner.DB_SELECT_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }
}

class TSledTradeTimeConfigHandler extends AbstractListHandler<SledTradeTimeConfig> {

    @Override
    protected SledTradeTimeConfig handleRow(ResultSet rs) throws SQLException {
        SledTradeTimeConfig config = new SledTradeTimeConfig();
        config.setSledCommodityId(rs.getInt(TableSledCommodityTradeTimeConfig.COLUMN_FSLED_COMMODITY_ID));
        config.setZoneId(rs.getString(TableSledCommodityTradeTimeConfig.COLUMN_FZONE_ID));
        String standardData = rs.getString(TableSledCommodityTradeTimeConfig.COLUMN_FSTANDARD_WEEK_TRADE_TIMES);
        Map<Days, DayTradeTime> standardWeekTradeTimes = GsonFactory.getInstance().getGson().fromJson(standardData, new TypeToken<HashMap<Days, DayTradeTime>>() {
        }.getType());
        if (standardWeekTradeTimes != null) {
            config.setStandardWeekTradeTimes(standardWeekTradeTimes);
        } else {
            config.setStandardWeekTradeTimes(new HashMap<>());
        }

        String dstData = rs.getString(TableSledCommodityTradeTimeConfig.COLUMN_FDST_WEEK_TRADE_TIMES);
        Map<Days, DayTradeTime> dstWeekTradeTimes = GsonFactory.getInstance().getGson().fromJson(dstData, new TypeToken<HashMap<Days, DayTradeTime>>() {
        }.getType());
        if (dstWeekTradeTimes != null) {
            config.setDstWeekTradeTimes(dstWeekTradeTimes);
        } else {
            config.setDstWeekTradeTimes(new HashMap<>());
        }

        int flag = rs.getInt(TableSledCommodityTradeTimeConfig.COLUMN_FDST_EXISTS);
        config.setDstExists(flag == 0 ? false : true);
        config.setCreateTimestamp(rs.getLong(TableSledCommodityTradeTimeConfig.COLUMN_FCREATE_TIMESTAMP));
        config.setLastModifyTimestamp(rs.getLong(TableSledCommodityTradeTimeConfig.COLUMN_FLAST_MODIFY_TIMESTAMP));
        return config;
    }
}
