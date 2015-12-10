package com.ylf.jucaipen.radarpaint.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ylf.jucaipen.radarpaint.R;

/**
 * Created by Administrator on 2015/12/10.
 */
public class Test3Activity extends  TestActivity {

    private Button btn_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_test3);
        initViews();
    }

    private void initViews() {
        btn_et= (Button) findViewById(R.id.btn_et);
        btn_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPress(Test3Activity.this);
            }
        });
    }
}
