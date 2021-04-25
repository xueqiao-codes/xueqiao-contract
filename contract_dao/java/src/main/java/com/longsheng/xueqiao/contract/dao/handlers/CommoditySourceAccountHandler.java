package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.google.gson.reflect.TypeToken;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableCommoditySourceAccount;
import com.longsheng.xueqiao.contract.dao.utils.GsonFactory;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.soldier.base.AES;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.dal_set.DbUtil;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CommoditySourceAccountHandler extends TableHandler {

    private static final String secretKey = "#Account_Pwd#";

    public CommoditySourceAccountHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(CommoditySourceAccount commoditySource) throws ErrorInfo {

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();

        try {
            insert(commoditySource, runner, conn);
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public void insert(CommoditySourceAccount commoditySource, QueryRunner runner, Connection conn) throws ErrorInfo, SQLException {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(commoditySource);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledExchange fields must set.");
        }

        fields.addInt(TableCommoditySourceAccount.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableCommoditySourceAccount.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableCommoditySourceAccount.TABLE_NAME, fields);
        runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
    }

    private static PreparedFields prepareFields(CommoditySourceAccount commoditySource) {
        PreparedFields fields = new PreparedFields();
        if (commoditySource.isSetAccountName()) {
            fields.addString(TableCommoditySourceAccount.COLUMN_FACCOUNT_NAME, commoditySource.getAccountName());
        }
        if (commoditySource.isSetAccountpwd()) {
//            String pwdEncrypt = AES.encrypt(commoditySource.getAccountpwd(), secretKey);
            String pwdEncrypt = commoditySource.getAccountpwd();
            fields.addString(TableCommoditySourceAccount.COLUMN_FACCOUNT_PWD, pwdEncrypt);
        }
        if (commoditySource.isSetTechPlatformEnv()) {
            fields.addInt(TableCommoditySourceAccount.COLUMN_FTECH_PLATFORM_ENV, commoditySource.getTechPlatformEnv().getValue());
        }
        if (commoditySource.isSetTechPlatform()) {
            fields.addInt(TableCommoditySourceAccount.COLUMN_FTECH_PLATFORM, commoditySource.getTechPlatform().getValue());
        }
        if (commoditySource.isSetBrokerEntryId()) {
            fields.addInt(TableCommoditySourceAccount.COLUMN_FBROKER_ID, commoditySource.getBrokerEntryId());
        }
        if (commoditySource.isSetBrokerAccessId()) {
            fields.addInt(TableCommoditySourceAccount.COLUMN_FBROKER_ACCESS_ID, commoditySource.getBrokerAccessId());
        }
        if (commoditySource.isSetAccountProperties()) {

            String data = GsonFactory.getInstance().getGson().toJson(commoditySource.getAccountProperties());
            fields.addString(TableCommoditySourceAccount.COLUMN_FACCOUNT_PROPERTIES, data);
        }
        if (commoditySource.isSetAccessState()) {
            fields.addInt(TableCommoditySourceAccount.COLUMN_FACCOUNT_ACCESS_STATE, commoditySource.getAccessState().getValue());
        }
        if (commoditySource.isSetInvalidReason()) {
            fields.addString(TableCommoditySourceAccount.COLUMN_FINVALID_REASON, commoditySource.getInvalidReason());
        }
        if (commoditySource.isSetApiRetCode()) {
            fields.addInt(TableCommoditySourceAccount.COLUMN_FAPI_RET_CODE, commoditySource.getApiRetCode());
        }
        if (commoditySource.isSetIpAddress()) {
            fields.addString(TableCommoditySourceAccount.COLUMN_FIP_ADDRESS, commoditySource.getIpAddress());
        }
        if (commoditySource.isSetPort()) {
            fields.addInt(TableCommoditySourceAccount.COLUMN_FPORT, commoditySource.getPort());
        }
        return fields;
    }

    public void update(CommoditySourceAccount commoditySourceAccount) throws ErrorInfo {

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            update(commoditySourceAccount, runner, conn);
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public static void update(CommoditySourceAccount commoditySource, QueryRunner runner, Connection conn) throws ErrorInfo, SQLException {
        if (!commoditySource.isSetAccountId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommoditySourceAccount field AccountId must set.");
        }
        PreparedFields fields = prepareFields(commoditySource);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommoditySourceAccount fields must set.");
        }
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableCommoditySourceAccount.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableCommoditySourceAccount.TABLE_NAME, fields);
        String condition = TableCommoditySourceAccount.COLUMN_FACCOUNT_ID + "=" + commoditySource.getAccountId();
        sqlBuffer.append(condition);

        runner.update(conn, sqlBuffer.toString(), fields.getParameters());
    }

    private static SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableCommoditySourceAccount.COLUMN_FACCOUNT_ID,
                TableCommoditySourceAccount.COLUMN_FACCOUNT_NAME,
                TableCommoditySourceAccount.COLUMN_FACCOUNT_PWD,
                TableCommoditySourceAccount.COLUMN_FBROKER_ID,
                TableCommoditySourceAccount.COLUMN_FBROKER_ACCESS_ID,
                TableCommoditySourceAccount.COLUMN_FACCOUNT_PROPERTIES,
                TableCommoditySourceAccount.COLUMN_FACCOUNT_ACCESS_STATE,
                TableCommoditySourceAccount.COLUMN_FINVALID_REASON,
                TableCommoditySourceAccount.COLUMN_FIP_ADDRESS,
                TableCommoditySourceAccount.COLUMN_FAPI_RET_CODE,
                TableCommoditySourceAccount.COLUMN_FPORT,
                TableCommoditySourceAccount.COLUMN_FTECH_PLATFORM,
                TableCommoditySourceAccount.COLUMN_FTECH_PLATFORM_ENV,
                TableCommoditySourceAccount.COLUMN_FCREATE_TIMESTAMP,
                TableCommoditySourceAccount.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableCommoditySourceAccount.TABLE_NAME);
        return sqlBuilder;
    }

    public CommoditySourceAccountPage query(ReqCommoditySourceAccountOption option) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            return query(option, runner, conn);
        } catch (SQLException e) {
            AppLog.e("Error occurs at query.", e);
            throw new ErrorInfo(ErrorCodeInner.DB_SELECT_FAILED.getErrorCode(),
                    ErrorCodeInner.DB_SELECT_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public static CommoditySourceAccountPage query(ReqCommoditySourceAccountOption option, QueryRunner runner, Connection conn) throws SQLException {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.getAccountIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableCommoditySourceAccount.COLUMN_FACCOUNT_ID,
                    option.getAccountIds());
        }
        CommoditySourceAccountPage page = new CommoditySourceAccountPage();
        if (option.isSetPageOption()) {
            if (option.getPageOption().isNeedTotalCount()) {
                int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
                page.setTotal(total);
            }
            if (option.getPageOption().getPageSize() > 0) {
                sqlBuilder.setPage(option.getPageOption().getPageIndex(), option.getPageOption().getPageSize());
            }
        }
        List<CommoditySourceAccount> list = runner.query(conn, sqlBuilder.getItemsSql(), new TCommoditySourceHandler(),
                sqlBuilder.getParameterList());
        page.setPage(list);
        return page;
    }

    private static class TCommoditySourceHandler extends AbstractListHandler<CommoditySourceAccount> {

        @Override
        protected CommoditySourceAccount handleRow(ResultSet rs) throws SQLException {
            CommoditySourceAccount info = new CommoditySourceAccount();
            info.setAccountId(rs.getInt(TableCommoditySourceAccount.COLUMN_FACCOUNT_ID));
            info.setAccountName(rs.getString(TableCommoditySourceAccount.COLUMN_FACCOUNT_NAME));

            String pwdEncrypt = rs.getString(TableCommoditySourceAccount.COLUMN_FACCOUNT_PWD);
            if (!"".equals(pwdEncrypt)) {
//                info.setAccountpwd(AES.decrypt(pwdEncrypt, secretKey));
                info.setAccountpwd(pwdEncrypt);

            }
            info.setBrokerAccessId(rs.getInt(TableCommoditySourceAccount.COLUMN_FBROKER_ACCESS_ID));
            info.setBrokerEntryId(rs.getInt(TableCommoditySourceAccount.COLUMN_FBROKER_ID));

            Map<String, String> accountProperties = GsonFactory.getInstance().getGson()
                    .fromJson(rs.getString(TableCommoditySourceAccount.COLUMN_FACCOUNT_PROPERTIES)
                            , new TypeToken<HashMap<String, String>>() {
                            }.getType());
            info.setAccountProperties(accountProperties);
            info.setAccessState(AccountAccessState.findByValue(rs.getInt(TableCommoditySourceAccount.COLUMN_FACCOUNT_ACCESS_STATE)));
            info.setInvalidReason(rs.getString(TableCommoditySourceAccount.COLUMN_FINVALID_REASON));
            info.setIpAddress(rs.getString(TableCommoditySourceAccount.COLUMN_FIP_ADDRESS));
            info.setApiRetCode(rs.getInt(TableCommoditySourceAccount.COLUMN_FAPI_RET_CODE));
            info.setPort(rs.getInt(TableCommoditySourceAccount.COLUMN_FPORT));
            info.setTechPlatformEnv(TechPlatformEnv.findByValue(rs.getInt(TableCommoditySourceAccount.COLUMN_FTECH_PLATFORM_ENV)));
            info.setTechPlatform(TechPlatform.findByValue(rs.getInt(TableCommoditySourceAccount.COLUMN_FTECH_PLATFORM)));
            info.setCreateTimestamp(rs.getLong(TableCommoditySourceAccount.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModifyTimestamp(rs.getLong(TableCommoditySourceAccount.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }
}
