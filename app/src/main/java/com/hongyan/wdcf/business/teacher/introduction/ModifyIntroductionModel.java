package com.hongyan.wdcf.business.teacher.introduction;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.business.main.discover.DiscoverResult;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class ModifyIntroductionModel extends BaseModel {

    private ModifyIntroductionHolder viewHolder;

    public ModifyIntroductionModel(ModifyIntroductionHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void commit(String content) {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getEditUserUrl());
        feedbackCall.setResultClass(ModifyIntroductionResult.class);
        feedbackCall.addParam(RequestKeyTable.CONTENT, content);
        feedbackCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                ModifyIntroductionResult modifyIntroductionResult = (ModifyIntroductionResult) result;
                if (modifyIntroductionResult.isSuccessful()) {
                    viewHolder.showSuccessToast("提交成功");
                    AccountManager.getInstance().refresh();
                    viewHolder.goBack();
                } else {
                    viewHolder.showErrorToast(modifyIntroductionResult.getReturnMessage());
                }
            }

            @Override
            public void onError(BaseResult.Error error) {

            }
        });
    }
}
