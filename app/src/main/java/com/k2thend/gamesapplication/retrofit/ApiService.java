package com.k2thend.gamesapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    //instance
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
