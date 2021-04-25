package com.longsheng.data;

import com.longsheng.table.TableSledContract;
import com.longsheng.utils.DaoUtil;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledContractOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContract;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SledContractHandler extends TableHandler {

    public SledContractHandler(Connection connection, QueryRunner runner) throws ErrorInfo {
        super(connection, runner);
    }

    public void insert(TSledContract tSledContract) throws ErrorInfo, SQLException {

        PreparedFields fields = prepareFields(tSledContract);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSledContract.TABLE_NAME, fields);
        runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
    }

    private PreparedFields prepareFields(TSledContract tSledContract) {
        PreparedFields fields = new PreparedFields();
        if (tSledContract.isSetSledCommodityId()) {
            fields.addInt(TableSledContract.COLUMN_FSLED_COMMODITY_ID, tSledContract.getSledCommodityId());
        }
        if (tSledContract.isSetSledContractCode()) {
            fields.addString(TableSledContract.COLUMN_FSLED_CONTRACT_CODE, tSledContract.getSledContractCode());
        }
        if (tSledContract.isSetRelateContractIds()) {
            fields.addString(TableSledContract.COLUMN_FRELATE_CONTRACT_IDS, StringUtils.join(tSledContract.getRelateContractIds(), ","));
        }

        if (tSledContract.isSetTechPlatformEnv()) {
            fields.addInt(TableSledContract.COLUMN_FTECH_PLATFORM_ENV, tSledContract.getTechPlatformEnv());
        }
        if (tSledContract.isSetSledTag()) {
            fields.addString(TableSledContract.COLUMN_FSLED_TAG, tSledContract.getSledTag());
        }
        if (tSledContract.isSetContractExpDate()) {
            fields.addLong(TableSledContract.COLUMN_FCONTRACT_EXP_DATE, tSledContract.getContractExpDate());
        }

        if (tSledContract.isSetLastTradeDate()) {
            fields.addLong(TableSledContract.COLUMN_FLAST_TRADE_DATE, tSledContract.getLastTradeDate());
        }
        if (tSledContract.isSetFirstNoticeDate()) {
            fields.addLong(TableSledContract.COLUMN_FFIRST_NOTICE_DATE, tSledContract.getFirstNoticeDate());
        }
        if (tSledContract.isSetEditstatus()) {
            fields.addInt(TableSledContract.COLUMN_FEDIT_STATUS, tSledContract.getEditstatus());
        }
        if (tSledContract.isSetWorkingStatus()) {
            fields.addInt(TableSledContract.COLUMN_FWORKING_STATUS, tSledContract.getWorkingStatus());
        }
        if (tSledContract.isSetEngName()) {
            fields.addString(TableSledContract.COLUMN_FCONTRACT_ENG_NAME, tSledContract.getEngName());
        }
        if (tSledContract.isSetCnName()) {
            fields.addString(TableSledContract.COLUMN_FCONTRACT_CN_NAME, tSledContract.getCnName());
        }
        if (tSledContract.isSetTcName()) {
            fields.addString(TableSledContract.COLUMN_FCONTRACT_TC_NAME, tSledContract.getTcName());
        }
        if (tSledContract.isSetContractStatus()) {
            fields.addInt(TableSledContract.COLUMN_FCONTRACT_STATUS, tSledContract.getContractStatus());
        }
        if (tSledContract.isSetActiveStartTimestamp()) {
            fields.addLong(TableSledContract.COLUMN_FACTIVE_START_TIMESTAMP, tSledContract.getActiveStartTimestamp());
        }
        if (tSledContract.isSetActiveEndTimestamp()) {
            fields.addLong(TableSledContract.COLUMN_FACTIVE_END_TIMESTAMP, tSledContract.getActiveEndTimestamp());
        }
        if (tSledContract.isSetSledContractId()) {
            fields.addInt(TableSledContract.COLUMN_FSLED_CONTRACT_ID, tSledContract.getSledContractId());
        }
        if (tSledContract.isSetCreateTimestamp()) {
            fields.addLong(TableSledContract.COLUMN_FCREATE_TIMESTAMP, tSledContract.getCreateTimestamp());
        }
        if (tSledContract.isSetLastModityTimestamp()) {
            fields.addLong(TableSledContract.COLUMN_FLAST_MODIFY_TIMESTAMP, tSledContract.getLastModityTimestamp());
        }
        if (tSledContract.isSetSubscribeXQQuote()) {
            fields.addInt(TableSledContract.COLUMN_FSUBSCRIBE_XQ_QUOTE, tSledContract.getSubscribeXQQuote());
        }

        return fields;
    }

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableSledContract.COLUMN_FSLED_COMMODITY_ID,
                TableSledContract.COLUMN_FSLED_CONTRACT_ID,
                TableSledContract.COLUMN_FSLED_CONTRACT_CODE,
                TableSledContract.COLUMN_FTECH_PLATFORM_ENV,
                TableSledContract.COLUMN_FRELATE_CONTRACT_IDS,
                TableSledContract.COLUMN_FSLED_TAG,
                TableSledContract.COLUMN_FCONTRACT_EXP_DATE,
                TableSledContract.COLUMN_FCONTRACT_ENG_NAME,
                TableSledContract.COLUMN_FCONTRACT_CN_NAME,
                TableSledContract.COLUMN_FCONTRACT_TC_NAME,
                TableSledContract.COLUMN_FLAST_TRADE_DATE,
                TableSledContract.COLUMN_FFIRST_NOTICE_DATE,
                TableSledContract.COLUMN_FWORKING_STATUS,
                TableSledContract.COLUMN_FEDIT_STATUS,
                TableSledContract.COLUMN_FCONTRACT_STATUS,
                TableSledContract.COLUMN_FACTIVE_START_TIMESTAMP,
                TableSledContract.COLUMN_FACTIVE_END_TIMESTAMP,
                TableSledContract.COLUMN_FSUBSCRIBE_XQ_QUOTE,
                TableSledContract.COLUMN_FLAST_MODIFY_TIMESTAMP,
                TableSledContract.COLUMN_FCREATE_TIMESTAMP);
        sqlBuilder.addTables(TableSledContract.TABLE_NAME);
        return sqlBuilder;
    }

    public List<TSledContract> query(Set<Integer> sledCommodityIds) throws ErrorInfo, SQLException {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                TableSledContract.COLUMN_FSLED_COMMODITY_ID,
                sledCommodityIds);

        return runner.query(conn, sqlBuilder.getItemsSql() + " for update ", new TSledContractHandler(),
                sqlBuilder.getParameterList());
    }

    private class TSledContractHandler extends AbstractListHandler<TSledContract> {

        @Override
        protected TSledContract handleRow(ResultSet rs) throws SQLException {
            TSledContract info = new TSledContract();
            info.setSledCommodityId(rs.getInt(TableSledContract.COLUMN_FSLED_COMMODITY_ID));

            String[] list = StringUtils.split(rs.getString(TableSledContract.COLUMN_FRELATE_CONTRACT_IDS), ",");
            List<Integer> ids = new ArrayList<>();
            for (String s : list) {
                if (!"".equals(s) && s != null) {
                    ids.add(Integer.parseInt(s));
                }
            }
            info.setRelateContractIds(ids);
            info.setSledContractId(rs.getInt(TableSledContract.COLUMN_FSLED_CONTRACT_ID));
            info.setSledContractCode(rs.getString(TableSledContract.COLUMN_FSLED_CONTRACT_CODE));
            info.setTechPlatformEnv(rs.getInt(TableSledContract.COLUMN_FTECH_PLATFORM_ENV));
            info.setSledTag(rs.getString(TableSledContract.COLUMN_FSLED_TAG));
            info.setEngName(rs.getString(TableSledContract.COLUMN_FCONTRACT_ENG_NAME));
            info.setCnName(rs.getString(TableSledContract.COLUMN_FCONTRACT_CN_NAME));
            info.setTcName(rs.getString(TableSledContract.COLUMN_FCONTRACT_TC_NAME));
            info.setContractExpDate(rs.getLong(TableSledContract.COLUMN_FCONTRACT_EXP_DATE));
            info.setLastTradeDate(rs.getLong(TableSledContract.COLUMN_FLAST_TRADE_DATE));
            info.setFirstNoticeDate(rs.getLong(TableSledContract.COLUMN_FFIRST_NOTICE_DATE));
            info.setContractStatus(rs.getInt(TableSledContract.COLUMN_FCONTRACT_STATUS));
            info.setEditstatus(rs.getInt(TableSledContract.COLUMN_FEDIT_STATUS));
            info.setWorkingStatus(rs.getInt(TableSledContract.COLUMN_FWORKING_STATUS));
            info.setActiveStartTimestamp(rs.getLong(TableSledContract.COLUMN_FACTIVE_START_TIMESTAMP));
            info.setActiveEndTimestamp(rs.getLong(TableSledContract.COLUMN_FACTIVE_END_TIMESTAMP));
            info.setCreateTimestamp(rs.getLong(TableSledContract.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getLong(TableSledContract.COLUMN_FLAST_MODIFY_TIMESTAMP));
            info.setSubscribeXQQuote(rs.getInt(TableSledContract.COLUMN_FSUBSCRIBE_XQ_QUOTE));
            return info;
        }
    }
}
