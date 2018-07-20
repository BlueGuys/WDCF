package com.hongyan.wdcf.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.DisplayUtils;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by wangning on 2018/7/10.
 */

public class CommonIndicator extends LinearLayout {

    private int currentIndex;
    private Context mContext;
    private ArrayList<String> mTabList = new ArrayList<>();

    public CommonIndicator(Context context) {
        this(context, null);
    }

    public CommonIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setOrientation(HORIZONTAL);
    }

    public void setTab(String[] tabs) {
        if (tabs == null || tabs.length == 0) {
            return;
        }
        mTabList.addAll(Arrays.asList(tabs));
        notifyDataChanged();
    }

    private void notifyDataChanged() {
        removeAllViews();
        for (int i = 0; i < mTabList.size(); i++) {
            LinearLayout tab = createTabView(mTabList.get(i), i == currentIndex);
            final int finalI = i;
            tab.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onTabChangedListener == null) {
                        return;
                    }
                    onTabChangedListener.onSelect(finalI);
                }
            });
            addView(tab);
        }
    }

    private LinearLayout createTabView(String text, boolean isSeleted) {
        LinearLayout tabLayout = new LinearLayout(mContext);
        tabLayout.setOrientation(VERTICAL);
        tabLayout.setGravity(Gravity.CENTER);
        tabLayout.setPadding(0, 20, 0, 0);
        tabLayout.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));

        TextView textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setTextSize(11);
        textView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, DisplayUtils.dip2px(mContext, 30)));
        textView.setTextColor(isSeleted ? Color.parseColor("#66573e") : Color.parseColor("#000000"));
        tabLayout.addView(textView);

        View line = new View(mContext);
        line.setBackgroundColor(Color.parseColor("#66573e"));
        line.setLayoutParams(new LayoutParams(100, 5));
        line.setVisibility(isSeleted ? VISIBLE : INVISIBLE);
        tabLayout.addView(line);
        return tabLayout;
    }


    private OnTabChangedListener onTabChangedListener;

    public void setOnTabChangedListener(OnTabChangedListener listener) {
        this.onTabChangedListener = listener;
    }

    public void setCurrentTab(int position) {
        this.currentIndex = position;
        notifyDataChanged();
    }

    public interface OnTabChangedListener {
        void onSelect(int position);
    }
}
