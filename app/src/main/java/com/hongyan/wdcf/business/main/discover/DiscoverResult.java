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
        public ArrayList<HomeMediaAd> homeMedioAd;
        public ArrayList<HomeBottomAd> homeFootAd;
        public ArrayList<HotArticle> hotArticle;
        public ArrayList<AssetArticle> assetArticle;
        public ArrayList<homeEvent> homeEvent;
    }

    static class HomeTopAd {

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
