package com.ylf.jucaipen.radarpaint.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.caucho.hessian.client.HessianProxyFactory;
import com.ylf.jucaipen.radarpaint.base.BasicAPI;

import java.net.MalformedURLException;

/**
 * Created by Administrator on 2015/12/9.
 */
public class HessianTest extends Activity {
    String url = "https://developer.apple.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HessianProxyFactory factory = new HessianProxyFactory();
        factory.setDebug(true);
        factory.setReadTimeout(1000 * 5);
        try {
            BasicAPI api = factory.create(BasicAPI.class, url, getClassLoader());
            Log.i("111", "say:" + api.sayHello());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
