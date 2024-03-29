package com.liuting.jetpack.jetpackdemo;

import android.app.Application;

import com.liuting.jetpack.jetpackdemo.network.NetEntry;
import com.squareup.leakcanary.LeakCanary;

/**
 * 作者:admin on 2020/10/18 21:24
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo
 * TODO:
 */
public class MainAppAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetEntry.Companion.get().initDataBase();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
