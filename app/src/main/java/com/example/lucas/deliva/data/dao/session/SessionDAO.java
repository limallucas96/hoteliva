package com.example.lucas.deliva.data.dao.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.BuildConfig;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.UserReturn;
import com.example.lucas.deliva.data.model.mock.Order;
import com.google.gson.Gson;

public class SessionDAO {

    private static final String TAG = SessionDAO.class.getName();

    private final static String PREF_NAME = "DelivaPreferences";

    private final static String KEY_ORDER_ON_GOING = "KEY_ORDER_ON_GOING";
    private final static String KEY_USER = "KEY_USER";
    private final static String KEY_USER_LOGGED_IN = "KEY_USER_LOGGED_IN";

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
    public void setUser(UserReturn user) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_USER, mGson.toJson(user));
        editor.apply();
    }

    @Nullable
    public UserReturn getUser() {
        String jsonValuation = mSharedPreferences.getString(KEY_USER, null);
        if (jsonValuation != null) {
            return mGson.fromJson(jsonValuation, UserReturn.class);
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

    public void setLoggedUser(UserReturn user) {
        updateUser(user);
        updateLoggedIn(true);
    }

    private void updateUser(@NonNull final UserReturn user) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_USER, mGson.toJson(user));
        editor.apply();
    }
//END USER DAO

}
