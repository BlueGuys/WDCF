package com.hongyan.wdcf.business.account.core;

import com.hongyan.base.BaseResult;

public class Account extends BaseResult {

    public Data data;

    class Data {
        public String id;
        public String email;
        public String status;
        public String nickname;
        public String mobile;
    }

}
