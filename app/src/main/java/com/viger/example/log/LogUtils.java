package com.viger.example.log;

/**
 * Created by Administrator on 2017/7/26.
 */

public class LogUtils {

    public static String getClassName() {
        String result;
        StackTraceElement element = Thread.currentThread().getStackTrace()[2];
        result = element.getClassName();
        int index = result.lastIndexOf(".");
        result = result.substring(index + 1, result.length());
        return result;
    }

}
