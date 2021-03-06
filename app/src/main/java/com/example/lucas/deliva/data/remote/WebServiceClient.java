package com.example.lucas.deliva.data.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.lucas.deliva.business.session.SessionBO;
import com.facebook.stetho.okhttp3.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class WebServiceClient {

    private WebService mService;
    public static String BASE_URL = "http://192.168.0.6:5000";
    private static final String CONTENT_TYPE_HEADER_NAME = "Content-Type";
    private final SessionBO mSessionBO;


    public WebServiceClient() {
        mSessionBO = new SessionBO();
        String uri = mSessionBO.getHost();
//        String uri = BASE_URL;
        Gson gson = new GsonBuilder().setLenient().create();
        mService = WebServiceClient.createWebService(uri, gson);
    }

    private static WebService createWebService(@NonNull final String uri,
                                               @Nullable Gson gson) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);
        builder.addNetworkInterceptor(new StethoInterceptor());
        builder.build();

        OkHttpClient client = builder.build();

        // Create retrofit access
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(uri)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(WebService.class);

    }

    public WebService getService() {
        return mService;
    }
}
