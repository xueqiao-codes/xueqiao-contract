package com.longsheng.xueqiao.contract.dao.handlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.dal_set.DbUtil;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableSledExchange;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledExchangeOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledExchange;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledExchangePage;
import com.longsheng.xueqiao.contract.dao.utils.DaoUtil;

public class SledExchangeHandler extends TableHandler {

    public SledExchangeHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public int insert(TSledExchange tSledExchange) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(tSledExchange);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledExchange fields must set.");
        }

        int sledExchangeId;
        try {
            sledExchangeId = ConfigurationProperty.instance().getSledExchangeIdMaker().createIdIntSafe();
            if (sledExchangeId == 0) {
                throw new IdException("contract id create failed!");
            }
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "contract create failed!");
        }

        fields.addInt(TableSledExchange.COLUMN_FSLED_EXCHANGE_ID, sledExchangeId);
        fields.addInt(TableSledExchange.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableSledExchange.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSledExchange.TABLE_NAME, fields);

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
        return sledExchangeId;
    }

    private PreparedFields prepareFields(TSledExchange tSledExchange) {
        PreparedFields fields = new PreparedFields();
        if (tSledExchange.isSetExchangeMic()) {
            fields.addString(TableSledExchange.COLUMN_FEXCHANGE_MIC, tSledExchange.getExchangeMic());
        }
        if (tSledExchange.isSetCountry()) {
            fields.addString(TableSledExchange.COLUMN_FCOUNTRY, tSledExchange.getCountry());
        }
        if (tSledExchange.isSetCountryCode()) {
            fields.addString(TableSledExchange.COLUMN_FCOUNTRY_CODE, tSledExchange.getCountryCode());
        }
        if (tSledExchange.isSetOperatingMic()) {
            fields.addString(TableSledExchange.COLUMN_FOPERATING_MIC, tSledExchange.getOperatingMic());
        }
        if (tSledExchange.isSetOperatingMicType()) {
            fields.addInt(TableSledExchange.COLUMN_FEXCHANGE_OPERATING_MIC_TYPE, tSledExchange.getOperatingMicType());
        }
        if (tSledExchange.isSetNameInstitution()) {
            fields.addString(TableSledExchange.COLUMN_FNAME_INSTITUTION, tSledExchange.getNameInstitution());
        }
        if (tSledExchange.isSetAcronym()) {
            fields.addString(TableSledExchange.COLUMN_FACRONYM, tSledExchange.getAcronym());
        }
        if (tSledExchange.isSetCity()) {
            fields.addString(TableSledExchange.COLUMN_FCITY, tSledExchange.getCity());
        }
        if (tSledExchange.isSetWebsite()) {
            fields.addString(TableSledExchange.COLUMN_FWEBSITE, tSledExchange.getWebsite());
        }
        if (tSledExchange.isSetCnName()) {
            fields.addString(TableSledExchange.COLUMN_FCN_NAME, tSledExchange.getCnName());
        }
        if (tSledExchange.isSetCnAcronym()) {
            fields.addString(TableSledExchange.COLUMN_FCN_ACRONYM, tSledExchange.getCnAcronym());
        }
        if (tSledExchange.isSetActiveStartTimestamp()) {
            fields.addLong(TableSledExchange.COLUMN_FACTIVE_START_TIMESTAMP, tSledExchange.getActiveStartTimestamp());
        }
        if (tSledExchange.isSetActiveEndTimestamp()) {
            fields.addLong(TableSledExchange.COLUMN_FACTIVE_END_TIMESTAMP, tSledExchange.getActiveEndTimestamp());
        }
        if (tSledExchange.isSetZoneId()) {
            fields.addString(TableSledExchange.COLUMN_FZONE_ID, tSledExchange.getZoneId());
        }
        if (tSledExchange.isSetTimeLagMs()) {
            fields.addLong(TableSledExchange.COLUMN_FTIME_LAG_MS, tSledExchange.getTimeLagMs());
        }
        return fields;
    }

    public int update(TSledExchange tSledExchange) throws ErrorInfo {

        if (!tSledExchange.isSetSledExchangeId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledExchange field SledExchangeId must set.");
        }
        PreparedFields fields = prepareFields(tSledExchange);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledExchange fields must set.");
        }
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableSledExchange.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableSledExchange.TABLE_NAME, fields);
        String condition = TableSledExchange.COLUMN_FSLED_EXCHANGE_ID + "=" + tSledExchange.getSledExchangeId();
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
        return tSledExchange.getSledExchangeId();
    }

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableSledExchange.COLUMN_FSLED_EXCHANGE_ID,
                TableSledExchange.COLUMN_FEXCHANGE_MIC,
                TableSledExchange.COLUMN_FCOUNTRY,
                TableSledExchange.COLUMN_FCOUNTRY_CODE,
                TableSledExchange.COLUMN_FOPERATING_MIC,
                TableSledExchange.COLUMN_FEXCHANGE_OPERATING_MIC_TYPE,
                TableSledExchange.COLUMN_FNAME_INSTITUTION,
                TableSledExchange.COLUMN_FACRONYM,
                TableSledExchange.COLUMN_FCITY,
                TableSledExchange.COLUMN_FWEBSITE,
                TableSledExchange.COLUMN_FCN_ACRONYM,
                TableSledExchange.COLUMN_FCN_NAME,
                TableSledExchange.COLUMN_FZONE_ID,
                TableSledExchange.COLUMN_FTIME_LAG_MS,
                TableSledExchange.COLUMN_FACTIVE_START_TIMESTAMP,
                TableSledExchange.COLUMN_FACTIVE_END_TIMESTAMP,
                TableSledExchange.COLUMN_FCREATE_TIMESTAMP,
                TableSledExchange.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableSledExchange.TABLE_NAME);
        return sqlBuilder;
    }

    public TSledExchangePage query(ReqTSledExchangeOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.isSetSledExchangeIds() && option.getSledExchangeIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledExchange.COLUMN_FSLED_EXCHANGE_ID,
                    DaoUtil.map2Set(option.getSledExchangeIds()));
        }

        if (option.isSetExchangeMic()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledExchange.COLUMN_FEXCHANGE_MIC + "=?",
                    option.getExchangeMic());
        }

        if (option.isSetCnNamePartical() || option.isSetExchangeMicPartical()
                || option.isSetNameInstitutionPartical() || option.isSetAcronymPartical() || option.isSetCnAcronymPartical()) {

            List<String> values = new ArrayList<>();
            List<String> columns = new ArrayList<>();
            if (option.isSetCnAcronymPartical()) {
                columns.add(TableSledExchange.COLUMN_FCN_ACRONYM);
                values.add(option.getCnAcronymPartical());
            }
            if (option.isSetCnNamePartical()) {
                columns.add(TableSledExchange.COLUMN_FCN_NAME);
                values.add(option.getCnNamePartical());
            }
            if (option.isSetExchangeMicPartical()) {
                columns.add(TableSledExchange.COLUMN_FEXCHANGE_MIC);
                values.add(option.getExchangeMicPartical());
            }
            if (option.isSetNameInstitutionPartical()) {
                columns.add(TableSledExchange.COLUMN_FNAME_INSTITUTION);
                values.add(option.getNameInstitutionPartical());
            }
            if (option.isSetAcronymPartical()) {
                columns.add(TableSledExchange.COLUMN_FACRONYM);
                values.add(option.getAcronymPartical());
            }

            String str = DaoUtil.getConditionORString(columns);
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, str, DaoUtil.getConditionORValues(values));
        }


        sqlBuilder.setPage(pageIndex, pageSize);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            AppLog.i("sql: " + sqlBuilder.getItemsSql());
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
            List<TSledExchange> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSledExchangeHandler(),
                    sqlBuilder.getParameterList());
            TSledExchangePage page = new TSledExchangePage();
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

    public void deleteExchange(int sledExchangeId) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        String deleteSql = "delete from " + TableSledExchange.TABLE_NAME + " where " + TableSledExchange.COLUMN_FSLED_EXCHANGE_ID + " =?";
        ExchangeMapHandler handler = new ExchangeMapHandler(this.provider);

        ReqTSledExchangeOption option = new ReqTSledExchangeOption();
        option.addToSledExchangeIds(sledExchangeId);
        TSledExchangePage page = query(option, 0, 1);
        if (page.getPageSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), " Sled Exchange not found.");
        }
        try {
            handler.deleteExchangeMapping(runner, conn, page.getPage().get(0).getExchangeMic());
            runner.update(conn, deleteSql, sledExchangeId);
        } catch (SQLException e) {
            AppLog.e("Error occurs at delete.", e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(),
                    ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    private class TSledExchangeHandler extends AbstractListHandler<TSledExchange> {

        @Override
        protected TSledExchange handleRow(ResultSet rs) throws SQLException {
            TSledExchange info = new TSledExchange();
            info.setSledExchangeId(rs.getInt(TableSledExchange.COLUMN_FSLED_EXCHANGE_ID));
            info.setExchangeMic(rs.getString(TableSledExchange.COLUMN_FEXCHANGE_MIC));
            info.setCountry(rs.getString(TableSledExchange.COLUMN_FCOUNTRY));
            info.setCountryCode(rs.getString(TableSledExchange.COLUMN_FCOUNTRY_CODE));
            info.setOperatingMic(rs.getString(TableSledExchange.COLUMN_FOPERATING_MIC));
            info.setOperatingMicType(rs.getInt(TableSledExchange.COLUMN_FEXCHANGE_OPERATING_MIC_TYPE));
            info.setNameInstitution(rs.getString(TableSledExchange.COLUMN_FNAME_INSTITUTION));
            info.setAcronym(rs.getString(TableSledExchange.COLUMN_FACRONYM));
            info.setCity(rs.getString(TableSledExchange.COLUMN_FCITY));
            info.setWebsite(rs.getString(TableSledExchange.COLUMN_FWEBSITE));
            info.setCnAcronym(rs.getString(TableSledExchange.COLUMN_FCN_ACRONYM));
            info.setCnName(rs.getString(TableSledExchange.COLUMN_FCN_NAME));
            info.setZoneId(rs.getString(TableSledExchange.COLUMN_FZONE_ID));
            info.setTimeLagMs(rs.getLong(TableSledExchange.COLUMN_FTIME_LAG_MS));
            info.setActiveStartTimestamp(rs.getLong(TableSledExchange.COLUMN_FACTIVE_START_TIMESTAMP));
            info.setActiveEndTimestamp(rs.getLong(TableSledExchange.COLUMN_FACTIVE_END_TIMESTAMP));
            info.setCreateTimestamp(rs.getLong(TableSledExchange.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getLong(TableSledExchange.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }
}
