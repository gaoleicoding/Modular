package com.example.car;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.arouter.ARouterPath;
import com.example.base.event.StickyToast;
import com.example.base.fragment.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.FRAGMENT_CAR)
public class CarFragment extends BaseFragment {

    List<String> carList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ARouter.getInstance().inject(this);
        carList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            carList.add("车辆" + i);
        }
        CarManager.getInstance().setCarList(carList);
        View view = View.inflate(getActivity(), R.layout.fragment_car, null);

        view.findViewById(R.id.tv_car).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!EventBus.getDefault().isRegistered(CarFragment.this)) {
                    EventBus.getDefault().register(CarFragment.this);
                }
            }
        });
        return view;

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(StickyToast stickyToast) {
        Toast.makeText(getActivity(), stickyToast.toast, Toast.LENGTH_SHORT).show();
    }
}
