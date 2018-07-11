package com.hongyan.wdcf.business.main.me;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;

/**
 * Created by wangning on 2018/7/10.
 */

public class MeUserPageView extends LinearLayout implements View.OnClickListener {

    private View view;
    TextView tvUserPhone;

    public MeUserPageView(Context context) {
        super(context);
        view = LayoutInflater.from(context).inflate(R.layout.view_me_user, this, true);
        initView();
    }

    private void initView() {
        RelativeLayout layoutHelper = view.findViewById(R.id.rl_help);
        RelativeLayout layoutFeedback = view.findViewById(R.id.rl_user_feedback);
        RelativeLayout layoutEvaluate = view.findViewById(R.id.rl_evaluate);
        RelativeLayout layoutAbout = view.findViewById(R.id.rl_about);
        LinearLayout layoutOrder = view.findViewById(R.id.ll_order);
        LinearLayout layoutRisk = view.findViewById(R.id.ll_risk);
        ImageView imageShare = view.findViewById(R.id.image_share);
        ImageView imageSetting = view.findViewById(R.id.image_setting);
        ImageView imageMessage = view.findViewById(R.id.image_message);
        TextView tvMember = view.findViewById(R.id.tv_member);
        LinearLayout layoutUser = view.findViewById(R.id.ll_user);
        ImageView imageLogo = view.findViewById(R.id.image_logo);
        TextView tvUserName = view.findViewById(R.id.tv_userName);
        tvUserPhone = view.findViewById(R.id.tv_userPhone);
        layoutHelper.setOnClickListener(this);
        layoutFeedback.setOnClickListener(this);
        layoutEvaluate.setOnClickListener(this);
        layoutAbout.setOnClickListener(this);
        layoutOrder.setOnClickListener(this);
        layoutRisk.setOnClickListener(this);
        imageShare.setOnClickListener(this);
        imageSetting.setOnClickListener(this);
        imageMessage.setOnClickListener(this);
        tvMember.setOnClickListener(this);
        layoutUser.setOnClickListener(this);
        imageLogo.setOnClickListener(this);
        tvUserName.setOnClickListener(this);
        tvUserPhone.setOnClickListener(this);

        AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
        if (accountInfo != null) {
            tvUserPhone.setText(accountInfo.mobile);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_help:
                break;
            case R.id.rl_user_feedback:
                break;
            case R.id.rl_evaluate:
                break;
            case R.id.rl_about:
                break;
            case R.id.ll_order:
                break;
            case R.id.ll_risk:
                break;
            case R.id.image_share:
                break;
            case R.id.image_setting:
                break;
            case R.id.image_message:
                break;
            case R.id.tv_member:
                break;
            case R.id.ll_user:
                break;
            case R.id.image_logo:
                break;
            case R.id.tv_userName:
                break;
            case R.id.tv_userPhone:
                break;
        }
    }
}
