package com.example.qrcodebatiment.network;


import com.example.qrcodebatiment.MainActivity;
import com.example.qrcodebatiment.models.Breakfast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("simple.xml")
    Call<Breakfast> getInfoBatiment(
            @Query("numbatiment") String batiment
    );

    @GET("simple.xml")
    Call<Breakfast> getInfoBatiment();
}