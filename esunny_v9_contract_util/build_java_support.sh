#!/bin/bash

source cpp_platform/envsetup.sh
blade build --generate-java || exit 1

rm -f  java/src/main/java/com/longsheng/xueqiao/util/esunny9/swig/*.java
cp -f  build64_release/com/longsheng/xueqiao/util/esunny9/swig/*.java java/src/main/java/com/longsheng/xueqiao/util/esunny9/swig/ || exit 1
cp -f  build64_release/libEsunnyTradeSwigUtil_java.so java/src/main/resources || exit 1
cp -f  build64_release/cpp_platform/thirdparty/esunny9/libiTapTradeAPI9.so java/src/main/resources || exit 1

echo "Finished..."