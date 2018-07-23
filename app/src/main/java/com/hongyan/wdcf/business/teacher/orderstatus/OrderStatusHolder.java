package com.hongyan.wdcf.business.teacher.orderstatus;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;

/**
 * Created by wangning on 2018/6/10.
 */

public class OrderStatusHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private OrderStatusModel introductionModel;
    private EditText editText;
    private String orderID;
    private int status;

    public OrderStatusHolder(BaseActivity mActivity) {
        super(mActivity);
        introductionModel = new OrderStatusModel(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_order_status;
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
        Button buttonCommit = rootView.findViewById(R.id.btn_commit);
        editText = rootView.findViewById(R.id.et_feedback);
        buttonCommit.setOnClickListener(this);
    }

    @Override
    public int getNavigationTitle() {
        return R.string.order_status_setting;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_commit:
                String content = editText.getText().toString();
                if (content.length() < 15) {
                    showErrorToast("字数太少");
                    return;
                }
                introductionModel.setContent(content);
                introductionModel.setStatus(status);
                introductionModel.setId(orderID);
                introductionModel.commit();
                break;
        }
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}
