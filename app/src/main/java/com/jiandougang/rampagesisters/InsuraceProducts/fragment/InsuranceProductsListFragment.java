package com.jiandougang.rampagesisters.InsuraceProducts.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandougang.rampagesisters.InsuraceProducts.InsuranceBean;
import com.jiandougang.rampagesisters.InsuraceProducts.InsuranceProductsAdapter;
import com.jiandougang.rampagesisters.InsuraceProducts.SpacesItemDecoration;
import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseFragment;

import java.util.ArrayList;

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
        insuranceProductsAdapter = new InsuranceProductsAdapter(getActivity(), insuranceBeanArrayList);

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
