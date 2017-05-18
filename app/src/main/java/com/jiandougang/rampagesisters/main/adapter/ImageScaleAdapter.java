package com.jiandougang.rampagesisters.main.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.main.model.EvaluationListBean;
import com.jiandougang.rampagesisters.main.view.photoview.PhotoView;
import com.jiandougang.rampagesisters.main.view.photoview.PhotoViewAttacher;
import com.jiandougang.rampagesisters.utils.ImageUrlUtils;

import java.util.List;


public class ImageScaleAdapter extends PagerAdapter implements PhotoViewAttacher.OnPhotoTapListener {
    private List<EvaluationListBean.EvaluationPicBean> mPicData;
    private Context mContext;

    private PhotoView imageView;
    private View mCurrentView;
    private static final String[] sDrawables = ImageUrlUtils.getImageUrls();


    public ImageScaleAdapter(Context mContext, List<EvaluationListBean.EvaluationPicBean> data) {
        super();
        this.mPicData = data;
        this.mContext = mContext;

    }

    @Override
    public int getCount() {
        if (mPicData != null) {
            return mPicData.size();
        } else {
            return 0;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //动态加载在setPrimaryItem中实现，
    //每次滑动都会调用setPrimaryItem，
    //所以在这里可以进行网络加载，
    //这里我loadTag判断是否需要重复加载
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        mCurrentView = (View) object;
    }

    public View getPrimaryItem() {
        return mCurrentView;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_photoview, container, false);

        PhotoView photoView = (PhotoView) view.findViewById(R.id.pv_picture);
        photoView.setImageUri(sDrawables[position]);

        container.addView(view);
        return view;
    }


    /**
     * 显示进度条
     *
     * @param pb
     */
    private void startLoad(ProgressBar pb) {
        pb.setVisibility(View.VISIBLE);
    }

    /**
     * 结束进度条
     *
     * @param pb
     */
    private void overLoad(ProgressBar pb) {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//		super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Override
    public void onPhotoTap(View view, float x, float y) {

    }
}
