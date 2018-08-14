package com.hongyan.wdcf.base;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.NetworkCall;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.business.account.login.LoginResult;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class PDFModel extends BaseModel {

    private PDFHolder viewHolder;

    public PDFModel(PDFHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void login(String mobilePhone, String password) {
        viewHolder.startLoading();

    }
}
