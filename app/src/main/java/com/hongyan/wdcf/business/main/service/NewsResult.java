package com.hongyan.wdcf.business.main.service;

import com.hongyan.base.BaseResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class NewsResult extends BaseResult {

    public Data data;

    static class Data {
        public ArrayList<News> newsList;
        public ArrayList<Ad> topAd;
    }

    static class News {
        public String photo;
        public String url;
        public String id;
        public String address;
        public String end_time;
        public String start_time;
        public String title;
        public String content;
        public String source;
        public String create_time;
    }

    static class Ad{
        public String photo;
        public String url;
        public String id;
    }

}
