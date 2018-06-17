package com.hongyan.wdcf.business.list;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;

/**
 * Created by wangning on 2018/6/15.
 */

public class ListActivity extends BaseActivity {

    @Override
    protected BaseViewHolder getViewHolder() {
        return new MyListViewHolder(this);
    }

}
