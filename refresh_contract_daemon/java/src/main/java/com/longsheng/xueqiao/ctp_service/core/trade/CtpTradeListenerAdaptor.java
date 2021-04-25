package com.longsheng.xueqiao.ctp_service.core.trade;

import net.jctp.*;
import org.soldier.base.logger.AppLog;

/**
 * Created by Jason on 2017/2/22.
 */
abstract class CtpTradeListenerAdaptor implements TraderApiListener {
    @Override
    public void OnFrontConnected() {

        AppLog.i("TraderListener.OnFrontDisconnected enter");

    }

    @Override
    public void OnFrontDisconnected(int nReason) {

        AppLog.d("TraderListener.OnFrontDisconnected enter: "
                + nReason);

    }

    @Override
    public void OnHeartBeatWarning(int nTimeLapse) {
    }

    @Override
    public void OnRspAuthenticate(
            CThostFtdcRspAuthenticateField pRspAuthenticateField,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.i("TraderListener.OnRspAuthenticate enter: "
                + pRspAuthenticateField + "," + pRspInfo + "," + nRequestID
                + "," + bIsLast);
    }

    @Override
    public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin,
                               CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.i("TraderListener.OnRspUserLogin enter: "
                + pRspUserLogin + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspSettlementInfoConfirm(
            CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspSettlementInfoConfirm enter: "
                + pSettlementInfoConfirm + "," + pRspInfo + "," + nRequestID
                + "," + bIsLast);

    }

