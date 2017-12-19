package com.android.lgf.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.lgf.demo.activity.ChapterFiveActivity;
import com.android.lgf.demo.activity.ChapterOneActivity;
import com.android.lgf.demo.activity.ChapterThreeActivity;
import com.android.lgf.demo.activity.ChapterTwoActivity;
import com.android.lgf.demo.activity.GotoSettingActivity;
import com.android.lgf.demo.activity.TestActivity;
import com.android.lgf.demo.util.ActivityUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGotoTest;
    private Button btnTestGotoSetting;
    private Button btnGotoChapterOne;
    private Button btnGotoChapterTwo;
    private Button btnGotoChapterThree;
    private Button btnGotoChapterFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void initView() {
        btnGotoTest = (Button) findViewById(R.id.btn_go_to_test);
        btnTestGotoSetting = (Button) findViewById(R.id.btn_go_to_setting);
        btnGotoChapterOne = (Button) findViewById(R.id.btn_go_to_chapter_one);
        btnGotoChapterTwo = (Button) findViewById(R.id.btn_go_to_chapter_two);
        btnGotoChapterThree = (Button) findViewById(R.id.btn_go_to_chapter_three);
        btnGotoChapterFive = (Button) findViewById(R.id.btn_go_to_chapter_five);
    }

    private void setListener() {
        btnGotoTest.setOnClickListener(this);
        btnTestGotoSetting.setOnClickListener(this);
        btnGotoChapterOne.setOnClickListener(this);
        btnGotoChapterTwo.setOnClickListener(this);
        btnGotoChapterThree.setOnClickListener(this);
        btnGotoChapterFive.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_go_to_test:
                ActivityUtil.startActivity(this, TestActivity.class);
                break;
            case R.id.btn_go_to_setting:
                ActivityUtil.startActivity(this, GotoSettingActivity.class);
                break;
            case R.id.btn_go_to_chapter_one:
                ActivityUtil.startActivity(this, ChapterOneActivity.class);
                break;
            case R.id.btn_go_to_chapter_two:
                ActivityUtil.startActivity(this, ChapterTwoActivity.class);
                break;
            case R.id.btn_go_to_chapter_three:
                ActivityUtil.startActivity(this, ChapterThreeActivity.class);
                break;
            case R.id.btn_go_to_chapter_five:
                ActivityUtil.startActivity(this, ChapterFiveActivity.class);
                break;
            default:
                break;
        }
    }
}
