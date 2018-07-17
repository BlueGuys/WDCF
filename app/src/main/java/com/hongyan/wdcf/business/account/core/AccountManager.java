package com.hongyan.wdcf.business.account.core;


import com.hongyan.StringUtils;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.base.io.SharePreferenceManager;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.parse.GsonUtils;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.config.UrlConst;

import org.greenrobot.eventbus.EventBus;

public class AccountManager {

    private static volatile AccountManager instance;
    private AccountInfo mAccountInfo;
    private String token;

    private AccountManager() {
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
        this.token = SharePreferenceManager.getInstance().getString("token");
        readAccountInfo();
    }

    public void logout() {
        SharePreferenceManager.getInstance().deleteStr("account");
        SharePreferenceManager.getInstance().deleteStr("token");
        EventBus.getDefault().post(new AccountMessageEvent(false));
        this.mAccountInfo = null;
        this.token = "";
    }

    public void setToken(String token) {
        this.token = token;
        SharePreferenceManager.getInstance().putString("token", token);
        refresh();
    }

    public String getToken() {
        return this.token;
    }

    public AccountInfo getAccountInfo() {
        return mAccountInfo;
    }

    /**
     * 如果没有登录,直接跳转登录页面
     *
     * @return true 已登录  false 去登录
     */
    public boolean checkLogin() {
        if (mAccountInfo != null && StringUtils.notEmpty(mAccountInfo.getId())) {
            return true;
        }
        Router router = new Router();
        router.setUrl(RouterConfig.UserLoginIndex);
        RouterManager.getInstance().openUrl(router);
        return false;
    }

    public void refresh() {
        getAccountInfoFromServer();
    }

    /**
     * 从网络拉取账户信息
     */
    private void getAccountInfoFromServer() {
        if (null == this.token) {
            return;
        }
        WDNetworkCall userInfoCall = new WDNetworkCall<>();
        userInfoCall.setRequestUrl(UrlConst.getUserInfoUrl());
        userInfoCall.setResultClass(UserInfoResult.class);
        userInfoCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                UserInfoResult userInfoResult = (UserInfoResult) result;
                if (userInfoResult.isSuccessful()) {
                    UserInfoResult.Data data = userInfoResult.data;
                    if (data == null) {
                        return;
                    }
                    mAccountInfo = new AccountInfo();
                    mAccountInfo.setId(data.id);
                    mAccountInfo.setUser_type(data.user_type);
                    mAccountInfo.setMobile(data.mobile);
                    mAccountInfo.setAvatar(data.avatar);
                    saveAccountInfo(GsonUtils.toJson(mAccountInfo));
                }
            }

            @Override
            public void onError(BaseResult.Error error) {

            }
        });

    }

    private void saveAccountInfo(String accountJson) {
        SharePreferenceManager.getInstance().putString("account", accountJson);
    }

    private void readAccountInfo() {
        String accountJson = SharePreferenceManager.getInstance().getString("account");
        if (!StringUtils.isEmpty(accountJson)) {
            mAccountInfo = GsonUtils.gsonResolve(accountJson, AccountInfo.class);
        }
    }
}
