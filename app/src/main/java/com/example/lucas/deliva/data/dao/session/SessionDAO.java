package com.example.lucas.deliva.data.dao.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.mock.Order;
import com.google.gson.Gson;

public class SessionDAO {

    private static final String TAG = SessionDAO.class.getName();

    private final static String PREF_NAME = "DelivaPreferences";

    private final static String KEY_ORDER_ON_GOING = "KEY_ORDER_ON_GOING";
    private final static String KEY_USER = "KEY_USER";
    private final static String KEY_USER_LOGGED_IN = "KEY_USER_LOGGED_IN";
    private static final String KEY_LANGUAGE = "KEY_LANGUAGE";
    private static final String KEY_LOCALE = "KEY_LOCALE";

    private final SharedPreferences mSharedPreferences;
    private final Gson mGson;

    public SessionDAO() {
        mSharedPreferences = AppApplication.getAppContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mGson = new Gson();
    }


    //    BEGIN ORDER DAO
    public void setOrderOnGoing(Order order) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_ORDER_ON_GOING, mGson.toJson(order));
        editor.apply();
    }

    @Nullable
    public Order getOrderOnGoing() {
        String jsonValuation = mSharedPreferences.getString(KEY_ORDER_ON_GOING, null);
        if (jsonValuation != null) {
            return mGson.fromJson(jsonValuation, Order.class);
        }

        return null;
    }

    public void removeOrder() {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.remove(KEY_ORDER_ON_GOING);
        editor.apply();
    }
    //    END ORDER DAO

    //    BEGIN USER DAO
    public void setUser(User user) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_USER, mGson.toJson(user));
        editor.apply();
    }

    @Nullable
    public User getUser() {
        String jsonValuation = mSharedPreferences.getString(KEY_USER, null);
        if (jsonValuation != null) {
            return mGson.fromJson(jsonValuation, User.class);
        }

        return null;
    }

    private void updateLoggedIn(final boolean isLoggedIn) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(KEY_USER_LOGGED_IN, isLoggedIn);
        editor.apply();
    }

    public boolean isLogged() {
        return mSharedPreferences.getBoolean(KEY_USER_LOGGED_IN, false);
    }

    public void setLoggedUser(User user) {
        updateUser(user);
        updateLoggedIn(true);
    }

    private void updateUser(@NonNull final User user) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_USER, mGson.toJson(user));
        editor.apply();
    }

    public void logoutUser() {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    //END USER DAO

    //BEGIN LOCALE
    public void setLanguage(@NonNull final String language) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_LANGUAGE, language);
        editor.apply();
    }

    public String getLanguage() {
        return mSharedPreferences.getString(KEY_LANGUAGE, "pt");
    }

    public void setLocale(@NonNull final String locale) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_LOCALE, locale);
        editor.apply();
    }

    public String getLocale() {
        return mSharedPreferences.getString(KEY_LOCALE, "BR");
    }
    //END LOCALE

}
