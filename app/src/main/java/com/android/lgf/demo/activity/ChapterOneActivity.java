package com.android.lgf.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.lgf.demo.R;
import com.android.lgf.demo.conf.Constant;
import com.android.lgf.demo.util.ActivityUtil;

public class ChapterOneActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTestHorizontalRecyclerView;
    private Button btnTestVerticalRecyclerView;
    private Button btnTestGridRecyclerView;
    private Button btnTestStaggeredRecyclerView;
    private Button btnTestCardView;
    private Button btnTestNotification;
    private Button btnTestPermission;
    private Button btnTestMultiWindowMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_one);
        initView();
        setListener();
    }

    private void initView() {
        btnTestHorizontalRecyclerView = (Button) findViewById(R.id.btn_test_horizontal_recycler_view);
        btnTestVerticalRecyclerView = (Button) findViewById(R.id.btn_test_vertical_recycler_view);
        btnTestGridRecyclerView = (Button) findViewById(R.id.btn_test_grid_recycler_view);
        btnTestStaggeredRecyclerView = (Button) findViewById(R.id.btn_test_staggered_recycler_view);
        btnTestCardView = (Button) findViewById(R.id.btn_test_card_view);
        btnTestNotification = (Button) findViewById(R.id.btn_test_notification);
        btnTestPermission = (Button) findViewById(R.id.btn_test_permission);
        btnTestMultiWindowMode = (Button) findViewById(R.id.btn_test_multi_window_mode);
    }

    private void setListener() {
        btnTestHorizontalRecyclerView.setOnClickListener(this);
        btnTestVerticalRecyclerView.setOnClickListener(this);
        btnTestGridRecyclerView.setOnClickListener(this);
        btnTestStaggeredRecyclerView.setOnClickListener(this);
        btnTestCardView.setOnClickListener(this);
        btnTestNotification.setOnClickListener(this);
        btnTestPermission.setOnClickListener(this);
        btnTestMultiWindowMode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_horizontal_recycler_view:
                startRecyclerView(Constant.TYPE_HORIZONTAL_RECYCLER_VIEW);
                break;
            case R.id.btn_test_vertical_recycler_view:
                startRecyclerView(Constant.TYPE_VERTICAL_RECYCLER_VIEW);
                break;
            case R.id.btn_test_grid_recycler_view:
                startRecyclerView(Constant.TYPE_GRID_RECYCLER_VIEW);
                break;
            case R.id.btn_test_staggered_recycler_view:
                startRecyclerView(Constant.TYPE_STAGGERED_RECYCLER_VIEW);
                break;
            case R.id.btn_test_card_view:
                ActivityUtil.startActivity(this, CardViewActivity.class);
                break;
            case R.id.btn_test_notification:
                ActivityUtil.startActivity(this, NotificationActivity.class);
                break;
            case R.id.btn_test_permission:
                ActivityUtil.startActivity(this, PermissionActivity.class);
                break;
            case R.id.btn_test_multi_window_mode:
                ActivityUtil.startActivity(this, MultiWindowModeActivity.class);
            default:
                break;
        }
    }

    private void startRecyclerView(int type) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        intent.putExtra(Constant.BUNDLE_KEY_RECYCLER_VIEW_TYPE, type);
        startActivity(intent);
    }
}
