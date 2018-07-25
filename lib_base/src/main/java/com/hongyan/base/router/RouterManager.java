package com.hongyan.base.router;


import android.content.Context;
import android.content.Intent;

import com.hongyan.base.BaseApplication;

import java.util.Map;

public class RouterManager {

    private static volatile RouterManager instance;

    private RouterManager() {
    }

    public static RouterManager getInstance() {
        if (instance == null) {
            synchronized (RouterManager.class) {
                if (instance == null) {
                    instance = new RouterManager();
                }
            }
        }
        return instance;
    }

    /**
     * 先判断类型
     */
    public void openUrl(Router router) {
        if (router == null) {
            return;
        }
        String routerUrl = router.getUrl();
        if (routerUrl == null || routerUrl.length() == 0) {
            return;
        }
        if (routerUrl.startsWith("http")) {
            openWebActivity(router);
        } else if (routerUrl.startsWith("native")) {
            openNativeActivity(router);
        } else {
        }
    }

    private void openWebActivity(Router router) {
        if (router == null || getContext() == null) {
            return;
        }
        Context context = getContext();
        Class clz = null;
        try {
            clz = Class.forName("com.hongyan.wdcf.base.BaseWebViewActivity");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (clz == null) {
            return;
        }
        Intent intent = new Intent(context, clz);
        Map<String, String> params = router.getParams();
        if (params != null) {
            for (String key : params.keySet()) {
                String value = params.get(key);
                intent.putExtra(key, value);
            }
        }
        intent.putExtra("url", getHandleUrl(router.getUrl(), router.getParams()));
        context.startActivity(intent);
    }

    private void openNativeActivity(Router router) {
        if (router == null || getContext() == null) {
            return;
        }
        Context context = getContext();
        Class clz = null;
        try {
            clz = Class.forName(router.getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (clz == null) {
            return;
        }
        Intent intent = new Intent(context, clz);
        Map<String, String> params = router.getParams();
        if (params != null) {
            for (String key : params.keySet()) {
                String value = params.get(key);
                intent.putExtra(key, value);
            }
        }
        context.startActivity(intent);
    }

    /**
     * 拼接参数
     */
    private String getHandleUrl(String url, Map<String, String> params) {
        if (url == null || url.length() <= 1) {
            return url;
        }
        if (params != null) {
            StringBuilder builder = new StringBuilder(url);
            for (String key : params.keySet()) {
                String urlTemp = builder.toString();
                String keyAndValue = key + "=" + params.get(key);
                if (urlTemp.contains("?")) {
                    builder.append("&").append(keyAndValue);
                } else {
                    builder.append("?").append(keyAndValue);
                }
            }
            return builder.toString();
        }
        return url;
    }


    private Context getContext() {
        return BaseApplication.getInstance().getApplicationContext();
    }

}
