package com.jiandougang.rampagesisters.dezhoubank.foundation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.dezhoubank.foundation.FoundationBean;
import com.jiandougang.rampagesisters.dezhoubank.foundation.presenter.FoundationProductsComparisonKeyAdapterPresenter;

import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 基金产品基本信息adapter
 * Created by mabeijianxi on 2016/1/3.
 */
public class FoundationProductsComparisonContentAdapter extends RecyclerView.Adapter<FoundationProductsComparisonContentAdapter.FoundationProductsComparisonContentAdapterHolder> {

    private SupportFragment mContext;


    private FoundationProductsComparisonKeyAdapterPresenter presenter;
    private List<String> realDataList;


    public FoundationProductsComparisonContentAdapter(SupportFragment context, List<FoundationBean> dataList) {
        this.mContext = context;


        this.presenter = new FoundationProductsComparisonKeyAdapterPresenter();

        realDataList = presenter.transformDataList(dataList);


    }


    @Override
    public int getItemCount() {
        return realDataList.size();
    }

    @Override
    public FoundationProductsComparisonContentAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_foundation_products_content, parent, false);
        return new FoundationProductsComparisonContentAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(FoundationProductsComparisonContentAdapterHolder holder, int position) {
        holder.tvContent.setText(realDataList.get(position));

    }


    public class FoundationProductsComparisonContentAdapterHolder extends RecyclerView.ViewHolder {
        private TextView tvContent;

        public FoundationProductsComparisonContentAdapterHolder(View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }


    }

}
