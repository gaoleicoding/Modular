package com.kymjs.app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.car.CarFragment;
import com.example.me.MeFragment;
import com.example.message.MessageFragment;
import com.example.order.OrderFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> mFragments;
    private ArrayList<String> titles;
  ViewPager viewPager;
  TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);

        mFragments = new ArrayList<Fragment>();
        // 获取Fragment
        CarFragment carFragment = new CarFragment();
        MessageFragment messageFragment = new MessageFragment();
        OrderFragment orderFragment = new OrderFragment();
        MeFragment meFragment = new MeFragment();
        mFragments.add(carFragment);
        mFragments.add(messageFragment);
        mFragments.add(orderFragment);
        mFragments.add(meFragment);
        titles = new ArrayList<String>();
        titles.add(getString(R.string.cars));
        titles.add(getString(R.string.message));
        titles.add(getString(R.string.order));
        titles.add(getString(R.string.me ));

        MainTabAdapter adapter = new MainTabAdapter(getSupportFragmentManager(), mFragments);
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        //将TabLayout和ViewPager关联起来
        tabLayout.setupWithViewPager(viewPager);
        initTab();
    }
    /**
     * 设置添加Tab
     */
    private void initTab() {

        tabLayout.getTabAt(0).setCustomView(R.layout.tab_cars);
        tabLayout.getTabAt(1).setCustomView(R.layout.tab_message);
        tabLayout.getTabAt(2).setCustomView(R.layout.tab_order);
        tabLayout.getTabAt(3).setCustomView(R.layout.tab_me);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //标签选中之后执行的方法
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
            }

            //标签没选中
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
