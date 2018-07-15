package com.hongyan.wdcf.business.account.modifyloginpassword;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class ModifyLoginPasswordActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new ModifyLoginPasswordHolder(this);
    }
}
