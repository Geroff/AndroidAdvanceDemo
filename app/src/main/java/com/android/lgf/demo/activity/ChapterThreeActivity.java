package com.android.lgf.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.lgf.demo.R;
import com.android.lgf.demo.activity.chapterthree.CustomViewActivity;
import com.android.lgf.demo.activity.chapterthree.PropertyAnimationActivity;
import com.android.lgf.demo.util.ActivityUtil;

/**
 * Created by lgf on 17-12-8.
 */

public class ChapterThreeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnTestCustomMoveView;
    private Button btnTestPropertyAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_three);
        initView();
        setListener();
    }

    private void initView() {
        btnTestCustomMoveView = (Button) findViewById(R.id.btn_chapter_three_test_custom_move_view);
        btnTestPropertyAnimation = (Button) findViewById(R.id.btn_chapter_three_test_property_animation);
    }

    private void setListener() {
        btnTestCustomMoveView.setOnClickListener(this);
        btnTestPropertyAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_chapter_three_test_custom_move_view:
                ActivityUtil.startActivity(this, CustomViewActivity.class);
                break;
            case R.id.btn_chapter_three_test_property_animation:
                ActivityUtil.startActivity(this, PropertyAnimationActivity.class);
                break;
            default:
                break;
        }
    }
}
