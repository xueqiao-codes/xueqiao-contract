
%module  ContractConvertor

%ignore RelateSledContract; 
%ignore RelateCommodityMap; 
%ignore RelateMixContract; 
%ignore OtherCommonContract;
%ignore _TwoLegsCommonContractCode;
%ignore _TwoLegsCommonCommodityCode;

%{

#include "DataType.h"
#include "DataStruct.h"
#include "ContractConvertor.h"

%}

%include "arrays_java.i";
%include "DataType.h"  
%include "DataStruct.h" 
%include "ContractConvertor.h" 

%extend _SledContract {
  void setRelateSledContract_(int i, SledBaseContract sledBaseContract) {
    $self->RelateSledContract_[i] = sledBaseContract;
  }
  SledBaseContract getRelateSledContract_(int i){
	return $self->RelateSledContract_[i];
  }
}

%extend _SledContractToTechPlatformArgs {
  void setRelateCommodityMap_(int i, CommodityMap commodityMap) {
    $self->RelateCommodityMap_[i] = commodityMap;
  }
  CommodityMap getRelateCommodityMap_(int i) {
	return $self->RelateCommodityMap_[i];
  }
}

%extend _SledContractToTechPlatformResult {
  CommonContract getOtherCommonContract_(int i) {
    return $self->OtherCommonContract_[i];
  }
}

%extend _TechPlatformContractToSledArgs {
   void setOtherCommonContract_(int i, CommonContract commonContract) {
    $self->OtherCommonContract_[i] = commonContract;
  }
  CommonContract getOtherCommonContract_(int i) {
	return $self->OtherCommonContract_[i];
  }
}

%extend _TechPlatformContractToSledResult {
  MixContract getRelateMixContract_(int i) {
    return $self->RelateMixContract_[i];
  }
}

