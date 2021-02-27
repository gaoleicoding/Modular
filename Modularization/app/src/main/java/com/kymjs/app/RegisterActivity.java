package com.kymjs.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.arouter.ARouterParam;
import com.example.base.arouter.ARouterPath;

@Route(path = ARouterPath.ACTIVITY_REGISTER)
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button button = (Button) findViewById(R.id.bt_register);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(ARouterParam.REGISTER_RESULT_KEY, "注册成功！");
                setResult(ARouterParam.REGISTER_RESULT_CODE, intent);
                finish();
            }
        });
    }
}
