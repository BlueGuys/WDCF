package com.hongyan.wdcf.business.account.order;

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
import com.hongyan.wdcf.business.teacher.subscribe.ItemOrderA;

import java.util.ArrayList;
import java.util.List;

public class TransactionListFragment extends BaseFragment implements OrderListModel.UIRequestListener {

    private View view;
    private PullToRefreshListView listView;
    private OrderTransactionAdapter adapter;
    private OrderListModel model;
    private List<OrderListResult.Order> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        model = new OrderListModel(this);
        model.setStatus("4");
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_sub_transation_list, container, false);
            listView = view.findViewById(R.id.listView);
            adapter = new TransactionListFragment.OrderTransactionAdapter();
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
        OrderListResult orderListResult = (OrderListResult) result;
        if (orderListResult.isSuccessful() && orderListResult.data != null) {
            mList.addAll(orderListResult.data.list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailed() {

    }

    class OrderTransactionAdapter extends BaseAdapter {

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
            ItemOrderA item = new ItemOrderA(getActivity());
            final OrderListResult.Order order = mList.get(position);
            if (order != null) {
                item.setName(order.user_nicename);
                item.setTime(order.create_time);
                item.setType(order.term_str);
                item.setEditClickListener(new ItemOrderA.OnEditClickListener() {
                    @Override
                    public void onClick() {
                        Router router = new Router();
                        router.setUrl(RouterConfig.TeacherOrderStatusEdit);
                        router.addParams(RequestKeyTable.ID, order.id);
                        RouterManager.getInstance().openUrl(router);
                    }
                });
            }
            return item;
        }
    }


}
