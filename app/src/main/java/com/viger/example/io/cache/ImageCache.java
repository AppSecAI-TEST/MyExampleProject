package com.viger.example.io.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.util.LruCache;

import java.io.File;

/**a
 * Created by Administrator on 2017/8/9.
 * 单例模式
 */

public class ImageCache {

    private static ImageCache instance = null;
    public LruCache<String, Bitmap> lruCache;
    private String path;

    private ImageCache() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        //使用最大内存的8分之1来作为缓存内存
        int maxSize = (int)maxMemory / 8;
        lruCache = new LruCache<String, Bitmap>(maxSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //指定缓存中每个对象占用多少内存
                //return value.getRowBytes() * value.getHeight();
                return value.getByteCount();
            }
        };
        path = Environment.getExternalStorageDirectory() + File.separator + "bitmaps" + File.separator;
    }

    public static ImageCache getInstance() {
        if(instance == null) {
            synchronized (ImageCache.class) {
                if(instance == null) {
                    instance = new ImageCache();
                }
            }
        }
        return instance;
    }

    public Bitmap getBitmap(String key) {
        Log.d("tag", "==>getBitmap key="+key);
        Bitmap bitmap = null;
        bitmap = lruCache.get(key);
        if(bitmap != null) {
            Log.d("tag", "==>getImageFrom Lrucache");
            return bitmap;
        }
        //缓存中没有，从文件中获取,并且加入缓存中
        bitmap = BitmapFactory.decodeFile(path + key);
        putBitmap(key, bitmap);
        Log.d("tag", "==>getImageFrom sdCard");
        return bitmap;
    }

    public void putBitmap(String key, Bitmap bitmap) {
        Log.d("tag", "==>putBitmap key="+key);
        if(bitmap != null) {
            lruCache.put(key, bitmap);
        }
    }

}
