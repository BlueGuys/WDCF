package com.hongyan.wdcf.business.account.bankcard;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

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
import com.hongyan.wdcf.business.main.MainResult;
import com.hongyan.wdcf.config.UrlConst;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/6/10.
 */

public class BankCardListHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private BankCardListAdapter adapter;
    private ListView listView;
    private Button button;

    public BankCardListHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_bankcard_list;
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
        adapter = new BankCardListAdapter();
        listView.setAdapter(adapter);
    }

    @Override
    public int getNavigationTitle() {
        return R.string.my_bankcard;
    }

    @Override
    public RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(BankCardListResult.class);
        bean.setRequestUrl(UrlConst.getBankCardListUrl());
        bean.addParam(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
        return bean;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
        BankCardListResult cardListResult = (BankCardListResult) result;
        if (cardListResult == null) {
            return;
        }
        if (cardListResult.isSuccessful()) {
            setDataList(cardListResult.data.list);
        } else {
            showErrorToast(cardListResult.getReturnMessage());
        }
    }

    protected void setDataList(ArrayList<BankCardListResult.BankCard> list) {
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
