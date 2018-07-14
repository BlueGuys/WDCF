package com.hongyan.wdcf.business.account.select;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

public class SelectIdentifyHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {


    private IdentityView identityView;

    public SelectIdentifyHolder(BaseActivity mActivity) {
        super(mActivity);
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
        Button buttonChinese = rootView.findViewById(R.id.button_chinese);
        Button buttonGat = rootView.findViewById(R.id.button_gat);
        Button buttonForeigner = rootView.findViewById(R.id.button_foreigner);
        TextView tvBack = rootView.findViewById(R.id.tv_back);
        identityView = rootView.findViewById(R.id.identityView);
        identityView.setStep(1);

        tvBack.setOnClickListener(this);
        buttonChinese.setOnClickListener(this);
        buttonGat.setOnClickListener(this);
        buttonForeigner.setOnClickListener(this);
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
                break;
            case R.id.button_gat:
                break;
            case R.id.button_foreigner:
                break;
            case R.id.tv_back:
                goBack();
                break;
        }
    }
}
