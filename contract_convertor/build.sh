#!/bin/sh

cd c/ContractConvertor

swig -java -package com.longsheng.xueqiao.contractconvertor.swig -outdir com/longsheng/xueqiao/contractconvertor/swig ContractConvertor.i
echo "swig finish"

make
echo "make finish"

cp com/longsheng/xueqiao/contractconvertor/swig/*.java ../../../ContractConvertor/Java/ContractConvertor/src/main/java/com/longsheng/xueqiao/contractconvertor/swig/
echo "copy swig java file to java project finish"

cp lib/libContractConvertor.so ../../../ContractConvertor/Java/ContractConvertor/src/main/resources/
echo "copy so to java project finish"
