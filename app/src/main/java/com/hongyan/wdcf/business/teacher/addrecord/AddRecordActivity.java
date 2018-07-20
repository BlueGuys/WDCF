package com.hongyan.wdcf.business.teacher.addrecord;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

/**
 * 增加沟通记录
 */
public class AddRecordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return new AddRecordHolder(this);
    }
}
