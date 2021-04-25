package com.xueqiao.ctp_service.core.trade;

import net.jctp.*;
import org.soldier.base.logger.AppLog;

abstract class CtpTradeListenerAdaptor implements TraderApiListener {
    @Override
    public void OnFrontConnected() {
        AppLog.i("TraderListener.OnFrontConnected enter");
    }

    @Override
    public void OnFrontDisconnected(int nReason) {
        AppLog.i("TraderListener.OnFrontDisconnected enter: "
                + nReason);
    }

    @Override
    public void OnHeartBeatWarning(int nTimeLapse) {
        AppLog.i("TraderListener.OnHeartBeatWarning enter: " + nTimeLapse);
    }

    @Override
    public void OnRspAuthenticate(
            CThostFtdcRspAuthenticateField pRspAuthenticateField,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspAuthenticate enter: "
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

    public void OnRspSettlementInfoConfirm(
            CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspSettlementInfoConfirm enter: "
                + pSettlementInfoConfirm + "," + pRspInfo + "," + nRequestID
                + "," + bIsLast);
    }

    public void OnRspUserLogout(CThostFtdcUserLogoutField pUserLogout,
                                CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.i("TraderListener.OnRspUserLogout enter: "
                + pUserLogout + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspUserPasswordUpdate(
            CThostFtdcUserPasswordUpdateField pUserPasswordUpdate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspUserPasswordUpdate enter: "
                + pUserPasswordUpdate + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspTradingAccountPasswordUpdate(
            CThostFtdcTradingAccountPasswordUpdateField pTradingAccountPasswordUpdate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspTradingAccountPasswordUpdate enter: "
                + pTradingAccountPasswordUpdate
                + ","
                + pRspInfo
                + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRspOrderInsert(CThostFtdcInputOrderField pInputOrder,
                                 CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        AppLog.d("TraderListener.OnRspOrderInsert enter: "
                + pInputOrder + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspParkedOrderInsert(CThostFtdcParkedOrderField pParkedOrder,
                                       CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspParkedOrderInsert enter: "
                + pParkedOrder + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspParkedOrderAction(
            CThostFtdcParkedOrderActionField pParkedOrderAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspParkedOrderAction enter: "
                + pParkedOrderAction + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspOrderAction(
            CThostFtdcInputOrderActionField pInputOrderAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        AppLog.d("TraderListener.OnRspOrderAction enter: "
                + pInputOrderAction + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQueryMaxOrderVolume(
            CThostFtdcQueryMaxOrderVolumeField pQueryMaxOrderVolume,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQueryMaxOrderVolume enter: "
                + pQueryMaxOrderVolume + "," + pRspInfo + "," + nRequestID
                + "," + bIsLast);
    }

    public void OnRspRemoveParkedOrder(
            CThostFtdcRemoveParkedOrderField pRemoveParkedOrder,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspRemoveParkedOrder enter: "
                + pRemoveParkedOrder + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspRemoveParkedOrderAction(
            CThostFtdcRemoveParkedOrderActionField pRemoveParkedOrderAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspRemoveParkedOrderAction enter: "
                + pRemoveParkedOrderAction + "," + pRspInfo + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRspQryOrder(CThostFtdcOrderField pOrder,
                              CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryOrder enter: " + pOrder
                + "," + pRspInfo + "," + nRequestID + "," + bIsLast);
    }

    public void OnRspQryTrade(CThostFtdcTradeField pTrade,
                              CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTrade enter: " + pTrade
                + "," + pRspInfo + "," + nRequestID + "," + bIsLast);
    }

    public void OnRspQryInvestorPosition(
            CThostFtdcInvestorPositionField pInvestorPosition,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryInvestorPosition enter: "
                + pInvestorPosition + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryTradingAccount(
            CThostFtdcTradingAccountField pTradingAccount,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTradingAccount enter: "
                + pTradingAccount + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryInvestor(CThostFtdcInvestorField pInvestor,
                                 CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryInvestor enter: " + pInvestor
                + "," + pRspInfo + "," + nRequestID + "," + bIsLast);
    }

    public void OnRspQryTradingCode(CThostFtdcTradingCodeField pTradingCode,
                                    CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTradingCode enter: "
                + pTradingCode + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryInstrumentMarginRate(
            CThostFtdcInstrumentMarginRateField pInstrumentMarginRate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryInstrumentMarginRate enter: "
                + pInstrumentMarginRate + "," + pRspInfo + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRspQryInstrumentCommissionRate(
            CThostFtdcInstrumentCommissionRateField pInstrumentCommissionRate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryInstrumentCommissionRate enter: "
                + pInstrumentCommissionRate
                + ","
                + pRspInfo
                + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRspQryExchange(CThostFtdcExchangeField pExchange,
                                 CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryExchange enter: " + pExchange
                + "," + pRspInfo + "," + nRequestID + "," + bIsLast);
    }

    public void OnRspQryInstrument(CThostFtdcInstrumentField pInstrument,
                                   CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryInstrument enter: "
                + pInstrument + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryDepthMarketData(
            CThostFtdcDepthMarketDataField pDepthMarketData,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryDepthMarketData enter: "
                + pDepthMarketData + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQrySettlementInfo(
            CThostFtdcSettlementInfoField pSettlementInfo,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQrySettlementInfo enter: "
                + pSettlementInfo + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryTransferBank(CThostFtdcTransferBankField pTransferBank,
                                     CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTransferBank enter: "
                + pTransferBank + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryInvestorPositionDetail(
            CThostFtdcInvestorPositionDetailField pInvestorPositionDetail,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryInvestorPositionDetail enter: "
                + pInvestorPositionDetail
                + ","
                + pRspInfo
                + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRspQryNotice(CThostFtdcNoticeField pNotice,
                               CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryNotice enter: " + pNotice
                + "," + pRspInfo + "," + nRequestID + "," + bIsLast);
    }

    public void OnRspQrySettlementInfoConfirm(
            CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQrySettlementInfoConfirm enter: "
                + pSettlementInfoConfirm + "," + pRspInfo + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRspQryInvestorPositionCombineDetail(
            CThostFtdcInvestorPositionCombineDetailField pInvestorPositionCombineDetail,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryInvestorPositionCombineDetail enter: "
                + pInvestorPositionCombineDetail
                + ","
                + pRspInfo
                + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRspQryCFMMCTradingAccountKey(
            CThostFtdcCFMMCTradingAccountKeyField pCFMMCTradingAccountKey,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryCFMMCTradingAccountKey enter: "
                + pCFMMCTradingAccountKey
                + ","
                + pRspInfo
                + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRspQryEWarrantOffset(
            CThostFtdcEWarrantOffsetField pEWarrantOffset,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryEWarrantOffset enter: "
                + pEWarrantOffset + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryInvestorProductGroupMargin(
            CThostFtdcInvestorProductGroupMarginField pInvestorProductGroupMargin,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryInvestorProductGroupMargin enter: "
                + pInvestorProductGroupMargin
                + ","
                + pRspInfo
                + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRspQryExchangeMarginRate(
            CThostFtdcExchangeMarginRateField pExchangeMarginRate,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryExchangeMarginRate enter: "
                + pExchangeMarginRate + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryExchangeMarginRateAdjust(
            CThostFtdcExchangeMarginRateAdjustField pExchangeMarginRateAdjust,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryExchangeMarginRateAdjust enter: "
                + pExchangeMarginRateAdjust
                + ","
                + pRspInfo
                + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRspQryTransferSerial(
            CThostFtdcTransferSerialField pTransferSerial,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTransferSerial enter: "
                + pTransferSerial + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryAccountregister(
            CThostFtdcAccountregisterField pAccountregister,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryAccountregister enter: "
                + pAccountregister + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID,
                           boolean bIsLast) {

        AppLog.e("TraderListener.OnRspError enter: " + pRspInfo + ","
                + nRequestID + "," + bIsLast);
    }

    public void OnRtnOrder(CThostFtdcOrderField pOrder) {
        AppLog.d("TraderListener.OnRtnOrder enter: " + pOrder);
    }

    public void OnRtnTrade(CThostFtdcTradeField pTrade) {
        AppLog.d("TraderListener.OnRtnTrade enter: " + pTrade);
    }

    public void OnErrRtnOrderInsert(CThostFtdcInputOrderField pInputOrder,
                                    CThostFtdcRspInfoField pRspInfo) {
        AppLog.e("TraderListener.OnErrRtnOrderInsert enter: "
                + pInputOrder + "," + pRspInfo);
    }

    public void OnErrRtnOrderAction(CThostFtdcOrderActionField pOrderAction,
                                    CThostFtdcRspInfoField pRspInfo) {
        AppLog.e("TraderListener.OnErrRtnOrderAction enter: "
                + pOrderAction + "," + pRspInfo);
    }

    public void OnRtnInstrumentStatus(
            CThostFtdcInstrumentStatusField pInstrumentStatus) {
        AppLog.d("TraderListener.OnRtnInstrumentStatus enter: "
                + pInstrumentStatus);
    }

    public void OnRtnTradingNotice(
            CThostFtdcTradingNoticeInfoField pTradingNoticeInfo) {

        AppLog.d("TraderListener.OnRtnTradingNotice enter: "
                + pTradingNoticeInfo);
    }

    public void OnRtnErrorConditionalOrder(
            CThostFtdcErrorConditionalOrderField pErrorConditionalOrder) {

        AppLog.e("TraderListener.OnRtnErrorConditionalOrder enter: "
                + pErrorConditionalOrder);
    }

    public void OnRspQryContractBank(CThostFtdcContractBankField pContractBank,
                                     CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryContractBank enter: "
                + pContractBank + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryParkedOrder(CThostFtdcParkedOrderField pParkedOrder,
                                    CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryParkedOrder enter: "
                + pParkedOrder + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryParkedOrderAction(
            CThostFtdcParkedOrderActionField pParkedOrderAction,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryParkedOrderAction enter: "
                + pParkedOrderAction + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryTradingNotice(
            CThostFtdcTradingNoticeField pTradingNotice,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryTradingNotice enter: "
                + pTradingNotice + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRspQryBrokerTradingParams(
            CThostFtdcBrokerTradingParamsField pBrokerTradingParams,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryBrokerTradingParams enter: "
                + pBrokerTradingParams + "," + pRspInfo + "," + nRequestID
                + "," + bIsLast);
    }

    public void OnRspQryBrokerTradingAlgos(
            CThostFtdcBrokerTradingAlgosField pBrokerTradingAlgos,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQryBrokerTradingAlgos enter: "
                + pBrokerTradingAlgos + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);
    }

    public void OnRtnFromBankToFutureByBank(
            CThostFtdcRspTransferField pRspTransfer) {

        AppLog.d("TraderListener.OnRtnFromBankToFutureByBank enter: "
                + pRspTransfer);
    }

    public void OnRtnFromFutureToBankByBank(
            CThostFtdcRspTransferField pRspTransfer) {

        AppLog.d("TraderListener.OnRtnFromFutureToBankByBank enter: "
                + pRspTransfer);
    }

    public void OnRtnRepealFromBankToFutureByBank(
            CThostFtdcRspRepealField pRspRepeal) {

        AppLog.d("TraderListener.OnRtnRepealFromBankToFutureByBank enter: "
                + pRspRepeal);
    }

    public void OnRtnRepealFromFutureToBankByBank(
            CThostFtdcRspRepealField pRspRepeal) {

        AppLog.d("TraderListener.OnRtnRepealFromFutureToBankByBank enter: "
                + pRspRepeal);
    }

    public void OnRtnFromBankToFutureByFuture(
            CThostFtdcRspTransferField pRspTransfer) {

        AppLog.d("TraderListener.OnRtnFromBankToFutureByFuture enter: "
                + pRspTransfer);
    }

    public void OnRtnFromFutureToBankByFuture(
            CThostFtdcRspTransferField pRspTransfer) {

        AppLog.d("TraderListener.OnRtnFromFutureToBankByFuture enter: "
                + pRspTransfer);
    }

    public void OnRtnRepealFromBankToFutureByFutureManual(
            CThostFtdcRspRepealField pRspRepeal) {

        AppLog.d("TraderListener.OnRtnRepealFromBankToFutureByFutureManual enter: "
                + pRspRepeal);
    }

    public void OnRtnRepealFromFutureToBankByFutureManual(
            CThostFtdcRspRepealField pRspRepeal) {

        AppLog.d("TraderListener.OnRtnRepealFromFutureToBankByFutureManual enter: "
                + pRspRepeal);
    }

    public void OnRtnQueryBankBalanceByFuture(
            CThostFtdcNotifyQueryAccountField pNotifyQueryAccount) {

        AppLog.d("TraderListener.OnRtnQueryBankBalanceByFuture enter: "
                + pNotifyQueryAccount);
    }

    public void OnErrRtnBankToFutureByFuture(
            CThostFtdcReqTransferField pReqTransfer,
            CThostFtdcRspInfoField pRspInfo) {

        AppLog.e("TraderListener.OnErrRtnBankToFutureByFuture enter: "
                + pReqTransfer + "," + pRspInfo);
    }

    public void OnErrRtnFutureToBankByFuture(
            CThostFtdcReqTransferField pReqTransfer,
            CThostFtdcRspInfoField pRspInfo) {

        AppLog.e("TraderListener.OnErrRtnFutureToBankByFuture enter: "
                + pReqTransfer + "," + pRspInfo);
    }

    public void OnErrRtnRepealBankToFutureByFutureManual(
            CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {

        AppLog.e("TraderListener.OnErrRtnRepealBankToFutureByFutureManual enter: "
                + pReqRepeal + "," + pRspInfo);
    }

    public void OnErrRtnRepealFutureToBankByFutureManual(
            CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {

        AppLog.e("TraderListener.OnErrRtnRepealFutureToBankByFutureManual enter: "
                + pReqRepeal + "," + pRspInfo);
    }

    public void OnErrRtnQueryBankBalanceByFuture(
            CThostFtdcReqQueryAccountField pReqQueryAccount,
            CThostFtdcRspInfoField pRspInfo) {

        AppLog.e("TraderListener.OnErrRtnQueryBankBalanceByFuture enter: "
                + pReqQueryAccount + "," + pRspInfo);
    }

    public void OnRtnRepealFromBankToFutureByFuture(
            CThostFtdcRspRepealField pRspRepeal) {

        AppLog.d("TraderListener.OnRtnRepealFromBankToFutureByFuture enter: "
                + pRspRepeal);
    }

    public void OnRtnRepealFromFutureToBankByFuture(
            CThostFtdcRspRepealField pRspRepeal) {

        AppLog.d("TraderListener.OnRtnRepealFromFutureToBankByFuture enter: "
                + pRspRepeal);
    }

    public void OnRspFromBankToFutureByFuture(
            CThostFtdcReqTransferField pReqTransfer,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspFromBankToFutureByFuture enter: "
                + pReqTransfer + "," + pRspInfo + "," + nRequestID
                + "," + bIsLast);
    }

    public void OnRspFromFutureToBankByFuture(
            CThostFtdcReqTransferField pReqTransfer,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspFromFutureToBankByFuture enter: "
                + pReqTransfer + "," + pRspInfo + "," + nRequestID
                + "," + bIsLast);
    }

    public void OnRspQueryBankAccountMoneyByFuture(
            CThostFtdcReqQueryAccountField pReqQueryAccount,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        AppLog.d("TraderListener.OnRspQueryBankAccountMoneyByFuture enter: "
                + pReqQueryAccount
                + ","
                + pRspInfo
                + ","
                + nRequestID
                + "," + bIsLast);
    }

    public void OnRtnOpenAccountByBank(CThostFtdcOpenAccountField pOpenAccount) {

        AppLog.d("TraderListener.OnRtnOpenAccountByBank enter: "
                + pOpenAccount);
    }

    public void OnRtnCancelAccountByBank(
            CThostFtdcCancelAccountField pCancelAccount) {

        AppLog.d("TraderListener.OnRtnCancelAccountByBank enter: "
                + pCancelAccount);
    }

    public void OnRtnChangeAccountByBank(
            CThostFtdcChangeAccountField pChangeAccount) {

        AppLog.d("TraderListener.OnRtnChangeAccountByBank enter: "
                + pChangeAccount);
    }

    @Override
    public void OnRspQryProduct(CThostFtdcProductField pProduct,
                                CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        AppLog.d("TraderListener.OnRspQryProduct enter: "
                + pProduct + "," + pRspInfo + "," + nRequestID + ","
                + bIsLast);

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

}
