package com.longsheng.xueqiao.contract.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.Md5;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.file_storage.FileStorage;
import org.soldier.platform.file_storage.FileStorageFactory;
import org.soldier.platform.oss.api.HttpOption;
import org.soldier.platform.oss.api.OssFailedException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.aliyun.oss.model.CannedAccessControlList;
import com.longsheng.xueqiao.contract.online.dao.thriftapi.client.ContractOnlineDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.ContractVersion;
import com.longsheng.xueqiao.contract.thriftapi.ContractVersionPage;
import com.longsheng.xueqiao.contract.thriftapi.ReqContractVersionOption;

public class VersionDumper {

    private static final String OSS_STORAGE_KEY = "contract";
    private static final String LOCK_DB_USER = "online_version_dumper";
    private volatile ContractSyncConfig mCurrentConfig = null;

    private FileStorage mFileStorage;

    public VersionDumper() throws Exception {
        mCurrentConfig = ContractSyncConfig.readConfig();
        if (mCurrentConfig == null) {
            throw new Exception("read qconf failed!");
        }

        mFileStorage = FileStorageFactory.getInstance().getFileStorage(OSS_STORAGE_KEY);
        mFileStorage.setTimeout(60);
    }

    public void runOnce() throws Exception {
        ContractVersion latestVersion = getLastestVersion();
        if (latestVersion == null) {
            AppLog.i("no latest version, maybe database has no data!");
            return;
        }
        if (!StringUtils.isEmpty(latestVersion.getFilePath())
                && !StringUtils.isEmpty(latestVersion.getFileMD5())) {
            AppLog.i("latestVersion=" + latestVersion + " is updated!");
            return;
        }

        if (!lockDb()) {
            AppLog.e("lock online db fail.");
            return;
        }

        File sqlFile = prepareSqlFile(latestVersion);
        try {
            dumpSql(sqlFile);
            checkSql(sqlFile);
            String sqlMd5 = Md5.toMD5(sqlFile);
            if (sqlMd5 == null) {
                throw new Exception("calculateMd5 failed! java has some error?");
            }

            String ossFilePath = uploadSql(sqlFile);
            checkOssFile(sqlMd5, ossFilePath);
            updateToVersion(latestVersion.getVersionId(), sqlMd5, ossFilePath);
        } finally {
            sqlFile.delete();
        }
        unlocakDb();
    }

    private void unlocakDb() throws TException {
        ContractOnlineDaoServiceStub stub = new ContractOnlineDaoServiceStub();
        DbLockingInfo existLockingInfo = stub.reqDbLockingInfo();
        if (existLockingInfo.isIsLocked()) {
            if (LOCK_DB_USER.equals(existLockingInfo.getLockedBy())) {
                stub.removeDbLocking(LOCK_DB_USER);
            }
        }
    }

    private boolean lockDb() throws TException {
        ContractOnlineDaoServiceStub stub = new ContractOnlineDaoServiceStub();
        DbLockingInfo existLockingInfo = stub.reqDbLockingInfo();
        if (existLockingInfo.isIsLocked()) {
            if (LOCK_DB_USER.equals(existLockingInfo.getLockedBy())) {
                return true;
            } else {
                return false;
            }
        }
        DbLockingInfo newLockingInfo = new DbLockingInfo();
        newLockingInfo.setLockedBy(LOCK_DB_USER);
        newLockingInfo.setLockArea("all");
        stub.addDbLocking(newLockingInfo);
        return true;
    }

    private ContractVersion getLastestVersion() throws ErrorInfo, TException {
        ReqContractVersionOption option = new ReqContractVersionOption();
        option.setLatest(true);

        ContractOnlineDaoServiceStub stub = new ContractOnlineDaoServiceStub();
        ContractVersionPage resultPage = stub.reqContractVersion(RandomUtils.nextInt(), 3000, option, 0, 10);
        if (resultPage.getPageSize() <= 0) {
            return null;
        }
        return resultPage.getPage().get(0);
    }

    private File prepareSqlFile(ContractVersion lastestVersion) throws Exception {
        return File.createTempFile("/contract_online_" + lastestVersion.getVersionId() + "_", ".sql");
    }

