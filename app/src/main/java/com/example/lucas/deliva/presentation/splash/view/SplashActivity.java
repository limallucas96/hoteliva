package com.example.lucas.deliva.presentation.splash.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.example.lucas.deliva.data.model.UserReturn;
import com.example.lucas.deliva.presentation.base.view.BaseActivity;

import com.example.lucas.deliva.presentation.login.view.LoginActivity;
import com.example.lucas.deliva.R;
import com.example.lucas.deliva.presentation.order.view.OrderActivityActivity;
import com.example.lucas.deliva.presentation.splash.presenter.SplashPresenter;


public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashActivityView {

    private static int SPLASH_TIME_OUT = 3000;

    @NonNull
    @Override
    protected SplashPresenter createPresenter(@NonNull Context context) {
        return new SplashPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.removeOrder();
                if(isUserLogged()){
                    startOrderActivity();
                }else{
                    startLoginActivity();
                }
            }
        }, SPLASH_TIME_OUT);
    }

    private Boolean isUserLogged() {
        UserReturn user = mPresenter.getUser();
        if (user != null) {
            if (user.getLogged())
                return true;
            else
                return false;
        }
        return false;
    }

    private void startLoginActivity(){
        Intent i = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void startOrderActivity(){
        //TODO - Pass bundle data to order activity if it contains data from ws
        Intent i = new Intent(SplashActivity.this, OrderActivityActivity.class);
        startActivity(i);
        finish();
    }
}
