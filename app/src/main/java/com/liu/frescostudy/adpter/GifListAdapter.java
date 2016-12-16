package com.liu.frescostudy.adpter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.liu.frescostudy.R;

import java.util.List;

/**
 * 展示Gif的ListView的Adapter
 * Created by liu on 2016/12/16.
 */

public class GifListAdapter extends BaseAdapter {
    private Context mContext;
    //数据集
    private List<String> data;
    private LayoutInflater inflater;

    public GifListAdapter(Context mContext, List<String> data) {
        this.mContext = mContext;
        this.data = data;
        initLayoutInflater();
    }

    private void initLayoutInflater() {
        inflater = LayoutInflater.from(this.mContext);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_gif_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.simpleDraweeView = (SimpleDraweeView) convertView.findViewById(R.id.item_sdv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String url = data.get(position);
        if (!TextUtils.isEmpty(url)) {
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setUri(Uri.parse(url))
                    .setAutoPlayAnimations(true)
                    .build();
            viewHolder.simpleDraweeView.setController(controller);
        }

        return convertView;
    }

    private static class ViewHolder {
        private SimpleDraweeView simpleDraweeView;
    }
}
