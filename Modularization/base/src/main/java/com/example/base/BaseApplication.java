package com.example.base;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;


public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouter(this);
        MultiDex.install(this);
    }

    private void initRouter(BaseApplication myApplication) {

        ARouter.init(myApplication);

    }
}
