package com.hongyan.wdcf.business.main.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hongyan.base.BaseFragment;
import com.hongyan.wdcf.R;

import java.util.ArrayList;
import java.util.List;

public class ServiceFragment extends BaseFragment {

    private View view;
    private ServiceHeadView headView;
    private ViewPager viewPager;
    private ServerPagerAdapter adapter;

    private List<Fragment> fragments = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_service, container, false);
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
        viewPager = view.findViewById(R.id.viewpager);
        headView = view.findViewById(R.id.headView);
        fragments.add(new ProductFragment());
        fragments.add(new ActivityFragment());
        fragments.add(new NewsFragment());

        adapter = new ServerPagerAdapter(getActivity().getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                headView.select(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        headView.setOnMenuClickListener(new ServiceHeadView.OnMenuClickListener() {
            @Override
            public void onSelect(int position) {
                viewPager.setCurrentItem(position);
            }
        });
    }
}
