package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderProfileFragment;

public class OrderProfileFragmentPresenter extends BasePresenter {

    private OrderProfileFragment mView;

    public OrderProfileFragmentPresenter(OrderProfileFragment view) {
        this.mView = view;
    }
}
