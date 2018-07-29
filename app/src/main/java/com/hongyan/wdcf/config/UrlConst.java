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
     * 资讯列表
     */
    public static String getNewsListUrl() {
        return HOST + "Api/News/getList";
    }

    /**
     * 资讯详情
     */
    public static String getNewsDetailUrl() {
        return HOST + "Api/News/getDetail";
    }

    /**
     * 活动详情
     */
    public static String getActivityDetailUrl() {
        return HOST + "Api/Event/getDetail";
    }

    /**
     * 预约活动
     */
    public static String getYuyueActivityUrl() {
        return HOST + "Api/event/joinEvent";
    }

    /**
     * 修改用户信息
     */
    public static String getEditUserUrl() {
        return HOST + "Api/Users/edit_user";
    }

    /**
     * 推荐的理财师
     */
    public static String getRecommandTeacherUrl() {
        return HOST + "Api/Finaplanner/getChoose";
    }

    /**
     * 推荐的理财师
     */
    public static String getBindTeacherUrl() {
        return HOST + "Api/Finaplanner/bindFinaplanner";
    }

    /**
     * 修改登录密码
     */
    public static String getModifyLoginPasswordUrl() {
        return HOST + "";
    }

    /**
     * 获取验证码
     */
    public static String getCheckCodeUrl() {
        return HOST + "";
    }

    /**
     * 修改交易密码
     */
    public static String getModifyTradePasswordUrl() {
        return HOST + "";
    }

    /**
     * 获取产品列表
     */
    public static String getProductListUrl() {
        return HOST + "Api/Product/home";
    }

    /**
     * 我的订单列表
     */
    public static String getMyOrderListUrl() {
        return HOST + "Api/Users/myOrder";
    }

    /**
     * 我的活动列表
     */
    public static String getMyActivityListUrl() {
        return HOST + "Api/Users/myEvent";
    }

    /**
     * 类固定收益列表
     */
    public static String getProductFixedListUrl() {
        return HOST + "Api/Product/getList";
    }

    /**
     * 我的客户列表
     */
    public static String getCustomerListUrl() {
        return HOST + "Api/Finaplanner/myUser";
    }

    /**
     * 用户订单
     */
    public static String getSubcribeOrderListUrl() {
        return HOST + "Api/Finaplanner/myOrder";
    }

    /**
     * 订单受理状态
     */
    public static String getOrderStatusEditUrl() {
        return HOST + "Api/Finaplanner/changeStatus";
    }

    /**
     * 增加沟通
     */
    public static String getAddRecordUrl() {
        return HOST + "Api/Finaplanner/addLinkup";
    }

    /**
     * 订单详情
     */
    public static String getOrderDetailUrl() {
        return HOST + "Api/Order/orderDetail";
    }
}
