package com.viger.example.utils.leakcanary;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.viger.example.R;

/**
 * Created by Administrator on 2017/7/31.
 */

public class LeakCanaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_canary);
    }

    public void startThread(View v) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            for(int i=0;i<20;i++) {
                SystemClock.sleep(1000);
            }
        }
    }

}
