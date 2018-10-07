package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderDetailsActivity;

public class OrderDetailsActivityPresenter extends BasePresenter {

    private final OrderDetailsActivity mView;

    public OrderDetailsActivityPresenter(OrderDetailsActivity view) {
        this.mView = view;
    }
}
