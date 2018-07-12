package com.hongyan.wdcf.business.main.discover;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.widget.ScrollBannerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2018/7/11.
 */

public class DiscoverAdapter extends BaseAdapter {

    private static final int TYPE_BANNER = 0;
    private static final int TYPE_HOT_ARTICLE = 1;
    private static final int TYPE_MIDDLE_AD = 2;
    private static final int TYPE_ASSET_ARTICLE = 3;
    private static final int TYPE_BOTTOM_AD = 4;
    private static final int TYPE_EVENT = 5;

    private DiscoverResult.Data data;

    public void setData(DiscoverResult.Data data) {
        if (data == null) {
            return;
        }
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (data == null) {
            return 0;
        }
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_BANNER;
            case 1:
                return TYPE_HOT_ARTICLE;
            case 2:
                return TYPE_MIDDLE_AD;
            case 3:
                return TYPE_ASSET_ARTICLE;
            case 4:
                return TYPE_BOTTOM_AD;
            case 5:
                return TYPE_EVENT;
        }
        return 6;
    }

    @Override
    public int getViewTypeCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            switch (getItemViewType(position)) {
                case TYPE_BANNER:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_head, parent, false);
                    handleHeader(convertView);
                    break;
                case TYPE_HOT_ARTICLE:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_hot, parent, false);
                    break;
                case TYPE_MIDDLE_AD:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_top_ad, parent, false);
                    break;
                case TYPE_ASSET_ARTICLE:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_asset, parent, false);
                    break;
                case TYPE_BOTTOM_AD:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_bottom_ad, parent, false);
                    break;
                case TYPE_EVENT:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_event, parent, false);
                    break;
            }
        }
        return convertView;
    }

    private void handleHeader(View convertView) {
        ArrayList<DiscoverResult.HomeTopAd> homeTopAd = data.homeTopAd;
        ArrayList<ScrollBannerView.Entity> entityArrayList = new ArrayList<>();
        ScrollBannerView bannerView = convertView.findViewById(R.id.banner);
        for (int i = 0; i < homeTopAd.size(); i++) {
            ScrollBannerView.Entity entity = new ScrollBannerView.Entity();
            entity.setImageUrl(homeTopAd.get(i).photo);
            entity.setTitle("");
            entityArrayList.add(entity);
        }
        bannerView.setData(entityArrayList);
        bannerView.setOnPageClickListener(new ScrollBannerView.OnPageClickListener() {
            @Override
            public void setOnPage(int position) {
                Router router = new Router();
                router.setUrl(data.homeTopAd.get(position).url);
                RouterManager.getInstance().openUrl(router);
            }
        });
        TextView tvLife = convertView.findViewById(R.id.tv_life);
        TextView tvStudy = convertView.findViewById(R.id.tv_study);
        TextView tvInvest = convertView.findViewById(R.id.tv_invest);
        TextView tvWelfare = convertView.findViewById(R.id.tv_welfare);
        TextView tvGuaratee = convertView.findViewById(R.id.tv_guarantee);
    }
}
