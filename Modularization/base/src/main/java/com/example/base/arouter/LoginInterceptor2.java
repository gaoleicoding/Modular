package com.example.base.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;

/*
priority是拦截器的优先级，值越小优先级越高，会优先拦截
*/
@Interceptor(priority = 2)
public class LoginInterceptor2 implements IInterceptor {

    private static final String TAG = "LoginInterceptor";

    private Context mContext;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        boolean isLogin = false;
        Log.i(TAG, "LoginInterceptor2 开始执行");

        //给需要跳转的页面添加值为Constant.LOGIN_NEEDED的extra参数，用来标记是否需要用户先登录才可以访问该页面
        //先判断需不需要
        if (postcard.getExtra() == ArouterConfig.NEED_LOGIN) {
            //if(postcard.getPath().equals(ARouterPath.ACTIIVTY_USERINFO))


            //判断用户的登录情况，可以把值保存在sp中
            if (isLogin) {
                callback.onContinue(postcard);
            } else {//没有登录,注意需要传入context
                ARouter.getInstance().build(ARouterPath.ACTIIVTY_LOGIN).navigation(mContext);
            }
        } else {//没有extra参数时则继续执行，不做拦截
            callback.onContinue(postcard);
        }

//        callback.onInterrupt(null);

    }

    @Override
    public void init(Context context) {

        mContext = context;

        Log.i(TAG, "LoginInterceptor 初始化");

    }
}