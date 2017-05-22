package com.jiandougang.rampagesisters.dezhoubank.foundation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.dezhoubank.foundation.FoundationBean;

import java.util.List;
import java.util.Objects;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 保险产品基本信息adapter
 * Created by mabeijianxi on 2016/1/3.
 */
public class FoundationProductsComparisonKeyAdapter extends RecyclerView.Adapter<FoundationProductsComparisonKeyAdapter.InsuranceProductsDetailBaseInfoAdapterHolder> {

    private SupportFragment mContext;
    private Objects[] nullData;
    private List<FoundationBean> dataList;

    public FoundationProductsComparisonKeyAdapter(SupportFragment context, Objects[] nullData) {
        this.mContext = context;
        this.nullData = nullData;

    }


    @Override
    public int getItemCount() {
        return nullData.length;
    }

    @Override
    public InsuranceProductsDetailBaseInfoAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_foundation_products_key, parent, false);
        return new InsuranceProductsDetailBaseInfoAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(InsuranceProductsDetailBaseInfoAdapterHolder holder, int position) {

        switch (position) {
            case 0:
                holder.key = "基金名称";
                break;

            case 1:
                holder.key = "基金代码";
                break;

            case 2:
                holder.key = "基金类型";
                break;

            case 3:
                holder.key = "申购状态";
                break;

            case 4:
                holder.key = "赎回状态";
                break;

            case 5:
                holder.key = "单位净值";
                break;

            case 6:
                holder.key = "累计净值";
                break;

            case 7:
                holder.key = "每百分收益";
                break;
        }

        holder.tvKey.setText(holder.key);

    }


    public static class InsuranceProductsDetailBaseInfoAdapterHolder extends RecyclerView.ViewHolder {

        private TextView tvKey;
        private String key;

        public InsuranceProductsDetailBaseInfoAdapterHolder(View itemView) {
            super(itemView);
            tvKey = (TextView) itemView.findViewById(R.id.tv_key);
        }


    }

}
