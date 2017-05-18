package com.jiandougang.rampagesisters.utils;

import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by wuguohong on 2016/12/9.
 */

public class FrescoUtils {

    /**
     * 显示缩略图
     *
     * @param draweeView     draweeView
     * @param url            url
     * @param resizeWidthDp  resizeWidth
     * @param resizeHeightDp resizeHeight
     */
    public static void showThumb(SimpleDraweeView draweeView, Uri uri, float resizeWidthDp, float resizeHeightDp) {
        if (uri == null)
            return;
        if (draweeView == null)
            return;
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setResizeOptions(new ResizeOptions((int) DensityUtil.dip2px(draweeView.getContext(), resizeWidthDp), (int) DensityUtil.dip2px(draweeView.getContext(), resizeHeightDp)))
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(draweeView.getController())
                .setControllerListener(new BaseControllerListener<ImageInfo>())
                .build();
        draweeView.setController(controller);
    }
}