    private void checkSql(File sqlFile) throws Exception {
        String lastLine = readLastLine(sqlFile, "UTF-8");
        if (StringUtils.isEmpty(lastLine) ||
                !lastLine.startsWith("-- Dump completed on")) {
            throw new Exception("dumpSql error! not complated with mysqldump content! sqlFile="
                    + sqlFile.getAbsolutePath());
        }
    }

    private void checkOssFile(String sqlMd5, String ossFilePath) throws Exception {
        int retryCount = 0;
        boolean checkSuccess = false;
        while ((retryCount++) < 3) {
            try {
                downloadAndCheck(sqlMd5, ossFilePath);
                checkSuccess = true;
                break;
            } catch (Throwable e) {
                AppLog.e(e.getMessage(), e);
            }
        }

        if (!checkSuccess) {
            throw new Exception("check oss file failed!");
        }
    }

    private void updateToVersion(int versionId, String sqlMd5, String ossFilePath) throws ErrorInfo, TException {
        ContractOnlineDaoServiceStub stub = new ContractOnlineDaoServiceStub();

        ContractVersion updateVersion = new ContractVersion();
        updateVersion.setVersionId(versionId);
        updateVersion.setFileMD5(sqlMd5);
        updateVersion.setFilePath(ossFilePath);

        stub.updateContractVersion(RandomUtils.nextInt(), 3000, updateVersion);
    }

    private String uploadSql(File sqlFile) throws OssFailedException, IOException {
        StringBuilder ossFilePathBuilder = new StringBuilder();
        ossFilePathBuilder.append("sql/").append(sqlFile.getName());

        HttpOption option = new HttpOption();
        option.setAcl(CannedAccessControlList.Private);

        byte[] sqlFileContent = readSqlFile(sqlFile);
        AliyunOssStorageHolder.get().writeFile(OSS_STORAGE_KEY
                , ossFilePathBuilder.toString(), sqlFileContent, option);

        return ossFilePathBuilder.toString();
    }

    private void downloadAndCheck(String sqlMd5, String ossFilePath) throws Exception {
        byte[] content = AliyunOssStorageHolder.get().readFile(OSS_STORAGE_KEY, ossFilePath);
        if (content == null) {
            throw new Exception("file is not existed in oss");
        }

        if (!sqlMd5.equalsIgnoreCase(Md5.toMd5(content))) {
            throw new Exception("md5 content is not equals to read content");
        }
    }

    public static byte[] readSqlFile(File file) throws IOException {
        FileInputStream stream = new FileInputStream(file);
        try {
            return IOUtils.toByteArray(stream);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    public static String readLastLine(File file, String charset) throws IOException {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "r");
            long len = raf.length();
            if (len == 0L) {
                return "";
            } else {
                long pos = len - 1;
                while (pos > 0) {
                    pos--;
                    raf.seek(pos);
                    if (raf.readByte() == '\n') {
                        break;
                    }
                }
                if (pos == 0) {
                    raf.seek(0);
                }
                byte[] bytes = new byte[(int) (len - pos)];
                raf.read(bytes);
                if (charset == null) {
                    return new String(bytes);
                } else {
                    return new String(bytes, charset);
                }
            }
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (Exception e2) {
                }
            }
        }
    }

    private void dumpSql(File sqlFile) throws Exception {
        ContractSyncConfig syncConfig = mCurrentConfig;

        List<String> cmdList = new ArrayList<String>();
        cmdList.add("mysqldump");
        cmdList.add("-u" + syncConfig.getUserName());
        cmdList.add("-p" + syncConfig.getUserPasswd());
        cmdList.add("--single-transaction");
        cmdList.add("-h");
        cmdList.add(syncConfig.getHost());
        cmdList.add(syncConfig.getDbName());

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(cmdList);
        processBuilder.redirectOutput(sqlFile);
        processBuilder.redirectError(sqlFile);

        Process subProcess = processBuilder.start();
        int ret = subProcess.waitFor();
        if (ret != 0) {
            throw new Exception("mysqldump failed, ret=" + ret + ", output is " + sqlFile.getAbsolutePath());
        } else {
            AppLog.i("dump sql to " + sqlFile.getAbsolutePath());
        }
    }
}
