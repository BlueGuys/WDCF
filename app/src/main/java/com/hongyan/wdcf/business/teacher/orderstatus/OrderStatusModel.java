package com.hongyan.wdcf.business.teacher.orderstatus;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.business.main.discover.DiscoverResult;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class OrderStatusModel extends BaseModel {

    private OrderStatusHolder viewHolder;
    private int status;
    private String content;
    private String id;

    public OrderStatusModel(OrderStatusHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void commit() {
        WDNetworkCall editOrderCall = new WDNetworkCall<>();
        editOrderCall.setRequestUrl(UrlConst.getOrderStatusEditUrl());
        editOrderCall.setResultClass(OrderStatusResult.class);
        editOrderCall.addParam(RequestKeyTable.REMARKS, content);
        editOrderCall.addParam(RequestKeyTable.STATUS, String.valueOf(status));
        editOrderCall.addParam(RequestKeyTable.ID, id);
        editOrderCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                OrderStatusResult orderStatusResult = (OrderStatusResult) result;
                if (orderStatusResult.isSuccessful()) {
                    viewHolder.showSuccessToast("提交成功");
                    viewHolder.goBack();
                } else {
                    viewHolder.showErrorToast(orderStatusResult.getReturnMessage());
                }
            }

            @Override
            public void onError(BaseResult.Error error) {

            }
        });
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }
}
