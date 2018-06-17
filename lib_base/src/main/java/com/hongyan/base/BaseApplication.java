package com.hongyan.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;

import com.hongyan.DynamicTimeFormat;
import com.hongyan.TestFactory;
import com.hongyan.lib_base.BuildConfig;
import com.hongyan.smartrefresh.layout.SmartRefreshLayout;
import com.hongyan.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.hongyan.smartrefresh.layout.api.RefreshHeader;
import com.hongyan.smartrefresh.layout.api.RefreshLayout;
import com.hongyan.smartrefresh.layout.header.ClassicsHeader;

/**
 * com.hongyan.base.BaseApplication
 */
public class BaseApplication extends Application {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);//启用矢量图兼容
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setPrimaryColorsId(android.R.color.white, android.R.color.darker_gray);//全局设置主题颜色
                return new ClassicsHeader(context).setTimeFormat(new DynamicTimeFormat("更新于 %s"));
            }
        });
    }

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
