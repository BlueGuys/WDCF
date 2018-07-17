package com.hongyan.wdcf.business.main.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hongyan.base.BaseFragment;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.business.account.core.AccountMessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MeFragment extends BaseFragment {

    private View view;
    private LinearLayout roorLayout;
    private MeUserPageView userPageView;
    private MeTeacherPageView teacherPageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        view = inflater.inflate(R.layout.fragment_me, container, false);
        roorLayout = view.findViewById(R.id.linearLayout);
        userPageView = new MeUserPageView(getActivity());
        teacherPageView = new MeTeacherPageView(getActivity());
        changePage();
        return view;
    }

    private void changePage() {
        roorLayout.removeAllViews();
        switch (getUserType()) {
            case AccountInfo.TYPE_USER:
                roorLayout.addView(userPageView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                break;
            case AccountInfo.TYPE_TEACHER:
                roorLayout.addView(teacherPageView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                break;
            default:
                roorLayout.addView(userPageView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        if (null != view) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    private String getUserType() {
        AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
        if (accountInfo != null) {
            return accountInfo.getUser_type();
        }
        return AccountInfo.TYPE_USER;
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void accountEvent(AccountMessageEvent message) {
        if (message.isLogin()) {
            changePage();
            userPageView.notifyDataChanged();
            teacherPageView.notifyDataChanged();
        }
    }

}
