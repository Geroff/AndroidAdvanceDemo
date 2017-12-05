package com.android.lgf.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.lgf.demo.BuildConfig;
import com.android.lgf.demo.R;
import com.android.lgf.demo.util.LogUtil;

/**
 * Created by lgf on 17-12-5.
 */

public class MultiWindowModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_window);
        if (BuildConfig.DEBUG) {
            LogUtil.debug("MultiWindowModeActivity.onCreate() ## ");
        }

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MultiWindowModeActivity.this, "已获得焦点", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (BuildConfig.DEBUG) {
            LogUtil.debug("MultiWindowModeActivity.onRestart() ## ");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (BuildConfig.DEBUG) {
            LogUtil.debug("MultiWindowModeActivity.onStart() ## ");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG) {
            LogUtil.debug("MultiWindowModeActivity.onResume() ## ");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (BuildConfig.DEBUG) {
            LogUtil.debug("MultiWindowModeActivity.onPause() ## ");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (BuildConfig.DEBUG) {
            LogUtil.debug("MultiWindowModeActivity.onStop() ## ");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG) {
            LogUtil.debug("MultiWindowModeActivity.onDestroy() ## ");
        }
    }
}
