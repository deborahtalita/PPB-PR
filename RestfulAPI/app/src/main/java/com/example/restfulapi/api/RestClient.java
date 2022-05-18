package com.example.restfulapi.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    // TODO menginisiasi MainInterface
    private static MainInterface service;
    private static Retrofit retrofit;

    public static MainInterface getService() {

        if (service == null) {
            // Membuat base URL
            String BASE_URL = "https://reqres.in/";

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.client(httpClient.build()).build();

            service = retrofit.create(MainInterface.class);
        }
        return service;
    }

    public static Retrofit retrofit(){
        return retrofit;
    }
}
