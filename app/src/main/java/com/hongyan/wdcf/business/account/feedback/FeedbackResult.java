package com.hongyan.wdcf.business.account.feedback;

import com.hongyan.base.BaseResult;

/**
 * Created by wangning on 2018/7/7.
 */

public class FeedbackResult extends BaseResult {

    public Data data;

    static class Data {
        public String user_type;//2 用户 3理财师
        public String token;
    }

}
