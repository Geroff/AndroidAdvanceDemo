package com.android.lgf.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.lgf.demo.R;
import com.android.lgf.demo.util.ActivityUtil;

/**
 * Created by lgf on 17-12-6.
 */
public class ChapterTwoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTestTextInputLayout;
    private Button btnTestTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two);
        initView();
        setListener();
    }

    private void setListener() {
        btnTestTextInputLayout.setOnClickListener(this);
        btnTestTabLayout.setOnClickListener(this);
    }

    private void initView() {
        btnTestTextInputLayout = (Button) findViewById(R.id.btn_test_text_input_layout);
        btnTestTabLayout = (Button) findViewById(R.id.btn_test_tab_layout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_text_input_layout:
                ActivityUtil.startActivity(this, LoginActivity.class);
                break;
            case R.id.btn_test_tab_layout:
                ActivityUtil.startActivity(this, TabLayoutActivity.class);
                break;
            default:
                break;
        }
    }
}
