package com.hongyan.wdcf.business.main.discover;

import com.hongyan.base.BaseResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class DiscoverResult extends BaseResult {

    public Data data;

    static class Data {
        public ArrayList<HomeTopAd> homeTopAd;
        public ArrayList<HomeMediaAd> homeMedioAd;//中部广告位
        public ArrayList<HomeBottomAd> homeFootAd;//底部广告位
        public ArrayList<HotArticle> hotArticle;//热点资讯
        public ArrayList<AssetArticle> assetArticle;//资产配置
        public ArrayList<homeEvent> homeEvent;//精彩活动
    }

    static class HomeTopAd {
        public String photo;
        public String url;
        public String id;
    }

    static class HomeMediaAd {
    }

    static class HomeBottomAd {
    }

    static class HotArticle {
    }

    static class AssetArticle {
    }

    static class homeEvent {
    }
}
