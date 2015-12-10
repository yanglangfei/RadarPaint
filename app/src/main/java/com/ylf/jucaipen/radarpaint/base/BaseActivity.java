package com.ylf.jucaipen.radarpaint.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2015/12/9.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.finish();
    }
}
