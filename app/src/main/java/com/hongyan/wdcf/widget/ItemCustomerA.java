package com.hongyan.wdcf.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.StringUtils;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ItemCustomerA extends LinearLayout {
    private View view;
    private ImageView imageLogo;
    private ImageView imageCall;
    private TextView tvCustomerName;
    private TextView tvCustomerMobile;

    private OnCallClickListener callClickListener;

    public ItemCustomerA(Context context) {
        this(context, null);
    }

    public ItemCustomerA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_customer_a, this, true);
        imageLogo = view.findViewById(R.id.image_logo);
        tvCustomerName = view.findViewById(R.id.tv_customer_name);
        tvCustomerMobile = view.findViewById(R.id.tv_customer_mobile);
        ImageView imgCall = view.findViewById(R.id.img_call);
        imgCall.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callClickListener != null) {
                    callClickListener.onClick();
                }
            }
        });
    }

    public void setName(String name) {
        tvCustomerName.setText(name);
    }

    public void setMobile(String mobile) {
        tvCustomerMobile.setText(mobile);
    }

    public void setUrl(String url) {
        DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getAvatarImageOption();
        ImageLoader.getInstance().displayImage(url, imageLogo, options);
    }

    public interface OnCallClickListener {
        void onClick();
    }

    public void setCallClickListener(OnCallClickListener callClickListener) {
        this.callClickListener = callClickListener;
    }
}
