package com.hongyan.wdcf.business.account.modifytradepassword;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.business.main.discover.DiscoverResult;
import com.hongyan.wdcf.config.UrlConst;

public class ModifyTradePasswordModel extends BaseModel {
    private ModifyTradePasswordHolder viewHolder;

    public ModifyTradePasswordModel(ModifyTradePasswordHolder viewHolder) {
        this.viewHolder = viewHolder;
    }
    public void getCheckCode(String phone) {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getCheckCodeUrl());
        feedbackCall.setResultClass(DiscoverResult.class);
        feedbackCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                DiscoverResult discoverResult = (DiscoverResult) result;
                if (discoverResult.isSuccessful()) {
                    viewHolder.showSuccessToast("验证码发送成功");
                    viewHolder.startTimer();
                }
                viewHolder.getActivity().cancelLoading();
            }

            @Override
            public void onError(BaseResult.Error error) {
                viewHolder.getActivity().cancelLoading();
                viewHolder.showSuccessToast(error.errorCode + " " +error.errorMessage);
            }
        });
    }

    public void confirm(String checkcode, String newpassword) {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getModifyTradePasswordUrl());
        feedbackCall.setResultClass(DiscoverResult.class);
        feedbackCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                DiscoverResult discoverResult = (DiscoverResult) result;
                if (discoverResult.isSuccessful()) {
                    viewHolder.showSuccessToast("修改成功");
                    viewHolder.goBack();
                }
                viewHolder.getActivity().cancelLoading();
            }

            @Override
            public void onError(BaseResult.Error error) {
                viewHolder.getActivity().cancelLoading();
                viewHolder.showSuccessToast(error.errorCode + " " +error.errorMessage);
            }
        });
    }
}
