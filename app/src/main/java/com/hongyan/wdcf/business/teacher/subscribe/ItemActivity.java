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

public class ItemActivity extends LinearLayout {
    private View view;
    private TextView tvActivityTitle;
    private TextView tvActivityDesc;
    private TextView tvActivityTime;
    private TextView tvActivityStatus;

    private OnEditClickListener editClickListener;

    public ItemActivity(Context context) {
        this(context, null);
    }

    public ItemActivity(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_activity_list, this, true);
        tvActivityTitle = view.findViewById(R.id.tv_activity_title);
        tvActivityDesc = view.findViewById(R.id.tv_activity_number);
        tvActivityTime = view.findViewById(R.id.tv_activity_time);
        tvActivityStatus = view.findViewById(R.id.tv_activity_status);
    }

    public void setTitle(String name) {
        tvActivityTitle.setText(name);
    }

    public void setDesc(String type) {
        tvActivityDesc.setText(type);
    }

    public void setTime(String time) {
        tvActivityTime.setText(time);
    }

    public void setStatus(String time) {
        tvActivityStatus.setText(time);
    }

    public interface OnEditClickListener {
        void onClick();
    }
}
