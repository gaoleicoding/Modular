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

@Route(path = ARouterPath.ACTIIVTY_NO_NEED_LOGIN)
public class NoNeedLoginActivity extends AppCompatActivity {
    @Autowired
    public String msg;

    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_no_need_login);
        tvMsg = findViewById(R.id.tv_msg);
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("msg：").append(msg + "\n");
        tvMsg.setText(msg);

    }
}
