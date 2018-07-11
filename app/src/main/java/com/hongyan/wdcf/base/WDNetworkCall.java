package com.hongyan.wdcf.base;

import com.hongyan.base.BaseResult;
import com.hongyan.base.NetworkCall;
import com.hongyan.wdcf.business.account.core.AccountManager;

/**
 * Created by wangning on 2018/7/11.
 */

public class WDNetworkCall<T extends BaseResult> extends NetworkCall {

    public WDNetworkCall() {
        addParam(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
    }
}
