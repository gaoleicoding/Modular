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
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(myApplication);

    }
}
