package com.hongyan.wdcf.business.account.bankcard;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class BankCardListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new BankCardListHolder(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startRequestPageData();
    }
}
