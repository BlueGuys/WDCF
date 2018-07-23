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

public class ItemOrderA extends LinearLayout {
    private View view;
    private TextView tvOrderName;
    private TextView tvOrderType;
    private TextView tvOrderTime;

    private OnEditClickListener editClickListener;

    public ItemOrderA(Context context) {
        this(context, null);
    }

    public ItemOrderA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_order_a, this, true);
        tvOrderName = view.findViewById(R.id.tv_order_name);
        tvOrderType = view.findViewById(R.id.tv_order_type);
        tvOrderTime = view.findViewById(R.id.tv_order_time);
        ImageView imgEdit = view.findViewById(R.id.img_edit);
        imgEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editClickListener != null) {
                    editClickListener.onClick();
                }
            }
        });
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

    public interface OnEditClickListener {
        void onClick();
    }

    public void setEditClickListener(OnEditClickListener editClickListener) {
        this.editClickListener = editClickListener;
    }
}
