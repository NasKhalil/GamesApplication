package com.k2thend.gamesapplication.retrofit;

import com.k2thend.gamesapplication.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //GET Method
    @GET("/v2/5de8d38a3100000f006b1479")
    Call<ApiResponse> getGames();
}
