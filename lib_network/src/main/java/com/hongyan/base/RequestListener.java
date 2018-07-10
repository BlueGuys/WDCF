package com.hongyan.base;

/**
 * Created by wangning on 2018/6/10.
 */

public interface RequestListener {

    <T extends BaseResult> void onResponse(T result);

    void onError(BaseResult.Error error);

}
