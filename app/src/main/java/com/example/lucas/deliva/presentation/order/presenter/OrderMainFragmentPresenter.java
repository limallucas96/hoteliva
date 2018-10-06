package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderMainFragment;

public class OrderMainFragmentPresenter  extends BasePresenter {

    private final OrderMainFragment mView;

    public OrderMainFragmentPresenter(OrderMainFragment view) {
        mView = view;
    }
}
