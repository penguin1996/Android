package com.accenture.day_02_application;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class ChxService extends Service {

    @Override
    public void onCreate() {
        Log.i("run","MyService Created:"+Thread.currentThread().getId());
        super.onCreate();
        new Handler().postDelayed(new Runnable(){
            public void run() {
                Log.i("run","MyService Done"+Thread.currentThread().getId());
                stopSelf();
            }
        },5000);
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId) {
        Log.i("run","MyService onStartCommand:"+Thread.currentThread().getId());
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("run","MyService onBind"+Thread.currentThread().getId());
        return null;
    }

    @Override
    public void onDestroy( ){
        Log.i("run","onDestroy"+Thread.currentThread().getId());
        super.onDestroy();
    }
}
