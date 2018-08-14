package com.hongyan.wdcf.base;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.hongyan.StringUtils;
import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;
import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import java.io.File;

/**
 * Created by wangning on 2018/6/10.
 */

public class PDFHolder extends BaseViewHolder implements IViewHolder, OnPageChangeListener {

    private PDFView pdfView;
    private String mUrl;
    private String fileName;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 10001) {
                cancelLoading();
                String url = Environment.getExternalStorageDirectory().getAbsolutePath() + "/wdcf/" + fileName;
                File file = new File(url);
                pdfView.fromFile(file)
                        .defaultPage(0)
                        .swipeVertical(true)
                        .load();
            }
        }
    };

    public PDFHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    public void setmUrl(String url) {
        this.mUrl = url;
        if (StringUtils.notEmpty(url)) {
            fileName = url.substring(url.lastIndexOf("/", url.length()));
        }
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_pdf;
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
        pdfView = rootView.findViewById(R.id.pdfview);
        startLoading();
        DownloadUtil.get().download(mUrl, "/wdcf", new DownloadUtil.OnDownloadListener() {
            @Override
            public void onDownloadSuccess() {
                Log.e("download", "下载成功");
                handler.sendEmptyMessage(10001);
            }

            @Override
            public void onDownloading(int progress) {

            }

            @Override
            public void onDownloadFailed() {
                Log.e("download", "下载失败");
            }
        });
    }

    @Override
    protected boolean hideNavigationView() {
        return true;
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

    @Override
    public void onPageChanged(int page, int pageCount) {

    }

}
