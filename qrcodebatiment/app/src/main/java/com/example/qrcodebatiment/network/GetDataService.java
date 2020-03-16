package com.example.qrcodebatiment.network;


import com.example.qrcodebatiment.models.MXAsset;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("index.php")
    Call<MXAsset> getInfoBatiment(
            @Query("q") String batiment
    );

}