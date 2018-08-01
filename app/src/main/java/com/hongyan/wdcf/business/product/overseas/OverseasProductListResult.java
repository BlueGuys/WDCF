package com.hongyan.wdcf.business.product.overseas;

import com.hongyan.base.BaseResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class OverseasProductListResult extends BaseResult {

    public Data data;

    static class Data {
        public ArrayList<Product> list;
    }

    static class Product {
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
        public String surplus_money;
    }

}
