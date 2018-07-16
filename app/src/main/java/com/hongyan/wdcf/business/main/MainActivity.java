package com.hongyan.wdcf.business.main;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.tab.SubPage;
import com.hongyan.base.tab.TabActivity;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.business.account.core.MainMessageEvent;
import com.hongyan.wdcf.business.main.discover.DiscoverFragment;
import com.hongyan.wdcf.business.main.me.MeFragment;
import com.hongyan.wdcf.business.main.service.ServiceFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class MainActivity extends TabActivity {

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<SubPage> list = new ArrayList<>();
        SubPage discoverPage = new SubPage();
        discoverPage.fragment = new DiscoverFragment();
        discoverPage.text = "发现";
        discoverPage.drawable = new int[]{R.drawable.icon_discover_s, R.drawable.icon_discover_n};

        SubPage servicePage = new SubPage();
        servicePage.fragment = new ServiceFragment();
        servicePage.text = "服务";
        servicePage.drawable = new int[]{R.drawable.icon_service_s, R.drawable.icon_service_n};

        SubPage mePage = new SubPage();
        mePage.fragment = new MeFragment();
        mePage.text = "我的";
        mePage.drawable = new int[]{R.drawable.icon_me_s, R.drawable.icon_me_n};

        list.add(discoverPage);
        list.add(servicePage);
        list.add(mePage);
        addSubPage(list);
        EventBus.getDefault().register(this);
        AccountManager.getInstance().refresh();

    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void accountEvent(MainMessageEvent message) {
        if (message == null) {
            return;
        }
        selectPage(message.getPosition());
    }

    @Override
    protected void select(int position) {
        super.select(position);
        if (position == 2) {
            AccountManager.getInstance().checkLogin();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        return super.getViewHolder();
    }
}
