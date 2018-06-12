package com.hongyan.base;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkManger {

    private static volatile NetworkManger instance;
    private RequestQueue mRequestQueue;

    private NetworkManger() {
    }

    public static NetworkManger getInstance() {
        if (instance == null) {
            synchronized (NetworkManger.class) {
                if (instance == null) {
                    instance = new NetworkManger();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        if (this.mRequestQueue == null) {
            this.mRequestQueue = Volley.newRequestQueue(context);
        }
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}
