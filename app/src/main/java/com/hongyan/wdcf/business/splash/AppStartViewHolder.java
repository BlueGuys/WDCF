package com.hongyan.wdcf.business.splash;

import android.view.View;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;

/**
 * Created by wangning on 2018/6/10.
 */

public class AppStartViewHolder extends BaseViewHolder implements IViewHolder {

    AppStartViewHolder(BaseActivity activity) {
        super(activity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_start;
    }

    @Override
    public RequestBean getRequestBean() {
        return null;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
    }

    @Override
    public boolean onRequestFail() {
        return false;
    }

    @Override
    protected boolean hideNavigationView() {
        return true;
    }


    @Override
    public int getLayoutType() {
        return IViewHolder.LAYOUT_TYPE_COMMON;
    }

    @Override
    public boolean needPageRequest() {
        return false;
    }

    @Override
    public void initView(View rootView) {

    }

    @Override
    public int getNavigationTitle() {
        return R.string.app_name;
    }
}
