package com.hongyan.wdcf.business.product.fixed;

import com.hongyan.base.BaseModel;
import com.hongyan.base.BaseResult;
import com.hongyan.base.RequestListener;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.WDNetworkCall;
import com.hongyan.wdcf.business.teacher.subscribe.SubscribeResult;
import com.hongyan.wdcf.config.UrlConst;

import java.util.ArrayList;

/**
 * Created by wangning on 2018/7/7.
 */

public class FixedProductListModel extends BaseModel {

    private UIRequestListener mListener;
    public ArrayList<FixedProductListResult.Product> list = new ArrayList<>();
    private int currentPage = 1;

    public FixedProductListModel(UIRequestListener listener) {
        this.mListener = listener;
    }

    public void refresh() {
        currentPage = 1;
        loadData();
    }

    public void loadMore() {
        currentPage++;
        loadData();
    }

    private void loadData() {
        WDNetworkCall feedbackCall = new WDNetworkCall<>();
        feedbackCall.setRequestUrl(UrlConst.getProductFixedListUrl());
        feedbackCall.setResultClass(FixedProductListResult.class);
        feedbackCall.addParam(RequestKeyTable.CAT_ID, "5");
        feedbackCall.addParam(RequestKeyTable.PAGE, String.valueOf(currentPage));
        feedbackCall.start(new RequestListener() {
            @Override
            public <T extends BaseResult> void onResponse(T result) {
                FixedProductListResult cardListResult = (FixedProductListResult) result;
                if (cardListResult == null || cardListResult.data == null) {
                    return;
                }
                if (mListener == null) {
                    return;
                }
                if (currentPage == 1) {
                    list.clear();
                    list.addAll(cardListResult.data.list);
                    mListener.onRefresh(list, cardListResult.data.hasMore());
                } else {
                    list.addAll(cardListResult.data.list);
                    mListener.onLoadMore(list, cardListResult.data.hasMore());
                }
            }

            @Override
            public void onError(BaseResult.Error error) {
                mListener.onFail(error.errorMessage);
            }
        });
    }

    public interface UIRequestListener {
        void onRefresh(ArrayList<FixedProductListResult.Product> list, boolean hasMore);

        void onLoadMore(ArrayList<FixedProductListResult.Product> list, boolean hasMore);

        void onFail(String message);
    }
}
