package com.example.lucas.deliva.data.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceClient {

    private WebService mService;
    static final String BASE_URL = "http://localhost:5000/";


    public WebServiceClient() {
        String uri = BASE_URL;
        Gson gson = new GsonBuilder().setLenient().create();
        mService = WebServiceClient.createWebService(uri, gson);
    }

    private static WebService createWebService(@NonNull final String uri,
                                               @Nullable Gson gson) {

        // Create retrofit access
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(uri)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(WebService.class);

    }

    public WebService getService() {
        return mService;
    }
}
