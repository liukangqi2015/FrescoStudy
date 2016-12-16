package com.liu.frescostudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.liu.frescostudy.adpter.GifListPagerAdapter;
import com.liu.frescostudy.fragment.GifListViewFragment;
import com.liu.frescostudy.fragment.GifRecyclerViewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示Gif列表的界面
 * Created by liu on 2016/12/15.
 */

public class GifListActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> titles=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_list);
        initView();
        setData();
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.gif_tablayout);
        viewPager= (ViewPager) findViewById(R.id.gif_list_view_pager);
        titles.add(getResources().getString(R.string.recycler_view));
        titles.add(getResources().getString(R.string.list_view));

//        tabLayout.addTab(tabLayout.newTab().setText(R.string.recycler_view));
//        tabLayout.addTab(tabLayout.newTab().setText(R.string.list_view));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setData() {
        fragments.add(new GifRecyclerViewFragment());
        fragments.add(new GifListViewFragment());
        viewPager.setAdapter(new GifListPagerAdapter(getSupportFragmentManager(),fragments,titles));
        tabLayout.setupWithViewPager(viewPager);
    }
}
