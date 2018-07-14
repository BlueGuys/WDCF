package com.hongyan.base.tab;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TabContainer extends LinearLayout {

    private Context mContext;

    private List<Tab> tabList = new ArrayList<>();
    private OnSelectChangeListener onSelectChangeListener;

    public TabContainer(Context context) {
        this(context, null);
    }

    public TabContainer(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabContainer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    public void addTab(Tab tab) {
        tabList.add(tab);
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        removeAllViews();
        for (int i = 0; i < tabList.size(); i++) {
            Tab tab = tabList.get(i);
            LinearLayout tabView = createTabView(tab);
            final int finalI = i;
            tabView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onSelectChangeListener != null) {
                        onSelectChangeListener.onChange(finalI);
                    }
                }
            });
            addView(tabView);
        }
    }

    public LinearLayout createTabView(Tab tab) {
        LinearLayout tabView = new LinearLayout(mContext);
        tabView.setOrientation(VERTICAL);
        tabView.setGravity(Gravity.CENTER);
        tabView.setPadding(0, 0, 0, 0);
        tabView.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));

        ImageView image = new ImageView(mContext);
        image.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0, 2.0f));

        TextView textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setText(tab.text);
        textView.setTextSize(11);
        textView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1.0f));

        if (tab.isSelected) {
            image.setImageResource(tab.drawable[0]);
        } else {
            image.setImageResource(tab.drawable[1]);
        }
        tabView.addView(image);
        tabView.addView(textView);
        return tabView;
    }


    public static final class Tab {
        int[] drawable;
        String text;
        boolean isSelected;
    }

    public Tab newTab() {
        return new Tab();
    }

    public void setOnSelectChangeListener(OnSelectChangeListener listener) {
        this.onSelectChangeListener = listener;
    }

    interface OnSelectChangeListener {
        void onChange(int position);
    }
}
