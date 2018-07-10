package com.hongyan.wdcf.business.account;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;

/**
 * Created by wangning on 2018/7/10.
 */

public class IdentityView extends LinearLayout {

    private View view;
    private ImageButton image01;
    private ImageButton image02;
    private ImageButton image03;
    private TextView tip01;
    private TextView tip02;
    private TextView tip03;
    private TextView textView01;
    private TextView textView02;
    private TextView textView03;

    private int currentStep = 1;

    public IdentityView(Context context) {
        super(context);
    }

    public IdentityView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.view_identity, this, true);
        initView();
    }

    private void initView() {
        image01 = view.findViewById(R.id.image_01);
        image02 = view.findViewById(R.id.image_02);
        image03 = view.findViewById(R.id.image_03);
        tip01 = view.findViewById(R.id.tip_01);
        tip02 = view.findViewById(R.id.tip_02);
        tip03 = view.findViewById(R.id.tip_03);
        textView01 = view.findViewById(R.id.textView_01);
        textView02 = view.findViewById(R.id.textView_02);
        textView03 = view.findViewById(R.id.textView_03);
        setStep(currentStep);
    }

    public void setStep(int step) {
        this.currentStep = step;
        if (currentStep == 1) {
            image01.setBackgroundResource(R.drawable.icon_circle_yellow);
            image02.setBackgroundResource(R.drawable.icon_circle_gray);
            image03.setBackgroundResource(R.drawable.icon_circle_gray);
            tip01.setVisibility(View.GONE);
            tip02.setVisibility(View.VISIBLE);
            tip03.setVisibility(View.VISIBLE);
            textView01.setTextColor(getResources().getColor(R.color.appColorPositive));
            textView02.setTextColor(getResources().getColor(R.color.appColorNegative));
            textView03.setTextColor(getResources().getColor(R.color.appColorNegative));
        } else if (currentStep == 2) {
            image01.setBackgroundResource(R.drawable.icon_circle_gray);
            image02.setBackgroundResource(R.drawable.icon_circle_yellow);
            image03.setBackgroundResource(R.drawable.icon_circle_gray);
            tip01.setVisibility(View.VISIBLE);
            tip02.setVisibility(View.GONE);
            tip03.setVisibility(View.VISIBLE);
            textView01.setTextColor(getResources().getColor(R.color.appColorNegative));
            textView02.setTextColor(getResources().getColor(R.color.appColorPositive));
            textView03.setTextColor(getResources().getColor(R.color.appColorNegative));
        } else if (currentStep == 3) {
            image01.setBackgroundResource(R.drawable.icon_circle_gray);
            image02.setBackgroundResource(R.drawable.icon_circle_gray);
            image03.setBackgroundResource(R.drawable.icon_circle_yellow);
            tip01.setVisibility(View.VISIBLE);
            tip02.setVisibility(View.VISIBLE);
            tip03.setVisibility(View.GONE);
            textView01.setTextColor(getResources().getColor(R.color.appColorNegative));
            textView02.setTextColor(getResources().getColor(R.color.appColorNegative));
            textView03.setTextColor(getResources().getColor(R.color.appColorPositive));
        }
    }
}
