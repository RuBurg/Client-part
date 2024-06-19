package com.example.myapplication.retrofit;

import com.example.myapplication.DB.clientModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface clientAPI {
    @GET("/client/get-all")
    Call<List<clientModel>> getAllclients();

    @POST("/client/save")
    Call<clientModel> save(@Body clientModel client);
}
