package com.hongyan.wdcf.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;


/**
 * Created by wangning on 2018/7/10.
 */

public class ItemB extends LinearLayout {

    private View view;
    TextView tvTitle;
    TextView tvDesc;
    ImageView imgArrow;

    public ItemB(Context context) {
        super(context);
    }

    public ItemB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_b, this, true);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        tvTitle = view.findViewById(R.id.tv_title);
        tvDesc = view.findViewById(R.id.tv_desc);
        imgArrow = view.findViewById(R.id.img_arrow);
        @SuppressLint("Recycle") TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ItemB);
        String title = ta.getString(R.styleable.ItemB_title);
        String desc = ta.getString(R.styleable.ItemB_desc);
        tvTitle.setText(title);
        tvDesc.setText(desc);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setDesc(String desc) {
        tvDesc.setText(desc);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        imgArrow.setVisibility(enabled ? View.VISIBLE : View.GONE);
    }
}
