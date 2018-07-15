package com.hongyan.wdcf.business.account.modifyloginpassword;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.hongyan.ToastsUtils;
import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.widget.ItemD;

public class ModifyLoginPasswordHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {
    private ItemD itemOldPassword;
    private ItemD itemNewPassword;
    private ItemD itemNewPasswordAgain;
    private Button btnConfirm;
    private ModifyLoginPasswordModel model;

    public ModifyLoginPasswordHolder(BaseActivity mActivity) {
        super(mActivity);
        model = new ModifyLoginPasswordModel(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_modify_loginpassword;
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
        itemOldPassword = rootView.findViewById(R.id.item_oldpassword);
        itemNewPassword = rootView.findViewById(R.id.item_newpassword);
        itemNewPasswordAgain = rootView.findViewById(R.id.item_newpassword_again);
        btnConfirm = rootView.findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public int getNavigationTitle() {
        return R.string.modify_loginpassword;
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
        switch (v.getId()) {
            case R.id.btn_confirm:
                String oldpassword = itemOldPassword.getEditContent();
                if (TextUtils.isEmpty(oldpassword)) {
                    ToastsUtils.showShort("请输入原密码");
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
                    model.confirm(oldpassword, newpassword);
                } else {
                    ToastsUtils.showShort("两次新密码不一致");
                }
                break;
        }
    }
}
