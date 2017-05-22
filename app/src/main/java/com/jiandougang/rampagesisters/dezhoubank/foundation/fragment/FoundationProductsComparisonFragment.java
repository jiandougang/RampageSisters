package com.jiandougang.rampagesisters.dezhoubank.foundation.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseFragment;
import com.jiandougang.rampagesisters.dezhoubank.foundation.FoundationBean;
import com.jiandougang.rampagesisters.dezhoubank.foundation.adapter.FoundationProductsComparisonContentAdapter;
import com.jiandougang.rampagesisters.dezhoubank.foundation.adapter.FoundationProductsComparisonKeyAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 基金对比页
 * Created by wuguohong on 2017/5/18.
 */

public class FoundationProductsComparisonFragment extends RPBaseFragment {

    private List<FoundationBean> dataList = new ArrayList<>();
    private FoundationBean foundationBean = new FoundationBean();
    private RecyclerView rvKey, rvConent;
    private RecyclerView.LayoutManager layoutManager;
    private FoundationProductsComparisonKeyAdapter foundationProductsComparisonkeyAdapter;
    private FoundationProductsComparisonContentAdapter foundationProductsComparisonContentAdapter;
    private int rowSize;

    private int preTabIndex = 0;

    public static FoundationProductsComparisonFragment newInstance() {
        return new FoundationProductsComparisonFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foundation_products_comparison, container, false);

        if (savedInstanceState == null) {
            initData();
            initView(view);
        }

        return view;
    }

    private void initView(View view) {
        rvKey = (RecyclerView) view.findViewById(R.id.rv_key);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }

        };
        foundationProductsComparisonkeyAdapter = new FoundationProductsComparisonKeyAdapter(this, new Objects[8]);
        rvKey.setLayoutManager(layoutManager);
        rvKey.setAdapter(foundationProductsComparisonkeyAdapter);

        rvConent = (RecyclerView) view.findViewById(R.id.rv_content);
        layoutManager = new GridLayoutManager(getContext(), rowSize, GridLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }

        };

        foundationProductsComparisonContentAdapter = new FoundationProductsComparisonContentAdapter(this, dataList);
        rvConent.setLayoutManager(layoutManager);
        rvConent.setAdapter(foundationProductsComparisonContentAdapter);


    }

    private void initData() {
        ArrayList arrayList = getArguments().getParcelableArrayList("dataList");
        dataList = (List<FoundationBean>) arrayList.get(0);
        rowSize = dataList.size();
    }
}
