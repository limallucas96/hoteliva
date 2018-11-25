package com.example.lucas.deliva.business.status;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.connection.ConnectionBO;
import com.example.lucas.deliva.business.session.SessionBO;
import com.example.lucas.deliva.data.dao.status.StatusDAO;
import com.example.lucas.deliva.data.model.Balance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusBO {

    private static final String TAG = StatusBO.class.getName();

    private final StatusDAO mStatusDAO;
    private final ConnectionBO mConnectionBO;
    private final SessionBO mSessionBO;

    public StatusBO() {
        mStatusDAO = new StatusDAO();
        mConnectionBO = new ConnectionBO();
        mSessionBO = new SessionBO();
    }

    public List<Balance> getOrderStatus(@NonNull String idResident,
                                        @NonNull String idRoom) throws BusinessException {
        mConnectionBO.assertInternetConnection();
        List<Balance> balance = new ArrayList<>();
        try {
            HashMap<String, Balance> gson = mStatusDAO.getOrderStatus(idResident, idRoom);
            if (gson != null && !gson.isEmpty()) {
                for (Map.Entry<String, Balance> balanceReturn : gson.entrySet()) {
                    String orderId = balanceReturn.getKey();
                    balance.add(new Balance(
                            orderId,
                            balanceReturn.getValue().getDate(),
                            balanceReturn.getValue().getDescription(),
                            balanceReturn.getValue().getIdService(),
                            balanceReturn.getValue().getName(),
                            balanceReturn.getValue().getAmount(),
                            balanceReturn.getValue().getStatus(),
                            balanceReturn.getValue().getTotalValue(),
                            balanceReturn.getValue().getValue(),
                            mSessionBO.getUser().getRoomNumber()));
                }
                return balance;
            } else {
                throw new BusinessException(BusinessErrorCode.GENERIC_ERROR);
            }
        } catch (Exception exception) {
            String errorMessage = "Generic get order status error " + exception.getMessage();
            Log.e(TAG, errorMessage);
            throw new BusinessException(errorMessage, BusinessErrorCode.GENERIC_ERROR);
        }
    }
}
