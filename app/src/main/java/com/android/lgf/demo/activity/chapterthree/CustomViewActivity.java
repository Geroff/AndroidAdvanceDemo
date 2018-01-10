package com.android.lgf.demo.activity.chapterthree;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.android.lgf.demo.R;
import com.android.lgf.demo.view.ScrollerMoveView;

/**
 * Created by lgf on 17-12-8.
 */

public class CustomViewActivity extends AppCompatActivity {
    private TextView tvInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_move_view);
        tvInfo = (TextView) findViewById(R.id.tv_info);
        tvInfo.post(new Runnable() {
            @Override
            public void run() {
                int height = tvInfo.getBottom() - tvInfo.getTop();
                int width = tvInfo.getRight() - tvInfo.getLeft();
                tvInfo.setText("height-->" + height + ", width-->" + width + "\n getHeight-->" + tvInfo.getHeight() + ", getWidth-->" + tvInfo.getWidth());
            }
        });
    }

}
