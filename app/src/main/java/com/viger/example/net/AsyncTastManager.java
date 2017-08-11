package com.viger.example.net;

import android.os.AsyncTask;
import android.text.TextUtils;

/**hah 
 * Created by Administrator on 2017/8/11.
 */

public class AsyncTastManager {

    private String url;
    private MyAsyncTask myAsyncTask;


    public AsyncTastManager(String url) {
        this.url = url;
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(url);
    }

    private class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            //省略网络请求代码
            //子线程执行
            String result = getNetWorkData(url);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!TextUtils.isEmpty(s)) {
                //处理返回数据
                handleBackData(s);
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            //调用onCancel()就会执行到这里

        }

        private void handleBackData(String s) {

        }


    }

    private String getNetWorkData(String url) {
        return "json数据";
    }

    public void onCancel() {
        if(myAsyncTask!=null) {
            myAsyncTask.onCancelled();
        }
    }





}
