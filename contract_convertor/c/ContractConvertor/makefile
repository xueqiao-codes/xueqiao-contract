CC = gcc  
LD	:= ld

CFLAGS = -c -std=c99 -fpic 
LDFLAGS	:= -shared -fpic 

DIR_OBJ	:= ./obj
DIR_LIB	:= ./lib

LIB_NAME	:= libContractConvertor

SHARE_LIB	:= $(LIB_NAME).so

OBJS = ${DIR_OBJ}/ContractConvertor_wrap.o ${DIR_OBJ}/ContractConvertor.o   \
        ${DIR_OBJ}/CtpContractConvertor.o ${DIR_OBJ}/CtpUtil.o  \
        ${DIR_OBJ}/EsunnyV9ContractConvertor.o  \
        ${DIR_OBJ}/EsunnyV3ContractConvertor.o ${DIR_OBJ}/EsunnyV3Util.o  \
        ${DIR_OBJ}/Util.o
  
Lib:$(OBJS)  
	$(LD) $(LDFLAGS) -o $(DIR_LIB)/$(SHARE_LIB) $(OBJS)  

    ${DIR_OBJ}/ContractConvertor_wrap.o:ContractConvertor_wrap.c
	$(CC) $(CFLAGS) -o ${DIR_OBJ}/ContractConvertor_wrap.o ContractConvertor_wrap.c -I/usr/java/default/include -I/usr/java/default/include/linux

    ${DIR_OBJ}/ContractConvertor.o:ContractConvertor.c
	$(CC) $(CFLAGS) -o ${DIR_OBJ}/ContractConvertor.o ContractConvertor.c

    ${DIR_OBJ}/CtpContractConvertor.o:CtpContractConvertor.c
	$(CC) $(CFLAGS) -o ${DIR_OBJ}/CtpContractConvertor.o CtpContractConvertor.c

    ${DIR_OBJ}/CtpUtil.o:CtpUtil.c
	$(CC) $(CFLAGS) -o ${DIR_OBJ}/CtpUtil.o CtpUtil.c  

    ${DIR_OBJ}/EsunnyV9ContractConvertor.o:EsunnyV9ContractConvertor.c
	$(CC) $(CFLAGS) -o ${DIR_OBJ}/EsunnyV9ContractConvertor.o EsunnyV9ContractConvertor.c  

    ${DIR_OBJ}/EsunnyV3ContractConvertor.o:EsunnyV3ContractConvertor.c
	$(CC) $(CFLAGS) -o ${DIR_OBJ}/EsunnyV3ContractConvertor.o EsunnyV3ContractConvertor.c  
    
    ${DIR_OBJ}/EsunnyV3Util.o:EsunnyV3Util.c
	$(CC) $(CFLAGS) -o ${DIR_OBJ}/EsunnyV3Util.o EsunnyV3Util.c  
    
${DIR_OBJ}/Util.o:Util.c
	$(CC) $(CFLAGS) -o ${DIR_OBJ}/Util.o Util.c  

.PHONY:clean  
clean:  
	rm -rf ${DIR_OBJ}/*.o  $(DIR_LIB)/$(SHARE_LIB)
	@echo "Clean done!"
