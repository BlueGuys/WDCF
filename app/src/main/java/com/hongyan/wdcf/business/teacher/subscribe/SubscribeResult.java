package com.hongyan.wdcf.business.teacher.subscribe;

import com.hongyan.base.BaseResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class SubscribeResult extends BaseResult {

    public Data data;

    static class Data {
        public ArrayList<Record> list;
    }

    static class Record {
        public String id;
        public String user_nicename;
        public int term_id;
        public String term_str;
        public String create_time;

        public String getType() {
            switch (term_id) {
                case 5:
                    return "";
                case 6:
                    return "私募股权";
                default:
                    return "保险服务";
            }
        }
    }

}
