package com.example.lucas.deliva.data.remote;

import com.example.lucas.deliva.data.model.Balance;
import com.example.lucas.deliva.data.model.CartReturn;
import com.example.lucas.deliva.data.model.MenuReturn;
import com.example.lucas.deliva.data.model.User;
import com.example.lucas.deliva.data.model.Order;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WebService {

    @FormUrlEncoded
    @POST("/api_login")
    Call<User> login(@Field("username") String username, @Field("pwd") String pwd);

    @POST("api_service")
    Call<HashMap<String, MenuReturn>> getMenuList();

    @FormUrlEncoded
    @POST("outstanding_balance")
    Call<HashMap<String, Balance>> getUserBalance(@Field("id_resident") String idResident);

    @FormUrlEncoded
    @POST("service_status")
    Call<HashMap<String, Balance>> getOrderStatus(@Field("id_resident") String idResident,
                                                  @Field("id_room") String idRoom);

    @POST("/insert_order")
    Call<CartReturn> createOrder(@Body Order order);

}
