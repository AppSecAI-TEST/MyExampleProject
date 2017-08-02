package com.viger.example.utils.leakcanary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.viger.example.R;

/**
 * Created by Administrator on 2017/8/2.
 */

public class LeakFragment2 extends Fragment {

    private View view;
    private Button btn2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_leak2, container, false);
        btn2 = view.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "clickme22", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