    @Override
    public void OnRspUserLogout(CThostFtdcUserLogoutField pUserLogout,
                                CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.i("TraderListener.OnRspUserLogout enter: "
                + pUserLogout + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspUserPasswordUpdate(
            CThostFtdcUserPasswordUpdateField pUserPasswordUpdate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspUserPasswordUpdate enter: "
                + pUserPasswordUpdate + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspTradingAccountPasswordUpdate(
            CThostFtdcTradingAccountPasswordUpdateField pTradingAccountPasswordUpdate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspTradingAccountPasswordUpdate enter: "
                        + pTradingAccountPasswordUpdate
                        + ","
                        + pRspInfo
                        + ","
                        + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspOrderInsert(CThostFtdcInputOrderField pInputOrder,
                                 CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspOrderInsert enter: "
                + pInputOrder + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspParkedOrderInsert(CThostFtdcParkedOrderField pParkedOrder,
                                       CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspParkedOrderInsert enter: "
                + pParkedOrder + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspParkedOrderAction(
            CThostFtdcParkedOrderActionField pParkedOrderAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspParkedOrderAction enter: "
                + pParkedOrderAction + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspOrderAction(
            CThostFtdcInputOrderActionField pInputOrderAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspOrderAction enter: "
                + pInputOrderAction + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQueryMaxOrderVolume(
            CThostFtdcQueryMaxOrderVolumeField pQueryMaxOrderVolume,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQueryMaxOrderVolume enter: "
                + pQueryMaxOrderVolume + "," + pRspInfo + "," + nRequestID
                + "," + bIsLast);
    }

    @Override
    public void OnRspRemoveParkedOrder(
            CThostFtdcRemoveParkedOrderField pRemoveParkedOrder,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspRemoveParkedOrder enter: "
                + pRemoveParkedOrder + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspRemoveParkedOrderAction(
            CThostFtdcRemoveParkedOrderActionField pRemoveParkedOrderAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspRemoveParkedOrderAction enter: "
                        + pRemoveParkedOrderAction + "," + pRspInfo + ","
                        + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryOrder(CThostFtdcOrderField pOrder,
                              CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryOrder enter: " + pOrder
                + "," + pRspInfo + "," + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryTrade(CThostFtdcTradeField pTrade,
                              CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTrade enter: " + pTrade
                + "," + pRspInfo + "," + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryInvestorPosition(
            CThostFtdcInvestorPositionField pInvestorPosition,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryInvestorPosition enter: "
                + pInvestorPosition + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryTradingAccount(
            CThostFtdcTradingAccountField pTradingAccount,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTradingAccount enter: "
                + pTradingAccount + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryInvestor(CThostFtdcInvestorField pInvestor,
                                 CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQryInvestor enter: " + pInvestor
                        + "," + pRspInfo + "," + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryTradingCode(CThostFtdcTradingCodeField pTradingCode,
                                    CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTradingCode enter: "
                + pTradingCode + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryInstrumentMarginRate(
            CThostFtdcInstrumentMarginRateField pInstrumentMarginRate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQryInstrumentMarginRate enter: "
                        + pInstrumentMarginRate + "," + pRspInfo + ","
                        + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryInstrumentCommissionRate(
            CThostFtdcInstrumentCommissionRateField pInstrumentCommissionRate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQryInstrumentCommissionRate enter: "
                        + pInstrumentCommissionRate
                        + ","
                        + pRspInfo
                        + ","
                        + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryExchange(CThostFtdcExchangeField pExchange,
                                 CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQryExchange enter: " + pExchange
                        + "," + pRspInfo + "," + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryInstrument(CThostFtdcInstrumentField pInstrument,
                                   CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryInstrument enter: "
                + pInstrument + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryDepthMarketData(
            CThostFtdcDepthMarketDataField pDepthMarketData,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryDepthMarketData enter: "
                + pDepthMarketData + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQrySettlementInfo(
            CThostFtdcSettlementInfoField pSettlementInfo,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQrySettlementInfo enter: "
                + pSettlementInfo + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryTransferBank(CThostFtdcTransferBankField pTransferBank,
                                     CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTransferBank enter: "
                + pTransferBank + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryInvestorPositionDetail(
            CThostFtdcInvestorPositionDetailField pInvestorPositionDetail,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQryInvestorPositionDetail enter: "
                        + pInvestorPositionDetail
                        + ","
                        + pRspInfo
                        + ","
                        + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryNotice(CThostFtdcNoticeField pNotice,
                               CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryNotice enter: " + pNotice
                + "," + pRspInfo + "," + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQrySettlementInfoConfirm(
            CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQrySettlementInfoConfirm enter: "
                        + pSettlementInfoConfirm + "," + pRspInfo + ","
                        + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryInvestorPositionCombineDetail(
            CThostFtdcInvestorPositionCombineDetailField pInvestorPositionCombineDetail,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQryInvestorPositionCombineDetail enter: "
                        + pInvestorPositionCombineDetail
                        + ","
                        + pRspInfo
                        + ","
                        + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryCFMMCTradingAccountKey(
            CThostFtdcCFMMCTradingAccountKeyField pCFMMCTradingAccountKey,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQryCFMMCTradingAccountKey enter: "
                        + pCFMMCTradingAccountKey
                        + ","
                        + pRspInfo
                        + ","
                        + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryEWarrantOffset(
            CThostFtdcEWarrantOffsetField pEWarrantOffset,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryEWarrantOffset enter: "
                + pEWarrantOffset + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryInvestorProductGroupMargin(
            CThostFtdcInvestorProductGroupMarginField pInvestorProductGroupMargin,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQryInvestorProductGroupMargin enter: "
                        + pInvestorProductGroupMargin
                        + ","
                        + pRspInfo
                        + ","
                        + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryExchangeMarginRate(
            CThostFtdcExchangeMarginRateField pExchangeMarginRate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryExchangeMarginRate enter: "
                + pExchangeMarginRate + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryExchangeMarginRateAdjust(
            CThostFtdcExchangeMarginRateAdjustField pExchangeMarginRateAdjust,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQryExchangeMarginRateAdjust enter: "
                        + pExchangeMarginRateAdjust
                        + ","
                        + pRspInfo
                        + ","
                        + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRspQryTransferSerial(
            CThostFtdcTransferSerialField pTransferSerial,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTransferSerial enter: "
                + pTransferSerial + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryAccountregister(
            CThostFtdcAccountregisterField pAccountregister,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryAccountregister enter: "
                + pAccountregister + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID,
                           boolean bIsLast) {

        AppLog.d("TraderListener.OnRspError enter: " + pRspInfo + ","
                + nRequestID + "," + bIsLast);
    }

    @Override
    public void OnRtnOrder(CThostFtdcOrderField pOrder) {

        AppLog.d("TraderListener.OnRtnOrder enter: " + pOrder);
    }

    @Override
    public void OnRtnTrade(CThostFtdcTradeField pTrade) {

        AppLog.d("TraderListener.OnRtnTrade enter: " + pTrade);
    }

    @Override
    public void OnErrRtnOrderInsert(CThostFtdcInputOrderField pInputOrder,
                                    CThostFtdcRspInfoField pRspInfo) {

        AppLog.d("TraderListener.OnErrRtnOrderInsert enter: "
                + pInputOrder + "," + pRspInfo);
    }

    @Override
    public void OnErrRtnOrderAction(CThostFtdcOrderActionField pOrderAction,
                                    CThostFtdcRspInfoField pRspInfo) {

        AppLog.d("TraderListener.OnErrRtnOrderAction enter: "
                + pOrderAction + "," + pRspInfo);
    }

    @Override
    public void OnRtnInstrumentStatus(
            CThostFtdcInstrumentStatusField pInstrumentStatus) {
        AppLog.d("TraderListener.OnRtnInstrumentStatus enter: "
                + pInstrumentStatus);
    }

    @Override
    public void OnRtnTradingNotice(
            CThostFtdcTradingNoticeInfoField pTradingNoticeInfo) {

        AppLog.d("TraderListener.OnRtnTradingNotice enter: "
                + pTradingNoticeInfo);
    }

    @Override
    public void OnRtnErrorConditionalOrder(
            CThostFtdcErrorConditionalOrderField pErrorConditionalOrder) {

        AppLog.d("TraderListener.OnRtnErrorConditionalOrder enter: "
                + pErrorConditionalOrder);
    }

    @Override
    public void OnRspQryContractBank(CThostFtdcContractBankField pContractBank,
                                     CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryContractBank enter: "
                + pContractBank + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryParkedOrder(CThostFtdcParkedOrderField pParkedOrder,
                                    CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryParkedOrder enter: "
                + pParkedOrder + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryParkedOrderAction(
            CThostFtdcParkedOrderActionField pParkedOrderAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryParkedOrderAction enter: "
                + pParkedOrderAction + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryTradingNotice(
            CThostFtdcTradingNoticeField pTradingNotice,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTradingNotice enter: "
                + pTradingNotice + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRspQryBrokerTradingParams(
            CThostFtdcBrokerTradingParamsField pBrokerTradingParams,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryBrokerTradingParams enter: "
                + pBrokerTradingParams + "," + pRspInfo + "," + nRequestID
                + "," + bIsLast);
    }

    @Override
    public void OnRspQryBrokerTradingAlgos(
            CThostFtdcBrokerTradingAlgosField pBrokerTradingAlgos,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryBrokerTradingAlgos enter: "
                + pBrokerTradingAlgos + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    @Override
    public void OnRtnFromBankToFutureByBank(
            CThostFtdcRspTransferField pRspTransfer) {

        AppLog.d("TraderListener.OnRtnFromBankToFutureByBank enter: "
                + pRspTransfer);
    }

    @Override
    public void OnRtnFromFutureToBankByBank(
            CThostFtdcRspTransferField pRspTransfer) {

        AppLog.d("TraderListener.OnRtnFromFutureToBankByBank enter: "
                + pRspTransfer);
    }

    @Override
    public void OnRtnRepealFromBankToFutureByBank(
            CThostFtdcRspRepealField pRspRepeal) {

        System.out
                .println("TraderListener.OnRtnRepealFromBankToFutureByBank enter: "
                        + pRspRepeal);
    }

    @Override
    public void OnRtnRepealFromFutureToBankByBank(
            CThostFtdcRspRepealField pRspRepeal) {

        System.out
                .println("TraderListener.OnRtnRepealFromFutureToBankByBank enter: "
                        + pRspRepeal);
    }

    @Override
    public void OnRtnFromBankToFutureByFuture(
            CThostFtdcRspTransferField pRspTransfer) {

        System.out
                .println("TraderListener.OnRtnFromBankToFutureByFuture enter: "
                        + pRspTransfer);
    }

    @Override
    public void OnRtnFromFutureToBankByFuture(
            CThostFtdcRspTransferField pRspTransfer) {

        System.out
                .println("TraderListener.OnRtnFromFutureToBankByFuture enter: "
                        + pRspTransfer);
    }

    @Override
    public void OnRtnRepealFromBankToFutureByFutureManual(
            CThostFtdcRspRepealField pRspRepeal) {

        System.out
                .println("TraderListener.OnRtnRepealFromBankToFutureByFutureManual enter: "
                        + pRspRepeal);
    }

    @Override
    public void OnRtnRepealFromFutureToBankByFutureManual(
            CThostFtdcRspRepealField pRspRepeal) {

        System.out
                .println("TraderListener.OnRtnRepealFromFutureToBankByFutureManual enter: "
                        + pRspRepeal);
    }

    @Override
    public void OnRtnQueryBankBalanceByFuture(
            CThostFtdcNotifyQueryAccountField pNotifyQueryAccount) {

        System.out
                .println("TraderListener.OnRtnQueryBankBalanceByFuture enter: "
                        + pNotifyQueryAccount);
    }

    @Override
    public void OnErrRtnBankToFutureByFuture(
            CThostFtdcReqTransferField pReqTransfer,
            CThostFtdcRspInfoField pRspInfo) {

        System.out
                .println("TraderListener.OnErrRtnBankToFutureByFuture enter: "
                        + pReqTransfer + "," + pRspInfo);
    }

    @Override
    public void OnErrRtnFutureToBankByFuture(
            CThostFtdcReqTransferField pReqTransfer,
            CThostFtdcRspInfoField pRspInfo) {

        System.out
                .println("TraderListener.OnErrRtnFutureToBankByFuture enter: "
                        + pReqTransfer + "," + pRspInfo);
    }

    @Override
    public void OnErrRtnRepealBankToFutureByFutureManual(
            CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {

        System.out
                .println("TraderListener.OnErrRtnRepealBankToFutureByFutureManual enter: "
                        + pReqRepeal + "," + pRspInfo);
    }

    @Override
    public void OnErrRtnRepealFutureToBankByFutureManual(
            CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {

        System.out
                .println("TraderListener.OnErrRtnRepealFutureToBankByFutureManual enter: "
                        + pReqRepeal + "," + pRspInfo);
    }

    @Override
    public void OnErrRtnQueryBankBalanceByFuture(
            CThostFtdcReqQueryAccountField pReqQueryAccount,
            CThostFtdcRspInfoField pRspInfo) {

        System.out
                .println("TraderListener.OnErrRtnQueryBankBalanceByFuture enter: "
                        + pReqQueryAccount + "," + pRspInfo);
    }

    @Override
    public void OnRtnRepealFromBankToFutureByFuture(
            CThostFtdcRspRepealField pRspRepeal) {

        System.out
                .println("TraderListener.OnRtnRepealFromBankToFutureByFuture enter: "
                        + pRspRepeal);
    }

    @Override
    public void OnRtnRepealFromFutureToBankByFuture(
            CThostFtdcRspRepealField pRspRepeal) {

        System.out
                .println("TraderListener.OnRtnRepealFromFutureToBankByFuture enter: "
                        + pRspRepeal);
    }

    @Override
    public void OnRspFromBankToFutureByFuture(
            CThostFtdcReqTransferField pReqTransfer,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspFromBankToFutureByFuture enter: "
                        + pReqTransfer + "," + pRspInfo + "," + nRequestID
                        + "," + bIsLast);
    }

    @Override
    public void OnRspFromFutureToBankByFuture(
            CThostFtdcReqTransferField pReqTransfer,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspFromFutureToBankByFuture enter: "
                        + pReqTransfer + "," + pRspInfo + "," + nRequestID
                        + "," + bIsLast);
    }

    @Override
    public void OnRspQueryBankAccountMoneyByFuture(
            CThostFtdcReqQueryAccountField pReqQueryAccount,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        System.out
                .println("TraderListener.OnRspQueryBankAccountMoneyByFuture enter: "
                        + pReqQueryAccount
                        + ","
                        + pRspInfo
                        + ","
                        + nRequestID
                        + "," + bIsLast);
    }

    @Override
    public void OnRtnOpenAccountByBank(CThostFtdcOpenAccountField pOpenAccount) {

        AppLog.d("TraderListener.OnRtnOpenAccountByBank enter: "
                + pOpenAccount);
    }

    @Override
    public void OnRtnCancelAccountByBank(
            CThostFtdcCancelAccountField pCancelAccount) {

        AppLog.d("TraderListener.OnRtnCancelAccountByBank enter: "
                + pCancelAccount);
    }

    @Override
    public void OnRtnChangeAccountByBank(
            CThostFtdcChangeAccountField pChangeAccount) {

        AppLog.d("TraderListener.OnRtnChangeAccountByBank enter: "
                + pChangeAccount);
    }

    @Override
    public void OnRspQryProduct(CThostFtdcProductField pProduct,
                                CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryExchangeRate(CThostFtdcExchangeRateField pExchangeRate,
                                     CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQrySecAgentACIDMap(
            CThostFtdcSecAgentACIDMapField pSecAgentACIDMap,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspExecOrderInsert(
            CThostFtdcInputExecOrderField pInputExecOrder,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspExecOrderAction(
            CThostFtdcInputExecOrderActionField pInputExecOrderAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspForQuoteInsert(
            CThostFtdcInputForQuoteField pInputForQuote,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQuoteInsert(CThostFtdcInputQuoteField pInputQuote,
                                 CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQuoteAction(
            CThostFtdcInputQuoteActionField pInputQuoteAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryOptionInstrTradeCost(
            CThostFtdcOptionInstrTradeCostField pOptionInstrTradeCost,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryOptionInstrCommRate(
            CThostFtdcOptionInstrCommRateField pOptionInstrCommRate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryExecOrder(CThostFtdcExecOrderField pExecOrder,
                                  CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryForQuote(CThostFtdcForQuoteField pForQuote,
                                 CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryQuote(CThostFtdcQuoteField pQuote,
                              CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRtnExecOrder(CThostFtdcExecOrderField pExecOrder) {


    }

    @Override
    public void OnErrRtnExecOrderInsert(
            CThostFtdcInputExecOrderField pInputExecOrder,
            CThostFtdcRspInfoField pRspInfo) {


    }

    @Override
    public void OnErrRtnExecOrderAction(
            CThostFtdcExecOrderActionField pExecOrderAction,
            CThostFtdcRspInfoField pRspInfo) {


    }

    @Override
    public void OnErrRtnForQuoteInsert(
            CThostFtdcInputForQuoteField pInputExecOrder,
            CThostFtdcRspInfoField pRspInfo) {


    }

    @Override
    public void OnRtnQuote(CThostFtdcQuoteField pQuote) {


    }

    @Override
    public void OnErrRtnQuoteInsert(CThostFtdcInputQuoteField pInputQuote,
                                    CThostFtdcRspInfoField pRspInfo) {


    }

    @Override
    public void OnErrRtnQuoteAction(CThostFtdcQuoteActionField pQuoteAction,
                                    CThostFtdcRspInfoField pRspInfo) {


    }

    @Override
    public void OnRtnForQuoteRsp(CThostFtdcForQuoteRspField pForQuoteRsp) {


    }

    @Override
    public void OnRtnCFMMCTradingAccountToken(
            CThostFtdcCFMMCTradingAccountTokenField pCFMMCTradingAccountToken) {

    }

    @Override
    public void OnRspQueryCFMMCTradingAccountToken(
            CThostFtdcQueryCFMMCTradingAccountTokenField pQueryCFMMCTradingAccountToken,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

    }

    @Override
    public void OnRspCombActionInsert(
            CThostFtdcInputCombActionField pInputCombAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryProductExchRate(
            CThostFtdcProductExchRateField pProductExchRate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryCombInstrumentGuard(
            CThostFtdcCombInstrumentGuardField pCombInstrumentGuard,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryCombAction(CThostFtdcCombActionField pCombAction,
                                   CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRtnCombAction(CThostFtdcCombActionField pCombAction) {


    }

    @Override
    public void OnErrRtnCombActionInsert(
            CThostFtdcInputCombActionField pInputCombAction,
            CThostFtdcRspInfoField pRspInfo) {


    }

    @Override
    public void OnRspBatchOrderAction(CThostFtdcInputBatchOrderActionField pInputBatchOrderAction,
                                      CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryProductGroup(CThostFtdcProductGroupField pProductGroup, CThostFtdcRspInfoField pRspInfo,
                                     int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryMMInstrumentCommissionRate(
            CThostFtdcMMInstrumentCommissionRateField pMMInstrumentCommissionRate, CThostFtdcRspInfoField pRspInfo,
            int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryMMOptionInstrCommRate(CThostFtdcMMOptionInstrCommRateField pMMOptionInstrCommRate,
                                              CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRspQryInstrumentOrderCommRate(CThostFtdcInstrumentOrderCommRateField pInstrumentOrderCommRate,
                                                CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {


    }

    @Override
    public void OnRtnBulletin(CThostFtdcBulletinField pBulletin) {


    }

    @Override
    public void OnErrRtnBatchOrderAction(CThostFtdcBatchOrderActionField pBatchOrderAction,
                                         CThostFtdcRspInfoField pRspInfo) {


    }

    @Override
    public void OnRspOptionSelfCloseInsert(CThostFtdcInputOptionSelfCloseField pInputOptionSelfClose,
                                           CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

    }

    @Override
    public void OnRspOptionSelfCloseAction(CThostFtdcInputOptionSelfCloseActionField pInputOptionSelfCloseAction,
                                           CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

    }

    @Override
    public void OnRspQrySecAgentTradingAccount(CThostFtdcTradingAccountField pTradingAccount,
                                               CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

    }

    @Override
    public void OnRspQrySecAgentCheckMode(CThostFtdcSecAgentCheckModeField pSecAgentCheckMode,
                                          CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

    }

    @Override
    public void OnRspQryOptionSelfClose(CThostFtdcOptionSelfCloseField pOptionSelfClose,
                                        CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

    }

    @Override
    public void OnRspQryInvestUnit(CThostFtdcInvestUnitField pInvestUnit, CThostFtdcRspInfoField pRspInfo,
                                   int nRequestID, boolean bIsLast) {

    }

    @Override
    public void OnRtnOptionSelfClose(CThostFtdcOptionSelfCloseField pOptionSelfClose) {

    }

    @Override
    public void OnErrRtnOptionSelfCloseInsert(CThostFtdcInputOptionSelfCloseField pInputOptionSelfClose,
                                              CThostFtdcRspInfoField pRspInfo) {

    }

    @Override
    public void OnErrRtnOptionSelfCloseAction(CThostFtdcOptionSelfCloseActionField pOptionSelfCloseAction,
                                              CThostFtdcRspInfoField pRspInfo) {

    }

    @Override
    public void OnRspUserAuthMethod(CThostFtdcRspUserAuthMethodField pRspUserAuthMethod,
                                    CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

    }

    @Override
    public void OnRspGenUserCaptcha(CThostFtdcRspGenUserCaptchaField pRspGenUserCaptcha,
                                    CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

    }

    @Override
    public void OnRspGenUserText(CThostFtdcRspGenUserTextField pRspGenUserText, CThostFtdcRspInfoField pRspInfo,
                                 int nRequestID, boolean bIsLast) {

    }

    @Override
    public void OnRspQrySecAgentTradeInfo(CThostFtdcSecAgentTradeInfoField pSecAgentTradeInfo,
                                          CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

    }

}
