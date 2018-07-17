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
        public String photo;
        public String url;
        public String id;
        public String detail_url;
    }

    static class HomeBottomAd {
        public String photo;
        public String url;
        public String id;
    }

    static class HotArticle {
        public String photo;
        public String url;
        public String excerpt;
        public String id;
        public String title;
        public String create_time;
        public String content;
        public String source;
        public String detail_url;
    }

    static class AssetArticle {
        public String photo;
        public String url;
        public String id;
        public String title;
        public String create_time;
        public String content;
        public String excerpt;
        public String source;
        public String detail_url;
    }

    static class homeEvent {
        public String photo;
        public String url;
        public String id;
        public String detail_url;
        public String title;
    }
}
