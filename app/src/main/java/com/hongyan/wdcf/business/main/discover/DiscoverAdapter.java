package com.hongyan.wdcf.business.main.discover;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.ImageLoaderOptionHelper;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.business.account.core.AccountMessageEvent;
import com.hongyan.wdcf.business.account.core.MainMessageEvent;
import com.hongyan.wdcf.widget.ScrollBannerView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2018/7/11.
 */

public class DiscoverAdapter extends BaseAdapter {

    private static final int TYPE_BANNER = 0;
    private static final int TYPE_MIDDLE_AD = 1;
    private static final int TYPE_HOT_ARTICLE = 2;
    private static final int TYPE_ASSET_ARTICLE = 3;
    private static final int TYPE_BOTTOM_AD = 4;
    private static final int TYPE_EVENT = 5;

    private DiscoverResult.Data data;

    private DiscoverFragment fragment;

    public DiscoverAdapter(DiscoverFragment fragment) {
        this.fragment = fragment;
    }

    public void setData(DiscoverResult.Data data) {
        if (data == null) {
            return;
        }
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (data == null) {
            return 0;
        }
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_BANNER;
            case 1:
                return TYPE_MIDDLE_AD;
            case 2:
                return TYPE_HOT_ARTICLE;
            case 3:
                return TYPE_ASSET_ARTICLE;
            case 4:
                return TYPE_BOTTOM_AD;
            case 5:
                return TYPE_EVENT;
        }
        return 6;
    }

    @Override
    public int getViewTypeCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            switch (getItemViewType(position)) {
                case TYPE_BANNER:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_head, parent, false);
                    handleHeader(convertView);
                    break;
                case TYPE_MIDDLE_AD:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_top_ad, parent, false);
                    handleMiddleAdd(convertView);
                    break;
                case TYPE_HOT_ARTICLE:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_hot, parent, false);
                    handleHotArticle(convertView);
                    break;
                case TYPE_ASSET_ARTICLE:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_asset, parent, false);
                    handleAssetsArticle(convertView);
                    break;
                case TYPE_BOTTOM_AD:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_bottom_ad, parent, false);
                    handleBottomAdd(convertView);
                    break;
                case TYPE_EVENT:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_event, parent, false);
                    handleEvent(convertView);
                    break;
            }
        }
        return convertView;
    }

    private void handleHeader(View convertView) {
        ArrayList<DiscoverResult.HomeTopAd> homeTopAd = data.homeTopAd;
        ArrayList<ScrollBannerView.Entity> entityArrayList = new ArrayList<>();
        ScrollBannerView bannerView = convertView.findViewById(R.id.banner);
        for (int i = 0; i < homeTopAd.size(); i++) {
            ScrollBannerView.Entity entity = new ScrollBannerView.Entity();
            entity.setImageUrl(homeTopAd.get(i).photo);
            entity.setTitle("");
            entityArrayList.add(entity);
        }
        bannerView.setData(entityArrayList);
        bannerView.setOnPageClickListener(new ScrollBannerView.OnPageClickListener() {
            @Override
            public void setOnPage(int position) {
                Router router = new Router();
                router.setUrl(data.homeTopAd.get(position).url);
                RouterManager.getInstance().openUrl(router);
            }
        });
        TextView tvLife = convertView.findViewById(R.id.tv_life);
        TextView tvStudy = convertView.findViewById(R.id.tv_study);
        TextView tvInvest = convertView.findViewById(R.id.tv_invest);
        TextView tvWelfare = convertView.findViewById(R.id.tv_welfare);
        TextView tvGuaratee = convertView.findViewById(R.id.tv_guarantee);
        tvStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router();
                router.setUrl("http://caifu.thongfu.com/App/Active/lists.html?cat_id=4");
                router.addParams(RequestKeyTable.TITLE, "学习");
                router.addParams(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
                RouterManager.getInstance().openUrl(router);
            }
        });
        tvLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router();
                router.setUrl("http://caifu.thongfu.com/App/Life");
                router.addParams(RequestKeyTable.TITLE, "生活");
                router.addParams(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
                RouterManager.getInstance().openUrl(router);
            }
        });
        tvInvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MainMessageEvent(1));
            }
        });
        tvWelfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.showErrorToast("敬请期待");
            }
        });
        tvGuaratee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.showErrorToast("敬请期待");
            }
        });


    }

    private void handleMiddleAdd(View convertView) {
        final ArrayList<DiscoverResult.HomeMediaAd> homeMedioAd = data.homeMedioAd;
        ImageView imageView = convertView.findViewById(R.id.imageView);
        if (homeMedioAd.size() > 0) {
            DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCornerImageOption(20);
            ImageLoader.getInstance().displayImage(homeMedioAd.get(0).photo, imageView, options);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router();
                router.setUrl(homeMedioAd.get(0).url);
                RouterManager.getInstance().openUrl(router);
            }
        });
    }

    private void handleBottomAdd(View convertView) {
        final ArrayList<DiscoverResult.HomeBottomAd> homeFootAd = data.homeFootAd;
        ImageView imageView = convertView.findViewById(R.id.imageView);
        if (homeFootAd.size() > 0) {
            DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCornerImageOption(20);
            ImageLoader.getInstance().displayImage(homeFootAd.get(0).photo, imageView, options);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router();
                router.setUrl(homeFootAd.get(0).url);
                RouterManager.getInstance().openUrl(router);
            }
        });
    }

    private void handleEvent(View convertView) {
        final ArrayList<DiscoverResult.homeEvent> homeEvents = data.homeEvent;
        ImageView imageViewA = convertView.findViewById(R.id.imageViewA);
        ImageView imageViewB = convertView.findViewById(R.id.imageViewB);
        if (homeEvents.size() > 1) {
            DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCommonImageOption();
            ImageLoader.getInstance().displayImage(homeEvents.get(0).photo, imageViewA, options);
            ImageLoader.getInstance().displayImage(homeEvents.get(0).photo, imageViewB, options);
        }
        imageViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router();
                router.setUrl(homeEvents.get(0).detail_url);
                RouterManager.getInstance().openUrl(router);
            }
        });
        imageViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router router = new Router();
                router.setUrl(homeEvents.get(1).detail_url);
                RouterManager.getInstance().openUrl(router);
            }
        });
    }

    private void handleHotArticle(View convertView) {
        ArrayList<DiscoverResult.HotArticle> hotArticles = data.hotArticle;
        TextView tvTitleA = convertView.findViewById(R.id.tv_title_A);
        TextView tvDescA = convertView.findViewById(R.id.tv_desc_A);
        TextView tvTimeA = convertView.findViewById(R.id.tv_timeA);
        TextView tvSiteA = convertView.findViewById(R.id.tv_siteA);
        ImageView imageViewA = convertView.findViewById(R.id.imageViewA);

        TextView tvTitleB = convertView.findViewById(R.id.tv_title_B);
        TextView tvDescB = convertView.findViewById(R.id.tv_desc_B);
        TextView tvTimeB = convertView.findViewById(R.id.tv_timeB);
        TextView tvSiteB = convertView.findViewById(R.id.tv_siteB);
        ImageView imageViewB = convertView.findViewById(R.id.imageViewB);

        LinearLayout layoutB = convertView.findViewById(R.id.linearB);

        DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCommonImageOption();
        if (hotArticles.size() == 1) {
            layoutB.setVisibility(View.GONE);
            final DiscoverResult.HotArticle articleA = hotArticles.get(0);
            tvTitleA.setText(articleA.title);
            tvDescA.setText(articleA.excerpt);
            tvTimeA.setText(articleA.create_time);
            tvSiteA.setText(articleA.source);
            ImageLoader.getInstance().displayImage(articleA.photo, imageViewA, options);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Router router = new Router();
                    router.setUrl(articleA.detail_url);
                    RouterManager.getInstance().openUrl(router);
                }
            });
        } else if (hotArticles.size() == 2) {
            final DiscoverResult.HotArticle articleA = hotArticles.get(0);
            tvTitleA.setText(articleA.title);
            tvDescA.setText(articleA.excerpt);
            tvTimeA.setText(articleA.create_time);
            tvSiteA.setText(articleA.source);
            ImageLoader.getInstance().displayImage(articleA.photo, imageViewA, options);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Router router = new Router();
                    router.setUrl(articleA.detail_url);
                    RouterManager.getInstance().openUrl(router);
                }
            });

            final DiscoverResult.HotArticle articleB = hotArticles.get(1);
            tvTitleB.setText(articleB.title);
            tvDescB.setText(articleB.excerpt);
            tvTimeB.setText(articleB.create_time);
            tvSiteB.setText(articleB.source);
            ImageLoader.getInstance().displayImage(articleB.photo, imageViewB, options);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Router router = new Router();
                    router.setUrl(articleB.detail_url);
                    RouterManager.getInstance().openUrl(router);
                }
            });
        }
    }

    private void handleAssetsArticle(View convertView) {
        ArrayList<DiscoverResult.AssetArticle> assetArticles = data.assetArticle;
        TextView tvTitleA = convertView.findViewById(R.id.tv_title_A);
        TextView tvDescA = convertView.findViewById(R.id.tv_desc_A);
        TextView tvTimeA = convertView.findViewById(R.id.tv_timeA);
        TextView tvSiteA = convertView.findViewById(R.id.tv_siteA);
        ImageView imageViewA = convertView.findViewById(R.id.imageViewA);

        TextView tvTitleB = convertView.findViewById(R.id.tv_title_B);
        TextView tvDescB = convertView.findViewById(R.id.tv_desc_B);
        TextView tvTimeB = convertView.findViewById(R.id.tv_timeB);
        TextView tvSiteB = convertView.findViewById(R.id.tv_siteB);
        ImageView imageViewB = convertView.findViewById(R.id.imageViewB);

        LinearLayout layoutB = convertView.findViewById(R.id.linearB);

        DisplayImageOptions options = ImageLoaderOptionHelper.getInstance().getCommonImageOption();
        if (assetArticles.size() == 1) {

            layoutB.setVisibility(View.GONE);

            final DiscoverResult.AssetArticle articleA = assetArticles.get(0);
            tvTitleA.setText(articleA.title);
            tvDescA.setText(articleA.excerpt);
            tvTimeA.setText(articleA.create_time);
            tvSiteA.setText(articleA.source);
            ImageLoader.getInstance().displayImage(articleA.photo, imageViewA, options);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Router router = new Router();
                    router.setUrl(articleA.detail_url);
                    RouterManager.getInstance().openUrl(router);
                }
            });
        } else if (assetArticles.size() == 2) {
            final DiscoverResult.AssetArticle articleA = assetArticles.get(0);
            tvTitleA.setText(articleA.title);
            tvDescA.setText(articleA.excerpt);
            tvTimeA.setText(articleA.create_time);
            tvSiteA.setText(articleA.source);
            ImageLoader.getInstance().displayImage(articleA.photo, imageViewA, options);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Router router = new Router();
                    router.setUrl(articleA.detail_url);
                    RouterManager.getInstance().openUrl(router);
                }
            });

            final DiscoverResult.AssetArticle articleB = assetArticles.get(1);
            tvTitleB.setText(articleB.title);
            tvDescB.setText(articleB.excerpt);
            tvTimeB.setText(articleB.create_time);
            tvSiteB.setText(articleB.source);
            ImageLoader.getInstance().displayImage(articleB.photo, imageViewB, options);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Router router = new Router();
                    router.setUrl(articleB.detail_url);
                    RouterManager.getInstance().openUrl(router);
                }
            });
        }
    }
}
