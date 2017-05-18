package com.jiandougang.rampagesisters.main.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseActivity;
import com.jiandougang.rampagesisters.main.adapter.ImageScaleAdapter;
import com.jiandougang.rampagesisters.main.model.EvaluationListBean;
import com.jiandougang.rampagesisters.main.view.photoview.HackyViewPager;
import com.jiandougang.rampagesisters.main.view.photoview.PhotoView;
import com.jiandougang.rampagesisters.main.view.recycleView.util.CommonUtils;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewTreeObserver.OnPreDrawListener;

/**
 * 朋友圈查看大图activity
 * Created by wuguohong on 16/10/11.
 */

public class RPSeeBigPictureActivity extends RPBaseActivity implements OnPreDrawListener {

    public static String PIC_DATA_LIST = "PIC_DATA_LIST";
    public static String CURRENT_ITEM = "CURRENT_ITEM";
    public int mPosition;
    private ArrayList<EvaluationListBean.EvaluationPicBean> picDataList;
    private HackyViewPager viewPager;
    private LinearLayout llDots;
    private RelativeLayout rlRoot;
    private List<View> dotList = new ArrayList<>();
    private ImageScaleAdapter imageScaleAdapter;
    private int currentItem;
    private int height;
    private int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_big_picture);

        initData();
        initView();
        initEvent();
    }

    private void initData() {
        Intent intent = getIntent();
        picDataList = (ArrayList<EvaluationListBean.EvaluationPicBean>) intent.getSerializableExtra(PIC_DATA_LIST);
        currentItem = intent.getIntExtra(CURRENT_ITEM, 0);
        mPosition = currentItem;
        imageScaleAdapter = new ImageScaleAdapter(this, picDataList);

    }

    private void initView() {
        viewPager = (HackyViewPager) findViewById(R.id.hvp_pic);
        viewPager.setAdapter(imageScaleAdapter);
        viewPager.setCurrentItem(currentItem);
        rlRoot = (RelativeLayout) findViewById(R.id.rl_root);
        llDots = (LinearLayout) findViewById(R.id.ll_dots);
        initDot(currentItem);
    }

    private void initEvent() {
        setPagerChangeListener(viewPager);
        viewPager.getViewTreeObserver().addOnPreDrawListener(this);

    }

    /**
     * 初始化轮播图点
     */
    private void initDot(int index) {
        // 清空点所在集合
        dotList.clear();
        llDots.removeAllViews();
        for (int i = 0; i < picDataList.size(); i++) {
            ImageView view = new ImageView(this);
            if (i == index || picDataList.size() == 1) {
                view.setBackgroundResource(R.mipmap.type_selected);
            } else {
                view.setBackgroundResource(R.mipmap.type_normal);
            }
            // 指定点的大小
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    CommonUtils.dip2px(this, 5), CommonUtils.dip2px(this, 5));
            // 指定点的间距
            layoutParams.setMargins(CommonUtils.dip2px(this, 2), 0, CommonUtils.dip2px(this, 2), 0);
            // 添加到线性布局中
            llDots.addView(view, layoutParams);
            // 添加到集合中去
            dotList.add(view);
        }
    }

    /**
     * 页面改动监听
     *
     * @param viewPager
     */
    private void setPagerChangeListener(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPosition = position;
                initDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onPreDraw() {

        Log.i("123aaa", "有没有到这里来啊onPreDraw");
        viewPager.getViewTreeObserver().removeOnPreDrawListener(this);
        final View view = imageScaleAdapter.getPrimaryItem();
        final PhotoView imageView = (PhotoView)((FrameLayout) view).getChildAt(0);

//        computeImageWidthAndHeight(imageView);

        final EvaluationListBean.EvaluationPicBean evaluationPicBean = picDataList.get(mPosition);
//        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1.0f);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAndimationUpdate(ValueAnimator animation) {
//
//                float animatedFraction = animation.getAnimatedFraction();
//
//                view.setTranslationX(EvaluateUtil.evaluateInt(animatedFraction, evaluationPicBean.x + evaluationPicBean.width / 2 - imageView.getWidth() / 2, 0));
//                view.setTranslationY(EvaluateUtil.evaluateInt(animatedFraction, evaluationPicBean.y + evaluationPicBean.height / 2 - imageView.getHeight() / 2, 0));
//                view.setScaleX(EvaluateUtil.evaluateFloat(animatedFraction, vx, 1));
//                view.setScaleY(EvaluateUtil.evaluateFloat(animatedFraction, vy, 1));
//                rlRoot.setBackgroundColor((int) EvaluateUtil.evaluateArgb(animatedFraction, 0x0, 0xff000000));
//            }
//        });
//
//
//        addIntoListener(valueAnimator);
//        valueAnimator.setDuration(300);
//        valueAnimator.start();


        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationY", imageView.getHeight() / 2, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 0.8f, 1),
                ObjectAnimator.ofFloat(view, "scaleY", 0.8f, 1),
                ObjectAnimator.ofInt(this, "backgroundColor", 0x0, 0xff000000)
        );
        set.setDuration(300);
        set.start();

        return false;
    }

    /**
     * 进场动画过程监听
     *
     * @param valueAnimator
     */
    private void addIntoListener(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                rlRoot.setBackgroundColor(0x0);
//                rl_title.setVisibility(View.INVISIBLE);
//                ll_bottom_all.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

//                rl_title.setVisibility(View.VISIBLE);
//                ll_bottom_all.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    /**
     * 计算图片的宽高
     *
     * @param imageView
     */
    private void computeImageWidthAndHeight(PhotoView imageView) {

        //获取真实大小
        Drawable drawable = imageView.getDrawable();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        //计算出与屏幕的比例，用于比较以宽的比例为准还是高的比例为准，因为很多时候不是高度没充满，就是宽度没充满
        float hScale = CommonUtils.getScreenSizeHeight(this) * 1.0f / intrinsicHeight;
        float wScale = CommonUtils.getScreenSizeWidth(this) * 1.0f / intrinsicWidth;
        if (hScale > wScale) {
            hScale = wScale;
        } else {
            wScale = hScale;
        }
        //得出当宽高至少有一个充满的时候图片对应的宽高
        height = (int) (intrinsicHeight * hScale);
        width = (int) (intrinsicWidth * wScale);
    }
}
