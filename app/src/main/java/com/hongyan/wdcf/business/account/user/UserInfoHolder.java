package com.hongyan.wdcf.business.account.user;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hongyan.StringUtils;
import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.widget.ConfirmDialog;
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
    private Button button;

    private String userName;
    private String userAvatar;
    private String mobile;
    private String userRealName;
    private String userIdentifyNumber;
    private String level;
    private String email;
    private String address;
    private String type;

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
        button = rootView.findViewById(R.id.btn_exit);

        tvUserName.setText(userName);
        tvUserMobile.setText(mobile);
        itemName.setDesc(userName);
        itemCertificatesNumber.setDesc(userIdentifyNumber);
        itemMobilePhone.setDesc(userName);
        itemEmail.setDesc(email);
        itemAddress.setDesc(address);
        if (StringUtils.notEmpty(userAvatar)) {
            DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getAvatarImageOption();
            ImageLoader.getInstance().displayImage(userAvatar, imageUserLogo, options);
        }

        if (StringUtils.notEmpty(type) && type.equals("1")) {//是自己
            button.setText("退出登录");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AccountManager.getInstance().logout();
                    getActivity().finish();
                }
            });
        } else {//是别人
            button.setText("联系客户");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final ConfirmDialog dialog = new ConfirmDialog(mActivity);
                    dialog.show();
                    dialog.setContent(mobile, "取消", "呼叫");
                    dialog.setLeftListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.setRightListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            Uri data = Uri.parse("tel:" + mobile);
                            intent.setData(data);
                            mActivity.startActivity(intent);
                        }
                    });
                }
            });
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
            case R.id.image_user_logo:
                break;
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public void setUserIdentifyNumber(String userIdentifyNumber) {
        this.userIdentifyNumber = userIdentifyNumber;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }
}
