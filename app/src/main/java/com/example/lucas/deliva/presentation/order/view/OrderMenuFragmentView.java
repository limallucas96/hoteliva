package com.example.lucas.deliva.presentation.order.view;

import com.example.lucas.deliva.data.model.mock.Menu;
import com.example.lucas.deliva.presentation.base.view.BaseView;

import java.util.List;

public interface OrderMenuFragmentView extends BaseView {

    void onSuccessGetMenuList(List<Menu> result);

    void onErrorGetMenuList();
}
