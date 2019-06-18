package com.kymjs.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.arouter.ARouterParam;
import com.example.base.arouter.ArouterConfig;
import com.example.base.arouter.ARouterPath;

@Route(path = ARouterPath.ACTIIVTY_USERINFO, extras = ArouterConfig.NEED_LOGIN)
public class UserInfoActivity extends AppCompatActivity {
    @Autowired(name = ARouterParam.LOGIN_PARAM_AGE)
    int age = 0;
    @Autowired(name = ARouterParam.LOGIN_PARAM_NAME)
    String name;

    TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_userinfo);
        tvUser = findViewById(R.id.tv_user);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("个人信息：").append(name + "、").append(age);
        tvUser.setText(stringBuffer.toString());
    }
}
