package com.ylf.jucaipen.radarpaint.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ylf.jucaipen.radarpaint.R;
import com.ylf.jucaipen.radarpaint.adapter.ParentAdapt;
import com.ylf.jucaipen.radarpaint.entity.Entity;
import com.ylf.jucaipen.radarpaint.entity.ShowEntity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/9.
 */
public class ListMain extends Activity {
    private  String url="http://blog.csdn.net/newest.html?&page=7";

    private ParentAdapt mParentAdapt;
    private ArrayList<ShowEntity> mParentList;
    private Handler mHandle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
           if(msg.what==10){
               Document result= (Document) msg.obj;
               Elements tag=result.getElementsByTag("meta");
               for(Element e : tag){
                  String name=e.attr("name");
                   String content=e.attr("content");
                   ShowEntity entity=new ShowEntity(name,content);
                   mParentList.add(entity);
               }
               mParentAdapt.notifyDataSetChanged();
           }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
        initData();
        initView();

    }

    private void initView() {
        ListView listView = (ListView)findViewById(R.id.listView1);
        mParentAdapt=new ParentAdapt(this,mParentList);
        listView.setAdapter(mParentAdapt);
        listView.setOnItemClickListener(new AdaptItemClick());
    }

    private void initData() {
        mParentList = new ArrayList<>();
        mParentList.clear();
        new Thread(){
            @Override
            public void run() {
                try {
                  Document result=Jsoup.connect(url).data("query", "Java").userAgent("Mozilla")
                            .cookie("auth", "token").timeout(3000 * 5).post();
                  mHandle.obtainMessage(10,result).sendToTarget();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private  class  AdaptItemClick implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           if(mParentAdapt.mParentItem==position&&mParentAdapt.mbShowChild){
               mParentAdapt.mbShowChild=false;
           }else {
               mParentAdapt.mbShowChild=true;
           }
            ParentAdapt.mParentItem = position;
            mParentAdapt.notifyDataSetChanged();
        }
    }
}
