package com.hongyan.wdcf.business.teacher.activitydetail;

import android.view.View;
import android.widget.TextView;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.config.UrlConst;
import com.hongyan.wdcf.widget.ItemA;

/**
 * Created by wangning on 2018/6/10.
 */

public class ActivityDetailHolder extends BaseViewHolder implements IViewHolder {

    private TextView tvMore;
    private ItemA itemTitle;
    private ItemA itemTime;
    private ItemA itemNo;
    private String id;
    private String title;
    private String statusStr;
    private String createTime;
    private String number;

    public ActivityDetailHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_activity_detail;
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
        itemTitle = rootView.findViewById(R.id.item_order_title);
        itemTime = rootView.findViewById(R.id.item_order_time);
        itemNo = rootView.findViewById(R.id.item_order_no);
        tvMore = rootView.findViewById(R.id.tv_more);
        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        itemTitle.setTitle(title);
        itemTitle.setDesc(statusStr);
        itemTime.setDesc(createTime);
        itemNo.setDesc(number);
    }

    @Override
    public int getNavigationTitle() {
        return R.string.order_detail;
    }

    @Override
    public RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(ActivityDetailResult.class);
        bean.setRequestUrl(UrlConst.getOrderDetailUrl());
        bean.addParam(RequestKeyTable.ID, id);
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

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
