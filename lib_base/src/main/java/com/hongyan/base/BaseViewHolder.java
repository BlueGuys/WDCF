package com.hongyan.base;

import android.view.View;

import com.hongyan.lib_base.R;

/**
 * Created by wangning on 2018/6/10.
 */

public abstract class BaseViewHolder {

    protected BaseActivity activity;
    protected NavigationView navigationView;

    public BaseViewHolder(BaseActivity activity) {
        this.activity = activity;
    }

    protected abstract RequestBean getRequestBean();

    protected abstract <T extends BaseResult> void onRequestSuccess(T result);

    protected boolean onRequestFail() {
        return false;
    }

    protected abstract int getLayoutID();

    protected abstract void initView(View rootView);

    protected abstract int getNavigationTitle();

    public BaseActivity getActivity() {
        return activity;
    }

    protected boolean hideNavigationView() {
        return false;
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }

    protected void setNavigationView(NavigationView navigationView) {
        this.navigationView = navigationView;
    }

    protected void addLeftButton(int buttonResId, View.OnClickListener listener) {
        this.navigationView.addLeftButton(buttonResId, listener);
    }

    protected void addLeftButtonDefault() {
        addLeftButton(R.drawable.icon_arrow_back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    protected void showSuccessToast(String message) {
        activity.showSuccessToast(message);
    }

    protected void showErrorToast(String message) {
        activity.showErrorToast(message);
    }

    protected void startLoading() {
        activity.startLoading();
    }

    /**
     * @param isCancelable 是否可以取消
     */
    protected void startLoading(boolean isCancelable) {
        activity.startLoading(isCancelable);
    }

    protected void cancelLoading() {
        activity.cancelLoading();
    }


}
