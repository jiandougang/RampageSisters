package com.jiandougang.rampagesisters;

/**
 * Created by wuguohong on 2017/5/14.
 */

public class JNIUtils {

    public static native String sayName();


    /**
     * 加载so库或jni库
     */
    static {
        System.loadLibrary("JNI_ANDROID");
    }
}
