package com.jiandougang.rampagesisters.InsuraceProducts.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiandougang.rampagesisters.InsuraceProducts.InsuranceBean;
import com.jiandougang.rampagesisters.InsuraceProducts.InsuranceProductsAdapter;
import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseFragment;

import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 保险列表
 * Created by wuguohong on 2017/5/18.
 */

public class InsuranceProductsTitleFragment extends RPBaseFragment {

    private InsuranceProductsAdapter insuranceProductsAdapter;
    private ArrayList<InsuranceBean> insuranceBeanArrayList = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView rvProducts;
    private TextView tvAllProducts, tvHotProducts, tvNewestProducts;
    private ArrayList<TextView> tvProductsArrayList;
    private SupportFragment[] tabFragments = new SupportFragment[3];
    private int preTabIndex = 0;

    public static InsuranceProductsTitleFragment newInstance() {
        return new InsuranceProductsTitleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insurance_products_list, container, false);

        if (savedInstanceState == null) {
            initView(view);
            initEvent();
        } else {
            tabFragments[0] = findFragment(InsuranceProductsListFragment.class);
            tabFragments[1] = findFragment(InsuranceProductsListFragment.class);
            tabFragments[2] = findFragment(InsuranceProductsListFragment.class);
        }
//
//
//
//        for (int i = 0; i < 10; i++) {
//            InsuranceBean insuranceBean = new InsuranceBean();
//            insuranceBean.setProductName("fuck you ");
//            insuranceBean.setPuttingTime("1990-09-19");
//            insuranceBeanArrayList.add(insuranceBean);
//        }
//
//        layoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
//        insuranceProductsAdapter = new InsuranceProductsAdapter(getActivity(), insuranceBeanArrayList);
//
//        rvProducts = (RecyclerView) view.findViewById(R.id.rv_products);
//        SpacesItemDecoration decoration = new SpacesItemDecoration(20);
//        rvProducts.addItemDecoration(decoration);
//        rvProducts.setLayoutManager(layoutManager);
//        rvProducts.setAdapter(insuranceProductsAdapter);
        return view;
    }

    private void initView(View view) {


        tvAllProducts = (TextView) view.findViewById(R.id.tv_all_products);
        tvHotProducts = (TextView) view.findViewById(R.id.tv_hot_products);
        tvNewestProducts = (TextView) view.findViewById(R.id.tv_newest_products);


        tvProductsArrayList = new ArrayList<>();
        tvProductsArrayList.add(tvAllProducts);
        tvProductsArrayList.add(tvHotProducts);
        tvProductsArrayList.add(tvNewestProducts);


        tabFragments[0] = InsuranceProductsListFragment.newInstance();
        tabFragments[1] = InsuranceProductsListFragment.newInstance();
        tabFragments[2] = InsuranceProductsListFragment.newInstance();

        loadMultipleRootFragment(R.id.fl_products, 0, tabFragments[0], tabFragments[1], tabFragments[2]);


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
    }

    private void setTabsClick(View view) {

        int size = tvProductsArrayList.size();
        for (int i = 0; i < size; i++) {
            tvProductsArrayList.get(i).setBackgroundResource(R.color.transparent);
            tvProductsArrayList.get(i).setTextColor(getResources().getColor(R.color.white));

            if (tvProductsArrayList.get(i) == view) {
                view.setBackgroundResource(R.drawable.sale_leads_white_tab);
                tvProductsArrayList.get(i).setTextColor(getResources().getColor(R.color.black));


                int currentIndex = 0;
                switch (view.getId()) {

                    case R.id.tv_all_products:
                        currentIndex = 0;
                        break;

                    case R.id.tv_hot_products:
                        currentIndex = 1;
                        break;

                    case R.id.tv_newest_products:
                        currentIndex = 2;
                        break;
                }

                showHideFragment(tabFragments[currentIndex], tabFragments[preTabIndex]);
                preTabIndex = currentIndex;
            }
        }

    }
}
