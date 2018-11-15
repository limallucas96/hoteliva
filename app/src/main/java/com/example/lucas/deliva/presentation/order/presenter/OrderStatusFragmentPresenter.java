package com.example.lucas.deliva.presentation.order.presenter;

import com.example.lucas.deliva.data.model.mock.OrderStatus;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderStatusFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusFragmentPresenter extends BasePresenter {

    private final OrderStatusFragment mView;

    public OrderStatusFragmentPresenter(OrderStatusFragment view) {
        mView = view;
    }

//    public void getOrderStatusList() {
//        List<OrderStatus> mOrderStatus = new ArrayList<>();
//
//        mOrderStatus.add(new OrderStatus(1, null, "https://img00.deviantart.net/5c51/i/2015/225/3/e/naruto_uzumaki___minimalist_by_triasfak-d95i7r9.png", 0, "0"));
//        mOrderStatus.add(new OrderStatus(2, null, "https://img00.deviantart.net/5c51/i/2015/225/3/e/naruto_uzumaki___minimalist_by_triasfak-d95i7r9.png", 0, "1"));
//        mOrderStatus.add(new OrderStatus(3, null, "http://s3.envato.com/files/253203724/DSC_2352111.jpg", 1, "1"));
//        mOrderStatus.add(new OrderStatus(4, null, "http://s3.envato.com/files/253203724/DSC_2352111.jpg", 1, "2"));
//        mOrderStatus.add(new OrderStatus(5, null, "http://s3.envato.com/files/253203724/DSC_2352111.jpg", 1, "1"));
//        mOrderStatus.add(new OrderStatus(6, null, "http://s3.envato.com/files/253203724/DSC_2352111.jpg", 2, "1"));
//        mOrderStatus.add(new OrderStatus(7, null, "http://s3.envato.com/files/253203724/DSC_2352111.jpg", 2, "2"));
//
//        if (mOrderStatus != null) {
//            mView.onSuccessGetOrderStatusList(mOrderStatus);
//        } else {
//            mView.onErrorGetOrderStatusList();
//        }
//    }
}
