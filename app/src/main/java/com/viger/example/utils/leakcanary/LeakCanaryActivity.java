package com.viger.example.utils.leakcanary;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.viger.example.R;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/7/31.
 */

public class LeakCanaryActivity extends AppCompatActivity {

    public boolean isDestroy = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_canary);
    }

    public void startThread(View v) {
        MyThread myThread = new MyThread(this);
        myThread.start();
    }

    private static class MyThread extends Thread {

        private WeakReference<Activity> reference = null;

        public MyThread(Activity act) {
            reference = new WeakReference<Activity>(act);
        }

        @Override
        public void run() {
            super.run();
            LeakCanaryActivity activity = (LeakCanaryActivity) reference.get();
            if(activity!=null) {
                for(int i=0;i<20;i++) {
                    if(activity.isDestroy) {
                        Log.d("tag", "activity已销毁");
                        return;
                    }
                    Log.d("tag", "run:"+i);
                    SystemClock.sleep(1000);
                }
                Log.d("tag", "for循环结束");
            }
            Log.d("tag", "方法结束");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestroy = true;
    }
}
