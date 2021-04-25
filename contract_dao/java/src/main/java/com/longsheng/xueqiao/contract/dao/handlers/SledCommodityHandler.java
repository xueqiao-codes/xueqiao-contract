package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableSledCommodity;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledCommodityOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityPage;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledCommodity;
import com.longsheng.xueqiao.contract.dao.utils.DaoUtil;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledTradingSessionOption;
import com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig;
import com.longsheng.xueqiao.contract.thriftapi.SledTradingSession;
import com.longsheng.xueqiao.contract.thriftapi.SledTradingSessionPage;
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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SledCommodityHandler extends TableHandler {


    private final static String XUEQIAO_SPLIT1 = "[xq_split1]";

    public SledCommodityHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public int insert(TSledCommodity tSledCommodity) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        if (!tSledCommodity.isSetSledCommodityConfig()) {
            tSledCommodity.setSledCommodityConfig(new ArrayList<>());
        }

        PreparedFields fields = prepareFields(tSledCommodity);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledCommodity fields must set.");
        }

        int sledCommodityId;
        try {
            sledCommodityId = ConfigurationProperty.instance().getSleCommodityIdMaker().createIdIntSafe();
            if (sledCommodityId == 0) {
                throw new IdException("contract id create failed!");
            }
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "contract create failed!");
        }

        fields.addInt(TableSledCommodity.COLUMN_FSLED_COMMODITY_ID, sledCommodityId);
        fields.addInt(TableSledCommodity.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableSledCommodity.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSledCommodity.TABLE_NAME, fields);

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            ;
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
        return sledCommodityId;
    }

    private PreparedFields prepareFields(TSledCommodity tSledCommodity) {
        PreparedFields fields = new PreparedFields();
        if (tSledCommodity.isSetExchangeMic()) {
            fields.addString(TableSledCommodity.COLUMN_FEXCHANGE_MIC, tSledCommodity.getExchangeMic());
        }
        if (tSledCommodity.isSetRelateCommodityIds()) {
            fields.addString(TableSledCommodity.COLUMN_FRELATE_COMMODITY_IDS, StringUtils.join(tSledCommodity.getRelateCommodityIds(), XUEQIAO_SPLIT1));
        }
        if (tSledCommodity.isSetSledCommodityCode()) {
            fields.addString(TableSledCommodity.COLUMN_FSLED_COMMODITY_CODE, tSledCommodity.getSledCommodityCode());
        }
        if (tSledCommodity.isSetZoneId()) {
            fields.addString(TableSledCommodity.COLUMN_FZONE_ID, tSledCommodity.getZoneId());
        }
        if (tSledCommodity.isSetTradeCurrency()) {
            fields.addString(TableSledCommodity.COLUMN_FTRADE_CURRENCY, tSledCommodity.getTradeCurrency());
        }
        if (tSledCommodity.isSetSledCommodityType()) {
            fields.addInt(TableSledCommodity.COLUMN_FSLED_COMMODITY_TYPE, tSledCommodity.getSledCommodityType());
        }
        if (tSledCommodity.isSetEditstatus()) {
            fields.addInt(TableSledCommodity.COLUMN_FEDIT_STATUS, tSledCommodity.getEditstatus());
        }
        if (tSledCommodity.isSetWorkingStatus()) {
            fields.addDouble(TableSledCommodity.COLUMN_FWORKING_STATUS, tSledCommodity.getWorkingStatus());
        }
        if (tSledCommodity.isSetEngName()) {
            fields.addString(TableSledCommodity.COLUMN_FENG_NAME, tSledCommodity.getEngName());
        }
        if (tSledCommodity.isSetCnName()) {
            fields.addString(TableSledCommodity.COLUMN_FCN_NAME, tSledCommodity.getCnName());
        }
        if (tSledCommodity.isSetTcName()) {
            fields.addString(TableSledCommodity.COLUMN_FTC_NAME, tSledCommodity.getTcName());
        }
        if (tSledCommodity.isSetActiveStartTimestamp()) {
            fields.addLong(TableSledCommodity.COLUMN_FACTIVE_START_TIMESTAMP, tSledCommodity.getActiveStartTimestamp());
        }
        if (tSledCommodity.isSetActiveEndTimestamp()) {
            fields.addLong(TableSledCommodity.COLUMN_FACTIVE_END_TIMESTAMP, tSledCommodity.getActiveEndTimestamp());
        }
        if (tSledCommodity.isSetSledCommodityConfig()) {
            fields.addString(TableSledCommodity.COLUMN_FSLED_COMMODITY_CONFIG, StringUtils.join(tSledCommodity.getSledCommodityConfig(), XUEQIAO_SPLIT1));
        }
        if (tSledCommodity.isSetContractSize()) {
            fields.addDouble(TableSledCommodity.COLUMN_FCONTRACT_SIZE, tSledCommodity.getContractSize());
        }
        if (tSledCommodity.isSetTickSize()) {
            fields.addDouble(TableSledCommodity.COLUMN_FTICK_SIZE, tSledCommodity.getTickSize());
        }
        if (tSledCommodity.isSetDenominator()) {
            fields.addInt(TableSledCommodity.COLUMN_FDENOMINATOR, tSledCommodity.getDenominator());
        }
        if (tSledCommodity.isSetCmbDirect()) {
            fields.addInt(TableSledCommodity.COLUMN_FCMB_DIRECT, tSledCommodity.getCmbDirect());
        }
        if (tSledCommodity.isSetCommodityState()) {
            fields.addInt(TableSledCommodity.COLUMN_FCOMMODITY_STATE, tSledCommodity.getCommodityState());
        }
        if (tSledCommodity.isSetIsAlsoSupportSim()) {
            fields.addInt(TableSledCommodity.COLUMN_FIS_ALSO_SUPPORT_SIM, tSledCommodity.isIsAlsoSupportSim() ? 1 : 0);
        }
        if (tSledCommodity.isSetEngAcronym()) {
            fields.addString(TableSledCommodity.COLUMN_FENG_ACRONYM, tSledCommodity.getEngAcronym());
        }
        if (tSledCommodity.isSetCnAcronym()) {
            fields.addString(TableSledCommodity.COLUMN_FCN_ACRONYM, tSledCommodity.getCnAcronym());
        }
        if (tSledCommodity.isSetTcAcronym()) {
            fields.addString(TableSledCommodity.COLUMN_FTC_ACRONYM, tSledCommodity.getTcAcronym());
        }

        return fields;
    }

    public int update(TSledCommodity tSledCommodity) throws ErrorInfo {

        if (!tSledCommodity.isSetSledCommodityId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledCommodity field SledCommodityId must set.");
        }
        PreparedFields fields = prepareFields(tSledCommodity);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledCommodity fields must set.");
        }
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableSledCommodity.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableSledCommodity.TABLE_NAME, fields);
        String condition = TableSledCommodity.COLUMN_FSLED_COMMODITY_ID + "=" + tSledCommodity.getSledCommodityId();
        sqlBuffer.append(condition);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            runner.update(conn, sqlBuffer.toString(), fields.getParameters());
            if (tSledCommodity.isSetZoneId()) {
                SledTradingSessionTable table = new SledTradingSessionTable(conn);
                ReqSledTradingSessionOption option = new ReqSledTradingSessionOption();
                option.setSledCommodityId(tSledCommodity.getSledCommodityId());
                SledTradingSessionPage page = table.query(option, null);
                for (SledTradingSession session : page.getPage()) {
                    SledTradingSession newSession = new SledTradingSession();
                    newSession.setTradeSessionId(session.getTradeSessionId());
                    newSession.setZoneId(tSledCommodity.getZoneId());
                    table.update(newSession);
                }
            }
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
        return tSledCommodity.getSledCommodityId();
    }

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(TableSledCommodity.COLUMN_FSLED_COMMODITY_ID,
                TableSledCommodity.COLUMN_FEXCHANGE_MIC,
                TableSledCommodity.COLUMN_FSLED_COMMODITY_TYPE,
                TableSledCommodity.COLUMN_FSLED_COMMODITY_CODE,
                TableSledCommodity.COLUMN_FRELATE_COMMODITY_IDS,
                TableSledCommodity.COLUMN_FTRADE_CURRENCY,
                TableSledCommodity.COLUMN_FZONE_ID,
                TableSledCommodity.COLUMN_FCONTRACT_SIZE,
                TableSledCommodity.COLUMN_FTICK_SIZE,
                TableSledCommodity.COLUMN_FDENOMINATOR,
                TableSledCommodity.COLUMN_FCMB_DIRECT,
                TableSledCommodity.COLUMN_FCOMMODITY_STATE,
                TableSledCommodity.COLUMN_FENG_NAME,
                TableSledCommodity.COLUMN_FCN_NAME,
                TableSledCommodity.COLUMN_FTC_NAME,
                TableSledCommodity.COLUMN_FENG_ACRONYM,
                TableSledCommodity.COLUMN_FCN_ACRONYM,
                TableSledCommodity.COLUMN_FTC_ACRONYM,
                TableSledCommodity.COLUMN_FSLED_COMMODITY_CONFIG,
                TableSledCommodity.COLUMN_FIS_ALSO_SUPPORT_SIM,
                TableSledCommodity.COLUMN_FACTIVE_START_TIMESTAMP,
                TableSledCommodity.COLUMN_FACTIVE_END_TIMESTAMP,
                TableSledCommodity.COLUMN_FCREATE_TIMESTAMP,
                TableSledCommodity.COLUMN_FEDIT_STATUS,
                TableSledCommodity.COLUMN_FWORKING_STATUS,
                TableSledCommodity.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableSledCommodity.TABLE_NAME);
        return sqlBuilder;
    }

    public TCommodityPage query(ReqTSledCommodityOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        map2SqlBuilder(option, sqlBuilder);
        QueryRunner runner = new QueryRunner();
        sqlBuilder.setPage(pageIndex, pageSize);
        Connection conn = getConnection();
        try {
            AppLog.d("query sql: " + sqlBuilder.getItemsSql());
            TCommodityPage page = new TCommodityPage();
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(),
                    sqlBuilder.getParameterList()).intValue();

            List<TSledCommodity> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSledCommodityHandler(),
                    sqlBuilder.getParameterList());
            page.setTotal(total);
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

    private void map2SqlBuilder(ReqTSledCommodityOption option, SqlQueryBuilder sqlBuilder) {
        if (option.isSetSledCommodityIds() && option.getSledCommodityIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledCommodity.COLUMN_FSLED_COMMODITY_ID,
                    DaoUtil.map2Set(option.getSledCommodityIds()));
        }
        if (option.isSetExchangeMic()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledCommodity.COLUMN_FEXCHANGE_MIC + "=?", option.getExchangeMic());
        }

        if (option.isSetSledCommodityType()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledCommodity.COLUMN_FSLED_COMMODITY_TYPE + "=?", option.getSledCommodityType());
        }

        if (option.isSetSledCommodityCode()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledCommodity.COLUMN_FSLED_COMMODITY_CODE + "=?", option.getSledCommodityCode());
        }

        if (option.isSetEditstatus()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledCommodity.COLUMN_FEDIT_STATUS + "=?", option.getEditstatus());
        }
        if (option.isSetWorkingStatus()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledCommodity.COLUMN_FWORKING_STATUS + "=?", option.getWorkingStatus());
        }
        if (option.isSetIsSim()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableSledCommodity.COLUMN_FIS_ALSO_SUPPORT_SIM + "=?", option.isIsSim() ? 1 : 0);
        }

        if (option.isSetCnNamePartical() || option.isSetEngNamePartical() || option.isSetSledCommodityCodePartical()) {

            List<String> values = new ArrayList<>();
            List<String> columns = new ArrayList<>();
            if (option.isSetSledCommodityCodePartical()) {
                columns.add(TableSledCommodity.COLUMN_FSLED_COMMODITY_CODE);
                values.add(option.getSledCommodityCodePartical());
            }
            if (option.isSetEngNamePartical()) {
                columns.add(TableSledCommodity.COLUMN_FENG_NAME);
                values.add(option.getEngNamePartical());
            }
            if (option.isSetCnNamePartical()) {
                columns.add(TableSledCommodity.COLUMN_FCN_NAME);
                values.add(option.getCnNamePartical());
            }

            String str = DaoUtil.getConditionORString(columns);
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, str, DaoUtil.getConditionORValues(values));
        }

    }


    private class TSledCommodityHandler extends AbstractListHandler<TSledCommodity> {

        @Override
        protected TSledCommodity handleRow(ResultSet rs) throws SQLException {
            TSledCommodity info = new TSledCommodity();
            info.setSledCommodityId(rs.getInt(TableSledCommodity.COLUMN_FSLED_COMMODITY_ID));
            info.setExchangeMic(rs.getString(TableSledCommodity.COLUMN_FEXCHANGE_MIC));
            info.setSledCommodityType(rs.getInt(TableSledCommodity.COLUMN_FSLED_COMMODITY_TYPE));
            info.setSledCommodityCode(rs.getString(TableSledCommodity.COLUMN_FSLED_COMMODITY_CODE));

            String[] list = StringUtils.splitByWholeSeparator(rs.getString(TableSledCommodity.COLUMN_FRELATE_COMMODITY_IDS), XUEQIAO_SPLIT1);
            List<Integer> ids = new ArrayList<Integer>();
            for (String s : list) {
                if (!"".equals(s) && s != null) {
                    ids.add(Integer.parseInt(s));
                }
            }
            info.setRelateCommodityIds(ids);
            info.setTradeCurrency(rs.getString(TableSledCommodity.COLUMN_FTRADE_CURRENCY));
            info.setZoneId(rs.getString(TableSledCommodity.COLUMN_FZONE_ID));

            info.setContractSize(rs.getDouble(TableSledCommodity.COLUMN_FCONTRACT_SIZE));
            info.setTickSize(rs.getDouble(TableSledCommodity.COLUMN_FTICK_SIZE));
            info.setDenominator(rs.getInt(TableSledCommodity.COLUMN_FDENOMINATOR));
            info.setCmbDirect(rs.getInt(TableSledCommodity.COLUMN_FCMB_DIRECT));
            info.setCommodityState(rs.getInt(TableSledCommodity.COLUMN_FCOMMODITY_STATE));

            info.setEngName(rs.getString(TableSledCommodity.COLUMN_FENG_NAME));
            info.setCnName(rs.getString(TableSledCommodity.COLUMN_FCN_NAME));
            info.setTcName(rs.getString(TableSledCommodity.COLUMN_FTC_NAME));

            info.setEngAcronym(rs.getString(TableSledCommodity.COLUMN_FENG_ACRONYM));
            info.setCnAcronym(rs.getString(TableSledCommodity.COLUMN_FCN_ACRONYM));
            info.setTcAcronym(rs.getString(TableSledCommodity.COLUMN_FTC_ACRONYM));

            info.setActiveStartTimestamp(rs.getLong(TableSledCommodity.COLUMN_FACTIVE_START_TIMESTAMP));
            info.setActiveEndTimestamp(rs.getLong(TableSledCommodity.COLUMN_FACTIVE_END_TIMESTAMP));
            info.setIsAlsoSupportSim(1 == rs.getInt(TableSledCommodity.COLUMN_FIS_ALSO_SUPPORT_SIM));

            String[] configs = StringUtils.splitByWholeSeparator(rs.getString(TableSledCommodity.COLUMN_FSLED_COMMODITY_CONFIG), XUEQIAO_SPLIT1);
            info.setSledCommodityConfig(Arrays.asList(configs));

            info.setEditstatus(rs.getInt(TableSledCommodity.COLUMN_FEDIT_STATUS));
            info.setWorkingStatus(rs.getInt(TableSledCommodity.COLUMN_FWORKING_STATUS));
            info.setCreateTimestamp(rs.getLong(TableSledCommodity.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getLong(TableSledCommodity.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }

}
