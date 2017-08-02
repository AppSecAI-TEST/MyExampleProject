package com.viger.example;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Administrator on 2017/7/31.
 */

public class MyApplication extends Application {

    //为了检测fragment内存泄漏
    public static RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        //LeakCanary.install(this);
        mRefWatcher = LeakCanary.install(this);
    }
}
