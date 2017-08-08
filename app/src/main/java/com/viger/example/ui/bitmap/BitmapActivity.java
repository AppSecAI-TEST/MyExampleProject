package com.viger.example.ui.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.viger.example.R;

import java.io.File;

/**
 * Created by Administrator on 2017/8/8.
 */

public class BitmapActivity extends AppCompatActivity {

    private ImageView imageView;
    private int mScreenWidth;
    private int mScreenHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        imageView = (ImageView) findViewById(R.id.iv_bitmap);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mScreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;
    }

    //直接加载不做任何压缩
    public Bitmap getBitmap() {
        Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + File.separator + "ss.jpg");
        return bitmap;
    }

    public void set(View view) {
        //Bitmap bitmap = getBitmap();
        Bitmap bitmap = getScaledBitmap(540,540);
        imageView.setImageBitmap(bitmap);
    }

    //边界压缩
    public Bitmap getScaledBitmap(int targetWidth, int targetHeight) {
        Log.d("tag", "targetwidth="+targetWidth+" target2="+targetHeight);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + File.separator + "ss.jpg", options);
        int width = options.outWidth;
        int height = options.outHeight;
        Log.d("tag", "压缩前width1="+width+" height1="+height);
        int scaleResult = 1;
        if(targetWidth != 0) {
            int widthScale = width / targetWidth;
            scaleResult = Math.max(scaleResult, widthScale);
        }
        if(targetHeight != 0) {
            int heightScale = height / targetHeight;
            scaleResult = Math.max(scaleResult, heightScale);
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = scaleResult;
        bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + File.separator + "ss.jpg", options);
        Log.d("tag", "压缩后width2="+bitmap.getWidth()+" 2="+bitmap.getHeight());
        return bitmap;
    }
}
