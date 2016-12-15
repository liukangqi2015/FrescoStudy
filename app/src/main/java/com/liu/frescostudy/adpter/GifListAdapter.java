package com.liu.frescostudy.adpter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.liu.frescostudy.R;

import java.util.List;

/**
 * 展示Gif列表的RecycleView的适配器
 * Created by liu on 2016/12/15.
 */

public class GifListAdapter extends RecyclerView.Adapter<GifListAdapter.ViewHolder>{
    //数据集
    private List<String> data;

    public GifListAdapter(List<String> data){
        this.data=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gif_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position<getItemCount()){
            String url=data.get(position);
            if (!TextUtils.isEmpty(url)){
                Log.e("Adapter","position:"+position+"-url:"+url);
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(Uri.parse(url))
                        .setAutoPlayAnimations(true)
                        .build();
                holder.simpleDraweeView.setController(controller);
            }
        }



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView simpleDraweeView;

        public ViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.item_sdv);
        }
    }
}
