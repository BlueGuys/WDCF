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

    public static final String TYPE_USER = "2";
    public static final String TYPE_TEACHER = "3";

    /**
     * 2 用户 3理财师
     */
    private String userType = TYPE_USER;

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
        this.userType = SharePreferenceManager.getInstance().getString("userType");
        readAccountInfo();
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
        SharePreferenceManager.getInstance().putString("userType", userType);
    }

    /**
     * 如果没有登录,直接跳转登录页面
     */
    public boolean checkLogin() {
        if (token != null && token.length() > 0) {
            return true;
        }
        Router router = new Router();
        router.setUrl(RouterConfig.UserLoginIndex);
        RouterManager.getInstance().openUrl(router);
        return false;
    }

    public void logout() {
        SharePreferenceManager.getInstance().deleteStr("account");
        SharePreferenceManager.getInstance().deleteStr("token");
        SharePreferenceManager.getInstance().deleteStr("userType");
        EventBus.getDefault().post(new AccountMessageEvent(false));
        this.mAccountInfo = null;
        this.token = "";
    }

    public void refresh() {
        if (token == null) {
            return;
        }
        getAccountInfoFromServer(token);
    }

    /**
     * 从网络拉取账户信息
     */
    private void getAccountInfoFromServer(final String token) {
        if (null == token) {
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
