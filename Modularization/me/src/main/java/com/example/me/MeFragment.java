package com.example.me;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.base.arouter.ARouterParam;
import com.example.base.arouter.ARouterPath;
import com.example.base.arouter.interceptor.LoginNavigationCallbackImpl;


@Route(path = ARouterPath.FRAGMENT_ME)
public class MeFragment extends Fragment implements View.OnClickListener {

    Button btnLogin;
    Button btnNoNeedLogin;
    Button btnNeedLogin;
    Button btnExit;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ARouter.getInstance().inject(this);
        View view = View.inflate(getActivity(), R.layout.fragment_me, null);

        btnLogin = view.findViewById(R.id.btn_login);
        btnNoNeedLogin = view.findViewById(R.id.btn_no_need_login);
        btnNeedLogin = view.findViewById(R.id.btn_need_login);
        btnExit = view.findViewById(R.id.btn_exit);
        btnLogin.setOnClickListener(this);
        btnNoNeedLogin.setOnClickListener(this);
        btnNeedLogin.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        return view;
    }

    public void sikp() {
        // 未登录
//        ARouter.getInstance().build(ARouterPath.ACTIIVTY_USERINFO).withTransition(R.anim.slide_in_right, R.anim.slide_out_right).navigation(getActivity());
//        // 已登录
        Person person = new Person("小明", "20");
        ARouter.getInstance().build(ARouterPath.ACTIIVTY_USERINFO).greenChannel()
                .withInt(ARouterParam.LOGIN_PARAM_AGE, 32)
                .withString(ARouterParam.LOGIN_PARAM_NAME, "gaolei")
                .withObject(ARouterParam.LOGIN_PARAM_KEY, person)
                .withTransition(R.anim.slide_in_right, R.anim.slide_out_right).navigation();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_login) {
            ARouter.getInstance().build(ARouterPath.ACTIIVTY_LOGIN)
                    .navigation();
        } else if (id == R.id.btn_no_need_login) {
            // 不需要登录的
            Person person = new Person("小明", "20");
            ARouter.getInstance().build(ARouterPath.ACTIIVTY_NO_NEED_LOGIN)
                    .withString("msg", "ARouter传递过来的不需要登录的参数msg")
                    .navigation();
        } else if (id == R.id.btn_need_login) {
            // 需要登录的
            ARouter.getInstance().build(ARouterPath.ACTIIVTY_NEED_LOGIN)
                    .withString("msg", "ARouter传递过来的需要登录的参数msg")
                    .navigation(getActivity(), new LoginNavigationCallbackImpl());
        } else if (id == R.id.btn_exit) {
            // 退出登录
            ToastUtils.showShort("退出登录成功");
            SPUtils.getInstance().remove(ARouterPath.SP_IS_LOGIN);
        }
    }
}
