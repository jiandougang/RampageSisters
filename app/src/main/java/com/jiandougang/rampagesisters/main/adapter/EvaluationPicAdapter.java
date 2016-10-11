package com.jiandougang.rampagesisters.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandougang.rampagesisters.R;

/**
 * 朋友圈图片apater
 * Created by wuguohong on 16/10/11.
 */

public class EvaluationPicAdapter extends RecyclerView.Adapter<EvaluationPicAdapter.EvaluationPicHolder> {


    @Override
    public EvaluationPicAdapter.EvaluationPicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_friend_circle, parent, false);

        return new EvaluationPicAdapter.EvaluationPicHolder(view);
    }


    @Override
    public void onBindViewHolder(EvaluationPicAdapter.EvaluationPicHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class EvaluationPicHolder extends RecyclerView.ViewHolder {


        public EvaluationPicHolder(View itemView) {
            super(itemView);


        }


    }
}
