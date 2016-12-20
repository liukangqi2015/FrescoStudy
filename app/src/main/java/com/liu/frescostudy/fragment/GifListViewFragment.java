package com.liu.frescostudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.liu.frescostudy.R;
import com.liu.frescostudy.adpter.GifListAdapter;
import com.liu.frescostudy.constant.Constant;
import com.liu.frescostudy.model.GifModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 用ListView显示Gif的fragment
 * Created by liu on 2016/12/16.
 */

public class GifListViewFragment extends Fragment {
    private ListView listView;
    private List<GifModel> urlList = new ArrayList<>();
    private GifListAdapter adapter;
    private boolean isStart = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_gif_listview, container, false);
        initView(view);
        setData();
        return view;
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.list_view);
        //对于ListView滑动监听，触摸滑动或者快速滑动的时候可以停在加载图片

//        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                switch (scrollState) {
//                    case SCROLL_STATE_FLING:
//                    case SCROLL_STATE_TOUCH_SCROLL:
//                        if (!Fresco.getImagePipeline().isPaused()) {
//                            Fresco.getImagePipeline().pause();
//                        }
//                        break;
//                    case SCROLL_STATE_IDLE:
//                        if (Fresco.getImagePipeline().isPaused()) {
//                            Fresco.getImagePipeline().resume();
//                        }
//                        break;
//
//                }
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//
//            }
//        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    adapter.startAnim(position);
            }
        });
    }

    private void setData() {
        //对于GIF的缓存，Fresco的解释是缓存每一帧图像是困难的，所以在ListView或RecyclerView中加载GIF时看起来每一次都得重新加载(即使刚刚已经加载好了这张GIF)
        //Fresco会更新关于GIF的逻辑(Looking forward to the update)
        int lengthGif = Constant.Url.GIF_ARRAY.length;
        for (int i = 0; i < lengthGif; i++) {
            GifModel gifModel = new GifModel();
            gifModel.url = Constant.Url.GIF_ARRAY[i];
            urlList.add(gifModel);
        }
        adapter = new GifListAdapter(getActivity(), urlList);
        listView.setAdapter(adapter);

    }
}
