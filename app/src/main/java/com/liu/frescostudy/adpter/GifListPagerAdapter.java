package com.liu.frescostudy.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 显示Gif列表的ViewPager的Adapter
 * Created by liu on 2016/12/16.
 */

public class GifListPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    private List<String> titles;

    public GifListPagerAdapter(FragmentManager fm, List<Fragment> fragments,List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
