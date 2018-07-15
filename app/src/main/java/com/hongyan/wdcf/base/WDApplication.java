package com.hongyan.wdcf.base;

import com.hongyan.ToastsUtils;
import com.hongyan.base.BaseApplication;
import com.hongyan.wdcf.business.account.core.AccountManager;

/**
 * Created by wangning on 2018/6/10.
 */

public class WDApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
        AccountManager.getInstance().init();
        ImageLoaderOptionHelper.getInstance().initImageLoader(this);
        ToastsUtils.register(this);
    }


    private void initRouter() {
        RouterConfig.getInstance().init();
    }
}
