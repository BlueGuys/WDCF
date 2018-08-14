package com.hongyan.wdcf.business.teacher.invite;

import com.hongyan.base.BaseResult;

/**
 * Created by wangning on 2018/7/7.
 */

public class ShareResult extends BaseResult {

    public Data data;

    static class Data {
        public String title;
        public String intro;
        public String photo;
        public String url;
    }
}
