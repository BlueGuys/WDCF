package com.hongyan.wdcf.business.main.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hongyan.base.BaseFragment;
import com.hongyan.wdcf.R;

public class NewsFragment extends BaseFragment {

    private View view;
    private ListView listView;
    private NewsAdapter adapter;

    private NewsModel model;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_sub_news, container, false);
            initView();
            initView();
            model = new NewsModel(this);
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
        adapter = new NewsAdapter();
        listView.setAdapter(adapter);
    }

    protected void setData(NewsResult.Data data) {
        if (data != null) {
            adapter.setData(data.newsList,data.topAd);
        }
    }
}
