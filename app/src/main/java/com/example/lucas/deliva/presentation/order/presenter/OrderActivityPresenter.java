package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.data.model.UserReturn;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderActivityActivity;

public class OrderActivityPresenter extends BasePresenter {

    private final OrderActivityActivity mView;
    private final SessionBO mSessionBO;

    public OrderActivityPresenter(OrderActivityActivity view){
        this.mView = view;
        mSessionBO = new SessionBO();
    }

    public void logoutUser(){
        mSessionBO.logoutUser();
    }

    public UserReturn getUser() {
        return mSessionBO.getUser();
    }

}
