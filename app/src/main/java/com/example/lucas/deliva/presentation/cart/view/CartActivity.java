package com.example.lucas.deliva.presentation.cart.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;
import com.example.lucas.deliva.presentation.cart.presenter.CartActivityPresenter;

public class CartActivity extends BaseActivity<CartActivityPresenter> implements CartActivityView {

    @NonNull
    @Override
    protected CartActivityPresenter createPresenter(@NonNull Context context) {
        return new CartActivityPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cart;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
