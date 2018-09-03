package com.example.lucas.deliva.presentation.base.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity implements BaseView{

    private static final String TAG = BaseActivity.class.getSimpleName();

    @LayoutRes
    public abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showGenericError() {

    }

    @Override
    public void showConnectionError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProgressDialog(@NonNull String message) {

    }

    @Override
    public void dismissProgressDialog() {

    }
}
