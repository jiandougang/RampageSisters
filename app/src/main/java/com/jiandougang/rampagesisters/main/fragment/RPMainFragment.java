package com.jiandougang.rampagesisters.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseFragment;
import com.jiandougang.rampagesisters.main.adapter.RPMainAdapter;

/**
 * 首页-旅游资讯
 * Created by wuguohong on 16/8/11.
 */
public class RPMainFragment extends RPBaseFragment {

    private View view;
    private RecyclerView rcContent;
    private RPMainAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;



    public static RPMainFragment newInstance() {
        return new RPMainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rcContent = (RecyclerView) view.findViewById(R.id.rc_content);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        adapter = new RPMainAdapter(getContext());
        rcContent.setAdapter(adapter);
        rcContent.setLayoutManager(layoutManager);
    }
}
