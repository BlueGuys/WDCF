package com.hongyan.wdcf.business.teacher.activitydetail;

import com.hongyan.base.BaseResult;

/**
 * Created by wangning on 2018/7/7.
 */

public class ActivityDetailResult extends BaseResult {

    public Data data;

    static class Data {
        public String id;
        public String product_title;
        public String tlimit;
        public String order_no;
        public String create_time;
        public String rate;
        public String status_str;
        public String finaplanner_name;
        public String finaplanner_mobile;
    }

//            "id": "89",
//            "uid": "12",
//            "order_no": "2018072619320416352",
//            "order_total": null,
//            "term_str": "私募股权",
//            "tlimit": "5年",
//            "status": "0",
//            "create_time": "2018-07-26",
//            "update_time": "2018-07-26 19:32:04",
//            "rate": "4%",
//            "finaplanner_id": "9",
//            "finaplanner_mobile": "13261925141",
//            "product_id": "11",
//            "remarks": null,
//            "finaplanner_name": "理财师向",
//            "product_title": "英国某某私募基金1",
//            "user_nicename": "王宁",
//            "term_id": "6",
//            "is_delete": "0",
//            "user_mobile": "18600412701",
//            "status_str": "待受理",
//            "mid": "89"
}
