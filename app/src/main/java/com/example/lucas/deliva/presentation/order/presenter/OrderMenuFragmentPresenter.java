package com.example.lucas.deliva.presentation.order.presenter;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.controller.menu.MenuController;
import com.example.lucas.deliva.data.model.mock.Menu;
import com.example.lucas.deliva.data.model.mock.Order;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.order.view.OrderMenuFragment;

import java.util.ArrayList;
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
        List<Menu> mMenuList = new ArrayList<>();
        mMenuList.add(new Menu(1, "Korean", "Barbecue", 19.90, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu(2, "Lucas", "Lima", 19.99, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu(3, "Bruno", "Silva", 9.99, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu(4, "Sergio", "Furgeri", 10.00, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu(5, "ADS", "6 Semestre", 6.66, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu(6, "TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO ", "TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO ", 6.66, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));
        mMenuList.add(new Menu(7, "ADS", "6 Semestre", 6.66, "https://static.tumblr.com/90b30b74c5d4c98ab35024137993f1b0/mty6lgy/CDZn599q2/tumblr_static_tumblr_static_705cmutimq880c4gkwssckkc8_640.jpg"));

        if (mMenuList != null) {
            mView.onSuccessGetMenuList(mMenuList);
        } else {
            mView.onErrorGetMenuList();
        }
    }

    public void getMenuList2() {
        mMenuController.getMenuList(new ControllerListener<List<com.example.lucas.deliva.data.model.Menu>>() {
            @Override
            public void onSuccess(@NonNull List<com.example.lucas.deliva.data.model.Menu> result) {
                mView.onSuccessGetMenuList2(result);
            }

            @Override
            public void onError(@NonNull BusinessException errorCode) {
                mView.onErrorGetMenuList();
            }
        });
    }

}
