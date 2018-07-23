package com.hongyan.wdcf.business.teacher.invite;

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
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.widget.ConfirmDialog;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by wangning on 2018/6/10.
 */

public class InviteHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private String mobilePhone;

    public InviteHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_invite;
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
        TextView buttonCommit = rootView.findViewById(R.id.btn_share);
        TextView tvName = rootView.findViewById(R.id.tv_user_name);
        TextView tvMobile = rootView.findViewById(R.id.tv_user_mobile);
        TextView tvCompany = rootView.findViewById(R.id.tv_user_company);
        ImageView imageLogo = rootView.findViewById(R.id.image_logo);
        ImageView imageCall = rootView.findViewById(R.id.image_call);
        buttonCommit.setOnClickListener(this);
        imageCall.setOnClickListener(this);
        AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
        if (accountInfo != null) {
            if (StringUtils.notEmpty(accountInfo.getUser_nicename())) {
                tvName.setText(accountInfo.getUser_nicename());
            }
            tvMobile.setText(accountInfo.getUIMobile());
            tvCompany.setText(accountInfo.getCompany());
            DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCommonImageOption();
            ImageLoader.getInstance().displayImage(accountInfo.getAvatar(), imageLogo, options);
            mobilePhone = accountInfo.getMobile();
        }
    }

    @Override
    public int getNavigationTitle() {
        return R.string.invite_you;
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
            case R.id.btn_share:

                break;
            case R.id.image_call:
                final ConfirmDialog dialog = new ConfirmDialog(mActivity);
                dialog.show();
                dialog.setContent(mobilePhone, "取消", "呼叫");
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
                        Uri data = Uri.parse("tel:" + mobilePhone);
                        intent.setData(data);
                        mActivity.startActivity(intent);
                    }
                });
                break;
        }
    }
}
