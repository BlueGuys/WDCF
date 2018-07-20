package com.hongyan.wdcf.business.account.invite;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.business.main.discover.DiscoverResult;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class InviteModel extends BaseModel {

    private InviteHolder viewHolder;

    public InviteModel(InviteHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void commit(String content, String email) {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getFeedbackUrl());
        feedbackCall.setResultClass(DiscoverResult.class);
        feedbackCall.addParam(RequestKeyTable.CONTENT, content);
        feedbackCall.addParam(RequestKeyTable.EMAIL, email);
        feedbackCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                DiscoverResult discoverResult = (DiscoverResult) result;
                if (discoverResult.isSuccessful()) {
                    viewHolder.showSuccessToast("提交成功");
                    viewHolder.goBack();
                }
            }

            @Override
            public void onError(BaseResult.Error error) {

            }
        });
    }
}
