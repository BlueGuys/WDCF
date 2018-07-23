package com.hongyan.wdcf.business.teacher.customerList;

import com.hongyan.base.BaseResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class CustomerListResult extends BaseResult {

    public Data data;

    static class Data {
        public ArrayList<Customer> list;
    }

    static class Customer {
        public String user_nicename;
        public String id;
        public String mobile;
        public String review_str;
        public String avatar;

        public String getUIMobile() {
            if (mobile != null && mobile.length() == 11) {
                return mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
            }
            return mobile;
        }
    }

}
