package com.hongyan.wdcf.business.login;

import android.view.View;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.CommonViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.main.MainResult;

/**
 * Created by wangning on 2018/6/10.
 */

public class LoginViewHolder extends CommonViewHolder {

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
    public boolean needPageRequest() {
        return false;
    }

    @Override
    protected void initView(View rootView) {
    }
}
