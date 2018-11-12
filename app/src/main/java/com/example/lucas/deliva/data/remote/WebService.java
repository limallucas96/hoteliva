package com.example.lucas.deliva.data.remote;

import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.UserReturn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WebService {

    @POST("/api_login")
    Call<UserReturn> login(@Body User user);

    @POST("api_service")
    Call<List<Menu>> getMenuList();

}
