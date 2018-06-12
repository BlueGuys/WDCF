package com.hongyan.base;

import android.app.Application;

import com.hongyan.TestFactory;
import com.hongyan.lib_base.BuildConfig;

/**
 * com.hongyan.base.BaseApplication
 */
public class BaseApplication extends Application {

    private static BaseApplication _instance;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
        NetworkManger.getInstance().init(this);
        if (BuildConfig.DEBUG) {
            TestFactory.getInstance().init(this);
        }
    }

    public static BaseApplication getInstance() {
        return _instance;
    }
}
