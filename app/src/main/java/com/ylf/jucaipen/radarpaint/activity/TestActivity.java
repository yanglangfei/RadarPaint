package com.ylf.jucaipen.radarpaint.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tandong.sa.activity.SmartActivity;
import com.tandong.sa.tools.AssistTool;
import com.ylf.jucaipen.radarpaint.R;

/**
 * Created by Administrator on 2015/12/9.
 */
public class TestActivity extends SmartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
        AssistTool tool=new AssistTool(this);
        long size=tool.getRealSizeOnPhone();
        long s=tool.getRealSizeOnSdcard();
    }
}
