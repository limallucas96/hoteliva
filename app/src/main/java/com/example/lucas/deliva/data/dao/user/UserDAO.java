package com.example.lucas.deliva.data.dao.user;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.data.dao.PersistenceException;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.remote.WebService;
import com.example.lucas.deliva.data.remote.WebServiceClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class UserDAO {
    private static final String TAG = UserDAO.class.getName();

    private final WebService mWebService;

    public UserDAO() {
        mWebService = new WebServiceClient().getService();
    }

    public User login(@NonNull final String username, @NonNull final String password) throws PersistenceException {

        try {
            WebService webService = new WebServiceClient().getService();
            Call<User> wsCall = webService.login(username, password);
            Response<User> response = wsCall.execute();

            if (response.isSuccessful()) {
                return response.body();
            } else {
                String errorMessage = "Webservice Error";
                throw new PersistenceException(errorMessage);
            }

        } catch (IOException e) {
            String errorMessage = "IOException could not login " + e.getMessage();
            throw new PersistenceException(errorMessage);
        }
    }
}
