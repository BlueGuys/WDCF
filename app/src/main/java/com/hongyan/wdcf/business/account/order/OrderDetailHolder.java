package com.hongyan.wdcf.business.account.order;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
import com.hongyan.wdcf.widget.ItemA;

/**
 * Created by wangning on 2018/6/10.
 */

public class OrderDetailHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private TextView tvCommit;
    private ItemA itemStatus;
    private ItemA itemDate;
    private ItemA itemTerm;
    private ItemA itemRate;
    private ItemA itemNumber;
    private ItemA itemTeacherName;
    private ItemA itemTeacherMobile;
    private String id;

    public OrderDetailHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_order_detail;
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
        tvCommit = rootView.findViewById(R.id.tv_commit);
        itemStatus = rootView.findViewById(R.id.item_order_status);
        itemDate = rootView.findViewById(R.id.item_order_date);
        itemTerm = rootView.findViewById(R.id.item_order_term);
        itemRate = rootView.findViewById(R.id.item_order_rate);
        itemNumber = rootView.findViewById(R.id.item_order_number);
        itemTeacherName = rootView.findViewById(R.id.item_teacher_name);
        itemTeacherMobile = rootView.findViewById(R.id.item_teacher_mobile);
    }

    @Override
    public int getNavigationTitle() {
        return R.string.order_detail;
    }

    @Override
    public RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(OrderDetailResult.class);
        bean.setRequestUrl(UrlConst.getOrderDetailUrl());
        bean.addParam(RequestKeyTable.ID, id);
        bean.addParam(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
        return bean;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
        OrderDetailResult cardListResult = (OrderDetailResult) result;
        if (cardListResult == null || cardListResult.data == null) {
            return;
        }
        OrderDetailResult.Data order = cardListResult.data;
        itemStatus.setTitle(order.product_title);
        itemStatus.setDesc(order.status_str);
        itemDate.setDesc(order.create_time);
        itemTerm.setDesc(order.tlimit);
        itemRate.setDesc(order.rate);
        itemNumber.setDesc(order.order_no);
        itemTeacherName.setDesc(order.finaplanner_name);
        itemTeacherMobile.setDesc(order.finaplanner_mobile);
    }

    @Override
    public boolean onRequestFail() {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_commit:
                showSuccessToast("敬请期待");
                break;
        }
    }

    public void setId(String id) {
        this.id = id;
    }
}
