package com.viger.example.utils.leakcanary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.viger.example.R;

/**
 * Created by Administrator on 2017/8/1.
 */

public class ContextLeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_leak);
    }

    public void click(View v){
        //ToastManager manager = ToastManager.getInstance(this);
        //使用applicationContext避免内存溢出
        ToastManager manager = ToastManager.getInstance(getApplicationContext());
        manager.showToast("我是弹出提示信息");
    }
}
