package com.example.lucas.deliva.presentation.cart.presenter;

import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.data.model.mock.Order;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.cart.view.CartActivity;

public class CartActivityPresenter extends BasePresenter {

    private final CartActivity mView;
    private final SessionBO mSessionBO;

    public CartActivityPresenter(CartActivity view) {
        this.mView = view;
        this.mSessionBO = new SessionBO();
    }

    public Order getOrder() {
        return mSessionBO.getOrder();
    }

    public void saveOrder(Order order) {
        mSessionBO.setOrderOnGoing(order);
    }
}
