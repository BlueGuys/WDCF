package com.hongyan.wdcf.base;


import android.content.Context;
import android.graphics.Bitmap;

import com.hongyan.wdcf.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

public class ImageLoaderOptionHelper {

    private static volatile ImageLoaderOptionHelper instance;

    /**
     * 列表图Image样式
     */
    private DisplayImageOptions mListImageOption;

    /**
     * 首页大图Image样式
     */
    private DisplayImageOptions mHeaderImageOption;

    /**
     * 首页大图Image样式
     */
    private DisplayImageOptions mCircleImageOption;


    private ImageLoaderOptionHelper() {
    }

    public static ImageLoaderOptionHelper getInstance() {
        if (instance == null) {
            synchronized (ImageLoaderOptionHelper.class) {
                if (instance == null) {
                    instance = new ImageLoaderOptionHelper();
                }
            }
        }
        return instance;
    }

    public DisplayImageOptions getCircleImageOption() {
        if (mCircleImageOption == null) {
            mCircleImageOption = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .considerExifParams(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .displayer(new RoundedBitmapDisplayer(90))
                    .build();
        }
        return mCircleImageOption;
    }

    public DisplayImageOptions getListImageOption() {
        if (mListImageOption == null) {
            mListImageOption = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.icon_net_loading)
                    .showImageForEmptyUri(R.drawable.icon_start)
                    .showImageOnFail(R.drawable.icon_net_fail)
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .considerExifParams(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .displayer(new RoundedBitmapDisplayer(7))//是否设置为圆角,弧度为多少
                    .build();
        }
        return mListImageOption;
    }

    public DisplayImageOptions getHeaderImageOption() {
        if (mHeaderImageOption == null) {
            mHeaderImageOption = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.icon_net_loading)
                    .showImageForEmptyUri(R.drawable.icon_start)
                    .showImageOnFail(R.drawable.icon_net_fail)
                    .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                    .cacheOnDisk(true)//设置是否缓存在SD卡中
                    .considerExifParams(true)//是否考虑JPEG图像EXIF参数（旋转，翻转）
                    .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片的缩放类型
                    .bitmapConfig(Bitmap.Config.ARGB_4444)//设置图片的解码类型
                    .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
                    .displayer(new RoundedBitmapDisplayer(100))//是否设置为圆角,弧度为多少
                    .displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间
                    .build();
        }
        return mHeaderImageOption;
    }

    public void initImageLoader(Context context) {
        //获取缓存文件
        File cacheDir = StorageUtils.getCacheDirectory(context);
        //设置自定义缓存的目录
        cacheDir = StorageUtils.getOwnCacheDirectory(context, "imageloader/Cache");
        //初始化ImageLoad
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800)//设置缓存图片的默认尺寸,一般取设备的屏幕尺寸
                .diskCacheExtraOptions(480, 800, null)
                .threadPoolSize(3)// 线程池内加载的数量,default = 3
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))//自定义内存的缓存策略
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13)// default
                .diskCache(new UnlimitedDiskCache(cacheDir))// default
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)//缓存的文件数量
                .diskCache(new UnlimitedDiskCache(cacheDir))//自定义缓存路径
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())// default
                .imageDownloader(new BaseImageDownloader(context))// default
                .imageDecoder(new BaseImageDecoder(true))// default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())// default
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(config);
    }

}
