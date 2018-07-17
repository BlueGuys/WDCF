package com.hongyan.wdcf.business.main.me;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hongyan.StringUtils;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;

/**
 * Created by wangning on 2018/7/10.
 */

public class MeUserPageView extends LinearLayout implements View.OnClickListener {

    private View view;
    TextView tvUserPhone;
    TextView tvUserName;

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
        tvUserName = view.findViewById(R.id.tv_userName);
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

    }

    public void notifyDataChanged() {
        AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
        if (accountInfo != null) {
            if (StringUtils.notEmpty(accountInfo.getUser_nicename())) {
                tvUserName.setText(accountInfo.getUser_nicename());
            }
            tvUserPhone.setText(accountInfo.getUIMobile());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_help:
                RouterManager.getInstance().openUrl(new Router("http://caifu.thongfu.com/App/Help/index.html?title=帮助中心"));
                break;
            case R.id.rl_user_feedback:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserUserFeedback));
                break;
            case R.id.rl_evaluate:
                break;
            case R.id.rl_about:
                RouterManager.getInstance().openUrl(new Router("http://caifu.thongfu.com/App/About/index.html?title=关于"));
                break;
            case R.id.ll_order:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserOrderList));
                break;
            case R.id.ll_risk:
                RouterManager.getInstance().openUrl(new Router("http://caifu.thongfu.com/App/Assessment/lists.html?title=风险评估&&token" + AccountManager.getInstance().getToken()));
                break;
            case R.id.image_share:
                break;
            case R.id.image_setting:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserUserSetting));
                break;
            case R.id.image_message:
                break;
            case R.id.tv_member:
                break;
            case R.id.ll_user:
            case R.id.image_logo:
            case R.id.tv_userName:
            case R.id.tv_userPhone: {
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserInfoIndex));
                break;
            }
        }
    }
}
