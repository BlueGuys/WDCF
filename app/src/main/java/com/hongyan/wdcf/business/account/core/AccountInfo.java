package com.hongyan.wdcf.business.account.core;


import com.hongyan.base.BaseResult;


public class AccountInfo extends BaseResult {

    public static final String TYPE_USER = "2";
    public static final String TYPE_TEACHER = "3";

    public static final int AUTH_TYPE_STATUS = 1;

    public String id;
    /**
     * 2 用户 3理财师
     */
    public String user_type;
    public String user_nicename;
    public String user_email;
    public String avatar;
    public String mobile;
    /**
     *  auth_status=0 跳转提交资料页面提交资料进行审核
     *  auth_status=1 等待审核 提示等待，
     *  auth_status=2 通过，
     *  auth_status=3 跳转提交资料页面提交资料进行审核
     */
    public int auth_status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_nicename() {
        return user_nicename;
    }

    public void setUser_nicename(String user_nicename) {
        this.user_nicename = user_nicename;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public String getUIMobile() {
        if (mobile != null && mobile.length() == 11) {
            return mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
        }
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAuth_status() {
        return auth_status;
    }

    public void setAuth_status(int auth_status) {
        this.auth_status = auth_status;
    }
}
