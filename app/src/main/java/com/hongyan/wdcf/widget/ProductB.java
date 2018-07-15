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
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;


/**
 * Created by wangning on 2018/7/10.
 */

public class ProductB extends LinearLayout {

    private View view;

    private ImageView image;
    private TextView tvDesc;
    private TextView tvLabel1;
    private TextView tvLabel2;
    private TextView tvLabel3;
    private TextView tvDeadLine;
    private TextView tvAmount;


    public ProductB(Context context) {
        super(context);
    }

    public ProductB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.view_product_private, this, true);
        image = view.findViewById(R.id.image_photo);
        tvDesc = view.findViewById(R.id.tv_desc);
        tvLabel1 = view.findViewById(R.id.tv_label1);
        tvLabel2 = view.findViewById(R.id.tv_label2);
        tvLabel3 = view.findViewById(R.id.tv_label3);
        tvDeadLine = view.findViewById(R.id.tv_deadline);
        tvAmount = view.findViewById(R.id.tv_amount);
    }

    public void setImgUrl(String imgUrl) {
        DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCommonImageOption();
        ImageLoader.getInstance().displayImage(imgUrl, image, options);
    }

    public void setDesc(String desc) {
        tvDesc.setText(desc);
    }

    public void setLabel1(String label1) {
        tvLabel1.setText(label1);
    }

    public void setLabel2(String label2) {
        tvLabel2.setText(label2);
    }

    public void setLabel3(String label3) {
        tvLabel3.setText(label3);
    }

    public void setDeadLine(String deadLine) {
        tvDeadLine.setText(deadLine);
    }

    public void setAmount(String amount) {
        tvAmount.setText(amount);
    }
}
