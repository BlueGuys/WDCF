package com.hongyan.base.router;

import java.util.HashMap;

/**
 * Created by wangning on 2018/7/9.
 */

public final class RouterConst {

    private static HashMap<String, String> routerList;

    static {
        routerList = new HashMap<>();
    }

    public static String getRouteClass(String key) {
        String className;
        if (key == null || key.length() <= 0) {
            className = "";
        } else {
            className = routerList.get(key);
        }
        return className;
    }

    public static void addRouter(String key, String className) {
        if (key != null && key.length() > 0 && className != null && className.length() > 0) {
            routerList.put(key, className);
        }
    }

}
