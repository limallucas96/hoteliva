package com.example.lucas.deliva.presentation.login.presenter;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.R;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.controller.user.UserController;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.type.CountryType;
import com.example.lucas.deliva.mechanism.connection.locale.LocaleManager;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;
import com.example.lucas.deliva.presentation.login.view.LoginView;

public class LoginPresenter extends BasePresenter {

    private final LoginView mView;
    private final UserController mUserController;
    private final SessionBO mSessionBO;

    public LoginPresenter(LoginView view) {
        mView = view;
        mUserController = new UserController();
        mSessionBO = new SessionBO();
    }

    public User login(@NonNull final String email,
                      @NonNull final String password) {
        mView.showProgress();
        mUserController.login(email, password, new ControllerListener<User>() {
            @Override
            public void onSuccess(@NonNull User result) {
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

    public void setUser(User user) {
        mSessionBO.setUser(user);
    }

    public Integer getLocaleFlag() {
        CountryType country = CountryType.fromString(LocaleManager.getLocale());
        switch (country) {
            case BRAZIL:
                return R.drawable.ic_brazil;
            case UNITED_STATES:
                return R.drawable.ic_usa;
            default:
                return R.drawable.ic_brazil;
        }
    }

    public Integer getLocaleFlag(CountryType countryType) {
        switch (countryType) {
            case BRAZIL:
                return R.drawable.ic_brazil;
            case UNITED_STATES:
                return R.drawable.ic_usa;
            default:
                return R.drawable.ic_brazil;
        }
    }

    public void persistLanguage(@NonNull final CountryType countryType) {
        switch (countryType) {
            case BRAZIL:
                LocaleManager.persistLanguage("pt", countryType.getValue());
                break;
            case UNITED_STATES:
                LocaleManager.persistLanguage("en", countryType.getValue());
                break;
            default:
                LocaleManager.persistLanguage("pt", countryType.getValue());
                break;
        }
        LocaleManager.setLocale(AppApplication.getAppContext());
        mView.restartActivity();
    }


}
