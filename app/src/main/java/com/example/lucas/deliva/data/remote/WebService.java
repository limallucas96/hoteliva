package com.example.lucas.deliva.data.remote;

import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.UserReturn;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebService {

    @POST("api_login")
    Call<UserReturn> login(@Body User user);

}
