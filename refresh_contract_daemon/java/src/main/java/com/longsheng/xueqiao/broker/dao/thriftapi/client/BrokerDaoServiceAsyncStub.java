package com.longsheng.xueqiao.broker.dao.thriftapi.client;

import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerDaoService;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerDaoServiceVariable;
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
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.RemoveBrokerAccessEntryResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.RemoveBrokerEntryResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.SyncBrokerOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.SyncBrokerResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.WorkingBrokerAccessEntryResp;

public class BrokerDaoServiceAsyncStub extends BaseStub { 
  public BrokerDaoServiceAsyncStub() {
    super(BrokerDaoServiceVariable.serviceKey);
  }
  public void send_addBrokerEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry) throws TException {
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
        create_addBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntry), new TRequestOption());
  }

  public void send_addBrokerEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry,TRequestOption requestOption) throws TException { 
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
        create_addBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntry), requestOption);
  }

  public long addBrokerEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry, IMethodCallback<BrokerDaoService.addBrokerEntry_args, BrokerDaoService.addBrokerEntry_result> callback) throws TException{
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
            create_addBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntry), callback);
  }

  public long add_addBrokerEntryCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry, IMethodCallback<BrokerDaoService.addBrokerEntry_args, BrokerDaoService.addBrokerEntry_result> callback) throws TException{
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
            create_addBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntry), callback);
  }

  protected TServiceCall create_addBrokerEntryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.addBrokerEntry_args request = new BrokerDaoService.addBrokerEntry_args();
    request.setPlatformArgs(platformArgs);
    request.setBrokerEntry(brokerEntry);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addBrokerEntry");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.addBrokerEntry_result.class);
    return serviceCall;
  }

  public void send_updateBrokerEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry) throws TException {
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
        create_updateBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntry), new TRequestOption());
  }

  public void send_updateBrokerEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry,TRequestOption requestOption) throws TException { 
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
        create_updateBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntry), requestOption);
  }

  public long updateBrokerEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry, IMethodCallback<BrokerDaoService.updateBrokerEntry_args, BrokerDaoService.updateBrokerEntry_result> callback) throws TException{
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
            create_updateBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntry), callback);
  }

  public long add_updateBrokerEntryCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry, IMethodCallback<BrokerDaoService.updateBrokerEntry_args, BrokerDaoService.updateBrokerEntry_result> callback) throws TException{
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
            create_updateBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntry), callback);
  }

  protected TServiceCall create_updateBrokerEntryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.updateBrokerEntry_args request = new BrokerDaoService.updateBrokerEntry_args();
    request.setPlatformArgs(platformArgs);
    request.setBrokerEntry(brokerEntry);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateBrokerEntry");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.updateBrokerEntry_result.class);
    return serviceCall;
  }

  public void send_reqBrokerEntry(int routeKey, int timeout, ReqBrokerEntryOption option, int pageIndex, int pageSize) throws TException {
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
        create_reqBrokerEntryServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), new TRequestOption());
  }

  public void send_reqBrokerEntry(int routeKey, int timeout, ReqBrokerEntryOption option, int pageIndex, int pageSize,TRequestOption requestOption) throws TException { 
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
        create_reqBrokerEntryServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), requestOption);
  }

  public long reqBrokerEntry(int routeKey, int timeout, ReqBrokerEntryOption option, int pageIndex, int pageSize, IMethodCallback<BrokerDaoService.reqBrokerEntry_args, BrokerDaoService.reqBrokerEntry_result> callback) throws TException{
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
            create_reqBrokerEntryServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  public long add_reqBrokerEntryCall(AsyncCallRunner runner, int routeKey, int timeout, ReqBrokerEntryOption option, int pageIndex, int pageSize, IMethodCallback<BrokerDaoService.reqBrokerEntry_args, BrokerDaoService.reqBrokerEntry_result> callback) throws TException{
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
            create_reqBrokerEntryServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  protected TServiceCall create_reqBrokerEntryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqBrokerEntryOption option, int pageIndex, int pageSize){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.reqBrokerEntry_args request = new BrokerDaoService.reqBrokerEntry_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageIndex(pageIndex);
    request.setPageSize(pageSize);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqBrokerEntry");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.reqBrokerEntry_result.class);
    return serviceCall;
  }

  public void send_addBrokerAccessEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry) throws TException {
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
        create_addBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntry), new TRequestOption());
  }

  public void send_addBrokerAccessEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry,TRequestOption requestOption) throws TException { 
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
        create_addBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntry), requestOption);
  }

  public long addBrokerAccessEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry, IMethodCallback<BrokerDaoService.addBrokerAccessEntry_args, BrokerDaoService.addBrokerAccessEntry_result> callback) throws TException{
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
            create_addBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntry), callback);
  }

  public long add_addBrokerAccessEntryCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry, IMethodCallback<BrokerDaoService.addBrokerAccessEntry_args, BrokerDaoService.addBrokerAccessEntry_result> callback) throws TException{
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
            create_addBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntry), callback);
  }

  protected TServiceCall create_addBrokerAccessEntryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.addBrokerAccessEntry_args request = new BrokerDaoService.addBrokerAccessEntry_args();
    request.setPlatformArgs(platformArgs);
    request.setBrokerAccessEntry(brokerAccessEntry);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addBrokerAccessEntry");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.addBrokerAccessEntry_result.class);
    return serviceCall;
  }

  public void send_updateBrokerAccessEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry) throws TException {
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
        create_updateBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntry), new TRequestOption());
  }

  public void send_updateBrokerAccessEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry,TRequestOption requestOption) throws TException { 
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
        create_updateBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntry), requestOption);
  }

  public long updateBrokerAccessEntry(int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry, IMethodCallback<BrokerDaoService.updateBrokerAccessEntry_args, BrokerDaoService.updateBrokerAccessEntry_result> callback) throws TException{
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
            create_updateBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntry), callback);
  }

  public long add_updateBrokerAccessEntryCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry, IMethodCallback<BrokerDaoService.updateBrokerAccessEntry_args, BrokerDaoService.updateBrokerAccessEntry_result> callback) throws TException{
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
            create_updateBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntry), callback);
  }

  protected TServiceCall create_updateBrokerAccessEntryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.updateBrokerAccessEntry_args request = new BrokerDaoService.updateBrokerAccessEntry_args();
    request.setPlatformArgs(platformArgs);
    request.setBrokerAccessEntry(brokerAccessEntry);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateBrokerAccessEntry");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.updateBrokerAccessEntry_result.class);
    return serviceCall;
  }

  public void send_reqBrokerAccessEntry(int routeKey, int timeout, ReqBrokerAccessEntryOption option, int pageIndex, int pageSize) throws TException {
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
        create_reqBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), new TRequestOption());
  }

  public void send_reqBrokerAccessEntry(int routeKey, int timeout, ReqBrokerAccessEntryOption option, int pageIndex, int pageSize,TRequestOption requestOption) throws TException { 
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
        create_reqBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), requestOption);
  }

  public long reqBrokerAccessEntry(int routeKey, int timeout, ReqBrokerAccessEntryOption option, int pageIndex, int pageSize, IMethodCallback<BrokerDaoService.reqBrokerAccessEntry_args, BrokerDaoService.reqBrokerAccessEntry_result> callback) throws TException{
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
            create_reqBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  public long add_reqBrokerAccessEntryCall(AsyncCallRunner runner, int routeKey, int timeout, ReqBrokerAccessEntryOption option, int pageIndex, int pageSize, IMethodCallback<BrokerDaoService.reqBrokerAccessEntry_args, BrokerDaoService.reqBrokerAccessEntry_result> callback) throws TException{
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
            create_reqBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  protected TServiceCall create_reqBrokerAccessEntryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqBrokerAccessEntryOption option, int pageIndex, int pageSize){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.reqBrokerAccessEntry_args request = new BrokerDaoService.reqBrokerAccessEntry_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageIndex(pageIndex);
    request.setPageSize(pageSize);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqBrokerAccessEntry");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.reqBrokerAccessEntry_result.class);
    return serviceCall;
  }

  public void send_reqWorkingBrokerAccessEntry(int routeKey, int timeout, int brokerAccessEntryId) throws TException {
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
        create_reqWorkingBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), new TRequestOption());
  }

  public void send_reqWorkingBrokerAccessEntry(int routeKey, int timeout, int brokerAccessEntryId,TRequestOption requestOption) throws TException { 
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
        create_reqWorkingBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), requestOption);
  }

  public long reqWorkingBrokerAccessEntry(int routeKey, int timeout, int brokerAccessEntryId, IMethodCallback<BrokerDaoService.reqWorkingBrokerAccessEntry_args, BrokerDaoService.reqWorkingBrokerAccessEntry_result> callback) throws TException{
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
            create_reqWorkingBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), callback);
  }

  public long add_reqWorkingBrokerAccessEntryCall(AsyncCallRunner runner, int routeKey, int timeout, int brokerAccessEntryId, IMethodCallback<BrokerDaoService.reqWorkingBrokerAccessEntry_args, BrokerDaoService.reqWorkingBrokerAccessEntry_result> callback) throws TException{
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
            create_reqWorkingBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), callback);
  }

  protected TServiceCall create_reqWorkingBrokerAccessEntryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int brokerAccessEntryId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.reqWorkingBrokerAccessEntry_args request = new BrokerDaoService.reqWorkingBrokerAccessEntry_args();
    request.setPlatformArgs(platformArgs);
    request.setBrokerAccessEntryId(brokerAccessEntryId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqWorkingBrokerAccessEntry");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.reqWorkingBrokerAccessEntry_result.class);
    return serviceCall;
  }

  public void send_syncBrokerAccessEntry(int routeKey, int timeout, int brokerAccessEntryId) throws TException {
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
        create_syncBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), new TRequestOption());
  }

  public void send_syncBrokerAccessEntry(int routeKey, int timeout, int brokerAccessEntryId,TRequestOption requestOption) throws TException { 
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
        create_syncBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), requestOption);
  }

  public long syncBrokerAccessEntry(int routeKey, int timeout, int brokerAccessEntryId, IMethodCallback<BrokerDaoService.syncBrokerAccessEntry_args, BrokerDaoService.syncBrokerAccessEntry_result> callback) throws TException{
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
            create_syncBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), callback);
  }

  public long add_syncBrokerAccessEntryCall(AsyncCallRunner runner, int routeKey, int timeout, int brokerAccessEntryId, IMethodCallback<BrokerDaoService.syncBrokerAccessEntry_args, BrokerDaoService.syncBrokerAccessEntry_result> callback) throws TException{
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
            create_syncBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), callback);
  }

  protected TServiceCall create_syncBrokerAccessEntryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int brokerAccessEntryId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.syncBrokerAccessEntry_args request = new BrokerDaoService.syncBrokerAccessEntry_args();
    request.setPlatformArgs(platformArgs);
    request.setBrokerAccessEntryId(brokerAccessEntryId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("syncBrokerAccessEntry");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.syncBrokerAccessEntry_result.class);
    return serviceCall;
  }

  public void send_removeBrokerAccessEntry(int routeKey, int timeout, int brokerAccessEntryId) throws TException {
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
        create_removeBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), new TRequestOption());
  }

  public void send_removeBrokerAccessEntry(int routeKey, int timeout, int brokerAccessEntryId,TRequestOption requestOption) throws TException { 
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
        create_removeBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), requestOption);
  }

  public long removeBrokerAccessEntry(int routeKey, int timeout, int brokerAccessEntryId, IMethodCallback<BrokerDaoService.removeBrokerAccessEntry_args, BrokerDaoService.removeBrokerAccessEntry_result> callback) throws TException{
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
            create_removeBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), callback);
  }

  public long add_removeBrokerAccessEntryCall(AsyncCallRunner runner, int routeKey, int timeout, int brokerAccessEntryId, IMethodCallback<BrokerDaoService.removeBrokerAccessEntry_args, BrokerDaoService.removeBrokerAccessEntry_result> callback) throws TException{
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
            create_removeBrokerAccessEntryServiceCall(routeKey, timeout, platformArgs, brokerAccessEntryId), callback);
  }

  protected TServiceCall create_removeBrokerAccessEntryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int brokerAccessEntryId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.removeBrokerAccessEntry_args request = new BrokerDaoService.removeBrokerAccessEntry_args();
    request.setPlatformArgs(platformArgs);
    request.setBrokerAccessEntryId(brokerAccessEntryId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("removeBrokerAccessEntry");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.removeBrokerAccessEntry_result.class);
    return serviceCall;
  }

  public void send_removeBrokerEntry(int routeKey, int timeout, int brokerEntryId) throws TException {
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
        create_removeBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntryId), new TRequestOption());
  }

  public void send_removeBrokerEntry(int routeKey, int timeout, int brokerEntryId,TRequestOption requestOption) throws TException { 
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
        create_removeBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntryId), requestOption);
  }

  public long removeBrokerEntry(int routeKey, int timeout, int brokerEntryId, IMethodCallback<BrokerDaoService.removeBrokerEntry_args, BrokerDaoService.removeBrokerEntry_result> callback) throws TException{
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
            create_removeBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntryId), callback);
  }

  public long add_removeBrokerEntryCall(AsyncCallRunner runner, int routeKey, int timeout, int brokerEntryId, IMethodCallback<BrokerDaoService.removeBrokerEntry_args, BrokerDaoService.removeBrokerEntry_result> callback) throws TException{
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
            create_removeBrokerEntryServiceCall(routeKey, timeout, platformArgs, brokerEntryId), callback);
  }

  protected TServiceCall create_removeBrokerEntryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int brokerEntryId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.removeBrokerEntry_args request = new BrokerDaoService.removeBrokerEntry_args();
    request.setPlatformArgs(platformArgs);
    request.setBrokerEntryId(brokerEntryId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("removeBrokerEntry");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.removeBrokerEntry_result.class);
    return serviceCall;
  }

  public void send_syncBroker(int routeKey, int timeout, SyncBrokerOption option) throws TException {
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
        create_syncBrokerServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_syncBroker(int routeKey, int timeout, SyncBrokerOption option,TRequestOption requestOption) throws TException { 
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
        create_syncBrokerServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long syncBroker(int routeKey, int timeout, SyncBrokerOption option, IMethodCallback<BrokerDaoService.syncBroker_args, BrokerDaoService.syncBroker_result> callback) throws TException{
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
            create_syncBrokerServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_syncBrokerCall(AsyncCallRunner runner, int routeKey, int timeout, SyncBrokerOption option, IMethodCallback<BrokerDaoService.syncBroker_args, BrokerDaoService.syncBroker_result> callback) throws TException{
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
            create_syncBrokerServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_syncBrokerServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, SyncBrokerOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(BrokerDaoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    BrokerDaoService.syncBroker_args request = new BrokerDaoService.syncBroker_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("syncBroker");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(BrokerDaoService.syncBroker_result.class);
    return serviceCall;
  }

}
