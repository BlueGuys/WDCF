package com.hongyan.wdcf.business.product.equity;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class SimuListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new SimuListHolder(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startRequestPageData();
    }
}
