package com.hongyan.wdcf.base;


import com.hongyan.base.router.RouterConst;
import com.hongyan.wdcf.business.account.login.LoginActivity;

public final class RouterConfig {

    private static volatile RouterConfig instance;

    private RouterConfig() {
        init();
    }

    public static RouterConfig getInstance() {
        if (instance == null) {
            synchronized (RouterConfig.class) {
                if (instance == null) {
                    instance = new RouterConfig();
                }
            }
        }
        return instance;
    }

    public void init() {
        RouterConst.addRouter(UserLoginIndex, LoginActivity.class.getName());
    }


    public static final String UserLoginIndex = "native://user/login/index";

}
