package com.example.lucas.deliva.presentation.order.presenter;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.controller.menu.MenuController;
import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.data.model.Order;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderMenuFragment;

import java.util.List;

public class OrderMenuFragmentPresenter extends BasePresenter {

    private final OrderMenuFragment mView;
    private final SessionBO mSessionBO;
    private final MenuController mMenuController;

    public OrderMenuFragmentPresenter(OrderMenuFragment view) {
        this.mView = view;
        this.mSessionBO = new SessionBO();
        this.mMenuController = new MenuController();
    }

    public Order getOrder() {
        return mSessionBO.getOrder();
    }

    public void saveOrder(Order order) {
        mSessionBO.setOrderOnGoing(order);
    }

    public void getMenuList() {
        mMenuController.getMenuList(new ControllerListener<List<Menu>>() {
            @Override
            public void onSuccess(@NonNull List<Menu> result) {
                mView.onSuccessGetMenuList(result);
            }

            @Override
            public void onError(@NonNull BusinessException errorCode) {
                mView.onErrorGetMenuList();
            }
        });
    }

}
