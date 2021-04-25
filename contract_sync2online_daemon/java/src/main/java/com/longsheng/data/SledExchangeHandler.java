package com.longsheng.data;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.table.TableSledExchange;
import com.longsheng.utils.DaoUtil;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledExchangeOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledExchange;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledExchangePage;
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
import java.util.List;

public class SledExchangeHandler extends TableHandler {

    public SledExchangeHandler(Connection connection, QueryRunner runner) throws ErrorInfo {
        super(connection,runner);
    }

    public void insert(TSledExchange tSledExchange) throws ErrorInfo, SQLException {
        PreparedFields fields = prepareFields(tSledExchange);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledExchange fields must set.");
        }
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSledExchange.TABLE_NAME, fields);
        runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
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
        if (tSledExchange.isSetCreateTimestamp()) {
            fields.addLong(TableSledExchange.COLUMN_FCREATE_TIMESTAMP, tSledExchange.getCreateTimestamp());
        }
        if (tSledExchange.isSetLastModityTimestamp()) {
            fields.addLong(TableSledExchange.COLUMN_FLAST_MODIFY_TIMESTAMP, tSledExchange.getLastModityTimestamp());
        }
        if (tSledExchange.isSetSledExchangeId()) {
            fields.addInt(TableSledExchange.COLUMN_FSLED_EXCHANGE_ID, tSledExchange.getSledExchangeId());
        }
        if (tSledExchange.isSetZoneId()){
            fields.addString(TableSledExchange.COLUMN_FZONE_ID,tSledExchange.getZoneId());
        }
        if (tSledExchange.isSetTimeLagMs()){
            fields.addLong(TableSledExchange.COLUMN_FTIME_LAG_MS,tSledExchange.getTimeLagMs());
        }
        return fields;
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
                TableSledExchange.COLUMN_FZONE_ID,
                TableSledExchange.COLUMN_FCN_NAME,
                TableSledExchange.COLUMN_FTIME_LAG_MS,
                TableSledExchange.COLUMN_FACTIVE_START_TIMESTAMP,
                TableSledExchange.COLUMN_FACTIVE_END_TIMESTAMP,
                TableSledExchange.COLUMN_FCREATE_TIMESTAMP,
                TableSledExchange.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableSledExchange.TABLE_NAME);
        return sqlBuilder;
    }

    public List<TSledExchange> query(ReqTSledExchangeOption option, int pageIndex, int pageSize) throws ErrorInfo, SQLException {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.isSetSledExchangeIds() && option.getSledExchangeIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledExchange.COLUMN_FSLED_EXCHANGE_ID,
                    DaoUtil.map2Set(option.getSledExchangeIds()));
        }

        if (option.isSetExchangeMic()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledExchange.COLUMN_FEXCHANGE_MIC + "=?",
                    option.getExchangeMic());
        }
        sqlBuilder.setPage(pageIndex, pageSize);
        return runner.query(conn, sqlBuilder.getItemsSql() + " for update ", new TSledExchangeHandler(),
                sqlBuilder.getParameterList());
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
