package com.example.lucas.deliva.presentation.login.presenter;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.controller.user.UserController;
import com.example.lucas.deliva.data.model.UserReturn;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.login.view.LoginView;

public class LoginPresenter extends BasePresenter {

    private final LoginView mView;
    private final UserController mUserController;

    public LoginPresenter(LoginView view) {
        mView = view;
        mUserController = new UserController();
    }

    public UserReturn login(@NonNull final String email,
                            @NonNull final String password) {
        mView.showProgressDialog("logando");
        mUserController.login(email, password, new ControllerListener<UserReturn>() {
            @Override
            public void onSuccess(@NonNull UserReturn result) {
                mView.dismissProgressDialog();
                mView.showLoginSuccess(result);
            }

            @Override
            public void onError(@NonNull BusinessException errorCode) {
                mView.dismissProgressDialog();
                mView.showLoginError();
            }
        });
        return null;
    }


}
