package com.hongyan.wdcf.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hongyan.wdcf.R;
import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

/**
 * Created by wangning on 2018/8/15.
 */

public class PDFActivity extends Activity implements OnPageChangeListener {

    private PDFView pdfView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        pdfView = findViewById(R.id.pdfview);
        pdfView.fromAsset("")
                .defaultPage(10)
                .onPageChange(this)
                .load();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {

    }
}
