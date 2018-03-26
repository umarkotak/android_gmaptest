package com.example.hp.maps.network;

import com.example.hp.maps.model.GarduIndukApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 26/03/18.
 */

public class GarduIndukClient {
    private final String BASE_URL = "http://192.168.0.107:3000";
    private Retrofit retrofit;
    private GarduIndukApi garduIndukApi;

    public GarduIndukClient() {
        getClient();
    }

    public GarduIndukApi getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        garduIndukApi = retrofit.create(GarduIndukApi.class);
        return garduIndukApi;
    }
}
