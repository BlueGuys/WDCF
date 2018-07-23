package com.hongyan.wdcf.business.teacher.introduction;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;

/**
 * Created by wangning on 2018/6/10.
 */

public class ModifyIntroductionHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private ModifyIntroductionModel introductionModel;
    private EditText editText;
    private String introduction;

    public ModifyIntroductionHolder(BaseActivity mActivity) {
        super(mActivity);
        introductionModel = new ModifyIntroductionModel(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_modify_introduction;
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
        Button buttonCommit = rootView.findViewById(R.id.btn_commit);
        editText = rootView.findViewById(R.id.editText);
        buttonCommit.setOnClickListener(this);
    }

    @Override
    public int getNavigationTitle() {
        return R.string.introduction_info;
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
            case R.id.btn_commit:
                String content = editText.getText().toString();
                introductionModel.commit(content);
                break;
        }
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
        editText.setText(introduction);
    }
}
