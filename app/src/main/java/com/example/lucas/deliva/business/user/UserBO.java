package com.example.lucas.deliva.business.user;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.connection.ConnectionBO;
import com.example.lucas.deliva.data.dao.PersistenceException;
import com.example.lucas.deliva.data.dao.user.UserDAO;
import com.example.lucas.deliva.data.model.UserReturn;

import java.io.IOException;

public class UserBO {

    private static final String TAG = UserBO.class.getName();

    private final UserDAO mUserDAO;
    private final ConnectionBO mConnectionBO;

    public UserBO() {
        mConnectionBO = new ConnectionBO();
        mUserDAO = new UserDAO();
    }

    public UserReturn login(@NonNull final String email, @NonNull final String password) throws BusinessException {
        mConnectionBO.assertInternetConnection();
        try {
            UserReturn gson = mUserDAO.login(email, password);
            if (gson != null) {
                return gson;
            } else {
                throw new BusinessException(BusinessErrorCode.GENERIC_ERROR);
            }
        } catch (Exception exception) {
            String errorMessage = "Generic login error " + exception.getMessage();
            Log.e(TAG, errorMessage);
            throw new BusinessException(errorMessage, BusinessErrorCode.GENERIC_ERROR);
        }
    }
}
