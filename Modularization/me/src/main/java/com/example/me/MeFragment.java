package com.example.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.arouter.ArouterConfig;
import com.example.base.arouter.RouterPath;


@Route(path = RouterPath.FRAGMENT_ME)
public class MeFragment extends Fragment {

    Button bt_skip;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = View.inflate(getActivity(), R.layout.fragment_me, null);
        bt_skip = view.findViewById(R.id.bt_skip);
        bt_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sikp();
            }
        });
        return view;
    }

    public void sikp() {
        ARouter.getInstance().build(RouterPath.ACTIIVTY_USERINFO).navigation();
    }
}
