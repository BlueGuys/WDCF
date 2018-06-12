package com.hongyan.base;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Dimension;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hongyan.lib_base.R;


/**
 * com.jp.views.NavigationView
 *
 * @author wangning
 * @version 2.1.0
 * @date 2017/7/5:08:28
 * @desc
 */
public class NavigationView extends LinearLayout {

    private Context mContext;
    private RelativeLayout mLeftLayout;
    private RelativeLayout mCenterLayout;
    private RelativeLayout mRightLayout;
    private TextView textView;

    public NavigationView(Context context) {
        super(context);
        initView(context);
    }

    public NavigationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public NavigationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    protected void initView(Context context) {
        this.mContext = context;
        setBackgroundColor(Color.WHITE);
        View view = View.inflate(context, R.layout.view_navigation, this);
        mLeftLayout = view.findViewById(R.id.layout_left);
        mCenterLayout = view.findViewById(R.id.layout_center);
        mRightLayout = view.findViewById(R.id.layout_right);
        textView = view.findViewById(R.id.title);
    }

    public void setTitle(String title) {
        textView.setText(title);
    }

    public void addLeftButton(int buttonResId, final View.OnClickListener listener) {
        if (mLeftLayout != null) {
            mLeftLayout.removeAllViews();
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(buttonResId);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(80, 80);
            imageView.setLayoutParams(params);
            mLeftLayout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClick(v);
                    }
                }
            });
            mLeftLayout.addView(imageView);
        }
    }

}
