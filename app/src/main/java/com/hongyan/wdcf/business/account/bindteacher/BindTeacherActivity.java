package com.hongyan.wdcf.business.account.bindteacher;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

public class BindTeacherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new BindTeacherHolder(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startRequestPageData();
    }
}
