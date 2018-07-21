package com.hongyan.wdcf.business.teacher.subscribe;

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

public class SubscribeHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private CommonIndicator indicator;
    private ViewPager viewPager;
    private SubscribePagerAdapter adapter;

    private List<Fragment> fragments = new ArrayList<>();

    public SubscribeHolder(BaseActivity mActivity) {
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
        indicator.setTab(new String[]{"待受理", "已签约", "预约不成功"});
        viewPager = rootView.findViewById(R.id.viewpager);

        fragments.add(new WaitFragment());
        fragments.add(new DoneFragment());
        fragments.add(new FailedFragment());

        adapter = new SubscribePagerAdapter(mActivity.getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
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
        return R.string.subscribe_handle;
    }

    @Override
    public RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(SubscribeResult.class);
        bean.setRequestUrl(UrlConst.getMyOrderListUrl());
        bean.addParam(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
        return bean;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
        SubscribeResult cardListResult = (SubscribeResult) result;
        if (cardListResult == null) {
            return;
        }
        if (cardListResult.isSuccessful()) {
            setDataList(cardListResult.data.list);
        } else {
            showErrorToast(cardListResult.getReturnMessage());
        }
    }

    protected void setDataList(ArrayList<SubscribeResult.BankCard> list) {
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
