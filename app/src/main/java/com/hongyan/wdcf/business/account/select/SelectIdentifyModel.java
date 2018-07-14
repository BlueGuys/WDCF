package com.hongyan.wdcf.business.account.select;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.business.account.feedback.FeedbackHolder;
import com.hongyan.wdcf.business.main.discover.DiscoverResult;
import com.hongyan.wdcf.config.UrlConst;

/**
 * Created by wangning on 2018/7/7.
 */

public class SelectIdentifyModel extends BaseModel {

    private SelectIdentifyHolder viewHolder;

    private String type = "1";//'内地',2=>'港澳台',3=>'外籍'
    private String id_type = "1"; //1=>'身份证',2=>'护照',3=>'港澳台',4=>'军官证',5=>'其他'
    private String id_number;
    private String email;
    private String address;
    private String city;
    private String name;

    public SelectIdentifyModel(SelectIdentifyHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void commit() {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getEditUserUrl());
        feedbackCall.setResultClass(SelectIdentifyResult.class);
        feedbackCall.addParam(RequestKeyTable.TYPE, type);
        feedbackCall.addParam(RequestKeyTable.CITY, city);
        feedbackCall.addParam(RequestKeyTable.USER_NICENAME, name);
        feedbackCall.addParam(RequestKeyTable.ADDRESS, address);
        feedbackCall.addParam(RequestKeyTable.EMAIL, email);
        feedbackCall.addParam(RequestKeyTable.ID_NUMBER, id_number);
        feedbackCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                SelectIdentifyResult selectIdentifyResult = (SelectIdentifyResult) result;
                if (selectIdentifyResult.isSuccessful()) {
                    viewHolder.showSuccessToast("提交成功");
                    RouterManager.getInstance().openUrl(new Router(RouterConfig.UserBindTeacher));
                }
            }

            @Override
            public void onError(BaseResult.Error error) {
                viewHolder.showSuccessToast("提交失败");
            }
        });
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }
}
