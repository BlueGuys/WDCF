package com.hongyan.wdcf.business.account.order;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;


/**
 * Created by wangning on 2018/7/10.
 */

public class OrderListIndicator extends LinearLayout {

    private View view;
    private TextView textView01;
    private TextView textView02;
    private TextView textView03;
    private View view01;
    private View view02;
    private View view03;

    public OrderListIndicator(Context context) {
        super(context);
    }

    public OrderListIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.view_order_list_indicator, this, true);
        initView();
    }

    private void initView() {
        textView01 = view.findViewById(R.id.textView_01);
        textView02 = view.findViewById(R.id.textView_02);
        textView03 = view.findViewById(R.id.textView_03);
        view01 = view.findViewById(R.id.view_01);
        view02 = view.findViewById(R.id.view_02);
        view03 = view.findViewById(R.id.view_03);
        textView01.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuClickListener != null) {
                    menuClickListener.onSelect(0);
                }
                select(0);
            }
        });
        textView02.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuClickListener != null) {
                    menuClickListener.onSelect(1);
                }
                select(1);
            }
        });
        textView03.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuClickListener != null) {
                    menuClickListener.onSelect(2);
                }
                select(2);
            }
        });
        select(0);
    }

    protected void select(int index) {
        switch (index) {
            case 0:
                textView01.setTextColor(getResources().getColor(R.color.fontPositive));
                textView02.setTextColor(getResources().getColor(R.color.fontNegative));
                textView03.setTextColor(getResources().getColor(R.color.fontNegative));
                view01.setVisibility(View.VISIBLE);
                view02.setVisibility(View.GONE);
                view03.setVisibility(View.GONE);
                break;
            case 1:
                textView01.setTextColor(getResources().getColor(R.color.fontNegative));
                textView02.setTextColor(getResources().getColor(R.color.fontPositive));
                textView03.setTextColor(getResources().getColor(R.color.fontNegative));
                view01.setVisibility(View.GONE);
                view02.setVisibility(View.VISIBLE);
                view03.setVisibility(View.GONE);
                break;
            case 2:
                textView01.setTextColor(getResources().getColor(R.color.fontNegative));
                textView02.setTextColor(getResources().getColor(R.color.fontNegative));
                textView03.setTextColor(getResources().getColor(R.color.fontPositive));
                view01.setVisibility(View.GONE);
                view02.setVisibility(View.GONE);
                view03.setVisibility(View.VISIBLE);
                break;
        }
    }

    private OnMenuClickListener menuClickListener;

    public void setOnMenuClickListener(OnMenuClickListener listener) {
        this.menuClickListener = listener;
    }

    interface OnMenuClickListener {
        void onSelect(int position);
    }
}
