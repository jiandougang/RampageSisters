package com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.InsuranceBean;
import com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.fragment.InsuranceProductsDetailFragment;
import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.databinding.AdapterInsuranceProductsBinding;

import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 保险产品adapter
 * Created by mabeijianxi on 2016/1/3.
 */
public class InsuranceProductsAdapter extends RecyclerView.Adapter<InsuranceProductsAdapter.InsuranceProductsHolder> {

    private SupportFragment mContext;
    private ArrayList<InsuranceBean> insuranceBeanArrayList;


    public InsuranceProductsAdapter(SupportFragment context, ArrayList<InsuranceBean> insuranceBeanArrayList) {
        this.mContext = context;
        this.insuranceBeanArrayList = insuranceBeanArrayList;


    }


    @Override
    public int getItemCount() {
        return insuranceBeanArrayList.size();
    }

    @Override
    public InsuranceProductsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_insurance_products, parent, false);
        return new InsuranceProductsHolder(view);
    }

    @Override
    public void onBindViewHolder(InsuranceProductsHolder holder, int position) {

        holder.bind(mContext, insuranceBeanArrayList.get(position));

    }


    public static class InsuranceProductsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private AdapterInsuranceProductsBinding binding;
        private SupportFragment context;

        public InsuranceProductsHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);
        }


        public void bind(SupportFragment context, @NonNull InsuranceBean insuranceBean) {
            binding.setInsuranceBean(insuranceBean);
            this.context = context;

        }

        @Override
        public void onClick(View view) {
            context.start(InsuranceProductsDetailFragment.newInstance());
        }
    }

}
