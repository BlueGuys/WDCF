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

import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * @author 阎苏飞
 * @time 2018-03-24 PM 22:00
 * @desc 提供了一个横向可滚动Banner控件
 * {@link #setData(ArrayList)}  设置图片资源
 */
public class ScrollBannerView extends LinearLayout {

    public interface OnPageClickListener {
        void setOnPage(int position);
    }

    private ViewPager viewPager;
    private HeaderVpAdapter headerVpAdapter;
    private Context mContext;

    private OnPageClickListener mOnPageClickListener;

    private ArrayList<Entity> mList = new ArrayList<>();

    public ScrollBannerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        View view = View.inflate(mContext, R.layout.fragment_home_headerviewpager, this);
        viewPager = view.findViewById(R.id.homeheader_viewpager);

        headerVpAdapter = new HeaderVpAdapter();
        viewPager.setAdapter(headerVpAdapter);
    }

    public void setData(ArrayList<Entity> entityList) {
        if (entityList == null || entityList.size() == 0) {
            return;
        }
        this.mList.clear();
        this.mList.addAll(entityList);
        headerVpAdapter.notifyDataSetChanged();
    }

    public void setOnPageClickListener(OnPageClickListener onPageClickListener) {
        this.mOnPageClickListener = onPageClickListener;
    }

    public static class Entity {

        private String imageUrl;
        private String title;

        String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public class HeaderVpAdapter extends PagerAdapter {

        private DisplayImageOptions imageOptions;

        HeaderVpAdapter() {
            imageOptions = ImageLoaderOptionHelper.getInstance().getHeaderImageOption();
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_item, null);
            ImageView imageView = view.findViewById(R.id.home_header_imageView);
            Entity newsListEntity = mList.get(position);
            ImageLoader.getInstance().displayImage(newsListEntity.getImageUrl(), imageView, imageOptions);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnPageClickListener != null) {
                        mOnPageClickListener.setOnPage(position);
                    }
                }
            });
            container.addView(view);
            return view;
        }

    }
}
