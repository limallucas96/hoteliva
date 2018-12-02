package com.example.lucas.deliva.presentation.cart.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.controller.order.OrderController;
import com.example.lucas.deliva.data.model.CartReturn;
import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.Order;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.cart.view.CartActivity;
import com.example.lucas.deliva.presentation.order.adapter.CartRecyleAdapter;

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
        mOrderController.createOrder(order, new ControllerListener<CartReturn>() {
            @Override
            public void onSuccess(@NonNull CartReturn result) {
                mView.dismissProgressDialog();
                if (result.getStatus()) {
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

    public void setOrderOnGoing(Order orderOnGoing) {
        mSessionBO.setOrderOnGoing(orderOnGoing);
    }

//    public void removeSingleOrder(Menu menu, Order order, CartRecyleAdapter cartAdapter, RecyclerView recyclerView) {
//        mView.showProgress();
//        if (order != null) {
//            if (order.getMenuList() != null && !order.getMenuList().isEmpty()) {
//                for (Menu itemToRemove : order.getMenuList()) {
//                    if (itemToRemove.getId().equals(menu.getId())) {
//                        order.getMenuList().remove(itemToRemove);
//                        break;
//                    }
//                }
//            }
//        }
//        if (order != null) {
//            if (order.getMenuList() != null && !order.getMenuList().isEmpty()) {
//                cartAdapter.setData(order.getMenuList());
//            }
//        }
//        cartAdapter.notifyDataSetChanged();
//        recyclerView.removeAllViewsInLayout();
//        mView.dismissProgressDialog();
//    }
}
