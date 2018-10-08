package com.example.lucas.deliva.presentation.cart.presenter;

import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.cart.view.CartActivity;

public class CartActivityPresenter extends BasePresenter {

    private final CartActivity mView;

    public CartActivityPresenter(CartActivity view){
        this.mView = view;
    }
}
