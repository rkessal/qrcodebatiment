package com.example.qrcodebatiment.network;


import com.example.qrcodebatiment.models.Breakfast;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("simple.xml")
    Call<Breakfast> getInfoBatiment();
}