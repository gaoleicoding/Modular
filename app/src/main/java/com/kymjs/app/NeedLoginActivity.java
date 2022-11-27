package com.kymjs.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.arouter.ARouterParam;
import com.example.base.arouter.ARouterPath;
import com.example.me.Person;

@Route(path = ARouterPath.ACTIIVTY_NEED_LOGIN)
public class NeedLoginActivity extends AppCompatActivity {
    @Autowired
    public String msg;
    @Autowired(name = ARouterParam.LOGIN_PARAM_KEY)
    Person person;

    TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_need_login);
        tvUser = findViewById(R.id.tv_user);
        StringBuilder stringBuffer = new StringBuilder();

        stringBuffer.append("msg：").append(msg + "\n");
        if (person != null) {
            stringBuffer.append("person：").append(person.age + "、").append(person.name);
        }
        tvUser.setText(stringBuffer.toString());
    }
}
