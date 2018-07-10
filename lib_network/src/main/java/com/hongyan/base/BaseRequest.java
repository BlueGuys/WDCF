package com.hongyan.base;


import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.hongyan.parse.GsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class BaseRequest<T extends BaseResult> extends Request<BaseResponse> {

    private Response.Listener<BaseResponse> mResponseListener;
    private Response.ErrorListener mErrorListener;
    private Class<T> mResultClass = null;
    private HashMap<String, String> mMap = new HashMap();
    private boolean checkLogin = false;

    public BaseRequest(Class<T> resultClass, String url, Response.Listener<BaseResponse> listener, Response.ErrorListener errorListener) {
        this(Method.POST, url, listener, errorListener);
        mResultClass = resultClass;
        mErrorListener = errorListener;
        addCommonParams();
    }

    private BaseRequest(int method, String url, Response.Listener<BaseResponse> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mResponseListener = listener;
        DefaultRetryPolicy retryPolicy = new DefaultRetryPolicy(30 * 1000, 0, 1.0f);
        setRetryPolicy(retryPolicy);
        setShouldCache(true);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> tHeaderMap = new HashMap<>();
        return tHeaderMap;
    }

    @Override
    protected void deliverResponse(BaseResponse response) {
        if (mResponseListener != null) {
            mResponseListener.onResponse(response);
        }
    }

    @Override
    public void deliverError(VolleyError error) {
        if (mErrorListener != null) {
            mErrorListener.onErrorResponse(error);
        }
    }

    @Override
    protected Response<BaseResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        if (mResponseListener != null && networkResponse != null) {
            BaseResponse response = new BaseResponse();
            String string;
            try {
                string = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            } catch (UnsupportedEncodingException e) {
                string = new String(networkResponse.data);
            }
            response.setResponse(string);
            BaseResult result = GsonUtils.gsonResolve(string, mResultClass);
            response.setResult(result);
            return Response.success(response, HttpHeaderParser.parseCacheHeaders(networkResponse));
        }
        return null;
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        return super.parseNetworkError(volleyError);
    }

    public void addParam(String key, String value) {
        if (value == null) {
            return;
        }
        mMap.put(key, value);
    }

    public void addParam(HashMap<String, String> params) {
        mMap.putAll(params);
    }

    public void addParam(String key, int value) {
        mMap.put(key, String.valueOf(value));
    }

    public void setCheckLogin(boolean checkLogin) {
        this.checkLogin = checkLogin;
    }

    public Map<String, String> getParams() {
        return mMap;
    }

    private void addCommonParams() {
        String currentTime = System.currentTimeMillis() + "";
        String time = currentTime.substring(0, 10);
        mMap.put("sdkClientVersion", "1.0.0");
        mMap.put("appID", "1");
        mMap.put("platform", "android");
        mMap.put("timestamp", time);
    }
}

