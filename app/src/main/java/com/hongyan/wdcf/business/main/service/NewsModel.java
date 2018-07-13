package com.hongyan.wdcf.business.main.service;

import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/11.
 */

public class NewsModel {

    private NewsFragment fragment;

    public NewsModel(NewsFragment fragment) {
        this.fragment = fragment;
    }

    protected void requestDiscoverData() {
        WDNetworkCall userInfoCall = new WDNetworkCall<>();
        userInfoCall.setRequestUrl(UrlConst.getNewsUrl());
        userInfoCall.setResultClass(NewsResult.class);
        userInfoCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                NewsResult newsResult = (NewsResult) result;
                if (newsResult.isSuccessful()) {
                    NewsResult.Data data = newsResult.data;
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
