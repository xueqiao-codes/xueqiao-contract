package com.longsheng.data;

import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.table.TableContractVersion;
import com.longsheng.xueqiao.contract.thriftapi.ContractVersion;
import com.longsheng.xueqiao.contract.thriftapi.RemoveContractVersionOption;
import com.longsheng.xueqiao.contract.thriftapi.ReqContractVersionOption;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
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

    public ContractVersionHandler(Connection connection, QueryRunner runner) throws ErrorInfo {
        super(connection, runner);
    }

    public void insert(ContractVersion contractVersion) throws ErrorInfo, SQLException {
        PreparedFields fields = prepareFields(contractVersion);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableContractVersion.TABLE_NAME, fields);
        runner.update(conn, insertSqlBuffer.toString(), fields.getParameters());
    }

    private PreparedFields prepareFields(ContractVersion contractVersion) {
        PreparedFields fields = new PreparedFields();
        if (contractVersion.isSetFileMD5()) {
            fields.addString(TableContractVersion.COLUMN_FFILE_MD5, contractVersion.getFileMD5());
        }
        if (contractVersion.isSetFilePath()) {
            fields.addString(TableContractVersion.COLUMN_FFILE_PATH, contractVersion.getFilePath());
        }
        if (contractVersion.isSetCreateTimestamp()) {
            fields.addLong(TableContractVersion.COLUMN_FCREATE_TIMESTAMP, contractVersion.getCreateTimestamp());
        }
        if (contractVersion.isSetLastModityTimestamp()) {
            fields.addLong(TableContractVersion.COLUMN_FLAST_MODIFY_TIMESTAMP, contractVersion.getLastModityTimestamp());
        }
        if (contractVersion.isSetVersionId()) {
            fields.addInt(TableContractVersion.COLUMN_FVERSION_ID, contractVersion.getVersionId());
        }

        return fields;
    }

    public void remove(RemoveContractVersionOption option) throws ErrorInfo {

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

    public List<ContractVersion> query(ReqContractVersionOption option, int pageIndex, int pageSize) throws ErrorInfo, SQLException {
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

        return runner.query(conn, sqlBuilder.getItemsSql() + " for update ", new TSyncContractMapTaskHandler(),
                sqlBuilder.getParameterList());
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