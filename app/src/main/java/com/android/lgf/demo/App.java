package com.android.lgf.demo;

import android.app.Application;

import com.android.lgf.demo.manager.AppContextManager;

/**
 * Created by lgf on 17-12-9.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppContextManager.getInstance().setContext(getApplicationContext());
    }
}
