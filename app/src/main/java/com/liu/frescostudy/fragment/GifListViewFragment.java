package com.liu.frescostudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.liu.frescostudy.R;
import com.liu.frescostudy.adpter.GifListAdapter;
import com.liu.frescostudy.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 用ListView显示Gif的fragment
 * Created by liu on 2016/12/16.
 */

public class GifListViewFragment extends Fragment{
    private ListView listView;
    private List<String> urlList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_gif_listview,container,false);
        initView(view);
        setData();
        return view;
    }

    private void initView(View view) {
        listView= (ListView) view.findViewById(R.id.list_view);
    }

    private void setData() {
        int length= Constant.Url.GIF_ARRAY.length;
        for (int i = 0; i < length; i++) {
            urlList.add(Constant.Url.GIF_ARRAY[i]);
        }
        listView.setAdapter(new GifListAdapter(getActivity(),urlList));

    }
}
