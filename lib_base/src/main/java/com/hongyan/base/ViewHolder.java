package com.hongyan.base;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.hongyan.lib_base.R;
import com.hongyan.smartrefresh.layout.SmartRefreshLayout;
import com.hongyan.smartrefresh.layout.api.RefreshLayout;
import com.hongyan.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by wangning on 2018/6/10.
 */

class ViewHolder {

    private BaseActivity baseActivity;
    private BaseViewHolder businessViewHolder;

    private IViewHolder iViewHolder;

    private View rootView;
    protected NavigationView navigationView;
    private LinearLayout contentLayout;
    private LinearLayout businessLayout;
    private SmartRefreshLayout smartRefreshLayout;
    protected ListView listView;
    private View netErrorLayout;

    ViewHolder(BaseActivity baseActivity, BaseViewHolder businessViewHolder) {
        this.baseActivity = baseActivity;
        this.businessViewHolder = businessViewHolder;
        iViewHolder = (IViewHolder) businessViewHolder;
        initBaseView();
        requestPageData(false);
    }

    /**
     * 初始化View
     */
    private void initBaseView() {
        int layoutResId = 0;
        if (iViewHolder.getLayoutType() == IViewHolder.LAYOUT_TYPE_COMMON) {
            layoutResId = R.layout.activity_base_common;
        } else if (iViewHolder.getLayoutType() == IViewHolder.LAYOUT_TYPE_LIST) {
            layoutResId = R.layout.activity_base_list;
        }
        rootView = LayoutInflater.from(baseActivity).inflate(layoutResId, null, false);

        //实例化导航栏
        NavigationView navigationView = rootView.findViewById(R.id.navigation);
        try {
            navigationView.setTitle(baseActivity.getString(iViewHolder.getNavigationTitle()));
        } catch (Exception e) {
            navigationView.setTitle(baseActivity.getString(R.string.app_name));
        }
        businessViewHolder.setNavigationView(navigationView);
        navigationView.setVisibility(businessViewHolder.hideNavigationView() ? View.GONE : View.VISIBLE);

        contentLayout = rootView.findViewById(R.id.contentLayout);
        netErrorLayout = rootView.findViewById(R.id.netErrorLayout);
        smartRefreshLayout = rootView.findViewById(R.id.refreshLayout);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                requestPageData(true);
            }
        });

        //初始化networkErrorLayout
        netErrorLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                requestPageData(false);
                return true;
            }
        });

        if (iViewHolder.getLayoutType() == IViewHolder.LAYOUT_TYPE_COMMON) {
            initLayoutCommon();
        } else if (iViewHolder.getLayoutType() == IViewHolder.LAYOUT_TYPE_LIST) {
            initLayoutList();
        }
        showBusinessLayout();
    }


    private void initLayoutCommon() {
        businessLayout = rootView.findViewById(R.id.businessLayout);
        View businessView = LayoutInflater.from(baseActivity).inflate(iViewHolder.getLayoutID(), null, false);
        businessLayout.addView(businessView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        iViewHolder.initView(businessView);
    }

    private void initLayoutList() {
        listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(businessViewHolder.getAdapter());
    }

    /**
     * 发送页面请求
     */
    private void requestPageData(final boolean isPullRefresh) {
        if (!iViewHolder.needPageRequest()) {//如果子类指定不需要页面请求，那么就不请求
            return;
        }
        baseActivity.startLoading(false);
        RequestBean requestBean = iViewHolder.getRequestBean();
        if (requestBean == null) {
            throw new Error("请求参数不能为空");
        }
        showBusinessLayout();
        new NetworkCall<>().start(requestBean.getResultClass(), requestBean.getRequestUrl(), requestBean.getParams(), new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                baseActivity.cancelLoading();
                if (isPullRefresh) {
                    smartRefreshLayout.finishRefresh();
                }
                iViewHolder.onRequestSuccess(result);
                showBusinessLayout();
            }

            @Override
            public void onError(BaseError error) {
                baseActivity.cancelLoading();
                if (isPullRefresh) {
                    smartRefreshLayout.finishRefresh();
                }
                if (iViewHolder.onRequestFail()) {
                    //子类实现
                } else {
                    showNetErrorLayout();
                    Toast.makeText(baseActivity, "网络错误", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void showBusinessLayout() {
        contentLayout.setVisibility(View.VISIBLE);
        netErrorLayout.setVisibility(View.GONE);
    }

    private void showNetErrorLayout() {
        contentLayout.setVisibility(View.GONE);
        netErrorLayout.setVisibility(View.VISIBLE);
    }

    View getRootView() {
        return rootView;
    }

}
