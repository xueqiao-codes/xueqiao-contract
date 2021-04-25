package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableSledCommoditySpecTradeTime;
import com.longsheng.xueqiao.contract.dao.tables.TableSpecTradeTime;
import com.longsheng.xueqiao.contract.dao.utils.JsonFactory;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.DbUtil;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.util.ProtocolUtil;

import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecTradeTimeHandler extends TableHandler {


    public SpecTradeTimeHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(SpecTradeTime specTradeTime) throws ErrorInfo {

        checkInput(specTradeTime);
        long createTime = System.currentTimeMillis() / 1000;
        PreparedFields fields = prepareFields(specTradeTime);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledExchange fields must set.");
        }
        int specTradeTimeId;
        try {
            specTradeTimeId = ConfigurationProperty.instance().getSpecTradeTimeIdMaker().createIdIntSafe();
            if (specTradeTimeId == 0) {
                throw new IdException("spec trade time id create failed!");
            }
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "spec trade time create failed!");
        }

        List<PreparedFields> sledCommoditySpecTradeTimeFields = prepareSpecTradeTimeFields(specTradeTime, specTradeTimeId);

        fields.addInt(TableSpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID, specTradeTimeId);
        fields.addLong(TableSpecTradeTime.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addLong(TableSpecTradeTime.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSpecTradeTime.TABLE_NAME, fields);


        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
            for (PreparedFields preparedFields : sledCommoditySpecTradeTimeFields) {
                preparedFields.addLong(TableSledCommoditySpecTradeTime.COLUMN_FCREATE_TIMESTAMP, createTime);
                preparedFields.addLong(TableSledCommoditySpecTradeTime.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
                StringBuffer insertSledCommoditySpecTime = getInsertTableSqlBuffer(TableSledCommoditySpecTradeTime.TABLE_NAME, preparedFields);
                runner.update(conn, insertSledCommoditySpecTime.toString(), preparedFields.getParameters());
            }
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

    private void checkInput(SpecTradeTime specTradeTime) throws ErrorInfo {
        if (!specTradeTime.isSetExchangeMic()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "ExchangeMic must set.");
        }
        if (specTradeTime.getSledCommodityIdsSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SledCommodityIds must set.");
        }
        if (!specTradeTime.isSetNonTradeStartTimestamp() && !specTradeTime.isSetNonTradeEndTimestamp()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "NonTrade timestamp must set.");
        }
    }

    private List<PreparedFields> prepareSpecTradeTimeFields(SpecTradeTime specTradeTime, int specTradeTimeId) {
        List<PreparedFields> list = new ArrayList<>();
        for (int id : specTradeTime.getSledCommodityIds()) {
            PreparedFields fields = new PreparedFields();
            fields.addInt(TableSledCommoditySpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID, specTradeTimeId);
            fields.addInt(TableSledCommoditySpecTradeTime.COLUMN_FSLED_COMMODITY_ID, id);
            if (specTradeTime.isSetNextTradeOpenType()) {

                fields.addInt(TableSledCommoditySpecTradeTime.COLUMN_FNEXT_TRADE_OPEN_TYPE, specTradeTime.getNextTradeOpenType().getValue());
            }
            if (specTradeTime.isSetNonTradeStartTimestamp()) {
                fields.addLong(TableSledCommoditySpecTradeTime.COLUMN_FNON_TRADE_START_TIMESTAMP, specTradeTime.getNonTradeStartTimestamp());
            }
            if (specTradeTime.isSetNonTradeEndTimestamp()) {

                fields.addLong(TableSledCommoditySpecTradeTime.COLUMN_FNON_TRADE_END_TIMESTAMP, specTradeTime.getNonTradeEndTimestamp());
            }
            list.add(fields);
        }
        return list;
    }

    private PreparedFields prepareFields(SpecTradeTime specTradeTime) {
        PreparedFields fields = new PreparedFields();
        if (specTradeTime.isSetExchangeMic()) {
            fields.addString(TableSpecTradeTime.COLUMN_FEXCHANGE_MIC, specTradeTime.getExchangeMic());
        }
        if (specTradeTime.isSetNextTradeOpenType()) {

            fields.addInt(TableSpecTradeTime.COLUMN_FNEXT_TRADE_OPEN_TYPE, specTradeTime.getNextTradeOpenType().getValue());
        }
        if (specTradeTime.isSetNonTradeStartTimestamp()) {
            fields.addLong(TableSpecTradeTime.COLUMN_FNON_TRADE_START_TIMESTAMP, specTradeTime.getNonTradeStartTimestamp());
        }
        if (specTradeTime.isSetNonTradeEndTimestamp()) {

            fields.addLong(TableSpecTradeTime.COLUMN_FNON_TRADE_END_TIMESTAMP, specTradeTime.getNonTradeEndTimestamp());
        }
        if (specTradeTime.isSetSledCommodityIds() && specTradeTime.getSledCommodityIdsSize() > 0) {
            fields.addString(TableSpecTradeTime.COLUMN_FSLED_COMMODITY_IDS, StringUtils.join(specTradeTime.getSledCommodityIds(), ","));
        }
        if (specTradeTime.isSetZoneId()) {
            fields.addString(TableSpecTradeTime.COLUMN_FZONE_ID, specTradeTime.getZoneId());
        }

        if (specTradeTime.getSledCommodityNamesSize() > 0) {
            fields.addString(TableSpecTradeTime.COLUMN_FSLED_COMMODITY_CODES, StringUtils.join(specTradeTime.getSledCommodityNames(), ","));
        }
        if (specTradeTime.getSledCommodityTypesSize() > 0) {
            fields.addString(TableSpecTradeTime.COLUMN_FSLED_COMMODITY_TYPES, StringUtils.join(specTradeTime.getSledCommodityTypes(), ","));
        }

        return fields;
    }

    public void update(SpecTradeTime specTradeTime) throws ErrorInfo {
        if (specTradeTime.getSpecTradeTimeId() <= 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SpecTradeTimeId must set.");
        }
        checkInput(specTradeTime);
        long createTime = System.currentTimeMillis() / 1000;
        PreparedFields fields = prepareFields(specTradeTime);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledExchange fields must set.");
        }
        int specTradeTimeId = specTradeTime.getSpecTradeTimeId();

        List<PreparedFields> sledCommoditySpecTradeTimeFields = prepareSpecTradeTimeFields(specTradeTime, specTradeTimeId);

        fields.addInt(TableSpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID, specTradeTimeId);
        fields.addLong(TableSpecTradeTime.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addLong(TableSpecTradeTime.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSpecTradeTime.TABLE_NAME, fields);

        String deleteSpecTradeTime = "delete from " + TableSpecTradeTime.TABLE_NAME + " where " + TableSpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID + "=?";
        String deleteSledCommoditySpecTradeTime = "delete from  " + TableSledCommoditySpecTradeTime.TABLE_NAME + " where "
                + TableSledCommoditySpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID + " =?";

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            runner.update(conn, deleteSpecTradeTime, specTradeTimeId);
            runner.update(conn, deleteSledCommoditySpecTradeTime, specTradeTimeId);
            runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
            for (PreparedFields preparedFields : sledCommoditySpecTradeTimeFields) {
                preparedFields.addLong(TableSledCommoditySpecTradeTime.COLUMN_FCREATE_TIMESTAMP, createTime);
                preparedFields.addLong(TableSledCommoditySpecTradeTime.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
                StringBuffer insertSledCommoditySpecTime = getInsertTableSqlBuffer(TableSledCommoditySpecTradeTime.TABLE_NAME, preparedFields);
                runner.update(conn, insertSledCommoditySpecTime.toString(), preparedFields.getParameters());
            }
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

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableSpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID,
                TableSpecTradeTime.COLUMN_FEXCHANGE_MIC,
                TableSpecTradeTime.COLUMN_FNEXT_TRADE_OPEN_TYPE,
                TableSpecTradeTime.COLUMN_FNON_TRADE_START_TIMESTAMP,
                TableSpecTradeTime.COLUMN_FNON_TRADE_END_TIMESTAMP,
                TableSpecTradeTime.COLUMN_FSLED_COMMODITY_IDS,
                TableSpecTradeTime.COLUMN_FZONE_ID,
                TableSpecTradeTime.COLUMN_FSLED_COMMODITY_CODES,
                TableSpecTradeTime.COLUMN_FSLED_COMMODITY_TYPES,
                TableSpecTradeTime.COLUMN_FCREATE_TIMESTAMP,
                TableSpecTradeTime.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableSpecTradeTime.TABLE_NAME);
        return sqlBuilder;
    }

    public SpecTradeTimePage query(ReqSpecTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.isSetSpecTradeTimeIds() && option.getSpecTradeTimeIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID,
                    option.getSpecTradeTimeIds());
        }
        if (option.isSetExchangeMic()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSpecTradeTime.COLUMN_FEXCHANGE_MIC + "=?", option.getExchangeMic());
        }
        sqlBuilder.setPage(pageIndex, pageSize);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
            List<SpecTradeTime> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSpecTradeTimeHandler(),
                    sqlBuilder.getParameterList());
            SpecTradeTimePage page = new SpecTradeTimePage();
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

    public SledCommoditySpecTradeTimePage querySledCommoditySpecTradeTime(ReqCommoditySpecTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo {

        SqlQueryBuilder sqlBuilder = createSledCommoditySpecSqlBuilder();
        if (option.isSetSledCommodityIds() && option.getSledCommodityIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledCommoditySpecTradeTime.COLUMN_FSLED_COMMODITY_ID,
                    option.getSledCommodityIds());
        }
        if (option.isSetStartTimestamp()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledCommoditySpecTradeTime.COLUMN_FNON_TRADE_END_TIMESTAMP + " > ?", option.getStartTimestamp());
        }
        if (option.isSetEndTimestamp()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledCommoditySpecTradeTime.COLUMN_FNON_TRADE_START_TIMESTAMP + " < ?", option.getEndTimestamp());
        }
        sqlBuilder.setPage(pageIndex, pageSize);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
            List<SledCommoditySpecTradeTime> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSledCommoditySpecTradeTimeHandler(),
                    sqlBuilder.getParameterList());
            SledCommoditySpecTradeTimePage page = new SledCommoditySpecTradeTimePage();
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

    public void remove(int specTradeTimeId) throws ErrorInfo {
        String deleteSledCommoditySpecSql = "delete from " + TableSledCommoditySpecTradeTime.TABLE_NAME + " where " + TableSledCommoditySpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID + " =?";
        String deleteSpecSql = "delete from " + TableSpecTradeTime.TABLE_NAME + " where " + TableSpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID + " =?";
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            runner.update(conn,deleteSpecSql,specTradeTimeId);
            runner.update(conn, deleteSledCommoditySpecSql, specTradeTimeId);
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

    private SqlQueryBuilder createSledCommoditySpecSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableSledCommoditySpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID,
                TableSledCommoditySpecTradeTime.COLUMN_FID,
                TableSledCommoditySpecTradeTime.COLUMN_FNEXT_TRADE_OPEN_TYPE,
                TableSledCommoditySpecTradeTime.COLUMN_FNON_TRADE_START_TIMESTAMP,
                TableSledCommoditySpecTradeTime.COLUMN_FNON_TRADE_END_TIMESTAMP,
                TableSledCommoditySpecTradeTime.COLUMN_FSLED_COMMODITY_ID,
                TableSledCommoditySpecTradeTime.COLUMN_FCREATE_TIMESTAMP,
                TableSledCommoditySpecTradeTime.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableSledCommoditySpecTradeTime.TABLE_NAME);
        return sqlBuilder;

    }


    private class TSpecTradeTimeHandler extends AbstractListHandler<SpecTradeTime> {

        @Override
        protected SpecTradeTime handleRow(ResultSet rs) throws SQLException {
            SpecTradeTime specTradeTime = new SpecTradeTime();
            specTradeTime.setSpecTradeTimeId(rs.getInt(TableSpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID));
            specTradeTime.setExchangeMic(rs.getString(TableSpecTradeTime.COLUMN_FEXCHANGE_MIC));
            specTradeTime.setNextTradeOpenType(NextTradeOpenType.findByValue(rs.getInt(TableSpecTradeTime.COLUMN_FNEXT_TRADE_OPEN_TYPE)));
            specTradeTime.setNonTradeStartTimestamp(rs.getLong(TableSpecTradeTime.COLUMN_FNON_TRADE_START_TIMESTAMP));
            specTradeTime.setNonTradeEndTimestamp(rs.getLong(TableSpecTradeTime.COLUMN_FNON_TRADE_END_TIMESTAMP));
            specTradeTime.setZoneId(rs.getString(TableSpecTradeTime.COLUMN_FZONE_ID));
            String data = rs.getString(TableSpecTradeTime.COLUMN_FSLED_COMMODITY_IDS);
            List<Integer> list = new ArrayList<>();
            String[] idStrings = StringUtils.split(data, ",");
            for (String s : idStrings) {
                list.add(Integer.parseInt(s));
            }
            specTradeTime.setSledCommodityIds(list);

            specTradeTime.setSledCommodityNames(Arrays.asList(StringUtils.split(rs.getString(TableSpecTradeTime.COLUMN_FSLED_COMMODITY_CODES), ",")));
            specTradeTime.setSledCommodityTypes(Arrays.asList(StringUtils.split(rs.getString(TableSpecTradeTime.COLUMN_FSLED_COMMODITY_TYPES), ",")));

            specTradeTime.setCreateTimestamp(rs.getLong(TableSpecTradeTime.COLUMN_FCREATE_TIMESTAMP));
            specTradeTime.setLastModifyTimestamp(rs.getLong(TableSpecTradeTime.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return specTradeTime;
        }
    }

    private class TSledCommoditySpecTradeTimeHandler extends AbstractListHandler<SledCommoditySpecTradeTime> {

        @Override
        protected SledCommoditySpecTradeTime handleRow(ResultSet rs) throws SQLException {
            SledCommoditySpecTradeTime sledCommoditySpecTradeTime = new SledCommoditySpecTradeTime();

            sledCommoditySpecTradeTime.setSledCommodityId(rs.getInt(TableSledCommoditySpecTradeTime.COLUMN_FSLED_COMMODITY_ID));
            sledCommoditySpecTradeTime.setSpecTradeTimeId(rs.getInt(TableSledCommoditySpecTradeTime.COLUMN_FSPEC_TRADE_TIME_ID));
            sledCommoditySpecTradeTime.setNextTradeOpenType(NextTradeOpenType.findByValue(rs.getInt(TableSledCommoditySpecTradeTime.COLUMN_FNEXT_TRADE_OPEN_TYPE)));
            sledCommoditySpecTradeTime.setNonTradeStartTimestamp(rs.getLong(TableSledCommoditySpecTradeTime.COLUMN_FNON_TRADE_START_TIMESTAMP));
            sledCommoditySpecTradeTime.setNonTradeEndTimestamp(rs.getLong(TableSledCommoditySpecTradeTime.COLUMN_FNON_TRADE_END_TIMESTAMP));
            sledCommoditySpecTradeTime.setCreateTimestamp(rs.getLong(TableSledCommoditySpecTradeTime.COLUMN_FCREATE_TIMESTAMP));
            sledCommoditySpecTradeTime.setLastModifyTimestamp(rs.getLong(TableSledCommoditySpecTradeTime.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return sledCommoditySpecTradeTime;
        }
    }
}
