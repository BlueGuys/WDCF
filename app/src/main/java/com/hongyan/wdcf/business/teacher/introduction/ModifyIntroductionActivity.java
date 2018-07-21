package com.hongyan.wdcf.business.teacher.introduction;

import android.os.Bundle;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.base.RequestKeyTable;

public class ModifyIntroductionActivity extends BaseActivity {

    private ModifyIntroductionHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewHolder getViewHolder() {
        holder = new ModifyIntroductionHolder(this);
        return holder;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (holder != null) {
            holder.setIntroduction(getParam(RequestKeyTable.CONTENT));
        }
    }
}
