package com.hongyan.wdcf.business.main.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hongyan.base.BaseFragment;
import com.hongyan.wdcf.R;

public class DiscoverFragment extends BaseFragment {

    private View view;
    private ListView listView;
    private DiscoverAdapter adapter;

    private DiscoverModel model;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_discover, container, false);
            initView();
            model = new DiscoverModel(this);
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
        adapter = new DiscoverAdapter(this);
        listView.setAdapter(adapter);
    }

    protected void setData(DiscoverResult.Data data) {
        adapter.setData(data);
    }

}
