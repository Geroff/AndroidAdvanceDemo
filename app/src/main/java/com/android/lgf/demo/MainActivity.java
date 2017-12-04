package com.android.lgf.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.lgf.demo.activity.CardViewActivity;
import com.android.lgf.demo.activity.NotificationActivity;
import com.android.lgf.demo.activity.RecyclerViewActivity;
import com.android.lgf.demo.conf.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTestHorizontalRecyclerView;
    private Button btnTestVerticalRecyclerView;
    private Button btnTestGridRecyclerView;
    private Button btnTestStaggeredRecyclerView;
    private Button btnTestCardView;
    private Button btnTestNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    private void setListener() {
        btnTestHorizontalRecyclerView.setOnClickListener(this);
        btnTestVerticalRecyclerView.setOnClickListener(this);
        btnTestGridRecyclerView.setOnClickListener(this);
        btnTestStaggeredRecyclerView.setOnClickListener(this);
        btnTestCardView.setOnClickListener(this);
        btnTestNotification.setOnClickListener(this);
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
                startActivity(CardViewActivity.class);
                break;
            case R.id.btn_test_notification:
                startActivity(NotificationActivity.class);
                break;
            default:
                break;
        }
    }

    private void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    private void startRecyclerView(int type) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        intent.putExtra(Constant.BUNDLE_KEY_RECYCLER_VIEW_TYPE, type);
        startActivity(intent);
    }
}
