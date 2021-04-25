/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.longsheng.xueqiao.util.esunny9.swig;

public class EsunnyTradeSwig {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected EsunnyTradeSwig(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EsunnyTradeSwig obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        EsunnyTradeSwigUtilJNI.delete_EsunnyTradeSwig(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public EsunnyTradeSwig() {
    this(EsunnyTradeSwigUtilJNI.new_EsunnyTradeSwig(), true);
  }

  public void Init(EsLoginInfo esLoginInfo, IEsunnyTradeSwigCallback callback) {
    EsunnyTradeSwigUtilJNI.EsunnyTradeSwig_Init__SWIG_0(swigCPtr, this, EsLoginInfo.getCPtr(esLoginInfo), esLoginInfo, IEsunnyTradeSwigCallback.getCPtr(callback), callback);
  }

  public void Init(EsLoginInfo esLoginInfo, IEsunnyTradeSwigCallback callback, QryCommodityType qryCommodityType) {
    EsunnyTradeSwigUtilJNI.EsunnyTradeSwig_Init__SWIG_1(swigCPtr, this, EsLoginInfo.getCPtr(esLoginInfo), esLoginInfo, IEsunnyTradeSwigCallback.getCPtr(callback), callback, QryCommodityType.getCPtr(qryCommodityType), qryCommodityType);
  }

  public void Uninit() {
    EsunnyTradeSwigUtilJNI.EsunnyTradeSwig_Uninit(swigCPtr, this);
  }

  public void GetCommodityList() {
    EsunnyTradeSwigUtilJNI.EsunnyTradeSwig_GetCommodityList(swigCPtr, this);
  }

  public void GetContractList() {
    EsunnyTradeSwigUtilJNI.EsunnyTradeSwig_GetContractList__SWIG_0(swigCPtr, this);
  }

  public void GetContractList(char commodityType) {
    EsunnyTradeSwigUtilJNI.EsunnyTradeSwig_GetContractList__SWIG_1(swigCPtr, this, commodityType);
  }

}