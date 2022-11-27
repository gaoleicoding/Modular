package com.example.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.arouter.ARouterPath;
import com.example.base.event.CarOrder;
import com.example.base.fragment.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Route(path = ARouterPath.FRAGMENT_MESSAGE)
public class MessageFragment extends BaseFragment {

    private TextView tvMessage;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        EventBus.getDefault().register(this);
        View view = View.inflate(getActivity(), R.layout.fragment_message, null);
        tvMessage = view.findViewById(R.id.tv_message);
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CarOrder carOrder) {
        tvMessage.setText(String.format("第%d辆车被预订", carOrder.id) + "\n");
    }

}
