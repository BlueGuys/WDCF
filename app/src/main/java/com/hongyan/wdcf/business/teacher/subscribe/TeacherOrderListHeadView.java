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


/**
 * Created by wangning on 2018/7/10.
 */

public class TeacherOrderListHeadView extends LinearLayout {

    private View view;
    private TextView textView01;
    private TextView textView02;
    private ImageView imageBack;

    public TeacherOrderListHeadView(Context context) {
        super(context);
    }

    public TeacherOrderListHeadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.view_teacher_order_headview, this, true);
        initView();
    }

    private void initView() {
        imageBack = view.findViewById(R.id.image_back);
        textView01 = view.findViewById(R.id.textView_01);
        textView02 = view.findViewById(R.id.textView_02);
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
        select(0);
        imageBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(backClickListener!=null){
                    backClickListener.onClick();
                }
            }
        });
    }

    protected void select(int index) {
        switch (index) {
            case 0:
                textView01.setTextColor(getResources().getColor(R.color.fontPositive));
                textView02.setTextColor(getResources().getColor(R.color.white));
                textView01.setBackgroundResource(R.drawable.bg_left_white);
                textView02.setBackgroundResource(R.drawable.bg_right_white_stroke);
                break;
            case 1:
                textView01.setTextColor(getResources().getColor(R.color.white));
                textView02.setTextColor(getResources().getColor(R.color.fontPositive));
                textView01.setBackgroundResource(R.drawable.bg_left_white_stroke);
                textView02.setBackgroundResource(R.drawable.bg_right_white);
                break;
        }
    }

    private OnMenuClickListener menuClickListener;
    private OnBackClickListener backClickListener;

    public void setOnMenuClickListener(OnMenuClickListener listener) {
        this.menuClickListener = listener;
    }

    public void setBackClickListener(OnBackClickListener backClickListener) {
        this.backClickListener = backClickListener;
    }

    interface OnMenuClickListener {
        void onSelect(int position);
    }

    interface OnBackClickListener {
        void onClick();
    }
}
