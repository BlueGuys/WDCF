package com.hongyan.wdcf.business.main.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hongyan.base.BaseFragment;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.widget.MarginBannerView;
import com.hongyan.wdcf.widget.ProductA;
import com.hongyan.wdcf.widget.ProductB;

import java.util.ArrayList;

public class ProductFragment extends BaseFragment {

    private View view;
    private MarginBannerView bannerView;
    private ProductModel productModel;
    private ProductA productA;
    private ProductA productB;
    private ProductB product01;
    private ProductB product02;

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

        //标的
        ArrayList<ProductResult.Fixation> classFixation = data.classFixation;
        if (classFixation != null && classFixation.size() == 1) {
            ProductResult.Fixation fixationA = classFixation.get(0);
            productA.setAmount(fixationA.scale);
            productA.setRate(fixationA.rate);
//            productA.setStatus(fixationA.status);
            productA.setTerm(fixationA.term_id);
            productA.setTitle(fixationA.title);
            productB.setVisibility(View.GONE);
        } else if (classFixation != null && classFixation.size() == 2) {
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

        //平铺产品
        ArrayList<ProductResult.Equity> equities = data.privateEquity;
        if (equities != null) {
            if (equities.size() == 1) {
                final ProductResult.Equity equity01 = equities.get(0);
                product01.setAmount(equity01.scale);
                product01.setDeadLine(equity01.end_time);
                product01.setDesc(equity01.excerpt);
                product01.setImgUrl(equity01.photo);
                product01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Router router = new Router(equity01.detail_url);
//                        router.addParams(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
//                        RouterManager.getInstance().openUrl(router);
                    }
                });
                product02.setVisibility(View.GONE);
            } else if (equities.size() == 2) {
                final ProductResult.Equity equity01 = equities.get(0);
                product01.setAmount(equity01.scale);
                product01.setDeadLine(equity01.end_time);
                product01.setDesc(equity01.excerpt);
                product01.setImgUrl(equity01.photo);
                product01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Router router = new Router(equity01.detail_url);
//                        router.addParams(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
//                        RouterManager.getInstance().openUrl(router);
                    }
                });
                final ProductResult.Equity equity02 = equities.get(1);
                product02.setAmount(equity02.scale);
                product02.setDeadLine(equity02.end_time);
                product02.setDesc(equity02.excerpt);
                product02.setImgUrl(equity02.photo);
                product02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Router router = new Router(equity02.detail_url);
//                        router.addParams(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
//                        RouterManager.getInstance().openUrl(router);
                    }
                });
            }
        } else {
            product01.setVisibility(View.GONE);
            product02.setVisibility(View.GONE);
        }
        bannerView.setData(stringArrayList);
    }

    private void initView() {
        bannerView = view.findViewById(R.id.banner);
        productA = view.findViewById(R.id.product_A);
        productB = view.findViewById(R.id.product_B);
        product01 = view.findViewById(R.id.product_01);
        product02 = view.findViewById(R.id.product_02);
    }
}
