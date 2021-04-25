package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableContractVersion;
import com.longsheng.xueqiao.contract.thriftapi.ContractVersion;
import com.longsheng.xueqiao.contract.thriftapi.ContractVersionPage;
import com.longsheng.xueqiao.contract.thriftapi.RemoveContractVersionOption;
import com.longsheng.xueqiao.contract.thriftapi.ReqContractVersionOption;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.DbUtil;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContractVersionHandler extends TableHandler {

    public ContractVersionHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public int insert(ContractVersion contractVersion) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = prepareFields(contractVersion);

        fields.addInt(TableContractVersion.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableContractVersion.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableContractVersion.TABLE_NAME, fields);

        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        sqlBuilder.setPage(0, 1);
        sqlBuilder.setOrder(SqlQueryBuilder.OrderType.DESC, TableContractVersion.COLUMN_FVERSION_ID);

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        int versionId;
        try {
            conn.setAutoCommit(false);
            runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
            AppLog.d("insert version time : " + createTime);
            List<ContractVersion> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSyncContractMapTaskHandler(),
                    sqlBuilder.getParameterList());
            if (list.isEmpty()) {
                throw new SQLException("version query fail.");
            }
            versionId = list.get(0).getVersionId();
            AppLog.d("query version time : " + list.get(0).getCreateTimestamp());
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }

        return versionId;
    }

    private PreparedFields prepareFields(ContractVersion contractVersion) {
        PreparedFields fields = new PreparedFields();
        if (contractVersion.isSetFileMD5()) {
            fields.addString(TableContractVersion.COLUMN_FFILE_MD5, contractVersion.getFileMD5());
        }
        if (contractVersion.isSetFilePath()) {
            fields.addString(TableContractVersion.COLUMN_FFILE_PATH, contractVersion.getFilePath());
        }

        return fields;
    }

    public int update(ContractVersion contractVersion) throws ErrorInfo {

        if (!contractVersion.isSetVersionId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TContractVersion field VersionId must set.");
        }
        PreparedFields fields = prepareFields(contractVersion);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TContractVersion fields must set.");
        }
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableContractVersion.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableContractVersion.TABLE_NAME, fields);
        String condition = TableContractVersion.COLUMN_FVERSION_ID + "=" + contractVersion.getVersionId();
        sqlBuffer.append(condition);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            runner.update(conn, sqlBuffer.toString(), fields.getParameters());
            return contractVersion.getVersionId();
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_OP_FAILED.getErrorCode(), ErrorCodeInner.DB_OP_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public void remove(RemoveContractVersionOption option) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            String deleteStr = "delete from " + TableContractVersion.TABLE_NAME;
            String condition;
            if (option.isAll()) {
                condition = "";
            } else if (option.isSetVersionId()) {
                condition = " where " + TableContractVersion.COLUMN_FVERSION_ID + " = " + option.getVersionId();
            } else {
                throw new IllegalArgumentException("One of option fields must set.");
            }
            deleteStr = deleteStr + condition;
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
                TableContractVersion.COLUMN_FVERSION_ID,
                TableContractVersion.COLUMN_FFILE_MD5,
                TableContractVersion.COLUMN_FFILE_PATH,
                TableContractVersion.COLUMN_FCREATE_TIMESTAMP,
                TableContractVersion.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableContractVersion.TABLE_NAME);
        return sqlBuilder;
    }

    public ContractVersionPage query(ReqContractVersionOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();


        if (option.isLatest()) {
            sqlBuilder.setPage(0, 1);
            sqlBuilder.setOrder(SqlQueryBuilder.OrderType.DESC, TableContractVersion.COLUMN_FVERSION_ID);
        } else {
            sqlBuilder.setPage(pageIndex, pageSize);
        }
        if (option.isSetVersionId()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, TableContractVersion.COLUMN_FVERSION_ID + "=?", option.getVersionId());
        }

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            ContractVersionPage page = new ContractVersionPage();
            List<ContractVersion> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSyncContractMapTaskHandler(),
                    sqlBuilder.getParameterList());
            if (!option.isLatest()) {
                int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
                page.setTotal(total);
            }else {
                page.setTotal(list.size());
            }

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

    private class TSyncContractMapTaskHandler extends AbstractListHandler<ContractVersion> {

        @Override
        protected ContractVersion handleRow(ResultSet rs) throws SQLException {
            ContractVersion info = new ContractVersion();
            info.setVersionId(rs.getInt(TableContractVersion.COLUMN_FVERSION_ID));
            info.setFileMD5(rs.getString(TableContractVersion.COLUMN_FFILE_MD5));
            info.setFilePath(rs.getString(TableContractVersion.COLUMN_FFILE_PATH));
            info.setCreateTimestamp(rs.getLong(TableContractVersion.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getLong(TableContractVersion.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }

}