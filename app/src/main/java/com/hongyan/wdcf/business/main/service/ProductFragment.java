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
import com.hongyan.wdcf.widget.ProductA;

import java.util.ArrayList;

public class ProductFragment extends BaseFragment {

    private View view;
    private MarginBannerView bannerView;
    private ProductModel productModel;
    private ProductA productA;
    private ProductA productB;

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
        ArrayList<ProductResult.Fixation> classFixation = data.classFixation;
        if (classFixation.size() == 1) {
            ProductResult.Fixation fixationA = classFixation.get(0);
            productA.setAmount(fixationA.scale);
            productA.setRate(fixationA.rate);
//            productA.setStatus(fixationA.status);
            productA.setTerm(fixationA.term_id);
            productA.setTitle(fixationA.title);
            productB.setVisibility(View.GONE);
        } else if (classFixation.size() == 2) {
            ProductResult.Fixation fixationA = classFixation.get(0);
            productA.setAmount(fixationA.scale);
            productA.setRate(fixationA.rate);
            productA.setStatus(fixationA.status);
            productA.setTerm(fixationA.term_id);
            productA.setTitle(fixationA.title);

            ProductResult.Fixation fixationB = classFixation.get(1);
            productB.setAmount(fixationB.scale);
            productB.setRate(fixationB.rate);
            productB.setStatus(fixationB.status);
            productB.setTerm(fixationB.term_id);
            productB.setTitle(fixationB.title);
        }

        bannerView.setData(stringArrayList);
    }

    private void initView() {
        bannerView = view.findViewById(R.id.banner);
        productA = view.findViewById(R.id.product_A);
        productB = view.findViewById(R.id.product_B);
    }
}
