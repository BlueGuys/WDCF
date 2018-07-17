package com.hongyan.wdcf.business.account.core;

/**
 * Created by wangning on 2018/3/21.
 */

public class MainActivityEvent {

    public static final int ON_CREATE = 0;
    public static final int ON_START = 1;
    public static final int ON_RESUME = 2;

    public int lifecycle = -1;

    public MainActivityEvent(int lifecycle) {
        this.lifecycle = lifecycle;
    }
}
