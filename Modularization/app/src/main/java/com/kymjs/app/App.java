package com.kymjs.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouter(this);

    }

    private void initRouter(App myApplication) {

        ARouter.init(myApplication);

    }
}
