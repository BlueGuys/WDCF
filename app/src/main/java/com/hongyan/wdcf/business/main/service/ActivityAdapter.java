package com.hongyan.wdcf.business.main.service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.StringUtils;
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

public class ActivityAdapter extends BaseAdapter {

    private ArrayList<ActivityResult.Activity> mList = new ArrayList<>();

    public void setData(ArrayList<ActivityResult.Activity> list) {
        if (list != null) {
            mList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, parent, false);
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvAddress = convertView.findViewById(R.id.tv_address);
            holder.tvTime = convertView.findViewById(R.id.tv_time);
            holder.tvLabel1 = convertView.findViewById(R.id.tv_label1);
            holder.tvLabel2 = convertView.findViewById(R.id.tv_label2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final ActivityResult.Activity activity = mList.get(position);
        holder.tvTitle.setText(activity.title);
        holder.tvAddress.setText("地点:" + activity.address);
        holder.tvTime.setText("时间:" + activity.start_time + "至" + activity.end_time);
        if (StringUtils.notEmpty(activity.tags)) {
            String tags[] = activity.tags.split(",");
            if (tags.length == 1) {
                String tag1 = activity.tags.split(",")[0];
                holder.tvLabel1.setText(tag1);
                holder.tvLabel2.setVisibility(View.GONE);
            } else if (tags.length == 2) {
                String tag1 = activity.tags.split(",")[0];
                String tag2 = activity.tags.split(",")[1];
                holder.tvLabel1.setText(tag1);
                holder.tvLabel2.setText(tag2);
            }
        }
        DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCornerImageOption(20);
        ImageLoader.getInstance().displayImage(activity.photo, holder.imageView, options);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router(activity.detail_url);
                RouterManager.getInstance().openUrl(router);
            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvAddress;
        TextView tvTime;
        TextView tvLabel1;
        TextView tvLabel2;
    }

}
