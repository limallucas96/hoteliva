package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderActivity;

public class OrderActivityPresenter extends BasePresenter {

    private final OrderActivity mView;
    private final SessionBO mSessionBO;

    public OrderActivityPresenter(OrderActivity view){
        this.mView = view;
        mSessionBO = new SessionBO();
    }

    public void logoutUser(){
        mSessionBO.logoutUser();
    }

}
