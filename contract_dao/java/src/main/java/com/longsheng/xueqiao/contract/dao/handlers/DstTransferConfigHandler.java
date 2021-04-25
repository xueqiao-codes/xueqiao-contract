package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableDstTransferConfig;
import com.longsheng.xueqiao.contract.dao.tables.TableSledCommodityTradeTimeConfig;
import com.longsheng.xueqiao.contract.dao.utils.DaoUtil;
import com.longsheng.xueqiao.contract.dao.utils.GsonFactory;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.DbUtil;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DstTransferConfigHandler extends TableHandler {
    private static final String FULL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String HOUR_PATTERN = "HH:mm:ss";

    public DstTransferConfigHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(DstTransferConfig config) throws ErrorInfo {
        if (config.getCommodityIdsSize() == 0) {
            throw new IllegalArgumentException("DstTransferConfig CommodityIds must set");
        }

        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(config);

        fields.addInt(TableDstTransferConfig.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableDstTransferConfig.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableDstTransferConfig.TABLE_NAME, fields);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            if (!config.isCustom()) {
                updateSledDstTradeTime(config, createTime, runner, conn);
            }
            runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
            conn.commit();
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                AppLog.e(e1.getMessage(), e1);
            }
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    private void updateSledDstTradeTime(DstTransferConfig config, int createTime, QueryRunner runner, Connection conn) throws SQLException {
        SqlQueryBuilder sqlBuilder = createTradeTimeConfigSqlBuilder();
        sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledCommodityTradeTimeConfig.COLUMN_FSLED_COMMODITY_ID,
                DaoUtil.map2Set(config.getCommodityIds()));
        List<SledTradeTimeConfig> list = runner.query(conn, sqlBuilder.getItemsSql() + " for update", new TSledTradeTimeConfigHandler(),
                sqlBuilder.getParameterList());
        for (SledTradeTimeConfig sledTradeTimeConfig : list) {
            PreparedFields tradeTimeConfigFields = new PreparedFields();
            tradeTimeConfigFields.addInt(TableSledCommodityTradeTimeConfig.COLUMN_FDST_EXISTS, 1);
            try {
                sledTradeTimeConfig.setDstWeekTradeTimes(calculateDstWeekTradeTimes(sledTradeTimeConfig.getStandardWeekTradeTimes(), config.getStandard2DstOffSetMinute()));
            } catch (ParseException e) {
                throw new SQLException(e);
            }
            String data = GsonFactory.getInstance().getGson().toJson(sledTradeTimeConfig.getDstWeekTradeTimes());
            tradeTimeConfigFields.addString(TableSledCommodityTradeTimeConfig.COLUMN_FDST_WEEK_TRADE_TIMES, data);
            tradeTimeConfigFields.addLong(TableSledCommodityTradeTimeConfig.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
            StringBuffer updateSqlBuffer = getTableUpdateSqlBuffer(TableSledCommodityTradeTimeConfig.TABLE_NAME, tradeTimeConfigFields);
            String condition = TableSledCommodityTradeTimeConfig.COLUMN_FSLED_COMMODITY_ID + "=" + sledTradeTimeConfig.getSledCommodityId();
            updateSqlBuffer.append(condition);
            runner.update(conn, updateSqlBuffer.toString(), tradeTimeConfigFields.getParameters());
        }
    }

    private Map<Days, DayTradeTime> calculateDstWeekTradeTimes(Map<Days, DayTradeTime> standardWeekTradeTimes, int standard2DstOffSetMinute) throws ParseException {
        Map<Days, DayTradeTime> weekTradeTimes = new HashMap<>();
        for (Days days : standardWeekTradeTimes.keySet()) {
            DayTradeTime stdDayTradeTime = standardWeekTradeTimes.get(days);
            DayTradeTime dstDayTradeTime = new DayTradeTime();
            if (stdDayTradeTime.isSetTTradeTimes()) {
                for (String tradeTime : stdDayTradeTime.getTTradeTimes()) {
                    String timeSpan = calculateTimeSpan(standard2DstOffSetMinute, tradeTime);
                    dstDayTradeTime.addToTTradeTimes(timeSpan);
                }
            }
            if (stdDayTradeTime.isSetTPlusOneTradeTimes()) {
                for (String tradeTime : stdDayTradeTime.getTPlusOneTradeTimes()) {
                    String timeSpan = calculateTimeSpan(standard2DstOffSetMinute, tradeTime);
                    dstDayTradeTime.addToTTradeTimes(timeSpan);
                }
            }
            weekTradeTimes.put(days, dstDayTradeTime);
        }
        return weekTradeTimes;
    }

    private String calculateTimeSpan(int standard2DstOffSetMinute, String tradeTime) throws ParseException {
        String[] spans = StringUtils.split(tradeTime, "-");
        String startStr = spans[0].trim();
        String endStr = spans[1].trim();

        String spanStart = getSpanString(startStr, standard2DstOffSetMinute);
        String spanEnd = getSpanString(endStr, standard2DstOffSetMinute);
        return spanStart + "-" + spanEnd;
    }

    private String getSpanString(String timeStr, int standard2DstOffSetMinute) throws ParseException {
        SimpleDateFormat dateSimpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        String dateStr = dateSimpleDateFormat.format(new Date());
        timeStr = dateStr + " " + timeStr;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FULL_DATE_TIME_PATTERN);
        Date startTime = simpleDateFormat.parse(timeStr);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startTime);
        calendar.add(Calendar.MINUTE, standard2DstOffSetMinute);
        return getHourStringDatePart(calendar.getTimeInMillis());
    }

    private String getHourStringDatePart(long time) {
        SimpleDateFormat hourSimpleDateFormat = new SimpleDateFormat(HOUR_PATTERN);
        String time_str = hourSimpleDateFormat.format(new Date(time));
        return time_str;
    }

    private SqlQueryBuilder createTradeTimeConfigSqlBuilder() {
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

    private SqlQueryBuilder createDstConfigSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableDstTransferConfig.COLUMN_FDST_TRANSFER_CONFIG_ID,
                TableDstTransferConfig.COLUMN_FEXCHANGE_MICS,
                TableDstTransferConfig.COLUMN_FSLED_COMMODITY_TYPES,
                TableDstTransferConfig.COLUMN_FSLED_COMMODITY_CODES,
                TableDstTransferConfig.COLUMN_FSLED_COMMODITY_IDS,
                TableDstTransferConfig.COLUMN_FSTANDARD2DST_OFFSET_MIN,
                TableDstTransferConfig.COLUMN_FCUSTOM,
                TableDstTransferConfig.COLUMN_FCREATE_TIMESTAMP,
                TableDstTransferConfig.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableDstTransferConfig.TABLE_NAME);
        return sqlBuilder;
    }

    private PreparedFields prepareFields(DstTransferConfig config) {
        PreparedFields fields = new PreparedFields();
        if (config.getCommodityIdsSize() > 0) {
            fields.addString(TableDstTransferConfig.COLUMN_FSLED_COMMODITY_IDS, StringUtils.join(config.getCommodityIds(), ","));
        }
        if (config.getExchangeMicsSize() > 0) {
            fields.addString(TableDstTransferConfig.COLUMN_FEXCHANGE_MICS, StringUtils.join(config.getExchangeMics(), ","));
        }
        if (config.getSledCommodityNamesSize() > 0) {
            fields.addString(TableDstTransferConfig.COLUMN_FSLED_COMMODITY_CODES, StringUtils.join(config.getSledCommodityNames(), ","));
        }
        if (config.getSledCommodityTypesSize() > 0) {
            fields.addString(TableDstTransferConfig.COLUMN_FSLED_COMMODITY_TYPES, StringUtils.join(config.getSledCommodityTypes(), ","));
        }
        if (config.isSetStandard2DstOffSetMinute()) {
            fields.addInt(TableDstTransferConfig.COLUMN_FSTANDARD2DST_OFFSET_MIN, config.getStandard2DstOffSetMinute());
        }
        if (config.isSetCustom()) {
            fields.addInt(TableDstTransferConfig.COLUMN_FCUSTOM, config.isCustom() ? 1 : 0);
        }

        return fields;

    }

    public void update(DstTransferConfig config) throws ErrorInfo {
        if (config.getCommodityIdsSize() == 0 || !config.isSetDstTransferConfigId()) {
            throw new IllegalArgumentException("DstTransferConfig CommodityIds & DstTransferConfigId must set");
        }

        PreparedFields fields = prepareFields(config);
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableDstTransferConfig.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableSledCommodityTradeTimeConfig.TABLE_NAME, fields);
        String condition = TableDstTransferConfig.COLUMN_FDST_TRANSFER_CONFIG_ID + "=" + config.getDstTransferConfigId();
        sqlBuffer.append(condition);

        SqlQueryBuilder sqlQueryBuilder = createDstConfigSqlBuilder();
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            sqlQueryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableDstTransferConfig.COLUMN_FDST_TRANSFER_CONFIG_ID + " =?", config.getDstTransferConfigId());
            List<DstTransferConfig> list = runner.query(conn, sqlQueryBuilder.getItemsSql() + " for update", new TDstTransferConfigHandler(),
                    sqlQueryBuilder.getParameterList());
            if (list.size() == 0) {
                return;
            }

            DstTransferConfig oldConfig = list.get(0);
            cleanOldSledDstTradeTime(oldConfig, runner, conn);
            updateSledDstTradeTime(config, timenow, runner, conn);
            runner.update(conn, sqlBuffer.toString(), fields.getParameters());
            conn.commit();
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                AppLog.e(e1.getMessage(), e1);
            }
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    private void cleanOldSledDstTradeTime(DstTransferConfig oldConfig, QueryRunner runner, Connection conn) throws ErrorInfo, SQLException {
        for (int sledCommodityId : oldConfig.getCommodityIds()) {
            SledTradeTimeConfig tradeTime = new SledTradeTimeConfig();
            tradeTime.setDstExists(false);
            tradeTime.setDstWeekTradeTimes(new HashMap<>());
            tradeTime.setSledCommodityId(sledCommodityId);
            SledTradeTimeConfigHandler.update(tradeTime, runner, conn);
        }
    }

    public DstTransferConfigPage query(ReqDstTransferConfigOption option, int pageIndex, int pageSize) throws ErrorInfo {

        SqlQueryBuilder sqlQueryBuilder = createDstConfigSqlBuilder();

        if (option.isSetDstTransferConfigId()) {
            sqlQueryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableDstTransferConfig.COLUMN_FDST_TRANSFER_CONFIG_ID, DaoUtil.map2Set(option.getDstTransferConfigId()));
        }
        sqlQueryBuilder.setPage(pageIndex, pageSize);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            int total = runner.query(conn, sqlQueryBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlQueryBuilder.getParameterList()).intValue();
            List<DstTransferConfig> list = runner.query(conn, sqlQueryBuilder.getItemsSql(), new TDstTransferConfigHandler(),
                    sqlQueryBuilder.getParameterList());
            DstTransferConfigPage page = new DstTransferConfigPage();
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

    public void remove(int dst_config_id) throws ErrorInfo {

        ReqDstTransferConfigOption option = new ReqDstTransferConfigOption();
        option.addToDstTransferConfigId(dst_config_id);
        DstTransferConfigPage page = query(option, 0, 1);
        if (page.getPageSize() == 0) {
            return;
        }

        String deleteSql = "delete from " + TableDstTransferConfig.TABLE_NAME + " where " + TableDstTransferConfig.COLUMN_FDST_TRANSFER_CONFIG_ID + " =?";
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            cleanOldSledDstTradeTime(page.getPage().get(0), runner, conn);
            runner.update(conn, deleteSql, dst_config_id);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            AppLog.e("Error occurs at query.", e);
            throw new ErrorInfo(ErrorCodeInner.DB_SELECT_FAILED.getErrorCode(),
                    ErrorCodeInner.DB_SELECT_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    private class TDstTransferConfigHandler extends AbstractListHandler<DstTransferConfig> {

        @Override
        protected DstTransferConfig handleRow(ResultSet rs) throws SQLException {
            DstTransferConfig config = new DstTransferConfig();
            config.setDstTransferConfigId(rs.getInt(TableDstTransferConfig.COLUMN_FDST_TRANSFER_CONFIG_ID));
            String idStrs = rs.getString(TableDstTransferConfig.COLUMN_FSLED_COMMODITY_IDS);
            String[] idStrArray = StringUtils.split(idStrs, ",");
            List<Integer> ids = new ArrayList<>();
            for (String s : idStrArray) {
                ids.add(Integer.parseInt(s));
            }
            config.setCommodityIds(ids);
            config.setExchangeMics(Arrays.asList(StringUtils.split(rs.getString(TableDstTransferConfig.COLUMN_FEXCHANGE_MICS), ",")));
            config.setSledCommodityNames(Arrays.asList(StringUtils.split(rs.getString(TableDstTransferConfig.COLUMN_FSLED_COMMODITY_CODES), ",")));
            config.setSledCommodityTypes(Arrays.asList(StringUtils.split(rs.getString(TableDstTransferConfig.COLUMN_FSLED_COMMODITY_TYPES), ",")));
            config.setStandard2DstOffSetMinute(rs.getInt(TableDstTransferConfig.COLUMN_FSTANDARD2DST_OFFSET_MIN));
            config.setCreateTimestamp(rs.getLong(TableDstTransferConfig.COLUMN_FCREATE_TIMESTAMP));
            config.setLastModifyTimestamp(rs.getLong(TableDstTransferConfig.COLUMN_FLAST_MODIFY_TIMESTAMP));
            config.setCustom(rs.getInt(TableDstTransferConfig.COLUMN_FCUSTOM) == 1 ? true : false);
            return config;
        }
    }

}
