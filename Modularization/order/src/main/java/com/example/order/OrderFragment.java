package com.example.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.arouter.ARouterPath;
import com.example.base.arouter.CarService;
import com.example.base.event.CarOrder;
import com.example.base.event.StickyToast;
import com.example.base.fragment.BaseFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


@Route(path = ARouterPath.FRAGMENT_ORDER)
public class OrderFragment extends BaseFragment {

    @Autowired(name = ARouterPath.BASE_CAR_SERVICE)
    CarService carService;
    int index = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ARouter.getInstance().inject(this);
        View view = View.inflate(getActivity(), R.layout.fragment_order, null);

//        final List<String> list = carService.getCarList();
//        view.findViewById(R.id.tv_order).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (index > list.size() - 1) {
//                    Toast.makeText(getActivity(), "下单失败，车辆已被预定完", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                Toast.makeText(getActivity(), String.format("第%d辆车下单成功", index), Toast.LENGTH_SHORT).show();
//                EventBus.getDefault().post(new CarOrder(index));
//                EventBus.getDefault().postSticky(new StickyToast("粘性事件test"));
//                index++;
//            }
//        });

        return view;
    }
}
