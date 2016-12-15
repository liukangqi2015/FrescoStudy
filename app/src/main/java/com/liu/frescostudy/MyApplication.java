package com.liu.frescostudy;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 本应用类
 * Created by liu on 2016/12/15.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Fresco
        Fresco.initialize(this);
    }
}
