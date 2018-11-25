package com.example.lucas.deliva.presentation.order.presenter;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.controller.status.StatusController;
import com.example.lucas.deliva.data.model.Balance;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderStatusFragment;

import java.util.List;

public class OrderStatusFragmentPresenter extends BasePresenter {

    private final OrderStatusFragment mView;
    private final StatusController mController;
    private final SessionBO mSessionBO;

    public OrderStatusFragmentPresenter(OrderStatusFragment view) {
        mView = view;
        mController = new StatusController();
        mSessionBO = new SessionBO();
    }

    public void getOrderStatus(@NonNull String idResident, @NonNull String idRoom) {
        mController.getOrderStatus(idResident, idRoom, new ControllerListener<List<Balance>>() {
            @Override
            public void onSuccess(@NonNull List<Balance> result) {
                mView.onSuccessGetOrderStatusList(result);
            }

            @Override
            public void onError(@NonNull BusinessException errorCode) {
                mView.onErrorGetOrderStatusList();
            }
        });
    }

    public User getUser() {
        return mSessionBO.getUser();
    }
}
