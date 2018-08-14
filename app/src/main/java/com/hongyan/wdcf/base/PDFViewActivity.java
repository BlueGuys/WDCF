package com.hongyan.wdcf.base;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.business.account.core.MainMessageEvent;

import org.greenrobot.eventbus.EventBus;

public class PDFViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        PDFHolder pdfHolder = new PDFHolder(this);
        pdfHolder.setmUrl(getParam("url"));
        return pdfHolder;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
