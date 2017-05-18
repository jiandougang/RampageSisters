package com.jiandougang.rampagesisters.InsuraceProducts;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.databinding.AdapterInsuranceProductsBinding;
import com.socks.library.KLog;

import java.util.ArrayList;

/**
 * 保险产品adapter
 * Created by mabeijianxi on 2016/1/3.
 */
public class InsuranceProductsAdapter extends RecyclerView.Adapter<InsuranceProductsAdapter.InsuranceProductsHolder> {

    private Context mContext;
    private ArrayList<InsuranceBean> insuranceBeanArrayList;


    public InsuranceProductsAdapter(Context context, ArrayList<InsuranceBean> insuranceBeanArrayList) {
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

        holder.bind(insuranceBeanArrayList.get(position));

    }




    public static class InsuranceProductsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        AdapterInsuranceProductsBinding binding;

        public InsuranceProductsHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);
        }


        public void bind(@NonNull InsuranceBean insuranceBean) {
            binding.setInsuranceBean(insuranceBean);
        }

        @Override
        public void onClick(View view) {
            KLog.i("你他妈有没有到这里来啊");
        }
    }



}
