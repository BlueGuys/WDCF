package com.hongyan.wdcf.business.account.modifytradepassword;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hongyan.ToastsUtils;
import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.widget.ItemD;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ModifyTradePasswordHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {
    private ItemD itemCheckCode;
    private TextView tvGetCode;
    private TextView tvReservePhone;
    private ItemD itemNewPassword;
    private ItemD itemNewPasswordAgain;
    private Button btnConfirm;
    private Timer timer;
    private ModifyTradePasswordModel model;

    public ModifyTradePasswordHolder(BaseActivity mActivity) {
        super(mActivity);
        model = new ModifyTradePasswordModel(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_modify_tradepassword;
    }

    @Override
    public int getLayoutType() {
        return IViewHolder.LAYOUT_TYPE_COMMON;
    }

    @Override
    public boolean needPageRequest() {
        return false;
    }

    @Override
    public void initView(View rootView) {
        addLeftButtonDefault();
        itemCheckCode = rootView.findViewById(R.id.item_checkcode);
        tvGetCode = itemCheckCode.getDescTextView();
        tvReservePhone = rootView.findViewById(R.id.tv_reserve_phone);
        itemNewPassword = rootView.findViewById(R.id.item_newpassword);
        itemNewPasswordAgain = rootView.findViewById(R.id.item_newpassword_again);
        btnConfirm = rootView.findViewById(R.id.btn_confirm);
        if (tvGetCode != null) {
            tvGetCode.setOnClickListener(this);
        }
        btnConfirm.setOnClickListener(this);

    }

    @Override
    public int getNavigationTitle() {
        return R.string.modify_tradepassword;
    }

    @Override
    public RequestBean getRequestBean() {
        return null;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {

    }

    @Override
    public boolean onRequestFail() {
        return false;
    }


    @Override
    public void onClick(View v) {
        if (v == tvGetCode) {
            mActivity.startLoading(false);
            model.getCheckCode("18600412701");
        } else if (v == btnConfirm) {
            String checkcode = itemCheckCode.getEditContent();
            if (TextUtils.isEmpty(checkcode)) {
                ToastsUtils.showShort("请输入验证码");
                return;
            }
            String newpassword = itemNewPassword.getEditContent();
            if (TextUtils.isEmpty(newpassword)) {
                ToastsUtils.showShort("请输入新密码");
                return;
            }
            String newpasswordagain = itemNewPasswordAgain.getEditContent();
            if (TextUtils.isEmpty(newpasswordagain)) {
                ToastsUtils.showShort("请再次输入新密码");
                return;
            }
            if (newpassword.equals(newpasswordagain)) {
                mActivity.startLoading(false);
                model.confirm(checkcode, newpassword);
            } else {
                ToastsUtils.showShort("两次新密码不一致");
            }
        }
    }

    public void startTimer() {
        tvGetCode.setEnabled(false);
        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            int duration = 60;

            @Override
            public void run() {
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvGetCode.setText("(" + duration + "秒)");
                        if (duration == 0) {
                            cancel();
                            tvGetCode.setEnabled(true);
                            tvGetCode.setText("获取验证码");
                        }
                    }
                });
                duration--;
            }
        }, 0, 1000);
    }
}
