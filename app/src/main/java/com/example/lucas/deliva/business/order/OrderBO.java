package com.example.lucas.deliva.business.order;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.connection.ConnectionBO;
import com.example.lucas.deliva.data.dao.order.OrderDAO;
import com.example.lucas.deliva.data.model.mock.Order;

public class OrderBO {

    private static final String TAG = OrderBO.class.getName();

    private final OrderDAO mOrderDAO;
    private final ConnectionBO mConnectionBO;

    public OrderBO() {
        mOrderDAO = new OrderDAO();
        mConnectionBO = new ConnectionBO();
    }

    public Boolean createOrder(@NonNull Order order) throws BusinessException {
        mConnectionBO.assertInternetConnection();
        try {
            Boolean gson = mOrderDAO.createOrder(order);
            if (gson != null) {
                return gson;
            } else {
                throw new BusinessException(BusinessErrorCode.GENERIC_ERROR);
            }
        } catch (Exception exception) {
            String errorMessage = "Generic menu error " + exception.getMessage();
            Log.e(TAG, errorMessage);
            throw new BusinessException(errorMessage, BusinessErrorCode.GENERIC_ERROR);
        }
    }
}
