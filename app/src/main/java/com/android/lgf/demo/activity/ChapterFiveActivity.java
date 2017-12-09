package com.android.lgf.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.android.lgf.demo.R;
import com.android.lgf.demo.activity.chapterfive.VolleyActivity;
import com.android.lgf.demo.util.ActivityUtil;

/**
 * Created by lgf on 17-12-9.
 */

public class ChapterFiveActivity extends Activity implements View.OnClickListener {
    private Button btnTestVolley;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_five);
        btnTestVolley = findViewById(R.id.btn_test_volley);
        btnTestVolley.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_volley:
                ActivityUtil.startActivity(this, VolleyActivity.class);
                break;
            default:
                break;
        }
    }
}
