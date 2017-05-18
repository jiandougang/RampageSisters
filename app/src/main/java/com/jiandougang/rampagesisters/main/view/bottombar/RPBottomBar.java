package com.jiandougang.rampagesisters.main.view.bottombar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import com.jiandougang.rampagesisters.R;

import java.util.ArrayList;


/**
 * 底部标题栏
 * Created by YoKeyword on 16/6/3.
 */
public class RPBottomBar extends LinearLayout {
    private static final int TRANSLATE_DURATION_MILLIS = 200;

    private final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private boolean mVisible = true;
    private LinearLayout mTabLayout;

    private LayoutParams mTabParams;
    private int mCurrentPosition = 0;

    /**
     * 传入的资源数组
     */
    private ArrayList<Integer> rpBottomBarImageArray = new ArrayList<>();
    private ArrayList<String> rpBottomBarTextArray = new ArrayList<>();
    private OnTabSelectedListener mListener;

    public RPBottomBar(Context context) {
        this(context, null);
    }

    public RPBottomBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RPBottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initTypeArray(context, attrs, defStyleAttr);

        initView(context);
    }

    /**
     * 根据一级TypedArray获取二级TypedArray资源并添加到资源队列中
     *
     * @param typedArray    一级TypedArray
     * @param attr          一级资源id属性
     * @param defaultResId  二级默认资源id
     * @param resourceArray 存储数组
     */
    private void addResourceArray(TypedArray typedArray, int attr, int defaultResId, ArrayList resourceArray) {
        int srcArrayId = typedArray.getResourceId(attr, defaultResId);
        TypedArray srcArray = getResources().obtainTypedArray(srcArrayId);
        int srcCount = srcArray.getIndexCount();
        for (int j = 0; j < srcCount; j++) {
            resourceArray.add(srcArray.getResourceId(j, 0));

        }
        srcArray.recycle();
    }

    private void initView(Context context) {
        setOrientation(VERTICAL);

        mTabLayout = new LinearLayout(context);
        mTabLayout.setBackgroundColor(Color.WHITE);
        mTabLayout.setOrientation(LinearLayout.HORIZONTAL);
        addView(mTabLayout, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        mTabParams = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        mTabParams.weight = 1;

        if (rpBottomBarImageArray.size() == rpBottomBarTextArray.size()) {

            int count = rpBottomBarImageArray.size();
            for (int i = 0; i < count; i++) {
                addItem(new BottomBarTab(getContext(), rpBottomBarImageArray.get(i), rpBottomBarTextArray.get(i)));
            }

        } else {

            throw new IllegalArgumentException("image count must equal to text count");
        }
    }

    private void initTypeArray(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RPBottomBar, defStyleAttr, 0);
        int typeCount = typedArray.getIndexCount();

        //获取attr文件下,declare-styleable属性
        for (int i = 0; i < typeCount; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.RPBottomBar_srcArray:

                    int srcArrayId = typedArray.getResourceId(attr, R.array.RPBottomBarImageArray);
                    String srcArray[] = getResources().getStringArray(srcArrayId);
                    int srcArrayCount = srcArray.length;

                    for (int j = 0; j < srcArrayCount; j++) {
                        Resources res = getResources();
                        String resPathArray[] = srcArray[j].split("/");
                        //带后缀名的图片名称
                        String imageWithSuffix = resPathArray[resPathArray.length - 1];
                        String imageNameArray[] = imageWithSuffix.split("\\.");
                        //不带后缀名的图片名称
                        String imageName = imageNameArray[0];
                        //获取drawable下的图片资源id
                        int resId = res.getIdentifier(imageName, "drawable", context.getPackageName());
                        rpBottomBarImageArray.add(resId);

                    }

                    break;

                case R.styleable.RPBottomBar_textArray:

                    int textArrayId = typedArray.getResourceId(attr, R.array.RPBottomBarTextArray);
                    String textArray[] = getResources().getStringArray(textArrayId);
                    int textCount = textArray.length;
                    for (int j = 0; j < textCount; j++) {

                        rpBottomBarTextArray.add(textArray[j]);
                    }

                    break;
            }

        }
        typedArray.recycle();
    }

    /**
     * 添加Tab控件
     *
     * @param tab BottomBarTab
     * @return this
     */
    public RPBottomBar addItem(final BottomBarTab tab) {
        tab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener == null) return;

                int pos = tab.getTabPosition();
                if (mCurrentPosition == pos) {
                    mListener.onTabReselected(pos);
                } else {
                    mListener.onTabSelected(pos, mCurrentPosition);
                    tab.setSelected(true);
                    mListener.onTabUnselected(mCurrentPosition);
                    mTabLayout.getChildAt(mCurrentPosition).setSelected(false);
                    mCurrentPosition = pos;
                }
            }
        });
        tab.setTabPosition(mTabLayout.getChildCount());
        tab.setLayoutParams(mTabParams);
        mTabLayout.addView(tab);
        return this;
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        mListener = onTabSelectedListener;
    }

    public void setCurrentItem(final int position) {
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                mTabLayout.getChildAt(position).performClick();
            }
        });
    }

    public int getCurrentItemPosition() {
        return mCurrentPosition;
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        return new SavedState(superState, mCurrentPosition);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        if (mCurrentPosition != ss.position) {
            mTabLayout.getChildAt(mCurrentPosition).setSelected(false);
            mTabLayout.getChildAt(ss.position).setSelected(true);
        }
        mCurrentPosition = ss.position;
    }

    public void hide() {
        hide(true);
    }

    public void show() {
        show(true);
    }

    public void hide(boolean anim) {
        toggle(false, anim, false);
    }

    public void show(boolean anim) {
        toggle(true, anim, false);
    }

    public boolean isVisible() {
        return mVisible;
    }

    private void toggle(final boolean visible, final boolean animate, boolean force) {
        if (mVisible != visible || force) {
            mVisible = visible;
            int height = getHeight();
            if (height == 0 && !force) {
                ViewTreeObserver vto = getViewTreeObserver();
                if (vto.isAlive()) {
                    // view树完成测量并且分配空间而绘制过程还没有开始的时候播放动画。
                    vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        @Override
                        public boolean onPreDraw() {
                            ViewTreeObserver currentVto = getViewTreeObserver();
                            if (currentVto.isAlive()) {
                                currentVto.removeOnPreDrawListener(this);
                            }
                            toggle(visible, animate, true);
                            return true;
                        }
                    });
                    return;
                }
            }
            int translationY = visible ? 0 : height;
            if (animate) {
                animate().setInterpolator(mInterpolator)
                        .setDuration(TRANSLATE_DURATION_MILLIS)
                        .translationY(translationY);
            } else {
                ViewCompat.setTranslationY(this, translationY);
            }
        }
    }

    public interface OnTabSelectedListener {
        void onTabSelected(int position, int prePosition);

        void onTabUnselected(int position);

        void onTabReselected(int position);
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        private int position;

        public SavedState(Parcel source) {
            super(source);
            position = source.readInt();
        }

        public SavedState(Parcelable superState, int position) {
            super(superState);
            this.position = position;
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(position);
        }
    }
}
