package com.hongyan.base;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.hongyan.lib_base.R;
import com.hongyan.smartrefresh.layout.SmartRefreshLayout;

/**
 * Created by wangning on 2018/6/10.
 */

public class BaseViewHolder {

    protected BaseActivity mActivity;
    private IViewHolder iViewHolder;

    private View rootView;
    protected NavigationView navigationView;
    private LinearLayout contentLayout;
    private LinearLayout businessLayout;
    private SmartRefreshLayout smartRefreshLayout;
    protected ListView listView;
    private View netErrorLayout;

    public BaseViewHolder(BaseActivity mActivity) {
        this.mActivity = mActivity;
    }

    private void showBusinessLayout() {
        contentLayout.setVisibility(View.VISIBLE);
        netErrorLayout.setVisibility(View.GONE);
    }

    private void showNetErrorLayout() {
        contentLayout.setVisibility(View.GONE);
        netErrorLayout.setVisibility(View.VISIBLE);
    }

    public Activity getActivity() {
        return mActivity;
    }

    public HYBaseAdapter getAdapter() {
        return null;
    }

    protected boolean hideNavigationView() {
        return false;
    }

    protected View getRootView() {
        return rootView;
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
