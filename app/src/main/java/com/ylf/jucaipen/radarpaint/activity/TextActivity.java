package com.ylf.jucaipen.radarpaint.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.widget.TextView;

import com.ylf.jucaipen.radarpaint.R;
import com.ylf.jucaipen.radarpaint.view.MyText;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Administrator on 2015/12/8.
 */
public class TextActivity extends Activity {
    private MyText tv_text;
    private TextView tv_text2;
    private  String url="http://blog.csdn.net/lmj623565791/article/details/23272657";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==100){
                String result= (String) msg.obj;
                tv_text2.setText(Html.fromHtml(result));
                tv_text.setText(result);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_text);
        initView();
    }

    private void initView() {
        tv_text= (MyText) findViewById(R.id.tv_text);
        tv_text2= (TextView) findViewById(R.id.tv_text2);
        new Thread(){
            @Override
            public void run() {
                try {
                    Document result = Jsoup.connect(url).data("query", "Java").userAgent("Mozilla")
                            .cookie("auth", "token").timeout(3000 * 5).post();
                    handler.obtainMessage(100,result.toString()).sendToTarget();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
