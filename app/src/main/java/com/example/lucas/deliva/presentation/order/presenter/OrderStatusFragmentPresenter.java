package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderStatusFragment;

public class OrderStatusFragmentPresenter extends BasePresenter {

    private final OrderStatusFragment mView;

    public OrderStatusFragmentPresenter(OrderStatusFragment view) {
        mView = view;
    }
}
