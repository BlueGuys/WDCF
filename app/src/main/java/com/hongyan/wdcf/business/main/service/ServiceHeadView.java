package com.hongyan.wdcf.business.main.service;

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

public class ServiceHeadView extends LinearLayout {

    private View view;
    private TextView textView01;
    private TextView textView02;
    private TextView textView03;

    public ServiceHeadView(Context context) {
        super(context);
    }

    public ServiceHeadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.view_service_headview, this, true);
        initView();
    }

    private void initView() {
        textView01 = view.findViewById(R.id.textView_01);
        textView02 = view.findViewById(R.id.textView_02);
        textView03 = view.findViewById(R.id.textView_03);
        select(0);
    }

    protected void select(int index) {
        switch (index) {
            case 0:
                textView01.setTextColor(getResources().getColor(R.color.fontPositive));
                textView02.setTextColor(getResources().getColor(R.color.white));
                textView03.setTextColor(getResources().getColor(R.color.white));
                textView01.setBackgroundResource(R.drawable.bg_left_white);
                textView02.setBackgroundResource(R.drawable.bg_white_stroke);
                textView03.setBackgroundResource(R.drawable.bg_right_white_stroke);
                break;
            case 1:
                textView01.setTextColor(getResources().getColor(R.color.white));
                textView02.setTextColor(getResources().getColor(R.color.fontPositive));
                textView03.setTextColor(getResources().getColor(R.color.white));
                textView01.setBackgroundResource(R.drawable.bg_left_white_stroke);
                textView02.setBackgroundResource(R.color.white);
                textView03.setBackgroundResource(R.drawable.bg_right_white_stroke);
                break;
            case 2:
                textView01.setTextColor(getResources().getColor(R.color.white));
                textView02.setTextColor(getResources().getColor(R.color.white));
                textView03.setTextColor(getResources().getColor(R.color.fontPositive));
                textView01.setBackgroundResource(R.drawable.bg_left_white_stroke);
                textView02.setBackgroundResource(R.drawable.bg_white_stroke);
                textView03.setBackgroundResource(R.drawable.bg_right_white);
                break;
        }
    }
}
