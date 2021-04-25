package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableSledContract;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledContractOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContract;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContractPage;
import com.longsheng.xueqiao.contract.dao.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.dal_set.DbUtil;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SledContractHandler extends TableHandler {

    public SledContractHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public int insert(TSledContract tSledContract) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(tSledContract);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledCommodity fields must set.");
        }

        int sledContractId;
        try {
            sledContractId = ConfigurationProperty.instance().getSledContractIdMaker().createIdIntSafe();
            if (sledContractId == 0) {
                throw new IdException("contract id create failed!");
            }
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "contract create failed!");
        }

        fields.addInt(TableSledContract.COLUMN_FSLED_CONTRACT_ID, sledContractId);
        fields.addInt(TableSledContract.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableSledContract.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSledContract.TABLE_NAME, fields);

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            AppLog.e("tSledContract: " + tSledContract);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
        return sledContractId;
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
        if (tSledContract.isSetSubscribeXQQuote()) {
            fields.addInt(TableSledContract.COLUMN_FSUBSCRIBE_XQ_QUOTE, tSledContract.getSubscribeXQQuote());
        }

        return fields;
    }

    public int update(TSledContract tSledContract) throws ErrorInfo {

        if (!tSledContract.isSetSledContractId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledContract field SledContractId must set.");
        }
        PreparedFields fields = prepareFields(tSledContract);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledContract fields must set.");
        }
        int timeNow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableSledContract.COLUMN_FLAST_MODIFY_TIMESTAMP, timeNow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableSledContract.TABLE_NAME, fields);
        String condition = TableSledContract.COLUMN_FSLED_CONTRACT_ID + "=" + tSledContract.getSledContractId();
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
        return tSledContract.getSledContractId();
    }

    public boolean inactiveExpiredContract(long timestamp) throws ErrorInfo {

        PreparedFields fields = new PreparedFields();
        int timeNow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableSledContract.COLUMN_FLAST_MODIFY_TIMESTAMP, timeNow);

        fields.addInt(TableSledContract.COLUMN_FCONTRACT_STATUS, 1);

        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableSledContract.TABLE_NAME, fields);
        String condition = TableSledContract.COLUMN_FCONTRACT_EXP_DATE + " < " + timestamp;
        sqlBuffer.append(condition);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            runner.update(conn, sqlBuffer.toString(), fields.getParameters());
            return true;
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

    public TSledContractPage query(ReqTSledContractOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = getSqlQueryBuilder(option);

        sqlBuilder.setPage(pageIndex, pageSize);
        sqlBuilder.setOrder(SqlQueryBuilder.OrderType.ASC, TableSledContract.COLUMN_FSLED_CONTRACT_CODE);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        TSledContractPage page = new TSledContractPage();

        AppLog.i("SledContractHandler option: " + option);
        AppLog.i("SledContractHandler sql: " + sqlBuilder.getItemsSql());

        try {
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(),
                    sqlBuilder.getParameterList()).intValue();

            page.setTotal(total);
            List<TSledContract> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSledContractHandler(),
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

    private SqlQueryBuilder getSqlQueryBuilder(ReqTSledContractOption option) {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.isSetSledContractIds() && option.getSledContractIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledContract.COLUMN_FSLED_CONTRACT_ID, DaoUtil.map2Set(option.getSledContractIds()));
        }
        if (option.isSetTechPlatformEnv()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledContract.COLUMN_FTECH_PLATFORM_ENV + "=?", option.getTechPlatformEnv());
        }
        if (option.isSetEditStatus()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledContract.COLUMN_FEDIT_STATUS + "=?",
                    option.getEditStatus());
        }
        if (option.isSetWorkingStatus()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledContract.COLUMN_FWORKING_STATUS + "=?",
                    option.getWorkingStatus());
        }
        if (option.isSetSledCommodityId()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledContract.COLUMN_FSLED_COMMODITY_ID + "=?",
                    option.getSledCommodityId());
        }
        if (option.isSetContractStatus()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledContract.COLUMN_FCONTRACT_STATUS + "=?",
                    option.getContractStatus());
        }
        if (option.isSetSledContractCode()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledContract.COLUMN_FSLED_CONTRACT_CODE + "=?",
                    option.getSledContractCode());
        }
        if (option.isSetIsSubscribeQuote()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledContract.COLUMN_FSUBSCRIBE_XQ_QUOTE + "=?",
                    option.isIsSubscribeQuote() ? 1 : 0);
        }

        if (option.isSetContractCodePartical() || option.isSetSledTagPartical() || option.isSetContractEngNamePartical() || option.isSetContractCnNamePartical()) {

            List<String> values = new ArrayList<>();
            List<String> columns = new ArrayList<>();
            if (option.isSetContractCodePartical()) {
                columns.add(TableSledContract.COLUMN_FSLED_CONTRACT_CODE);
                values.add(option.getContractCodePartical());
            }
            if (option.isSetSledTagPartical()) {
                columns.add(TableSledContract.COLUMN_FSLED_TAG);
                values.add(option.getSledTagPartical());
            }
            if (option.isSetContractEngNamePartical()) {
                columns.add(TableSledContract.COLUMN_FCONTRACT_ENG_NAME);
                values.add(option.getContractEngNamePartical());
            }
            if (option.isSetContractCnNamePartical()) {
                columns.add(TableSledContract.COLUMN_FCONTRACT_CN_NAME);
                values.add(option.getContractCnNamePartical());
            }

            String str = DaoUtil.getConditionORString(columns);
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, str, DaoUtil.getConditionORValues(values));
        }
        return sqlBuilder;
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
