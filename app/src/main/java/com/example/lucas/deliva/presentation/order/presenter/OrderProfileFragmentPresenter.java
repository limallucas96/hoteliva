package com.example.lucas.deliva.presentation.order.presenter;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.controller.balance.BalanceController;
import com.example.lucas.deliva.controller.user.UserController;
import com.example.lucas.deliva.data.model.Balance;
import com.example.lucas.deliva.data.model.mock.Purchase;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderProfileFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderProfileFragmentPresenter extends BasePresenter {

    private OrderProfileFragment mView;
    private final BalanceController mController;
    private final SessionBO mSessionBO;

    public OrderProfileFragmentPresenter(OrderProfileFragment view) {
        this.mView = view;
        mController = new BalanceController();
        mSessionBO = new SessionBO();
    }


    public void getUserBalance(@NonNull String idResident) {

        mController.getUserBalance(idResident, new ControllerListener<List<Balance>>() {
            @Override
            public void onSuccess(@NonNull List<Balance> result) {
                if (result != null && !result.isEmpty()) {
                    mView.onSuccessGetUserBalance(result);
                }
            }

            @Override
            public void onError(@NonNull BusinessException errorCode) {

            }
        });
    }

    public Integer getUserId() {
        if (mSessionBO.getUser() != null && mSessionBO.getUser().getUserId() != null) {
            return mSessionBO.getUser().getUserId();
        } else {
            return null;
        }
    }

}
