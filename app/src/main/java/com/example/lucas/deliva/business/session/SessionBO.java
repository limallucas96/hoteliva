package com.example.lucas.deliva.business.session;

import com.example.lucas.deliva.data.dao.session.SessionDAO;
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
}
