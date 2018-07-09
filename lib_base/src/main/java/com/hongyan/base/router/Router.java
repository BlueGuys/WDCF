package com.hongyan.base.router;

import com.hongyan.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangning on 2018/7/9.
 */

public class Router {

    private String url;
    private String className;

    private Map<String, String> params = new HashMap<>();

    public Router(String url) {
        this.url = url;
    }

    public Router() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClassName() {
        return RouterConst.getRouteClass(this.url);
    }

    public void addParams(String key, String value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return;
        }
        params.put(key, value);
    }

    public void addParams(HashMap<String, String> param) {
        if (params == null) {
            return;
        }
        params.putAll(param);
    }

    public Map<String, String> getParams() {
        return params;
    }
}
