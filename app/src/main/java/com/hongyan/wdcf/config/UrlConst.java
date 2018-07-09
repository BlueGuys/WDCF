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
     * 鉴权注册接口
     */
    public static String getRegisterUrl() {
        return HOST + "Api/Users/reg";
    }
}
