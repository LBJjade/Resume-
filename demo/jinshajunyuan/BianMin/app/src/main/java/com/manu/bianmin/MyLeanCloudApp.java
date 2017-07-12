package com.manu.bianmin;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by min on 2017/7/12.
 */

public class MyLeanCloudApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"AReSSNwX6JlO4R8ibzJyly3c-gzGzoHsz","KuiLI0rTTW2NyFrXlPYKUnH6");
        // 放在 SDK 初始化语句 AVOSCloud.initialize() 后面，只需要调用一次即可
        AVOSCloud.setDebugLogEnabled(true);
        //发布的时候，记得将第三个参数改成false
        CrashReport.initCrashReport(getApplicationContext(), "b9d30d053e", true);
    }
}
