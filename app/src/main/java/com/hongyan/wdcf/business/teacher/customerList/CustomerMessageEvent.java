package com.hongyan.wdcf.business.teacher.customerList;

/**
 * Created by wangning on 2018/3/21.
 */

public class CustomerMessageEvent {

    private String id;
    private String name;

    public CustomerMessageEvent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
