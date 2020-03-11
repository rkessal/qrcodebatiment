package com.example.qrcodebatiment.network;

import android.util.Base64;

import com.example.qrcodebatiment.models.Asset;
import com.example.qrcodebatiment.models.Asset$$TypeAdapter;
import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class RetrofitClientInstance {

    private static final String BASE_URL = "http://maximo.grandbesancon.fr/maxrest/rest/os/";
    private static Retrofit retrofit;
    private static OkHttpClient httpClient;
    //private OkHttpClient.Builder httpClient  = new OkHttpClient.Builder();
    private static String username = "scetic2";
    private static String password = "c69d63";





    public static Retrofit getRetrofitInstance() {


        if (retrofit == null) {

            if (username != null && password != null) {
                // Concatenate username and password with colon for authentication
                final String credentials = username + ":" + password;

                final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.DEFAULT);
                httpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request original = chain.request();

                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Authorization", basic.trim());
                        requestBuilder.addHeader("Accept", "application/xml");
                        requestBuilder.method(original.method(), original.body());


                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                }).build();
            }


            TikXml tik = new TikXml.Builder()
                    .exceptionOnUnreadXml(false).build();

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(TikXmlConverterFactory.create(tik))
                    .client(httpClient)
                    .build();
        }
        return retrofit;
    }

}
