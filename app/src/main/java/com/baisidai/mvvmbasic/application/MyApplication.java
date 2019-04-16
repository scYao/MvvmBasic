package com.baisidai.mvvmbasic.application;

import android.app.Application;

import com.baisidai.mvvmbasic.config.Url;
import com.baisidai.mvvmbasic.http.HttpUtils;

public class MyApplication extends Application {
    public static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
