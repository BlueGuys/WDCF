package com.hongyan.wdcf.business.teacher.person;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.widget.ItemA;

/**
 * Created by wangning on 2018/6/10.
 */

public class TeacherInfoHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private ImageView imageUserLogo;
    private TextView tvUserName;
    private TextView tvUserMobile;
    private ItemA itemMobilePhone;
    private ItemA itemIntroduction;
    private ItemA itemModifyPassword;
    private Button buttonExit;

    public TeacherInfoHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_teacher_info;
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

        imageUserLogo = rootView.findViewById(R.id.image_user_logo);
        tvUserName = rootView.findViewById(R.id.tv_user_name);
        tvUserMobile = rootView.findViewById(R.id.tv_user_mobile);
        itemMobilePhone = rootView.findViewById(R.id.item_mobile_phone);
        itemIntroduction = rootView.findViewById(R.id.item_introduction);
        itemModifyPassword = rootView.findViewById(R.id.item_modify_password);
        buttonExit = rootView.findViewById(R.id.btn_exit);
        buttonExit.setOnClickListener(this);

        AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
        if (accountInfo != null) {
            tvUserName.setText(accountInfo.getUser_nicename());
            tvUserMobile.setText(accountInfo.getUIMobile());
            itemMobilePhone.setDesc(accountInfo.getUIMobile());
        }

    }

    @Override
    public int getNavigationTitle() {
        return R.string.person_information;
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
            case R.id.btn_exit:
                AccountManager.getInstance().logout();
                getActivity().finish();
                break;
            case R.id.image_user_logo:
                break;
        }
    }
}
