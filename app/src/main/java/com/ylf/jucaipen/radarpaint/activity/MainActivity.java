package com.ylf.jucaipen.radarpaint.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import com.ylf.jucaipen.radarpaint.R;

public class MainActivity extends Activity {

    private ProgressDialog dialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setTitle("下载提示");
        dialog.setMax(100);


        dialog.setProgressNumberFormat("%1d kb/%2d kb");
        MyTask task = new MyTask();
        task.execute();
    }


    class MyTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(1000);
                    publishProgress(i);
                }
            } catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.cancel();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //ProgressDialog 更新
            dialog.setProgress(values[0]);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}
