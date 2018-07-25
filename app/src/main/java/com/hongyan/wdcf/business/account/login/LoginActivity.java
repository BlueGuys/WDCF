package com.hongyan.wdcf.business.account.login;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.business.account.core.MainMessageEvent;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new LoginHolder(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EventBus.getDefault().post(new MainMessageEvent(0));
    }
}
