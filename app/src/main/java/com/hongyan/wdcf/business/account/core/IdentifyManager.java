package com.hongyan.wdcf.business.account.core;


import android.widget.Toast;

import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.base.WDApplication;

public class IdentifyManager {

    private static volatile IdentifyManager instance;
    private AccountInfo mAccountInfo;
    private String token;

    private IdentifyManager() {
    }

    public static IdentifyManager getInstance() {
        if (instance == null) {
            synchronized (IdentifyManager.class) {
                if (instance == null) {
                    instance = new IdentifyManager();
                }
            }
        }
        return instance;
    }

    public boolean startVerify() {
        if (AccountManager.getInstance().checkLogin()) {
            AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
            int status = accountInfo.auth_status;
            switch (status) {
                case 0://跳转提交资料页面提交资料进行审核
                    RouterManager.getInstance().openUrl(new Router(RouterConfig.UserRegisterSelect));
                    return false;
                case 1://等待审核 提示等待
                    Toast.makeText(WDApplication.getInstance().getApplicationContext(), "等待审核", Toast.LENGTH_SHORT).show();
                    return false;
                case 2://通过
                    return true;
                case 3://跳转提交资料页面提交资料进行审核
                    RouterManager.getInstance().openUrl(new Router(RouterConfig.UserRegisterSelect));
                    return false;
            }
        }
        return false;
    }
}
