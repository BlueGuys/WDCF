package com.hongyan.wdcf.business.main.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hongyan.base.BaseFragment;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.widget.MarginBannerView;

import java.util.ArrayList;

public class ProductFragment extends BaseFragment {

    private View view;
    private MarginBannerView bannerView;
    private ProductModel productModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_sub_product, container, false);
            initView();
            productModel = new ProductModel(this);
            productModel.request();
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != view) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    protected void setData(ProductResult.Data data) {
        Log.e("test", "");
        if (data == null) {
            return;
        }
        ArrayList<ProductResult.Ad> list = data.topAd;
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (ProductResult.Ad ad : list) {
            stringArrayList.add(ad.photo);
            stringArrayList.add(ad.photo);
        }
        bannerView.setData(stringArrayList);
    }

    private void initView() {
        bannerView = view.findViewById(R.id.banner);
    }
}
