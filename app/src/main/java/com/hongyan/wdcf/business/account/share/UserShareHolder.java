package com.hongyan.wdcf.business.account.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by wangning on 2018/6/10.
 */

public class UserShareHolder extends BaseViewHolder implements IViewHolder, View.OnClickListener {

    private ImageView imageQRcode;
    private ImageView imageWechat;
    private ImageView imageMoments;
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
        imageMoments = rootView.findViewById(R.id.image_moments);
        imageQQ.setOnClickListener(this);
        imageMoments.setOnClickListener(this);
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
            case R.id.image_we_chat:
                UMWeb web0 = new UMWeb("https://developer.umeng.com/docs/66632/detail/66639");//连接地址
                web0.setTitle("王宁");//标题
                web0.setDescription("哈哈哈哈哈哈");//描述
                web0.setThumb(new UMEmoji(mActivity,R.drawable.ic_launcher));
                new ShareAction(mActivity)
                        .setPlatform(SHARE_MEDIA.WEIXIN)//传入平台
                        .withMedia(web0)
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
            case R.id.image_moments:
                UMWeb web1 = new UMWeb("http://www.baidu.com");//连接地址
                web1.setTitle("王宁");//标题
                web1.setDescription("哈哈哈哈哈哈");//描述
                new ShareAction(mActivity)
                        .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)//传入平台
                        .withMedia(web1)
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
            case R.id.image_qq:
                UMWeb web2 = new UMWeb("http://www.baidu.com");//连接地址
                web2.setTitle("王宁");//标题
                web2.setDescription("哈哈哈哈哈哈");//描述
                new ShareAction(mActivity)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(web2)
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
}
