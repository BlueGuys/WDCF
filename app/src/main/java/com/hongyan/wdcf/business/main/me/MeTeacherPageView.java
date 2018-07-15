package com.hongyan.wdcf.business.main.me;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wangning on 2018/7/10.
 */

public class MeTeacherPageView extends LinearLayout implements View.OnClickListener {

    private View view;
    TextView tvUserPhone;

    public MeTeacherPageView(Context context) {
        super(context);
        view = LayoutInflater.from(context).inflate(R.layout.view_me_teacher, this, true);
        LinearLayout layout01 = view.findViewById(R.id.layout_01);
        LinearLayout layout02 = view.findViewById(R.id.layout_02);
        LinearLayout layout03 = view.findViewById(R.id.layout_03);
        LinearLayout layout04 = view.findViewById(R.id.layout_04);
        ImageView imageLogo = view.findViewById(R.id.image_logo);
        TextView tvUserName = view.findViewById(R.id.tv_userName);
        tvUserPhone = view.findViewById(R.id.tv_userPhone);
        layout01.setOnClickListener(this);
        layout02.setOnClickListener(this);
        layout03.setOnClickListener(this);
        layout04.setOnClickListener(this);

        AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
        if (accountInfo != null) {
            tvUserPhone.setText(accountInfo.getUIMobile());
            tvUserName.setText(accountInfo.getUser_nicename());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_01:
                break;
            case R.id.layout_02:
                break;
            case R.id.layout_03:
                break;
            case R.id.layout_04:
                break;
        }
    }
}
