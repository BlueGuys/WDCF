package com.hongyan.wdcf.business.user.study;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hongyan.wdcf.widget.ItemCustomerA;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/11.
 */

public class StudyAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<StudyResult.Customer> mList = new ArrayList<>();

    public StudyAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setData(ArrayList<StudyResult.Customer> list) {
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
    public StudyResult.Customer getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemCustomerA item = new ItemCustomerA(activity);
        StudyResult.Customer customer = mList.get(position);
        if (customer != null) {
            item.setName(customer.user_nicename);
            item.setMobile(customer.getUIMobile());
            item.setUrl(customer.avatar);
        }
        return item;
    }
}
