package com.example.lucas.deliva.presentation.splash.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.lucas.deliva.presentation.splash.presenter.SplashActivityPresenter;

import com.example.lucas.deliva.presentation.login.view.LoginActivity;
import com.example.lucas.deliva.R;


public class SplashActivity extends Activity implements SplashActivityPresenter{

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
