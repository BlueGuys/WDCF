package com.hongyan.base;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hongyan.lib_base.R;
import com.hongyan.smartrefresh.layout.SmartRefreshLayout;
import com.hongyan.smartrefresh.layout.api.RefreshLayout;
import com.hongyan.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by wangning on 2018/6/15.
 */

public abstract class CommonViewHolder extends BaseViewHolder {

    private View commonWrapper;
    private SmartRefreshLayout smartRefreshLayout;

    public CommonViewHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    protected RequestBean getRequestBean() {
        return null;
    }

    @Override
    protected <T extends BaseResult> void onRequestSuccess(T result) {

    }

    @Override
    public abstract boolean needPageRequest();

    @Override
    protected int getLayoutID() {
        return 0;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int getNavigationTitle() {
        return 0;
    }

    @Override
    protected View getRootView() {
        if (commonWrapper == null) {
            commonWrapper = LayoutInflater.from(mActivity).inflate(R.layout.view_common_wrapper, null, false);
            smartRefreshLayout = commonWrapper.findViewById(R.id.refreshLayout);
        }
        smartRefreshLayout.setEnableHeaderTranslationContent(needPageRequest());
        smartRefreshLayout.setEnableFooterTranslationContent(false);
        LinearLayout linearLayout = commonWrapper.findViewById(R.id.layout_wrapper);
        View businessView = LayoutInflater.from(mActivity).inflate(getLayoutID(), null, false);
        if (businessView == null) {
            throw new Error("commonWrapper没有找到businessView");
        }
        linearLayout.addView(businessView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return commonWrapper;
    }
}
