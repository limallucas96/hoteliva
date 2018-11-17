package com.example.lucas.deliva.presentation.order.view;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.data.model.Balance;
import com.example.lucas.deliva.data.model.mock.Purchase;
import com.example.lucas.deliva.presentation.base.view.BaseView;

import java.util.List;

public interface OrderProfileFragmentView extends BaseView {

    void onSuccessGetUserWallet(@NonNull List<Purchase> purchaseList);

    void onErrorGetUserWallet();

    void onSuccessGetUserBalance(@NonNull List<Balance> result);

    void onErrorGetUserBalance();

}
