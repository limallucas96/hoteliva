package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderMenuFragment;

public class OrderMenuFragmentPresenter extends BasePresenter {

    private final OrderMenuFragment mView;

    public OrderMenuFragmentPresenter(OrderMenuFragment view){
        this.mView = view;
    }

}
