package com.viger.example.ui.ScreenFit;

import android.content.Context;

/**
 * Created by Administrator on 2017/8/7.
 */

public class DisplayUtils {

    public static int dp2px(Context ctx, float dp) {
        float density = ctx.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }
}
