package com.example.lucas.deliva.data.dao.status;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.data.dao.PersistenceException;
import com.example.lucas.deliva.data.model.Balance;
import com.example.lucas.deliva.data.remote.WebService;
import com.example.lucas.deliva.data.remote.WebServiceClient;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response;

public class StatusDAO {

    private static final String TAG = StatusDAO.class.getName();

    private final WebService mWebService;

    public StatusDAO() {
        mWebService = new WebServiceClient().getService();
    }

    public HashMap<String, Balance> getOrderStatus(@NonNull String idResident,
                                                   @NonNull String idRoom) throws PersistenceException {
        try {
            WebService webService = new WebServiceClient().getService();
            Call<HashMap<String, Balance>> wsCall = webService.getOrderStatus(idResident, idRoom);
            Response<HashMap<String, Balance>> response = wsCall.execute();

            if (response.isSuccessful()) {
                return response.body();
            } else {
                String errorMessage = "Webservice Error";
                throw new PersistenceException(errorMessage);
            }

        } catch (IOException e) {
            String errorMessage = "IOException could not get order status" + e.getMessage();
            throw new PersistenceException(errorMessage);
        }
    }

}
