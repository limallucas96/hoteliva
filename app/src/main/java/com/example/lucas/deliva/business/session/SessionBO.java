package com.example.lucas.deliva.business.session;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.data.dao.session.SessionDAO;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.mock.Order;

public class SessionBO {

    private static final String TAG = SessionBO.class.getName();

    private final SessionDAO mSessionDAO;

    public SessionBO() {
        mSessionDAO = new SessionDAO();
    }

    public void setOrderOnGoing(Order order) {
        mSessionDAO.setOrderOnGoing(order);
    }

    public Order getOrder() {
        return mSessionDAO.getOrderOnGoing();
    }

    public void removeOrder() {
        mSessionDAO.removeOrder();
    }

    public void setUser(User user) {
        mSessionDAO.setUser(user);
    }

    public User getUser(){
       return mSessionDAO.getUser();
    }

    public void logoutUser(){
        mSessionDAO.logoutUser();
    }

    public void setLanguage(@NonNull final String language) {
        mSessionDAO.setLanguage(language);
    }

    public String getLanguage() {
        return mSessionDAO.getLanguage();
    }

    public void setLocale(@NonNull final String locale) {
        mSessionDAO.setLocale(locale);
    }

    public String getLocale() {
        return mSessionDAO.getLocale();
    }
}
