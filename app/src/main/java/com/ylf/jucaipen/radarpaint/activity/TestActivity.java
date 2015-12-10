package com.ylf.jucaipen.radarpaint.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tandong.sa.activity.SmartActivity;
import com.tandong.sa.system.SystemInfo;
import com.tandong.sa.tools.AssistTool;
import com.ylf.jucaipen.radarpaint.R;
import com.ylf.jucaipen.radarpaint.base.BaseActivity;

/**
 * Created by Administrator on 2015/12/9.
 *
 *  测试 SmartAndroid.jar
 */
public class TestActivity extends SmartActivity {
    private Button btn_exit;
    private TextView tv_size;
    private TextView tv_ip;
    private AssistTool tool;
    private SystemInfo sys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_test);
        tool = new AssistTool(this);
        sys = new SystemInfo(this);
        tool.releaseWakeLock();
        initView();
    }

    /**
     * 退出程序
     */
    private void initView() {
        btn_exit = (Button) findViewById(R.id.btn_exit);
        tv_size = (TextView) findViewById(R.id.tv_size);
        tv_ip = (TextView) findViewById(R.id.tv_ip);
        long size = tool.getRealSizeOnPhone();
        long sd = tool.getRealSizeOnSdcard();
        String ip = tool.getWifiIp();
        int versionCode = tool.getVersionCode();
        String version = tool.getVersion();
        boolean isUser = sys.checkWifi();
        sys.ApplyRootAuthorize();
        String bootTime = sys.getBootTime();
        String memory = sys.getAvailableMemory();
        int cpuNum = sys.getCpuCoresNum();
        String maxFre = sys.getCpuMaxFrequence();
        String minFre = sys.getCpuMinFrequence();
        String cpuModel = sys.getCpuModel();
        String language = sys.getDeviceLanguage();
        String deviceName = sys.getDeviceName();
        String imei = sys.getImei();
        String macAddress = sys.getMacAddress();
        String netType = sys.getNetWorkType();
        String availableStorage = sys.getSDCardAvailableStorage();
        String totalStorage = sys.getSDCardTotalStorage();
        String sensor = sys.getSensor();
        String sysVersionCode = sys.getSystemVersionCode();
        String sysVersionName = sys.getSystemVersionName();
        int wifiAddress = sys.getWifiIpAddress();
        int linkSpeed = sys.getWifiLinkSpeed();
        String wifiMacAddress = sys.getWifiMacAddress();
        int wifiRssi = sys.getWifiRssi();
        Log.i("111", "availableStorage:" + availableStorage + " totalStorage:" +
                totalStorage + " sensor:" + sensor + " sysVersionCode:" +
                sysVersionCode + " sysVersionName" +
                sysVersionName+" wifiAddress:"+wifiAddress+" linkSpeed:"+linkSpeed+" wifiMacAddress:"+wifiMacAddress+" wifiRssi:"+wifiRssi);
        Log.i("111", "macAddress:" + macAddress + "  netType:" + netType);
        Log.i("111", "deviceName:" + deviceName + "  imei:" + imei);
        Log.i("111", "cpuModel:" + cpuModel + "  language:" + language);
        Log.i("111", "maxFre:" + maxFre + " minFre:" + minFre);
        Log.i("111", "cpuNum:" + cpuNum);
        Log.i("111", "memory:" + memory);
        Log.i("111", "bootTime:" + bootTime);
        Log.i("111", "isUse:" + isUser);
        tv_ip.setText("wifiIp:" + ip + "   code:" + versionCode + " version:" + version);
        tv_size.setText("phone:" + size + " sd:" + sd);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finish = new Intent();
                finish.setClass(TestActivity.this, BaseActivity.class);
                finish.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                finish.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                TestActivity.this.startActivity(finish);
                TestActivity.this.finish();
            }
        });
    }
}
