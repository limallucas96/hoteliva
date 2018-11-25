package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.data.model.Order;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderDetailsActivity;

public class OrderDetailsActivityPresenter extends BasePresenter {

    private final OrderDetailsActivity mView;
    private final SessionBO mSessionBO;

    public OrderDetailsActivityPresenter(OrderDetailsActivity view) {
        this.mView = view;
        this.mSessionBO = new SessionBO();
    }

    public void setOrderOnGoing(Order order){
        mSessionBO.setOrderOnGoing(order);
    }
}
