package com.hongyan.wdcf.business.account.register;

import android.util.Log;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseError;
import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.EmptyResult;
import com.hongyan.base.NetworkCall;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class RegisterModel extends BaseModel {

    private RegisterHolder viewHolder;

    public RegisterModel(RegisterHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void startRegister(String mobilePhone, String password, String verifyCode) {
        NetworkCall registerCall = new NetworkCall<>();
        registerCall.setRequestUrl(UrlConst.getRegisterUrl());
        registerCall.setResultClass(RegisterResult.class);
        registerCall.addParam(RequestKeyTable.MOBILE, mobilePhone);
        registerCall.addParam(RequestKeyTable.PASSWORD, password);
        registerCall.addParam(RequestKeyTable.YZM, verifyCode);
        registerCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                RegisterResult registerResult = (RegisterResult) result;
                if (registerResult.isSuccessful()) {
                    RegisterResult.Data data = registerResult.data;
                    if (data != null) {
                        AccountManager.getInstance().setToken(data.token);
                    }
                }
            }

            @Override
            public void onError(BaseError error) {
                Log.e("test", error.toString());
            }
        });
    }

    public void sendCodeRequest(String mobileNumber) {
        viewHolder.startLoading();
        NetworkCall codeCall = new NetworkCall<>();
        codeCall.setRequestUrl(UrlConst.getSendCodeUrl());
        codeCall.setResultClass(EmptyResult.class);
        codeCall.addParam(RequestKeyTable.MOBILE, mobileNumber);
        codeCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                viewHolder.cancelLoading();
                EmptyResult emptyResult = (EmptyResult) result;
                if (emptyResult != null && emptyResult.isSuccessful()) {
                    viewHolder.showSuccessToast("发送成功");
                }
            }

            @Override
            public void onError(BaseError error) {
                viewHolder.cancelLoading();
                Log.e("test", error.toString());
            }
        });
    }

}
