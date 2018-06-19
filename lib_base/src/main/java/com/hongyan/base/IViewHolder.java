package com.hongyan.base;

import android.view.View;

/**
 * Created by wangning on 2018/6/18.
 */

public interface IViewHolder {

    int LAYOUT_TYPE_COMMON = 0;
    int LAYOUT_TYPE_LIST = 1;

    int getLayoutID();

    int getLayoutType();

    boolean needPageRequest();

    void initView(View rootView);

    int getNavigationTitle();

    RequestBean getRequestBean();

    <T extends BaseResult> void onRequestSuccess(T result);

    boolean onRequestFail();

}
