package com.bdtask.mvvmpractice;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppConfig {

    private static String BASE_URL = "https://softest8.bdtask.com/Updatesaleserp/";
    //private static String BASE_URL = "http://192.168.43.3/saleserp/Api/";
    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
