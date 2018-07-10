package com.hongyan.wdcf.business.account.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hongyan.StringUtils;
import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;

/**
 * Created by wangning on 2018/6/10.
 */

public class LoginHolder extends BaseViewHolder implements IViewHolder, TextWatcher {

    private EditText etMobilePhone;
    private EditText etPassword;
    private Button btnLogin;
    private LoginModel registerModel;

    private String mobilePhone;
    private String password;

    public LoginHolder(BaseActivity mActivity) {
        super(mActivity);
        registerModel = new LoginModel(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
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
        btnLogin = rootView.findViewById(R.id.register);
        etMobilePhone = rootView.findViewById(R.id.et_mobile_phone);
        etPassword = rootView.findViewById(R.id.et_password);
        TextView tvRegister = rootView.findViewById(R.id.tv_register);
        btnLogin.setEnabled(false);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerModel.login(mobilePhone, password);
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router(RouterConfig.UserRegisterIndex);
                RouterManager.getInstance().openUrl(router);
            }
        });
        etMobilePhone.addTextChangedListener(this);
        etPassword.addTextChangedListener(this);
    }

    @Override
    protected boolean hideNavigationView() {
        return true;
    }

    @Override
    public int getNavigationTitle() {
        return 0;
    }

    @Override
    public void afterTextChanged(Editable s) {
        mobilePhone = etMobilePhone.getText().toString();
        password = etPassword.getText().toString();
        if (StringUtils.notEmpty(mobilePhone) && StringUtils.notEmpty(password)) {
            btnLogin.setEnabled(true);
        } else {
            btnLogin.setEnabled(false);
        }
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
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
}
