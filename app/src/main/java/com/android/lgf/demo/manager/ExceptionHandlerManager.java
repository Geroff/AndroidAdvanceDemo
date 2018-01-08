package com.android.lgf.demo.manager;

import android.text.TextUtils;

import com.android.lgf.demo.BuildConfig;
import com.android.lgf.demo.util.LogUtils;

/**
 * 用于捕获及处理app异常
 */
public class ExceptionHandlerManager implements Thread.UncaughtExceptionHandler {
    private static volatile ExceptionHandlerManager instance = null;

    public static ExceptionHandlerManager getInstance() {
        if (instance == null) {
            synchronized (ExceptionHandlerManager.class) {
                if (instance == null) {
                    instance = new ExceptionHandlerManager();
                }
            }
        }
        return instance;
    }

    private ExceptionHandlerManager() {
    }

    public void init() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable exception) {
        if (BuildConfig.DEBUG) {
            String name = thread.getName();
            if (!TextUtils.isEmpty(name)) {
                LogUtils.error("ExceptionHandlerManager.uncaughtException() # thread name-->" + name + ", thread id-->" + thread.getId());
            }
        }

        if (exception != null) {
            if (BuildConfig.DEBUG) {
                StackTraceElement[] stackTraces = exception.getStackTrace();
                if (stackTraces != null) {
                    LogUtils.error("Fatal exception:\n" + exception.getMessage());
                    for (StackTraceElement stackTraceElement : stackTraces) {
                        LogUtils.error(stackTraceElement.toString());
                    }
                }

            }
        }
    }
}
