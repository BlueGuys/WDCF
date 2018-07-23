package com.hongyan.wdcf.business.teacher.addrecord;

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

public class AddRecordModel extends BaseModel {

    private AddRecordHolder viewHolder;
    private String id;
    private String remarks;
    private String linkup_time;
    private String remind_time;

    public AddRecordModel(AddRecordHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void commit() {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getAddRecordUrl());
        feedbackCall.setResultClass(AddRecordResult.class);
        feedbackCall.addParam(RequestKeyTable.REMARKS, remarks);
        feedbackCall.addParam(RequestKeyTable.ID, id);
        feedbackCall.addParam(RequestKeyTable.LINK_UP_TIME, linkup_time);
        feedbackCall.addParam(RequestKeyTable.REMIND_TIME, remind_time);
        feedbackCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                AddRecordResult addRecordResult = (AddRecordResult) result;
                if (addRecordResult.isSuccessful()) {
                    viewHolder.showSuccessToast("提交成功");
                    viewHolder.goBack();
                }
            }

            @Override
            public void onError(BaseResult.Error error) {

            }
        });
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setLinkup_time(String linkup_time) {
        this.linkup_time = linkup_time;
    }

    public void setRemind_time(String remind_time) {
        this.remind_time = remind_time;
    }
}
