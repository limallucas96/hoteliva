package com.example.lucas.deliva.data.dao.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.BuildConfig;
import com.example.lucas.deliva.data.model.mock.Order;
import com.google.gson.Gson;

public class SessionDAO {

    private static final String TAG = SessionDAO.class.getName();

    private final static String PREF_NAME = "DelivaPreferences";

    private final static String KEY_ORDER_ON_GOING = "KEY_ORDER_ON_GOING";

    private final SharedPreferences mSharedPreferences;
    private final Gson mGson;

    public SessionDAO() {
        mSharedPreferences = AppApplication.getAppContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mGson = new Gson();
    }

    public void setOrderOnGoing(Order order) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_ORDER_ON_GOING, mGson.toJson(order));
        editor.apply();
    }

    @Nullable
    public Order getValuationOnGoing() {
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



}
