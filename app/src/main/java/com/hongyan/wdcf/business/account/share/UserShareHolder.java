package com.hongyan.wdcf.business.account.share;

import android.view.View;
import android.widget.ImageView;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.business.account.order.OrderListResult;
import com.hongyan.wdcf.utils.ZxingUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by wangning on 2018/6/10.
 */

public class UserShareHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener, ShareModel.UIRequestListener {

    private ImageView imageQRcode;
    private ImageView imageWechat;
    private ImageView imageMoments;
    private ImageView imageQQ;
    private ShareModel shareModel;

    public String title;
    public String intro;
    public String photo;
    public String url;


    public UserShareHolder(BaseActivity mActivity) {
        super(mActivity);
        shareModel = new ShareModel(this);
        shareModel.refresh();
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
        imageMoments = rootView.findViewById(R.id.image_moments);
        imageQQ.setOnClickListener(this);
        imageMoments.setOnClickListener(this);
        imageWechat.setOnClickListener(this);
        imageQRcode.setImageBitmap(ZxingUtils.createBitmap("http://caifu.thongfu.com//App//Download//index.html"));
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
        UMWeb web = new UMWeb(url);//连接地址
        web.setTitle(title);//标题
        web.setDescription(intro);//描述
        web.setThumb(new UMEmoji(mActivity, photo));
        switch (v.getId()) {
            case R.id.image_we_chat:
                new ShareAction(mActivity)
                        .setPlatform(SHARE_MEDIA.WEIXIN)//传入平台
                        .withMedia(web)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {
//                                showErrorToast("onStart");
                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
//                                showErrorToast("onResult");
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
//                                showErrorToast("onError");
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
//                                showErrorToast("onCancel");
                            }
                        })//回调监听器
                        .share();
                break;
            case R.id.image_moments:
                new ShareAction(mActivity)
                        .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)//传入平台
                        .withMedia(web)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {
//                                showErrorToast("onStart");
                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
//                                showErrorToast("onResult");
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
//                                showErrorToast("onError");
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
//                                showErrorToast("onCancel");
                            }
                        })//回调监听器
                        .share();
                break;
            case R.id.image_qq:
                new ShareAction(mActivity)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(web)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {
                                showErrorToast("onStart");
                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                                showErrorToast("onResult");
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                showErrorToast("onError");
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                                showErrorToast("onCancel");
                            }
                        })//回调监听器
                        .share();
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
}
