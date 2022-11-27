package com.example.car;

import java.util.List;

class CarManager {

    private CarManager() {
    }

    private static class InstanceHolder {
        private static final CarManager instance = new CarManager();
    }

    public static CarManager getInstance() {
        return InstanceHolder.instance;
    }

    List<String> carList;

    public List<String> getCarList() {
        return carList;
    }

    public void setCarList(List<String> carList) {
        this.carList = carList;
    }
}
