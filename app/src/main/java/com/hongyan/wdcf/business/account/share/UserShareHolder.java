package com.hongyan.wdcf.business.account.share;

import android.view.View;
import android.widget.ImageView;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.utils.ZxingUtils;
import com.hongyan.wdcf.widget.ItemC;

/**
 * Created by wangning on 2018/6/10.
 */

public class UserShareHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private ImageView imageQRcode;
    private ImageView imageWechat;
    private ImageView imageQQ;

    public UserShareHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_user_share;
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
        imageQRcode = rootView.findViewById(R.id.image_code);
        imageQQ = rootView.findViewById(R.id.image_qq);
        imageWechat = rootView.findViewById(R.id.image_we_chat);
        imageQQ.setOnClickListener(this);
        imageWechat.setOnClickListener(this);
        imageQRcode.setImageBitmap(ZxingUtils.createBitmap("http://www.baidu.com"));
    }

    @Override
    public int getNavigationTitle() {
        return R.string.share_and_invite;
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
            case R.id.image_qq:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserModifyLoginPasswrod));
                break;
            case R.id.image_we_chat:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.UserModifyTradePasswrod));
                break;
        }
    }
}
