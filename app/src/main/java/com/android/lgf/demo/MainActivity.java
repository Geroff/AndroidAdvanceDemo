package com.android.lgf.demo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.lgf.demo.adapter.DividerItemDecoration;
import com.android.lgf.demo.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HomeAdapter adapter;

    private List<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // 默认是垂直列表
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        // 实现自定义分割线
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this); // 默认是水平方向直线
//        itemDecoration.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        initData();
        adapter = new HomeAdapter(nameList);
        // 实现点击效果
        adapter.setOnItemClick(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "点击第" + (position + 1) + "条", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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

    private void initData() {
        nameList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            nameList.add("name" + i);
        }
    }
}
