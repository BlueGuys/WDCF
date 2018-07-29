package com.hongyan.wdcf.business.teacher.customer;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.hongyan.SoftInputUtils;
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

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2018/6/10.
 */

public class CustomerListHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private CommonIndicator indicator;
    private ViewPager viewPager;
    private CustomerPagerAdapter adapter;
    private EditText editText;

    private List<Fragment> fragments = new ArrayList<>();

    public CustomerListHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_customer_list_teacher;
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
        indicator.setTab(new String[]{"全部客户", "在投客户"});
        viewPager = rootView.findViewById(R.id.viewpager);
        editText = rootView.findViewById(R.id.et_search);

        fragments.add(new AllCustomerFragment());
        fragments.add(new RunCustomerFragment());

        adapter = new CustomerPagerAdapter(mActivity.getSupportFragmentManager(), fragments);
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
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    SearchTextChangeEvent s = new SearchTextChangeEvent();
                    s.setSearchKey(editText.getText().toString());
                    EventBus.getDefault().post(s);
                    SoftInputUtils.hideSoftKeyPad(mActivity,editText);
                }
                return false;
            }
        });
    }

    @Override
    public int getNavigationTitle() {
        return R.string.customer_info;
    }

    @Override
    public RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(CustomerListResult.class);
        bean.setRequestUrl(UrlConst.getMyOrderListUrl());
        bean.addParam(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
        return bean;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
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
