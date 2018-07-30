package com.hongyan.wdcf.business.teacher.subscribe;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.widget.CommonIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2018/6/10.
 */

public class SubscribeHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private TeacherOrderListHeadView toggleView;
    private CommonIndicator indicator;


    private List<Fragment> fragments1 = new ArrayList<>();
    private WaitFragment waitFragment = new WaitFragment();
    private DoneFragment doneFragment = new DoneFragment();
    private FailedFragment failedFragment = new FailedFragment();
    private ViewPager viewPager1;
    private SubscribePagerAdapter adapter1;

    private List<Fragment> fragments2 = new ArrayList<>();
    private Wait1Fragment wait1Fragment = new Wait1Fragment();
    private Done1Fragment done1Fragment = new Done1Fragment();
    private Failed1Fragment failed1Fragment = new Failed1Fragment();
    private ViewPager viewPager2;
    private SubscribePagerAdapter adapter2;


    public SubscribeHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_subscribe_order_list;
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
        fragments1.add(waitFragment);
        fragments1.add(doneFragment);
        fragments1.add(failedFragment);
        fragments2.add(wait1Fragment);
        fragments2.add(done1Fragment);
        fragments2.add(failed1Fragment);

        toggleView = rootView.findViewById(R.id.view_toggle);
        indicator = rootView.findViewById(R.id.indicator);
        indicator.setTab(new String[]{"待受理", "预约成功", "预约不成功"});

        viewPager1 = rootView.findViewById(R.id.viewpager1);
        viewPager2 = rootView.findViewById(R.id.viewpager2);

        adapter1 = new SubscribePagerAdapter(mActivity.getSupportFragmentManager(), fragments1);
        adapter2 = new SubscribePagerAdapter(mActivity.getSupportFragmentManager(), fragments2);

        viewPager1.setAdapter(adapter1);
        viewPager1.setOffscreenPageLimit(3);

        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager2.setAdapter(adapter2);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        toggleView.setOnMenuClickListener(new TeacherOrderListHeadView.OnMenuClickListener() {
            @Override
            public void onSelect(int position) {
                if (position == 0) {
                    viewPager1.setVisibility(View.VISIBLE);
                    viewPager2.setVisibility(View.GONE);
                } else if (position == 1) {
                    viewPager1.setVisibility(View.GONE);
                    viewPager2.setVisibility(View.VISIBLE);
                }
            }
        });

        indicator.setOnTabChangedListener(new CommonIndicator.OnTabChangedListener() {
            @Override
            public void onSelect(int position) {
                viewPager1.setCurrentItem(position);
                viewPager2.setCurrentItem(position);
            }
        });

        toggleView.setBackClickListener(new TeacherOrderListHeadView.OnBackClickListener() {
            @Override
            public void onClick() {
                mActivity.finish();
            }
        });
    }

    @Override
    protected boolean hideNavigationView() {
        return true;
    }

    @Override
    public int getNavigationTitle() {
        return R.string.subscribe_handle;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_commit:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserBindBankCard));
                break;
        }
    }
}
