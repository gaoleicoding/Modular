package com.example.base.arouter;


import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.List;
@Route(path = ARouterPath.BASE_CAR_SERVICE)
public class CarServiceImpl implements CarService {

    List<String> carList;

    @Override
    public List<String> getCarList() {
        return carList;
    }

    @Override
    public void setCarList(List<String> list) {
        carList = list;
    }

    @Override
    public void init(Context context) {

    }
}