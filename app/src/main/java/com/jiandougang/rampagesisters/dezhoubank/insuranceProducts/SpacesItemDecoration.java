package com.jiandougang.rampagesisters.dezhoubank.insuranceProducts;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * GridViewRecycleView 间距
 * Created by wuguohong on 2017/5/18.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = space;
        outRect.top = space;

    }
}