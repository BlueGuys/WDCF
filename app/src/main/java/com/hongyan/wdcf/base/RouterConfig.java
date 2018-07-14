package com.hongyan.wdcf.base;


import com.hongyan.base.router.RouterConst;
import com.hongyan.wdcf.business.account.bankcard.BankCardListActivity;
import com.hongyan.wdcf.business.account.bankcard.BindBankCardActivity;
import com.hongyan.wdcf.business.account.feedback.FeedbackActivity;
import com.hongyan.wdcf.business.account.login.LoginActivity;
import com.hongyan.wdcf.business.account.password.PasswordActivity;
import com.hongyan.wdcf.business.account.register.RegisterActivity;
import com.hongyan.wdcf.business.account.select.SelectIdentifyActivity;
import com.hongyan.wdcf.business.account.setting.SettingActivity;
import com.hongyan.wdcf.business.account.user.UserInfoActivity;

public final class RouterConfig {

    private static volatile RouterConfig instance;

    private RouterConfig() {
        init();
    }

    public static RouterConfig getInstance() {
        if (instance == null) {
            synchronized (RouterConfig.class) {
                if (instance == null) {
                    instance = new RouterConfig();
                }
            }
        }
        return instance;
    }

    void init() {
        RouterConst.addRouter(UserLoginIndex, LoginActivity.class.getName());
        RouterConst.addRouter(UserRegisterIndex, RegisterActivity.class.getName());
        RouterConst.addRouter(UserRegisterSelect, SelectIdentifyActivity.class.getName());
        RouterConst.addRouter(UserInfoIndex, UserInfoActivity.class.getName());
        RouterConst.addRouter(UserUserFeedback, FeedbackActivity.class.getName());
        RouterConst.addRouter(UserUserSetting, SettingActivity.class.getName());
        RouterConst.addRouter(UserModifyPassword, PasswordActivity.class.getName());
        RouterConst.addRouter(UserBankCardList, BankCardListActivity.class.getName());
        RouterConst.addRouter(UserBindBankCard, BindBankCardActivity.class.getName());
    }

    public static final String UserLoginIndex = "native://user/login/index";
    public static final String UserRegisterIndex = "native://user/register/index";
    public static final String UserRegisterSelect = "native://user/register/select";
    public static final String UserInfoIndex = "native://user/info/index";
    public static final String UserUserFeedback = "native://user/user/feedback";
    public static final String UserUserSetting = "native://user/user/setting";
    public static final String UserModifyPassword = "native://user/user/password";
    public static final String UserBankCardList = "native://user/bankcard/list";
    public static final String UserBindBankCard = "native://user/bankcard/bind";

}
