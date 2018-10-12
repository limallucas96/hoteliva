package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.data.model.mock.Order;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderMenuFragment;

public class OrderMenuFragmentPresenter extends BasePresenter {

    private final OrderMenuFragment mView;
    private final SessionBO mSessionBO;

    public OrderMenuFragmentPresenter(OrderMenuFragment view) {
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
