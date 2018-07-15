package com.hongyan.wdcf.business.main.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hongyan.base.BaseFragment;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.core.AccountManager;

public class MeFragment extends BaseFragment {

    private View view;
    private LinearLayout roorLayout;
    private String userType = AccountManager.getInstance().getUserType();
    private MeUserPageView userPageView;
    private MeTeacherPageView teacherPageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
        roorLayout = view.findViewById(R.id.linearLayout);
        userPageView = new MeUserPageView(getActivity());
        teacherPageView = new MeTeacherPageView(getActivity());
        changePage(userType);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        String tempType = AccountManager.getInstance().getUserType();
        if (!userType.equals(tempType)) {//如果当前的和最新的不一样，则切换View
            this.userType = tempType;
            changePage(tempType);
        }
    }

    private void changePage(String userType) {
        roorLayout.removeAllViews();
        switch (userType) {
            case AccountManager.TYPE_USER:
                roorLayout.addView(userPageView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                break;
            case AccountManager.TYPE_TEACHER:
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
        if (null != view) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

}
