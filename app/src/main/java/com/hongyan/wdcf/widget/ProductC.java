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

public class ProductC extends LinearLayout {

    private ImageView image;
    private TextView tvTitle;
    private TextView tvSubTitle;

    public ProductC(Context context) {
        this(context, null);
    }

    public ProductC(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.view_product_c, this, true);
        image = view.findViewById(R.id.image_photo);
        tvTitle = view.findViewById(R.id.tv_title);
        tvSubTitle = view.findViewById(R.id.tv_subTitle);
    }

    public void setImgUrl(String imgUrl) {
        DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCommonImageOption();
        ImageLoader.getInstance().displayImage(imgUrl, image, options);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setSubTitle(String subTitle) {
        tvSubTitle.setText(subTitle);
    }
}
