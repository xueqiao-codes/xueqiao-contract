package com.longsheng.xueqiao.ctp_service.thriftapi.client;

import com.longsheng.xueqiao.ctp_service.thriftapi.CtpService;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpServiceVariable;
import org.apache.thrift.TException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.client.AsyncCallRunner;
import org.soldier.platform.svr_platform.client.IMethodCallback;
import org.soldier.platform.svr_platform.client.SvrContainer;
import org.soldier.platform.svr_platform.client.TRequestOption;
import org.soldier.platform.svr_platform.client.TServiceCall;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import org.soldier.platform.svr_platform.client.BaseStub;
import java.util.List;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpAccount;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInputOrderActionField;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInputOrderField;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInstrument;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInstrumentCommissionRate;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInstrumentMarginRate;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInvestorInfo;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInvestorPosition;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpLoginStatus;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpOrderField;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpProduct;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpTradeField;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpTradingAccount;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpTradingParams;

public class CtpServiceAsyncStub extends BaseStub { 
  public CtpServiceAsyncStub() {
    super(CtpServiceVariable.serviceKey);
  }
  public void send_reqOrderInsert(int routeKey, int timeout, CtpInputOrderField ctpInputOrderField, String clientInfo) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqOrderInsertServiceCall(routeKey, timeout, platformArgs, ctpInputOrderField, clientInfo), new TRequestOption());
  }

  public void send_reqOrderInsert(int routeKey, int timeout, CtpInputOrderField ctpInputOrderField, String clientInfo,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqOrderInsertServiceCall(routeKey, timeout, platformArgs, ctpInputOrderField, clientInfo), requestOption);
  }

  public long reqOrderInsert(int routeKey, int timeout, CtpInputOrderField ctpInputOrderField, String clientInfo, IMethodCallback<CtpService.reqOrderInsert_args, CtpService.reqOrderInsert_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqOrderInsertServiceCall(routeKey, timeout, platformArgs, ctpInputOrderField, clientInfo), callback);
  }

  public long add_reqOrderInsertCall(AsyncCallRunner runner, int routeKey, int timeout, CtpInputOrderField ctpInputOrderField, String clientInfo, IMethodCallback<CtpService.reqOrderInsert_args, CtpService.reqOrderInsert_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqOrderInsertServiceCall(routeKey, timeout, platformArgs, ctpInputOrderField, clientInfo), callback);
  }

  protected TServiceCall create_reqOrderInsertServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CtpInputOrderField ctpInputOrderField, String clientInfo){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqOrderInsert_args request = new CtpService.reqOrderInsert_args();
    request.setPlatformArgs(platformArgs);
    request.setCtpInputOrderField(ctpInputOrderField);
    request.setClientInfo(clientInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqOrderInsert");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqOrderInsert_result.class);
    return serviceCall;
  }

  public void send_reqOrderAction(int routeKey, int timeout, CtpInputOrderActionField ctpInputOrderActionField, String clientInfo) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqOrderActionServiceCall(routeKey, timeout, platformArgs, ctpInputOrderActionField, clientInfo), new TRequestOption());
  }

  public void send_reqOrderAction(int routeKey, int timeout, CtpInputOrderActionField ctpInputOrderActionField, String clientInfo,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqOrderActionServiceCall(routeKey, timeout, platformArgs, ctpInputOrderActionField, clientInfo), requestOption);
  }

  public long reqOrderAction(int routeKey, int timeout, CtpInputOrderActionField ctpInputOrderActionField, String clientInfo, IMethodCallback<CtpService.reqOrderAction_args, CtpService.reqOrderAction_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqOrderActionServiceCall(routeKey, timeout, platformArgs, ctpInputOrderActionField, clientInfo), callback);
  }

  public long add_reqOrderActionCall(AsyncCallRunner runner, int routeKey, int timeout, CtpInputOrderActionField ctpInputOrderActionField, String clientInfo, IMethodCallback<CtpService.reqOrderAction_args, CtpService.reqOrderAction_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqOrderActionServiceCall(routeKey, timeout, platformArgs, ctpInputOrderActionField, clientInfo), callback);
  }

  protected TServiceCall create_reqOrderActionServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CtpInputOrderActionField ctpInputOrderActionField, String clientInfo){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqOrderAction_args request = new CtpService.reqOrderAction_args();
    request.setPlatformArgs(platformArgs);
    request.setCtpInputOrderActionField(ctpInputOrderActionField);
    request.setClientInfo(clientInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqOrderAction");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqOrderAction_result.class);
    return serviceCall;
  }

  public void send_reqInstrumentList(int routeKey, int timeout, String instrumentId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqInstrumentListServiceCall(routeKey, timeout, platformArgs, instrumentId), new TRequestOption());
  }

  public void send_reqInstrumentList(int routeKey, int timeout, String instrumentId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqInstrumentListServiceCall(routeKey, timeout, platformArgs, instrumentId), requestOption);
  }

  public long reqInstrumentList(int routeKey, int timeout, String instrumentId, IMethodCallback<CtpService.reqInstrumentList_args, CtpService.reqInstrumentList_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqInstrumentListServiceCall(routeKey, timeout, platformArgs, instrumentId), callback);
  }

  public long add_reqInstrumentListCall(AsyncCallRunner runner, int routeKey, int timeout, String instrumentId, IMethodCallback<CtpService.reqInstrumentList_args, CtpService.reqInstrumentList_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqInstrumentListServiceCall(routeKey, timeout, platformArgs, instrumentId), callback);
  }

  protected TServiceCall create_reqInstrumentListServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String instrumentId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqInstrumentList_args request = new CtpService.reqInstrumentList_args();
    request.setPlatformArgs(platformArgs);
    request.setInstrumentId(instrumentId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqInstrumentList");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqInstrumentList_result.class);
    return serviceCall;
  }

  public void send_reqInvestorInfo(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqInvestorInfoServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_reqInvestorInfo(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqInvestorInfoServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long reqInvestorInfo(int routeKey, int timeout, IMethodCallback<CtpService.reqInvestorInfo_args, CtpService.reqInvestorInfo_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqInvestorInfoServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_reqInvestorInfoCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<CtpService.reqInvestorInfo_args, CtpService.reqInvestorInfo_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqInvestorInfoServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_reqInvestorInfoServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqInvestorInfo_args request = new CtpService.reqInvestorInfo_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqInvestorInfo");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqInvestorInfo_result.class);
    return serviceCall;
  }

  public void send_reqTradingParams(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqTradingParamsServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_reqTradingParams(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqTradingParamsServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long reqTradingParams(int routeKey, int timeout, IMethodCallback<CtpService.reqTradingParams_args, CtpService.reqTradingParams_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqTradingParamsServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_reqTradingParamsCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<CtpService.reqTradingParams_args, CtpService.reqTradingParams_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqTradingParamsServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_reqTradingParamsServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqTradingParams_args request = new CtpService.reqTradingParams_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqTradingParams");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqTradingParams_result.class);
    return serviceCall;
  }

  public void send_reqOrders(int routeKey, int timeout, String frontId, String sessionId, String orderRef, String sledId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqOrdersServiceCall(routeKey, timeout, platformArgs, frontId, sessionId, orderRef, sledId), new TRequestOption());
  }

  public void send_reqOrders(int routeKey, int timeout, String frontId, String sessionId, String orderRef, String sledId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqOrdersServiceCall(routeKey, timeout, platformArgs, frontId, sessionId, orderRef, sledId), requestOption);
  }

  public long reqOrders(int routeKey, int timeout, String frontId, String sessionId, String orderRef, String sledId, IMethodCallback<CtpService.reqOrders_args, CtpService.reqOrders_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqOrdersServiceCall(routeKey, timeout, platformArgs, frontId, sessionId, orderRef, sledId), callback);
  }

  public long add_reqOrdersCall(AsyncCallRunner runner, int routeKey, int timeout, String frontId, String sessionId, String orderRef, String sledId, IMethodCallback<CtpService.reqOrders_args, CtpService.reqOrders_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqOrdersServiceCall(routeKey, timeout, platformArgs, frontId, sessionId, orderRef, sledId), callback);
  }

  protected TServiceCall create_reqOrdersServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String frontId, String sessionId, String orderRef, String sledId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqOrders_args request = new CtpService.reqOrders_args();
    request.setPlatformArgs(platformArgs);
    request.setFrontId(frontId);
    request.setSessionId(sessionId);
    request.setOrderRef(orderRef);
    request.setSledId(sledId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqOrders");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqOrders_result.class);
    return serviceCall;
  }

  public void send_reqTrades(int routeKey, int timeout, String exchangeId, String orderSysID, String tradeId, String sledId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqTradesServiceCall(routeKey, timeout, platformArgs, exchangeId, orderSysID, tradeId, sledId), new TRequestOption());
  }

  public void send_reqTrades(int routeKey, int timeout, String exchangeId, String orderSysID, String tradeId, String sledId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqTradesServiceCall(routeKey, timeout, platformArgs, exchangeId, orderSysID, tradeId, sledId), requestOption);
  }

  public long reqTrades(int routeKey, int timeout, String exchangeId, String orderSysID, String tradeId, String sledId, IMethodCallback<CtpService.reqTrades_args, CtpService.reqTrades_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqTradesServiceCall(routeKey, timeout, platformArgs, exchangeId, orderSysID, tradeId, sledId), callback);
  }

  public long add_reqTradesCall(AsyncCallRunner runner, int routeKey, int timeout, String exchangeId, String orderSysID, String tradeId, String sledId, IMethodCallback<CtpService.reqTrades_args, CtpService.reqTrades_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqTradesServiceCall(routeKey, timeout, platformArgs, exchangeId, orderSysID, tradeId, sledId), callback);
  }

  protected TServiceCall create_reqTradesServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String exchangeId, String orderSysID, String tradeId, String sledId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqTrades_args request = new CtpService.reqTrades_args();
    request.setPlatformArgs(platformArgs);
    request.setExchangeId(exchangeId);
    request.setOrderSysID(orderSysID);
    request.setTradeId(tradeId);
    request.setSledId(sledId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqTrades");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqTrades_result.class);
    return serviceCall;
  }

  public void send_reqInvestorPosition(int routeKey, int timeout, String instrumentId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqInvestorPositionServiceCall(routeKey, timeout, platformArgs, instrumentId), new TRequestOption());
  }

  public void send_reqInvestorPosition(int routeKey, int timeout, String instrumentId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqInvestorPositionServiceCall(routeKey, timeout, platformArgs, instrumentId), requestOption);
  }

  public long reqInvestorPosition(int routeKey, int timeout, String instrumentId, IMethodCallback<CtpService.reqInvestorPosition_args, CtpService.reqInvestorPosition_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqInvestorPositionServiceCall(routeKey, timeout, platformArgs, instrumentId), callback);
  }

  public long add_reqInvestorPositionCall(AsyncCallRunner runner, int routeKey, int timeout, String instrumentId, IMethodCallback<CtpService.reqInvestorPosition_args, CtpService.reqInvestorPosition_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqInvestorPositionServiceCall(routeKey, timeout, platformArgs, instrumentId), callback);
  }

  protected TServiceCall create_reqInvestorPositionServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String instrumentId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqInvestorPosition_args request = new CtpService.reqInvestorPosition_args();
    request.setPlatformArgs(platformArgs);
    request.setInstrumentId(instrumentId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqInvestorPosition");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqInvestorPosition_result.class);
    return serviceCall;
  }

  public void send_reqInstrumentMarginRate(int routeKey, int timeout, String instrumentId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqInstrumentMarginRateServiceCall(routeKey, timeout, platformArgs, instrumentId), new TRequestOption());
  }

  public void send_reqInstrumentMarginRate(int routeKey, int timeout, String instrumentId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqInstrumentMarginRateServiceCall(routeKey, timeout, platformArgs, instrumentId), requestOption);
  }

  public long reqInstrumentMarginRate(int routeKey, int timeout, String instrumentId, IMethodCallback<CtpService.reqInstrumentMarginRate_args, CtpService.reqInstrumentMarginRate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqInstrumentMarginRateServiceCall(routeKey, timeout, platformArgs, instrumentId), callback);
  }

  public long add_reqInstrumentMarginRateCall(AsyncCallRunner runner, int routeKey, int timeout, String instrumentId, IMethodCallback<CtpService.reqInstrumentMarginRate_args, CtpService.reqInstrumentMarginRate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqInstrumentMarginRateServiceCall(routeKey, timeout, platformArgs, instrumentId), callback);
  }

  protected TServiceCall create_reqInstrumentMarginRateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String instrumentId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqInstrumentMarginRate_args request = new CtpService.reqInstrumentMarginRate_args();
    request.setPlatformArgs(platformArgs);
    request.setInstrumentId(instrumentId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqInstrumentMarginRate");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqInstrumentMarginRate_result.class);
    return serviceCall;
  }

  public void send_reqInstrumentCommissionRate(int routeKey, int timeout, String instrumentId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqInstrumentCommissionRateServiceCall(routeKey, timeout, platformArgs, instrumentId), new TRequestOption());
  }

  public void send_reqInstrumentCommissionRate(int routeKey, int timeout, String instrumentId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqInstrumentCommissionRateServiceCall(routeKey, timeout, platformArgs, instrumentId), requestOption);
  }

  public long reqInstrumentCommissionRate(int routeKey, int timeout, String instrumentId, IMethodCallback<CtpService.reqInstrumentCommissionRate_args, CtpService.reqInstrumentCommissionRate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqInstrumentCommissionRateServiceCall(routeKey, timeout, platformArgs, instrumentId), callback);
  }

  public long add_reqInstrumentCommissionRateCall(AsyncCallRunner runner, int routeKey, int timeout, String instrumentId, IMethodCallback<CtpService.reqInstrumentCommissionRate_args, CtpService.reqInstrumentCommissionRate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqInstrumentCommissionRateServiceCall(routeKey, timeout, platformArgs, instrumentId), callback);
  }

  protected TServiceCall create_reqInstrumentCommissionRateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String instrumentId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqInstrumentCommissionRate_args request = new CtpService.reqInstrumentCommissionRate_args();
    request.setPlatformArgs(platformArgs);
    request.setInstrumentId(instrumentId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqInstrumentCommissionRate");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqInstrumentCommissionRate_result.class);
    return serviceCall;
  }

  public void send_reqTradingAccount(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqTradingAccountServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_reqTradingAccount(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqTradingAccountServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long reqTradingAccount(int routeKey, int timeout, IMethodCallback<CtpService.reqTradingAccount_args, CtpService.reqTradingAccount_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqTradingAccountServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_reqTradingAccountCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<CtpService.reqTradingAccount_args, CtpService.reqTradingAccount_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqTradingAccountServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_reqTradingAccountServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqTradingAccount_args request = new CtpService.reqTradingAccount_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqTradingAccount");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqTradingAccount_result.class);
    return serviceCall;
  }

  public void send_reqProducts(int routeKey, int timeout, String productId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqProductsServiceCall(routeKey, timeout, platformArgs, productId), new TRequestOption());
  }

  public void send_reqProducts(int routeKey, int timeout, String productId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqProductsServiceCall(routeKey, timeout, platformArgs, productId), requestOption);
  }

  public long reqProducts(int routeKey, int timeout, String productId, IMethodCallback<CtpService.reqProducts_args, CtpService.reqProducts_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqProductsServiceCall(routeKey, timeout, platformArgs, productId), callback);
  }

  public long add_reqProductsCall(AsyncCallRunner runner, int routeKey, int timeout, String productId, IMethodCallback<CtpService.reqProducts_args, CtpService.reqProducts_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqProductsServiceCall(routeKey, timeout, platformArgs, productId), callback);
  }

  protected TServiceCall create_reqProductsServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String productId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqProducts_args request = new CtpService.reqProducts_args();
    request.setPlatformArgs(platformArgs);
    request.setProductId(productId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqProducts");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqProducts_result.class);
    return serviceCall;
  }

  public void send_reqCtpAccount(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqCtpAccountServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_reqCtpAccount(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqCtpAccountServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long reqCtpAccount(int routeKey, int timeout, IMethodCallback<CtpService.reqCtpAccount_args, CtpService.reqCtpAccount_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqCtpAccountServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_reqCtpAccountCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<CtpService.reqCtpAccount_args, CtpService.reqCtpAccount_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqCtpAccountServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_reqCtpAccountServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqCtpAccount_args request = new CtpService.reqCtpAccount_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCtpAccount");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqCtpAccount_result.class);
    return serviceCall;
  }

  public void send_updateCtpAccount(int routeKey, int timeout, CtpAccount account) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_updateCtpAccountServiceCall(routeKey, timeout, platformArgs, account), new TRequestOption());
  }

  public void send_updateCtpAccount(int routeKey, int timeout, CtpAccount account,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_updateCtpAccountServiceCall(routeKey, timeout, platformArgs, account), requestOption);
  }

  public long updateCtpAccount(int routeKey, int timeout, CtpAccount account, IMethodCallback<CtpService.updateCtpAccount_args, CtpService.updateCtpAccount_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_updateCtpAccountServiceCall(routeKey, timeout, platformArgs, account), callback);
  }

  public long add_updateCtpAccountCall(AsyncCallRunner runner, int routeKey, int timeout, CtpAccount account, IMethodCallback<CtpService.updateCtpAccount_args, CtpService.updateCtpAccount_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_updateCtpAccountServiceCall(routeKey, timeout, platformArgs, account), callback);
  }

  protected TServiceCall create_updateCtpAccountServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CtpAccount account){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.updateCtpAccount_args request = new CtpService.updateCtpAccount_args();
    request.setPlatformArgs(platformArgs);
    request.setAccount(account);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateCtpAccount");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.updateCtpAccount_result.class);
    return serviceCall;
  }

  public void send_reqLogin(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqLoginServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_reqLogin(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqLoginServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long reqLogin(int routeKey, int timeout, IMethodCallback<CtpService.reqLogin_args, CtpService.reqLogin_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqLoginServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_reqLoginCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<CtpService.reqLogin_args, CtpService.reqLogin_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqLoginServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_reqLoginServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqLogin_args request = new CtpService.reqLogin_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqLogin");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqLogin_result.class);
    return serviceCall;
  }

  public void send_reqLogout(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqLogoutServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_reqLogout(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqLogoutServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long reqLogout(int routeKey, int timeout, IMethodCallback<CtpService.reqLogout_args, CtpService.reqLogout_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqLogoutServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_reqLogoutCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<CtpService.reqLogout_args, CtpService.reqLogout_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqLogoutServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_reqLogoutServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqLogout_args request = new CtpService.reqLogout_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqLogout");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqLogout_result.class);
    return serviceCall;
  }

  public void send_reqRelogin(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqReloginServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_reqRelogin(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqReloginServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long reqRelogin(int routeKey, int timeout, IMethodCallback<CtpService.reqRelogin_args, CtpService.reqRelogin_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqReloginServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_reqReloginCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<CtpService.reqRelogin_args, CtpService.reqRelogin_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqReloginServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_reqReloginServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqRelogin_args request = new CtpService.reqRelogin_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqRelogin");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqRelogin_result.class);
    return serviceCall;
  }

  public void send_reqLoginStatus(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqLoginStatusServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_reqLoginStatus(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqLoginStatusServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long reqLoginStatus(int routeKey, int timeout, IMethodCallback<CtpService.reqLoginStatus_args, CtpService.reqLoginStatus_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqLoginStatusServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_reqLoginStatusCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<CtpService.reqLoginStatus_args, CtpService.reqLoginStatus_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqLoginStatusServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_reqLoginStatusServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CtpServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CtpService.reqLoginStatus_args request = new CtpService.reqLoginStatus_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqLoginStatus");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CtpService.reqLoginStatus_result.class);
    return serviceCall;
  }

}
