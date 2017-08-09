package com.viger.example.io.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.viger.example.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/9.
 */

public class MyAdapter extends BaseAdapter {

    private ArrayList<String> arrayList;
    private Context context;
    private ImageCache imageCache;

    public MyAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        imageCache = ImageCache.getInstance();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view==null) {
            view = View.inflate(context, R.layout.lrucache_listview_item_, null);
            holder = new ViewHolder();
            holder.iv_lrucache_img = view.findViewById(R.id.iv_lrucache_img);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        String bitmapName = arrayList.get(i);
        Log.d("tag", "==>getView bitmapName="+bitmapName);
        //通过缓存拿bitmap
        Bitmap bitmap = imageCache.getBitmap(bitmapName);
        holder.iv_lrucache_img.setImageBitmap(bitmap);
        return view;
    }

    private class ViewHolder {
        ImageView iv_lrucache_img;
    }

}
