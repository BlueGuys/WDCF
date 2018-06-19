package com.hongyan.wdcf.business.main;

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

public class MainViewHolder extends BaseViewHolder implements IViewHolder {


    public MainViewHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public int getLayoutType() {
        return IViewHolder.LAYOUT_TYPE_COMMON;
    }

    @Override
    public boolean needPageRequest() {
        return true;
    }

    @Override
    public void initView(View rootView) {

    }

    @Override
    public int getNavigationTitle() {
        return 0;
    }

    @Override
    public RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(MainResult.class);
        bean.setRequestUrl("http://www.xicaijing.com/Api/Digiccy/mylists.html");
        bean.addParam("sss", "ss");
        return bean;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
        showSuccessToast("请求成功111");
    }

    @Override
    public boolean onRequestFail() {
        return false;
    }
}
