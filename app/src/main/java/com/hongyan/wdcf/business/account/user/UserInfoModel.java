package com.hongyan.wdcf.business.account.user;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.NetworkCall;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class UserInfoModel extends BaseModel {

    private UserInfoHolder viewHolder;

    public UserInfoModel(UserInfoHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void login(String mobilePhone, String password) {
        NetworkCall registerCall = new NetworkCall<>();
        registerCall.setRequestUrl(UrlConst.getLoginUrl());
        registerCall.setResultClass(UserInfoResult.class);
        registerCall.addParam(RequestKeyTable.MOBILE, mobilePhone);
        registerCall.addParam(RequestKeyTable.PASSWORD, password);
        registerCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                UserInfoResult registerResult = (UserInfoResult) result;
                if (registerResult.isSuccessful()) {
                    UserInfoResult.Data data = registerResult.data;
                    if (data != null) {
                        AccountManager.getInstance().setToken(data.token);
                        AccountManager.getInstance().setUserType(data.user_type);
                        viewHolder.showSuccessToast("登录成功");
                        viewHolder.goBack();
                    }
                } else {
                    viewHolder.showErrorToast(registerResult.getReturnMessage());
                }
            }

            @Override
            public void onError(BaseResult.Error error) {
                viewHolder.showErrorToast(error.errorMessage);
            }
        });
    }
}
