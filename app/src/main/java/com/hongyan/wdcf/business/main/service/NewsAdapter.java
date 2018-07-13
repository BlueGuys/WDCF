package com.hongyan.wdcf.business.main.service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.hongyan.wdcf.business.main.discover.DiscoverResult;
import com.hongyan.wdcf.widget.ScrollBannerView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/11.
 */

public class NewsAdapter extends BaseAdapter {

    private static final int TYPE_BANNER = 0;
    private static final int TYPE_ITEM = 1;

    private ArrayList<NewsResult.News> mNewsList = new ArrayList<>();
    private ArrayList<NewsResult.Ad> mAdList = new ArrayList<>();

    public void setData(ArrayList<NewsResult.News> newsList, ArrayList<NewsResult.Ad> adList) {
        if (newsList != null) {
            mNewsList.addAll(newsList);
        }
        if (adList != null) {
            mAdList.addAll(adList);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mNewsList.size() + 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_BANNER;
        }
        return TYPE_ITEM;
    }

    @Override
    public NewsResult.News getItem(int position) {
        if (position == 0) {
            return null;
        }
        return mNewsList.get(position - 1);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position) == TYPE_BANNER) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_head, parent, false);
                ScrollBannerView bannerView = convertView.findViewById(R.id.banner);

                ArrayList<ScrollBannerView.Entity> entityArrayList = new ArrayList<>();
                for (int i = 0; i < mAdList.size(); i++) {
                    ScrollBannerView.Entity entity = new ScrollBannerView.Entity();
                    entity.setImageUrl(mAdList.get(i).photo);
                    entity.setTitle("");
                    entityArrayList.add(entity);
                }
                bannerView.setData(entityArrayList);
                bannerView.setOnPageClickListener(new ScrollBannerView.OnPageClickListener() {
                    @Override
                    public void setOnPage(int position) {
                        Router router = new Router();
                        router.setUrl(mAdList.get(position).url);
                        RouterManager.getInstance().openUrl(router);
                    }
                });
            }
        } else {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
                holder.imageView = convertView.findViewById(R.id.imageView);
                holder.tvTitle = convertView.findViewById(R.id.tv_title);
                holder.tvDesc = convertView.findViewById(R.id.tv_desc);
                holder.tvTime = convertView.findViewById(R.id.tv_time);
                holder.tvSite = convertView.findViewById(R.id.tv_site);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            NewsResult.News news = getItem(position);
            holder.tvTitle.setText(news.title);
            holder.tvSite.setText(news.source);
            holder.tvDesc.setText(news.address);
            holder.tvTime.setText(news.create_time);
            DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCommonImageOption();
            ImageLoader.getInstance().displayImage(news.photo, holder.imageView, options);
        }
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvDesc;
        TextView tvTime;
        TextView tvSite;
    }

}
