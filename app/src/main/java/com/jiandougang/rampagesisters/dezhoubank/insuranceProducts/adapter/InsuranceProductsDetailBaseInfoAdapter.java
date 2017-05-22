package com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.InsuranceBean;
import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.databinding.AdapterInsuranceProductsBaseInfoBinding;

import java.util.Objects;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 保险产品基本信息adapter
 * Created by mabeijianxi on 2016/1/3.
 */
public class InsuranceProductsDetailBaseInfoAdapter extends RecyclerView.Adapter<InsuranceProductsDetailBaseInfoAdapter.InsuranceProductsDetailBaseInfoAdapterHolder> {

    private SupportFragment mContext;
    private Objects[] nullData;
    private InsuranceBean insuranceBean;


    public InsuranceProductsDetailBaseInfoAdapter(SupportFragment context, Objects[] nullData, InsuranceBean insuranceBean) {
        this.mContext = context;
        this.nullData = nullData;
        this.insuranceBean = insuranceBean;

    }


    @Override
    public int getItemCount() {
        return nullData.length;
    }

    @Override
    public InsuranceProductsDetailBaseInfoAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_insurance_products_base_info, parent, false);
        return new InsuranceProductsDetailBaseInfoAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(InsuranceProductsDetailBaseInfoAdapterHolder holder, int position) {

        switch (position) {
            case 0:
                holder.title = "险种名称";
                holder.content = insuranceBean.getProductName();
                break;
            case 1:
                holder.title = "保险公司";
                holder.content = insuranceBean.getProductCompany();
                break;
            case 2:
                holder.title = "缴费方式名称";
                holder.content = insuranceBean.getPaymentWay();
                break;
            case 3:
                holder.title = "缴费期限";
                holder.content = insuranceBean.getPaymentPeriod().toString();
                break;
            case 4:
                holder.title = "投保期限";
                holder.content = insuranceBean.getInsurancePeriod().toString();
                break;
            case 5:
                holder.title = "起点金额";
                holder.content = insuranceBean.getMinimumAmount();
                break;
        }

        holder.tvTitle.setText(holder.title);
        holder.tvContent.setText(holder.content);

    }


    public static class InsuranceProductsDetailBaseInfoAdapterHolder extends RecyclerView.ViewHolder {

        private AdapterInsuranceProductsBaseInfoBinding binding;
        private TextView tvTitle, tvContent;
        private String title, content;

        public InsuranceProductsDetailBaseInfoAdapterHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            binding = DataBindingUtil.bind(itemView);
        }


        public void bind(@NonNull InsuranceBean insuranceBean) {
            binding.setInsuranceBean(insuranceBean);

        }

    }

}
