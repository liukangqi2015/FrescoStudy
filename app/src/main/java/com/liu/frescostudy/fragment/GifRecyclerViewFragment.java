package com.liu.frescostudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liu.frescostudy.R;
import com.liu.frescostudy.adpter.GifRecyclerViewAdapter;
import com.liu.frescostudy.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 用RecycleView展示Gif的Fragmnet
 * Created by liu on 2016/12/16.
 */

public class GifRecyclerViewFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<String> urlList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_gif_recyclerview, container, false);
        initView(view);
        setData();
        return view;
    }

    private void initView(View view) {
        recyclerView= (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setData() {
        int length= Constant.Url.GIF_ARRAY.length;
        for (int i = 0; i < length; i++) {
            urlList.add(Constant.Url.GIF_ARRAY[i]);
        }
        recyclerView.setAdapter(new GifRecyclerViewAdapter(urlList));
    }
}
