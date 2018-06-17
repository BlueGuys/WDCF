package com.hongyan.base;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.hongyan.lib_base.R;
import com.hongyan.smartrefresh.layout.SmartRefreshLayout;
import com.hongyan.smartrefresh.layout.api.RefreshLayout;
import com.hongyan.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by wangning on 2018/6/15.
 */

public abstract class ListViewHolder extends BaseViewHolder {

    private SmartRefreshLayout refreshLayout;
    protected ListView listView;

    protected View rootView;

    public ListViewHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    protected RequestBean getRequestBean() {
        return null;
    }

    @Override
    protected <T extends BaseResult> void onRequestSuccess(T result) {

    }

    protected abstract HYBaseAdapter getAdapter();

    protected boolean allowPullRefresh() {
        return false;
    }

    protected boolean allowLoadMore() {
        return false;
    }

    @Override
    public abstract boolean needPageRequest();

    @Override
    protected int getLayoutID() {
        return 0;
    }

    @Override
    protected void initView(View rootView) {
        if (rootView == null) {
            throw new Error("listWrapper没有找到根view");
        }
        refreshLayout = rootView.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mActivity.showErrorToast("111111111111");
            }
        });
        listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(getAdapter());
    }

    @Override
    protected int getNavigationTitle() {
        return 0;
    }

    @Override
    protected View getRootView() {
        if (rootView == null) {
            rootView = LayoutInflater.from(mActivity).inflate(R.layout.view_list_wrapper, null, false);
        }
        if (rootView == null) {
            throw new Error("listWrapper没有找到根view");
        }
        return rootView;
    }
}
