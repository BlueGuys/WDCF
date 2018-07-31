package com.hongyan.wdcf.business.product.fixed;

import com.hongyan.StringUtils;
import com.hongyan.base.BaseResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class FixedProductListResult extends BaseResult {

    public Data data;

    static class Data {
        public ArrayList<Product> list;
        private String hasMore;
        public String next_page;

        public boolean hasMore() {
            return StringUtils.notEmpty(hasMore) && "1".equals(hasMore);
        }
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
