package com.hongyan.wdcf.business.teacher.addrecord;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.widget.ItemB;

/**
 * Created by wangning on 2018/6/10.
 */

public class AddRecordHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private AddRecordModel addRecordModel;
    private EditText editText;
    private ItemB itemCustomer;
    private String customerID;

    public AddRecordHolder(BaseActivity mActivity) {
        super(mActivity);
        addRecordModel = new AddRecordModel(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_add_record;
    }

    @Override
    public int getLayoutType() {
        return IViewHolder.LAYOUT_TYPE_COMMON;
    }

    @Override
    public boolean needPageRequest() {
        return false;
    }

    @Override
    public void initView(View rootView) {
        addLeftButtonDefault();
        itemCustomer = rootView.findViewById(R.id.item_select_customer);
        ItemB itemChatTime = rootView.findViewById(R.id.item_chat_time);
        ItemB itemRemindTime = rootView.findViewById(R.id.item_tip_time);
        editText = rootView.findViewById(R.id.editText);
        Button buttonCommit = rootView.findViewById(R.id.btn_commit);
        buttonCommit.setOnClickListener(this);
        itemCustomer.setOnClickListener(this);
        itemChatTime.setOnClickListener(this);
        itemRemindTime.setOnClickListener(this);
    }

    @Override
    public int getNavigationTitle() {
        return R.string.add_record;
    }

    @Override
    public RequestBean getRequestBean() {
        return null;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {
    }

    @Override
    public boolean onRequestFail() {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_select_customer:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.TeacherCustomerList));
                break;
            case R.id.item_chat_time:
                break;
            case R.id.item_tip_time:
                break;
            case R.id.btn_commit:
                String content = editText.getText().toString();
                if (content.length() < 15) {
                    showErrorToast("字数太少");
                    return;
                }
                addRecordModel.setId(customerID);
                addRecordModel.commit();
                break;
        }
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        itemCustomer.setDesc(customerName);
    }
}
