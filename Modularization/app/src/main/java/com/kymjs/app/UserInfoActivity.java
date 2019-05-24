package com.kymjs.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.arouter.ArouterConfig;
import com.example.base.arouter.ARouterPath;

@Route(path = ARouterPath.ACTIIVTY_USERINFO, extras = ArouterConfig.NEED_LOGIN)
public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

    }
}
