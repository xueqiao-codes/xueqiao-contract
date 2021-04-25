package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.tables.TableSledTradeTimeTmp;
import com.longsheng.xueqiao.contract.dao.utils.CompactFactory;
import com.longsheng.xueqiao.contract.dao.utils.DaoUtil;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeOption;
import com.longsheng.xueqiao.contract.thriftapi.SledTradeTime;
import com.longsheng.xueqiao.contract.thriftapi.SledTradeTimePage;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.DbUtil;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.util.ProtocolUtil;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SledTradeTimeTmpHandler extends TableHandler {


    public SledTradeTimeTmpHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void batInsert(List<SledTradeTime> sledTradeTimes) throws ErrorInfo {

        List<PreparedSql> list = new ArrayList<>();
        for (SledTradeTime sledTradeTime : sledTradeTimes) {

            if (sledTradeTime.getSledCommodityId() <= 0) {
                throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SledCommodityId must set.");
            }
            PreparedSql preparedSql = new PreparedSql();
            int createTime = (int) (System.currentTimeMillis() / 1000);
            PreparedFields fields = prepareFields(sledTradeTime);

            if (fields.getSize() == 0) {
                throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledExchange fields must set.");
            }

            fields.addInt(TableSledTradeTimeTmp.COLUMN_FSLED_COMMODITY_ID, sledTradeTime.getSledCommodityId());
            fields.addInt(TableSledTradeTimeTmp.COLUMN_FCREATE_TIMESTAMP, createTime);
            fields.addInt(TableSledTradeTimeTmp.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
            StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSledTradeTimeTmp.TABLE_NAME, fields);
            preparedSql.preparedFields = fields;
            preparedSql.sqlBuffer = insertSqlBuffer;
            list.add(preparedSql);
        }
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            String deleteSql = "delete from " + TableSledTradeTimeTmp.TABLE_NAME + " where 1=?";
            runner.update(conn, deleteSql, 1);
            for (PreparedSql preparedSql : list) {
                runner.update(conn, preparedSql.sqlBuffer.toString(), preparedSql.preparedFields.getParameters());
            }
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

    private class PreparedSql {
        public StringBuffer sqlBuffer;
        public PreparedFields preparedFields;
    }

    private PreparedFields prepareFields(SledTradeTime sledTradeTime) {
        PreparedFields fields = new PreparedFields();
        if (sledTradeTime.isSetZoneId()) {
            fields.addString(TableSledTradeTimeTmp.COLUMN_FZONE_ID, sledTradeTime.getZoneId());
        }
        if (sledTradeTime.isSetDateTimeSpans()) {
            ByteBuffer data = ProtocolUtil.serialize(CompactFactory.getInstance().getFactory(), sledTradeTime);
            Blob blob = null;
            try {
                blob = new javax.sql.rowset.serial.SerialBlob(data.array());
            } catch (SQLException e) {
                AppLog.e(e.getMessage(), e);
            }
            if (blob != null) {
                fields.addBlob(TableSledTradeTimeTmp.COLUMN_FTMP_TRADE_TIMES, blob);
            }
        }
        return fields;
    }

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableSledTradeTimeTmp.COLUMN_FSLED_COMMODITY_ID,
                TableSledTradeTimeTmp.COLUMN_FZONE_ID,
                TableSledTradeTimeTmp.COLUMN_FTMP_TRADE_TIMES,
                TableSledTradeTimeTmp.COLUMN_FCREATE_TIMESTAMP,
                TableSledTradeTimeTmp.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableSledTradeTimeTmp.TABLE_NAME);
        return sqlBuilder;
    }

    public SledTradeTimePage query(ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.isSetSledCommodityIds() && option.getSledCommodityIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledTradeTimeTmp.COLUMN_FSLED_COMMODITY_ID,
                    DaoUtil.map2Set(option.getSledCommodityIds()));
        }

        sqlBuilder.setPage(pageIndex, pageSize);
        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();
        try {
            int total = runner.query(conn, sqlBuilder.getTotalCountSql(), new ScalarHandler<Long>(), sqlBuilder.getParameterList()).intValue();
            List<SledTradeTime> list = runner.query(conn, sqlBuilder.getItemsSql(), new TSledTradeTimeHandler(),
                    sqlBuilder.getParameterList());
            SledTradeTimePage page = new SledTradeTimePage();
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


    private class TSledTradeTimeHandler extends AbstractListHandler<SledTradeTime> {

        @Override
        protected SledTradeTime handleRow(ResultSet rs) throws SQLException {
            SledTradeTime config = new SledTradeTime();
            config.setSledCommodityId(rs.getInt(TableSledTradeTimeTmp.COLUMN_FSLED_COMMODITY_ID));
            config.setZoneId(rs.getString(TableSledTradeTimeTmp.COLUMN_FZONE_ID));
            Blob data = rs.getBlob(TableSledTradeTimeTmp.COLUMN_FTMP_TRADE_TIMES);
            InputStream is = data.getBinaryStream();

            byte[] bytes = null;
            try {
                bytes = IOUtils.toByteArray(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bytes != null) {
                SledTradeTime sledTradeTime = ProtocolUtil.unSerialize(CompactFactory.getInstance().getFactory(), bytes, SledTradeTime.class);
                if (sledTradeTime != null) {
                    config.setDateTimeSpans(sledTradeTime.getDateTimeSpans());
                }
            }
            return config;
        }
    }
}
