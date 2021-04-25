package com.longsheng.xueqiao.broker.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.broker.config.ConfigurationProperty;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.page.Page;
import com.longsheng.xueqiao.broker.tables.TableBrokerAccess;
import com.longsheng.xueqiao.broker.thriftapi.*;
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

public class BrokerAccessHandler extends TableHandler {
    public BrokerAccessHandler(TServiceCntl oCntl) {
        super(oCntl);
    }

    private final static String XUEQIAO_SPLIT1 = "[xq_split1]";
    private final static String XUEQIAO_SPLIT2 = "[xq_split2]";

    public int insert(BrokerAccessEntry brokerAccessEntry) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        brokerAccessEntry.setWorkingStatus(BrokerAccessWorkingStatus.NOT_WORKING);
        brokerAccessEntry.setStatus(BrokerAccessStatus.NEW);
        if (!brokerAccessEntry.isSetAccessName() || "".equals(brokerAccessEntry.getAccessName().trim())) {
            brokerAccessEntry.setAccessName("默认席位");
        }
        if (!brokerAccessEntry.isSetTradeAddresses()) {
            brokerAccessEntry.setTradeAddresses(new ArrayList<>());
        }
        if (!brokerAccessEntry.isSetQuotaAddresses()) {
            brokerAccessEntry.setQuotaAddresses(new ArrayList<>());
        }
        if (!brokerAccessEntry.isSetCustomInfoMap()) {
            brokerAccessEntry.setCustomInfoMap(new HashMap<>());
        }
        PreparedFields fields = prepareFields(brokerAccessEntry);
        if (!brokerAccessEntry.isSetBrokerId() || !brokerAccessEntry.isSetPlatform()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "BrokerAccessEntry BrokerId and Platform must set.");
        }

        int brokerAccessId;
        try {
            brokerAccessId = ConfigurationProperty.instance().getBrokerAccessIdMaker().createIdIntSafe();
            if (brokerAccessId == 0) {
                throw new IdException("broker access id create failed!");
            }
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "broker access create failed!");
        }

        fields.addInt(TableBrokerAccess.COLUMN_FENTRY_ID, brokerAccessId);
        fields.addInt(TableBrokerAccess.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableBrokerAccess.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableBrokerAccess.TABLE_NAME, fields);

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
        return brokerAccessId;
    }

    private PreparedFields prepareFields(BrokerAccessEntry brokerAccessEntry) throws ErrorInfo {
        PreparedFields fields = new PreparedFields();
        if (brokerAccessEntry.isSetBrokerId()) {
            fields.addInt(TableBrokerAccess.COLUMN_FBROKER_ID, brokerAccessEntry.getBrokerId());
        }
        if (brokerAccessEntry.isSetPlatform()) {
            fields.addInt(TableBrokerAccess.COLUMN_FPLATFORM, brokerAccessEntry.getPlatform().getValue());
        }
        if (brokerAccessEntry.isSetQuotaAddresses()) {

            List<AccessAddress> list = brokerAccessEntry.getQuotaAddresses();
            String quotaAddress = getAddressString(list);

            fields.addString(TableBrokerAccess.COLUMN_FQUOTA_ADDRESS, quotaAddress);
        }
        if (brokerAccessEntry.isSetTradeAddresses()) {
            List<AccessAddress> list = brokerAccessEntry.getTradeAddresses();
            String tradeAddress = getAddressString(list);

            fields.addString(TableBrokerAccess.COLUMN_FTRADE_ADDRESS, tradeAddress);
        }
        if (brokerAccessEntry.isSetAccessName()) {
            fields.addString(TableBrokerAccess.COLUMN_FACCESS_NAME, brokerAccessEntry.getAccessName());
        }
        if (brokerAccessEntry.isSetCustomInfoMap()) {
            Map<String, String> map = brokerAccessEntry.getCustomInfoMap();
            StringBuffer mapString = buildCustomInfo(map);
            fields.addString(TableBrokerAccess.COLUMN_FACCESS_INFO_MAP, mapString.toString());
        }
        if (brokerAccessEntry.isSetStatus()) {
            fields.addInt(TableBrokerAccess.COLUMN_FSTATUS, brokerAccessEntry.getStatus().getValue());
        }
        if (brokerAccessEntry.isSetWorkingStatus()) {
            fields.addInt(TableBrokerAccess.COLUMN_FWORKING_STATUS, brokerAccessEntry.getWorkingStatus().getValue());
        }
        if (brokerAccessEntry.isSetTechPlatformEnv()) {
            fields.addInt(TableBrokerAccess.COLUMN_FTECH_PLATFORM_ENV, brokerAccessEntry.getTechPlatformEnv().getValue());
        }
        return fields;
    }

    private String getAddressString(List<AccessAddress> list) throws ErrorInfo {
        List<String> ipList = new ArrayList<>();
        for (AccessAddress address : list) {

            if (!address.isSetAddress() || "".equals(address.getAddress().trim())) {
                throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_ADDRESS_ERROR.getValue(), "adsress error.");
            }
            if (!address.isSetPort() || address.getPort() <= 0) {
                throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_ADDRESS_PORT_ERROR.getValue(), "adsress port error.");
            }

            ipList.add(address.getAddress() + XUEQIAO_SPLIT2 + address.getPort());
        }

        return StringUtils.join(ipList, XUEQIAO_SPLIT1);
    }

    private StringBuffer buildCustomInfo(Map<String, String> map) {
        Iterator<String> iterator = map.keySet().iterator();
        StringBuffer mapString = new StringBuffer();
        int index = 0;
        while (iterator.hasNext()) {
            if (index > 0) {
                mapString.append(XUEQIAO_SPLIT1);
            }
            String key = iterator.next();
            String value = map.get(key);
            mapString.append(key);
            mapString.append(XUEQIAO_SPLIT2);
            mapString.append(value);
            index++;
        }
        return mapString;
    }

    public int update(BrokerAccessEntry brokerEntry) throws ErrorInfo {

        if (!brokerEntry.isSetEntryId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "BrokerAccessEntry field EntryId must set.");
        }
        PreparedFields fields = prepareFields(brokerEntry);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "BrokerAccessEntry fields must set.");
        }
        int timeNow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableBrokerAccess.COLUMN_FLAST_MODIFY_TIMESTAMP, timeNow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableBrokerAccess.TABLE_NAME, fields);
        String condition = TableBrokerAccess.COLUMN_FENTRY_ID + "=" + brokerEntry.getEntryId();
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

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableBrokerAccess.COLUMN_FENTRY_ID,
                TableBrokerAccess.COLUMN_FBROKER_ID,
                TableBrokerAccess.COLUMN_FPLATFORM,
                TableBrokerAccess.COLUMN_FTRADE_ADDRESS,
                TableBrokerAccess.COLUMN_FQUOTA_ADDRESS,
                TableBrokerAccess.COLUMN_FACCESS_NAME,
                TableBrokerAccess.COLUMN_FTRADE_ADDRESS,
                TableBrokerAccess.COLUMN_FACCESS_INFO_MAP,
                TableBrokerAccess.COLUMN_FSTATUS,
                TableBrokerAccess.COLUMN_FWORKING_STATUS,
                TableBrokerAccess.COLUMN_FTECH_PLATFORM_ENV,
                TableBrokerAccess.COLUMN_FCREATE_TIMESTAMP,
                TableBrokerAccess.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableBrokerAccess.TABLE_NAME);
        return sqlBuilder;
    }

    public void removeBrokerAccessEntry(int brokerAccessEntryId) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            String deleteStr = "delete from " + TableBrokerAccess.TABLE_NAME + " where " + TableBrokerAccess.COLUMN_FENTRY_ID + " =" + brokerAccessEntryId;
            runner.update(conn, deleteStr);
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public Page<BrokerAccessEntry> query(ReqBrokerAccessEntryOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();

        if (option.isSetBrokerIds() && option.getBrokerIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBrokerAccess.COLUMN_FBROKER_ID, getSet(option.getBrokerIds()));
        }
        if (option.isSetPlatform()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBrokerAccess.COLUMN_FPLATFORM + " =? ", option.getPlatform().getValue());
        }
        if (option.isSetAccessStatus()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBrokerAccess.COLUMN_FSTATUS + "=?", option.getAccessStatus().getValue());
        }
        if (option.isSetWorkingStatus()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBrokerAccess.COLUMN_FWORKING_STATUS + "=?", option.getWorkingStatus().getValue());
        }
        if (option.isSetEntryIds() && option.getEntryIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBrokerAccess.COLUMN_FENTRY_ID, getSet(option.getEntryIds()));
        }
        if (option.isSetAccessName() && !"".equals(option.getAccessName().trim())) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND,
                    TableBrokerAccess.COLUMN_FACCESS_NAME + " =? ", option.getAccessName());
        }
        if (option.isSetEnv()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, TableBrokerAccess.COLUMN_FTECH_PLATFORM_ENV + "=?", option.getEnv().getValue());
        }
        if (option.isSetPlatforms() && option.getPlatformsSize() > 0) {
            Set<Integer> platformIds = new HashSet<>();
            for (BrokerPlatform brokerPlatform : option.getPlatforms()) {
                platformIds.add(brokerPlatform.getValue());
            }
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableBrokerAccess.COLUMN_FPLATFORM, platformIds);
        }

        sqlBuilder.setPage(pageIndex, pageSize);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        AppLog.d("sql: " + sqlBuilder.getItemsSql());
        try {
            Page<BrokerAccessEntry> page = new Page<BrokerAccessEntry>();
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
            page.setTotal(total);
            List<BrokerAccessEntry> list = runner.query(conn, sqlBuilder.getItemsSql(), new TBrokerAccessEntryHandler(),
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

    private class TBrokerAccessEntryHandler extends AbstractListHandler<BrokerAccessEntry> {

        @Override
        protected BrokerAccessEntry handleRow(ResultSet rs) throws SQLException {
            BrokerAccessEntry info = new BrokerAccessEntry();
            info.setEntryId(rs.getInt(TableBrokerAccess.COLUMN_FENTRY_ID));
            info.setBrokerId(rs.getInt(TableBrokerAccess.COLUMN_FBROKER_ID));
            info.setPlatform(BrokerPlatform.findByValue(rs.getInt(TableBrokerAccess.COLUMN_FPLATFORM)));
            info.setAccessName(rs.getString(TableBrokerAccess.COLUMN_FACCESS_NAME));

            String address = rs.getString(TableBrokerAccess.COLUMN_FQUOTA_ADDRESS);
            List<AccessAddress> list = getAccessAddresses(address);
            info.setQuotaAddresses(list);

            String tradeAddress = rs.getString(TableBrokerAccess.COLUMN_FTRADE_ADDRESS);
            List<AccessAddress> tradeList = getAccessAddresses(tradeAddress);
            info.setTradeAddresses(tradeList);

            String cumstom = rs.getString(TableBrokerAccess.COLUMN_FACCESS_INFO_MAP);
            Map<String, String> map = getStringStringMap(cumstom);
            info.setCustomInfoMap(map);
            info.setWorkingStatus(BrokerAccessWorkingStatus.findByValue(rs.getInt(TableBrokerAccess.COLUMN_FWORKING_STATUS)));
            info.setTechPlatformEnv(TechPlatformEnv.findByValue(rs.getInt(TableBrokerAccess.COLUMN_FTECH_PLATFORM_ENV)));
            info.setStatus(BrokerAccessStatus.findByValue(rs.getInt(TableBrokerAccess.COLUMN_FSTATUS)));
            info.setCreateTimestamp(rs.getInt(TableBrokerAccess.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getInt(TableBrokerAccess.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }

        private List<AccessAddress> getAccessAddresses(String address) {
            List<AccessAddress> list = new ArrayList<>();
            String[] addressList = StringUtils.splitByWholeSeparator(address, XUEQIAO_SPLIT1);
            for (String s : addressList) {
                String[] pair = StringUtils.splitByWholeSeparator(s, XUEQIAO_SPLIT2);
                AccessAddress accessAddress = new AccessAddress();
                if (pair.length > 0) {
                    accessAddress.setAddress(pair[0]);
                    if (pair.length > 1)
                        accessAddress.setPort(Integer.parseInt(pair[1]));
                    list.add(accessAddress);
                }
            }
            return list;
        }

        private Map<String, String> getStringStringMap(String cumstom) throws SQLException {
//           server_address[xq_spit2]tcp://218.76.45.156:41205,tcp://218.76.45.156:41205[xq_spit1]broker_code[xq_spit2]9999
            Map<String, String> map = new HashMap<>();
            String[] pairs = StringUtils.splitByWholeSeparator(cumstom, XUEQIAO_SPLIT1);
            for (String s : pairs) {
                String[] pair = StringUtils.splitByWholeSeparator(s, XUEQIAO_SPLIT2);
                if (pair.length == 2) {
                    map.put(pair[0], pair[1]);
                } else {
                    throw new SQLException("TableBroker.COLUMN_FCUSTOM_INFO_MAP data error.");
                }
            }
            return map;
        }
    }
}
