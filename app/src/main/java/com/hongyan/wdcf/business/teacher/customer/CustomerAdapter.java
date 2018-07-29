package com.hongyan.wdcf.business.teacher.customer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.widget.ConfirmDialog;
import com.hongyan.wdcf.widget.ItemCustomer;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/11.
 */

public class CustomerAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<CustomerListResult.Customer> mList = new ArrayList<>();

    public CustomerAdapter(Activity context) {
        this.activity = context;
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
        ItemCustomer itemCustomer = new ItemCustomer(activity);
        final CustomerListResult.Customer customer = mList.get(position);
        if (customer != null) {
            itemCustomer.setName(customer.user_nicename);
            itemCustomer.setMobile(customer.getUIMobile());
            itemCustomer.setLevel(customer.review_str);
            itemCustomer.setCallClickListener(new ItemCustomer.OnCallClickListener() {
                @Override
                public void onClick() {
                    final ConfirmDialog dialog = new ConfirmDialog(activity);
                    dialog.show();
                    dialog.setContent(customer.mobile, "取消", "呼叫");
                    dialog.setLeftListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.setRightListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            Uri data = Uri.parse("tel:" + customer.mobile);
                            intent.setData(data);
                            activity.startActivity(intent);
                        }
                    });
                }
            });
            itemCustomer.setEditClickListener(new ItemCustomer.OnEditClickListener() {
                @Override
                public void onClick() {
                    Router router = new Router(RouterConfig.TearcherAddRecord);
//                    router.addParams(RequestKeyTable.ID_NUMBER, customer.id);
                    RouterManager.getInstance().openUrl(router);
                }
            });
            itemCustomer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Router router = new Router(RouterConfig.UserInfoIndex);
                    router.addParams(RequestKeyTable.USER_NAME, customer.user_nicename);
                    router.addParams(RequestKeyTable.USER_REAL_NAME, customer.user_nicename);
                    router.addParams(RequestKeyTable.MOBILE, customer.mobile);
                    router.addParams(RequestKeyTable.EMAIL, customer.user_email);
                    router.addParams(RequestKeyTable.USER_IDENTIFY_NUMBER, customer.id_number);
                    router.addParams(RequestKeyTable.ADDRESS, customer.address);
                    router.addParams(RequestKeyTable.USER_AVATAR, customer.avatar);
                    RouterManager.getInstance().openUrl(router);
                }
            });
        }
        return itemCustomer;
    }

}
