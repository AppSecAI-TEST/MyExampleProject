package com.viger.example.utils.leakcanary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.viger.example.R;

/**
 * Created by Administrator on 2017/8/3.
 */

public class TraceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traceview);
    }

    public void click(View view) {

    }
}
