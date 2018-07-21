package com.hongyan.wdcf.business.teacher.invite;

import android.view.View;
import android.widget.Button;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;

/**
 * Created by wangning on 2018/6/10.
 */

public class InviteHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private InviteModel feedbackModel;

    public InviteHolder(BaseActivity mActivity) {
        super(mActivity);
        feedbackModel = new InviteModel(this);
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
        Button buttonCommit = rootView.findViewById(R.id.btn_commit);
        buttonCommit.setOnClickListener(this);
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
            case R.id.btn_commit:

                break;
        }
    }
}
