package com.android.lgf.demo.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.android.lgf.demo.R;
import com.android.lgf.demo.adapter.DividerItemDecoration;
import com.android.lgf.demo.adapter.HomeAdapter;
import com.android.lgf.demo.conf.Constant;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HomeAdapter adapter;

    private List<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        int recyclerViewType =Constant.TYPE_VERTICAL_RECYCLER_VIEW;
        Intent intent = getIntent();
        if (intent != null) {
            recyclerViewType = intent.getIntExtra(Constant.BUNDLE_KEY_RECYCLER_VIEW_TYPE, Constant.TYPE_VERTICAL_RECYCLER_VIEW);
        }

        // 设置增加删除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new HomeAdapter(nameList);
        if (recyclerViewType == Constant.TYPE_HORIZONTAL_RECYCLER_VIEW) {
            setHorizontalLayout();
        } else if (recyclerViewType == Constant.TYPE_GRID_RECYCLER_VIEW) {
            setGridLayout();
        } else if (recyclerViewType == Constant.TYPE_STAGGERED_RECYCLER_VIEW) {
            setStaggeredLayout();
        } else {
            setVerticalLayout();
        }

        // 实现点击效果
        adapter.setOnItemClick(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "点击第" + (position + 1) + "条", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RecyclerViewActivity.this);
                builder.setTitle("提示!");
                builder.setMessage("确定要删除吗?");
                builder.setNegativeButton("NO", null);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.remove(position);
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void setHorizontalLayout() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // 默认是垂直列表
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        // 实现自定义分割线
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this); // 默认是水平方向直线
        itemDecoration.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    private void setVerticalLayout() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // 默认是垂直列表
        recyclerView.setLayoutManager(layoutManager);
        // 实现自定义分割线
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this); // 默认是水平方向直线
        recyclerView.addItemDecoration(itemDecoration);
    }

    private void setGridLayout() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setStaggeredLayout() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        if (nameList != null) {
            int size = nameList.size();
            if (size > 0) {
                List<Integer> heightList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    heightList.add((int)(100 + Math.random() * 300));
                }
                adapter.setHeightList(heightList);
            }
        }
    }

    private void initData() {
        nameList = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            nameList.add("name" + i);
        }
    }
}
