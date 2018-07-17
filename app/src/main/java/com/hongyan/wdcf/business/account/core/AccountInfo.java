package com.hongyan.wdcf.business.account.core;


import com.hongyan.base.BaseResult;


public class AccountInfo extends BaseResult {

    public static final String TYPE_USER = "2";
    public static final String TYPE_TEACHER = "3";

    public String id;
    /**
     * 2 用户 3理财师
     */
    public String user_type;
    public String user_nicename;
    public String user_email;
    public String avatar;
    public String mobile;

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
}
