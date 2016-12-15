package com.liu.frescostudy;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/**
 * 使用Gif的Activity
 * Created by liu on 2016/12/15.
 */

public class GifActivity extends AppCompatActivity {
    private SimpleDraweeView simpleDraweeView;
    private Animatable mAnimatable;

    private Button btn;
    private String url = "http://mat1.gtimg.com/fashion/jingwen/34664.gif";
    private boolean isStart=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        initView();
        setData();
    }

    private void initView() {
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.simple_dv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mAnimatable!=null){
                    if (isStart){
                        mAnimatable.start();
                        isStart=false;
                    }else {
                        mAnimatable.stop();
                        isStart=true;
                    }

                }
            }
        });
    }

    private void setData() {
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(url))
                .setAutoPlayAnimations(false)
                .setControllerListener(new BaseControllerListener<ImageInfo>(){
                    @Override
                    public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                        if (animatable!=null){
                            mAnimatable=animatable;
                        }
                    }
                })
                .build();
        simpleDraweeView.setController(controller);

    }
}
