package com.example.lucas.deliva.presentation.order.presenter;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.controller.balance.BalanceController;
import com.example.lucas.deliva.data.model.Balance;
import com.example.lucas.deliva.data.model.mock.Purchase;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderProfileFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderProfileFragmentPresenter extends BasePresenter {

    private OrderProfileFragment mView;
    private final BalanceController mController;

    public OrderProfileFragmentPresenter(OrderProfileFragment view) {
        this.mView = view;
        mController = new BalanceController();
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

    public void getUserWallet() {

        List<Purchase> mPurchaseList = new ArrayList<>();
        mPurchaseList.add(new Purchase(123, "12/10/2018", 0, 120.00));
        mPurchaseList.add(new Purchase(454, "12/10/2018", 1, 80.00));
        mPurchaseList.add(new Purchase(543, "02/10/2018", 1, 90.00));
        mPurchaseList.add(new Purchase(454, "28/08/2018", 0, 113.00));
        mPurchaseList.add(new Purchase(847, "15/09/2018", 1, 105.00));
        mPurchaseList.add(new Purchase(847, "15/09/2018", 0, 105.00));
        mPurchaseList.add(new Purchase(847, "15/09/2018", 0, 105.00));
        mPurchaseList.add(new Purchase(847, "15/09/2018", 1, 105.00));
        mPurchaseList.add(new Purchase(847, "15/09/2018", 0, 105.00));
        mPurchaseList.add(new Purchase(847, "15/09/2018", 0, 105.00));
        mPurchaseList.add(new Purchase(847, "15/09/2018", 0, 105.00));

        if (mPurchaseList != null) {
            mView.onSuccessGetUserWallet(mPurchaseList);
        } else {
            mView.onErrorGetUserWallet();
        }

    }
}
