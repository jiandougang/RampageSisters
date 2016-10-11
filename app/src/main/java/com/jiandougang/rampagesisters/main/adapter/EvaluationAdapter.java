package com.jiandougang.rampagesisters.main.adapter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.databinding.AdapterFriendCircleBinding;
import com.jiandougang.rampagesisters.main.model.RPEvaluationBean;

import java.util.ArrayList;

/**
 * 朋友圈adapter
 * Created by mabeijianxi on 2016/1/3.
 */
public class EvaluationAdapter extends RecyclerView.Adapter<EvaluationAdapter.EvaluationHolder> {
    /**
     * 当高分辨率的时候服务器的图片显得太小，这里优化下显示比例
     */
    private Float fTimes;
    private Context mContext;
    private ArrayList<RPEvaluationBean> rpEvaluationBeanArrayList;
    private EvaluationGvPicAdaper mEvaluationGvPicAdaper;


    public ArrayList<RPEvaluationBean> getRpEvaluationBeanArrayList() {
        return rpEvaluationBeanArrayList;
    }


    public EvaluationAdapter(Context context) {
        this.mContext = context;
        rpEvaluationBeanArrayList = new ArrayList<>();

//        适配单图放大比例
        String sTimes = mContext.getResources().getString(R.string.times);
        fTimes = Float.valueOf(sTimes);
    }

    public void clearAdapterNotifyData() {
        rpEvaluationBeanArrayList.clear();
        notifyDataSetChanged();
    }

    public void clearAdapter() {
        rpEvaluationBeanArrayList.clear();
    }

    public void addEvaluationDataAllNotifyData(ArrayList<RPEvaluationBean> data) {
        if (data != null) {
            rpEvaluationBeanArrayList.addAll(data);
            notifyDataSetChanged();
        }

    }

    public void addEaluationDataAll(ArrayList<RPEvaluationBean> data) {
        if (data != null) {
            rpEvaluationBeanArrayList.addAll(data);
        }

    }

    public void addEvaluationData(RPEvaluationBean data) {
        if (data != null) {
            rpEvaluationBeanArrayList.add(data);
            notifyItemInserted(rpEvaluationBeanArrayList.size() - 1);
//            notifyDataSetChanged();
        }

    }

    @Override
    public int getItemCount() {
        return rpEvaluationBeanArrayList.size();
    }

    @Override
    public EvaluationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_friend_circle, parent, false);

        return new EvaluationHolder(view);
    }

    @Override
    public void onBindViewHolder(EvaluationHolder holder, int position) {

        holder.bind(rpEvaluationBeanArrayList.get(position));

        holder.layoutManager = new GridLayoutManager(mContext, 3, GridLayoutManager.VERTICAL, false);
        holder.evaluationPicAdapter = new EvaluationPicAdapter();
        holder.rcPicture.setLayoutManager(holder.layoutManager);
        holder.rcPicture.setAdapter(holder.evaluationPicAdapter);
    }



    public static class EvaluationHolder extends RecyclerView.ViewHolder {

        private AdapterFriendCircleBinding mBinding;
        private RecyclerView.LayoutManager layoutManager;
        private EvaluationPicAdapter evaluationPicAdapter;
        private RecyclerView rcPicture;

        public EvaluationHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
            rcPicture = (RecyclerView) itemView.findViewById(R.id.rv_picture);

        }

        public void bind(@NonNull RPEvaluationBean evaluationBean) {
            mBinding.setEvaluationBean(evaluationBean);
        }

        @BindingAdapter("url")
        public static void setHeadPortrait(final SimpleDraweeView view, String url) {
            if (url != null) {
                Uri uri = Uri.parse(url);
                view.setImageURI(uri);
            }
        }

    }

}
