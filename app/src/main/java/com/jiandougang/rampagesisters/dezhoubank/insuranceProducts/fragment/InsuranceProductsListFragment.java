package com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.InsuranceBean;
import com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.adapter.InsuranceProductsAdapter;
import com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.SpacesItemDecoration;
import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseFragment;

import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 保险列表
 * Created by wuguohong on 2017/5/18.
 */

public class InsuranceProductsListFragment extends RPBaseFragment {

    private InsuranceProductsAdapter insuranceProductsAdapter;
    private ArrayList<InsuranceBean> insuranceBeanArrayList = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView rvProducts;


    public static InsuranceProductsListFragment newInstance() {
        return new InsuranceProductsListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insurance_products_recycleview, container, false);

        if (savedInstanceState == null) {
            initView(view);
            initEvent();
        }

        for (int i = 0; i < 10; i++) {
            InsuranceBean insuranceBean = new InsuranceBean();
            insuranceBean.setProductName("fuck you ");
            insuranceBean.setPuttingTime("1990-09-19");
            insuranceBeanArrayList.add(insuranceBean);
        }


        layoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        SupportFragment fragment = (SupportFragment)getParentFragment();
        insuranceProductsAdapter = new InsuranceProductsAdapter(fragment, insuranceBeanArrayList);

        rvProducts = (RecyclerView) view.findViewById(R.id.rv_products);
        SpacesItemDecoration decoration = new SpacesItemDecoration(20);
        rvProducts.addItemDecoration(decoration);
        rvProducts.setLayoutManager(layoutManager);
        rvProducts.setAdapter(insuranceProductsAdapter);
        return view;
    }

    private void initView(View view) {


    }


    private void initEvent() {

    }


}
