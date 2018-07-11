package com.hongyan.wdcf.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
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

public class ItemA extends LinearLayout {

    private View view;

    public ItemA(Context context) {
        super(context);
    }

    public ItemA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_a, this, true);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvDesc = view.findViewById(R.id.tv_desc);
        @SuppressLint("Recycle") TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ItemA);
        String title = ta.getString(R.styleable.ItemA_title);
        String desc = ta.getString(R.styleable.ItemA_desc);
        tvTitle.setText(title);
        tvDesc.setText(desc);
    }
}
