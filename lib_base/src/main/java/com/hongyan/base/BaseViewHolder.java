package com.hongyan.base;

import android.view.View;

import com.hongyan.lib_base.R;

/**
 * Created by wangning on 2018/6/10.
 */

public abstract class BaseViewHolder {

    protected BaseActivity mActivity;
    protected NavigationView navigationView;

    public BaseViewHolder(BaseActivity mActivity) {
        this.mActivity = mActivity;
    }

    protected abstract RequestBean getRequestBean();

    protected abstract <T extends BaseResult> void onRequestSuccess(T result);

    protected boolean onRequestFail() {
        return false;
    }

    protected abstract int getLayoutID();

    protected abstract void initView(View rootView);

    protected abstract int getNavigationTitle();

    public BaseActivity getmActivity() {
        return mActivity;
    }

    protected boolean hideNavigationView() {
        return false;
    }

    protected boolean allowPullRefresh(){
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
                mActivity.finish();
            }
        });
    }

    protected void showSuccessToast(String message) {
        mActivity.showSuccessToast(message);
    }

    protected void showErrorToast(String message) {
        mActivity.showErrorToast(message);
    }

    protected void startLoading() {
        mActivity.startLoading();
    }

    /**
     * @param isCancelable 是否可以取消
     */
    protected void startLoading(boolean isCancelable) {
        mActivity.startLoading(isCancelable);
    }

    protected void cancelLoading() {
        mActivity.cancelLoading();
    }


}
