package com.hongyan.wdcf.business.teacher.invite;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hongyan.StringUtils;
import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseApplication;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.hongyan.wdcf.base.WDApplication;
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.business.account.share.*;
import com.hongyan.wdcf.business.teacher.share.ShareDialog;
import com.hongyan.wdcf.widget.ConfirmDialog;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by wangning on 2018/6/10.
 */

public class InviteHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener, ShareModel.UIRequestListener {

    private String mobilePhone;
    private ShareModel shareModel;
    public String title;
    public String intro;
    public String photo;
    public String url;

    public InviteHolder(BaseActivity mActivity) {
        super(mActivity);
        shareModel = new ShareModel(this);
        shareModel.refresh();
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_invite;
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
        TextView buttonCommit = rootView.findViewById(R.id.btn_share);
        TextView tvName = rootView.findViewById(R.id.tv_user_name);
        TextView tvMobile = rootView.findViewById(R.id.tv_user_mobile);
        TextView tvCompany = rootView.findViewById(R.id.tv_user_company);
        ImageView imageLogo = rootView.findViewById(R.id.image_logo);
        ImageView imageCall = rootView.findViewById(R.id.image_call);
        buttonCommit.setOnClickListener(this);
        imageCall.setOnClickListener(this);
        AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
        if (accountInfo != null) {
            if (StringUtils.notEmpty(accountInfo.getUser_nicename())) {
                tvName.setText(accountInfo.getUser_nicename());
            }
            tvMobile.setText(accountInfo.getUIMobile());
            tvCompany.setText(accountInfo.getCompany());
            DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCommonImageOption();
            ImageLoader.getInstance().displayImage(accountInfo.getAvatar(), imageLogo, options);
            mobilePhone = accountInfo.getMobile();
        }
    }

    @Override
    public int getNavigationTitle() {
        return R.string.invite_you;
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
            case R.id.btn_share:
                final ShareDialog dialog1 = new ShareDialog(mActivity);
                dialog1.show();
                dialog1.setOnShareClickListener(new ShareDialog.OnShareClickListener() {
                    @Override
                    public void onChannelSelect(int channelId) {
                        handleShare(channelId);
                        dialog1.dismiss();
                    }
                });
                break;
            case R.id.image_call:
                final ConfirmDialog dialog = new ConfirmDialog(mActivity);
                dialog.show();
                dialog.setContent(mobilePhone, "取消", "呼叫");
                dialog.setLeftListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.setRightListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        Uri data = Uri.parse("tel:" + mobilePhone);
                        intent.setData(data);
                        mActivity.startActivity(intent);
                    }
                });
                break;
        }
    }

    @Override
    public void onSuccess(BaseResult result) {
        if (result == null) {
            return;
        }
        ShareResult shareResult = (ShareResult) result;
        if (shareResult.isSuccessful() && shareResult.data != null) {
            title = shareResult.data.title;
            intro = shareResult.data.intro;
            photo = shareResult.data.photo;
            url = shareResult.data.url;
        }
    }

    @Override
    public void onFailed() {

    }

    private void handleShare(int channelId) {
        UMWeb web = new UMWeb(url);//连接地址
        web.setTitle(title);//标题
        web.setDescription(intro);//描述
        web.setThumb(new UMEmoji(mActivity, photo));
        switch (channelId) {
            case 0:
                new ShareAction(mActivity)
                        .setPlatform(SHARE_MEDIA.WEIXIN)//传入平台
                        .withMedia(web)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {
                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                            }
                        })//回调监听器
                        .share();
                break;
            case 1:
                new ShareAction(mActivity)
                        .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)//传入平台
                        .withMedia(web)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {
                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                            }
                        })//回调监听器
                        .share();
                break;
            case 2:
                new ShareAction(mActivity)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(web)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {
                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                            }
                        })//回调监听器
                        .share();
                break;
        }
    }
}
