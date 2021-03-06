package com.android.lgf.demo.util;

import android.util.Log;

/**
 * Created by lgf on 17-12-4.
 */

public class LogUtil {
    public static final String TAG = "LogUtil";

    public static void verbose(String message) {
        Log.v(TAG, message);
    }

    public static void debug(String message) {
        Log.d(TAG, message);
    }

    public static void info(String message) {
        Log.i(TAG, message);
    }

    public static void warn(String message) {
        Log.w(TAG, message);
    }
}
