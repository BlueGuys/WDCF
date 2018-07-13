package com.hongyan.wdcf.business.main.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hongyan.base.BaseFragment;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.main.discover.DiscoverAdapter;
import com.hongyan.wdcf.business.main.discover.DiscoverModel;
import com.hongyan.wdcf.business.main.discover.DiscoverResult;

public class ActivityFragment extends BaseFragment {

    private View view;
    private ListView listView;
    private ActivityAdapter adapter;

    private ActivityModel model;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_sub_activity, container, false);
            initView();
            model = new ActivityModel(this);
            model.requestDiscoverData();
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
        listView = view.findViewById(R.id.listView);
        adapter = new ActivityAdapter();
        listView.setAdapter(adapter);
    }

    protected void setData(ActivityResult.Data data) {
        if (data != null) {
            adapter.setData(data.list);
        }
    }
}
