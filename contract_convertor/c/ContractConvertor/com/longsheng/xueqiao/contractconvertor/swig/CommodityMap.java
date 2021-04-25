/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.longsheng.xueqiao.contractconvertor.swig;

public class CommodityMap {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CommodityMap(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CommodityMap obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ContractConvertorJNI.delete_CommodityMap(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTechPlatform_(TechPlatform value) {
    ContractConvertorJNI.CommodityMap_TechPlatform__set(swigCPtr, this, value.swigValue());
  }

  public TechPlatform getTechPlatform_() {
    return TechPlatform.swigToEnum(ContractConvertorJNI.CommodityMap_TechPlatform__get(swigCPtr, this));
  }

  public void setExchangeMic_(String value) {
    ContractConvertorJNI.CommodityMap_ExchangeMic__set(swigCPtr, this, value);
  }

  public String getExchangeMic_() {
    return ContractConvertorJNI.CommodityMap_ExchangeMic__get(swigCPtr, this);
  }

  public void setSledCommodityType_(SledCommodityType value) {
    ContractConvertorJNI.CommodityMap_SledCommodityType__set(swigCPtr, this, value.swigValue());
  }

  public SledCommodityType getSledCommodityType_() {
    return SledCommodityType.swigToEnum(ContractConvertorJNI.CommodityMap_SledCommodityType__get(swigCPtr, this));
  }

  public void setSledCommodityCode_(String value) {
    ContractConvertorJNI.CommodityMap_SledCommodityCode__set(swigCPtr, this, value);
  }

  public String getSledCommodityCode_() {
    return ContractConvertorJNI.CommodityMap_SledCommodityCode__get(swigCPtr, this);
  }

  public void setTechPlatform_Exchange_(String value) {
    ContractConvertorJNI.CommodityMap_TechPlatform_Exchange__set(swigCPtr, this, value);
  }

  public String getTechPlatform_Exchange_() {
    return ContractConvertorJNI.CommodityMap_TechPlatform_Exchange__get(swigCPtr, this);
  }

  public void setTechPlatform_CommodityType_(String value) {
    ContractConvertorJNI.CommodityMap_TechPlatform_CommodityType__set(swigCPtr, this, value);
  }

  public String getTechPlatform_CommodityType_() {
    return ContractConvertorJNI.CommodityMap_TechPlatform_CommodityType__get(swigCPtr, this);
  }

  public void setTechPlatform_CommodityCode_(String value) {
    ContractConvertorJNI.CommodityMap_TechPlatform_CommodityCode__set(swigCPtr, this, value);
  }

  public String getTechPlatform_CommodityCode_() {
    return ContractConvertorJNI.CommodityMap_TechPlatform_CommodityCode__get(swigCPtr, this);
  }

  public CommodityMap() {
    this(ContractConvertorJNI.new_CommodityMap(), true);
  }

}