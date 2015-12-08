package com.ylf.jucaipen.radarpaint.receiver;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;

/**
 * Created by Administrator on 2015/12/7.
 */
public class NetReceiver extends BroadcastReceiver {
    private ConnectivityManager manager;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
             manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo net=manager.getActiveNetworkInfo();
            String netName=net.getTypeName();
            if(net!=null&&net.isAvailable()){
                Log.i("111","connected:"+netName);
            }else {
               Log.i("111","fail:"+netName);
            }
        }
    }
}
