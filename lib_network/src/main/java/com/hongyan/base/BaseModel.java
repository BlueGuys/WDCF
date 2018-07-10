package com.hongyan.base;


import com.android.volley.RequestQueue;

/**
 * Created by wangning on 2018/4/24.
 */

public class BaseModel {

    public BaseModel() {

    }

    public void sendRequest(BaseRequest request) {
        RequestQueue requestQueue = NetworkManger.getInstance().getRequestQueue();
        if (requestQueue != null) {
            requestQueue.add(request);
        }
    }
}
