package com.hongyan.wdcf.config;

public class UrlConst {

    private static String HOST = "http://caifu.thongfu.com/";

    public static String getHOST() {
        return HOST;
    }

    public static void setHOST(String HOST) {
        UrlConst.HOST = HOST;
    }

    /**
     * 注册接口
     */
    public static String getRegisterUrl() {
        return HOST + "Api/Users/reg";
    }

    /**
     * 鉴权注册接口
     */
    public static String getSendCodeUrl() {
        return HOST + "Api/Users/sendyzm";
    }

    /**
     * 登录接口
     */
    public static String getLoginUrl() {
        return HOST + "Api/Users/login";
    }

    /**
     * 用户信息
     */
    public static String getUserInfoUrl() {
        return HOST + "Api/Users/getUserInfo";
    }
}
