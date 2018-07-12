package com.hongyan.wdcf.business.main.discover;

import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/11.
 */

public class DiscoverModel {

    private DiscoverFragment fragment;

    public DiscoverModel(DiscoverFragment fragment) {
        this.fragment = fragment;
    }

    protected void requestDiscoverData() {
        WDNetworkCall userInfoCall = new WDNetworkCall<>();
        userInfoCall.setRequestUrl(UrlConst.getDiscoverUrl());
        userInfoCall.setResultClass(DiscoverResult.class);
        userInfoCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                DiscoverResult discoverResult = (DiscoverResult) result;
                if (discoverResult.isSuccessful()) {
                    DiscoverResult.Data data = discoverResult.data;
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
