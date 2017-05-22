package com.jiandougang.rampagesisters.base;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.squareup.leakcanary.LeakCanary;

import me.yokeyword.fragmentation.Fragmentation;

/**
 * Created by wuguohong on 16/8/26.
 */
public class RPApplication extends Application {

    private static Context applicationContext;
    private final String LeadCloudAppId = "f9KC0p8lnpO7yTtUqVKrKB7b-gzGzoHsz";
    private final String LeadCloudAppKey = "CV2im2ncUqcIdnzX9IhfKeSc";

    @Override
    public void onCreate() {
        super.onCreate();

        applicationContext = getApplicationContext();

        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true).setDownsampleEnabled(true)
                .build();

        Fresco.initialize(this, config);

        AVOSCloud.initialize(this, LeadCloudAppId, LeadCloudAppKey);

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        // 栈视图功能，大大降低Fragment的开发难度，建议在Application里初始化
        Fragmentation.builder()
                // 显示悬浮球 ; 其他Mode:SHAKE: 摇一摇唤出   NONE：隐藏
                .stackViewMode(Fragmentation.BUBBLE)
                .install();
    }

    public static Context getApplication(){
        return applicationContext;
    }
}
