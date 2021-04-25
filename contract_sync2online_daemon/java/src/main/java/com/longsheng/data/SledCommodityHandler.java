package com.longsheng.data;

import com.longsheng.table.TableSledCommodity;
import com.longsheng.utils.DaoUtil;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledCommodityOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledCommodity;
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
import java.util.Arrays;
import java.util.List;

public class SledCommodityHandler extends TableHandler {


    private final static String XUEQIAO_SPLIT1 = "[xq_split1]";

    public SledCommodityHandler(Connection connection, QueryRunner runner) throws ErrorInfo {
        super(connection, runner);
    }

    public void insert(TSledCommodity tSledCommodity) throws ErrorInfo, SQLException {

        PreparedFields fields = prepareFields(tSledCommodity);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSledCommodity.TABLE_NAME, fields);
        runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
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
        if (tSledCommodity.isSetSledCommodityId()) {
            fields.addInt(TableSledCommodity.COLUMN_FSLED_COMMODITY_ID, tSledCommodity.getSledCommodityId());
        }
        if (tSledCommodity.isSetCreateTimestamp()) {
            fields.addLong(TableSledCommodity.COLUMN_FCREATE_TIMESTAMP, tSledCommodity.getCreateTimestamp());
        }
        if (tSledCommodity.isSetLastModityTimestamp()) {
            fields.addLong(TableSledCommodity.COLUMN_FLAST_MODIFY_TIMESTAMP, tSledCommodity.getLastModityTimestamp());
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

    public List<TSledCommodity> query(ReqTSledCommodityOption option, int pageIndex, int pageSize) throws SQLException, ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        map2SqlBuilder(option, sqlBuilder);
        sqlBuilder.setPage(pageIndex, pageSize);
        return runner.query(conn, sqlBuilder.getItemsSql() + " for update ", new TSledCommodityHandler(),
                sqlBuilder.getParameterList());
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

            String[] configs = StringUtils.splitByWholeSeparator(rs.getString(TableSledCommodity.COLUMN_FSLED_COMMODITY_CONFIG), XUEQIAO_SPLIT1);
            info.setSledCommodityConfig(Arrays.asList(configs));

            info.setIsAlsoSupportSim(rs.getInt(TableSledCommodity.COLUMN_FIS_ALSO_SUPPORT_SIM) == 1 ? true : false);

            info.setEditstatus(rs.getInt(TableSledCommodity.COLUMN_FEDIT_STATUS));
            info.setWorkingStatus(rs.getInt(TableSledCommodity.COLUMN_FWORKING_STATUS));
            info.setCreateTimestamp(rs.getLong(TableSledCommodity.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getLong(TableSledCommodity.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }

}
