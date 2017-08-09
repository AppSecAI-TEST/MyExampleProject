package com.viger.example.io.cache;

import android.content.Context;
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

    public MyAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
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
            view = View.inflate(context, R.layout.lrucache_listview_item_, viewGroup);
            holder = new ViewHolder();
            holder.iv_lrucache_img = view.findViewById(R.id.iv_lrucache_img);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        String bitmap = (String) getItem(i);

        return view;
    }

    private class ViewHolder {
        ImageView iv_lrucache_img;
    }

}
