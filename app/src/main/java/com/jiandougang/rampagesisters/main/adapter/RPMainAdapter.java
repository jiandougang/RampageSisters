package com.jiandougang.rampagesisters.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.main.viewholder.RPMainViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴走资讯adapter
 * Created by wuguohong on 16/8/11.
 */
public class RPMainAdapter extends RecyclerView.Adapter<RPMainViewHolder> {

    public Context context;
    public LayoutInflater layoutInflater;
    public List<String> datas;

    public RPMainAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

        datas = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            datas.add((char) i + "");
        }
    }

    @Override
    public RPMainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.adapter_main,parent,false);
        RPMainViewHolder viewHolder = new RPMainViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RPMainViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
