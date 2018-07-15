package com.hongyan.wdcf.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hongyan.LogUtils;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2018/7/14.
 */

public class MarginBannerView extends LinearLayout {

    private View view;
    private ViewPager viewPager;
    private MyPagerAdapter adapter;
    private ScrollBannerView.OnPageClickListener mOnPageClickListener;
    private Context mContext;

    private ArrayList<String> mList = new ArrayList<>();

    public MarginBannerView(Context context) {
        this(context, null);
    }

    public MarginBannerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        view = LayoutInflater.from(context).inflate(R.layout.view_margin_banner, this, true);
        viewPager = view.findViewById(R.id.viewpager);
        viewPager.setPageMargin(40);//设置page间间距，自行根据需求设置
//        viewPager.setOffscreenPageLimit(3);//>=3
        adapter = new MyPagerAdapter();
    }

    public void setData(ArrayList<String> list) {
        if (list != null && list.size() > 0) {
            viewPager.setAdapter(adapter);
            mList.clear();
            mList.addAll(list);
            adapter.notifyDataSetChanged();
            int m = (Integer.MAX_VALUE / 2) % mList.size();
            int currentPosition = Integer.MAX_VALUE / 2 - m;
            viewPager.setCurrentItem(currentPosition);
        }
    }

    public void setOnPageClickListener(ScrollBannerView.OnPageClickListener onPageClickListener) {
        this.mOnPageClickListener = onPageClickListener;
    }


    class MyPagerAdapter extends PagerAdapter {

        private DisplayImageOptions imageOptions;
        private List<View> mViewList;

        public MyPagerAdapter() {
            imageOptions = ImageLoaderOptionHelper.getInstance().getCornerImageOption(20);
        }

        @Override
        public int getCount() {
            if (mList.size() == 0) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(getView(position % mList.size()));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final int pos = position % mList.size();
            View view = getView(pos);
            ImageView imageView = view.findViewById(R.id.home_header_imageView);
            ImageLoader.getInstance().displayImage(mList.get(pos), imageView, imageOptions);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnPageClickListener != null) {
                        mOnPageClickListener.setOnPage(pos);
                    }
                }
            });
            ViewGroup group = (ViewGroup) view.getParent();
            if (group != null) {
                group.removeView(view);
            }
            container.addView(view);
            return view;
        }

        private View getView(int position) {
            if (mViewList == null) {
                mViewList = new ArrayList<>();
            }
            while (mViewList.size() - 1 < position) {
                mViewList.add(LayoutInflater.from(mContext).inflate(R.layout.viewpager_item, null));
            }
            return mViewList.get(position);
        }
    }

    public interface OnPageClickListener {
        void setOnPage(int position);
    }

}
