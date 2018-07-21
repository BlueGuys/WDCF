package com.hongyan.wdcf.business.product.overseas;

import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.config.UrlConst;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/6/10.
 */

public class OverseasProductListHolder extends BaseViewHolder implements IViewHolder {

    private OverseasProductListAdapter adapter;
    private PullToRefreshListView listView;

    public OverseasProductListHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_product_overseas_list;
    }

    @Override
    public int getLayoutType() {
        return IViewHolder.LAYOUT_TYPE_COMMON;
    }

    @Override
    public boolean needPageRequest() {
        return true;
    }

    @Override
    public void initView(View rootView) {
        addLeftButtonDefault();
        listView = rootView.findViewById(R.id.listView);
        adapter = new OverseasProductListAdapter(mActivity);
        listView.setAdapter(adapter);
    }

    @Override
    public int getNavigationTitle() {
        return R.string.overseas;
    }

    @Override
    public RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(OverseasProductListResult.class);
        bean.setRequestUrl(UrlConst.getProductFixedListUrl());
        bean.addParam(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
        bean.addParam(RequestKeyTable.CAT_ID, "5");
        return bean;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
        OverseasProductListResult cardListResult = (OverseasProductListResult) result;
        if (cardListResult == null) {
            return;
        }
        if (cardListResult.isSuccessful()) {
            setDataList(cardListResult.data.list);
        } else {
            showErrorToast(cardListResult.getReturnMessage());
        }
    }

    protected void setDataList(ArrayList<OverseasProductListResult.Product> list) {
        adapter.setData(list);
    }

    @Override
    public boolean onRequestFail() {
        return false;
    }
}
