package com.hongyan.wdcf.business.account.user;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.base.RequestKeyTable;

public class UserInfoActivity extends BaseActivity {

    private UserInfoHolder userInfoHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        String userName = getParam(RequestKeyTable.USER_NAME);
        String mobile = getParam(RequestKeyTable.MOBILE);
        String email = getParam(RequestKeyTable.EMAIL);
        String userAvatar = getParam(RequestKeyTable.USER_AVATAR);
        String address = getParam(RequestKeyTable.ADDRESS);
        String level = getParam(RequestKeyTable.LEVEL);
        String userIdentifyNumber = getParam(RequestKeyTable.USER_IDENTIFY_NUMBER);
        String userRealName = getParam(RequestKeyTable.USER_REAL_NAME);
        String type = getParam(RequestKeyTable.TYPE);
        userInfoHolder = new UserInfoHolder(this);
        userInfoHolder.setUserName(userName);
        userInfoHolder.setAddress(address);
        userInfoHolder.setMobile(mobile);
        userInfoHolder.setLevel(level);
        userInfoHolder.setUserIdentifyNumber(userIdentifyNumber);
        userInfoHolder.setUserRealName(userRealName);
        userInfoHolder.setEmail(email);
        userInfoHolder.setUserAvatar(userAvatar);
        userInfoHolder.setType(type);
        return userInfoHolder;
    }
}
