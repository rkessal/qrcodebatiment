package com.example.qrcodebatiment.network;

import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import retrofit2.Retrofit;

public class RetrofitClientInstance {

    private static final String BASE_URL = "https://www.w3schools.com/xml/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(TikXmlConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
