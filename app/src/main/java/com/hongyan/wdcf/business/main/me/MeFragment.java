package com.hongyan.wdcf.business.main.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hongyan.base.BaseFragment;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.core.AccountManager;

public class MeFragment extends BaseFragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        switch (AccountManager.getInstance().getUserType()) {
            case AccountManager.TYPE_USER:
                view = new MeUserPageView(getActivity());
                break;
            case AccountManager.TYPE_TEACHER:
                view = new MeTeacherPageView(getActivity());
                break;
            default:
                view = inflater.inflate(R.layout.fragment_me, container, false);
                break;
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        AccountManager.getInstance().checkLogin();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != view) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
