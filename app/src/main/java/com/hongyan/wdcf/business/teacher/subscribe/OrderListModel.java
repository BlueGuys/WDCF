package com.hongyan.wdcf.business.teacher.subscribe;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.business.teacher.customer.CustomerListResult;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class OrderListModel extends BaseModel {

    private UIRequestListener mListener;
    private String status;

    public OrderListModel(UIRequestListener listener) {
        this.mListener = listener;
    }

    public void refresh() {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getSubcribeOrderListUrl());
        feedbackCall.addParam(RequestKeyTable.STATUS,status);
        feedbackCall.setResultClass(SubscribeResult.class);
        feedbackCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                if (mListener != null) {
                    mListener.onSuccess(result);
                }
            }

            @Override
            public void onError(BaseResult.Error error) {
                if (mListener != null) {
                    mListener.onFailed();
                }
            }
        });
    }

    public interface UIRequestListener {
        void onSuccess(BaseResult result);

        void onFailed();
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
