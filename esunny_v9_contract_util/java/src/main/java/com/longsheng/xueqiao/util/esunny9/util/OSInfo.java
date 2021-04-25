package com.longsheng.xueqiao.util.esunny9.util;

public class OSInfo {

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isLinux() {
        return OS.indexOf("linux") >= 0;
    }

    public static boolean isWindows() {
        return OS.indexOf("windows") >= 0;
    }

    public static String getWindowsLib() {
        return System.getProperty("java.io.tmpdir");
    }

    public static String getLinuxLib() {
        return System.getProperty("java.io.tmpdir");
        //return "/usr/lib/";
    }

    public static String getLibPath() {
        String path = System.getProperty("java.io.tmpdir");

        if (isLinux()) {
            path = getLinuxLib();
        } else if (isWindows()) {
            path = getWindowsLib();
        }

        return path;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.io.tmpdir"));

    }
}