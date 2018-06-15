package com.hongyan.wdcf.business.login;

import android.view.View;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.main.MainResult;

/**
 * Created by wangning on 2018/6/10.
 */

public class LoginViewHolder extends BaseViewHolder {

    LoginViewHolder(BaseActivity activity) {
        super(activity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected int getNavigationTitle() {
        return R.string.login;
    }

    @Override
    protected boolean allowPullRefresh() {
        return true;
    }

    @Override
    protected boolean allowLoadMore() {
        return true;
    }

    @Override
    protected RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(MainResult.class);
        bean.setRequestUrl("http://www.xicaijing.com/Api/Digiccy/mylists.html");
        bean.addParam("sss", "ss");
        return bean;
    }

    @Override
    protected <T extends BaseResult> void onRequestSuccess(T result) {
        showSuccessToast("请求成功");
    }

    @Override
    protected void initView(View rootView) {
    }
}
