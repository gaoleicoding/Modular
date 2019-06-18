package com.example.me;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.arouter.ARouterParam;
import com.example.base.arouter.ARouterPath;


@Route(path = ARouterPath.FRAGMENT_ME)
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
        //     ARouter.getInstance().build(ARouterPath.ACTIIVTY_USERINFO).withTransition(R.anim.slide_in_right, R.anim.slide_out_right).navigation(getActivity());
        ARouter.getInstance().build(ARouterPath.ACTIIVTY_USERINFO).greenChannel()
                .withInt(ARouterParam.LOGIN_PARAM_AGE, 32)
                .withString(ARouterParam.LOGIN_PARAM_NAME, "gaolei")
                .withTransition(R.anim.slide_in_right, R.anim.slide_out_right).navigation();
    }
}
