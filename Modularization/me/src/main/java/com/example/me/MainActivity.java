package com.example.me;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.base.util.FragmentUtils;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentUtils.addFragment(this, new MeFragment(), R.id.fl_container);

    }
}
