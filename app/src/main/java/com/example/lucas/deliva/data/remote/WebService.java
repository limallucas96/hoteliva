package com.example.lucas.deliva.data.remote;

import com.example.lucas.deliva.data.model.MenuReturn;
import com.example.lucas.deliva.data.model.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WebService {

    @FormUrlEncoded
    @POST("/api_login")
    Call<User> login(@Field("username") String username, @Field("pwd") String pwd);

    @POST("api_service")
    Call<HashMap<String, MenuReturn>> getMenuList();

}
