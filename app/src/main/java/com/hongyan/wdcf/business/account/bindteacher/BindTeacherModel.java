package com.hongyan.wdcf.business.account.bindteacher;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class BindTeacherModel extends BaseModel {

    private BindTeacherHolder viewHolder;

    public BindTeacherModel(BindTeacherHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void commit(String code) {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getBindTeacherUrl());
        feedbackCall.addParam(RequestKeyTable.MOBILE, code);
        feedbackCall.setResultClass(BindTeacherResult.class);
        feedbackCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                BindTeacherResult bindTeacherResult = (BindTeacherResult) result;
                if (bindTeacherResult.isSuccessful()) {
                    viewHolder.showSuccessToast("提交成功");
                }
            }

            @Override
            public void onError(BaseResult.Error error) {
                viewHolder.showSuccessToast("提交失败");
            }
        });
    }

}
