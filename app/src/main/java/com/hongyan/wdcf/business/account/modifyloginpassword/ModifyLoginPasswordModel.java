package com.hongyan.wdcf.business.account.modifyloginpassword;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.business.main.discover.DiscoverResult;
import com.hongyan.wdcf.config.UrlConst;

public class ModifyLoginPasswordModel extends BaseModel {
    private ModifyLoginPasswordHolder viewHolder;

    public ModifyLoginPasswordModel(ModifyLoginPasswordHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void confirm(String oldpassword, String newpassword) {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getModifyLoginPasswordUrl());
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
