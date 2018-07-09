package com.hongyan.wdcf.business.account.core;


import android.util.Log;
import android.widget.Toast;

import com.hongyan.StringUtils;
import com.hongyan.base.BaseApplication;
import com.hongyan.base.io.SharePreferenceManager;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.parse.GsonUtils;
import com.hongyan.wdcf.base.RouterConfig;

import org.greenrobot.eventbus.EventBus;

public class AccountManager {

    private static volatile AccountManager instance;
    private AccountInfo mAccountInfo;
    private String token;

    private AccountManager() {
        init();
    }

    public static AccountManager getInstance() {
        if (instance == null) {
            synchronized (AccountManager.class) {
                if (instance == null) {
                    instance = new AccountManager();
                }
            }
        }
        return instance;
    }

    /**
     * 从SD卡读取账户信息
     */
    public void init() {
        readAccountInfo();
    }

    public void setToken(String token) {
        this.token = token;
        Toast.makeText(BaseApplication.getInstance().getApplicationContext(), "登录成功", Toast.LENGTH_LONG).show();
        getAccountInfoFromServer(token);
    }

    public String getToken() {
        return this.token;
    }

    public AccountInfo getAccountInfo() {
        return mAccountInfo;
    }

    /**
     * 如果没有登录,直接跳转登录页面
     */
    public boolean checkLogin() {
        if (mAccountInfo != null) {//如果没有登录，直接跳登录页面
            return true;
        }
        Router router = new Router();
        router.setUrl(RouterConfig.UserLoginIndex);
        RouterManager.getInstance().openUrl(router);
        return false;
    }

    public void logout() {
        SharePreferenceManager.getInstance().deleteStr("account");
        EventBus.getDefault().post(new AccountMessageEvent(false));
        mAccountInfo = null;
        this.token = "";
    }

    public void login() {

    }

    public void register() {

    }

    public void refresh() {
        getAccountInfoFromServer(this.token);
    }

    /**
     * 从网络拉取账户信息
     */
    private void getAccountInfoFromServer(final String token) {
        if (null == token) {

        }
    }

    private void saveAccountInfo(String accountJson) {
        SharePreferenceManager.getInstance().putString("account", accountJson);
    }

    private void readAccountInfo() {
        String accountJson = SharePreferenceManager.getInstance().getString("account");
        Log.e("XCJ", "accountJson=" + accountJson);
        if (!StringUtils.isEmpty(accountJson)) {
            mAccountInfo = GsonUtils.gsonResolve(accountJson, AccountInfo.class);
            if (mAccountInfo != null) {
                this.token = mAccountInfo.getToken();
            }
        }
    }
}
