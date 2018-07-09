package com.hongyan.base;

import java.util.HashMap;

/**
 * Created by wangning on 2018/6/10.
 */

public class RequestBean<T> {

    private String requestUrl;
    private HashMap<String, String> params = new HashMap<>();

    private Class<T> resultClass;

    public RequestBean(Class<T> resultClass) {
        this.resultClass = resultClass;
    }

    public Class<T> getResultClass() {
        return resultClass;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void addParam(String key, String value) {
        if (key != null && key.length() > 0 && value != null && value.length() > 0) {
            params.put(key, value);
        }
    }
}
