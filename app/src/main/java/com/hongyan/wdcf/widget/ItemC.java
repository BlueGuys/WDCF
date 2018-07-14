package com.hongyan.wdcf.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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

public class ItemC extends LinearLayout {

    private View view;

    public ItemC(Context context) {
        super(context);
    }

    public ItemC(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_c, this, true);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TextView tvTitle = view.findViewById(R.id.tv_title);
        ImageView imageLeft = view.findViewById(R.id.img_left);
        @SuppressLint("Recycle") TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ItemC);
        String title = ta.getString(R.styleable.ItemC_title);

        Drawable drawable = ta.getDrawable(R.styleable.ItemC_image);
        tvTitle.setText(title);
        imageLeft.setImageDrawable(drawable);
    }
}
