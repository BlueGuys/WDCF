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

    /**
     * 首页接口
     */
    public static String getDiscoverUrl() {
        return HOST + "api/home/index";
    }

    /**
     * 提交反馈
     */
    public static String getFeedbackUrl() {
        return HOST + "Api/Feedback/index";
    }

    /**
     * 活动
     */
    public static String getActivityUrl() {
        return HOST + "Api/Event/getList";
    }

    /**
     * 头条
     */
    public static String getNewsUrl() {
        return HOST + "Api/Product/topList";
    }

    /**
     * 银行卡列表
     */
    public static String getBankCardListUrl() {
        return HOST + "Api/Bank/getBanksList";
    }

    /**
     * 我的订单
     */
    public static String getMyOrderUrl() {
        return HOST + "Api/Finaplanner/myOrder";
    }

    /**
     * 我的活动
     */
    public static String getMyActivityUrl() {
        return HOST + "Api/Finaplanner/myEvent";
    }


}
