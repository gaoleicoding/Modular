package com.example.car;


import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.arouter.ARouterPath;
import com.example.base.arouter.CarService;

import java.util.List;
@Route(path = ARouterPath.BASE_CAR_SERVICE)
public class CarServiceImpl implements CarService {

    List<String> carList;

    @Override
    public List<String> getCarList() {
        return CarManager.getInstance().getCarList();
    }

    @Override
    public void setCarList(List<String> list) {
        carList = list;
    }

    @Override
    public void init(Context context) {

    }
}