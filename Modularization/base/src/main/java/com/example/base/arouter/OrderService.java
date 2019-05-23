package com.example.base.arouter;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface OrderService extends IProvider {
    void orderNotify(String name);
}