package com.hongyan.wdcf.business.teacher.customer;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class CustomerListModel extends BaseModel {

    private UIRequestListener mListener;
    private String searchKey = "";
    private WDNetworkCall feedbackCall;

    public CustomerListModel(UIRequestListener listener) {
        this.mListener = listener;
        feedbackCall = new WDNetworkCall<>();
    }

    public void refresh(boolean isAll) {
        feedbackCall.setRequestUrl(UrlConst.getCustomerListUrl());
        feedbackCall.setResultClass(CustomerListResult.class);
        feedbackCall.addParam(RequestKeyTable.IS_INVEST, isAll ? "0" : "1");
        feedbackCall.addParam(RequestKeyTable.SEARCH_WORD, searchKey);
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

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public interface UIRequestListener {
        void onSuccess(BaseResult result);

        void onFailed();
    }
}
