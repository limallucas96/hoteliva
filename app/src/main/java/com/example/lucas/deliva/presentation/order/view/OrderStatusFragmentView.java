package com.example.lucas.deliva.presentation.order.view;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.data.model.Balance;
import com.example.lucas.deliva.data.model.mock.OrderStatus;

import java.util.List;

public interface OrderStatusFragmentView {

    void onSuccessGetOrderStatusList(@NonNull List<Balance> result);

    void onErrorGetOrderStatusList();

}
