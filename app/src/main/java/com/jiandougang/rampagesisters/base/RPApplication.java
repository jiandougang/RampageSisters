package com.jiandougang.rampagesisters.base;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;

/**
 *
 * Created by wuguohong on 16/8/26.
 */
public class RPApplication extends Application {

    private final String LeadCloudAppId = "f9KC0p8lnpO7yTtUqVKrKB7b-gzGzoHsz";
    private final String LeadCloudAppKey = "CV2im2ncUqcIdnzX9IhfKeSc";

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        AVOSCloud.initialize(this, LeadCloudAppId, LeadCloudAppKey);

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
