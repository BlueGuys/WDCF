package com.hongyan.wdcf.business.account.bindteacher;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.hongyan.StringUtils;
import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.business.account.IdentityView;
import com.hongyan.wdcf.business.account.bankcard.BankCardListResult;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/6/10.
 */

public class BindTeacherHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private BindTeacherModel model;

    private Button btnCommit;
    private CheckBox checkBox01;
    private CheckBox checkBox02;
    private TextView textViewTeacher;
    private TextView textViewCode;
    private TextView textViewAddress;
    private EditText editTextCode;

    private String teacherCode1;
    private String teacherCode2;

    public BindTeacherHolder(BaseActivity mActivity) {
        super(mActivity);
        model = new BindTeacherModel(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_bind_teacher;
    }

    @Override
    public int getLayoutType() {
        return IViewHolder.LAYOUT_TYPE_COMMON;
    }

    @Override
    public boolean needPageRequest() {
        return true;
    }

    @Override
    public void initView(View rootView) {
        btnCommit = rootView.findViewById(R.id.btn_commit);
        TextView tvBack = rootView.findViewById(R.id.tv_back);
        IdentityView identityView = rootView.findViewById(R.id.identityView);
        identityView.setStep(3);
        tvBack.setOnClickListener(this);
        btnCommit.setOnClickListener(this);
        checkBox01 = rootView.findViewById(R.id.checkbox01);
        checkBox02 = rootView.findViewById(R.id.checkbox02);
        textViewCode = rootView.findViewById(R.id.tv_teacher_number);
        textViewAddress = rootView.findViewById(R.id.tv_address);
        textViewTeacher = rootView.findViewById(R.id.tv_teacher01);
        editTextCode = rootView.findViewById(R.id.et_code);

        checkBox01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox02.setChecked(false);
                }
            }
        });
        checkBox02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox01.setChecked(false);
                }
            }
        });
        checkBox01.setChecked(true);
        editTextCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                teacherCode2 = s.toString();
            }
        });
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
        RequestBean bean = new RequestBean<>(RecommenTeacherResult.class);
        bean.setRequestUrl(UrlConst.getRecommandTeacherUrl());
        bean.addParam(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
        return bean;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
        RecommenTeacherResult recommenTeacherResult = (RecommenTeacherResult) result;
        if (recommenTeacherResult == null) {
            return;
        }
        if (recommenTeacherResult.isSuccessful()) {
            RecommenTeacherResult.Data data = recommenTeacherResult.data;
            if (data != null) {
                teacherCode1 = data.id_number;
                textViewTeacher.setText(data.user_nicename);
                textViewCode.setText("员工编号" + data.id_number);
                textViewAddress.setText(data.address);
            }
        } else {
            showErrorToast(recommenTeacherResult.getReturnMessage());
        }
    }

    @Override
    public boolean onRequestFail() {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                goBack();
                break;
            case R.id.btn_commit:
                if (checkBox01.isChecked()) {
                    model.commit(teacherCode1);
                } else if (checkBox02.isChecked()) {
                    if (StringUtils.isEmpty(teacherCode2)) {
                        showErrorToast("请输入理财师员工编号");
                        return;
                    }
                    model.commit(teacherCode2);
                }
                break;
        }
    }


}
