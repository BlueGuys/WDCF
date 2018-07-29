package com.hongyan.base;

/**
 * Created by wangning on 2018/3/21.
 */

public class TokenMessageEvent {

    private boolean isLogin;

    public TokenMessageEvent(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
