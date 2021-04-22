package com.example.base.arouter.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.example.base.arouter.ARouterPath;

// 在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
// 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
// priority是拦截器的优先级，值越小优先级越高，会优先拦截。
@Interceptor(priority = 6)
public class LoginInterceptorImpl implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();
        LogUtils.w(path);
        boolean isLogin = SPUtils.getInstance().getBoolean(ARouterPath.SP_IS_LOGIN, false);

        if (isLogin) { // 如果已经登录不拦截
            callback.onContinue(postcard);
        } else {
            // 如果没有登录
            // 需要登录的直接拦截下来
            if (ARouterPath.ACTIIVTY_NEED_LOGIN.equals(path)) {
                callback.onInterrupt(null);
            } else {
                // 不需要登录的直接进入这个页面
                callback.onContinue(postcard);
            }
        }

    }

    @Override
    public void init(Context context) {
        //此方法只会走一次
        LogUtils.w("路由登录拦截器初始化成功");
    }

}
