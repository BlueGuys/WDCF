package com.hongyan.wdcf.business.account.bankcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.hongyan.wdcf.business.main.service.ActivityResult;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/11.
 */

public class BankCardListAdapter extends BaseAdapter {


    private ArrayList<BankCardListResult.BankCard> mList = new ArrayList<>();

    public void setData(ArrayList<BankCardListResult.BankCard> list) {
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
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        BankCardListResult.BankCard bankCard = mList.get(position);
//        holder.tvTitle.setText(bankCard.title);
//        holder.tvAddress.setText("地点:" + bankCard.address);
//        holder.tvTime.setText("时间:" + bankCard.start_time + "至" + bankCard.end_time);
//        DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCornerImageOption(20);
//        ImageLoader.getInstance().displayImage(bankCard.photo, holder.imageView, options);
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvAddress;
        TextView tvTime;
    }

}
