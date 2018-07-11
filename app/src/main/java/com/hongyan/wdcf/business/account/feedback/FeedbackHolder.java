package com.hongyan.wdcf.business.account.feedback;

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

public class FeedbackHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private FeedbackModel feedbackModel;
    private EditText etFeedback;
    private EditText etEmail;

    public FeedbackHolder(BaseActivity mActivity) {
        super(mActivity);
        feedbackModel = new FeedbackModel(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_feedback;
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
        etFeedback = rootView.findViewById(R.id.et_feedback);
        etEmail = rootView.findViewById(R.id.et_email);
        buttonCommit.setOnClickListener(this);
    }

    @Override
    public int getNavigationTitle() {
        return R.string.user_feedback;
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
                String content = etFeedback.getText().toString();
                if (content.length() < 15) {
                    showErrorToast("字数太少");
                    return;
                }
                String email = etEmail.getText().toString();
                feedbackModel.commit(content, email);
                break;
        }
    }
}
