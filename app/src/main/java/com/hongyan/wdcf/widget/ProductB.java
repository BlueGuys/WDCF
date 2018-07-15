package com.hongyan.wdcf.widget;

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

public class ProductB extends LinearLayout {

    private View view;

    private String title;
    private String rate;
    private String status;
    private String amount;
    private String term;

    private TextView tvTitle;
    private TextView tvRate;
    private TextView tvStatus;
    private TextView tvAmount;
    private TextView tvTerm;

    public ProductB(Context context) {
        super(context);
    }

    public ProductB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.view_product_class, this, true);
        tvTitle = view.findViewById(R.id.tv_title);
        tvRate = view.findViewById(R.id.tv_rate);
        tvStatus = view.findViewById(R.id.tv_status);
        tvAmount = view.findViewById(R.id.tv_amount);
        tvTerm = view.findViewById(R.id.tv_term);
    }

    public void setTitle(String title) {
        this.title = title;
        tvTitle.setText(title);
    }

    public void setRate(String rate) {
        this.rate = rate;
        tvRate.setText(rate);
    }

    public void setStatus(String status) {
        this.status = status;
        tvStatus.setText(status);
    }

    public void setAmount(String amount) {
        this.amount = amount;
        tvAmount.setText(amount);
    }

    public void setTerm(String term) {
        this.term = term;
        tvTerm.setText(term);
    }
}
