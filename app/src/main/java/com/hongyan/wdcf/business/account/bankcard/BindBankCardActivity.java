package com.hongyan.wdcf.business.account.bankcard;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class BindBankCardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new BindBankCardHolder(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
