package com.hongyan.wdcf.business.main.service;

import com.hongyan.base.BaseResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class ActivityResult extends BaseResult {

    public Data data;

    static class Data {
        public ArrayList<Activity> list;
    }

    static class Activity {
        public String photo;
        public String url;
        public String id;
        public String address;
        public String end_time;
        public String start_time;
        public String title;
        public String detail_url;
        public String tags;
    }

}
