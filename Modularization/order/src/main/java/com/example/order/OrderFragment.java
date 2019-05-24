package com.example.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.arouter.OrderService;
import com.example.base.arouter.ARouterPath;


@Route(path = ARouterPath.FRAGMENT_ORDER)
public class OrderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view= View.inflate(getActivity(), R.layout.fragment_order, null);
        view.findViewById(R.id.tv_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"下单成功",Toast.LENGTH_SHORT).show();
                OrderService orderService=(OrderService)ARouter.getInstance().build(ARouterPath.FRAGMENT_MESSAGE).navigation();
                orderService.orderNotify("");
            }
        });

        return view;
    }
}
