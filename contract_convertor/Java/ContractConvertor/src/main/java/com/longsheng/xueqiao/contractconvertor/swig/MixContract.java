/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.longsheng.xueqiao.contractconvertor.swig;

public class MixContract {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected MixContract(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MixContract obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ContractConvertorJNI.delete_MixContract(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTechPlatform_Exchange_(String value) {
    ContractConvertorJNI.MixContract_TechPlatform_Exchange__set(swigCPtr, this, value);
  }

  public String getTechPlatform_Exchange_() {
    return ContractConvertorJNI.MixContract_TechPlatform_Exchange__get(swigCPtr, this);
  }

  public void setTechPlatform_CommodityType_(String value) {
    ContractConvertorJNI.MixContract_TechPlatform_CommodityType__set(swigCPtr, this, value);
  }

  public String getTechPlatform_CommodityType_() {
    return ContractConvertorJNI.MixContract_TechPlatform_CommodityType__get(swigCPtr, this);
  }

  public void setTechPlatform_CommodityCode_(String value) {
    ContractConvertorJNI.MixContract_TechPlatform_CommodityCode__set(swigCPtr, this, value);
  }

  public String getTechPlatform_CommodityCode_() {
    return ContractConvertorJNI.MixContract_TechPlatform_CommodityCode__get(swigCPtr, this);
  }

  public void setSledContractCode_(String value) {
    ContractConvertorJNI.MixContract_SledContractCode__set(swigCPtr, this, value);
  }

  public String getSledContractCode_() {
    return ContractConvertorJNI.MixContract_SledContractCode__get(swigCPtr, this);
  }

  public MixContract() {
    this(ContractConvertorJNI.new_MixContract(), true);
  }

}
