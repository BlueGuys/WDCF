package com.hongyan.wdcf.business.main;


import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class MainActivity extends BaseActivity {

    @Override
    protected BaseViewHolder getViewHolder() {
        return new MainViewHolder(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
