package com.hongyan.wdcf.business.account.order;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;

public class ItemOrderActivity extends LinearLayout {
    private View view;
    private TextView tvOrderTitle;
    private TextView tvOrderDesc;
    private TextView tvOrderTime;
    private TextView tvOrderStatus;


    public ItemOrderActivity(Context context) {
        this(context, null);
    }

    public ItemOrderActivity(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_order_activity, this, true);
        tvOrderTitle = view.findViewById(R.id.tv_order_title);
        tvOrderDesc = view.findViewById(R.id.tv_order_desc);
        tvOrderTime = view.findViewById(R.id.tv_order_time);
        tvOrderStatus = view.findViewById(R.id.tv_order_status);
    }

    public void setTitle(String title) {
        tvOrderTitle.setText(title);
    }

    public void setDesc(String desc) {
        tvOrderDesc.setText(desc);
    }

    public void setTime(String time) {
        tvOrderTime.setText(time);
    }

    public void setStatus(String status) {
        tvOrderStatus.setText(status);
    }
}
