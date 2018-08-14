package com.hongyan.wdcf.business.teacher.invite;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class ShareModel extends BaseModel {

    private UIRequestListener mListener;

    public ShareModel(UIRequestListener listener) {
        this.mListener = listener;
    }

    public void refresh() {
        WDNetworkCall orderListCall = new WDNetworkCall<>();
        orderListCall.setRequestUrl(UrlConst.getTeacherShareUrl());
        orderListCall.setResultClass(ShareResult.class);
        orderListCall.start(new RequestListener() {
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
