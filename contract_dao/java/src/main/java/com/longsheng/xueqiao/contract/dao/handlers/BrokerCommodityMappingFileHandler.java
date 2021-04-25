package com.longsheng.xueqiao.contract.dao.handlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.DbUtil;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableBrokerCommodityMappingFile;
import com.longsheng.xueqiao.contract.dao.utils.DaoUtil;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfoPage;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileStatus;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption;

public class BrokerCommodityMappingFileHandler extends TableHandler {

    public BrokerCommodityMappingFileHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void insert(CommodityMapFileInfo fileInfo) throws ErrorInfo {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        if (!fileInfo.isSetBrokerEntryId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommodityMapFileInfo field BrokerEntryId must set.");
        }
        if (!fileInfo.isSetVersion()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommodityMapFileInfo field Version must set.");
        }
        PreparedFields fields = prepareFields(fileInfo);

        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommodityMapFileInfo fields must set.");
        }
        fields.addInt(TableBrokerCommodityMappingFile.COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(TableBrokerCommodityMappingFile.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableBrokerCommodityMappingFile.TABLE_NAME, fields);
        PreparedFields updateFields = new PreparedFields();
        updateFields.addInt(TableBrokerCommodityMappingFile.COLUMN_FSTATUS, CommodityMapFileStatus.NO_USE.getValue());
        StringBuffer updateSql = getTableUpdateSqlBuffer(TableBrokerCommodityMappingFile.TABLE_NAME, updateFields);
        String condition = TableBrokerCommodityMappingFile.COLUMN_FBROKER_ID + "=" + fileInfo.getBrokerEntryId();
        updateSql.append(condition);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            runner.update(conn,updateSql.toString(),updateFields.getParameters());
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

    private PreparedFields prepareFields(CommodityMapFileInfo fileInfo) {
        PreparedFields fields = new PreparedFields();
        if (fileInfo.isSetBrokerEntryId()) {
            fields.addInt(TableBrokerCommodityMappingFile.COLUMN_FBROKER_ID, fileInfo.getBrokerEntryId());
        }
        if (fileInfo.isSetFileMD5()) {
            fields.addString(TableBrokerCommodityMappingFile.COLUMN_FFILE_MD5, fileInfo.getFileMD5());
        }
        if (fileInfo.isSetPath()) {
            fields.addString(TableBrokerCommodityMappingFile.COLUMN_FFILE_PATH, fileInfo.getPath());
        }
        if (fileInfo.isSetTechPlatform()) {
            fields.addInt(TableBrokerCommodityMappingFile.COLUMN_FTECH_PLATFORM, fileInfo.getTechPlatform().getValue());
        }
        if (fileInfo.isSetVersion()) {
            fields.addInt(TableBrokerCommodityMappingFile.COLUMN_FVERSION, fileInfo.getVersion());
        }
        return fields;
    }

    public void update(CommodityMapFileInfo commodityMapFileInfo) throws ErrorInfo {

        if (!commodityMapFileInfo.isSetFileInfoId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommodityMapFileInfo field FileInfoId must set.");
        }

        PreparedFields fields = prepareFields(commodityMapFileInfo);
        if (fields.getSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "CommodityMapFileInfo fields must set.");
        }
        int timenow = (int) (System.currentTimeMillis() / 1000);
        fields.addInt(TableBrokerCommodityMappingFile.COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        StringBuffer sqlBuffer = getTableUpdateSqlBuffer(TableBrokerCommodityMappingFile.TABLE_NAME, fields);
        String condition = TableBrokerCommodityMappingFile.COLUMN_FFILE_INFO_ID + "=" + commodityMapFileInfo.getFileInfoId();
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
    }

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableBrokerCommodityMappingFile.COLUMN_FFILE_INFO_ID,
                TableBrokerCommodityMappingFile.COLUMN_FBROKER_ID,
                TableBrokerCommodityMappingFile.COLUMN_FFILE_MD5,
                TableBrokerCommodityMappingFile.COLUMN_FFILE_PATH,
                TableBrokerCommodityMappingFile.COLUMN_FTECH_PLATFORM,
                TableBrokerCommodityMappingFile.COLUMN_FVERSION,
                TableBrokerCommodityMappingFile.COLUMN_FSTATUS,
                TableBrokerCommodityMappingFile.COLUMN_FCREATE_TIMESTAMP,
                TableBrokerCommodityMappingFile.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableBrokerCommodityMappingFile.TABLE_NAME);
        sqlBuilder.setOrder(SqlQueryBuilder.OrderType.DESC, TableBrokerCommodityMappingFile.COLUMN_FCREATE_TIMESTAMP);
        return sqlBuilder;
    }

    public CommodityMapFileInfoPage query(ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.isSetBrokerEntryIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableBrokerCommodityMappingFile.COLUMN_FBROKER_ID,
                    DaoUtil.map2Set(option.getBrokerEntryIds()));
        }

        if (option.isSetTechPlatform()) {
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, TableBrokerCommodityMappingFile.COLUMN_FTECH_PLATFORM + "=?",
                    option.getTechPlatform().getValue());
        }
        if (option.isSetFileInfoIds()) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableBrokerCommodityMappingFile.COLUMN_FFILE_INFO_ID,
                    DaoUtil.map2Set(option.getFileInfoIds()));
        }
        if (option.isSetStatus()){
            sqlBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, TableBrokerCommodityMappingFile.COLUMN_FSTATUS + "=?",
                    option.getStatus().getValue());
        }

        sqlBuilder.setPage(pageIndex, pageSize);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
            List<CommodityMapFileInfo> list = runner.query(conn, sqlBuilder.getItemsSql(), new TCommodityFileInfoHandler(),
                    sqlBuilder.getParameterList());
            CommodityMapFileInfoPage page = new CommodityMapFileInfoPage();
            page.setPage(list);
            page.setTotal(total);
            return page;
        } catch (SQLException e) {
            AppLog.e("Error occurs at query.", e);
            throw new ErrorInfo(ErrorCodeInner.DB_SELECT_FAILED.getErrorCode(),
                    ErrorCodeInner.DB_SELECT_FAILED.getErrorMsg());
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    private class TCommodityFileInfoHandler extends AbstractListHandler<CommodityMapFileInfo> {

        @Override
        protected CommodityMapFileInfo handleRow(ResultSet rs) throws SQLException {
            CommodityMapFileInfo info = new CommodityMapFileInfo();
            info.setFileInfoId(rs.getInt(TableBrokerCommodityMappingFile.COLUMN_FFILE_INFO_ID));
            info.setPath(rs.getString(TableBrokerCommodityMappingFile.COLUMN_FFILE_PATH));
            info.setFileMD5(rs.getString(TableBrokerCommodityMappingFile.COLUMN_FFILE_MD5));
            info.setBrokerEntryId(rs.getInt(TableBrokerCommodityMappingFile.COLUMN_FBROKER_ID));
            info.setVersion(rs.getInt(TableBrokerCommodityMappingFile.COLUMN_FVERSION));
            info.setTechPlatform(TechPlatform.findByValue(rs.getInt(TableBrokerCommodityMappingFile.COLUMN_FTECH_PLATFORM)));
            info.setStatus(CommodityMapFileStatus.findByValue(rs.getInt(TableBrokerCommodityMappingFile.COLUMN_FSTATUS)));
            info.setCreateTimestamp(rs.getLong(TableBrokerCommodityMappingFile.COLUMN_FCREATE_TIMESTAMP));
            info.setLastModityTimestamp(rs.getLong(TableBrokerCommodityMappingFile.COLUMN_FLAST_MODIFY_TIMESTAMP));
            return info;
        }
    }
}
