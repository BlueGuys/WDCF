package com.hongyan.wdcf.business.main.service;

import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.business.main.discover.DiscoverFragment;
import com.hongyan.wdcf.business.main.discover.DiscoverResult;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/11.
 */

public class ActivityModel {

    private ActivityFragment fragment;

    public ActivityModel(ActivityFragment fragment) {
        this.fragment = fragment;
    }

    protected void requestDiscoverData() {
        WDNetworkCall userInfoCall = new WDNetworkCall<>();
        userInfoCall.setRequestUrl(UrlConst.getActivityUrl());
        userInfoCall.setResultClass(ActivityResult.class);
        userInfoCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                ActivityResult activityResult = (ActivityResult) result;
                if (activityResult.isSuccessful()) {
                    ActivityResult.Data data = activityResult.data;
                    if (data == null) {
                        return;
                    }
                    fragment.setData(data);
                }
            }

            @Override
            public void onError(BaseResult.Error error) {

            }
        });
    }
}
