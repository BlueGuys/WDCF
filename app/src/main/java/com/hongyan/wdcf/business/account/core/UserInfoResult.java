package com.hongyan.wdcf.business.account.core;

import com.hongyan.base.BaseResult;

/**
 * Created by wangning on 2018/7/7.
 */

public class UserInfoResult extends BaseResult {

    public Data data;

    static class Data {
        public String id;
        public String user_type;//2 用户 3理财师
        public String user_nicename;
        public String user_email;
        public String avatar;
        public String mobile;
        public String auth_status;
        public String id_number;
        public String address;
        public String company;
        public String content;
    }

    //        "id": "12",
//        "user_type": "2",
//        "user_login": "18600412701",
//        "user_pass": "6d5708a3f12a4607e782c4d86fd5364d7e4508bb10d91a59",
//        "user_nicename": "",
//        "user_email": "",
//        "writerid": null,
//        "avatar": null,
//        "last_login_ip": "61.149.12.13",
//        "last_login_time": "2018-07-11 16:04:14",
//        "user_status": "1",
//        "mobile": "18600412701",
//        "is_delete": "0",
//        "create_time": "2018-07-10 20:31:59",
//        "update_time": "2018-07-10 20:31:59",
//        "finaplanner_id": null,
//        "id_number": null,
//        "id_type": null,
//        "id_photo": null,
//        "auth_status": "1",
//        "city": null,
//        "senior_flag": "0",
//        "id_cate": null,
//        "is_invest": "0",
//        "review": "0",
//        "finaplanner_status": null,
//        "yq_code": null,
//        "is_choose": "0",
//        "address": null,
//        "id_address": null,
//        "birthday": null,
//        "sex": null,
//        "hkm_pass_id": null,
//        "work_age": null,
//        "grade": null,
//        "department": null,
//        "employee_id": null,
//        "tags": null,
//        "content": null,
//        "honor": null,
//        "fund_num": null,
//        "step": 1,
//        "mid": "12"

}
