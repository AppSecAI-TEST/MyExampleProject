package com.viger.example.utils.leakcanary;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.leakcanary.RefWatcher;
import com.viger.example.MyApplication;
import com.viger.example.R;

/**
 * Created by Administrator on 2017/8/2.
 */

public class LeakFragment extends Fragment {

    private View view;
    private Button btn;
    private Object o;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_leak, container);
        btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "clickme", Toast.LENGTH_SHORT).show();
                //new MyThread().start();
            }
        });
        return view;
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
                for(int i=0;i<20;i++) {
                    Log.d("tag", "run:"+i);
                    SystemClock.sleep(1000);
                }
            }
        }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //检测内存泄漏
        MyApplication.mRefWatcher.watch(this);

        //检测object是否泄漏
        RefWatcher mRefWatcher = MyApplication.mRefWatcher;
        mRefWatcher.watch(o);
    }
}
