package com.hongyan.wdcf.business.product.overseas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.widget.ProductB;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/11.
 */

public class OverseasProductListAdapter extends BaseAdapter {


    private ArrayList<OverseasProductListResult.Product> mList = new ArrayList<>();
    private Context mContext;

    public OverseasProductListAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<OverseasProductListResult.Product> list) {
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
        ProductB productB = new ProductB(mContext);
        final OverseasProductListResult.Product product = mList.get(position);
        productB.setAmount(product.scale);
        productB.setDeadLine(product.end_time);
        productB.setDesc(product.excerpt);
        productB.setLabel1(product.effecStr);
        productB.setImgUrl(product.photo);
        productB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router(product.detail_url);
                router.addParams(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
                RouterManager.getInstance().openUrl(router);
            }
        });
        convertView = productB;
        return convertView;
    }


}
