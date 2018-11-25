package com.example.lucas.deliva.presentation.cart.presenter;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.controller.order.OrderController;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.Order;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.cart.view.CartActivity;

public class CartActivityPresenter extends BasePresenter {

    private final CartActivity mView;
    private final SessionBO mSessionBO;
    private final OrderController mOrderController;

    public CartActivityPresenter(CartActivity view) {
        this.mView = view;
        this.mSessionBO = new SessionBO();
        this.mOrderController = new OrderController();
    }

    public Order getOrder() {
        return mSessionBO.getOrder();
    }

    public void saveOrder(Order order) {
        mSessionBO.setOrderOnGoing(order);
    }

    public void createOrder(@NonNull Order order) {
        mView.showProgress();
        mOrderController.createOrder(order, new ControllerListener<Boolean>() {
            @Override
            public void onSuccess(@NonNull Boolean result) {
                mView.dismissProgressDialog();
                if (result) {
                    mView.onSuccessCreateOrder();
                } else {
                    mView.onErrorCreateOrder();
                }
            }

            @Override
            public void onError(@NonNull BusinessException errorCode) {
                mView.dismissProgressDialog();
                mView.onErrorCreateOrder();
            }
        });
    }

    public User getUser() {
        return mSessionBO.getUser();
    }
}
