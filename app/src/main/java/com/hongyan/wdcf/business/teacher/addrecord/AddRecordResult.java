package com.hongyan.wdcf.business.teacher.addrecord;

import com.hongyan.base.BaseResult;

/**
 * Created by wangning on 2018/7/7.
 */

public class AddRecordResult extends BaseResult {

    public Data data;

    static class Data {
        public String user_type;//2 用户 3理财师
        public String token;
    }

}
