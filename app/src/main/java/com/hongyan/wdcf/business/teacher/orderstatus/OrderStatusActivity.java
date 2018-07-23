package com.hongyan.wdcf.business.teacher.orderstatus;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.base.RequestKeyTable;

public class OrderStatusActivity extends BaseActivity {

    private OrderStatusHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        holder = new OrderStatusHolder(this);
        return holder;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (holder != null) {
            holder.setOrderID(getParam(RequestKeyTable.ID));
        }
    }
}
