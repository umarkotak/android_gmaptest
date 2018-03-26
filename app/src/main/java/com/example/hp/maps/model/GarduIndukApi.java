package com.example.hp.maps.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 26/03/18.
 */

public interface GarduIndukApi {
    @GET("/map")
    Call<List<GarduInduk>> getAllGarduInduk();
}
