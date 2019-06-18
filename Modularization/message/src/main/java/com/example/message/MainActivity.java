package com.example.message;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.base.util.FragmentUtils;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentUtils.addFragment(this, new MessageFragment(), R.id.fl_container);

    }
}
