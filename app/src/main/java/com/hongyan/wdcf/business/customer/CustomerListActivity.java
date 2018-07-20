package com.hongyan.wdcf.business.customer;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class CustomerListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new CustomerListHolder(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startRequestPageData();
    }
}
