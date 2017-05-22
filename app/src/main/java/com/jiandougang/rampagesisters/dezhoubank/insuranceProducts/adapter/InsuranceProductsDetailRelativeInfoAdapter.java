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
public class InsuranceProductsDetailRelativeInfoAdapter extends RecyclerView.Adapter<InsuranceProductsDetailRelativeInfoAdapter.InsuranceProductsDetailBaseInfoAdapterHolder> {

    private SupportFragment mContext;
    private Objects[] nullData;
    private InsuranceBean insuranceBean;


    public InsuranceProductsDetailRelativeInfoAdapter(SupportFragment context, Objects[] nullData, InsuranceBean insuranceBean) {
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
                holder.title = "产品简介";
                holder.content = insuranceBean.getBriefIntroduction();
                break;
            case 1:
                holder.title = "产品特点";
                holder.content = insuranceBean.getCharacteristic();
                break;
            case 2:
                holder.title = "适合人群";
                holder.content = insuranceBean.getSuitableCrowd();
                break;
            case 3:
                holder.title = "投保范围";
                holder.content = insuranceBean.getInsuranceScope();
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
