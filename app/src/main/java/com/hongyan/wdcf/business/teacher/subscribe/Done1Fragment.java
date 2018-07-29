package com.hongyan.wdcf.business.teacher.subscribe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hongyan.base.BaseFragment;
import com.hongyan.base.BaseResult;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.RouterConfig;

import java.util.ArrayList;
import java.util.List;

public class Done1Fragment extends BaseFragment implements EventListModel.UIRequestListener{

    private View view;
    private PullToRefreshListView listView;
    private Done1Fragment.DoneAdapter adapter;
    private EventListModel model;
    private List<SubscribeResult.Record> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        model = new EventListModel(this);
        model.setStatus("1");
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_sub_subscribe_wait, container, false);
            listView = view.findViewById(R.id.listView);
            adapter = new Done1Fragment.DoneAdapter();
            listView.setAdapter(adapter);
        }
        model.refresh();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != view) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override
    public void onSuccess(BaseResult result) {
        if (result == null) {
            return;
        }
        SubscribeResult customerListResult = (SubscribeResult) result;
        if (customerListResult.isSuccessful() && customerListResult.data != null) {
            mList.addAll(customerListResult.data.list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailed() {

    }

    class DoneAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ItemOrderB item = new ItemOrderB(getActivity());
            final SubscribeResult.Record record = mList.get(position);
            if (record != null) {
                item.setName(record.user_nicename);
                item.setTime(record.create_time);
                item.setType(record.product_title);
                item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Router router = new Router(RouterConfig.UserOrderDetail);
                        router.addParams(RequestKeyTable.ID, record.id);
                        RouterManager.getInstance().openUrl(router);
                    }
                });
            }
            return item;
        }
    }



}
