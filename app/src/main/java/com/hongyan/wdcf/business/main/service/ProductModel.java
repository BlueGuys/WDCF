package com.hongyan.wdcf.business.main.service;

import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/11.
 */

public class ProductModel {

    private ProductFragment fragment;

    public ProductModel(ProductFragment fragment) {
        this.fragment = fragment;
    }

    protected void request() {
        WDNetworkCall userInfoCall = new WDNetworkCall<>();
        userInfoCall.setRequestUrl(UrlConst.getProductListUrl());
        userInfoCall.setResultClass(ProductResult.class);
        userInfoCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                ProductResult productResult = (ProductResult) result;
                if (productResult.isSuccessful()) {
                    ProductResult.Data data = productResult.data;
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
