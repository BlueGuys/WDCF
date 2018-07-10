package com.hongyan.wdcf.business.account.register;

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

public class RegisterHolder extends BaseViewHolder implements IViewHolder, TextWatcher {

    private EditText etMobilePhone;
    private EditText etPassword;
    private EditText etVerifyCode;
    private TextView tvSendCode;
    private TextView tvBack;
    private Button btnRegister;
    private RegisterModel registerModel;

    private String mobilePhone;
    private String password;
    private String verifyCode;

    public RegisterHolder(BaseActivity mActivity) {
        super(mActivity);
        registerModel = new RegisterModel(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_register;
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
        btnRegister = rootView.findViewById(R.id.register);
        etMobilePhone = rootView.findViewById(R.id.et_mobile_phone);
        etPassword = rootView.findViewById(R.id.et_password);
        etVerifyCode = rootView.findViewById(R.id.et_verify_code);
        tvSendCode = rootView.findViewById(R.id.tv_send_code);
        tvBack = rootView.findViewById(R.id.tv_back);
        btnRegister.setEnabled(false);
        tvSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerModel.sendCodeRequest(etMobilePhone.getText().toString());
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 待处理
                Router router = new Router(RouterConfig.UserRegisterSelect);
                RouterManager.getInstance().openUrl(router);
//                registerModel.startRegister(mobilePhone, password, verifyCode);
            }
        });
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
        etMobilePhone.addTextChangedListener(this);
        etPassword.addTextChangedListener(this);
        etVerifyCode.addTextChangedListener(this);
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
        verifyCode = etVerifyCode.getText().toString();
        if (StringUtils.notEmpty(mobilePhone) && StringUtils.notEmpty(password) && StringUtils.notEmpty(verifyCode)) {
            btnRegister.setEnabled(true);
        } else {
            btnRegister.setEnabled(false);
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
