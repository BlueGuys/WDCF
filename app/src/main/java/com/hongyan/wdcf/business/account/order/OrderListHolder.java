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
import com.hongyan.wdcf.widget.CommonIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2018/6/10.
 */

public class OrderListHolder extends BaseViewHolder implements IViewHolder {

    private CommonIndicator indicator;
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
        return false;
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
        viewPager.setOffscreenPageLimit(3);
        indicator.setTab(new String[]{"预约", "活动", "交易"});
        indicator.setOnTabChangedListener(new CommonIndicator.OnTabChangedListener() {
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
                indicator.setCurrentTab(position);
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
