package com.hongyan.wdcf.business.teacher.customer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hongyan.base.BaseFragment;
import com.hongyan.base.BaseResult;
import com.hongyan.wdcf.R;

public class AllCustomerFragment extends BaseFragment implements CustomerListModel.UIRequestListener {

    private View view;
    private PullToRefreshListView listView;
    private CustomerAdapter adapter;
    private CustomerListModel model;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        model = new CustomerListModel(this);
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_sub_customer_all, container, false);
            listView = view.findViewById(R.id.listView);
            adapter = new CustomerAdapter();
            listView.setAdapter(adapter);
        }
        model.refresh(true);
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
        CustomerListResult customerListResult = (CustomerListResult) result;
        if (customerListResult.isSuccessful() && customerListResult.data != null) {
            adapter.setData(customerListResult.data.list);
        }
    }

    @Override
    public void onFailed() {

    }
}
