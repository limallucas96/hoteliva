package com.example.lucas.deliva.business.connection;

import android.content.Context;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.mechanism.connection.NetworkUtils;
import com.example.lucas.deliva.presentation.AppApplication;

public class ConnectionBO {

    private static final String TAG = ConnectionBO.class.getSimpleName();

    public void assertInternetConnection() throws BusinessException {

        // Retrieve application context and ensure context retrieve is valid
        Context applicationContext = AppApplication.getContext();
        if (applicationContext == null) {
            String errorMessage = "Received invalid application context";
            Log.e(TAG, errorMessage);
            throw new BusinessException(errorMessage, BusinessErrorCode.GENERIC_ERROR);
        }

        // Test Internet connection before consult WS
        if (!NetworkUtils.isNetworkAvailable(applicationContext)) {
            String errorMessage = "Internet connection unavailable";
            Log.e(TAG, errorMessage);
            throw new BusinessException(errorMessage, BusinessErrorCode.INTERNET_CONNECTION_UNAVAILABLE);
        }
    }
}
