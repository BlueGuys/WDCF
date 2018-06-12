package com.hongyan.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hongyan.lib_base.R;

/**
 * Created by wangning on 2018/6/10.
 */

class ViewHolder {

    private BaseActivity baseActivity;
    private View rootView;
    private LinearLayout businessLayout;
    private BaseViewHolder businessViewHolder;
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

        businessLayout = rootView.findViewById(R.id.contentLayout);
        View contentView;
        try {
            contentView = LayoutInflater.from(baseActivity).inflate(businessViewHolder.getLayoutID(), null, false);
        } catch (Exception e) {
            contentView = LayoutInflater.from(baseActivity).inflate(R.layout.view_base, null, false);
        }
        businessLayout.addView(contentView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        netErrorLayout = rootView.findViewById(R.id.netErrorLayout);

        //实例化导航栏
        NavigationView navigationView = rootView.findViewById(R.id.navigation);
        businessViewHolder.setNavigationView(navigationView);
        navigationView.setVisibility(businessViewHolder.hideNavigationView() ? View.GONE : View.VISIBLE);

        businessViewHolder.initView(contentView);
    }

    /**
     * 发送页面请求
     */
    private void requestPageData() {
        if (!baseActivity.needPageRequest()) {//如果子类指定不需要页面请求，那么就不请求
            return;
        }
        baseActivity.startLoading();
        RequestBean requestBean = businessViewHolder.getRequestBean();
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
        netErrorLayout.setVisibility(View.GONE);
        businessLayout.setVisibility(View.VISIBLE);
    }

    private void showNetErrorLayout() {
        netErrorLayout.setVisibility(View.VISIBLE);
        businessLayout.setVisibility(View.GONE);
    }

    View getRootView() {
        return rootView;
    }

}
