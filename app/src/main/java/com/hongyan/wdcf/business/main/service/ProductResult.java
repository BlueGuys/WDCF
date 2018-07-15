package com.hongyan.wdcf.business.main.service;

import com.hongyan.base.BaseResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class ProductResult extends BaseResult {

    public Data data;

    static class Data {
        public ArrayList<Ad> topAd;
    }

    static class Ad {
        public String photo;
        public String url;
        public String id;
    }

}
