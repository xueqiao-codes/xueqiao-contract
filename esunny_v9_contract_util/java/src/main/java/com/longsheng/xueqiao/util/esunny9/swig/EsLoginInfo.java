/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.longsheng.xueqiao.util.esunny9.swig;

public class EsLoginInfo {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected EsLoginInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EsLoginInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        EsunnyTradeSwigUtilJNI.delete_EsLoginInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUserNo(String value) {
    EsunnyTradeSwigUtilJNI.EsLoginInfo_userNo_set(swigCPtr, this, value);
  }

  public String getUserNo() {
    return EsunnyTradeSwigUtilJNI.EsLoginInfo_userNo_get(swigCPtr, this);
  }

  public void setPassword(String value) {
    EsunnyTradeSwigUtilJNI.EsLoginInfo_password_set(swigCPtr, this, value);
  }

  public String getPassword() {
    return EsunnyTradeSwigUtilJNI.EsLoginInfo_password_get(swigCPtr, this);
  }

  public void setIp(String value) {
    EsunnyTradeSwigUtilJNI.EsLoginInfo_ip_set(swigCPtr, this, value);
  }

  public String getIp() {
    return EsunnyTradeSwigUtilJNI.EsLoginInfo_ip_get(swigCPtr, this);
  }

  public void setPort(int value) {
    EsunnyTradeSwigUtilJNI.EsLoginInfo_port_set(swigCPtr, this, value);
  }

  public int getPort() {
    return EsunnyTradeSwigUtilJNI.EsLoginInfo_port_get(swigCPtr, this);
  }

  public void setAuthCode(String value) {
    EsunnyTradeSwigUtilJNI.EsLoginInfo_authCode_set(swigCPtr, this, value);
  }

  public String getAuthCode() {
    return EsunnyTradeSwigUtilJNI.EsLoginInfo_authCode_get(swigCPtr, this);
  }

  public EsLoginInfo() {
    this(EsunnyTradeSwigUtilJNI.new_EsLoginInfo(), true);
  }

}