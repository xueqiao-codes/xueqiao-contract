cc_library(
    name = 'esunnytrade',
    srcs = [
        'util/api/esunnytrade.cpp',
		'util/api/SimpleEvent.cpp',
    ],
    deps = [
        '//cpp_platform/thirdparty/esunny9:iTapTradeAPI9',
    ]
)
cc_library(
    name = 'esunnytrade_swig',
    srcs = [
        'util/swig/esunnytrade_swig.cpp',
    ],
    deps = [
		':esunnytrade',
    ]
)
cc_binary(
    name = 'esunnytradetest',
    srcs = [
        'util/test/test.cpp',
		'util/test/esunnytrade_swig_callback_impl.cpp',
    ],
    deps = [
		':esunnytrade_swig',
    ]
)
swig_library(
    name = 'EsunnyTradeSwigUtil',
    srcs = [
        'util/swig/EsunnyTradeSwig.i',
    ],
    java_package = 'com.longsheng.xueqiao.util.esunny9.swig',
    java_lib_packed = True,
    deps = [
        ':esunnytrade_swig'
    ]
)


