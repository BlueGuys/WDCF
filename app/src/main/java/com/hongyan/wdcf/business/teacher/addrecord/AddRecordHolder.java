package com.hongyan.wdcf.business.teacher.addrecord;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hongyan.StringUtils;
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

import org.feezu.liuli.timeselector.TimeSelector;

/**
 * Created by wangning on 2018/6/10.
 */

public class AddRecordHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private AddRecordModel addRecordModel;
    private EditText editText;
    private ItemB itemCustomer;
    private ItemB itemChatTime;
    private ItemB itemRemindTime;
    private String customerID;
    private String customerName;
    private String content;
    private String chatTime;
    private String remindTime;

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
        itemChatTime = rootView.findViewById(R.id.item_chat_time);
        itemRemindTime = rootView.findViewById(R.id.item_tip_time);
        editText = rootView.findViewById(R.id.editText);
        Button buttonCommit = rootView.findViewById(R.id.btn_commit);
        buttonCommit.setOnClickListener(this);
        itemCustomer.setOnClickListener(this);
        itemChatTime.setOnClickListener(this);
        itemRemindTime.setOnClickListener(this);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                content = editText.getText().toString();
            }
        });
        //这段逻辑只会执行一次
        if (StringUtils.notEmpty(customerID)) {
            itemCustomer.setDesc(customerName);
            itemCustomer.setEnabled(false);
        } else {
            itemCustomer.setEnabled(true);
        }
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
            case R.id.item_chat_time: {
                TimeSelector timeSelector = new TimeSelector(mActivity, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        chatTime = time;
                        itemChatTime.setDesc(time);
                    }
                }, "2018-01-01 00:00", "2028-12-31 23:59:59");
                timeSelector.setIsLoop(false);//设置不循环,true循环
                timeSelector.setMode(TimeSelector.MODE.YMD);//显示 年月日时分（默认）
                timeSelector.show();
                break;
            }
            case R.id.item_tip_time: {
                TimeSelector timeSelector = new TimeSelector(mActivity, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        remindTime = time;
                        itemRemindTime.setDesc(time);
                    }
                }, "2018-01-01 00:00", "2028-12-31 23:59:59");
                timeSelector.setIsLoop(false);//设置不循环,true循环
                timeSelector.setMode(TimeSelector.MODE.YMD);//显示 年月日时分（默认）
                timeSelector.show();
                break;
            }
            case R.id.btn_commit:
                if (StringUtils.isEmpty(customerID)) {
                    showErrorToast("选择客户");
                    return;
                }
                if (StringUtils.isEmpty(customerID)) {
                    showErrorToast("选择沟通时间");
                    return;
                }
                if (StringUtils.isEmpty(customerID)) {
                    showErrorToast("选择提醒时间");
                    return;
                }
                if (content.length() < 15) {
                    showErrorToast("字数太少");
                    return;
                }
                addRecordModel.setId(customerID);
                addRecordModel.setLinkup_time(chatTime);
                addRecordModel.setRemind_time(remindTime);
                addRecordModel.setRemarks(content);
                addRecordModel.commit();
                break;
        }
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
        if (itemCustomer != null) {
            itemCustomer.setDesc(customerName);
        }
    }
}
