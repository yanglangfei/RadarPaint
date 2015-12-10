package com.ylf.jucaipen.radarpaint.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2015/12/9.
 */
public class BaseActivity extends Activity {

    private  String TAG=BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int pId=android.os.Process.myPid();
        Log.i(TAG,"pId:"+pId);
        this.finish();
    }
}
