package com.hongyan.wdcf.business.teacher.subscribe;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;

public class ItemOrderB extends LinearLayout {
    private View view;
    private TextView tvOrderName;
    private TextView tvOrderType;
    private TextView tvOrderTime;

    public ItemOrderB(Context context) {
        this(context, null);
    }

    public ItemOrderB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_order_b, this, true);
        tvOrderName = view.findViewById(R.id.tv_order_name);
        tvOrderType = view.findViewById(R.id.tv_order_type);
        tvOrderTime = view.findViewById(R.id.tv_order_time);
    }

    public void setName(String name) {
        tvOrderName.setText(name);
    }

    public void setType(String type) {
        tvOrderType.setText(type);
    }

    public void setTime(String time) {
        tvOrderTime.setText(time);
    }
}
