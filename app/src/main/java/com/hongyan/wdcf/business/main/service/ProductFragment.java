package com.hongyan.wdcf.business.main.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hongyan.StringUtils;
import com.hongyan.base.BaseFragment;
import com.hongyan.base.router.Router;
import com.hongyan.base.router.RouterManager;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.RequestKeyTable;
import com.hongyan.wdcf.base.RouterConfig;
import com.hongyan.wdcf.business.account.core.AccountInfo;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.hongyan.wdcf.business.account.core.IdentifyManager;
import com.hongyan.wdcf.widget.ConfirmDialog;
import com.hongyan.wdcf.widget.MarginBannerView;
import com.hongyan.wdcf.widget.ProductB;
import com.hongyan.wdcf.widget.ScrollBannerView;

import java.util.ArrayList;

public class ProductFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private MarginBannerView bannerView;
    private ProductModel productModel;
    private ProductB productA;
    private ProductB productB;
    private LinearLayout title01;
    private ProductB product01;
    private ProductB product02;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_sub_product, container, false);
            initView();
            productModel = new ProductModel(this);
            productModel.request();
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != view) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    protected void setData(ProductResult.Data data) {
        Log.e("test", "");
        if (data == null) {
            return;
        }


        //标的
        ArrayList<ProductResult.Fixation> classFixation = data.classFixation;
        if (classFixation != null && classFixation.size() == 1) {
            final ProductResult.Fixation fixationA = classFixation.get(0);
            productA.setAmount(fixationA.scale);
            productA.setDeadLine(fixationA.end_time);
            productA.setDesc(fixationA.excerpt);
            productA.setImgUrl(fixationA.photo);
            productA.setLabel1(fixationA.effecStr);
            productA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoProductDetail(fixationA.detail_url, fixationA.risk_lv);
                }
            });
            if (StringUtils.notEmpty(fixationA.tags)) {
                String[] tags = fixationA.tags.split(",");
                if (tags.length == 1) {
                    productA.setLabel2(tags[0]);
                } else if (tags.length == 2) {
                    productA.setLabel2(tags[0]);
                    productA.setLabel3(tags[1]);
                }
            }
            productB.setVisibility(View.GONE);
        } else if (classFixation != null && classFixation.size() == 2) {
            final ProductResult.Fixation fixationA = classFixation.get(0);
            productA.setAmount(fixationA.scale);
            productA.setDeadLine(fixationA.end_time);
            productA.setDesc(fixationA.excerpt);
            productA.setImgUrl(fixationA.photo);
            productA.setLabel1(fixationA.effecStr);
            productA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoProductDetail(fixationA.detail_url, fixationA.risk_lv);
                }
            });
            if (StringUtils.notEmpty(fixationA.tags)) {
                String[] tags = fixationA.tags.split(",");
                if (tags.length == 1) {
                    productA.setLabel2(tags[0]);
                } else if (tags.length == 2) {
                    productA.setLabel2(tags[0]);
                    productA.setLabel3(tags[1]);
                }
            }

            final ProductResult.Fixation fixationB = classFixation.get(1);
            productB.setAmount(fixationB.scale);
            productB.setDeadLine(fixationB.end_time);
            productB.setDesc(fixationB.excerpt);
            productB.setImgUrl(fixationB.photo);
            productB.setLabel1(fixationA.effecStr);
            productB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoProductDetail(fixationB.detail_url, fixationB.risk_lv);
                }
            });
            if (StringUtils.notEmpty(fixationB.tags)) {
                String[] tags = fixationA.tags.split(",");
                if (tags.length == 1) {
                    productB.setLabel2(tags[0]);
                } else if (tags.length == 2) {
                    productB.setLabel2(tags[0]);
                    productB.setLabel3(tags[1]);
                }
            }
        } else {
            productA.setVisibility(View.GONE);
            productB.setVisibility(View.GONE);
        }

        //平铺产品
        final ArrayList<ProductResult.Equity> equities = data.privateEquity;
        if (equities != null) {
            if (equities.size() == 1) {
                final ProductResult.Equity equity01 = equities.get(0);
                product01.setAmount(equity01.scale);
                product01.setDeadLine(equity01.end_time);
                product01.setDesc(equity01.excerpt);
                product01.setImgUrl(equity01.photo);
                product01.setLabel1(equity01.effecStr);
                product01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoProductDetail(equity01.detail_url, equity01.risk_lv);
                    }
                });
                product02.setVisibility(View.GONE);
            } else if (equities.size() == 2) {
                final ProductResult.Equity equity01 = equities.get(0);
                product01.setAmount(equity01.scale);
                product01.setDeadLine(equity01.end_time);
                product01.setDesc(equity01.excerpt);
                product01.setLabel1(equity01.effecStr);
                product01.setImgUrl(equity01.photo);
                product01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoProductDetail(equity01.detail_url, equity01.risk_lv);
                    }
                });
                final ProductResult.Equity equity02 = equities.get(1);
                product02.setAmount(equity02.scale);
                product02.setDeadLine(equity02.end_time);
                product02.setDesc(equity02.excerpt);
                product02.setLabel1(equity01.effecStr);
                product02.setImgUrl(equity02.photo);
                product02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoProductDetail(equity02.detail_url, equity02.risk_lv);
                    }
                });
            } else {
                product01.setVisibility(View.GONE);
                product02.setVisibility(View.GONE);
                title01.setVisibility(View.GONE);
            }
        } else {
            product01.setVisibility(View.GONE);
            product02.setVisibility(View.GONE);
        }
        final ArrayList<ProductResult.Ad> list = data.topAd;
        final ArrayList<String> stringArrayList = new ArrayList<>();
        for (ProductResult.Ad ad : list) {
            stringArrayList.add(ad.photo);
            stringArrayList.add(ad.photo);
        }
        bannerView.setData(stringArrayList);
        bannerView.setOnPageClickListener(new ScrollBannerView.OnPageClickListener() {
            @Override
            public void setOnPage(int position) {
                if (list.size() > 0) {
                    Router router = new Router();
                    router.setUrl(list.get(0).url);
                    router.addParams(RequestKeyTable.TITLE, "热点资讯");
                    RouterManager.getInstance().openUrl(router);
                }
            }
        });
    }

    private void initView() {
        bannerView = view.findViewById(R.id.banner);
        productA = view.findViewById(R.id.product_A);
        productB = view.findViewById(R.id.product_B);
        title01 = view.findViewById(R.id.title_01);
        product01 = view.findViewById(R.id.product_01);
        product02 = view.findViewById(R.id.product_02);
        TextView textView01 = view.findViewById(R.id.tv_product_01);
        TextView textView02 = view.findViewById(R.id.tv_product_02);
        TextView textView03 = view.findViewById(R.id.tv_product_03);
        TextView textView04 = view.findViewById(R.id.tv_product_04);
        TextView textView05 = view.findViewById(R.id.tv_product_05);
        TextView textView06 = view.findViewById(R.id.tv_product_06);
        textView01.setOnClickListener(this);
        textView02.setOnClickListener(this);
        textView03.setOnClickListener(this);
        textView04.setOnClickListener(this);
        textView05.setOnClickListener(this);
        textView06.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_product_01:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.ProductListFixed));
                break;
            case R.id.tv_product_02:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.ProductListSimu));
                break;
            case R.id.tv_product_03:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.ProductListOverseas));
                break;
            case R.id.tv_product_04:
                RouterManager.getInstance().openUrl(new Router(RouterConfig.ProductListInsurance));
                break;
            case R.id.tv_product_05:
                showErrorToast("敬请期待");
                break;
            case R.id.tv_product_06:
                showErrorToast("敬请期待");
                break;
        }
    }

    /**
     * 点击产品的时候，
     * 0.判断当前用户有没有实名认证和绑定理财师
     * 1.如果没有进行过风险评测，那么跳转该风险评测页面。
     * 2.如果本地已经有评测等级，然后比较等级
     */
    private void gotoProductDetail(String url, int risk) {
        if (!IdentifyManager.getInstance().startVerify()) {//登录和实名认证
            return;
        }
        if (!IdentifyManager.getInstance().isBindTeacher()) {//绑定理财师
            return;
        }
        AccountInfo accountInfo = AccountManager.getInstance().getAccountInfo();
        if (risk > accountInfo.getReview()) {//比较等级
            showRiskDialog(accountInfo.getReview());
            return;
        }
        Router router = new Router(url);
        router.addParams(RequestKeyTable.TOKEN, AccountManager.getInstance().getToken());
        RouterManager.getInstance().openUrl(router);
    }

    private void showRiskDialog(int level) {
        String str = "您目前的风险评测等级为R" + level + "，与此产品风险级别不匹配，不能浏览该产品";
        final ConfirmDialog dialog = new ConfirmDialog(getActivity());
        dialog.show();
        dialog.setContent(str, "取消", "现在评测");
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
                RouterManager.getInstance().openUrl(new Router("http://caifu.thongfu.com/App/Assessment/lists.html?title=风险评估"));
            }
        });
    }

}
