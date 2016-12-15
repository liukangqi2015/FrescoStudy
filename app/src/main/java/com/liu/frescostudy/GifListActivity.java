package com.liu.frescostudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liu.frescostudy.adpter.GifListAdapter;
import com.liu.frescostudy.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示Gif列表的界面
 * Created by liu on 2016/12/15.
 */

public class GifListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> urlList=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_list);
        initView();
        setData();
    }

    private void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setData() {
        int length=Constant.Url.GIF_ARRAY.length;
        for (int i = 0; i < length; i++) {
            urlList.add(Constant.Url.GIF_ARRAY[i]);
        }
        recyclerView.setAdapter(new GifListAdapter(urlList));
    }
}
