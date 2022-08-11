package com.example.splashscreenapp.retrofit_data;

import com.example.splashscreenapp.retrofit_data.RetrofilApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    public static final String URL_BASE = "http://10.0.2.2/proyecto/";

    public static RetrofilApiService getApiService(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(RetrofilApiService.class);
    }
}
