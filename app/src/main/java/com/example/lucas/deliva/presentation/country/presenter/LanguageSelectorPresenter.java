package com.example.lucas.deliva.presentation.country.presenter;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.mechanism.connection.locale.LocaleManager;
import com.example.lucas.deliva.presentation.base.presenter.BasePresenter;

public class LanguageSelectorPresenter extends BasePresenter {

    public LanguageSelectorPresenter() {
    }

    public void persistLanguage(@NonNull final String language, @NonNull final String locale) {
        LocaleManager.persistLanguage(language, locale);
        LocaleManager.setLocale(AppApplication.getAppContext());
    }
}
