package com.hongyan.wdcf.business.account.select;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.StringUtils;
import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.IdentityView;

/**
 * Created by wangning on 2018/6/10.
 */

public class SelectIdentifyHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener, TextWatcher {

    private SelectIdentifyModel model;

    private LinearLayout ll_select;
    private LinearLayout ll_input;
    private EditText etIdentifyName;
    private EditText etIdentifyNumber;
    private EditText etEmail;
    private EditText etCity;
    private EditText etAddress;
    private Button btnCommit;

    public SelectIdentifyHolder(BaseActivity mActivity) {
        super(mActivity);
        model = new SelectIdentifyModel(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_select_identify;
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
        ll_select = rootView.findViewById(R.id.ll_select);
        ll_input = rootView.findViewById(R.id.ll_input);
        Button buttonChinese = rootView.findViewById(R.id.button_chinese);
        Button buttonGat = rootView.findViewById(R.id.button_gat);
        Button buttonForeigner = rootView.findViewById(R.id.button_foreigner);
        btnCommit = rootView.findViewById(R.id.btn_commit);
        TextView tvBack = rootView.findViewById(R.id.tv_back);
        etIdentifyName = rootView.findViewById(R.id.et_identify_name);
        etIdentifyNumber = rootView.findViewById(R.id.et_identify_number);
        etEmail = rootView.findViewById(R.id.et_email_number);
        etCity = rootView.findViewById(R.id.et_city);
        etAddress = rootView.findViewById(R.id.et_address);
        etIdentifyName.addTextChangedListener(this);
        etIdentifyNumber.addTextChangedListener(this);
        etEmail.addTextChangedListener(this);
        etCity.addTextChangedListener(this);
        etAddress.addTextChangedListener(this);

        IdentityView identityView = rootView.findViewById(R.id.identityView);
        identityView.setStep(1);

        tvBack.setOnClickListener(this);
        buttonChinese.setOnClickListener(this);
        buttonGat.setOnClickListener(this);
        buttonForeigner.setOnClickListener(this);
        btnCommit.setOnClickListener(this);
        btnCommit.setEnabled(true);
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
            case R.id.button_chinese:
                model.setType("1");
                showInputLayout();
                break;
            case R.id.button_gat:
                model.setType("2");
                showInputLayout();
                break;
            case R.id.button_foreigner:
                model.setType("3");
                showInputLayout();
                break;
            case R.id.tv_back:
                goBack();
                break;
            case R.id.btn_commit:
                if (StringUtils.isEmpty(etIdentifyName.getText().toString())) {
                    showErrorToast("请输入姓名");
                    return;
                }
                if (StringUtils.isEmpty(etIdentifyNumber.getText().toString())) {
                    showErrorToast("请输入身份证号");
                    return;
                }
                model.setId_number(etIdentifyNumber.getText().toString());
                model.setName(etIdentifyName.getText().toString());
                model.setAddress(etAddress.getText().toString());
                model.setEmail(etEmail.getText().toString());
                model.setCity(etCity.getText().toString());
                model.commit();
                break;
        }
    }

    public void showInputLayout() {
        ll_input.setVisibility(View.VISIBLE);
        ll_select.setVisibility(View.GONE);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
//        if (StringUtils.notEmpty(etIdentifyName.getText().toString())
//                && StringUtils.notEmpty(etIdentifyNumber.getText().toString())
//                && StringUtils.notEmpty(etEmail.getText().toString())
//                && StringUtils.notEmpty(etCity.getText().toString())
//                && StringUtils.notEmpty(etAddress.getText().toString())) {
//            btnCommit.setEnabled(true);
//        } else {
//            btnCommit.setEnabled(false);
//        }
    }
}
