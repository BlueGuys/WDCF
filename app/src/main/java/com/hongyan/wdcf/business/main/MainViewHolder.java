package com.hongyan.wdcf.business.main;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.CommonViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.list.ListActivity;
import com.hongyan.wdcf.business.login.LoginActivity;

/**
 * Created by wangning on 2018/6/10.
 */

public class MainViewHolder extends CommonViewHolder {

    MainViewHolder(BaseActivity activity) {
        super(activity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected int getNavigationTitle() {
        return R.string.app_name;
    }

    @Override
    protected RequestBean getRequestBean() {
        RequestBean bean = new RequestBean<>(MainResult.class);
        bean.setRequestUrl("http://www.xicaijing.com/Api/Digiccy/mylists.html");
        bean.addParam("sss", "ss");
        return bean;
    }

    @Override
    protected <T extends BaseResult> void onRequestSuccess(T result) {
        Toast.makeText(getActivity(), "ssss", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean needPageRequest() {
        return true;
    }

    @Override
    protected boolean onRequestFail() {
        return super.onRequestFail();
    }

    @Override
    protected void initView(View rootView) {
        Button button = rootView.findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.startActivity(new Intent(mActivity, LoginActivity.class));
            }
        });

        Button buttonList = rootView.findViewById(R.id.startList);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.startActivity(new Intent(mActivity, ListActivity.class));
            }
        });
    }
}
