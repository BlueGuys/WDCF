package com.hongyan.wdcf.business.teacher.customer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.bankcard.BankCardListResult;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/11.
 */

public class CustomerAdapter extends BaseAdapter {


    private ArrayList<CustomerListResult.Customer> mList = new ArrayList<>();

    public CustomerAdapter() {
    }

    public void setData(ArrayList<CustomerListResult.Customer> list) {
        if (list != null) {
            mList.clear();
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bankcard, parent, false);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CustomerListResult.Customer customer = mList.get(position);
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvAddress;
        TextView tvTime;
    }

}
