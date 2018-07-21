package com.hongyan.wdcf.business.product.insurance;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.widget.ProductB;
import com.hongyan.wdcf.widget.ProductC;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/11.
 */

public class InsuranceListAdapter extends BaseAdapter {


    private ArrayList<InsuranceListResult.Product> mList = new ArrayList<>();
    private Context mContext;

    public InsuranceListAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<InsuranceListResult.Product> list) {
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
        ProductC productC = new ProductC(mContext);
        final InsuranceListResult.Product product = mList.get(position);
        productC.setTitle(product.title);
        productC.setTitle(product.excerpt);
        productC.setImgUrl(product.photo);
        productC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router(product.detail_url);
                router.addParams(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
                RouterManager.getInstance().openUrl(router);
            }
        });
        convertView = productC;
        return convertView;
    }


}
