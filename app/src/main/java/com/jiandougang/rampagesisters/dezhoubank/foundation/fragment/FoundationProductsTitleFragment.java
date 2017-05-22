package com.jiandougang.rampagesisters.dezhoubank.foundation.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseFragment;
import com.jiandougang.rampagesisters.databinding.AdapterFoundationProductsBinding;
import com.jiandougang.rampagesisters.dezhoubank.foundation.FoundationBean;
import com.jiandougang.rampagesisters.main.view.pageRecyclerView.PageIndicatorView;
import com.jiandougang.rampagesisters.main.view.pageRecyclerView.PageRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 保险标题栏
 * Created by wuguohong on 2017/5/18.
 */

public class FoundationProductsTitleFragment extends RPBaseFragment {

    private TextView tvAllProducts, tvHotProducts, tvNewestProducts, tvCompare, tvSearchByCompany, tvSearchByCode;
    private ArrayList<TextView> tvProductsArrayList,tvSearchArrayList;
    private SupportFragment[] tabFragments = new SupportFragment[3];
    private PageRecyclerView prProducts;
    private PageRecyclerView.PageAdapter pageAdapter;
    private List<FoundationBean> dataList;

    private int preTabIndex = 0;

    public static FoundationProductsTitleFragment newInstance() {
        return new FoundationProductsTitleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foundation_products_title, container, false);

        if (savedInstanceState == null) {
            initData();
            initView(view);
            initEvent();
        }

