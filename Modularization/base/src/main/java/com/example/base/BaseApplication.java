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
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
//        if (BuildConfig.DEBUG) {
//            //打印日志
//            ARouter.openLog();
//            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
//            //线上版本需要关闭,否则有安全风险)
//            ARouter.openDebug();
//        }
        ARouter.init(myApplication);

    }
}
