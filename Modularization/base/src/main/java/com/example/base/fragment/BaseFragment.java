package com.example.base.fragment;

import androidx.fragment.app.Fragment;

import com.example.base.event.CarOrder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public abstract class BaseFragment extends Fragment {

    public void onDestroyView() {

        super.onDestroyView();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

}
