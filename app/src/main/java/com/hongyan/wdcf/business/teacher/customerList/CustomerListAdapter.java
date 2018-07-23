package com.hongyan.wdcf.business.teacher.customerList;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.hongyan.wdcf.widget.ItemCustomerA;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/11.
 */

public class CustomerListAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<CustomerListResult.Customer> mList = new ArrayList<>();

    public CustomerListAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setData(ArrayList<CustomerListResult.Customer> list) {
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
    public CustomerListResult.Customer getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemCustomerA item = new ItemCustomerA(activity);
        CustomerListResult.Customer customer = mList.get(position);
        if (customer != null) {
            item.setName(customer.user_nicename);
            item.setMobile(customer.getUIMobile());
            item.setUrl(customer.avatar);
        }
        return item;
    }
}
