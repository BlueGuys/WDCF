package com.hongyan.wdcf.business.login;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean needPageRequest() {
        return true;
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new LoginViewHolder(this);
    }
}
