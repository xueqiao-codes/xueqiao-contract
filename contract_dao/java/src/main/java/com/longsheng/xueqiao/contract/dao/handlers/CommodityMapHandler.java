package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableCommodityMap;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTCommodityMapOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMap;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMapPage;
import com.longsheng.xueqiao.contract.dao.utils.DaoUtil;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
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

public class CommodityMapHandler extends TableHandler {

    public CommodityMapHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(TCommodityMap tCommodityMap) throws ErrorInfo {

        if (!tCommodityMap.isSetBrokerEntryId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommodityMapping brokerEntryId and TechPlatform must set");
        }

        PreparedFields fields = getPreparedFields(tCommodityMap);
        int commodityMappingId;
        try {
            commodityMappingId = ConfigurationProperty.instance().getCommodityMapIdMaker().createIdIntSafe();
            if (commodityMappingId == 0) {
                throw new IdException("commodity map id create failed!");
            }
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "commodity map create failed!");
        }

        fields.addInt(TableCommodityMap.COLUMN_FMAPPING_ID, commodityMappingId);
        int createTime = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableCommodityMap.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableCommodityMap.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);

        String tableName = getTableName(tCommodityMap.getBrokerEntryId());
        StringBuffer createTableBuffer = getCreateTableStringBuffer(tableName);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(tableName, fields);

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            if (!isTableExist(runner, conn, tCommodityMap.getBrokerEntryId())) {
                runner.update(conn, createTableBuffer.toString());
            }
            runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
            conn.commit();
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    private int getTechPlatformBrokerId(int brokerEntryId, int techPlatformValue) {

        if (techPlatformValue != TechPlatform.ESUNNY_3.getValue()) {
            brokerEntryId = 0;
        }
        return brokerEntryId;
    }

    private StringBuffer getCreateTableStringBuffer(String tableName) {
        StringBuffer createTableBuffer = new StringBuffer();
        createTableBuffer.append("CREATE TABLE if not exists ");
        createTableBuffer.append(tableName);

        createTableBuffer.append("(Fmapping_id INT UNSIGNED NOT NULL COMMENT '映射id',");
        createTableBuffer.append("Fsled_commodity_id INT UNSIGNED NOT NULL COMMENT '雪橇商品id',");
        createTableBuffer.append("Ftech_platform SMALLINT UNSIGNED NOT NULL COMMENT '技术平台',");
        createTableBuffer.append("Fplatform_exchange VARCHAR(32) NOT NULL DEFAULT '' COMMENT '技术平台交易所代号',");
        createTableBuffer.append("Fplatform_commodity_type VARCHAR(16) NOT NULL DEFAULT '' COMMENT '技术平台商品类型',");
        createTableBuffer.append("Fplatform_commodity_code VARCHAR(32) NOT NULL DEFAULT '' COMMENT '技术平台商品代号',");
        createTableBuffer.append("Fmoney_ratio DOUBLE UNSIGNED NOT NULL DEFAULT 1.0 COMMENT '价格转换比率 雪橇/平台',");
        createTableBuffer.append("Fbroker_id INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '券商实体信息id',");
        createTableBuffer.append("Factive_start_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活跃开始时间点',");
        createTableBuffer.append("Factive_end_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活跃结束时间点',");
        createTableBuffer.append("Fcreate_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间点',");
        createTableBuffer.append("Flast_modify_timestamp INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后修改时间点',");
        createTableBuffer.append("Fedit_status SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '映射编辑状态',");
        createTableBuffer.append("Fworking_status SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '映射使用状态',");
        createTableBuffer.append("PRIMARY KEY(Fmapping_id)");
        createTableBuffer.append(") CHARSET=utf8mb4, ENGINE=InnoDb");
        return createTableBuffer;
    }

    private String getTableName(int brokerEntryId) {

        return TableCommodityMap.TABLE_NAME +  brokerEntryId;
    }

    private PreparedFields getPreparedFields(TCommodityMap tCommodityMap) {
        PreparedFields fields = new PreparedFields();
        tCommodityMap.setBrokerEntryId(getTechPlatformBrokerId(tCommodityMap.getBrokerEntryId(), tCommodityMap.getTechPlatform()));
        if (tCommodityMap.isSetTechPlatform()) {
            fields.addInt(TableCommodityMap.COLUMN_FTECH_PLATFORM, tCommodityMap.getTechPlatform());
        }
        if (tCommodityMap.isSetSledCommodityId()) {
            fields.addInt(TableCommodityMap.COLUMN_FSLED_COMMODITY_ID, tCommodityMap.getSledCommodityId());
        }
        if (tCommodityMap.isSetCommodityCode()) {
            fields.addString(TableCommodityMap.COLUMN_FPLATFORM_COMMODITY_CODE, tCommodityMap.getCommodityCode());
        }
        if (tCommodityMap.isSetCommodityType()) {
            fields.addString(TableCommodityMap.COLUMN_FPLATFORM_COMMODITY_TYPE, tCommodityMap.getCommodityType());
        }
        if (tCommodityMap.isSetExchange()) {
            fields.addString(TableCommodityMap.COLUMN_FPLATFORM_EXCHANGE, tCommodityMap.getExchange());
        }

        if (tCommodityMap.isSetMoneyRatio()) {
            fields.addDouble(TableCommodityMap.COLUMN_FMONEY_RATIO, tCommodityMap.getMoneyRatio());
        }
        if (tCommodityMap.isSetBrokerEntryId()) {
            fields.addInt(TableCommodityMap.COLUMN_FBROKER_ENTRY_ID, tCommodityMap.getBrokerEntryId());
        }
        if (tCommodityMap.isSetWorkingStatus()) {
            fields.addInt(TableCommodityMap.COLUMN_FWORKING_STATUS, tCommodityMap.getWorkingStatus());
        }
        if (tCommodityMap.isSetEditstatus()) {
            fields.addInt(TableCommodityMap.COLUMN_FEDIT_STATUS, tCommodityMap.getEditstatus());
        }
        if (tCommodityMap.isSetActiveStartTimestamp()) {
            fields.addLong(TableCommodityMap.COLUMN_FACTIVE_START_TIMESTAMP, tCommodityMap.getActiveStartTimestamp());
        }
        if (tCommodityMap.isSetActiveEndTimestamp()) {
            fields.addLong(TableCommodityMap.COLUMN_FACTIVE_END_TIMESTAMP, tCommodityMap.getActiveEndTimestamp());
        }
        return fields;
    }

    private boolean isTableExist(QueryRunner runner, Connection conn, int brokerEntryId) throws SQLException {
        String tableName = getTableName(brokerEntryId);
        SqlQueryBuilder builder = createQueryTableSqlBuilder(tableName);
        int total = runner.query(conn, builder.getTotalCountSql(), new ScalarHandler<Long>(), builder.getParameterList()).intValue();
        if (total > 0) {
            return true;
        }
        return false;
    }

    private SqlQueryBuilder createQueryTableSqlBuilder(String tableName) {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields("count(*)");
        sqlBuilder.addTables("information_schema.TABLES");
        sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, "TABLE_NAME =?", tableName);
        return sqlBuilder;
    }

    private SqlQueryBuilder createSqlBuilder(int brokerEntryId) {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableCommodityMap.COLUMN_FMAPPING_ID,
                TableCommodityMap.COLUMN_FSLED_COMMODITY_ID,
                TableCommodityMap.COLUMN_FTECH_PLATFORM,
                TableCommodityMap.COLUMN_FPLATFORM_EXCHANGE,
                TableCommodityMap.COLUMN_FPLATFORM_COMMODITY_TYPE,
                TableCommodityMap.COLUMN_FPLATFORM_COMMODITY_CODE,
                TableCommodityMap.COLUMN_FMONEY_RATIO,
                TableCommodityMap.COLUMN_FBROKER_ENTRY_ID,
                TableCommodityMap.COLUMN_FWORKING_STATUS,
                TableCommodityMap.COLUMN_FACTIVE_START_TIMESTAMP,
                TableCommodityMap.COLUMN_FACTIVE_END_TIMESTAMP,
                TableCommodityMap.COLUMN_FEDIT_STATUS,
                TableCommodityMap.COLUMN_FCREATE_TIMESTAMP,
                TableCommodityMap.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(getTableName(brokerEntryId));
        return sqlBuilder;
    }

    public TCommodityMapPage query(ReqTCommodityMapOption option, int pageIndex, int pageSize) throws ErrorInfo {

        option.setBrokerEntryId(getTechPlatformBrokerId(option.getBrokerEntryId(), option.getPlatform()));
        SqlQueryBuilder sqlBuilder = createSqlBuilder(option.getBrokerEntryId());

        sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                TableCommodityMap.COLUMN_FBROKER_ENTRY_ID + "=?", option.getBrokerEntryId());

        if (option.isSetEditstatus()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityMap.COLUMN_FEDIT_STATUS + "=?", option.getEditstatus());
        }
        if (option.isSetWorkingStatus()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityMap.COLUMN_FWORKING_STATUS + "=?", option.getWorkingStatus());
        }

        if (option.isSetMapIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityMap.COLUMN_FMAPPING_ID, DaoUtil.map2Set(option.getMapIds()));
        }

        if (option.isSetSledCommodityIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityMap.COLUMN_FSLED_COMMODITY_ID, DaoUtil.map2Set(option.getSledCommodityIds()));
        }

        if (option.isSetCommodityCode()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityMap.COLUMN_FPLATFORM_COMMODITY_CODE + "=?", option.getCommodityCode());
        }

        if (option.isSetCommodityType()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityMap.COLUMN_FPLATFORM_COMMODITY_TYPE + "=?", option.getCommodityType());
        }

        if (option.isSetExchange()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityMap.COLUMN_FPLATFORM_EXCHANGE + "=?", option.getExchange());
        }

        if (option.isSetPlatform()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableCommodityMap.COLUMN_FTECH_PLATFORM + "=?", option.getPlatform());
        }

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        sqlBuilder.setPage(pageIndex, pageSize);
        try {
            TCommodityMapPage page = new TCommodityMapPage();
            int total = 0;
            List<TCommodityMap> list = new ArrayList<>();
            if (isTableExist(runner, conn, option.getBrokerEntryId())) {
                total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
                list = runner.query(conn, sqlBuilder.getItemsSql(), new TCommodityMappingHandler(),
                        sqlBuilder.getParameterList());
            }
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

    public int update(TCommodityMap tCommodityMap) throws ErrorInfo {

        if (!tCommodityMap.isSetMapId()) {
            throw new IllegalArgumentException("CommodityMap mapId must set.");
        }

        if (!tCommodityMap.isSetBrokerEntryId() ) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommodityMapping brokerEntryId must set");
        }
        PreparedFields fields = getPreparedFields(tCommodityMap);

        int createTime = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableCommodityMap.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer updateSqlBuffer = getTableUpdateSqlBuffer(getTableName(tCommodityMap.getBrokerEntryId()), fields);
        String condition = TableCommodityMap.COLUMN_FMAPPING_ID + "=" + tCommodityMap.getMapId();
        updateSqlBuffer.append(condition);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            if (isTableExist(runner, conn, tCommodityMap.getBrokerEntryId())) {
                runner.update(conn, updateSqlBuffer.toString(), fields.getParameters());
            }
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
        return tCommodityMap.getMapId();
    }

    private class TCommodityMappingHandler extends AbstractListHandler<TCommodityMap> {

        @Override
        protected TCommodityMap handleRow(ResultSet rs) throws SQLException {
            TCommodityMap info = new TCommodityMap();
            info.setMapId(rs.getInt(TableCommodityMap.COLUMN_FMAPPING_ID));
            info.setSledCommodityId(rs.getInt(TableCommodityMap.COLUMN_FSLED_COMMODITY_ID));
            info.setTechPlatform(rs.getInt(TableCommodityMap.COLUMN_FTECH_PLATFORM));
            info.setExchange(rs.getString(TableCommodityMap.COLUMN_FPLATFORM_EXCHANGE));
            info.setCommodityType(rs.getString(TableCommodityMap.COLUMN_FPLATFORM_COMMODITY_TYPE));
            info.setCommodityCode(rs.getString(TableCommodityMap.COLUMN_FPLATFORM_COMMODITY_CODE));
            info.setMoneyRatio(rs.getDouble(TableCommodityMap.COLUMN_FMONEY_RATIO));
            info.setEditstatus(rs.getInt(TableCommodityMap.COLUMN_FEDIT_STATUS));
            info.setWorkingStatus(rs.getInt(TableCommodityMap.COLUMN_FWORKING_STATUS));
            info.setBrokerEntryId(rs.getInt(TableCommodityMap.COLUMN_FBROKER_ENTRY_ID));
            info.setActiveStartTimestamp(rs.getLong(TableCommodityMap.COLUMN_FACTIVE_START_TIMESTAMP));
            info.setActiveEndTimestamp(rs.getLong(TableCommodityMap.COLUMN_FACTIVE_END_TIMESTAMP));
            info.setCreateTimestamp(rs.getLong(TableCommodityMap.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getLong(TableCommodityMap.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }
}
