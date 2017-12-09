package com.android.lgf.demo.activity.chaptertwo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.lgf.demo.R;
import com.android.lgf.demo.adapter.FragmentAdapter;
import com.android.lgf.demo.conf.Constant;
import com.android.lgf.demo.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgf on 17-12-6.
 */

public class TabLayoutActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        initView();
        initData();
    }

    private void initData() {
        List<String> titleList = new ArrayList<>();
        titleList.add("精选");
        titleList.add("体育");
        titleList.add("图文");
        titleList.add("购物");
        titleList.add("明星");
        titleList.add("搞笑");
        titleList.add("动漫");
        titleList.add("健康");
        int size = titleList.size();
        for (int i = 0; i < size; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(i)));
        }
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String title = titleList.get(i);
            Bundle bundle = new Bundle();
            bundle.putString(Constant.BUNDLE_KEY_FRAGMENT_ARGUMENT_TITLE_KEY, title);
            ListFragment listFragment = new ListFragment();
            listFragment.setArguments(bundle);
            fragmentList.add(listFragment);
        }

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList, titleList);
        // 1.给ViewPager设置适配器
        viewPager.setAdapter(fragmentAdapter);
        // 2.将TabLayout和ViewPager关联起来
        tabLayout.setupWithViewPager(viewPager, false);
        // 3.设置标签是否可以滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.tab_layout_view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tab_layout_toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("TabLayout体验");
        }
    }
}
