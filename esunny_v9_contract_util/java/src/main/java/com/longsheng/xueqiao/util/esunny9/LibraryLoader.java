package com.longsheng.xueqiao.util.esunny9;

/**
 * Created by Jason on 2018/7/19.
 */
import com.longsheng.xueqiao.util.esunny9.util.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LibraryLoader {
    private static boolean isInited = false;

    public static void init() {
        if (!isInited) {
            synchronized(LibraryLoader.class) {
                if (!isInited) {
                    try {
                        loadLibEsunny9();
                        loadLibJni();
                        isInited = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        Runtime.getRuntime().exit(1);
                    }
                }
            }
        }
    }

    private static void loadLibJni() throws IOException
    {
        String path = System.getProperty("java.io.tmpdir");

        String libFullName = "EsunnyTradeSwigUtil.dll";
        if(!OSInfo.isWindows())
            libFullName = "libEsunnyTradeSwigUtil_java.so";

        InputStream in = null;
        BufferedInputStream reader = null;
        FileOutputStream writer = null;

        File extractedLibFile;
        if(OSInfo.isWindows())
            extractedLibFile = File.createTempFile("EsunnyTradeSwigUtil",".dll");
        else
            extractedLibFile = File.createTempFile("libEsunnyTradeSwigUtil_java",".so");

        try {
            in = LibraryLoader.class.getResourceAsStream("/" + libFullName);
            reader = new BufferedInputStream(in);
            writer = new FileOutputStream(extractedLibFile);
            byte[] buffer = new byte[1024];
            while (reader.read(buffer) > 0){
                writer.write(buffer);
                buffer = new byte[1024];
            }
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(in!=null)
                in.close();
            if(writer!=null)
                writer.close();
        }
        System.out.println("loading " + extractedLibFile.toString());
        System.load(extractedLibFile.toString());
        if (extractedLibFile.exists()) {
            extractedLibFile.deleteOnExit();
        }
    }

    private static void loadLibEsunny9() throws IOException
    {
        String path = System.getProperty("java.io.tmpdir");
        String currentPath = System.getProperty("user.dir");

        String libFullName = "iTapTradeAPI9.dll";
        if(!OSInfo.isWindows())
            libFullName = "libiTapTradeAPI9.so";

        InputStream in = null;
        BufferedInputStream reader = null;
        FileOutputStream writer = null;

        File extractedLibFile;
        if(OSInfo.isWindows()) {
            String extractedLibFilePath = currentPath + "/build64_release/cpp_platform/thirdparty/esunny9/iTapTradeAPI9.dll";
            extractedLibFile = new File(extractedLibFilePath);
        }
        else {
            String extractedLibFilePath = currentPath + "/build64_release/cpp_platform/thirdparty/esunny9/libiTapTradeAPI9.so";
            extractedLibFile = new File(extractedLibFilePath);
        }

        try {
            //判断目标文件所在的目录是否存在
            if(!extractedLibFile.getParentFile().exists())
                extractedLibFile.getParentFile().mkdirs();
            extractedLibFile.createNewFile();

            in = LibraryLoader.class.getResourceAsStream("/" + libFullName);
            reader = new BufferedInputStream(in);
            writer = new FileOutputStream(extractedLibFile);
            byte[] buffer = new byte[1024];
            while (reader.read(buffer) > 0){
                writer.write(buffer);
                buffer = new byte[1024];
            }
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(in!=null)
                in.close();
            if(writer!=null)
                writer.close();
        }
        System.out.println("loading " + extractedLibFile.toString());
        System.load(extractedLibFile.toString());
        if (extractedLibFile.exists()) {
            extractedLibFile.deleteOnExit();
        }
    }
}
