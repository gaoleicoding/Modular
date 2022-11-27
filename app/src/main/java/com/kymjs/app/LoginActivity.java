package com.kymjs.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.base.arouter.ARouterParam;
import com.example.base.arouter.ARouterPath;
import com.example.base.util.Utils;
import com.example.me.Person;

@Route(path = ARouterPath.ACTIIVTY_LOGIN)
public class LoginActivity extends AppCompatActivity {

    @Autowired
    public String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtils.getInstance().put(ARouterPath.SP_IS_LOGIN, true);

                ToastUtils.showShort("登录成功");
                //登录成功，并跳转到相应Activity
                if (!StringUtils.isEmpty(path)) {
                    Person person = new Person("小明", "20");
                    ARouter.getInstance().build(path)
                            .with(getIntent().getExtras())
                            .withObject(ARouterParam.LOGIN_PARAM_KEY, person)
                            .navigation();
                }
                finish();
            }
        });

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterPath.ACTIVITY_REGISTER).navigation(LoginActivity.this, ARouterParam.REGISTER_RESULT_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ARouterParam.REGISTER_RESULT_CODE) {
            Utils.toast(this, "receive=" + data.getStringExtra(ARouterParam.REGISTER_RESULT_KEY));
        }
    }

}
