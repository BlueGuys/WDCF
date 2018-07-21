package com.hongyan.wdcf.business.teacher.customer;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.business.account.feedback.FeedbackHolder;
import com.hongyan.wdcf.business.main.discover.DiscoverResult;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class CustomerListModel extends BaseModel {

    private UIRequestListener mListener;

    public CustomerListModel(UIRequestListener listener) {
        this.mListener = listener;
    }

    public void refresh(boolean isAll) {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getCustomerListUrl());
        feedbackCall.setResultClass(CustomerListResult.class);
        feedbackCall.addParam(RequestKeyTable.IS_INVEST, isAll ? "0" : "1");
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
}
