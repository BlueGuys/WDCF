package com.hongyan.wdcf.base;

import com.hongyan.ToastsUtils;
import com.hongyan.base.BaseApplication;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

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
        UMConfigure.init(this, "5b6fd8b8a40fa3274c00039c", "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        PlatformConfig.setWeixin("wx1341921c649344b5", "f6435d2f326a5be7ca174c3490280d2f");
        PlatformConfig.setQQZone("1107393925", "eED7IKonDsTw2e7E");
        UMConfigure.setLogEnabled(true);
        UMShareAPI.get(this);
    }


    private void initRouter() {
        RouterConfig.getInstance().init();
    }
}
