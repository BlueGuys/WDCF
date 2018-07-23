package com.hongyan.wdcf.business.teacher.addrecord;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.business.account.core.MainMessageEvent;
import com.hongyan.wdcf.business.teacher.customerList.CustomerMessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 增加沟通记录
 */
public class AddRecordActivity extends BaseActivity {

    private AddRecordHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        holder = new AddRecordHolder(this);
        return holder;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void accountEvent(CustomerMessageEvent message) {
        if (message == null) {
            return;
        }
        holder.setCustomerID(message.getId());
        holder.setCustomerName(message.getName());
    }
}
