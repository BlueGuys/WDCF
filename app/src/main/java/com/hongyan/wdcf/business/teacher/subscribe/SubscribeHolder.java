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
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.config.UrlConst;
import com.hongyan.wdcf.widget.CommonIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2018/6/10.
 */

public class SubscribeHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private TeacherOrderListHeadView toggleView;
    private CommonIndicator indicator;
    private ViewPager viewPager;
    private SubscribePagerAdapter adapter;
    private WaitFragment waitFragment = new WaitFragment();
    private DoneFragment doneFragment = new DoneFragment();
    private FailedFragment failedFragment = new FailedFragment();
    private Wait1Fragment wait1Fragment = new Wait1Fragment();
    private Done1Fragment done1Fragment = new Done1Fragment();
    private Failed1Fragment failed1Fragment = new Failed1Fragment();

    private List<Fragment> fragments = new ArrayList<>();

    public SubscribeHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_order_list;
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
        toggleView = rootView.findViewById(R.id.view_toggle);
        indicator = rootView.findViewById(R.id.indicator);
        indicator.setTab(new String[]{"待受理", "预约成功", "预约不成功"});
        viewPager = rootView.findViewById(R.id.viewpager);

        fragments.add(waitFragment);
        fragments.add(doneFragment);
        fragments.add(failedFragment);
        adapter = new SubscribePagerAdapter(mActivity.getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        indicator.setOnTabChangedListener(new CommonIndicator.OnTabChangedListener() {
            @Override
            public void onSelect(int position) {
                viewPager.setCurrentItem(position);
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

//        toggleView.setOnMenuClickListener(new TeacherOrderListHeadView.OnMenuClickListener() {
//            @Override
//            public void onSelect(int position) {
//                if (position == 0) {
//                    fragments.clear();
//                    fragments.add(waitFragment);
//                    fragments.add(doneFragment);
//                    fragments.add(failedFragment);
//                    adapter.setFragments(fragments);
//                } else if (position == 2) {
//                    fragments.clear();
//                    fragments.add(wait1Fragment);
//                    fragments.add(done1Fragment);
//                    fragments.add(failed1Fragment);
//                    adapter.setFragments(fragments);
//                }
//            }
//        });
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
