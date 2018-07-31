package com.hongyan.wdcf.business.teacher.activitydetail;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.base.RequestKeyTable;

public class ActivityDetailActivity extends BaseActivity {

    private ActivityDetailHolder orderDetailHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        orderDetailHolder = new ActivityDetailHolder(this);
        orderDetailHolder.setId(getParam(RequestKeyTable.ID));
        orderDetailHolder.setCreateTime(getParam(RequestKeyTable.CREATE_TIME));
        orderDetailHolder.setNumber(getParam(RequestKeyTable.NUMBER));
        orderDetailHolder.setStatusStr(getParam(RequestKeyTable.STATUS));
        orderDetailHolder.setTitle(getParam(RequestKeyTable.TITLE));
        return orderDetailHolder;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
