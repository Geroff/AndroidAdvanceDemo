package com.android.lgf.demo.manager;

import android.content.Context;

/**
 * Created by lgf on 17-12-9.
 */

public class AppContextManager {
    private static volatile AppContextManager instance = null;
    private Context context;
    private AppContextManager() {

    }

    public static AppContextManager getInstance() {
        if (instance == null) {
            synchronized (AppContextManager.class) {
                if (instance == null) {
                    instance = new AppContextManager();
                }
            }
        }

        return instance;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
