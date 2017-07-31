package com.viger.example.utils.leakcanary;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.viger.example.R;
import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/7/31.
 */

public class HandlerLeakActivity extends AppCompatActivity {

    private boolean isDestroy = false;
    private String message;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_leak);

    }

    private static class MyHandler extends Handler {

        private WeakReference<Activity> reference = null;

        public MyHandler(Activity act) {
            reference = new WeakReference<Activity>(act);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            HandlerLeakActivity activity = (HandlerLeakActivity) reference.get();
            if(activity.isDestroy) return;
            switch (msg.what) {
                case 0:

                    break;
            }
        }
    }

    public void headlerClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestroy = true;
    }
}
