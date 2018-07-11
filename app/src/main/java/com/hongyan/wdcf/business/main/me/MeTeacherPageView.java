package com.hongyan.wdcf.business.main.me;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.hongyan.wdcf.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wangning on 2018/7/10.
 */

public class MeTeacherPageView extends LinearLayout {

    private View view;

    public MeTeacherPageView(Context context) {
        super(context);
        view = LayoutInflater.from(context).inflate(R.layout.view_me_user, this, true);
        initView();
        String s = "11";
        try {
            JSONObject jsonObject = new JSONObject(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initView() {

    }
}
