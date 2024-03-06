package com.example.applisae;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import java.util.concurrent.TimeUnit;


public class GetAPI {
    private static final String BASE_URL = "http://10.3.122.100:8080"; // Remplace avec l'URL de ton API
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).build())
                    .build();
        }
        return retrofit;
    }
    public static ApiService getApiService() {
        return getClient().create(ApiService.class);
    }
}
