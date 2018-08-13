package com.hongyan.wdcf.business.account.share;

import com.hongyan.base.BaseResult;

import java.util.ArrayList;

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
