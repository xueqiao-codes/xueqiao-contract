package com.longsheng.xueqiao.contract.dao.handlers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.longsheng.xueqiao.contract.dao.tables.*;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledTradingSessionOption;
import com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig;
import com.longsheng.xueqiao.contract.thriftapi.SledTradingSession;
import com.longsheng.xueqiao.contract.thriftapi.SledTradingSessionPage;
import org.apache.commons.dbutils.QueryRunner;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.dal_set.DbUtil;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;

public class DeleteCommodityHandler extends TableHandler {

    public DeleteCommodityHandler(IConnectionProvider provider) throws ErrorInfo {
        super(provider);
    }

    public void deleteCommodityFullPackage(int sledCommodityId, List<Integer> brokerEntryIds) throws ErrorInfo {

        QueryRunner runner = new QueryRunner();
        Connection conn = getConnection();

        try {
            conn.setAutoCommit(false);
            deleteCommodity(conn, runner, sledCommodityId);
            deleteContract(conn, runner, sledCommodityId);
            for (int brokerEntryId : brokerEntryIds) {
                deleteCommodityMapping(conn, runner, sledCommodityId, getTableName(brokerEntryId));
            }

            SledTradingSessionTable table = new SledTradingSessionTable(conn);
            ReqSledTradingSessionOption option = new ReqSledTradingSessionOption();
            option.setSledCommodityId(sledCommodityId);
            SledTradingSessionPage page = table.query(option, null);
            for (SledTradingSession session : page.getPage()) {
                new SledTradingSessionTimeSpanTable(conn).deleteByTradingSessionId(session.getTradeSessionId());
            }
            table.deleteBySledCommodityId(sledCommodityId);
            conn.commit();
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            DbUtil.closeQuietly(conn);
        }


    }

    private void deleteTradeTime(Connection conn, QueryRunner runner, int sledCommodityId) throws SQLException {
        String deleteSql = "delete from " + TableSledCommodityTradeTimeConfig.TABLE_NAME + " where " + TableSledCommodityTradeTimeConfig.COLUMN_FSLED_COMMODITY_ID + " =?";
        runner.update(conn, deleteSql, sledCommodityId);
    }

    private void deleteCommodityMapping(Connection conn, QueryRunner runner, int sledCommodityId, String tableName) throws SQLException {
        String deleteSql = "delete from " + tableName + " where " + TableCommodityMap.COLUMN_FSLED_COMMODITY_ID + " =?";
        runner.update(conn, deleteSql, sledCommodityId);
    }

    private void deleteCommodity(Connection conn, QueryRunner runner, int sledCommodityId) throws SQLException {
        String deleteSql = "delete from " + TableSledCommodity.TABLE_NAME + " where " + TableSledCommodity.COLUMN_FSLED_COMMODITY_ID + " =?";
        runner.update(conn, deleteSql, sledCommodityId);
    }

    private void deletePlatformCommodity(Connection conn, QueryRunner runner, int sledCommodityId) throws SQLException {
        String deleteSql = "delete from " + TableTechPlatformCommodity.TABLE_NAME + " where " + TableTechPlatformCommodity.COLUMN_FSLED_COMMODITY_ID + " =?";
        runner.update(conn, deleteSql, sledCommodityId);
    }

    private void deleteContract(Connection conn, QueryRunner runner, int sledCommodityId) throws SQLException {
        String deleteSql = "delete from " + TableSledContract.TABLE_NAME + " where " + TableSledContract.COLUMN_FSLED_COMMODITY_ID + " =?";
        runner.update(conn, deleteSql, sledCommodityId);
    }

    private String getTableName(int brokerEntryId) {
        return TableCommodityMap.TABLE_NAME + brokerEntryId;
    }


}
