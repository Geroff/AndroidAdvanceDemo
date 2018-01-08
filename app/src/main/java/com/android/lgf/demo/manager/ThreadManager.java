package com.android.lgf.demo.manager;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.SparseArray;

import com.android.lgf.demo.conf.Constant;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by lgf on 17-12-19.
 */

public class ThreadManager {
    private static volatile ThreadManager instance = null;
    private SparseArray<HandlerThread> handlerThreadSparseArray;
    private SparseArray<Handler> handlerSparseArray;
    private Set<Integer> handlerIndexSet;

    public static ThreadManager getInstance() {
        if (instance == null) {
            synchronized (ThreadManager.class) {
                if (instance == null) {
                    instance = new ThreadManager();
                }
            }
        }
        return instance;
    }

    private ThreadManager() {
    }

    public Handler getOrCreateDefaultThread() {
        Handler handler = getHandler(Constant.THREAD_DEFAULT);
        if (handler == null) {
            handler = createHandler(Constant.THREAD_DEFAULT);
        }
        return handler;
    }

    public Handler getOrCreateBackgroundThread() {
        Handler handler = getHandler(Constant.THREAD_BACKGROUND);
        if (handler == null) {
            handler = createHandler(Constant.THREAD_BACKGROUND);
        }
        return handler;
    }

    public Handler getOrCreateForegroundThread() {
        Handler handler = getHandler(Constant.THREAD_FOREGROUND);
        if (handler == null) {
            handler = createHandler(Constant.THREAD_FOREGROUND);
        }
        return handler;
    }

    public Handler getOrCreateNetworkThread() {
        Handler handler = getHandler(Constant.THREAD_NETWORK);
        if (handler == null) {
            handler = createHandler(Constant.THREAD_NETWORK);
        }
        return handler;
    }

    private Handler getHandler(int handlerIndex) {
        if (handlerSparseArray == null) {
            return null;
        }

        return handlerSparseArray.get(handlerIndex);
    }

    private Handler createHandler(int handlerIndex) {
        if (handlerThreadSparseArray == null) {
            handlerThreadSparseArray = new SparseArray<HandlerThread>();
        }

        if (handlerSparseArray == null) {
            handlerSparseArray = new SparseArray<Handler>();
        }

        if (handlerIndexSet == null) {
            handlerIndexSet = new HashSet<>();
        }

        Handler handler = handlerSparseArray.get(handlerIndex);
        if (handler == null) {
            handlerIndexSet.add(handlerIndex);
            HandlerThread handlerThread = new HandlerThread(Constant.THREAD_NAME + handlerIndex, Process.THREAD_PRIORITY_BACKGROUND);
            handlerThread.setDaemon(true);
            handlerThread.start();
            handlerThreadSparseArray.put(handlerIndex, handlerThread);
            handler = new Handler(handlerThread.getLooper());
            handlerSparseArray.put(handlerIndex, handler);
        }

        return handler;
    }

    public void release() {
        if (handlerIndexSet != null && !handlerIndexSet.isEmpty()) {
            Iterator<Integer> iterator = handlerIndexSet.iterator();
            while (iterator.hasNext()) {
                Integer handlerIndex = iterator.next();
                if (handlerSparseArray != null) {
                    Handler handler = handlerSparseArray.get(handlerIndex);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    handlerSparseArray.remove(handlerIndex);
                }

                if (handlerThreadSparseArray != null) {
                    HandlerThread handlerThread = handlerThreadSparseArray.get(handlerIndex);
                    if (handlerThread != null) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                            handlerThread.quitSafely();
                        } else {
                            handlerThread.quit();
                        }
                    }
                    handlerThreadSparseArray.remove(handlerIndex);
                }
            }
        }

        handlerSparseArray = null;
        handlerThreadSparseArray = null;
        handlerIndexSet = null;
        instance = null;
    }
}
