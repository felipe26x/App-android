package com.example.splashscreenapp.retrofit_data;

import com.example.splashscreenapp.model.ItemList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofilApiService {
    @GET("getItemsDB.php")
    Call<List<ItemList>> getItemsDB();



}
