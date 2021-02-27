package com.kymjs.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.arouter.ARouterParam;
import com.example.base.arouter.ARouterPath;
import com.example.base.util.Utils;

@Route(path = ARouterPath.ACTIIVTY_LOGIN)
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.bt_login);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterPath.ACTIVITY_REGISTER).navigation(LoginActivity.this, ARouterParam.REGISTER_RESULT_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ARouterParam.REGISTER_RESULT_CODE:
                Utils.toast(this, "receive=" + data.getStringExtra(ARouterParam.REGISTER_RESULT_KEY));
                break;
            default:
                break;
        }
    }
}
