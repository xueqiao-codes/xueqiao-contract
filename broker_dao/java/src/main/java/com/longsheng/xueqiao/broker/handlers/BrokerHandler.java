package com.longsheng.xueqiao.broker.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.broker.config.ConfigurationProperty;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.page.Page;
import com.longsheng.xueqiao.broker.tables.TableBroker;
import com.longsheng.xueqiao.broker.thriftapi.BrokerEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform;
import com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv;
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
import java.util.*;

public class BrokerHandler extends TableHandler {
    public BrokerHandler(TServiceCntl oCntl) {
        super(oCntl);
    }

    public int insert(BrokerEntry brokerEntry) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(brokerEntry);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "BrokerEntry fields must set.");
        }

        int brokerId;
        try {
            brokerId = ConfigurationProperty.instance().getBrokerIdMaker().createIdIntSafe();
            if (brokerId == 0) {
                throw new IdException("broker id create failed!");
            }
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "broker create failed!");
        }

        if (!brokerEntry.isSetCnName() || "".equals(brokerEntry.getCnName().trim())) {
            fields.addString(TableBroker.COLUMN_FCN_NAME, getDefaultName(brokerId));
        }
        if (!brokerEntry.isSetEngName() || "".equals(brokerEntry.getEngName().trim())) {
            fields.addString(TableBroker.COLUMN_FENG_NAME, getDefaultName(brokerId));
        }

        fields.addInt(TableBroker.COLUMN_FBROKER_ID, brokerId);
        fields.addInt(TableBroker.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableBroker.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableBroker.TABLE_NAME, fields);

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
        return brokerId;
    }

    private static String getName(String recordString, int userId) {
        if (recordString.equals(getDefaultName(userId))) {
            return "";
        } else {
            return recordString;
        }
    }

    private static String getDefaultName(int userId) {
        return "#" + userId + "#";
    }


    private PreparedFields prepareFields(BrokerEntry brokerEntry) {
        PreparedFields fields = new PreparedFields();
        if (brokerEntry.isSetCnName()) {
            fields.addString(TableBroker.COLUMN_FCN_NAME, brokerEntry.getCnName());
        }
        if (brokerEntry.isSetEngName()) {
            fields.addString(TableBroker.COLUMN_FENG_NAME, brokerEntry.getEngName());
        }
        if (brokerEntry.isSetNote()) {
            fields.addString(TableBroker.COLUMN_FNOTE, brokerEntry.getNote());
        }
        if (brokerEntry.isSetTechPlatformEnvs()) {
            Set<String> envNames = new HashSet<>();
            for (TechPlatformEnv env : brokerEntry.getTechPlatformEnvs()) {
                envNames.add(env.name());
            }
            fields.addString(TableBroker.COLUMN_FTECH_PLATFORM_ENV_FLAG, StringUtils.join(envNames, ","));
        }
        if (brokerEntry.isSetTechPlatforms()) {
            Set<String> platformNames = new HashSet<>();
            for (BrokerPlatform platform : brokerEntry.getTechPlatforms()) {
                platformNames.add(platform.name());
            }
            fields.addString(TableBroker.COLUMN_FTECH_PLATFORM_FLAG, StringUtils.join(platformNames, ","));
        }
        return fields;
    }

    public int update(BrokerEntry brokerEntry) throws ErrorInfo {

        if (!brokerEntry.isSetBrokerId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "BrokerId field TaskId must set.");
        }
        PreparedFields fields = prepareFields(brokerEntry);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "BrokerEntry fields must set.");
        }
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableBroker.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableBroker.TABLE_NAME, fields);
        String condition = TableBroker.COLUMN_FBROKER_ID + "=" + brokerEntry.getBrokerId();
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
        return brokerEntry.getBrokerId();
    }

    public void removeBrokerEntry(int brokerEntryId) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            String deleteStr = "delete from " + TableBroker.TABLE_NAME + " where " + TableBroker.COLUMN_FBROKER_ID + " =" + brokerEntryId;
            runner.update(conn, deleteStr);
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
                TableBroker.COLUMN_FBROKER_ID,
                TableBroker.COLUMN_FENG_NAME,
                TableBroker.COLUMN_FCN_NAME,
                TableBroker.COLUMN_FNOTE,
                TableBroker.COLUMN_FTECH_PLATFORM_ENV_FLAG,
                TableBroker.COLUMN_FTECH_PLATFORM_FLAG,
                TableBroker.COLUMN_FCREATE_TIMESTAMP,
                TableBroker.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableBroker.TABLE_NAME);
        return sqlBuilder;
    }

    public Page<BrokerEntry> query(ReqBrokerEntryOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();

        if (option.isSetBrokerIds() && option.getBrokerIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBroker.COLUMN_FBROKER_ID, getSet(option.getBrokerIds()));
        }
        if (option.isSetCnNameWhole()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBroker.COLUMN_FCN_NAME + "=?", option.getCnNameWhole());
        }
        if (option.isSetEngNameWhole()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBroker.COLUMN_FENG_NAME + "=?", option.getEngNameWhole());
        }
        if (option.isSetCnNamePartical()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND
                    , TableBroker.COLUMN_FCN_NAME + " like ?"
                    , "%" + option.getCnNamePartical().trim() + "%");
        }
        if (option.isSetEngNamePartical()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND
                    , TableBroker.COLUMN_FENG_NAME + " like ?"
                    , "%" + option.getEngNamePartical().trim() + "%");
        }
        if (option.isSetEnv()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBroker.COLUMN_FTECH_PLATFORM_ENV_FLAG + " like ?"
                    , "%" + option.getEnv().name() + "%");
        }
        if (option.isSetPlatform()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBroker.COLUMN_FTECH_PLATFORM_FLAG + " like ?"
                    , "%" + option.getPlatform().name() + "%");
        }

        sqlBuilder.setPage(pageIndex, pageSize);
        SqlQueryBuilder.OrderType orderType = SqlQueryBuilder.OrderType.DESC;
        if (option.isOrderAsc()) {
            orderType = SqlQueryBuilder.OrderType.ASC;
        }
        if (option.isSetOrderByCreateTimestamp()){
            sqlBuilder.setOrder(orderType, TableBroker.COLUMN_FCREATE_TIMESTAMP);
        }
        if (option.isSetOrderByBrokerName()) {
            sqlBuilder.setOrderChinese(orderType, TableBroker.COLUMN_FCN_NAME);
        }else {
            sqlBuilder.setOrder(orderType, TableBroker.COLUMN_FCREATE_TIMESTAMP);
        }
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        AppLog.d("sql: " + sqlBuilder.getItemsSql());
        try {
            Page<BrokerEntry> page = new Page<BrokerEntry>();
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
            page.setTotal(total);
            List<BrokerEntry> list = runner.query(conn, sqlBuilder.getItemsSql(), new TBrokerEntryHandler(),
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

    private Set<Integer> getSet(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : list) {
            if (i != null) {
                set.add(i);
            }
        }
        return set;
    }

    private class TBrokerEntryHandler extends AbstractListHandler<BrokerEntry> {

        @Override
        protected BrokerEntry handleRow(ResultSet rs) throws SQLException {
            BrokerEntry info = new BrokerEntry();
            info.setBrokerId(rs.getInt(TableBroker.COLUMN_FBROKER_ID));
            info.setEngName(getName(rs.getString(TableBroker.COLUMN_FENG_NAME), info.getBrokerId()));
            info.setCnName(getName(rs.getString(TableBroker.COLUMN_FCN_NAME), info.getBrokerId()));
            info.setNote(rs.getString(TableBroker.COLUMN_FNOTE));
            List<TechPlatformEnv> envs = new ArrayList<>();
            info.setTechPlatformEnvs(envs);
            String envsStr = rs.getString(TableBroker.COLUMN_FTECH_PLATFORM_ENV_FLAG);
            String[] names = StringUtils.split(envsStr, ",");
            for (String name : names) {
                info.addToTechPlatformEnvs(TechPlatformEnv.valueOf(name));
            }

            List<BrokerPlatform> platforms = new ArrayList<>();
            info.setTechPlatforms(platforms);
            String platformsStr = rs.getString(TableBroker.COLUMN_FTECH_PLATFORM_FLAG);
            String[] platformNames = StringUtils.split(platformsStr, ",");
            for (String name : platformNames) {
                info.addToTechPlatforms(BrokerPlatform.valueOf(name));
            }
            info.setCreateTimestamp(rs.getInt(TableBroker.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getInt(TableBroker.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }
}
