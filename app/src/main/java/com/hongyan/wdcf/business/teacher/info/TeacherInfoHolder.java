package com.hongyan.wdcf.business.teacher.info;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.widget.ItemA;
import com.hongyan.wdcf.widget.ItemB;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by wangning on 2018/6/10.
 */

public class TeacherInfoHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private ImageView imageUserLogo;
    private TextView tvUserName;
    private TextView tvUserMobile;
    private ItemA itemMobilePhone;
    private ItemB itemIntroduction;
    private ItemB itemModifyPassword;
    private Button buttonExit;
    private String content;

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
        itemModifyPassword.setOnClickListener(this);
        itemIntroduction.setOnClickListener(this);
        buttonExit = rootView.findViewById(R.id.btn_exit);
        buttonExit.setOnClickListener(this);
        refresh();
    }

    protected void refresh() {
        AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
        if (accountInfo != null) {
            content = accountInfo.getContent();
            tvUserName.setText(accountInfo.getUser_nicename());
            tvUserMobile.setText(accountInfo.getUIMobile());
            itemMobilePhone.setDesc(accountInfo.getUIMobile());
            itemIntroduction.setDesc(accountInfo.getContent());
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
            case R.id.item_modify_password:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserModifyLoginPasswrod));
                break;
            case R.id.item_introduction:
                Router router = new Router(RouterConfig.TeacherIntroductionModify);
                router.addParams(RequestKeyTable.CONTENT, content);
                RouterManager.getInstance().openUrl(router);
                break;
        }
    }
}
