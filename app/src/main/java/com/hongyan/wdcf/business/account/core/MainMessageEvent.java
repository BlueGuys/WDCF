package com.hongyan.wdcf.business.account.core;

/**
 * Created by wangning on 2018/3/21.
 */

public class MainMessageEvent {

    private int position;

    public MainMessageEvent(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
