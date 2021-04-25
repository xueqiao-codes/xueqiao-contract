EXE_NAME:=TestContractConvertor
  
all:lib_make
	g++ -std=c++11 -I.. test.cc -L. -l ContractConvertor -o ${EXE_NAME};
 
lib_make:
	make -C ..;
	cp ../lib/libContractConvertor.so .

.PHONY:clean  
clean:
	rm -rf ${EXE_NAME}