package com.hongyan.wdcf.business.account.order;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

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
import java.util.List;

/**
 * Created by wangning on 2018/6/10.
 */

public class OrderListHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private OrderListIndicator indicator;
    private ViewPager viewPager;
    private OrderListPagerAdapter adapter;

    private List<Fragment> fragments = new ArrayList<>();

    public OrderListHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_order_list;
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
        indicator = rootView.findViewById(R.id.indicator);
        viewPager = rootView.findViewById(R.id.viewpager);

        fragments.add(new OrderListFragment());
        fragments.add(new ActivityListFragment());
        fragments.add(new TransactionListFragment());

        adapter = new OrderListPagerAdapter(mActivity.getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        indicator.setOnMenuClickListener(new OrderListIndicator.OnMenuClickListener() {
            @Override
            public void onSelect(int position) {
                viewPager.setCurrentItem(position);
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator.select(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public int getNavigationTitle() {
        return R.string.my_order_list;
    }

    @Override
    public RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(OrderListResult.class);
        bean.setRequestUrl(UrlConst.getMyOrderListUrl());
        bean.addParam(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
        return bean;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
        OrderListResult cardListResult = (OrderListResult) result;
        if (cardListResult == null) {
            return;
        }
        if (cardListResult.isSuccessful()) {
            setDataList(cardListResult.data.list);
        } else {
            showErrorToast(cardListResult.getReturnMessage());
        }
    }

    protected void setDataList(ArrayList<OrderListResult.BankCard> list) {
        //
    }

    @Override
    public boolean onRequestFail() {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_commit:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserBindBankCard));
                break;
        }
    }
}
