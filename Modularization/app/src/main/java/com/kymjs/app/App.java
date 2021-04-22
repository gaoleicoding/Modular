package com.kymjs.app;

import android.app.Application;

import androidx.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.BuildConfig;

import org.greenrobot.eventbus.EventBus;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouter(this);
        MultiDex.install(this);
        EventBus.builder().addIndex(new EventBusIndex_message()).installDefaultEventBus();

    }

    private void initRouter(App myApplication) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
            //线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        ARouter.init(myApplication);

    }
}
