package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrdersFragment;

public class OrdersFragmentPresenter extends BasePresenter {

    private final OrdersFragment mView;

    public OrdersFragmentPresenter(OrdersFragment view) {
        mView = view;
    }

}
