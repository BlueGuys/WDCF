package com.hongyan.wdcf.business.account.order;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.base.RequestKeyTable;

public class OrderDetailActivity extends BaseActivity {

    private OrderDetailHolder orderDetailHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        orderDetailHolder = new OrderDetailHolder(this);
        orderDetailHolder.setId(getParam(RequestKeyTable.ID));
        return orderDetailHolder;
    }

    @Override
    protected void onResume() {
        super.onResume();
        startRequestPageData();
    }
}