        return view;
    }

    private void initData() {
        int max = 20;
        int min = 10;
        Random random = new Random();

        int size = random.nextInt(max) % (max - min + 1) + min;

        dataList = new ArrayList<>();
        dataList.clear();
        for (int i = 0; i < size; i++) {

            FoundationBean foundationBean = new FoundationBean();
            foundationBean.setProductName("fuck you ");
            foundationBean.setPuttingTime("1990-09-19");
            foundationBean.setProductName("fuck you ");
            foundationBean.setPuttingTime("1990-09-19");
            foundationBean.setProductName("年金险");
            foundationBean.setProductCompany("中国人寿");
            foundationBean.setPaymentWay("期缴");
            foundationBean.setBriefIntroduction("说了你也不懂，滚");
            foundationBean.setCharacteristic("死了绝逼能赔");
            foundationBean.setSuitableCrowd("老少咸宜");
            foundationBean.setInsuranceScope("18岁--55岁");
            foundationBean.setFoundationCode("2700008");
            foundationBean.setApplyState("开放");
            foundationBean.setRedeemState("开放");
            foundationBean.setNetAssetValue((int) 1.00);
            foundationBean.setAccumulativeNetAssetValue((int) 1.00);
            List<String> list = new ArrayList<>();
            list.add("3年");
            list.add("5年");
            list.add("20年");
            foundationBean.setPaymentPeriod(list);
            list.clear();
            list.add("10年");
            list.add("20年");
            foundationBean.setInsurancePeriod(list);
            foundationBean.setMinimumAmount("1000元起");
            if (i % 2 == 0) {
                foundationBean.setSelected(true);
            }
            dataList.add(foundationBean);
        }
    }


    private void initEvent() {
        tvAllProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTabsClick(view);

            }
        });

        tvHotProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTabsClick(view);
            }
        });

        tvNewestProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTabsClick(view);
            }
        });

        tvSearchByCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSearchClick(view);
            }
        });

        tvSearchByCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSearchClick(view);
            }
        });

        tvCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoundationProductsComparisonFragment foundationProductsComparisonFragment =
                        FoundationProductsComparisonFragment.newInstance();
                Bundle bundle = new Bundle();

                ArrayList list = new ArrayList();
                list.add(dataList);
                bundle.putParcelableArrayList("dataList", list);
                foundationProductsComparisonFragment.setArguments(bundle);


                start(foundationProductsComparisonFragment);

            }
        });
    }

    private void setTabsClick(View view) {

        int size = tvProductsArrayList.size();
        for (int i = 0; i < size; i++) {
            tvProductsArrayList.get(i).setBackgroundResource(R.color.transparent);
            tvProductsArrayList.get(i).setTextColor(getResources().getColor(R.color.white));

            if (tvProductsArrayList.get(i) == view) {
                view.setBackgroundResource(R.drawable.sale_leads_white_tab);
                tvProductsArrayList.get(i).setTextColor(getResources().getColor(R.color.black));

                initData();
                pageAdapter.refreshList(dataList);
            }
        }
    }

    private void setSearchClick(View view){
        int size = tvSearchArrayList.size();
        for (int i = 0; i < size; i++) {
            tvSearchArrayList.get(i).setBackgroundResource(R.color.transparent);
            tvSearchArrayList.get(i).setTextColor(getResources().getColor(R.color.white));

            if (tvSearchArrayList.get(i) == view) {
                view.setBackgroundResource(R.drawable.sale_leads_white_tab);
                tvSearchArrayList.get(i).setTextColor(getResources().getColor(R.color.black));

                initData();
                pageAdapter.refreshList(dataList);
            }
        }
    }

    private void initView(View view) {

        tvSearchByCompany = (TextView) view.findViewById(R.id.tv_search_by_company);
        tvSearchByCode = (TextView) view.findViewById(R.id.tv_search_by_code);

        tvSearchArrayList = new ArrayList<>();
        tvSearchArrayList.add(tvSearchByCompany);
        tvSearchArrayList.add(tvSearchByCode);


        tvAllProducts = (TextView) view.findViewById(R.id.tv_all_products);
        tvHotProducts = (TextView) view.findViewById(R.id.tv_hot_products);
        tvNewestProducts = (TextView) view.findViewById(R.id.tv_newest_products);

        tvProductsArrayList = new ArrayList<>();
        tvProductsArrayList.add(tvAllProducts);
        tvProductsArrayList.add(tvHotProducts);
        tvProductsArrayList.add(tvNewestProducts);


        prProducts = (PageRecyclerView) view.findViewById(R.id.pr_products);
        // 设置行数和列数
        prProducts.setPageSize(3, 3);
        // 设置页间距
        prProducts.setPageMargin(50);
        // 设置指示器
        prProducts.setIndicator((PageIndicatorView) view.findViewById(R.id.pi_indicator));

        ///////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////
        pageAdapter = prProducts.new PageAdapter(dataList, new PageRecyclerView.CallBack() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.adapter_foundation_products, parent, false);
                return new FoundationProductsHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((FoundationProductsHolder) holder).bind(FoundationProductsTitleFragment.this, dataList.get(position));

                if (dataList.get(position).getSelected()) {
                    ((FoundationProductsHolder) holder).ivSelectedState.setBackground(getResources().getDrawable(R.mipmap.image_check_on));
                } else {
                    ((FoundationProductsHolder) holder).ivSelectedState.setBackground(getResources().getDrawable(R.mipmap.image_check_off));
                }


            }

            @Override
            public void onItemClickListener(View view, int position) {

                ImageView ivSelectedState = (ImageView) view.findViewById(R.id.iv_selected_state);
                FoundationBean foundationBean = dataList.get(position);
                foundationBean.setSelected(!foundationBean.getSelected());
                if (foundationBean.getSelected()) {
                    ivSelectedState.setBackground(getResources().getDrawable(R.mipmap.image_check_on));
                } else {
                    ivSelectedState.setBackground(getResources().getDrawable(R.mipmap.image_check_off));
                }


            }

            @Override
            public void onItemLongClickListener(View view, int position) {

            }
        });
        ///////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////


        prProducts.setAdapter(pageAdapter);
        tvCompare = (TextView) view.findViewById(R.id.tv_compare);

    }


    public static class FoundationProductsHolder extends RecyclerView.ViewHolder {

        AdapterFoundationProductsBinding binding;
        private ImageView ivSelectedState;

        public FoundationProductsHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            ivSelectedState = (ImageView) itemView.findViewById(R.id.iv_selected_state);

        }

        public void bind(SupportFragment context, @NonNull FoundationBean foundationBean) {
            binding.setFoundationBean(foundationBean);

        }


    }
}
