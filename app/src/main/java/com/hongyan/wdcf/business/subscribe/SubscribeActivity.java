package com.hongyan.wdcf.business.subscribe;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class SubscribeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new SubscribeHolder(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startRequestPageData();
    }
}
