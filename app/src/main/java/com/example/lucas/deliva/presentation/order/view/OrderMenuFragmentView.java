package com.example.lucas.deliva.presentation.order.view;

import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.presentation.base.view.BaseView;

import java.util.HashMap;
import java.util.List;

public interface OrderMenuFragmentView extends BaseView {

    void onErrorGetMenuList();

    void onSuccessGetMenuList(List<Menu> result);

}
