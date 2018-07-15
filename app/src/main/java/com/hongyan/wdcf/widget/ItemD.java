package com.hongyan.wdcf.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;

public class ItemD extends LinearLayout {
    private View view;
    private EditText editText;
    private TextView tvDesc;

    public ItemD(Context context) {
        super(context);
    }

    public ItemD(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_d, this, true);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        ImageView imageLeft = view.findViewById(R.id.img_left);
        editText = view.findViewById(R.id.et_text);
        tvDesc = view.findViewById(R.id.tv_desc);
        @SuppressLint("Recycle") TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ItemD);
        Drawable drawable = ta.getDrawable(R.styleable.ItemD_image);
        String hint = ta.getString(R.styleable.ItemD_hint);
        String desc = ta.getString(R.styleable.ItemD_desc);
        imageLeft.setImageDrawable(drawable);
        editText.setHint(hint);
        tvDesc.setText(desc);
    }

    public String getEditContent() {
        String content = null;
        if (editText != null) {
            content = editText.getEditableText().toString();
        }
        return content;
    }

    public void setDesc(String desc) {
        if (tvDesc != null) {
            tvDesc.setText(desc);
        }
    }

    public TextView getDescTextView() {
        return tvDesc;
    }
}
