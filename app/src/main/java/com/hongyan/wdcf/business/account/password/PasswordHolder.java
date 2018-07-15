package com.hongyan.wdcf.business.account.password;

import android.util.Log;
import android.view.View;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.widget.ItemC;

/**
 * Created by wangning on 2018/6/10.
 */

public class PasswordHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private ItemC itemModifyLogin;
    private ItemC itemModifyBusiness;

    public PasswordHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_password;
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
        itemModifyLogin = rootView.findViewById(R.id.item_modify_login);
        itemModifyBusiness = rootView.findViewById(R.id.item_modify_business);
        itemModifyLogin.setOnClickListener(this);
        itemModifyBusiness.setOnClickListener(this);
        addLeftButtonDefault();
    }

    @Override
    public int getNavigationTitle() {
        return R.string.password_manage;
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
            case R.id.item_modify_login:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserModifyLoginPasswrod));
                break;
            case R.id.item_modify_business:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserModifyTradePasswrod));
                break;
        }
    }
}
