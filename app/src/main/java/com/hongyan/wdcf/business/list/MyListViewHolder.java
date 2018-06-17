package com.hongyan.wdcf.business.list;

import android.view.View;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.CommonViewHolder;
import com.hongyan.base.HYBaseAdapter;
import com.hongyan.base.ListViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.main.MainResult;

/**
 * Created by wangning on 2018/6/10.
 */

public class MyListViewHolder extends ListViewHolder {

    MyListViewHolder(BaseActivity activity) {
        super(activity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_list;
    }

    @Override
    protected int getNavigationTitle() {
        return R.string.list;
    }

    @Override
    protected boolean allowPullRefresh() {
        return true;
    }

    @Override
    protected boolean allowLoadMore() {
        return true;
    }

    @Override
    public boolean needPageRequest() {
        return true;
    }

    @Override
    protected HYBaseAdapter getAdapter() {
        return null;
    }

    @Override
    protected RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(MainResult.class);
        bean.setRequestUrl("http://www.xicaijing.com/Api/Digiccy/mylists.html");
        bean.addParam("sss", "ss");
        return bean;
    }

    @Override
    protected <T extends BaseResult> void onRequestSuccess(T result) {
        showSuccessToast("请求成功");
    }

    @Override
    protected void initView(View rootView) {
    }
}
