%module(directors="1")  EsunnyTradeSwigUtil

%{

#include "util/swig/datatype.h"
#include "util/swig/esunnytrade_swig_callback.h"
#include "util/swig/esunnytrade_swig.h"

%}

%include "util/swig/datatype.h"

%feature("director", assumeoverride=1) xueqiao::util::IEsunnyTradeSwigCallback;
%include "util/swig/esunnytrade_swig_callback.h"

%include "util/swig/esunnytrade_swig.h" 

