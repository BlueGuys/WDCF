package com.hongyan.wdcf.business.teacher.subscribe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wangning on 2018/7/13.
 */

public class SubscribePagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public SubscribePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

//    public void setFragments(List<Fragment> fragmentList) {
//        if (fragmentList != null) {
//            this.fragments.clear();
//            this.fragments.addAll(fragmentList);
//            notifyDataSetChanged();
//        }
//    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }
}
