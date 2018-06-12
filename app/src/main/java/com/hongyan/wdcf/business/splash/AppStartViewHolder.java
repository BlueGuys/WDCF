package com.hongyan.wdcf.business.splash;

import android.view.View;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;

/**
 * Created by wangning on 2018/6/10.
 */

public class AppStartViewHolder extends BaseViewHolder {

    AppStartViewHolder(BaseActivity activity) {
        super(activity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_start;
    }

    @Override
    protected int getNavigationTitle() {
        return R.string.app_name;
    }

    @Override
    protected RequestBean getRequestBean() {
        return null;
    }

    @Override
    protected <T extends BaseResult> void onRequestSuccess(T result) {
    }

    @Override
    protected void initView(View rootView) {
    }

    @Override
    protected boolean hideNavigationView() {
        return true;
    }
}
