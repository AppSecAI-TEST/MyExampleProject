package com.viger.example.utils.leakcanary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.viger.example.R;

/**
 * Created by Administrator on 2017/7/31.
 */

public class StaticInstanceActivity extends AppCompatActivity {

    private static User user = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_instance);
    }

    public void start(View v) {
        //user = new User();
    }

    private class User {
        public User() {

        }
    }

}
