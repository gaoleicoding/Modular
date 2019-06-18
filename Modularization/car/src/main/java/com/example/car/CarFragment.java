package com.example.car;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.arouter.ARouterPath;
import com.example.base.arouter.CarService;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.FRAGMENT_CAR)
public class CarFragment extends Fragment {

    @Autowired(name = ARouterPath.BASE_CAR_SERVICE)
    CarService carService;
    List<String> carList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ARouter.getInstance().inject(this);
        carList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            carList.add("车辆"+i);
        }
        carService.setCarList(carList);

        return View.inflate(getActivity(), R.layout.fragment_car, null);

    }
}
