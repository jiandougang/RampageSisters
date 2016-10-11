package com.jiandougang.rampagesisters.main.view.recycleView;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.main.view.recycleView.util.AnimUtil;

import java.util.ArrayList;

/**
 *
 * Created by kai.wang on 3/18/14.
 */
public class RecycleZoomView extends WrapRecyclerView {


    private ArrayList<View> mHeaderViews = new ArrayList<>();

    private ArrayList<View> mFootViews = new ArrayList<>();

    private Adapter mAdapter;

    private float downY = 0.0f;

    private View headerView;

    /**
     * headerView真实高度
     */
    private int headerHeight;

    private int currentHeaderHeight;

    private int maxHeaderHeight;

    private boolean zooming;


    public RecycleZoomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.pull);
        int layout = typedArray.getResourceId(R.styleable.pull_header, 0);
        maxHeaderHeight = typedArray.getLayoutDimension(R.styleable.pull_maxHeaderHeight, 0);
        int minHeaderHeight = typedArray.getLayoutDimension(R.styleable.pull_minHeaderHeight, 0);
        typedArray.recycle();

        if (layout == 0) {
            throw new RuntimeException("RecycleZoomView haven't header view.");
        }
        if (maxHeaderHeight == 0) {
            throw new RuntimeException("RecycleZoomView maxHeaderHeight must be set.");
        }

        headerView = LayoutInflater.from(context).inflate(layout, null);
        addHeaderView(headerView, minHeaderHeight);
        currentHeaderHeight = headerHeight;

    }

    protected void addHeaderView(View headerView, int height) {
        this.headerView = headerView;
        addHeaderView(headerView);
        measureHeader(headerView, height);
        headerHeight = headerView.getMeasuredHeight();
    }


    /**
     * measure header view's width and height
     *
     * @param headerView
     * @param height
     */
    private void measureHeader(View headerView, int height) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) headerView.getLayoutParams();

        if (layoutParams == null) {
            int h = height == 0 ? ViewGroup.LayoutParams.WRAP_CONTENT : height;
            layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, h);
        } else if (height != 0) {
            layoutParams.height = height;
        }

        headerView.setLayoutParams(layoutParams);
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int lpHeight = layoutParams.height;
        int childHeightSpec;

        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }

        headerView.measure(childWidthSpec, childHeightSpec);
    }


    /**
     * 计算并调整header显示的高度
     *
     * @param ev
     * @param actionUp
     */
    private void computeTravel(MotionEvent ev, boolean actionUp) {
        float movingY = ev.getRawY();
        int travel = (int) (downY - movingY);

        //向上拖动
        boolean up = travel > 0;

        travel = Math.abs(travel);

        move(travel, up, actionUp);
    }

    public void move(int distance, boolean upwards, boolean release) {
        // illegal distance
//        if (distance > 30) {
//            return;
//        }

        if (release) {//拉申
            // zooming
            if (headerView.getHeight() > headerHeight) {
                AnimUtil.collapse(headerView, headerHeight);
                currentHeaderHeight = headerHeight;
            }
            zooming = false;
        } else {//回弹
            zooming = true;
            resizeHeader(distance, upwards);
        }
    }

    private void resizeHeader(int distance, boolean upwards) {

        distance = (int) (distance / 1.5f);
        // zoom out
        if (upwards && headerView.getHeight() > headerHeight) {
            int tmpHeight = currentHeaderHeight - distance;
            if (tmpHeight < headerHeight) {
                tmpHeight = headerHeight;
            }
            currentHeaderHeight = tmpHeight;
            resizeHeight(currentHeaderHeight);

        }
        if (!upwards && headerView.getHeight() >= headerHeight) {
            // zoom in
            currentHeaderHeight += distance;
            if (currentHeaderHeight > maxHeaderHeight) {
                currentHeaderHeight = maxHeaderHeight;
            }
            resizeHeight(currentHeaderHeight);
        }

    }


    private void resizeHeight(int resizeHeight) {
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) headerView.getLayoutParams();
        if (params == null) {
            params = new RecyclerView.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, resizeHeight);
        } else {
            params.height = resizeHeight;
        }
        headerView.setLayoutParams(params);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int action = event.getAction();
        boolean result = false;

        switch (action) {

            case MotionEvent.ACTION_DOWN:

                if (headerView.getTop() == getTop()) {
                    downY = event.getRawY();
                }
                downY = event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:

                break;
        }


        return super.onInterceptTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        if (action == MotionEvent.ACTION_MOVE) {
            boolean upwards = downY - event.getRawY() > 0;
            //下拉放大
            if (headerView.getHeight() >= headerHeight && headerView.getTop() == getTop()) {
                if (!(upwards && headerView.getHeight() == headerHeight)) {
                    computeTravel(event, false);
                    downY = event.getRawY();

                    return true;
                }

            }
            //headerView置顶的情况
        } else if (action == MotionEvent.ACTION_UP && headerView.getTop() == getTop()) {
            computeTravel(event, true);
        }

        return super.onTouchEvent(event);
    }

}
