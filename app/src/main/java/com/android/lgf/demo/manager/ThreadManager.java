package com.sharedream.lib.manager;

import android.os.Process;
import android.support.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by linyiteng on 2016/6/14.
 */
public class ThreadManager {
    private static ThreadManager instance;
    private ExecutorService executorService;

    private ThreadManager() {
        executorService = Executors.newCachedThreadPool(new PriorityThreadFactory());
    }

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

    public void execute(Runnable runnable) {
        executorService.execute(runnable);
    }

    private class PriorityThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(@NonNull Runnable r) {
            Thread thread = new Thread(r);
            thread.setPriority(Process.THREAD_PRIORITY_BACKGROUND);
            return thread;
        }
    }
}
