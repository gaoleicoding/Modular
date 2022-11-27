package com.example.base.arouter;

import com.alibaba.android.arouter.facade.template.IProvider;

import java.util.List;

public interface CarService extends IProvider {

    List<String> getCarList();

    void setCarList(List<String> list);

}