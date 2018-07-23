package com.hongyan.wdcf.business.teacher.customerList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

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
import com.hongyan.wdcf.business.account.core.AccountMessageEvent;
import com.hongyan.wdcf.config.UrlConst;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/6/10.
 */

public class CustomerListHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private CustomerListAdapter adapter;
    private PullToRefreshListView listView;
    private Button button;

    public CustomerListHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_customer_list;
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
        button = rootView.findViewById(R.id.btn_commit);
        button.setOnClickListener(this);
        adapter = new CustomerListAdapter(mActivity);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomerListResult.Customer customer = adapter.getItem(position - 1);
                EventBus.getDefault().post(new CustomerMessageEvent(customer.id, customer.user_nicename));
                mActivity.finish();
            }
        });
    }

    @Override
    public int getNavigationTitle() {
        return R.string.customer;
    }

    @Override
    public RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(CustomerListResult.class);
        bean.setRequestUrl(UrlConst.getCustomerListUrl());
        bean.addParam(RequestKeyTable.IS_INVEST, "0");
        bean.addParam(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
        return bean;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
        CustomerListResult customerListResult = (CustomerListResult) result;
        if (customerListResult == null) {
            return;
        }
        if (customerListResult.isSuccessful()) {
            setDataList(customerListResult.data.list);
        } else {
            showErrorToast(customerListResult.getReturnMessage());
        }
    }

    protected void setDataList(ArrayList<CustomerListResult.Customer> list) {
        adapter.setData(list);
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
