package com.kymjs.app;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouter(this);
        MultiDex.install(this);
    }

    private void initRouter(App myApplication) {

        ARouter.init(myApplication);

    }
}
