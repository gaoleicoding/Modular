package com.kymjs.app;

import android.app.Application;

import com.kymjs.common.App;
import com.kymjs.common.LogUtils;
import com.kymjs.crash.CustomActivityOnCrash;

/**
 * Created by ZhangTao on 10/12/16.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.mLogEnable = BuildConfig.DEBUG;
        CustomActivityOnCrash.install(com.kymjs.common.App.INSTANCE);
    }
}
