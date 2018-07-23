package com.hongyan.wdcf.business.teacher.subscribe;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;

public class ItemOrderC extends LinearLayout {
    private View view;
    private TextView tvOrderName;
    private TextView tvOrderType;
    private TextView tvOrderReason;

    public ItemOrderC(Context context) {
        this(context, null);
    }

    public ItemOrderC(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_order_c, this, true);
        tvOrderName = view.findViewById(R.id.tv_order_name);
        tvOrderType = view.findViewById(R.id.tv_order_type);
        tvOrderReason = view.findViewById(R.id.tv_order_reason);
    }

    public void setName(String name) {
        tvOrderName.setText(name);
    }

    public void setType(String type) {
        tvOrderType.setText(type);
    }

    public void setResponse(String time) {
        tvOrderReason.setText(time);
    }

}
