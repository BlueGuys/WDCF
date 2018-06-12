package com.hongyan.base;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.HashMap;

/**
 * Created by wangning on 2018/6/10.
 */

public class NetworkCall<T extends BaseResult> {

    public void start(Class<T> resultClass, String url, HashMap<String, String> params, final RequestListener listener) {
        BaseModel baseModel = new BaseModel();
        BaseRequest request = new BaseRequest<>(resultClass, url, new Response.Listener<BaseResponse>() {
            @Override
            public void onResponse(BaseResponse response) {
                if (response == null || response.getResult() == null) {
                    return;
                }
                if (listener != null) {
                    listener.onResponse(response.getResult());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (listener != null) {
                    listener.onError(new BaseError());
                }
            }
        });
        baseModel.sendRequest(request);
    }

}
