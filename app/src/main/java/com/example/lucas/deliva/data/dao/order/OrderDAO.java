package com.example.lucas.deliva.data.dao.order;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.data.dao.PersistenceException;
import com.example.lucas.deliva.data.model.mock.Order;
import com.example.lucas.deliva.data.remote.WebService;
import com.example.lucas.deliva.data.remote.WebServiceClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class OrderDAO {

    private static final String TAG = OrderDAO.class.getName();

    private final WebService mWebService;

    public OrderDAO() {
        mWebService = new WebServiceClient().getService();
    }

    public Boolean createOrder(@NonNull Order order) throws PersistenceException {
        try {
            WebService webService = new WebServiceClient().getService();
            Call<Boolean> wsCall = webService.createOrder(order);
            Response<Boolean> response = wsCall.execute();

            if (response.isSuccessful()) {
                return response.body();
            } else {
                String errorMessage = "Webservice Error";
                throw new PersistenceException(errorMessage);
            }

        } catch (IOException e) {
            String errorMessage = "IOException could not create order" + e.getMessage();
            throw new PersistenceException(errorMessage);
        }
    }

}
