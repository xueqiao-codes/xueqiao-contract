package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeOuter;
import com.google.common.base.Preconditions;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledTradingSessionOption;
import com.longsheng.xueqiao.contract.thriftapi.SledTradingSession;
import com.longsheng.xueqiao.contract.thriftapi.SledTradingSessionPage;
import com.longsheng.xueqiao.contract.thriftapi.SledTradingSessionTimeSpan;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TradingSessionHandler {
    private DataSource mDataSource;

    public TradingSessionHandler(DataSource dataSource) {
        this.mDataSource = dataSource;
    }

    public void addSledTradingSession(SledTradingSession sledTradingSession) throws ErrorInfo {

        new DBTransactionHelper<Void>(mDataSource) {
            @Override
            public void onPrepareData() throws ErrorInfo, Exception {

            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                new SledTradingSessionTable(getConnection()).add(sledTradingSession);
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();
    }

    public void updateSledTradingSession(SledTradingSession sledTradingSession) throws ErrorInfo {
        Preconditions.checkNotNull(sledTradingSession);
        Preconditions.checkArgument(sledTradingSession.getTradeSessionId() > 0);

        new DBTransactionHelper<Void>(mDataSource) {
            @Override
            public void onPrepareData() throws ErrorInfo, Exception {

            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                SledTradingSessionTable tradingSessionTable = new SledTradingSessionTable(getConnection());
                SledTradingSessionTimeSpanTable timeSpanTable = new SledTradingSessionTimeSpanTable(getConnection());
                SledTradingSession oldTradeSession = tradingSessionTable.queryForUpdate(sledTradingSession.getTradeSessionId(), true);
                if (oldTradeSession == null) {
                    throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SledTradingSession not found");
                }

                for (SledTradingSessionTimeSpan timeSpan : oldTradeSession.getTimeSpans()) {
                    SledTradingSessionTimeSpan renewTimeSpan = new SledTradingSessionTimeSpan();
                    renewTimeSpan.setTimeSpanId(timeSpan.getTimeSpanId());
                    renewTimeSpan.setTradeSessionId(0);
                    timeSpanTable.update(renewTimeSpan);
                }

                if (sledTradingSession.isSetTimeSpans()) {
                    List<SledTradingSessionTimeSpan> newSpan = new ArrayList<>();
                    for (SledTradingSessionTimeSpan timeSpan : sledTradingSession.getTimeSpans()) {
                        timeSpan.setTradeSessionId(sledTradingSession.getTradeSessionId());
                        if (timeSpan.isSetTimeSpanId()) {
                            SledTradingSessionTimeSpan oldTimeSpan = timeSpanTable.queryForUpdate(timeSpan.getTimeSpanId(), true);
                            if (oldTimeSpan == null) {
                                throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TimeSpanId not found");
                            }
                            timeSpanTable.update(timeSpan);
                        } else {
                            newSpan.add(timeSpan);
                        }
                    }
                    timeSpanTable.batAdd(newSpan);
                }
                tradingSessionTable.update(sledTradingSession);
                timeSpanTable.deleteByTradingSessionId(0);
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();
    }

    public SledTradingSessionPage reqSledTradingSession(ReqSledTradingSessionOption option, IndexedPageOption pageOption) throws ErrorInfo {

        return new DBQueryHelper<SledTradingSessionPage>(mDataSource) {
            @Override
            protected SledTradingSessionPage onQuery(Connection connection) throws Exception {
                return new SledTradingSessionTable(connection).query(option, pageOption);
            }
        }.query();
    }

    public void deleteSledTradingSession(long sledTradingSessionId) throws ErrorInfo {

        new DBTransactionHelper<Void>(mDataSource) {
            @Override
            public void onPrepareData() throws ErrorInfo, Exception {

            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                new SledTradingSessionTable(getConnection()).deleteSledTradingSession(sledTradingSessionId);
                new SledTradingSessionTimeSpanTable(getConnection()).deleteByTradingSessionId(sledTradingSessionId);
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();

    }
}
