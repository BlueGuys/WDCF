package com.hongyan.wdcf.business.account.register;

import android.view.View;
import android.widget.Button;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RouterConfig;

/**
 * Created by wangning on 2018/6/10.
 */

public class RegisterHolder extends BaseViewHolder implements IViewHolder {

    private Button button;
    private Button login;
    private RegisterModel registerModel;

    public RegisterHolder(BaseActivity mActivity) {
        super(mActivity);
        registerModel = new RegisterModel();
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_register;
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
        button = rootView.findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router();
                router.setUrl("https://www.zhihu.com");
                router.addParams("hello", "222");
                router.addParams("hell", "王宁");
                RouterManager.getInstance().openUrl(router);
//                registerModel.startRegister();
            }
        });
        login = rootView.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router();
                router.setUrl(RouterConfig.UserLoginIndex);
                router.addParams("type", "1");
                router.addParams("test", "哈哈哈");
                RouterManager.getInstance().openUrl(router);
            }
        });

    }

    @Override
    public int getNavigationTitle() {
        return 0;
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
}
