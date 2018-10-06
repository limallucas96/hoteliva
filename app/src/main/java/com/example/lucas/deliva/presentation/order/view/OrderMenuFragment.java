package com.example.lucas.deliva.presentation.order.view;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.base.view.BaseFragment;
import com.example.lucas.deliva.presentation.order.presenter.OrderMenuFragmentPresenter;

public class OrderMenuFragment extends BaseFragment<OrderMenuFragmentPresenter> {

//    @BindView(R.id.toolbar)
//    protected Toolbar mToolbar;
//
//    @BindView(R.id.title)
//    protected TextView mTitle;


    @NonNull
    @Override
    protected OrderMenuFragmentPresenter createPresenter(@NonNull Context context) {
        return new OrderMenuFragmentPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_menu;
    }
}

