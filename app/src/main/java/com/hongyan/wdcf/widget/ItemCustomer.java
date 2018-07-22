package com.hongyan.wdcf.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;

public class ItemCustomer extends LinearLayout {
    private View view;
    private TextView tvCustomerName;
    private TextView tvCustomerLevel;
    private TextView tvCustomerMobile;

    private OnEditClickListener editClickListener;
    private OnCallClickListener callClickListener;

    public ItemCustomer(Context context) {
        this(context, null);
    }

    public ItemCustomer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_customer, this, true);
        tvCustomerName = view.findViewById(R.id.tv_customer_name);
        tvCustomerLevel = view.findViewById(R.id.tv_customer_level);
        tvCustomerMobile = view.findViewById(R.id.tv_customer_phone);
        ImageView imgCall = view.findViewById(R.id.img_call);
        ImageView imgEdit = view.findViewById(R.id.img_edit);
        imgCall.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callClickListener != null) {
                    callClickListener.onClick();
                }
            }
        });
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
        tvCustomerName.setText(name);
    }

    public void setMobile(String mobile) {
        tvCustomerMobile.setText(mobile);
    }

    public void setLevel(String level) {
        tvCustomerLevel.setText(level);
    }

    public interface OnCallClickListener {
        void onClick();
    }

    public interface OnEditClickListener {
        void onClick();
    }

    public void setEditClickListener(OnEditClickListener editClickListener) {
        this.editClickListener = editClickListener;
    }

    public void setCallClickListener(OnCallClickListener callClickListener) {
        this.callClickListener = callClickListener;
    }
}
