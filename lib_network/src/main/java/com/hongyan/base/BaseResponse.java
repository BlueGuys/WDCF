package com.hongyan.base;

/**
 * com.jp.base.BaseResponse
 *
 * @author wangning
 * @version 2.1.0
 * @date 2017/7/6:15:24
 * @desc
 */
public class BaseResponse {

    private String mResponse;

    private BaseResult mResult;

    public String getResponse() {
        return mResponse;
    }

    public void setResponse(String response) {
        this.mResponse = response;
    }

    public BaseResult getResult() {
        return mResult;
    }

    public void setResult(BaseResult result) {
        this.mResult = result;
    }
}
