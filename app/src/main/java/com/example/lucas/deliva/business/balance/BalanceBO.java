package com.example.lucas.deliva.business.balance;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.connection.ConnectionBO;
import com.example.lucas.deliva.data.dao.balance.BalanceDAO;
import com.example.lucas.deliva.data.model.Balance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceBO {

    private static final String TAG = BalanceBO.class.getName();

    private final BalanceDAO mBalanceDAO;
    private final ConnectionBO mConnectionBO;

    public BalanceBO() {
        mBalanceDAO = new BalanceDAO();
        mConnectionBO = new ConnectionBO();
    }

    public List<Balance> getUserBalance(@NonNull String idResident) throws BusinessException {
        mConnectionBO.assertInternetConnection();
        List<Balance> balance = new ArrayList<>();
        try {
            HashMap<String, Balance> gson = mBalanceDAO.getUserBalance(idResident);
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
                            balanceReturn.getValue().getValue()));
                }
                return balance;
            } else {
                throw new BusinessException(BusinessErrorCode.GENERIC_ERROR);
            }
        } catch (Exception exception) {
            String errorMessage = "Generic balance error " + exception.getMessage();
            Log.e(TAG, errorMessage);
            throw new BusinessException(errorMessage, BusinessErrorCode.GENERIC_ERROR);
        }
    }

}
