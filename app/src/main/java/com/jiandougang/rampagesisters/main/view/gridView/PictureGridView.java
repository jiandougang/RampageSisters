package com.jiandougang.rampagesisters.main.view.gridView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * Created by mabeijianxi on 2015/9/17.
 */
public class PictureGridView extends GridView {

    public PictureGridView(Context context) {

        super(context);

    }

    public PictureGridView(Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public PictureGridView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);

    }

    /**
     * 处理嵌套显示不全的问题
     *
     * @param widthMeasureSpec  widthMeasureSpec
     * @param heightMeasureSpec heightMeasureSpec
     */
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    @Override

    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_MOVE) {

            return true;  //禁止GridView滑动
        }

        return super.dispatchTouchEvent(ev);
    }
}
