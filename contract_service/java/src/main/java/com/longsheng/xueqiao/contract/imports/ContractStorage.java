package com.longsheng.xueqiao.contract.imports;

import org.soldier.platform.file_storage.FileStorage;
import org.soldier.platform.file_storage.FileStorageFactory;

import java.util.UUID;

public class ContractStorage {

    private final static String CONTRACT_STORAGE_KEY = "contract";

    private static FileStorage sInstance;

    public static FileStorage getStorage() {
        if (sInstance == null) {
            synchronized(ContractStorage.class) {
                if (sInstance == null) {
                    sInstance = FileStorageFactory.getInstance().getFileStorage(CONTRACT_STORAGE_KEY);
                    sInstance.setTimeout(60000);
                }
            }
        }
        return sInstance;
    }

    public static String generateFilePath(int brokerId) {
        StringBuilder filePathBuilder = new StringBuilder(128);

        filePathBuilder.append(brokerId);
        filePathBuilder.append("/");
        filePathBuilder.append(UUID.randomUUID().toString().replace("-",""));
        filePathBuilder.append(".csv");

        return filePathBuilder.toString();
    }
}
