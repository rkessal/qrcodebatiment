package com.example.qrcodebatiment.network;


import com.example.qrcodebatiment.models.MXAsset;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("mxasset")
    Call<MXAsset> getInfoBatiment(
            @Query("assetnum") String batiment
    );

}