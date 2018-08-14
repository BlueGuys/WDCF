package com.hongyan.wdcf.business.teacher.share;


import com.hongyan.wdcf.R;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/4/10.
 */

public class ShareDataFactory {

    public static ArrayList<ShareChannel> getShareChannelList() {
        ArrayList<ShareChannel> list = new ArrayList<>();
        list.add(new ShareChannel(0, R.drawable.icon_wechat, "微信"));
        list.add(new ShareChannel(1, R.drawable.icon_moments, "朋友圈"));
        list.add(new ShareChannel(2, R.drawable.icon_qq, "qq"));
        return list;
    }

}
