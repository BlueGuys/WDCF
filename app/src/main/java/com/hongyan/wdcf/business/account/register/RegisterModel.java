package com.hongyan.wdcf.business.account.register;

import android.util.Log;

import com.hongyan.base.BaseError;
import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.NetworkCall;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class RegisterModel extends BaseModel {

    public void startRegister() {
        NetworkCall networkCall = new NetworkCall<>();
        networkCall.setRequestUrl(UrlConst.getRegisterUrl());
        networkCall.setResultClass(RegisterResult.class);
        networkCall.addParam("", "");
        networkCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                RegisterResult registerResult = (RegisterResult) result;

            }

            @Override
            public void onError(BaseError error) {
                Log.e("test", error.toString());
            }
        });
    }

}
