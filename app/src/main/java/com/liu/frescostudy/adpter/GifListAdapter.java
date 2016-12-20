package com.liu.frescostudy.adpter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.animated.base.AbstractAnimatedDrawable;
import com.facebook.imagepipeline.image.ImageInfo;
import com.liu.frescostudy.R;
import com.liu.frescostudy.model.GifModel;

import java.util.List;

/**
 * 展示Gif的ListView的Adapter
 * Created by liu on 2016/12/16.
 */

public class GifListAdapter extends BaseAdapter {
    private Context mContext;
    //数据集
    private List<GifModel> data;
    private LayoutInflater inflater;

    public GifListAdapter(Context mContext, List<GifModel> data) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_gif_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.simpleDraweeView = (SimpleDraweeView) convertView.findViewById(R.id.item_sdv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String url = data.get(position).url;
        if (!TextUtils.isEmpty(url)) {
//            DraweeController controller = Fresco.newDraweeControllerBuilder()
//                    .setUri(Uri.parse(url))
//                    .setAutoPlayAnimations(true)
//                    .build();
//            viewHolder.simpleDraweeView.setImageURI(url);
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setUri(Uri.parse(url))
                    .setControllerListener(new BaseControllerListener<ImageInfo>() {
                        @Override
                        public void onFinalImageSet(
                                String id,
                                ImageInfo imageInfo,
                                Animatable anim) {
                            updateAnimationControls(anim, position);
                        }
                    })
                    .setOldController(viewHolder.simpleDraweeView.getController())
                    .build();

            viewHolder.simpleDraweeView.setController(controller);
        }

        return convertView;
    }


    private void updateAnimationControls(Animatable anim, int position) {
        if (anim == null) {
            return;
        }
        data.get(position).animatable = anim;
    }

    //开始播放Gif
    public void startAnim(int position) {
        for (int i = 0; i <getCount() ; i++) {
            Animatable anim=data.get(i).animatable;
            if (anim!=null){
                if (position==i){
                    anim.start();
                }else {

                    anim.stop();
                }
            }

        }
    }

    //暂停播放Gif
    public void pasueAnim(Animatable anim) {
        if (anim != null) {
            if (anim instanceof AbstractAnimatedDrawable) {
                AbstractAnimatedDrawable animatedDrawable = (AbstractAnimatedDrawable) anim;
                animatedDrawable.pause();
            } else {
                Toast.makeText(mContext, "Could not pause animation", Toast.LENGTH_SHORT).show();
            }

        }
    }

    //停止播放Gif
    public void stopAnim(Animatable anim) {
        if (anim != null) {
            anim.stop();
        }
    }


    private static class ViewHolder {
        private SimpleDraweeView simpleDraweeView;
    }
}
