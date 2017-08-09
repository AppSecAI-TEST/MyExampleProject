package com.viger.example.io.cache;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.viger.example.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/9.
 */

public class LruCacheActivity extends AppCompatActivity {

    private ListView listView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lrucache);
        listView = (ListView) findViewById(R.id.lv_lrucache);
        initData();
    }

    private void initData() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i=1;i<=20;i++) {
            String format = "";
            if(i < 10) {
                format = String.format("bitmap0%d.jpg", i);
            }else {
                format = String.format("bitmap%d.jpg", i);
            }
            Log.d("tag", format);
            arrayList.add(format);
        }

        myAdapter = new MyAdapter(arrayList, getApplicationContext());
        listView.setAdapter(myAdapter);
    }

}
