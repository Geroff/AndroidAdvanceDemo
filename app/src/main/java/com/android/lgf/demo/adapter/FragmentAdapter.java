package com.android.lgf.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by lgf on 17-12-6.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> titleList;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        if (this.fragmentList == null) {
            return null;
        }

        return this.fragmentList.get(position);
    }

    @Override
    public int getCount() {
        if (this.fragmentList == null) {
            return 0;
        }

        return this.fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (this.titleList == null) {
            return super.getPageTitle(position);
        }

        return titleList.get(position);
    }
}
