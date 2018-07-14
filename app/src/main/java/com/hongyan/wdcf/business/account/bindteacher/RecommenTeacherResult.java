package com.hongyan.wdcf.business.account.bindteacher;

import com.hongyan.base.BaseResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class RecommenTeacherResult extends BaseResult {

    public Data data;

    static class Data {
        public String user_nicename;
        public String id_number;
        public String address;
    }


}
