package com.hongyan.wdcf.business.subscribe;

import com.hongyan.base.BaseResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class SubscribeResult extends BaseResult {

    public Data data;

    static class Data {
        public ArrayList<BankCard> list;
    }

    static class BankCard{

    }

}
