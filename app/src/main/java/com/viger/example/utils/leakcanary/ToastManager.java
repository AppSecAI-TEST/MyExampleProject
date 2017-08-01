package com.viger.example.utils.leakcanary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/1.
 */

public class ToastManager {

    public static ToastManager instance = null;
    private Context mContext;

    private ToastManager(Context ctx) {
        this.mContext = ctx;
    }

    public static ToastManager getInstance(Context ctx) {
        if(instance == null) {
            synchronized (ToastManager.class) {
                if(instance == null) {
                    instance = new ToastManager(ctx);
                }
            }
        }
        return instance;
    }

    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }


}
