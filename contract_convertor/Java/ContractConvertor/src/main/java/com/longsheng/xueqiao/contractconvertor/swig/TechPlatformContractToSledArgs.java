/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.longsheng.xueqiao.contractconvertor.swig;

public class TechPlatformContractToSledArgs {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected TechPlatformContractToSledArgs(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(TechPlatformContractToSledArgs obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ContractConvertorJNI.delete_TechPlatformContractToSledArgs(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTechPlatform_(TechPlatform value) {
    ContractConvertorJNI.TechPlatformContractToSledArgs_TechPlatform__set(swigCPtr, this, value.swigValue());
  }

  public TechPlatform getTechPlatform_() {
    return TechPlatform.swigToEnum(ContractConvertorJNI.TechPlatformContractToSledArgs_TechPlatform__get(swigCPtr, this));
  }

  public void setCommonContract_(CommonContract value) {
    ContractConvertorJNI.TechPlatformContractToSledArgs_CommonContract__set(swigCPtr, this, CommonContract.getCPtr(value), value);
  }

  public CommonContract getCommonContract_() {
    long cPtr = ContractConvertorJNI.TechPlatformContractToSledArgs_CommonContract__get(swigCPtr, this);
    return (cPtr == 0) ? null : new CommonContract(cPtr, false);
  }

  public void setOtherCommonContractCount_(long value) {
    ContractConvertorJNI.TechPlatformContractToSledArgs_OtherCommonContractCount__set(swigCPtr, this, value);
  }

  public long getOtherCommonContractCount_() {
    return ContractConvertorJNI.TechPlatformContractToSledArgs_OtherCommonContractCount__get(swigCPtr, this);
  }

  public void setOtherCommonContract_(CommonContract value) {
    ContractConvertorJNI.TechPlatformContractToSledArgs_OtherCommonContract__set(swigCPtr, this, CommonContract.getCPtr(value), value);
  }

  public CommonContract getOtherCommonContract_() {
    long cPtr = ContractConvertorJNI.TechPlatformContractToSledArgs_OtherCommonContract__get(swigCPtr, this);
    return (cPtr == 0) ? null : new CommonContract(cPtr, false);
  }

  public void setOtherCommonContract_(int i, CommonContract commonContract) {
    ContractConvertorJNI.TechPlatformContractToSledArgs_setOtherCommonContract_(swigCPtr, this, i, CommonContract.getCPtr(commonContract), commonContract);
  }

  public CommonContract getOtherCommonContract_(int i) {
    return new CommonContract(ContractConvertorJNI.TechPlatformContractToSledArgs_getOtherCommonContract_(swigCPtr, this, i), true);
  }

  public TechPlatformContractToSledArgs() {
    this(ContractConvertorJNI.new_TechPlatformContractToSledArgs(), true);
  }

}
