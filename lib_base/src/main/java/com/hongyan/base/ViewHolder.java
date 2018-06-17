package com.hongyan.base;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hongyan.lib_base.R;
import com.hongyan.smartrefresh.layout.SmartRefreshLayout;

/**
 * Created by wangning on 2018/6/10.
 */

class ViewHolder {

    private BaseActivity baseActivity;
    private View rootView;
    private BaseViewHolder businessViewHolder;
    private LinearLayout contentLayout;
    private View netErrorLayout;

    ViewHolder(BaseActivity baseActivity, BaseViewHolder businessViewHolder) {
        this.baseActivity = baseActivity;
        this.businessViewHolder = businessViewHolder;
        initView();
        requestPageData();
    }

    /**
     * 初始化View
     */
    private void initView() {
        rootView = LayoutInflater.from(baseActivity).inflate(R.layout.activity_base, null, false);

        //初始化businessLayout
        contentLayout = rootView.findViewById(R.id.contentLayout);
        View businessView = businessViewHolder.getRootView();
        contentLayout.addView(businessView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        //初始化networkErrorLayout
        netErrorLayout = rootView.findViewById(R.id.netErrorLayout);
        netErrorLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                requestPageData();
                return true;
            }
        });

        //实例化导航栏
        NavigationView navigationView = rootView.findViewById(R.id.navigation);
        navigationView.setTitle(baseActivity.getString(businessViewHolder.getNavigationTitle()));
        navigationView.setVisibility(businessViewHolder.hideNavigationView() ? View.GONE : View.VISIBLE);
        businessViewHolder.setNavigationView(navigationView);

        businessViewHolder.initView(businessView);
    }

    /**
     * 发送页面请求
     */
    private void requestPageData() {
        if (!baseActivity.getViewHolder().needPageRequest()) {//如果子类指定不需要页面请求，那么就不请求
            return;
        }
        baseActivity.startLoading(false);
        RequestBean requestBean = businessViewHolder.getRequestBean();
        if (requestBean == null) {
            throw new Error("请求参数不能为空");
        }
        showBusinessLayout();
        new NetworkCall<>().start(requestBean.getResultClass(), requestBean.getRequestUrl(), requestBean.getParams(), new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                baseActivity.cancelLoading();
                businessViewHolder.onRequestSuccess(result);
                showBusinessLayout();
            }

            @Override
            public void onError(BaseError error) {
                baseActivity.cancelLoading();
                if (businessViewHolder.onRequestFail()) {
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
