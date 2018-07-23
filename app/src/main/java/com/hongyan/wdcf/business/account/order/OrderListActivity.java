package com.hongyan.wdcf.business.account.order;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class OrderListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new OrderListHolder(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
