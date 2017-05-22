package com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseFragment;
import com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.InsuranceBean;
import com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.adapter.InsuranceProductsDetailBaseInfoAdapter;
import com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.adapter.InsuranceProductsDetailRelativeInfoAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 保险详情页
 * Created by wuguohong on 2017/5/18.
 */

public class InsuranceProductsDetailFragment extends RPBaseFragment {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView rvBaseInfo, rvRelativeInfo;
    private TextView tvRelativeInfo;
    private InsuranceProductsDetailBaseInfoAdapter baseInfoAdapter;
    private InsuranceProductsDetailRelativeInfoAdapter relativeInfoAdapter;
    private InsuranceBean insuranceBean = new InsuranceBean();

    public static InsuranceProductsDetailFragment newInstance() {
        return new InsuranceProductsDetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insurance_products_detail, container, false);

        initData();
        initView(view);
        return view;
    }


    private void initView(View view) {

        rvBaseInfo = (RecyclerView) view.findViewById(R.id.rv_base_info);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        baseInfoAdapter = new InsuranceProductsDetailBaseInfoAdapter(this, new Objects[6], insuranceBean);
        rvBaseInfo.setLayoutManager(layoutManager);
        rvBaseInfo.setAdapter(baseInfoAdapter);

        rvRelativeInfo = (RecyclerView) view.findViewById(R.id.rv_relative_info);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        relativeInfoAdapter = new InsuranceProductsDetailRelativeInfoAdapter(this, new Objects[4], insuranceBean);
        rvRelativeInfo.setLayoutManager(layoutManager);
        rvRelativeInfo.setAdapter(relativeInfoAdapter);

        tvRelativeInfo = (TextView) view.findViewById(R.id.tv_relative_info);
        tvRelativeInfo.setText(insuranceBean.getProductName());
    }

    private void initData() {

        insuranceBean.setProductName("fuck you ");
        insuranceBean.setPuttingTime("1990-09-19");
        insuranceBean.setProductName("年金险");
        insuranceBean.setProductCompany("中国人寿");
        insuranceBean.setPaymentWay("期缴");
        insuranceBean.setBriefIntroduction("说了你也不懂，滚");
        insuranceBean.setCharacteristic("死了绝逼能赔");
        insuranceBean.setSuitableCrowd("老少咸宜");
        insuranceBean.setInsuranceScope("18岁--55岁");
        List<String> list = new ArrayList<>();
        list.add("3年");
        list.add("5年");
        list.add("20年");
        insuranceBean.setPaymentPeriod(list);
        list.clear();
        list.add("10年");
        list.add("20年");
        insuranceBean.setInsurancePeriod(list);
        insuranceBean.setMinimumAmount("1000元起");


    }
}


