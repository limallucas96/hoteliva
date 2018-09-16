package com.example.lucas.deliva.data.dao.user;

import android.support.annotation.NonNull;

import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.UserReturn;
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

    private UserReturn login(@NonNull final String username, @NonNull final String password) {

        User user = new User(username, password);
        try{
            WebService webService = new WebServiceClient().getService();
            Call<UserReturn> wsCall = webService.login(user);
            Response<UserReturn> response = wsCall.execute();

            if(response.isSuccessful()){
                return response.body();
            }

        }catch (IOException e){
            String errorMessage = "IOException could not login " + e.getMessage();
            throw new PersistenceException(errorMessage);
        }

    }

}
