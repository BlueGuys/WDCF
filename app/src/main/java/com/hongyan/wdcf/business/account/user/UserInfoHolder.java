package com.hongyan.wdcf.business.account.user;

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
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.widget.ItemA;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by wangning on 2018/6/10.
 */

public class UserInfoHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private ImageView imageUserLogo;
    private TextView tvUserName;
    private TextView tvUserMobile;
    private ItemA itemName;
    private ItemA itemCertificatesType;
    private ItemA itemCertificatesNumber;
    private ItemA itemMobilePhone;
    private ItemA itemEmail;
    private ItemA itemAddress;
    private Button buttonExit;

    public UserInfoHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_user_info;
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
        itemName = rootView.findViewById(R.id.item_name);
        itemCertificatesType = rootView.findViewById(R.id.item_certificates_type);
        itemCertificatesNumber = rootView.findViewById(R.id.item_certificates_number);
        itemMobilePhone = rootView.findViewById(R.id.item_mobile_phone);
        itemEmail = rootView.findViewById(R.id.item_email);
        itemAddress = rootView.findViewById(R.id.item_address);
        buttonExit = rootView.findViewById(R.id.btn_exit);
        buttonExit.setOnClickListener(this);

        AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
        if (accountInfo != null) {
            tvUserName.setText(accountInfo.getUser_nicename());
            tvUserMobile.setText(accountInfo.getUIMobile());
            itemName.setDesc(accountInfo.getUser_nicename());
            itemCertificatesNumber.setDesc(accountInfo.getUser_nicename());
            itemMobilePhone.setDesc(accountInfo.getUIMobile());
            itemEmail.setDesc(accountInfo.getUser_email());
            itemAddress.setDesc(accountInfo.getAddress());

            DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getAvatarImageOption();
            ImageLoader.getInstance().displayImage(accountInfo.getAvatar(), imageUserLogo, options);
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
