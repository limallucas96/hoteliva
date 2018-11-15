package com.example.lucas.deliva.presentation.splash.presenter;

import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.splash.view.SplashActivity;

public class SplashPresenter extends BasePresenter {

    private final SplashActivity mView;
    private final SessionBO mSessionBO;

    public SplashPresenter(SplashActivity view) {
        this.mView = view;
        mSessionBO = new SessionBO();
    }

    public User getUser() {
        return mSessionBO.getUser();
    }

    public void removeOrder(){
        mSessionBO.removeOrder();
    }

}
