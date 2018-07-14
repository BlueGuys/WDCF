package com.hongyan.wdcf.business.account.setting;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.widget.ItemC;

/**
 * Created by wangning on 2018/6/10.
 */

public class SettingHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private ItemC itemBank;
    private ItemC itemPassword;

    public SettingHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_setting;
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
        itemBank = rootView.findViewById(R.id.item_bank);
        itemPassword = rootView.findViewById(R.id.item_password);
        itemBank.setOnClickListener(this);
        itemPassword.setOnClickListener(this);
        addLeftButtonDefault();
    }

    @Override
    public int getNavigationTitle() {
        return R.string.setting;
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
            case R.id.item_bank:
                Log.e("test", "11111111");
                break;
            case R.id.item_password:
                Log.e("test", "2222222");
                break;
        }
    }
}
