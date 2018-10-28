package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.data.model.mock.Purchase;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderProfileFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderProfileFragmentPresenter extends BasePresenter {

    private OrderProfileFragment mView;

    public OrderProfileFragmentPresenter(OrderProfileFragment view) {
        this.mView = view;
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
