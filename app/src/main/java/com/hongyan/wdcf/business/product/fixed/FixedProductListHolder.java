package com.hongyan.wdcf.business.product.fixed;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.config.UrlConst;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/6/10.
 */

public class FixedProductListHolder extends BaseViewHolder implements IViewHolder {

    private FixedProductListAdapter adapter;
    private PullToRefreshListView listView;
    private FixedProductListModel model;

    public FixedProductListHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_product_fixed_list;
    }

    @Override
    public int getLayoutType() {
        return IViewHolder.LAYOUT_TYPE_COMMON;
    }

    @Override
    public boolean needPageRequest() {
        return false;
    }

    @Override
    public void initView(View rootView) {
        addLeftButtonDefault();
        listView = rootView.findViewById(R.id.listView);
        adapter = new FixedProductListAdapter(mActivity);
        listView.setAdapter(adapter);
        model = new FixedProductListModel(new FixedProductListModel.UIRequestListener() {
            @Override
            public void onRefresh(ArrayList<FixedProductListResult.Product> list, boolean hasMore) {
                listView.setMode(hasMore ? PullToRefreshBase.Mode.BOTH : PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY);
                adapter.setData(list);
                listView.onRefreshComplete();
            }

            @Override
            public void onLoadMore(ArrayList<FixedProductListResult.Product> list, boolean hasMore) {
                listView.setMode(hasMore ? PullToRefreshBase.Mode.BOTH : PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY);
                adapter.setData(list);
                listView.onRefreshComplete();
            }

            @Override
            public void onFail(String message) {
                showErrorToast(message);
            }
        });
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                model.refresh();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                model.loadMore();
            }
        });
        model.refresh();
    }

    @Override
    public int getNavigationTitle() {
        return R.string.fixed_profit;
    }

    @Override
    public RequestBean getRequestBean() {
        return null;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
    }

    @Override
    public boolean onRequestFail() {
        return false;
    }
}
