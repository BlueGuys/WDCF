package com.hongyan.wdcf.business.main.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_sub_product, container, false);

            initView();
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

    private void initView() {
        bannerView = view.findViewById(R.id.banner);
        ArrayList<String> list = new ArrayList<>();
        list.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=d109aa168dcb39dbdec06156e01409a7/2f738bd4b31c8701ad467c1a2b7f9e2f0608ff5e.jpg");
        list.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=d109aa168dcb39dbdec06156e01409a7/2f738bd4b31c8701ad467c1a2b7f9e2f0608ff5e.jpg");
        list.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=d109aa168dcb39dbdec06156e01409a7/2f738bd4b31c8701ad467c1a2b7f9e2f0608ff5e.jpg");
        list.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=d109aa168dcb39dbdec06156e01409a7/2f738bd4b31c8701ad467c1a2b7f9e2f0608ff5e.jpg");
        bannerView.setData(list);
    }
}
