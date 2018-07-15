package com.hongyan.base.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseFragment;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.lib_base.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2018/6/20.
 */

public class TabViewHolder extends BaseViewHolder implements IViewHolder {

    private List<SubPage> mPageList = new ArrayList<>();
    private List<BaseFragment> mFragmentList = new ArrayList<>();
    private ContentPagerAdapter contentAdapter;
    private ViewPager mViewPager;
    private TabContainer tabContainer;

    public TabViewHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_base_tab;
    }

    @Override
    public int getLayoutType() {
        return IViewHolder.LAYOUT_TYPE_COMMON;
    }

    @Override
    public boolean needPageRequest() {
        return false;
    }

    @Override
    public void initView(View rootView) {
        mViewPager = rootView.findViewById(R.id.vp_content);
        tabContainer = rootView.findViewById(R.id.tabContainer);
        initContent();
        initTab();
    }

    @Override
    protected boolean hideNavigationView() {
        return true;
    }

    private void initTab() {

    }

    private void initContent() {
        contentAdapter = new ContentPagerAdapter(mActivity.getSupportFragmentManager());
        mViewPager.setAdapter(contentAdapter);
    }

    @Override
    public int getNavigationTitle() {
        return 0;
    }

    @Override
    public RequestBean getRequestBean() {
        return null;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {

    }

    @Override
    public boolean onRequestFail() {
        return false;
    }

    public void addSubPage(ArrayList<SubPage> list) {
        if (list == null) {
            return;
        }
        mPageList.addAll(list);
        for (int i = 0; i < mPageList.size(); i++) {
            SubPage subPage = mPageList.get(i);
            mFragmentList.add(subPage.fragment);
            TabContainer.Tab tab = tabContainer.newTab();
            tab.drawable = subPage.drawable;
            tab.text = subPage.text;
            tabContainer.addTab(tab);
        }
        tabContainer.setOnSelectChangeListener(new TabContainer.OnSelectChangeListener() {
            @Override
            public void onChange(int position) {
                mViewPager.setCurrentItem(position);
                TabActivity activity = (TabActivity) mActivity;
                activity.select(position);
            }
        });
        contentAdapter.notifyDataSetChanged();
    }

    class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
