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
        public ArrayList<Fixation> classFixation;
        public ArrayList<Equity> privateEquity;

    }

    static class Ad {
        public String photo;
        public String url;
        public String detail_url;
        public String id;
    }

    static class Fixation {
        public String title;
        public String rate;
        public String status;
        public String scale;
        public String term_id;
        public String excerpt;
        public String end_time;
        public String photo;
        public String detail_url;
        public String effecStr;
    }

    static class Equity {
        public String title;
        public String rate;
        public String status;
        public String scale;
        public String term_id;
        public String excerpt;
        public String end_time;
        public String photo;
        public String detail_url;
        public String effecStr;
    }

}
