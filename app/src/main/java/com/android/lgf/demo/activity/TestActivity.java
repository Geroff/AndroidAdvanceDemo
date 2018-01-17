package com.android.lgf.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.lgf.demo.R;
import com.android.lgf.demo.activity.test.DisplayTestActivity;
import com.android.lgf.demo.activity.test.SpannableStringTestActivity;
import com.android.lgf.demo.activity.test.ThreadTestActivity;
import com.android.lgf.demo.util.ActivityUtil;

/**
 * Created by lgf on 17-12-19.
 */

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTestThread;
    private Button btnTestDisplay;
    private Button btnTestSpannable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
        setListener();
    }

    private void setListener() {
        btnTestThread.setOnClickListener(this);
        btnTestDisplay.setOnClickListener(this);
        btnTestSpannable.setOnClickListener(this);
    }

    private void initView() {
        btnTestThread = (Button) findViewById(R.id.btn_test_thread);
        btnTestDisplay = (Button) findViewById(R.id.btn_test_display);
        btnTestSpannable = (Button) findViewById(R.id.btn_test_spannable);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_thread:
                ActivityUtil.startActivity(this, ThreadTestActivity.class);
                break;
            case R.id.btn_test_display:
                ActivityUtil.startActivity(this, DisplayTestActivity.class);
                break;
            case R.id.btn_test_spannable:
                ActivityUtil.startActivity(this, SpannableStringTestActivity.class);
                break;
            default:
                break;
        }
    }
}
