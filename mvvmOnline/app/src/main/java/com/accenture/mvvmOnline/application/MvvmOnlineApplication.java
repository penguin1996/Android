package com.accenture.mvvmOnline.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MvvmOnlineApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
